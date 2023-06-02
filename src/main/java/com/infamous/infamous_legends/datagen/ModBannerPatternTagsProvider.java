package com.infamous.infamous_legends.datagen;

import com.infamous.infamous_legends.init.BannerPatternInit;
import com.infamous.infamous_legends.init.TagInit;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.infamous.infamous_legends.InfamousLegends.MOD_ID;

public class ModBannerPatternTagsProvider extends TagsProvider<BannerPattern> {

    public ModBannerPatternTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, Registry.BANNER_PATTERN, MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(TagInit.BannerPatterns.BASTION_PATTERN).add(BannerPatternInit.BASTION_PATTERN.get());
        tag(TagInit.BannerPatterns.HUNT_PATTERN).add(BannerPatternInit.HUNT_PATTERN.get());
        tag(TagInit.BannerPatterns.SPORE_PATTERN).add(BannerPatternInit.SPORE_PATTERN.get());
    }
}
