package com.infamous.infamous_legends.events;

import java.util.Random;
import java.util.UUID;

import org.jetbrains.annotations.NotNull;

import com.google.common.collect.ImmutableMultimap;
import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.capabilities.MobHorde;
import com.infamous.infamous_legends.capabilities.MobHordeProvider;
import com.infamous.infamous_legends.init.DamageSourceInit;
import com.infamous.infamous_legends.init.HordeTypeInit;
import com.infamous.infamous_legends.init.ItemInit;
import com.infamous.infamous_legends.init.MobHordeIdentityInit;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.init.SoundEventInit;
import com.infamous.infamous_legends.items.PigmadilloShellItem;
import com.infamous.infamous_legends.models.PiglinBombModel;
import com.infamous.infamous_legends.models.armor.PigmadilloShellRollingModel;
import com.infamous.infamous_legends.network.Messages;
import com.infamous.infamous_legends.network.message.ServerToClientHordeSyncPacket;
import com.infamous.infamous_legends.utils.MiscUtils;
import com.infamous.infamous_legends.utils.PositionUtils;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.ViewportEvent.ComputeCameraAngles;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingConversionEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = InfamousLegends.MOD_ID, bus = Bus.FORGE)
public class PigmadilloShellEvents {

	   private static final UUID STEP_HEIGHT_MODIFIER_ROLLING_UUID = UUID.fromString("85d490b6-b5ed-4362-bc09-2a72c3c5147a");
	   private static final AttributeModifier STEP_HEIGHT_MODIFIER_ROLLING = new AttributeModifier(STEP_HEIGHT_MODIFIER_ROLLING_UUID, "Rolling step height addition", 0.5F, AttributeModifier.Operation.ADDITION);
	   
	public static Random random = new Random();
	
