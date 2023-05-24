package com.infamous.infamous_legends.init;

import static com.infamous.infamous_legends.init.ItemInit.registerBlockItem;
import static com.infamous.infamous_legends.itemgroups.InfamousLegendsBlocksItemGroup.INFAMOUS_LEGENDS_BLOCKS;

import java.util.function.Supplier;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.blocks.BigBeakEggBlock;
import com.infamous.infamous_legends.blocks.FungusBombBlock;
import com.infamous.infamous_legends.blocks.LegendsSpawnerBlock;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
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

    private static RegistryObject<Block> registerBlock(String id, Supplier<Block> sup) {
        RegistryObject<Block> blockRegistryObject = BLOCKS.register(id, sup);
        registerBlockItem(id, blockRegistryObject, blockSupplier -> new BlockItem(blockSupplier.get(), new Item.Properties().tab(INFAMOUS_LEGENDS_BLOCKS)));
        return blockRegistryObject;
    }


    public static void initRenderTypes(){
        ItemBlockRenderTypes.setRenderLayer(LEGENDS_SPAWNER_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(FUNGUS_BOMB.get(), RenderType.cutout());
    }

}
