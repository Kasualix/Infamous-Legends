package com.infamous.infamous_legends.events;

import java.util.Random;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.init.BlockInit;
import com.infamous.infamous_legends.init.ItemInit;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = InfamousLegends.MOD_ID, bus = Bus.FORGE)
public class ReturnCaseOfCreationAfterCraftingEvent {

	public static Random random = new Random();
	
	@SubscribeEvent
    public static void returnCaseOfCreation(ItemCraftedEvent event) {
		 if (event.getCrafting().getItem() instanceof BlockItem && ((BlockItem)event.getCrafting().getItem()).getBlock() == BlockInit.LEGENDS_SPAWNER_BLOCK.get()) {
			 if (event.getEntity().getInventory().add(new ItemStack(ItemInit.EMPTY_CASE_OF_CREATION.get()))) {
				 
			 } else {
				 event.getEntity().drop(new ItemStack(ItemInit.EMPTY_CASE_OF_CREATION.get()), true);
			 }
		 }
    }
}
