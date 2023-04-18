package com.infamous.infamous_legends.ai.goals;

import java.util.EnumSet;

import javax.annotation.Nullable;

import com.infamous.infamous_legends.entities.FirstOfOak;
import com.infamous.infamous_legends.entities.FirstOfOakBolt;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

public class FirstOfOakShootAttackGoal extends Goal {

		public FirstOfOak mob;
		@Nullable
		public LivingEntity target;
		
		public int nextUseTime;

		public FirstOfOakShootAttackGoal(FirstOfOak mob) {
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
			return target != null && mob.tickCount >= this.nextUseTime && !target.isRemoved() && !target.isDeadOrDying() && mob.distanceTo(target) <= 30 && animationsUseable() && mob.hasLineOfSight(target);
		}

		@Override
		public boolean canContinueToUse() {
			return !animationsUseable();
		}

		@Override
		public void start() {
			mob.shootAnimationTick = mob.shootAnimationLength;
			mob.level.broadcastEntityEvent(mob, (byte) 4);
		}

		@Override
		public void tick() {
			target = mob.getTarget();

			mob.getNavigation().stop();
			
			if (target != null) {
				mob.lookAt(Anchor.EYES, target.position());
			}
			
			if (target != null && mob.shootAnimationTick == mob.shootAnimationActionPoint && mob.hasLineOfSight(target)) {
				FirstOfOakBolt bolt = new FirstOfOakBolt(mob.level, mob);
				bolt.moveTo(mob.position().add(0, 2.5, 0));
				double d0 = target.getX() - mob.getX();
				double d1 = target.getY(0.3333333333333333D) - bolt.getY();
				double d2 = target.getZ() - mob.getZ();
				double d3 = Math.sqrt(d0 * d0 + d2 * d2);
				bolt.setType(mob.getWood1Type());
				bolt.shoot(d0, d1 + d3 * (double) 0.1F, d2, 3.0F, 0);
				mob.playSound(SoundEvents.DISPENSER_LAUNCH);
				mob.playSound(SoundEvents.PISTON_CONTRACT);
				mob.level.addFreshEntity(bolt);
			}
		}
		
		@Override
		public void stop() {
			super.stop();
			this.nextUseTime = mob.tickCount + 60;
		}

		public boolean animationsUseable() {
			return mob.shootAnimationTick <= 0;
		}

	}