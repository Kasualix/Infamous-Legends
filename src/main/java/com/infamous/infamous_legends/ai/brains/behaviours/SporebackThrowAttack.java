package com.infamous.infamous_legends.ai.brains.behaviours;

import com.google.common.collect.ImmutableMap;
import com.infamous.infamous_legends.entities.ExplosiveFungus;
import com.infamous.infamous_legends.entities.Sporeback;
import com.infamous.infamous_legends.init.ItemInit;
import com.infamous.infamous_legends.init.SoundEventInit;
import com.infamous.infamous_legends.utils.MiscUtils;
import com.infamous.infamous_legends.utils.PositionUtils;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.phys.Vec3;

public class SporebackThrowAttack extends Behavior<Sporeback> {
   private final int cooldownBetweenAttacks;

   public SporebackThrowAttack(int p_23512_) {
      super(ImmutableMap.of(MemoryModuleType.LOOK_TARGET, MemoryStatus.REGISTERED, MemoryModuleType.ATTACK_TARGET, MemoryStatus.VALUE_PRESENT, MemoryModuleType.ATTACK_COOLING_DOWN, MemoryStatus.VALUE_ABSENT), 600, 600);
      this.cooldownBetweenAttacks = p_23512_;
   }

   protected boolean checkExtraStartConditions(ServerLevel level, Sporeback mob) {
      LivingEntity livingentity = this.getAttackTarget(mob);
      return mob.isHolding(ItemInit.EXPLOSIVE_FUNGUS.get()) && mob.hasLineOfSight(livingentity) && mob.distanceTo(livingentity) <= 35;
   }

   protected void start(ServerLevel p_23524_, Sporeback p_23525_, long p_23526_) {
      LivingEntity livingentity = this.getAttackTarget(p_23525_);
      p_23525_.lookAt(Anchor.EYES, livingentity.position());
      p_23525_.getNavigation().stop();
		
      p_23525_.playSound(SoundEventInit.SPOREBACK_THROW_START.get(), 1.0F, 1);
      p_23525_.playSound(SoundEventInit.SPOREBACK_THROW_VOCAL.get(), 1.0F, 1);
	    
      p_23525_.throwAnimationTick = p_23525_.throwAnimationLength;
      p_23524_.broadcastEntityEvent(p_23525_, (byte) 4);
   }
   
   @Override
	protected void tick(ServerLevel p_22551_, Sporeback p_22552_, long p_22553_) {
		super.tick(p_22551_, p_22552_, p_22553_);
		
		LivingEntity livingentity = this.getAttackTarget(p_22552_);
		
		if (livingentity != null) {
			p_22552_.lookAt(Anchor.EYES, livingentity.position());
		}
		
		p_22552_.getNavigation().stop();

		if (livingentity != null && p_22552_.throwAnimationTick == p_22552_.throwAnimationActionPoint) {
			ExplosiveFungus fungus = new ExplosiveFungus(p_22551_, p_22552_);
			Vec3 fungusPos = PositionUtils.getOffsetPos(p_22552_, 1, 1, -0.5, p_22552_.yBodyRot);
			Vec3 vec3 = livingentity.getDeltaMovement();
			double d0 = livingentity.getX() + vec3.x - fungusPos.x;
			double d1 = livingentity.getEyeY() - (double) 1.1F - fungusPos.y;
			double d2 = livingentity.getZ() + vec3.z - fungusPos.z;
			double d3 = Math.sqrt(d0 * d0 + d2 * d2);
			fungus.setXRot(fungus.getXRot() - -80.0F);
			fungus.moveTo(fungusPos);
			double yMultiplier = p_22552_.distanceTo(livingentity) <= 14 ? 0.2 : 0.7;
			fungus.shoot(d0 * 0.8, d1 + d3 * yMultiplier, d2 * 0.8, 1F, 8.0F);
		    p_22552_.playSound(SoundEventInit.SPOREBACK_THROW.get(), 1.0F, MiscUtils.randomSoundPitch());
		    p_22552_.playSound(SoundEventInit.SPOREBACK_THROW_PROJECTILE.get(), 1.5F, MiscUtils.randomSoundPitch());
		    p_22551_.addFreshEntity(fungus);
		}
		
		if (p_22552_.throwAnimationTick == p_22552_.throwAnimationLength - 30) {
			p_22552_.playSound(SoundEventInit.SPOREBACK_THROW_STOP_VOCAL.get(), 1.0F, 1);
		}
		
		if (p_22552_.throwAnimationTick == p_22552_.throwAnimationLength - 44) {
			p_22552_.playSound(SoundEventInit.SPOREBACK_THROW_STOP.get(), 1.0F, 1);
		}
	}
   
   @Override
	protected boolean canStillUse(ServerLevel p_22545_, Sporeback p_22546_, long p_22547_) {
		return p_22546_.throwAnimationTick > 0;
	}
   
   @Override
	protected void stop(ServerLevel p_22548_, Sporeback p_22549_, long p_22550_) {
		super.stop(p_22548_, p_22549_, p_22550_);
		p_22549_.getBrain().setMemoryWithExpiry(MemoryModuleType.ATTACK_COOLING_DOWN, true, (long)this.cooldownBetweenAttacks);
	}

   private LivingEntity getAttackTarget(Sporeback p_23533_) {
      return p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).isPresent() ? p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).get() : null;
   }
}