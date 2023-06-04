package com.infamous.infamous_legends.init;

import java.util.function.Function;
import java.util.function.Supplier;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.enums.CustomArmorMaterials;
import com.infamous.infamous_legends.itemgroups.InfamousLegendsItemsItemGroup;
import com.infamous.infamous_legends.itemgroups.InfamousLegendsMobsItemGroup;
import com.infamous.infamous_legends.items.ExplosiveFungusItem;
import com.infamous.infamous_legends.items.PiglinBombItem;
import com.infamous.infamous_legends.items.PiglinMaceItem;
import com.infamous.infamous_legends.items.PigmadilloShellItem;
import com.infamous.infamous_legends.items.PortalGuardFlailItem;
import com.infamous.infamous_legends.items.SporeMedicMaskItem;

import net.minecraft.tags.BannerPatternTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			InfamousLegends.MOD_ID);	
	
	// SPAWN EGGS
	
	public static final RegistryObject<Item> MACE_RUNT_SPAWN_EGG = ITEMS.register("mace_runt_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.MACE_RUNT, 0x4b3f34, 0xf9f3a4,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> BLAZE_RUNT_SPAWN_EGG = ITEMS.register("blaze_runt_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.BLAZE_RUNT, 0x995f40, 0xffd528,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> SPORE_MEDIC_SPAWN_EGG = ITEMS.register("spore_medic_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.SPORE_MEDIC, 0x995f40, 0xa42429,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> PIGLIN_BRUISER_SPAWN_EGG = ITEMS.register("piglin_bruiser_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.PIGLIN_BRUISER, 0x995f40, 0x3f303b,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> WAR_BOAR_SPAWN_EGG = ITEMS.register("war_boar_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.WAR_BOAR, 0x986c7c, 0xf5c650,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> PIGLIN_BUILDER_SPAWN_EGG = ITEMS.register("piglin_builder_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.PIGLIN_BUILDER, 0x4d494d, 0xffd83d,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> SEEKER_SPAWN_EGG = ITEMS.register("seeker_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.SEEKER, 0x986c7c, 0x119b85,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> SPOREBACK_SPAWN_EGG = ITEMS.register("sporeback_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.SPOREBACK, 0xe5d3c7, 0x119b85,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> LAVA_LAUNCHER_SPAWN_EGG = ITEMS.register("lava_launcher_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.LAVA_LAUNCHER, 0xe5d3c7, 0xa96f7f,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> PIGMADILLO_SPAWN_EGG = ITEMS.register("pigmadillo_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.PIGMADILLO, 0x7a4e6b, 0x532f2f,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> PORTAL_GUARD_SPAWN_EGG = ITEMS.register("portal_guard_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.PORTAL_GUARD, 0xffd83d, 0x584c2f,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> COBBLESTONE_GOLEM_SPAWN_EGG = ITEMS.register("cobblestone_golem_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.COBBLESTONE_GOLEM, 0x8b8985, 0x5f5f5c,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> PLANK_GOLEM_SPAWN_EGG = ITEMS.register("plank_golem_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.PLANK_GOLEM, 0xb8945f, 0x453f3b,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> GRINDSTONE_GOLEM_SPAWN_EGG = ITEMS.register("grindstone_golem_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.GRINDSTONE_GOLEM, 0x2f4a4b, 0x31c5b8,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> MOSSY_GOLEM_SPAWN_EGG = ITEMS.register("mossy_golem_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.MOSSY_GOLEM, 0x90919b, 0x70922d,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> FIRST_OF_STONE_SPAWN_EGG = ITEMS.register("first_of_stone_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.FIRST_OF_STONE, 0x8b8985, 0x415a1c,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> FIRST_OF_OAK_SPAWN_EGG = ITEMS.register("first_of_oak_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.FIRST_OF_OAK, 0xd7c185, 0xb99558,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> BADGER_SPAWN_EGG = ITEMS.register("badger_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.BADGER, 0x3b342b, 0xd7d4c9,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> BIG_BEAK_SPAWN_EGG = ITEMS.register("big_beak_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.BIG_BEAK, 0x27aa96, 0xd18e32,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> REGAL_TIGER_SPAWN_EGG = ITEMS.register("regal_tiger_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.REGAL_TIGER, 0xad6bbf, 0xd2cdd6,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	// WEAPONS
	
	public static final RegistryObject<Item> PIGLIN_MACE = ITEMS.register("piglin_mace",
			() -> new PiglinMaceItem(7, -3.15F, Tiers.NETHERITE,
					new Item.Properties().tab(InfamousLegendsItemsItemGroup.INFAMOUS_LEGENDS_ITEMS)));
	
	public static final RegistryObject<Item> PIGLIN_SAW = ITEMS.register("piglin_saw",
			() -> new SwordItem(Tiers.NETHERITE, 6, -3.0F,
					new Item.Properties().tab(InfamousLegendsItemsItemGroup.INFAMOUS_LEGENDS_ITEMS)));
	
	public static final RegistryObject<Item> PIGLIN_BOMB = ITEMS.register("piglin_bomb",
			() -> new PiglinBombItem(new Item.Properties().stacksTo(16).tab(InfamousLegendsItemsItemGroup.INFAMOUS_LEGENDS_ITEMS)));
	
	public static final RegistryObject<Item> EXPLOSIVE_FUNGUS = ITEMS.register("explosive_fungus",
			() -> new ExplosiveFungusItem(new Item.Properties().stacksTo(16).tab(InfamousLegendsItemsItemGroup.INFAMOUS_LEGENDS_ITEMS)));
	
	public static final RegistryObject<Item> PORTAL_GUARD_FLAIL = ITEMS.register("portal_guard_flail",
			() -> new PortalGuardFlailItem(new Item.Properties().stacksTo(1).durability(300).tab(InfamousLegendsItemsItemGroup.INFAMOUS_LEGENDS_ITEMS)));

	// ARMOUR
	
	public static final RegistryObject<Item> SPORE_MEDIC_MASK = ITEMS.register("spore_medic_mask",
			() -> new SporeMedicMaskItem(CustomArmorMaterials.SPORE_MEDIC_MASK, EquipmentSlot.HEAD, new Item.Properties().stacksTo(1).tab(InfamousLegendsItemsItemGroup.INFAMOUS_LEGENDS_ITEMS)));
	
	public static final RegistryObject<Item> PIGMADILLO_SHELL = ITEMS.register("pigmadillo_shell",
			() -> new PigmadilloShellItem(CustomArmorMaterials.PIGMADILLO_SHELL, EquipmentSlot.CHEST, new Item.Properties().stacksTo(1).tab(InfamousLegendsItemsItemGroup.INFAMOUS_LEGENDS_ITEMS)));
	
	// FOOD
	
	public static final RegistryObject<Item> SPORKCHOP = ITEMS.register("sporkchop",
			() -> new Item(new Item.Properties().food(FoodInit.SPORKCHOP).tab(InfamousLegendsItemsItemGroup.INFAMOUS_LEGENDS_ITEMS)));
	
	// MISC
	
	public static final RegistryObject<Item> TAR_BUCKET = ITEMS.register("tar_bucket",
			() -> new BucketItem(() -> FluidInit.SOURCE_TAR.get(), new Item.Properties().stacksTo(1).tab(InfamousLegendsItemsItemGroup.INFAMOUS_LEGENDS_ITEMS)));
	
	public static final RegistryObject<Item> PRIMORDIAL_HEART = ITEMS.register("primordial_heart",
			() -> new Item(new Item.Properties().stacksTo(1).tab(InfamousLegendsItemsItemGroup.INFAMOUS_LEGENDS_ITEMS)));
	
	public static final RegistryObject<Item> EMPTY_CASE_OF_CREATION = ITEMS.register("empty_case_of_creation",
			() -> new Item(new Item.Properties().stacksTo(1).tab(InfamousLegendsItemsItemGroup.INFAMOUS_LEGENDS_ITEMS)));
	
	public static final RegistryObject<Item> LIT_CASE_OF_CREATION = ITEMS.register("lit_case_of_creation",
			() -> new Item(new Item.Properties().stacksTo(1).tab(InfamousLegendsItemsItemGroup.INFAMOUS_LEGENDS_ITEMS)));
	
	public static RegistryObject<BlockItem> registerBlockItem(String id, RegistryObject<Block> block, Function<Supplier<Block>, BlockItem> itemCreatorFunction){
		return ITEMS.register(id,  () -> itemCreatorFunction.apply(block));
	}

	// PATTERNS
	public static final RegistryObject<Item> BASTION_BANNER_PATTERN = ITEMS.register("bastion_banner_pattern", () -> new BannerPatternItem(TagInit.BannerPatterns.BASTION_PATTERN, new Item.Properties().stacksTo(1).tab(InfamousLegendsItemsItemGroup.INFAMOUS_LEGENDS_ITEMS)));
	public static final RegistryObject<Item> HUNT_BANNER_PATTERN = ITEMS.register("hunt_banner_pattern", () -> new BannerPatternItem(TagInit.BannerPatterns.HUNT_PATTERN, new Item.Properties().stacksTo(1).tab(InfamousLegendsItemsItemGroup.INFAMOUS_LEGENDS_ITEMS)));
	public static final RegistryObject<Item> SPORE_BANNER_PATTERN = ITEMS.register("spore_banner_pattern", () -> new BannerPatternItem(TagInit.BannerPatterns.SPORE_PATTERN, new Item.Properties().stacksTo(1).tab(InfamousLegendsItemsItemGroup.INFAMOUS_LEGENDS_ITEMS)));
	public static final RegistryObject<Item> MACE_BANNER_PATTERN = ITEMS.register("mace_banner_pattern", () -> new BannerPatternItem(TagInit.BannerPatterns.MACE_PATTERN, new Item.Properties().stacksTo(1).tab(InfamousLegendsItemsItemGroup.INFAMOUS_LEGENDS_ITEMS)));
	public static final RegistryObject<Item> ROD_BANNER_PATTERN = ITEMS.register("rod_banner_pattern", () -> new BannerPatternItem(TagInit.BannerPatterns.ROD_PATTERN, new Item.Properties().stacksTo(1).tab(InfamousLegendsItemsItemGroup.INFAMOUS_LEGENDS_ITEMS)));



}
