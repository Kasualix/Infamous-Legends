package com.infamous.infamous_legends.init;

import java.util.List;

import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraftforge.registries.ForgeRegistries;

public class FoodInit {
	public static RandomSource random = RandomSource.create();
	
	   public static final FoodProperties SPORKCHOP = (new FoodProperties.Builder()).nutrition(10).meat().saturationMod(0.8F).effect(() -> {
		   List<MobEffect> effects = ForgeRegistries.MOB_EFFECTS.tags().getTag(TagInit.Effects.SPORKCHOP_EFFECTS).stream().toList();
		   return new MobEffectInstance(effects.size() > 0 ? effects.get(random.nextInt(effects.size())) : MobEffects.POISON, 200, 0);
	   }, 1.0F).build();
}
