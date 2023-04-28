package com.infamous.infamous_legends.ai.goals;

import java.util.EnumSet;

import javax.annotation.Nullable;

import com.infamous.infamous_legends.entities.GrindstoneGolem;
import com.infamous.infamous_legends.init.SoundEventInit;
import com.infamous.infamous_legends.utils.PositionUtils;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

public class GrindstoneGolemRollAttackGoal extends Goal {

		public GrindstoneGolem mob;
		@Nullable
		public LivingEntity target;
		
		public int nextUseTime;

		public GrindstoneGolemRollAttackGoal(GrindstoneGolem mob) {
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
			return target != null && mob.tickCount >= this.nextUseTime && !target.isRemoved() && !target.isDeadOrDying() && animationsUseable() && mob.hasLineOfSight(target);
		}

		@Override
		public boolean canContinueToUse() {
			return !animationsUseable();
		}

		@Override
		public void start() {
			mob.playSound(SoundEventInit.GRINDSTONE_GOLEM_ATTACK.get(), 1, mob.getVoicePitch());
			mob.playSound(SoundEventInit.GRINDSTONE_GOLEM_ROLL_START.get(), 1, mob.getVoicePitch());
			mob.rollAnimationTick = mob.rollAnimationLength;
			mob.lookAt(Anchor.EYES, target.position());
			mob.level.broadcastEntityEvent(mob, (byte) 4);
		}

		@Override
		public void tick() {
			target = mob.getTarget();

			mob.getNavigation().stop();
			
			if (mob.rollAnimationTick > 48 && target != null) {
				mob.lookAt(Anchor.EYES, target.position());
			}
			
			if (mob.rollAnimationTick == mob.rollAnimationLength - 16) {
				mob.playSound(SoundEventInit.GRINDSTONE_GOLEM_ROLL.get(), 1, 1);
			}
			
			if (mob.rollAnimationTick == mob.rollAnimationLength - 31) {
				mob.playSound(SoundEventInit.GRINDSTONE_GOLEM_ROLL.get(), 1, 1);
			}
			
			if (mob.rollAnimationTick == mob.rollAnimationLength - 49) {
				mob.playSound(SoundEventInit.GRINDSTONE_GOLEM_ROLL_STOP.get(), 1, 1);
			}
			
			mob.getNavigation().stop();
			
			if (mob.rolling()) {
				mob.setDeltaMovement(mob.getDeltaMovement().add(PositionUtils.getOffsetMotion(mob, 0, 0, mob.isOnGround() ? 0.175 : 0.075, mob.yBodyRot)));
			}
		}
		
		@Override
		public void stop() {
			super.stop();
			this.nextUseTime = mob.tickCount + 100;
		}

		public boolean animationsUseable() {
			return mob.rollAnimationTick <= 0;
		}

	}