package com.infamous.infamous_legends.events;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.jetbrains.annotations.NotNull;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Lists;
import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.capabilities.MobHorde;
import com.infamous.infamous_legends.capabilities.MobHordeProvider;
import com.infamous.infamous_legends.entities.PlayerPortalGuardWreckingBall;
import com.infamous.infamous_legends.init.DamageSourceInit;
import com.infamous.infamous_legends.init.HordeTypeInit;
import com.infamous.infamous_legends.init.ItemInit;
import com.infamous.infamous_legends.init.MobHordeIdentityInit;
import com.infamous.infamous_legends.init.TagInit;
import com.infamous.infamous_legends.items.PortalGuardFlailItem;
import com.infamous.infamous_legends.network.Messages;
import com.infamous.infamous_legends.network.message.ServerToClientHordeSyncPacket;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BottleItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingConversionEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = InfamousLegends.MOD_ID, bus = Bus.FORGE)
public class FillCaseOfCreationEvent {

	public static Random random = new Random();
	
	@SubscribeEvent
    public static void fillCaseOfCreation(BlockEvent.BreakEvent event) {
		if (!event.getPlayer().level.isClientSide && !event.getPlayer().getAbilities().instabuild && event.getPlayer().level.getBlockState(event.getPos()).is(TagInit.Blocks.FILLS_EMPTY_CASE_OF_CREATION)) {
			List<ItemStack> itemStacks = Lists.newArrayList(event.getPlayer().getInventory().items);
			if (itemStacks != null) {
				itemStacks.add(event.getPlayer().getOffhandItem());
				for (ItemStack stack : itemStacks) {
					if (stack.getItem() == ItemInit.EMPTY_CASE_OF_CREATION.get()) {
						if (stack == event.getPlayer().getOffhandItem()) {
							event.getPlayer().setItemInHand(InteractionHand.OFF_HAND, new ItemStack(ItemInit.LIT_CASE_OF_CREATION.get()));
						} else {
							event.getPlayer().getInventory().setItem(itemStacks.indexOf(stack), new ItemStack(ItemInit.LIT_CASE_OF_CREATION.get()));
						}
						break;
					}
				}
			}
		}
    }
}
