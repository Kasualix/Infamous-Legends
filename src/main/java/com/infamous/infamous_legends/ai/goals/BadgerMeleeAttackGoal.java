package com.infamous.infamous_legends.ai.goals;

import java.util.EnumSet;

import javax.annotation.Nullable;

import com.infamous.infamous_legends.entities.Badger;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.init.SoundEventInit;
import com.infamous.infamous_legends.utils.MiscUtils;
import com.infamous.infamous_legends.utils.PositionUtils;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.phys.Vec3;

public class BadgerMeleeAttackGoal extends Goal {

		public Badger mob;
		@Nullable
		public LivingEntity target;
		
		public int nextUseTime;

		public BadgerMeleeAttackGoal(Badger mob) {
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
			return target != null && mob.tickCount >= this.nextUseTime && !target.isRemoved() && !target.isDeadOrDying() && mob.distanceTo(target) <= 1 && animationsUseable() && mob.hasLineOfSight(target);
		}

		@Override
		public boolean canContinueToUse() {
			return !animationsUseable();
		}

		@Override
		public void start() {
			mob.playSound(SoundEventInit.BADGER_ATTACK.get());
			mob.attackAnimationTick = mob.attackAnimationLength;
			mob.level.broadcastEntityEvent(mob, (byte) 4);
		}

		@Override
		public void tick() {
			target = mob.getTarget();

			mob.getNavigation().stop();
			
			if (target != null) {
				mob.lookAt(Anchor.EYES, target.position());
			}
			
			if (target != null && mob.distanceTo(target) <= 2 && mob.attackAnimationTick == mob.attackAnimationActionPoint && mob.hasLineOfSight(target)) {
				mob.doHurtTarget(target);
			}
		}
		
		@Override
		public void stop() {
			super.stop();
			this.nextUseTime = mob.tickCount + 10;
		}

		public boolean animationsUseable() {
			return mob.attackAnimationTick <= 0;
		}

	}