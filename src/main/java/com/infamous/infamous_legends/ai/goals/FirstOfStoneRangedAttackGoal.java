package com.infamous.infamous_legends.ai.goals;

import java.util.EnumSet;

import javax.annotation.Nullable;

import com.infamous.infamous_legends.entities.BoulderProjectile;
import com.infamous.infamous_legends.entities.FirstOfStone;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.utils.MiscUtils;
import com.infamous.infamous_legends.utils.PositionUtils;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class FirstOfStoneRangedAttackGoal extends Goal {

		public FirstOfStone mob;
		@Nullable
		public LivingEntity target;
		
		public int nextUseTime;

		public FirstOfStoneRangedAttackGoal(FirstOfStone mob) {
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
			return target != null && mob.tickCount >= this.nextUseTime && !target.isRemoved() && !target.isDeadOrDying() && mob.distanceTo(target) > 5 && mob.distanceTo(target) <= 25 && animationsUseable() && mob.hasLineOfSight(target);
		}

		@Override
		public boolean canContinueToUse() {
			return !animationsUseable();
		}

		@Override
		public void start() {
			mob.rangedAttackAnimationTick = mob.rangedAttackAnimationLength;
			mob.level.broadcastEntityEvent(mob, (byte) 11);
		}

		@Override
		public void tick() {
			target = mob.getTarget();

			mob.getNavigation().stop();
			
			if (target != null) {
				mob.lookAt(Anchor.EYES, target.position());
			}
			
			if (mob.rangedAttackAnimationTick == mob.rangedAttackAnimationLength - 16) {
				mob.playSound(SoundEvents.GOAT_RAM_IMPACT, 1.5F, MiscUtils.randomSoundPitch() * 0.25F);
			}
			
			if (mob.rangedAttackAnimationTick <= mob.rangedAttackAnimationLength - 25 && mob.rangedAttackAnimationTick >= mob.rangedAttackAnimationLength - 55 && mob.tickCount % 3 == 0) {
				mob.playSound(SoundEvents.GRASS_HIT, 1.0F, MiscUtils.randomSoundPitch() * 0.005F);
			    Vec3 particlePos = PositionUtils.getOffsetPos(mob, 1.5, 0, -1 + mob.getRandom().nextGaussian() * 2, mob.yBodyRot);
				((ServerLevel)mob.level).sendParticles(ParticleTypeInit.DUST.get(), particlePos.x, particlePos.y,
						particlePos.z, 5, 0.5D, 0.2D, 0.5D, 0.0D);
			}
			
			if (mob.rangedAttackAnimationTick == mob.rangedAttackAnimationActionPoint) {
				mob.playSound(SoundEvents.SNOWBALL_THROW, 1.5F, MiscUtils.randomSoundPitch() * 0.25F);
			}
			
			if (target != null && mob.rangedAttackAnimationTick == mob.rangedAttackAnimationActionPoint && mob.hasLineOfSight(target)) {
			      BoulderProjectile boulder = new BoulderProjectile(mob.level, mob);
			      Vec3 boulderPos = PositionUtils.getOffsetPos(mob, 1.5, 1, -3, mob.yBodyRot);
			      BlockState blockState0 = mob.level.getBlockState(PositionUtils.getOffsetBlockPos(mob, 1.0, -1.5, -3, mob.yBodyRot));
			      BlockState blockState1 = mob.level.getBlockState(PositionUtils.getOffsetBlockPos(mob, 2.0, -1.5, -3, mob.yBodyRot));
			      BlockState blockState2 = mob.level.getBlockState(PositionUtils.getOffsetBlockPos(mob, 1.0, -1.5, -4, mob.yBodyRot));
			      BlockState blockState3 = mob.level.getBlockState(PositionUtils.getOffsetBlockPos(mob, 2.0, -1.5, -4, mob.yBodyRot));
			      BlockState blockState4 = mob.level.getBlockState(PositionUtils.getOffsetBlockPos(mob, 1.0, -0.5, -3, mob.yBodyRot));
			      BlockState blockState5 = mob.level.getBlockState(PositionUtils.getOffsetBlockPos(mob, 2.0, -0.5, -3, mob.yBodyRot));
			      BlockState blockState6 = mob.level.getBlockState(PositionUtils.getOffsetBlockPos(mob, 1.0, -0.5, -4, mob.yBodyRot));
			      BlockState blockState7 = mob.level.getBlockState(PositionUtils.getOffsetBlockPos(mob, 2.0, -0.5, -4, mob.yBodyRot));
			      double d0 = target.getX() - boulderPos.x;
			      double d1 = target.getY(0.3333333333333333D) - boulderPos.y;
			      double d2 = target.getZ() - boulderPos.z;
			      double d3 = Math.sqrt(d0 * d0 + d2 * d2);
			      boulder.moveTo(boulderPos);
			      float yMultiplier = mob.distanceTo(target) <= 10 ? 0.1F : 0.2F;
			      boulder.shoot(d0, d1 + d3 * (double)yMultiplier, d2, 1.5F, 1);
			      if (blockState0.getBlock() instanceof AirBlock && blockState1.getBlock() instanceof AirBlock && blockState2.getBlock() instanceof AirBlock && blockState3.getBlock() instanceof AirBlock && blockState4.getBlock() instanceof AirBlock && blockState5.getBlock() instanceof AirBlock && blockState6.getBlock() instanceof AirBlock && blockState7.getBlock() instanceof AirBlock) {
			    	  blockState0 = Blocks.DIRT.defaultBlockState();
			    	  blockState1 = Blocks.DIRT.defaultBlockState();
			    	  blockState2 = Blocks.DIRT.defaultBlockState();
			    	  blockState3 = Blocks.DIRT.defaultBlockState();
			    	  blockState4 = Blocks.DIRT.defaultBlockState();
			    	  blockState5 = Blocks.DIRT.defaultBlockState();
			    	  blockState6 = Blocks.DIRT.defaultBlockState();
			    	  blockState7 = Blocks.DIRT.defaultBlockState();
			      }
			      boulder.setBlockState(blockState0, 0);
			      boulder.setBlockState(blockState1, 1);
			      boulder.setBlockState(blockState2, 2);
			      boulder.setBlockState(blockState3, 3);
			      boulder.setBlockState(blockState4, 4);
			      boulder.setBlockState(blockState5, 5);
			      boulder.setBlockState(blockState6, 6);
			      boulder.setBlockState(blockState7, 7);
			      mob.level.addFreshEntity(boulder);
					((ServerLevel)mob.level).sendParticles(ParticleTypeInit.DUST.get(), boulder.getX(), boulder.getY(0.5),
							boulder.getZ(), 30, 1.0D, 1.0D, 1.0D, 0.0D);
			}
		}
		
		@Override
		public void stop() {
			super.stop();
			this.nextUseTime = mob.tickCount + 20;
		}

		public boolean animationsUseable() {
			return mob.rangedAttackAnimationTick <= 0;
		}

	}