	@SubscribeEvent
    public static void roll(PlayerTickEvent event) {
		AttributeInstance attributeinstance = event.player.getAttribute(ForgeMod.STEP_HEIGHT_ADDITION.get());
		boolean rolling = false;
		if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ItemInit.PIGMADILLO_SHELL.get()) {
			if (!event.player.getCooldowns().isOnCooldown(ItemInit.PIGMADILLO_SHELL.get()) && event.player.isCrouching() && !event.player.isOnGround()) {
				event.player.level.playSound((Player)null, event.player.getX(), event.player.getY(), event.player.getZ(), SoundEventInit.PIGMADILLO_ROLL_FOLEY.get(), SoundSource.NEUTRAL, 1F, 1);
				event.player.getCooldowns().addCooldown(ItemInit.PIGMADILLO_SHELL.get(), 360);
				PigmadilloShellItem.setRollDegrees(event.player.getItemBySlot(EquipmentSlot.CHEST), event.player.getYHeadRot());
				event.player.getItemBySlot(EquipmentSlot.CHEST).hurtAndBreak(3, event.player, (p_43414_) -> {
					p_43414_.broadcastBreakEvent(EquipmentSlot.CHEST);
				});
			}
			if (event.player.getCooldowns().getCooldownPercent(ItemInit.PIGMADILLO_SHELL.get(), 0) >= 0.84) {
				for (LivingEntity entity : event.player.level.getNearbyEntities(LivingEntity.class, TargetingConditions.forCombat(), event.player, event.player.getBoundingBox().inflate(0.5))) {
					if (entity != event.player) {
						entity.hurt(DamageSource.mobAttack(event.player), 10);
						double d0 = entity.getX() - event.player.getX();
						double d1 = entity.getZ() - event.player.getZ();
						double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
						entity.push(d0 / d2 * 1.0D, 0.3D, d1 / d2 * 1.0D);
						MiscUtils.disableShield(entity, 40);
					}
				}
				
	            rolling = true;
				ShakeCameraEvent.shake(event.player.level, 20, 0.001F, event.player.blockPosition(), 5);
				event.player.level.addParticle(ParticleTypeInit.DUST.get(), event.player.getX(), event.player.getY(), event.player.getZ(), 0, 0, 0);
				event.player.setPose(Pose.SWIMMING);
				event.player.setDeltaMovement(event.player.getDeltaMovement().add(PositionUtils.getOffsetMotion(event.player, 0, 0, event.player.isOnGround() ? 0.125 : 0.05, PigmadilloShellItem.getRollDegrees(event.player.getItemBySlot(EquipmentSlot.CHEST)))));
				if (!attributeinstance.hasModifier(STEP_HEIGHT_MODIFIER_ROLLING)) {
		            attributeinstance.addTransientModifier(STEP_HEIGHT_MODIFIER_ROLLING);
		         }
			}
		}
		if (!rolling) {
			attributeinstance.removeModifier(STEP_HEIGHT_MODIFIER_ROLLING);
		}
    }
	
	@SubscribeEvent
    public static void lowerDamage(LivingDamageEvent event) {
		if (event.getEntity() instanceof Player && event.getEntity().getItemBySlot(EquipmentSlot.CHEST).getItem() == ItemInit.PIGMADILLO_SHELL.get() && ((Player)event.getEntity()).getCooldowns().getCooldownPercent(ItemInit.PIGMADILLO_SHELL.get(), 0) >= 0.84) {
			Entity entity = event.getSource().getDirectEntity();
			if (entity instanceof AbstractArrow) {
				event.setCanceled(true);
			} else {
				if (event.getSource() != DamageSource.OUT_OF_WORLD) {
					event.setAmount(event.getAmount() / 2);
				}
			}
		}
    }
	
	@SubscribeEvent
    public static void renderRollingShell(RenderPlayerEvent event) {
		if (event.getEntity().getCooldowns().getCooldownPercent(ItemInit.PIGMADILLO_SHELL.get(), 0) >= 0.84 && event.getEntity().getItemBySlot(EquipmentSlot.CHEST).getItem() == ItemInit.PIGMADILLO_SHELL.get()) {
			event.getPoseStack().pushPose();
			
			PigmadilloShellRollingModel model = new PigmadilloShellRollingModel(Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayerInit.PIGMADILLO_SHELL_ROLLING));
			
			model.shell.xRot = SineWaveAnimationUtils.getTick(event.getEntity().tickCount, true) * 750;
			
			event.getPoseStack().mulPose(Vector3f.YP.rotationDegrees(-PigmadilloShellItem.getRollDegrees(event.getEntity().getItemBySlot(EquipmentSlot.CHEST))));
			event.getPoseStack().translate(0, -0.5, 0);
		      
			RenderType RENDER_TYPE = RenderType.entityTranslucent(new ResourceLocation(InfamousLegends.MOD_ID, "textures/armor/pigmadillo_shell.png"));
		    VertexConsumer vertexconsumer = event.getMultiBufferSource().getBuffer(RENDER_TYPE);
		    model.renderToBuffer(event.getPoseStack(), vertexconsumer, event.getPackedLight(), OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		    
		    event.getPoseStack().popPose();
		    
			event.getPoseStack().scale(0, 0, 0);
		}
    }
	
	@SubscribeEvent
    public static void rollCamera(ComputeCameraAngles event) {
		if (Minecraft.getInstance().options.getCameraType().isFirstPerson() && event.getCamera().getEntity() instanceof Player && ((Player)event.getCamera().getEntity()).getItemBySlot(EquipmentSlot.CHEST).getItem() == ItemInit.PIGMADILLO_SHELL.get() && ((Player)event.getCamera().getEntity()).getCooldowns().getCooldownPercent(ItemInit.PIGMADILLO_SHELL.get(), 0) >= 0.84) {
			event.setYaw(PigmadilloShellItem.getRollDegrees(((Player)event.getCamera().getEntity()).getItemBySlot(EquipmentSlot.CHEST)));
			event.setPitch(SineWaveAnimationUtils.getTick(event.getCamera().getEntity().tickCount, false) * 750);
		}
    }
}
