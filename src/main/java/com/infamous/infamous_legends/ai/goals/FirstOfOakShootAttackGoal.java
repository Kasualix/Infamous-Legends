package com.infamous.infamous_legends.ai.goals;

import java.util.EnumSet;

import javax.annotation.Nullable;

import com.infamous.infamous_legends.entities.FirstOfOak;
import com.infamous.infamous_legends.entities.FirstOfOakBolt;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.utils.MiscUtils;
import com.infamous.infamous_legends.utils.PositionUtils;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

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
			
			if (mob.shootAnimationTick == mob.shootAnimationLength - 17) {
				mob.playSound(SoundEvents.GOAT_RAM_IMPACT, 1.5F, MiscUtils.randomSoundPitch() * 0.25F);
				Vec3 slamAttackBoundingBoxOffset = PositionUtils.getOffsetPos(mob, 0, 0, 1.5, mob.yBodyRot);
				AABB slamAttackBoundingBox = mob.getBoundingBox().deflate(0, 2, 0).move(0, -2, 0).inflate(2, 0, 2).move(slamAttackBoundingBoxOffset.x - mob.getX(), slamAttackBoundingBoxOffset.y - mob.getY(), slamAttackBoundingBoxOffset.z - mob.getZ());
				((ServerLevel)mob.level).sendParticles(ParticleTypeInit.DUST.get(), slamAttackBoundingBoxOffset.x, slamAttackBoundingBoxOffset.y, slamAttackBoundingBoxOffset.z, 20, 1, 0, 1, 1);
				for (LivingEntity entity : mob.level.getNearbyEntities(LivingEntity.class, TargetingConditions.forCombat(), mob, slamAttackBoundingBox)) {
					if (!MiscUtils.nonEnemy(mob, entity)) {
						mob.doHurtTarget(entity);
					}
				}
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