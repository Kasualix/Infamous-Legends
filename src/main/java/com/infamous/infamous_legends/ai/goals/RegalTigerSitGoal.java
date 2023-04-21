package com.infamous.infamous_legends.ai.goals;

import java.util.EnumSet;

import javax.annotation.Nullable;

import com.infamous.infamous_legends.entities.RegalTiger;
import com.infamous.infamous_legends.utils.MiscUtils;
import com.infamous.infamous_legends.utils.PositionUtils;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;

public class RegalTigerSitGoal extends Goal {

		public RegalTiger mob;
		
		public int nextUseTime;
		public int sittingFor;
		public int nextCleanTime;

		public RegalTigerSitGoal(RegalTiger mob) {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK, Goal.Flag.TARGET));
			this.mob = mob;
		}

		@Override
		public boolean isInterruptable() {
			return false;
		}
		
		@Override
		public boolean requiresUpdateEveryTick() {
			return true;
		}

		@Override
		public boolean canUse() {
			return mob.isSitting() || (!mob.isSitting() && mob.tickCount >= nextUseTime && !mob.isVehicle() && (mob.getTarget() == null || mob.getTarget().isRemoved() || mob.getTarget().isDeadOrDying()) && mob.getRandom().nextInt(200) == 0);
		}
		
		@Override
		public boolean canContinueToUse() {
			return mob.isSitting();
		}

		@Override
		public void start() {
			mob.sitAnimationTick = mob.sitAnimationLength;
			mob.level.broadcastEntityEvent(mob, (byte) 11);
			mob.setSitting(true);
			this.sittingFor = 0;
		}
		
		@Override
		public void tick() {
			mob.getNavigation().stop();
			
			this.sittingFor ++;
			
			if (mob.tickCount >= nextCleanTime && mob.getRandom().nextInt(100) == 0 && mob.cleanAnimationTick <= 0 && mob.sitAnimationTick <= 0 && mob.standAnimationTick <= 0) {
				mob.cleanAnimationTick = mob.cleanAnimationLength;
				mob.level.broadcastEntityEvent(mob, (byte) 8);
				this.nextCleanTime = mob.tickCount + mob.cleanAnimationLength + 100;
			}
			
			if (sittingFor > 200 && mob.getRandom().nextInt(100) == 0 && mob.cleanAnimationTick <= 0 && mob.standAnimationTick <= 0) {
				mob.standAnimationTick = mob.standAnimationLength;
				mob.level.broadcastEntityEvent(mob, (byte) 9);
			}
			
			if (mob.standAnimationTick == 2) {
				this.stop();
			}
		}
		
		@Override
		public void stop() {
			this.nextUseTime = mob.tickCount + 200;
			mob.setSitting(false);
			this.sittingFor = 0;
		}
	}