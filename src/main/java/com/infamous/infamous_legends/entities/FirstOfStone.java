package com.infamous.infamous_legends.entities;

import javax.annotation.Nullable;

import com.infamous.infamous_legends.ai.goals.ApproachTargetGoal;
import com.infamous.infamous_legends.ai.goals.FirstOfStoneMeleeAttackGoal;
import com.infamous.infamous_legends.ai.goals.FirstOfStoneRangedAttackGoal;
import com.infamous.infamous_legends.ai.goals.LookAtTargetGoal;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.init.SoundEventInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.GolemRandomStrollInVillageGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class FirstOfStone extends AbstractGolem {

	public AnimationState attackAnimationState = new AnimationState();
	public int attackAnimationTick;
	public final int attackAnimationLength = 76;
	public final int attackAnimationActionPoint = 36;
	
	public AnimationState rangedAttackAnimationState = new AnimationState();
	public int rangedAttackAnimationTick;
	public final int rangedAttackAnimationLength = 86;
	public final int rangedAttackAnimationActionPoint = 30;
	
	public FirstOfStone(EntityType<? extends FirstOfStone> type, Level level) {
		super(type, level);		
	}
	
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FirstOfStoneMeleeAttackGoal(this));
		this.goalSelector.addGoal(1, new FirstOfStoneRangedAttackGoal(this));
		this.goalSelector.addGoal(2, new LookAtTargetGoal(this));
		this.goalSelector.addGoal(3, new ApproachTargetGoal(this, 25, 1.2, true));
		this.goalSelector.addGoal(4, new MoveBackToVillageGoal(this, 0.6D, false));
		this.goalSelector.addGoal(5, new GolemRandomStrollInVillageGoal(this, 0.6D));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this).setAlertOthers());
		this.targetSelector.addGoal(3,
				new NearestAttackableTargetGoal<>(this, Mob.class, 10, false, false, (p_28879_) -> {
					return p_28879_ instanceof Enemy && !(p_28879_ instanceof Creeper);
				}));
	}
	
	@Override
	public boolean canBeCollidedWith() {
		return true;
	}
	
	@Override
	public boolean canAttack(LivingEntity target) {
		if (target instanceof Player && this.getTeam() == null && target.getTeam() == null) {
			return false;
		} else {
			return super.canAttack(target);
		}
	}
	
	public void handleEntityEvent(byte p_219360_) {
		if (p_219360_ == 4) {
			this.attackAnimationTick = this.attackAnimationLength;
			this.attackAnimationState.start(this.tickCount);
		} else if (p_219360_ == 11) {
			this.rangedAttackAnimationTick = this.rangedAttackAnimationLength;
			this.rangedAttackAnimationState.start(this.tickCount);
		} else {
			super.handleEntityEvent(p_219360_);
		}

	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 150.0D).add(Attributes.MOVEMENT_SPEED, 0.3D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 1D).add(Attributes.ATTACK_DAMAGE, 18.0D)
				.add(Attributes.ATTACK_KNOCKBACK, 2D).add(Attributes.FOLLOW_RANGE, 35.0D);
	}
	
	@Override
	public void baseTick() {
		super.baseTick();
		
		if (this.level.isClientSide) {
			Vec3 velocity = this.getDeltaMovement();
			float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));				
			
			boolean shouldPlayRunAnimation = speed > 0.15 && this.attackAnimationTick <= 0 && this.rangedAttackAnimationTick <= 0;
			
			if (shouldPlayRunAnimation && this.random.nextBoolean()) {
				this.level.addParticle(ParticleTypeInit.DUST.get(), this.getRandomX(0.5), this.getY(), this.getRandomZ(0.5), 0, 0, 0);
			}
			
		      if (!shouldPlayRunAnimation && this.getDeltaMovement().horizontalDistanceSqr() > (double)2.5000003E-7F && this.random.nextInt(5) == 0) {
		          int i = Mth.floor(this.getX());
		          int j = Mth.floor(this.getY() - (double)0.2F);
		          int k = Mth.floor(this.getZ());
		          BlockPos pos = new BlockPos(i, j, k);
		          BlockState blockstate = this.level.getBlockState(pos);
		          if (!blockstate.isAir()) {
		             this.level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, blockstate).setPos(pos), this.getX() + ((double)this.random.nextFloat() - 0.5D) * (double)this.getBbWidth(), this.getY() + 0.1D, this.getZ() + ((double)this.random.nextFloat() - 0.5D) * (double)this.getBbWidth(), 4.0D * ((double)this.random.nextFloat() - 0.5D), 0.5D, ((double)this.random.nextFloat() - 0.5D) * 4.0D);
		          }
		       }
		}
		
		if (this.attackAnimationTick > 0) {
			this.attackAnimationTick--;
		}
		
		if (this.attackAnimationTick <= 0 && this.attackAnimationState.isStarted()) {
			this.attackAnimationState.stop();
		}
		
		if (this.rangedAttackAnimationTick > 0) {
			this.rangedAttackAnimationTick--;
		}
		
		if (this.rangedAttackAnimationTick <= 0 && this.rangedAttackAnimationState.isStarted()) {
			this.rangedAttackAnimationState.stop();
		}
	}
	
	@Nullable
	protected SoundEvent getAmbientSound() {
		return this.rangedAttackAnimationTick > 0 || this.attackAnimationTick > 0 ? null : SoundEventInit.FIRST_OF_STONE_IDLE.get();
	}

	protected SoundEvent getHurtSound(DamageSource p_35498_) {
		return SoundEventInit.FIRST_OF_STONE_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return SoundEventInit.FIRST_OF_STONE_DEATH.get();
	}
	
	protected void playStepSound(BlockPos p_35066_, BlockState p_35067_) {
		Vec3 velocity = this.getDeltaMovement();
		float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));	
		
		boolean shouldPlayRunAnimation = speed > 0.15 && this.attackAnimationTick <= 0 && this.rangedAttackAnimationTick <= 0;
		if (shouldPlayRunAnimation) {
			this.playSound(SoundEventInit.FIRST_OF_STONE_STEP_RUNNING.get(), 0.75F, this.getVoicePitch());
		} else {
			this.playSound(SoundEventInit.FIRST_OF_STONE_STEP.get(), 0.5F, this.getVoicePitch());
		}
	}
	   
	protected int decreaseAirSupply(int p_28882_) {
		return p_28882_;
	}
}
