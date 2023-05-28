package com.infamous.infamous_legends.ai.goals;

import java.util.EnumSet;

import com.infamous.infamous_legends.entities.Badger;
import com.infamous.infamous_legends.init.SoundEventInit;
import com.infamous.infamous_legends.utils.MiscUtils;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

public class BadgerGoToAlertPosGoal extends Goal {

	public Badger mob;

	public BadgerGoToAlertPosGoal(Badger mob) {
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP));
		this.mob = mob;
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
		return mob.alertPos != null && (mob.getTarget() == null || mob.getTarget().isRemoved() || mob.getTarget().isDeadOrDying());
	}

	@Override
	public boolean canContinueToUse() {
		return mob.alertPos != null && (mob.getTarget() == null || mob.getTarget().isRemoved() || mob.getTarget().isDeadOrDying());
	}

	@Override
	public void start() {
		if (mob.alertPos != null) {
			mob.playSound(SoundEventInit.BADGER_ALERT.get(), 1, mob.getVoicePitch());
			if (MiscUtils.distanceToBlockPos(mob, mob.alertPos) > 3) {
				mob.getNavigation().moveTo(mob.alertPos.getX(), mob.alertPos.getY(), mob.alertPos.getZ(), 1.25);
				if (mob.alertAnimationState.isStarted()) {
					mob.alertAnimationState.stop();
					mob.level.broadcastEntityEvent(mob, (byte) 10);
				}
			} else {
				mob.getNavigation().stop();
				if (!mob.alertAnimationState.isStarted()) {
					mob.alertAnimationState.start(mob.tickCount);
					mob.level.broadcastEntityEvent(mob, (byte) 9);
				}
			}
			mob.lookAt(Anchor.EYES, new Vec3(mob.alertPos.getX(), mob.alertPos.getY(), mob.alertPos.getZ()));
		}
	}

	@Override
	public void tick() {
		if (mob.alertPos != null) {
			if (mob.tickCount % 60 == 0) {
				mob.playSound(SoundEventInit.BADGER_ALERT.get(), 1, mob.getVoicePitch());
			}
			
			if (MiscUtils.distanceToBlockPos(mob, mob.alertPos) > 3) {
				mob.getNavigation().moveTo(mob.alertPos.getX(), mob.alertPos.getY(), mob.alertPos.getZ(), 1.25);
				if (mob.alertAnimationState.isStarted()) {
					mob.alertAnimationState.stop();
					mob.level.broadcastEntityEvent(mob, (byte) 10);
				}
			} else {
				mob.getNavigation().stop();
				if (!mob.alertAnimationState.isStarted()) {
					mob.alertAnimationState.start(mob.tickCount);
					mob.level.broadcastEntityEvent(mob, (byte) 9);
				}
			}
			mob.lookAt(Anchor.EYES, new Vec3(mob.alertPos.getX(), mob.alertPos.getY(), mob.alertPos.getZ()));
		}
	}

}
