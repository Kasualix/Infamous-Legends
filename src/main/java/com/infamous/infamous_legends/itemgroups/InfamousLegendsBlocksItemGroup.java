package com.infamous.infamous_legends.itemgroups;

import com.infamous.infamous_legends.InfamousLegends;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.ForgeRegistries;

public class InfamousLegendsBlocksItemGroup extends CreativeModeTab {
	
	public static final InfamousLegendsBlocksItemGroup INFAMOUS_LEGENDS_BLOCKS = new InfamousLegendsBlocksItemGroup(CreativeModeTab.TABS.length, "infamous_legends_blocks");

	public InfamousLegendsBlocksItemGroup(int p_i1853_1_, String p_i1853_2_) {
		super(p_i1853_1_, p_i1853_2_);
	}

	@Override
	public ItemStack makeIcon() {
		Item defaultItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(InfamousLegends.MOD_ID, "legends_spawner_block"));
		return defaultItem != null ? new ItemStack(defaultItem) : new ItemStack(Items.SPAWNER);
	}

}
