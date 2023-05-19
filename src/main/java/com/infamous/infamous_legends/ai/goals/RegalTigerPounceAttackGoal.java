package com.infamous.infamous_legends.ai.goals;

import java.util.EnumSet;

import javax.annotation.Nullable;

import com.infamous.infamous_legends.entities.RegalTiger;
import com.infamous.infamous_legends.init.SoundEventInit;
import com.infamous.infamous_legends.utils.PositionUtils;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;

public class RegalTigerPounceAttackGoal extends Goal {

		public RegalTiger mob;
		@Nullable
		public LivingEntity target;
		
		public int nextUseTime;

		public RegalTigerPounceAttackGoal(RegalTiger mob) {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP));
			this.mob = mob;
			this.target = mob.getTarget();
		}

		@Override
		public boolean isInterruptable() {
			return false;
		}

		public boolean requiresUpdateEveryTick() {
			return true;
		}

		@Override
		public boolean canUse() {
			target = mob.getTarget();
			return target != null && mob.tickCount >= this.nextUseTime && !mob.isVehicle() && !target.isRemoved() && !target.isDeadOrDying() && mob.distanceTo(target) <= 6 && animationsUseable() && mob.hasLineOfSight(target);
		}

		@Override
		public boolean canContinueToUse() {
			return !animationsUseable();
		}

		@Override
		public void start() {
			mob.attackAnimationTick = mob.attackAnimationLength;
			mob.level.broadcastEntityEvent(mob, (byte) 4);
		}

		@Override
		public void tick() {
			target = mob.getTarget();

			mob.getNavigation().stop();
			
			if (mob.attackAnimationTick > mob.attackAnimationActionPoint) {
				if (target != null) {
					mob.lookAt(Anchor.EYES, target.position());
				}
				mob.setDeltaMovement(0, mob.getDeltaMovement().y, 0);
				mob.getNavigation().stop();
			}
			
			if (mob.isOnGround() && mob.attackAnimationTick == mob.attackAnimationActionPoint) {
				mob.setDeltaMovement(mob.getDeltaMovement().add(PositionUtils.getOffsetMotion(mob, 0, 0.35, 1.6, mob.yBodyRot)));
				mob.playSound(SoundEventInit.REGAL_TIGER_ATTACK.get(), 1, mob.getVoicePitch());
				mob.playSound(SoundEventInit.REGAL_TIGER_ATTACK_START.get(), 1, mob.getVoicePitch());
			}
			
			if (mob.attackAnimationTick == mob.attackAnimationLength - 17) {
				mob.playSound(SoundEventInit.REGAL_TIGER_ATTACK_STOP.get(), 1, mob.getVoicePitch());
			}
			
			if (target != null && mob.attackAnimationTick < mob.attackAnimationActionPoint && mob.attackAnimationTick >= mob.attackAnimationLength - 17 && mob.getBoundingBox().inflate(0.1).intersects(target.getBoundingBox())) {
				target.hurt(DamageSource.mobAttack(mob), 8);
				target.hurtMarked = true;
				target.setDeltaMovement(target.getDeltaMovement().add(mob.getDeltaMovement()));
			}
		}
		
		@Override
		public void stop() {
			super.stop();
			this.nextUseTime = mob.tickCount + 60;
		}

		public boolean animationsUseable() {
			return mob.attackAnimationTick <= 0;
		}

	}