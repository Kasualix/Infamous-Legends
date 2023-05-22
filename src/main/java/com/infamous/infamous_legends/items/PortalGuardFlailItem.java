package com.infamous.infamous_legends.items;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.infamous.infamous_legends.entities.PlayerPortalGuardWreckingBall;
import com.infamous.infamous_legends.entities.ThrownBlazeRod;
import com.infamous.infamous_legends.init.SoundEventInit;
import com.infamous.infamous_legends.utils.MiscUtils;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class PortalGuardFlailItem extends Item implements Vanishable {

	private final Multimap<Attribute, AttributeModifier> defaultModifiers;
	
	private static final String TAG_SHOOTING = "Shooting";
	
	private static final String TAG_WRECKING_BALL_ID = "WreckingBallID";
	
	public PortalGuardFlailItem(Properties pProperties) {
		super(pProperties);
		ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 6.0D,
				AttributeModifier.Operation.ADDITION));
		builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier",
				-0.9F, AttributeModifier.Operation.MULTIPLY_TOTAL));
		builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier",
				-0.015F, AttributeModifier.Operation.ADDITION));
		this.defaultModifiers = builder.build();
	}
	
	   public static boolean isShooting(ItemStack stack) {
		      CompoundTag compoundtag = stack.getTag();
		      return compoundtag != null && compoundtag.getBoolean(TAG_SHOOTING);
		   }

		   public static void setShooting(ItemStack stack, boolean pIsCharged) {
		      CompoundTag compoundtag = stack.getOrCreateTag();
		      compoundtag.putBoolean(TAG_SHOOTING, pIsCharged);
		   }
			   
			   public static int getWreckingBallID(ItemStack stack) {
				      CompoundTag compoundtag = stack.getTag();
				      return compoundtag != null ? compoundtag.getInt(TAG_WRECKING_BALL_ID) : 0;
				   }

				   public static void setWreckingBallID(ItemStack stack, int pIsCharged) {
				      CompoundTag compoundtag = stack.getOrCreateTag();
				      compoundtag.putInt(TAG_WRECKING_BALL_ID, pIsCharged);
				   }
		   
		   /**
		    * Returns the action that specifies what animation to play when the item is being used.
		    */
		   public UseAnim getUseAnimation(ItemStack pStack) {
		      return UseAnim.BOW;
		   }

		   /**
		    * How long it takes to use or consume an item
		    */
		   public int getUseDuration(ItemStack pStack) {
		      return 72000;
		   }

		   public void releaseUsing(ItemStack stack, Level level, LivingEntity user, int usingFor) {
				if (user instanceof Player player) {
					int i = 72000 - usingFor;
					if (i >= 20) {
						if (!level.isClientSide) {
							PortalGuardFlailItem.setShooting(stack, true);
							PlayerPortalGuardWreckingBall wreckingBall = new PlayerPortalGuardWreckingBall(level, player);
							wreckingBall.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.25F,
									4F);

							level.addFreshEntity(wreckingBall);
							PortalGuardFlailItem.setWreckingBallID(stack, wreckingBall.getId());
							level.playSound((Player) null, wreckingBall, SoundEventInit.PORTAL_GUARD_SHOOT.get(),
									SoundSource.PLAYERS, 1.0F, MiscUtils.randomSoundPitch());
							
							if (!player.getAbilities().instabuild) {
								stack.hurtAndBreak(1, user, (p_43414_) -> {
									p_43414_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
								});
							}
						}

						player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
					}
				}
			}

			public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
				ItemStack itemstack = player.getItemInHand(hand);
				if (PortalGuardFlailItem.isShooting(itemstack)) {
					return InteractionResultHolder.fail(itemstack);
				} else {
					player.startUsingItem(hand);
					return InteractionResultHolder.consume(itemstack);
				}
			}
			
			   /**
			    * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
			    * the damage on the stack.
			    */
			   public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
			      pStack.hurtAndBreak(2, pAttacker, (p_43414_) -> {
			         p_43414_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
			      });
			      return true;
			   }

			   /**
			    * Called when a {@link net.minecraft.world.level.block.Block} is destroyed using this Item. Return {@code true} to
			    * trigger the "Use Item" statistic.
			    */
			   public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
			      if ((double)pState.getDestroySpeed(pLevel, pPos) != 0.0D) {
			         pStack.hurtAndBreak(1, pEntityLiving, (p_43385_) -> {
			            p_43385_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
			         });
			      }

			      return true;
			   }

			   /**
			    * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
			    */
			   public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
			      return pEquipmentSlot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(pEquipmentSlot);
			   }
}
