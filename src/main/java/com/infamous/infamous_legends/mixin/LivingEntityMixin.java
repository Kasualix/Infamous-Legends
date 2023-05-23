package com.infamous.infamous_legends.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.infamous.infamous_legends.entities.RegalTiger;
import com.infamous.infamous_legends.init.ItemInit;
import com.mojang.authlib.GameProfile;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.ProfilePublicKey;
import net.minecraft.world.level.Level;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {


	public LivingEntityMixin(EntityType<?> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Inject(at = @At("HEAD"), method = "canAttack", cancellable = true)
	public void infamous_legends_creepersCantAttackRegalTigers(LivingEntity target, CallbackInfoReturnable<Boolean> callback) {
		if (this.getType() == EntityType.CREEPER && target instanceof RegalTiger) {
			callback.setReturnValue(false);
		}
	}
}
