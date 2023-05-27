package com.infamous.infamous_legends.init;

import static com.infamous.infamous_legends.init.ItemInit.registerBlockItem;
import static com.infamous.infamous_legends.itemgroups.InfamousLegendsBlocksItemGroup.INFAMOUS_LEGENDS_BLOCKS;

import java.util.function.Supplier;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.blocks.BigBeakEggBlock;
import com.infamous.infamous_legends.blocks.FungusBombBlock;
import com.infamous.infamous_legends.blocks.LegendsSpawnerBlock;
import com.infamous.infamous_legends.blocks.PreservedMobBlock;
import com.infamous.infamous_legends.blocks.PreservedMobBlock.FreeMethod;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister
            .create(ForgeRegistries.BLOCKS, InfamousLegends.MOD_ID);

    public static final RegistryObject<Block> LEGENDS_SPAWNER_BLOCK = registerBlock("legends_spawner_block", () -> new LegendsSpawnerBlock(Block.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> BIG_BEAK_EGG = registerBlock("big_beak_egg", () -> new BigBeakEggBlock(Block.Properties.of(Material.EGG).strength(0.5F).sound(SoundType.METAL).randomTicks().noOcclusion()));
    public static final RegistryObject<Block> FUNGUS_BOMB = registerBlock("fungus_bomb", () -> new FungusBombBlock(Block.Properties.of(Material.MOSS).strength(0.3F).sound(SoundType.MOSS).noOcclusion()));
    public static final RegistryObject<LiquidBlock> TAR_BLOCK = BLOCKS.register("tar_block", () -> new LiquidBlock(FluidInit.SOURCE_TAR, Block.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));
    public static final RegistryObject<Block> PRESERVED_REGAL_TIGER = registerBlock("preserved_regal_tiger", () -> new PreservedMobBlock("infamous_legends:regal_tiger", () -> {
    	CompoundTag tag = new CompoundTag();
    	tag.putInt("Age", -24000);
    	return tag;
    }, new BlockPos(0, 2, 0), new BlockPos(-20, 10, 0), new BlockPos(7, 7, 7), FreeMethod.WASH, null, BlockBehaviour.Properties.copy(Blocks.DIRT).strength(1.5F, 3.0F).sound(SoundType.MUD)));
    public static final RegistryObject<Block> PRESERVED_BIG_BEAK_EGG = registerBlock("preserved_big_beak_egg", () -> new PreservedMobBlock("minecraft:item", () -> {
    	CompoundTag tag = new CompoundTag();
    	return tag;
    }, new BlockPos(0, 8, 1), new BlockPos(-20, -40, 0), new BlockPos(10, 10, 10), FreeMethod.MELT, "infamous_legends:big_beak_egg", BlockBehaviour.Properties.copy(Blocks.SNOW_BLOCK).strength(0.8F)));
    
    private static RegistryObject<Block> registerBlock(String id, Supplier<Block> sup) {
        RegistryObject<Block> blockRegistryObject = BLOCKS.register(id, sup);
        registerBlockItem(id, blockRegistryObject, blockSupplier -> new BlockItem(blockSupplier.get(), new Item.Properties().tab(INFAMOUS_LEGENDS_BLOCKS)));
        return blockRegistryObject;
    }


    public static void initRenderTypes(){
        ItemBlockRenderTypes.setRenderLayer(LEGENDS_SPAWNER_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(FUNGUS_BOMB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(FluidInit.SOURCE_TAR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidInit.FLOWING_TAR.get(), RenderType.translucent());
    }

}
