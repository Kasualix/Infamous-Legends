package com.infamous.infamous_legends.entities;

import com.infamous.infamous_legends.ai.goals.ApproachTargetGoal;
import com.infamous.infamous_legends.ai.goals.LookAtTargetGoal;
import com.infamous.infamous_legends.ai.goals.PlankGolemShootAttackGoal;
import com.infamous.infamous_legends.golem_types.PlankGolemType;
import com.infamous.infamous_legends.init.PlankGolemTypeInit;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
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
import net.minecraft.world.level.ServerLevelAccessor;

public class PlankGolem extends AbstractGolem {

	private static final EntityDataAccessor<String> TYPE = SynchedEntityData.defineId(PlankGolem.class, EntityDataSerializers.STRING);
	   
	public AnimationState shootAnimationState = new AnimationState();
	public int shootAnimationTick;
	public final int shootAnimationLength = 35;
	public final int shootAnimationActionPoint = 18;
	
	public PlankGolem(EntityType<? extends PlankGolem> type, Level level) {
		super(type, level);		
	}
	
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new PlankGolemShootAttackGoal(this));
		this.goalSelector.addGoal(1, new LookAtTargetGoal(this));
		this.goalSelector.addGoal(2, new ApproachTargetGoal(this, 20, 1.2, true));
		this.goalSelector.addGoal(3, new MoveBackToVillageGoal(this, 0.6D, false));
		this.goalSelector.addGoal(4, new GolemRandomStrollInVillageGoal(this, 0.6D));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this).setAlertOthers());
		this.targetSelector.addGoal(3,
				new NearestAttackableTargetGoal<>(this, Mob.class, 10, false, false, (p_28879_) -> {
					return p_28879_ instanceof Enemy && !(p_28879_ instanceof Creeper);
				}));
	}
	
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty,
			MobSpawnType pReason, SpawnGroupData pSpawnData, CompoundTag pDataTag) {
		this.setType(PlankGolemTypeInit.PLANK_GOLEM_TYPE_REGISTRY.getData().values().stream().toList().get(this.random.nextInt(PlankGolemTypeInit.PLANK_GOLEM_TYPE_REGISTRY.getData().values().size())));
		return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
	}
	
	protected void defineSynchedData() {
	    super.defineSynchedData();
		this.entityData.define(TYPE, "oak");
	}
	
	public void addAdditionalSaveData(CompoundTag pCompound) {
		super.addAdditionalSaveData(pCompound);
		pCompound.putString("Type", this.getPlankGolemType().getName());
	}

	public void readAdditionalSaveData(CompoundTag pCompound) {
		super.readAdditionalSaveData(pCompound);
		if (pCompound.contains("Type", 8)) {
			this.setType(PlankGolemTypeInit.getPlankGolemTypeByName(pCompound.getString("Type")));
		}
	}
	
	public void setType(PlankGolemType type) {
		this.entityData.set(TYPE, type.getName());
	}

	public PlankGolemType getPlankGolemType() {
		PlankGolemType type = PlankGolemTypeInit.getPlankGolemTypeByName(this.entityData.get(TYPE));
		if (type == null) {
			this.setType(PlankGolemTypeInit.getPlankGolemTypeByName("oak"));
			type = PlankGolemTypeInit.getPlankGolemTypeByName(this.entityData.get(TYPE));
		}
		return type;
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
			this.shootAnimationTick = this.shootAnimationLength;
			this.shootAnimationState.start(this.tickCount);
		} else {
			super.handleEntityEvent(p_219360_);
		}

	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 15.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.FOLLOW_RANGE, 25.0D);
	}
	
	@Override
	public void baseTick() {
		super.baseTick();
		
		if (this.shootAnimationTick > 0) {
			this.shootAnimationTick--;
		}
		
		if (this.shootAnimationTick <= 0 && this.shootAnimationState.isStarted()) {
			this.shootAnimationState.stop();
		}
	}
	
	protected SoundEvent getHurtSound(DamageSource p_35498_) {
		return SoundEvents.WOOD_HIT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.WOOD_BREAK;
	}
	   
	protected int decreaseAirSupply(int p_28882_) {
		return p_28882_;
	}
}
