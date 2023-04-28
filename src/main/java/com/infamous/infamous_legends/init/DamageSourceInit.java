package com.infamous.infamous_legends.init;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class DamageSourceInit {

	static Random rand = new Random();

	public static final DamageSource NETHERSPORES = new DamageSource("netherspores").bypassArmor();
	
}
