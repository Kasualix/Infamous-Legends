package com.infamous.infamous_legends.entities;

import com.infamous.infamous_legends.ai.goals.ApproachTargetGoal;
import com.infamous.infamous_legends.ai.goals.FirstOfOakShootAttackGoal;
import com.infamous.infamous_legends.ai.goals.LookAtTargetGoal;
import com.infamous.infamous_legends.golem_types.FirstOfOakWood1Type;
import com.infamous.infamous_legends.golem_types.FirstOfOakWood2Type;
import com.infamous.infamous_legends.init.FirstOfOakWood1TypeInit;
import com.infamous.infamous_legends.init.FirstOfOakWood2TypeInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
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
import net.minecraft.world.level.block.state.BlockState;

public class FirstOfOak extends AbstractGolem {

	private static final EntityDataAccessor<String> WOOD_1_TYPE = SynchedEntityData.defineId(FirstOfOak.class, EntityDataSerializers.STRING);
	private static final EntityDataAccessor<String> WOOD_2_TYPE = SynchedEntityData.defineId(FirstOfOak.class, EntityDataSerializers.STRING);
	
	public AnimationState shootAnimationState = new AnimationState();
	public int shootAnimationTick;
	public final int shootAnimationLength = 56;
	public final int shootAnimationActionPoint = 25;
	
	public FirstOfOak(EntityType<? extends FirstOfOak> type, Level level) {
		super(type, level);		
	}
	
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FirstOfOakShootAttackGoal(this));
		this.goalSelector.addGoal(2, new LookAtTargetGoal(this));
		this.goalSelector.addGoal(3, new ApproachTargetGoal(this, 30, 1.2, true));
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
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty,
			MobSpawnType pReason, SpawnGroupData pSpawnData, CompoundTag pDataTag) {
		this.setWood1Type(FirstOfOakWood1TypeInit.FIRST_OF_OAK_WOOD_1_TYPE_REGISTRY.getData().values().stream().toList().get(this.random.nextInt(FirstOfOakWood1TypeInit.FIRST_OF_OAK_WOOD_1_TYPE_REGISTRY.getData().values().size())));
		this.setWood2Type(FirstOfOakWood2TypeInit.FIRST_OF_OAK_WOOD_2_TYPE_REGISTRY.getData().values().stream().toList().get(this.random.nextInt(FirstOfOakWood2TypeInit.FIRST_OF_OAK_WOOD_2_TYPE_REGISTRY.getData().values().size())));
		return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
	}
	
	protected void defineSynchedData() {
	    super.defineSynchedData();
		this.entityData.define(WOOD_1_TYPE, "oak");
		this.entityData.define(WOOD_2_TYPE, "oak");
	}
	
	public void addAdditionalSaveData(CompoundTag pCompound) {
		super.addAdditionalSaveData(pCompound);
		pCompound.putString("Wood1Type", this.getWood1Type().getName());
		pCompound.putString("Wood2Type", this.getWood2Type().getName());
	}

	public void readAdditionalSaveData(CompoundTag pCompound) {
		super.readAdditionalSaveData(pCompound);
		if (pCompound.contains("Wood1Type", 8)) {
			this.setWood1Type(FirstOfOakWood1TypeInit.getWood1TypeByName(pCompound.getString("Wood1Type")));
		}
		if (pCompound.contains("Wood2Type", 8)) {
			this.setWood2Type(FirstOfOakWood2TypeInit.getWood2TypeByName(pCompound.getString("Wood2Type")));
		}
	}
	
	public void setWood1Type(FirstOfOakWood1Type type) {
		this.entityData.set(WOOD_1_TYPE, type.getName());
	}

	public FirstOfOakWood1Type getWood1Type() {
		FirstOfOakWood1Type type = FirstOfOakWood1TypeInit.getWood1TypeByName(this.entityData.get(WOOD_1_TYPE));
		if (type == null) {
			this.setWood1Type(FirstOfOakWood1TypeInit.getWood1TypeByName("oak"));
			type = FirstOfOakWood1TypeInit.getWood1TypeByName(this.entityData.get(WOOD_1_TYPE));
		}
		return type;
	}
	
	public void setWood2Type(FirstOfOakWood2Type type) {
		this.entityData.set(WOOD_2_TYPE, type.getName());
	}

	public FirstOfOakWood2Type getWood2Type() {
		FirstOfOakWood2Type type = FirstOfOakWood2TypeInit.getWood2TypeByName(this.entityData.get(WOOD_2_TYPE));
		if (type == null) {
			this.setWood2Type(FirstOfOakWood2TypeInit.getWood2TypeByName("oak"));
			type = FirstOfOakWood2TypeInit.getWood2TypeByName(this.entityData.get(WOOD_2_TYPE));
		}
		return type;
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
			this.shootAnimationTick = this.shootAnimationLength;
			this.shootAnimationState.start(this.tickCount);
		} else {
			super.handleEntityEvent(p_219360_);
		}

	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 100.0D).add(Attributes.MOVEMENT_SPEED, 0.325D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 1D).add(Attributes.ATTACK_KNOCKBACK, 1D).add(Attributes.ATTACK_DAMAGE, 6D).add(Attributes.FOLLOW_RANGE, 40.0D);
	}
	
	@Override
	public void baseTick() {
		super.baseTick();

		if (this.level.isClientSide && this.getDeltaMovement().horizontalDistanceSqr() > (double) 2.5000003E-7F
				&& this.random.nextInt(5) == 0) {
			int i = Mth.floor(this.getX());
			int j = Mth.floor(this.getY() - (double) 0.2F);
			int k = Mth.floor(this.getZ());
			BlockPos pos = new BlockPos(i, j, k);
			BlockState blockstate = this.level.getBlockState(pos);
			if (!blockstate.isAir()) {
				this.level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, blockstate).setPos(pos),
						this.getX() + ((double) this.random.nextFloat() - 0.5D) * (double) this.getBbWidth(),
						this.getY() + 0.1D,
						this.getZ() + ((double) this.random.nextFloat() - 0.5D) * (double) this.getBbWidth(),
						4.0D * ((double) this.random.nextFloat() - 0.5D), 0.5D,
						((double) this.random.nextFloat() - 0.5D) * 4.0D);
			}
		}
		
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
