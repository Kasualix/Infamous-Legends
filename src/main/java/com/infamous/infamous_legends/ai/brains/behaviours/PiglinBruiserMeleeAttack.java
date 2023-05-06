package com.infamous.infamous_legends.ai.brains.behaviours;

import com.google.common.collect.ImmutableMap;
import com.infamous.infamous_legends.entities.PiglinBruiser;
import com.infamous.infamous_legends.init.SoundEventInit;
import com.infamous.infamous_legends.utils.MiscUtils;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ProjectileWeaponItem;

public class PiglinBruiserMeleeAttack extends Behavior<PiglinBruiser> {
   private final int cooldownBetweenAttacks;

   public PiglinBruiserMeleeAttack(int p_23512_) {
      super(ImmutableMap.of(MemoryModuleType.LOOK_TARGET, MemoryStatus.REGISTERED, MemoryModuleType.ATTACK_TARGET, MemoryStatus.VALUE_PRESENT, MemoryModuleType.ATTACK_COOLING_DOWN, MemoryStatus.VALUE_ABSENT), 600, 600);
      this.cooldownBetweenAttacks = p_23512_;
   }

   protected boolean checkExtraStartConditions(ServerLevel level, PiglinBruiser mob) {
      LivingEntity livingentity = this.getAttackTarget(mob);
      return !this.isHoldingUsableProjectileWeapon(mob) && mob.hasLineOfSight(livingentity) && mob.distanceTo(livingentity) <= 2;
   }

   private boolean isHoldingUsableProjectileWeapon(PiglinBruiser p_23528_) {
      return p_23528_.isHolding((p_147697_) -> {
         Item item = p_147697_.getItem();
         return item instanceof ProjectileWeaponItem && p_23528_.canFireProjectileWeapon((ProjectileWeaponItem)item);
      });
   }

   protected void start(ServerLevel p_23524_, PiglinBruiser p_23525_, long p_23526_) {
      LivingEntity livingentity = this.getAttackTarget(p_23525_);
      p_23525_.lookAt(Anchor.EYES, livingentity.position());
      p_23525_.getNavigation().stop();
		
      if (MiscUtils.randomPercent(40)) {
    	  p_23525_.playSound(SoundEventInit.PIGLIN_BRUISER_ATTACK_START_VOCAL.get(), 1, p_23525_.getVoicePitch());
          p_23525_.attackAnimationTick = p_23525_.attackAnimationLength;
          p_23524_.broadcastEntityEvent(p_23525_, (byte) 4);
      } else {
    	  p_23525_.playSound(SoundEventInit.PIGLIN_BRUISER_SPIN_ATTACK_VOCAL.get(), 1, p_23525_.getVoicePitch());
          p_23525_.spinAnimationTick = p_23525_.spinAnimationLength;
          p_23524_.broadcastEntityEvent(p_23525_, (byte) 11);
      }
   }
   
   @Override
	protected void tick(ServerLevel p_22551_, PiglinBruiser p_22552_, long p_22553_) {
		super.tick(p_22551_, p_22552_, p_22553_);
		
		LivingEntity livingentity = this.getAttackTarget(p_22552_);
		
		if (livingentity != null) {
			p_22552_.lookAt(Anchor.EYES, livingentity.position());
		}
		
		p_22552_.getNavigation().stop();
		
		if (p_22552_.attackAnimationTick == p_22552_.attackAnimationLength - 2) {
			p_22552_.playSound(SoundEventInit.PIGLIN_BRUISER_ATTACK.get(), 1, 1);
		}
		
		if (p_22552_.attackAnimationTick == p_22552_.attackAnimationLength - 10) {
			p_22552_.playSound(SoundEventInit.PIGLIN_BRUISER_ATTACK_VOCAL.get(), 1, p_22552_.getVoicePitch());
		}
		
		if (p_22552_.spinAnimationTick == p_22552_.spinAnimationLength - 5) {
			p_22552_.playSound(SoundEventInit.PIGLIN_BRUISER_SPIN_ATTACK.get(), 1, 1);
		}
		
		if (livingentity != null && p_22552_.attackAnimationTick == p_22552_.attackAnimationActionPoint && p_22552_.distanceTo(livingentity) <= 3 && p_22552_.hasLineOfSight(livingentity)) {					
			p_22552_.doHurtTarget(livingentity);
			for (LivingEntity entity : p_22551_.getNearbyEntities(LivingEntity.class, TargetingConditions.forCombat(), p_22552_, livingentity.getBoundingBox().inflate(1, 0, 1))) {
				if (!MiscUtils.piglinAllies(p_22552_, entity) && entity != livingentity) {
					p_22552_.doHurtTarget(entity);
				}
			}
		}
		
		if (p_22552_.spinAnimationTick == p_22552_.spinAnimationActionPoint) {					
			for (LivingEntity entity : p_22551_.getNearbyEntities(LivingEntity.class, TargetingConditions.forCombat(), p_22552_, p_22552_.getBoundingBox().inflate(2.5, 0, 2.5))) {
				if (!MiscUtils.piglinAllies(p_22552_, entity)) {
					entity.hurt(DamageSource.mobAttack(p_22552_), 12);
				}
			}
		}
	}
   
   @Override
	protected boolean canStillUse(ServerLevel p_22545_, PiglinBruiser p_22546_, long p_22547_) {
		return p_22546_.attackAnimationTick > 0 || p_22546_.spinAnimationTick > 0;
	}
   
   @Override
	protected void stop(ServerLevel p_22548_, PiglinBruiser p_22549_, long p_22550_) {
		super.stop(p_22548_, p_22549_, p_22550_);
		p_22549_.getBrain().setMemoryWithExpiry(MemoryModuleType.ATTACK_COOLING_DOWN, true, (long)this.cooldownBetweenAttacks);
	}

   private LivingEntity getAttackTarget(PiglinBruiser p_23533_) {
      return p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).isPresent() ? p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).get() : null;
   }
}