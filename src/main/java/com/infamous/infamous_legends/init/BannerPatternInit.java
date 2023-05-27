package com.infamous.infamous_legends.init;

import com.infamous.infamous_legends.InfamousLegends;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BannerPattern;

public class BannerPatternInit {
	   public static final ResourceKey<BannerPattern> BASTION = create("bastion");
	   public static final ResourceKey<BannerPattern> HUNT = create("hunt");
	   public static final ResourceKey<BannerPattern> SPORE = create("spore");

	   private static ResourceKey<BannerPattern> create(String pName) {
	      return ResourceKey.create(Registry.BANNER_PATTERN_REGISTRY, new ResourceLocation(InfamousLegends.MOD_ID, pName));
	   }

	   public static void bootstrap() {
	      Registry.register(Registry.BANNER_PATTERN, BASTION, new BannerPattern("bastion"));
	      Registry.register(Registry.BANNER_PATTERN, HUNT, new BannerPattern("hunt"));
	      Registry.register(Registry.BANNER_PATTERN, SPORE, new BannerPattern("spore"));
	   }
}
