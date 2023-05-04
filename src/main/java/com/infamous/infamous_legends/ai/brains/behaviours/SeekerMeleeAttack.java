package com.infamous.infamous_legends.ai.brains.behaviours;

import com.google.common.collect.ImmutableMap;
import com.infamous.infamous_legends.entities.Seeker;
import com.infamous.infamous_legends.events.ShakeCameraEvent;
import com.infamous.infamous_legends.init.SoundEventInit;
import com.infamous.infamous_legends.utils.MiscUtils;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.level.Explosion;

public class SeekerMeleeAttack extends Behavior<Seeker> {
   private final int cooldownBetweenAttacks;

   public SeekerMeleeAttack(int p_23512_) {
      super(ImmutableMap.of(MemoryModuleType.LOOK_TARGET, MemoryStatus.REGISTERED, MemoryModuleType.ATTACK_TARGET, MemoryStatus.VALUE_PRESENT, MemoryModuleType.ATTACK_COOLING_DOWN, MemoryStatus.VALUE_ABSENT), 600, 600);
      this.cooldownBetweenAttacks = p_23512_;
   }

   protected boolean checkExtraStartConditions(ServerLevel level, Seeker mob) {
      LivingEntity livingentity = this.getAttackTarget(mob);
      return mob.hasLineOfSight(livingentity) && mob.distanceTo(livingentity) <= 2;
   }

   protected void start(ServerLevel p_23524_, Seeker p_23525_, long p_23526_) {
      LivingEntity livingentity = this.getAttackTarget(p_23525_);
      p_23525_.lookAt(Anchor.EYES, livingentity.position());
      p_23525_.getNavigation().stop();
      
      p_23525_.setDeltaMovement(0, 0.75, 0);
      
      p_23525_.playSound(SoundEventInit.SEEKER_ATTACK_VOCAL.get(), 1.5F, 1);
		
      p_23525_.attackAnimationTick = p_23525_.attackAnimationLength;
      p_23524_.broadcastEntityEvent(p_23525_, (byte) 4);
   }
   
   @Override
	protected void tick(ServerLevel p_22551_, Seeker p_22552_, long p_22553_) {
		super.tick(p_22551_, p_22552_, p_22553_);
		
		LivingEntity livingentity = this.getAttackTarget(p_22552_);
		
		if (livingentity != null) {
			p_22552_.lookAt(Anchor.EYES, livingentity.position());
		}
		
		p_22552_.getNavigation().stop();
		
		if (p_22552_.attackAnimationTick == p_22552_.attackAnimationActionPoint) {
			ShakeCameraEvent.shake(p_22551_, 40, 0.075F, p_22552_.blockPosition(), 8);
			MiscUtils.customExplosion(p_22551_, p_22552_, DamageSource.explosion(p_22552_), null, p_22552_.getX(), p_22552_.getY(),
					p_22552_.getZ(), 2.5F, false, net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(p_22551_, p_22552_) ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE, null,
					p_22552_.getSoundSource(), ParticleTypes.EXPLOSION, ParticleTypes.EXPLOSION_EMITTER, 15.0F, false);
		}
		
		if (p_22552_.attackAnimationTick == p_22552_.attackAnimationLength - 4) {
			p_22552_.playSound(SoundEventInit.SEEKER_ATTACK.get(), 1.5F, 1);
		}
		
		if (p_22552_.attackAnimationTick == 1) {
			p_22551_.broadcastEntityEvent(p_22552_, (byte)60);
			p_22552_.discard();
		}
	}
   
   @Override
	protected boolean canStillUse(ServerLevel p_22545_, Seeker p_22546_, long p_22547_) {
		return p_22546_.attackAnimationTick > 0;
	}
   
   @Override
	protected void stop(ServerLevel p_22548_, Seeker p_22549_, long p_22550_) {
		super.stop(p_22548_, p_22549_, p_22550_);
		p_22549_.getBrain().setMemoryWithExpiry(MemoryModuleType.ATTACK_COOLING_DOWN, true, (long)this.cooldownBetweenAttacks);
	}

   private LivingEntity getAttackTarget(Seeker p_23533_) {
      return p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).isPresent() ? p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).get() : null;
   }
}