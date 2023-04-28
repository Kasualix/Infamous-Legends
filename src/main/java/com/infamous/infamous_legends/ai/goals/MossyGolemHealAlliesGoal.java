package com.infamous.infamous_legends.ai.goals;

import java.util.EnumSet;

import javax.annotation.Nullable;

import com.infamous.infamous_legends.entities.MossyGolem;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

public class MossyGolemHealAlliesGoal extends Goal {

		public MossyGolem mob;
		@Nullable
		public LivingEntity target;
		
		public int healingFor;
		public int nextUseTime;

		public MossyGolemHealAlliesGoal(MossyGolem mob) {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP));
			this.mob = mob;
			this.target = mob.getHealTarget();
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
			target = mob.getHealTarget();
			return mob.tickCount >= this.nextUseTime && target != null && !target.isRemoved() && !target.isDeadOrDying() && mob.distanceTo(target) <= 3 && mob.hasLineOfSight(target);
		}

		@Override
		public boolean canContinueToUse() {
			return this.healingFor < 100 && mob.shooting && target != null && !target.isRemoved() && !target.isDeadOrDying();
		}

		@Override
		public void start() {
		      mob.shooting = true;
		      mob.level.broadcastEntityEvent(mob, (byte) 4);
		     this.healingFor = 0;
		}

		@Override
		public void tick() {
			target = mob.getHealTarget();

			mob.getNavigation().stop();
			
			this.healingFor ++;
		}
		
		@Override
		public void stop() {
			super.stop();
			mob.shooting = false;
			mob.level.broadcastEntityEvent(mob, (byte) 11);
			this.nextUseTime = mob.tickCount + 100;
			this.healingFor = 0;
		}

	}