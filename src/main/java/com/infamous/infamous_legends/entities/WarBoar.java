package com.infamous.infamous_legends.entities;

import java.util.UUID;

import com.google.common.collect.ImmutableList;
import com.infamous.infamous_legends.ai.brains.WarBoarAi;
import com.infamous.infamous_legends.init.MemoryModuleTypeInit;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.init.SensorTypeInit;
import com.infamous.infamous_legends.init.SoundEventInit;
import com.infamous.infamous_legends.utils.MiscUtils;
import com.mojang.serialization.Dynamic;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.hoglin.HoglinBase;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class WarBoar extends Monster implements Enemy, HoglinBase {
	protected static final ImmutableList<? extends SensorType<? extends Sensor<? super WarBoar>>> SENSOR_TYPES = ImmutableList
			.of(SensorTypeInit.CUSTOM_NEAREST_LIVING_ENTITIES.get(), SensorTypeInit.CUSTOM_NEAREST_PLAYERS.get(), SensorTypeInit.LEGENDS_PIGLIN_SPECIFIC_SENSOR.get());
	protected static final ImmutableList<? extends MemoryModuleType<?>> MEMORY_TYPES = ImmutableList.of(
			MemoryModuleType.NEAREST_LIVING_ENTITIES, MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES,
			MemoryModuleType.NEAREST_VISIBLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_ATTACKABLE_PLAYER,
			MemoryModuleType.LOOK_TARGET, MemoryModuleType.WALK_TARGET, MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE,
			MemoryModuleType.PATH, MemoryModuleType.ATTACK_TARGET, MemoryModuleType.ATTACK_COOLING_DOWN,
			MemoryModuleType.NEARBY_ADULT_PIGLINS, MemoryModuleType.NEAREST_VISIBLE_NEMESIS, MemoryModuleType.ANGRY_AT,
			MemoryModuleTypeInit.NEARBY_ALLIES.get());
	
	public AnimationState attackAnimationState = new AnimationState();
	public int attackAnimationTick;
	public final int attackAnimationLength = 15;
	public final int attackAnimationActionPoint = 12;
	
	public float attackDamageAdditionMultiplier;

	public WarBoar(EntityType<? extends WarBoar> p_34204_, Level p_34205_) {
		super(p_34204_, p_34205_);
		this.xpReward = 7;
	}
	
	@Override
	public float getStepHeight() {
		return 1;
	}
	
	@Override
	public void baseTick() {
		super.baseTick();
		
		Vec3 velocity = this.getDeltaMovement();
		float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));				
		
		boolean shouldPlayRunAnimation = speed > 0.15 && this.attackAnimationTick <= 0;
		
		if (this.level.isClientSide && shouldPlayRunAnimation) {
			this.level.addParticle(ParticleTypeInit.DUST.get(), this.getX(), this.getY(), this.getZ(), 0, 0, 0);
		}
		
		if (this.attackAnimationTick > 0) {
			this.attackAnimationTick--;
		}
		
		if (this.attackAnimationTick <= 0 && this.attackAnimationState.isStarted()) {
			this.attackAnimationState.stop();
		}
		
		if (!this.level.isClientSide && this.getTarget() != null && !this.getTarget().isDeadOrDying() && !this.getTarget().isRemoved()) {
			for (LivingEntity entity : this.level.getNearbyEntities(LivingEntity.class, TargetingConditions.forCombat(), this, getBoundingBox().inflate(0.1))) {
				if (entity != this.getTarget() && !MiscUtils.piglinAllies(this, entity)) {
					entity.hurt(DamageSource.mobAttack(this), 5 * (speed * 5));
					double d0 = entity.getX() - this.getX();
					double d1 = entity.getZ() - this.getZ();
					double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
					entity.push(d0 / d2 * 2.0D, 0.3D, d1 / d2 * 2.0D);
				}
			}
		}
	}
	
	@Override
	public void aiStep() {
		super.aiStep();		
        this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(Mth.lerp(0.025D, this.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), (double) 0.425F));
		Vec3 velocity = this.getDeltaMovement();
		float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));	
		if (this.attackAnimationTick <= 0) {
	        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(5 + (8 * (speed * 5)));
		}
	}
	
	public void handleEntityEvent(byte p_219360_) {
		if (p_219360_ == 4) {
			this.attackAnimationTick = this.attackAnimationLength;
			this.attackAnimationState.start(this.tickCount);
		} else {
			super.handleEntityEvent(p_219360_);
		}

	}
	
	public boolean hurt(DamageSource p_35055_, float p_35056_) {
		boolean flag = super.hurt(p_35055_, p_35056_);
		if (this.level.isClientSide) {
			return false;
		} else {
			if (flag && p_35055_.getEntity() instanceof LivingEntity) {
				WarBoarAi.wasHurtBy(this, (LivingEntity) p_35055_.getEntity());
			}

			return flag;
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 45.0D).add(Attributes.FOLLOW_RANGE, 20.0D)
				.add(Attributes.MOVEMENT_SPEED, (double) 0.425F).add(Attributes.KNOCKBACK_RESISTANCE, (double) 0.8F)
				.add(Attributes.ATTACK_KNOCKBACK, 1.5D).add(Attributes.ATTACK_DAMAGE, 5.0D);
	}

	public boolean doHurtTarget(Entity p_34207_) {
		if (!(p_34207_ instanceof LivingEntity)) {
			return false;
		} else {
			return HoglinBase.hurtAndThrowTarget(this, (LivingEntity) p_34207_);
		}
	}

	protected void blockedByShield(LivingEntity p_34246_) {
		HoglinBase.throwTarget(this, p_34246_);
	}

	protected Brain.Provider<WarBoar> brainProvider() {
		return Brain.provider(MEMORY_TYPES, SENSOR_TYPES);
	}

	protected Brain<?> makeBrain(Dynamic<?> p_35064_) {
		return WarBoarAi.makeBrain(this, this.brainProvider().makeBrain(p_35064_));
	}

	public Brain<WarBoar> getBrain() {
		return (Brain<WarBoar>) super.getBrain();
	}

	protected void customServerAiStep() {
		this.level.getProfiler().push("warBoarBrain");
		this.getBrain().tick((ServerLevel) this.level, this);
		this.level.getProfiler().pop();
		WarBoarAi.updateActivity(this);
	}

	protected SoundEvent getAmbientSound() {
		Vec3 velocity = this.getDeltaMovement();
		float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));		
		
		return speed > 0.15 ? SoundEventInit.WAR_BOAR_CHARGE.get() : SoundEventInit.WAR_BOAR_IDLE.get();
	}

	protected SoundEvent getHurtSound(DamageSource p_34244_) {
		return SoundEventInit.WAR_BOAR_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return SoundEventInit.WAR_BOAR_DEATH.get();
	}

	protected void playStepSound(BlockPos p_34231_, BlockState p_34232_) {
		Vec3 velocity = this.getDeltaMovement();
		float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));	
		
		this.playSound(speed > 0.15 ? SoundEventInit.WAR_BOAR_STEP_CHARGING.get() : SoundEventInit.WAR_BOAR_STEP.get(), speed > 0.15 ? 0.75F : 0.25F, 1.0F);
	}

	public void playAngrySound() {
		this.playSound(SoundEventInit.WAR_BOAR_IDLE.get(), 1.0F, this.getVoicePitch());
	}

	@Override
	public int getAttackAnimationRemainingTicks() {
		return 0;
	}
}