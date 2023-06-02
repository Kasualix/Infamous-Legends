package com.infamous.infamous_legends.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.infamous.infamous_legends.InfamousLegends.MOD_ID;

public class BannerPatternInit {

	public static final DeferredRegister<BannerPattern> BANNER_PATTERNS = DeferredRegister.create(Registry.BANNER_PATTERN.key(), MOD_ID);

	public static final RegistryObject<BannerPattern> BASTION_PATTERN = registerPattern("bastion");
	public static final RegistryObject<BannerPattern> HUNT_PATTERN = registerPattern("hunt");
	public static final RegistryObject<BannerPattern> SPORE_PATTERN = registerPattern("spore");

	private static RegistryObject<BannerPattern> registerPattern(String name) {
		return BANNER_PATTERNS.register(name, () -> new BannerPattern("il:"+name));
	}
}
