package com.infamous.infamous_legends.ai.brains.behaviours;

import com.google.common.collect.ImmutableMap;
import com.infamous.infamous_legends.entities.PortalGuard;
import com.infamous.infamous_legends.init.MemoryModuleTypeInit;
import com.infamous.infamous_legends.init.SoundEventInit;
import com.infamous.infamous_legends.utils.MiscUtils;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;

public class PortalGuardSwingAttack extends Behavior<PortalGuard> {
   private final int cooldownBetweenAttacks;

   public PortalGuardSwingAttack(int p_23512_) {
      super(ImmutableMap.of(MemoryModuleType.LOOK_TARGET, MemoryStatus.REGISTERED, MemoryModuleType.ATTACK_TARGET, MemoryStatus.VALUE_PRESENT, MemoryModuleTypeInit.SWING_COOLING_DOWN.get(), MemoryStatus.VALUE_ABSENT), 600, 600);
      this.cooldownBetweenAttacks = p_23512_;
   }

   protected boolean checkExtraStartConditions(ServerLevel level, PortalGuard mob) {
      LivingEntity livingentity = this.getAttackTarget(mob);
      return mob.hasLineOfSight(livingentity) && mob.distanceTo(livingentity) <= 5.0 && mob.attackAnimationTick <= 0 && mob.shootAnimationTick <= 0 && mob.reelInBallAnimationTick <= 0 && !mob.playingIdleShootingAnimation;
   }

   protected void start(ServerLevel p_23524_, PortalGuard p_23525_, long p_23526_) {
      LivingEntity livingentity = this.getAttackTarget(p_23525_);
      p_23525_.lookAt(Anchor.EYES, livingentity.position());
      p_23525_.getNavigation().stop();
		
      p_23525_.playSound(SoundEventInit.PORTAL_GUARD_SWING_START_VOCAL.get(), 1.5F, 1);
      
      p_23525_.swingAnimationTick = p_23525_.swingAnimationLength;
      p_23524_.broadcastEntityEvent(p_23525_, (byte) 7);
   }
   
   @Override
	protected void tick(ServerLevel p_22551_, PortalGuard p_22552_, long p_22553_) {
		super.tick(p_22551_, p_22552_, p_22553_);
		
		LivingEntity livingentity = this.getAttackTarget(p_22552_);
		
		p_22552_.getNavigation().stop();
		
		if (p_22552_.swingAnimationTick == p_22552_.swingAnimationLength - 15) {
			p_22552_.playSound(SoundEventInit.PORTAL_GUARD_SWING_START.get(), 1.5F, 1);
		}
		
		if (p_22552_.swingAnimationTick == p_22552_.swingAnimationLength - 57) {
			p_22552_.playSound(SoundEventInit.PORTAL_GUARD_SWING.get(), 1.5F, 1);
			p_22552_.playSound(SoundEventInit.PORTAL_GUARD_SWING_VOCAL.get(), 1.5F, 1);
		}
		
		if (p_22552_.swingAnimationTick == p_22552_.swingAnimationActionPoint) {					
			for (LivingEntity entity : p_22551_.getNearbyEntities(LivingEntity.class, TargetingConditions.forCombat(), p_22552_, p_22552_.getBoundingBox().inflate(6, 0, 6))) {
				if (!MiscUtils.piglinAllies(p_22552_, entity)) {
					entity.hurt(DamageSource.mobAttack(p_22552_), 20);
					MiscUtils.disableShield(((LivingEntity)entity), 200);
					if (p_22552_.distanceTo(entity) > 0.2) {
						double d0 = entity.getX() - p_22552_.getX();
						double d1 = entity.getZ() - p_22552_.getZ();
						double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
						entity.push(d0 / d2 * 2D, 0.3D, d1 / d2 * 2D);
					}
				}
			}
		}
	}
   
   @Override
	protected boolean canStillUse(ServerLevel p_22545_, PortalGuard p_22546_, long p_22547_) {
		return p_22546_.swingAnimationTick > 0;
	}
   
   @Override
	protected void stop(ServerLevel p_22548_, PortalGuard p_22549_, long p_22550_) {
		super.stop(p_22548_, p_22549_, p_22550_);
		p_22549_.getBrain().setMemoryWithExpiry(MemoryModuleTypeInit.SWING_COOLING_DOWN.get(), true, (long)this.cooldownBetweenAttacks);
	}

   private LivingEntity getAttackTarget(PortalGuard p_23533_) {
      return p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).isPresent() ? p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).get() : null;
   }
}