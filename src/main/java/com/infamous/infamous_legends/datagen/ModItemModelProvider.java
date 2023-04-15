package com.infamous.infamous_legends.datagen;

import com.infamous.infamous_legends.init.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import static com.infamous.infamous_legends.InfamousLegends.MOD_ID;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        registerBlockItems();
    }

    private void registerBlockItems() {
        blockItemModel(BlockInit.LEGENDS_SPAWNER_BLOCK.get());
    }


    private void blockItemModel(Block block) {
        String name = ForgeRegistries.BLOCKS.getKey(block).getPath();
        getBuilder(name).parent(new ModelFile.UncheckedModelFile(modLoc(ModelProvider.BLOCK_FOLDER + "/" + name)));
    }
}
