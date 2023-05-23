package com.infamous.infamous_legends.events;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;
import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.PlayerPortalGuardWreckingBall;
import com.infamous.infamous_legends.items.PortalGuardFlailItem;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = InfamousLegends.MOD_ID, bus = Bus.FORGE)
public class PortalGuardFlailAutoReturnEvent {

	public static Random random = new Random();
	
	@SubscribeEvent
    public static void returnPortalGuardFlail(PlayerTickEvent event) {
		if (!event.player.level.isClientSide) {
			List<ItemStack> itemStacks = Lists.newArrayList(event.player.getInventory().items);
			if (itemStacks != null) {
				itemStacks.add(event.player.getOffhandItem());
				for (ItemStack stack : itemStacks) {
					if (stack.getItem() instanceof PortalGuardFlailItem && PortalGuardFlailItem.isShooting(stack)) {
						Entity wreckingBall = event.player.level.getEntity(PortalGuardFlailItem.getWreckingBallID(stack));
						if (wreckingBall == null || (wreckingBall != null && !(wreckingBall instanceof PlayerPortalGuardWreckingBall)) || (wreckingBall != null && wreckingBall instanceof PlayerPortalGuardWreckingBall && ((PlayerPortalGuardWreckingBall)wreckingBall).getOwner() != event.player)) {
							event.player.getCooldowns().addCooldown(stack.getItem(), 100);
							PortalGuardFlailItem.setShooting(stack, false);	
							break;
						}
					}
				}
			}
		}
	}
}
