package com.infamous.infamous_legends.datagen;

import static com.infamous.infamous_legends.InfamousLegends.MOD_ID;

import com.infamous.infamous_legends.init.BlockInit;

import com.infamous.infamous_legends.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        registerBlockItems();
        registerBannerPatternItems();
    }

    private void registerBlockItems() {
        blockItemModel(BlockInit.LEGENDS_SPAWNER_BLOCK.get());
    }


    private void blockItemModel(Block block) {
        String name = ForgeRegistries.BLOCKS.getKey(block).getPath();
        getBuilder(name).parent(new ModelFile.UncheckedModelFile(modLoc(ModelProvider.BLOCK_FOLDER + "/" + name)));
    }

    private void registerBannerPatternItems() {
        bannerPatternItem(ItemInit.BASTION_BANNER_PATTERN.get());
        bannerPatternItem(ItemInit.HUNT_BANNER_PATTERN.get());
        bannerPatternItem(ItemInit.SPORE_BANNER_PATTERN.get());
        bannerPatternItem(ItemInit.MACE_BANNER_PATTERN.get());
        bannerPatternItem(ItemInit.ROD_BANNER_PATTERN.get());
    }

    private void bannerPatternItem(Item bannerPattern) {
        ResourceLocation resourceLocation = ForgeRegistries.ITEMS.getKey(bannerPattern);
        generated(resourceLocation.getPath(), itemLoc(new ResourceLocation("creeper_banner_pattern")));
    }

    private void generated(String path, ResourceLocation texture) {
        getBuilder(path).parent(new ModelFile.UncheckedModelFile(mcLoc("item/generated"))).texture("layer0", texture);
    }

    private static ResourceLocation itemLoc(ResourceLocation resourceLocation) {
        return new ResourceLocation(resourceLocation.getNamespace(), ITEM_FOLDER + "/" + resourceLocation.getPath());
    }
}
