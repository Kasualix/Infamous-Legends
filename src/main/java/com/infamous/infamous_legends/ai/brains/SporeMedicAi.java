package com.infamous.infamous_legends.ai.brains;

import java.util.Optional;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.infamous.infamous_legends.ai.brains.behaviours.InteractWithTag;
import com.infamous.infamous_legends.ai.brains.behaviours.LookAtAttackTarget;
import com.infamous.infamous_legends.ai.brains.behaviours.LookAtHealTarget;
import com.infamous.infamous_legends.ai.brains.behaviours.SetWalkTargetFromHealTargetIfTargetOutOfReach;
import com.infamous.infamous_legends.ai.brains.behaviours.SporeMedicHealAllies;
import com.infamous.infamous_legends.ai.brains.behaviours.SporeMedicShootAttack;
import com.infamous.infamous_legends.ai.brains.behaviours.StartHealing;
import com.infamous.infamous_legends.ai.brains.behaviours.StopAtDistanceSetWalkTargetFromAttackTargetIfTargetOutOfReach;
import com.infamous.infamous_legends.ai.brains.behaviours.StopHealingIfHealTargetInvalid;
import com.infamous.infamous_legends.ai.brains.sensors.CustomSensor;
import com.infamous.infamous_legends.entities.MaceRunt;
import com.infamous.infamous_legends.entities.SporeMedic;
import com.infamous.infamous_legends.init.ActivityInit;
import com.infamous.infamous_legends.init.MemoryModuleTypeInit;
import com.infamous.infamous_legends.init.TagInit;
import com.infamous.infamous_legends.utils.BrainUtils;
import com.mojang.datafixers.util.Pair;

import net.minecraft.core.GlobalPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.behavior.DoNothing;
import net.minecraft.world.entity.ai.behavior.InteractWithDoor;
import net.minecraft.world.entity.ai.behavior.LookAtTargetSink;
import net.minecraft.world.entity.ai.behavior.MoveToTargetSink;
import net.minecraft.world.entity.ai.behavior.RandomStroll;
import net.minecraft.world.entity.ai.behavior.RunOne;
import net.minecraft.world.entity.ai.behavior.SetEntityLookTarget;
import net.minecraft.world.entity.ai.behavior.SetLookAndInteract;
import net.minecraft.world.entity.ai.behavior.SetWalkTargetAwayFrom;
import net.minecraft.world.entity.ai.behavior.SetWalkTargetFromAttackTargetIfTargetOutOfReach;
import net.minecraft.world.entity.ai.behavior.StartAttacking;
import net.minecraft.world.entity.ai.behavior.StopAttackingIfTargetInvalid;
import net.minecraft.world.entity.ai.behavior.StopBeingAngryIfTargetDead;
import net.minecraft.world.entity.ai.behavior.StrollAroundPoi;
import net.minecraft.world.entity.ai.behavior.StrollToPoi;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.schedule.Activity;

public class SporeMedicAi {

	  public static Brain<?> makeBrain(SporeMedic p_35100_, Brain<SporeMedic> p_35101_) {
	      initCoreActivity(p_35100_, p_35101_);
	      initIdleActivity(p_35100_, p_35101_);
	      initHealAllyActivity(p_35100_, p_35101_);
	      initFightActivity(p_35100_, p_35101_);
	      p_35101_.setCoreActivities(ImmutableSet.of(Activity.CORE));
	      p_35101_.setDefaultActivity(Activity.IDLE);
	      p_35101_.useDefaultActivity();
	      return p_35101_;
	   }

	   public static void initMemories(SporeMedic p_35095_) {
	      GlobalPos globalpos = GlobalPos.of(p_35095_.level.dimension(), p_35095_.blockPosition());
	      p_35095_.getBrain().setMemory(MemoryModuleType.HOME, globalpos);
	   }

	   private static void initCoreActivity(SporeMedic p_35112_, Brain<SporeMedic> p_35113_) {
	      p_35113_.addActivity(Activity.CORE, 0, ImmutableList.of(new LookAtTargetSink(45, 90), new MoveToTargetSink(), new InteractWithDoor(), new StopBeingAngryIfTargetDead<>()));
	   }

	   private static void initIdleActivity(SporeMedic p_35120_, Brain<SporeMedic> p_35121_) {
	      p_35121_.addActivity(Activity.IDLE, 10, ImmutableList.of(new StartHealing<>(SporeMedicAi::findNearestValidHealTarget), new StartAttacking<>(SporeMedicAi::findNearestValidAttackTarget), createIdleLookBehaviors(), createIdleMovementBehaviors(), new SetLookAndInteract(EntityType.PLAYER, 4)));
	   }

	   private static void initHealAllyActivity(SporeMedic p_35125_, Brain<SporeMedic> p_35126_) {
	      p_35126_.addActivityAndRemoveMemoryWhenStopped(ActivityInit.HEAL_ALLY.get(), 1, ImmutableList.of(new StopHealingIfHealTargetInvalid<>((p_35118_) -> {
	         return !isNearestValidHealTarget(p_35125_, p_35118_);
	      }), new SetWalkTargetFromHealTargetIfTargetOutOfReach(1.0F, 4.0D), new SporeMedicHealAllies(), new LookAtHealTarget()), MemoryModuleTypeInit.HEAL_TARGET.get());
	   }
	   
