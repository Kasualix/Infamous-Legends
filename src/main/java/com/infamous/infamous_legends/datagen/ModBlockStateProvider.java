package com.infamous.infamous_legends.datagen;


import static com.infamous.infamous_legends.InfamousLegends.MOD_ID;

import com.infamous.infamous_legends.init.BlockInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        cubeTop(BlockInit.LEGENDS_SPAWNER_BLOCK.get());
    }

    public void cubeTop(Block block) {
        getVariantBuilder(block)
                .partialState().setModels(new ConfiguredModel(models().cubeTop(name(block), blockTexture(block), extend(blockTexture(block), "_top"))));
    }


    private ResourceLocation extend(ResourceLocation rl, String suffix) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

}