	   private static void initFightActivity(SporeMedic p_35125_, Brain<SporeMedic> p_35126_) {
		      p_35126_.addActivityAndRemoveMemoryWhenStopped(Activity.FIGHT, 10, ImmutableList.of(new StopAttackingIfTargetInvalid<>((p_35118_) -> {
		         return !isNearestValidAttackTarget(p_35125_, p_35118_) || p_35126_.hasMemoryValue(MemoryModuleTypeInit.HEAL_TARGET.get());
		      }), new StopAtDistanceSetWalkTargetFromAttackTargetIfTargetOutOfReach(1.0F, 4), new SporeMedicShootAttack(), new LookAtAttackTarget()), MemoryModuleType.ATTACK_TARGET);
		   }

	   private static RunOne<SporeMedic> createIdleLookBehaviors() {
	      return new RunOne<>(ImmutableList.of(Pair.of(new SetEntityLookTarget(EntityType.PLAYER, 8.0F), 1), Pair.of(new SetEntityLookTarget(TagInit.EntityTypes.PIGLIN_ALLIES, 8.0F), 1), Pair.of(new SetEntityLookTarget(8.0F), 1), Pair.of(new DoNothing(30, 60), 1)));
	   }

	   private static RunOne<SporeMedic> createIdleMovementBehaviors() {
	      return new RunOne<>(ImmutableList.of(Pair.of(new RandomStroll(0.6F), 2), Pair.of(InteractWithTag.of(TagInit.EntityTypes.PIGLIN_ALLIES, 8, MemoryModuleType.INTERACTION_TARGET, 0.6F, 2), 2), Pair.of(new StrollToPoi(MemoryModuleType.HOME, 0.6F, 2, 100), 2), Pair.of(new StrollAroundPoi(MemoryModuleType.HOME, 0.6F, 5), 2), Pair.of(new DoNothing(30, 60), 1)));
	   }

	   public static void updateActivity(SporeMedic p_35110_) {
	      Brain<SporeMedic> brain = p_35110_.getBrain();
	      brain.setActiveActivityToFirstValid(ImmutableList.of(ActivityInit.HEAL_ALLY.get(), Activity.FIGHT, Activity.IDLE));
	      p_35110_.setAggressive(brain.hasMemoryValue(MemoryModuleType.ATTACK_TARGET));
	   }

	   private static boolean isNearestValidHealTarget(AbstractPiglin p_35089_, LivingEntity p_35090_) {
	      return findNearestValidHealTarget(p_35089_).filter((p_35085_) -> {
	         return p_35085_ == p_35090_;
	      }).isPresent();
	   }

	   private static Optional<? extends LivingEntity> findNearestValidHealTarget(AbstractPiglin p_35087_) {
	      Optional<LivingEntity> optional = p_35087_.getBrain().getMemory(MemoryModuleTypeInit.HEAL_TARGET.get());
	      if (optional.isPresent() && optional.get().getHealth() < optional.get().getMaxHealth()) {
	         return optional;
	      } else {
	         return getHealTargetIfWithinRange(p_35087_, MemoryModuleTypeInit.HEAL_TARGET.get());
	      }
	   }
	   
	   private static boolean isNearestValidAttackTarget(SporeMedic p_35089_, LivingEntity p_35090_) {
		      return !p_35089_.getBrain().hasMemoryValue(MemoryModuleTypeInit.HEAL_TARGET.get()) && findNearestValidAttackTarget(p_35089_).filter((p_35085_) -> {
		         return p_35085_ == p_35090_;
		      }).isPresent();
		   }

		   private static Optional<? extends LivingEntity> findNearestValidAttackTarget(AbstractPiglin p_35087_) {
		      Optional<LivingEntity> optional = BehaviorUtils.getLivingEntityFromUUIDMemory(p_35087_, MemoryModuleType.ANGRY_AT);
		      if (optional.isPresent() && CustomSensor.isEntityAttackableIgnoringLineOfSight(p_35087_, optional.get())) {
		         return optional;
		      } else {
		         Optional<? extends LivingEntity> optional1 = getAttackTargetIfWithinRange(p_35087_, MemoryModuleType.NEAREST_VISIBLE_ATTACKABLE_PLAYER);
		         return optional1.isPresent() ? optional1 : p_35087_.getBrain().getMemory(MemoryModuleType.NEAREST_VISIBLE_NEMESIS);
		      }
		   }

		   public static void wasHurtBy(SporeMedic p_35097_, LivingEntity p_35098_) {
			      BrainUtils.piglinMaybeRetaliate(p_35097_, p_35098_);
		   }

		   protected static void setAngerTarget(SporeMedic p_149989_, LivingEntity p_149990_) {
		      p_149989_.getBrain().eraseMemory(MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE);
		      p_149989_.getBrain().setMemoryWithExpiry(MemoryModuleType.ANGRY_AT, p_149990_.getUUID(), 600L);
		   }

	   private static Optional<? extends LivingEntity> getHealTargetIfWithinRange(AbstractPiglin p_35092_, MemoryModuleType<? extends LivingEntity> p_35093_) {
	      return p_35092_.getBrain().getMemory(p_35093_).filter((p_35108_) -> {
	         return p_35108_.closerThan(p_35092_, p_35092_.getAttributeValue(Attributes.FOLLOW_RANGE)) && p_35108_.getHealth() < p_35108_.getMaxHealth();
	      });
	   }
	   
	   private static Optional<? extends LivingEntity> getAttackTargetIfWithinRange(AbstractPiglin p_35092_, MemoryModuleType<? extends LivingEntity> p_35093_) {
		      return p_35092_.getBrain().getMemory(p_35093_).filter((p_35108_) -> {
		         return p_35108_.closerThan(p_35092_, p_35092_.getAttributeValue(Attributes.FOLLOW_RANGE));
		      });
		   }
}
