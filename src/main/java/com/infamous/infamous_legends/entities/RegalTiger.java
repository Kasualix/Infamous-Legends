package com.infamous.infamous_legends.entities;

import java.util.UUID;

import javax.annotation.Nullable;

import com.infamous.infamous_legends.ai.goals.ApproachTargetGoal;
import com.infamous.infamous_legends.ai.goals.LookAtTargetGoal;
import com.infamous.infamous_legends.ai.goals.RegalTigerPounceAttackGoal;
import com.infamous.infamous_legends.ai.goals.RegalTigerSitGoal;
import com.infamous.infamous_legends.init.EntityTypeInit;
import com.infamous.infamous_legends.init.TagInit;
import com.infamous.infamous_legends.utils.MiscUtils;
import com.infamous.infamous_legends.utils.PositionUtils;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PlayerRideableJumping;
import net.minecraft.world.entity.Saddleable;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class RegalTiger extends Animal implements PlayerRideableJumping, Saddleable {

	private static final EntityDataAccessor<Boolean> SADDLED = SynchedEntityData
			.defineId(RegalTiger.class, EntityDataSerializers.BOOLEAN);
	
	private static final EntityDataAccessor<Boolean> SITTING = SynchedEntityData
			.defineId(RegalTiger.class, EntityDataSerializers.BOOLEAN);
	
	public AnimationState attackAnimationState = new AnimationState();
	public int attackAnimationTick;
	public final int attackAnimationLength = 30;
	public final int attackAnimationActionPoint = 24;
	
	public AnimationState sitAnimationState = new AnimationState();
	public int sitAnimationTick;
	public final int sitAnimationLength = 12;
	
	public AnimationState cleanAnimationState = new AnimationState();
	public int cleanAnimationTick;
	public final int cleanAnimationLength = 150;
	
	public AnimationState standAnimationState = new AnimationState();
	public int standAnimationTick;
	public final int standAnimationLength = 16;
	
	public boolean pounceWasOrdered;
	public double orderedPounceSpeed;
	public float orderedPounceDamage;
	
	public int orderedPounceCooldown;
	
	public RegalTiger(EntityType<? extends RegalTiger> type, Level level) {
		super(type, level);		
	}
	
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(0, new RegalTigerSitGoal(this));
		this.goalSelector.addGoal(1, new RegalTigerPounceAttackGoal(this) {
			@Override
			public boolean canUse() {
				return !RegalTiger.this.isBaby() && super.canUse();
			}
		});
		this.goalSelector.addGoal(2, new LookAtTargetGoal(this) {
			@Override
			public boolean canUse() {
				return !RegalTiger.this.isBaby() && super.canUse();
			}
		});
		this.goalSelector.addGoal(3, new ApproachTargetGoal(this, 6, 1.4, true) {
			@Override
			public boolean canUse() {
				return !RegalTiger.this.isBaby() && super.canUse();
			}
		});
		this.goalSelector.addGoal(4, new BreedGoal(this, 0.6D));
		this.goalSelector.addGoal(5, new TemptGoal(this, 0.8D, Ingredient.of(TagInit.Items.REGAL_TIGER_BRED_WITH), false));
		this.goalSelector.addGoal(6, new FollowParentGoal(this, 1.4D) {
			@Override
			public boolean canUse() {
				return !RegalTiger.this.isSitting() && super.canUse();
			}
		});
		this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 0.6D));
		this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Creeper.class, true) {
			@Override
			public boolean canUse() {
				return !RegalTiger.this.isBaby() && !RegalTiger.this.isVehicle() && super.canUse();
			}
		});
	}
	
	@Override
	public boolean hurt(DamageSource pSource, float pAmount) {
		if (!this.level.isClientSide && this.isSitting()) {
			this.standAnimationTick = this.standAnimationLength;
			this.level.broadcastEntityEvent(this, (byte) 9);
		}
		return super.hurt(pSource, pAmount);
	}
	   
	   @Override
	public float getStepHeight() {
		return 1;
	}
	   
	   @Override
	public double getPassengersRidingOffset() {
		return 15 / 16.0D;
	}

		   public static AttributeSupplier.Builder createAttributes() {
		      return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 40.0D).add(Attributes.FOLLOW_RANGE, 18.0D).add(Attributes.MOVEMENT_SPEED, 0.325D);
		   }
		   
		   @Override
		public float getVoicePitch() {
			return super.getVoicePitch() * 0.5F;
		}
		   
		   protected SoundEvent getAmbientSound() {
			      return SoundEvents.POLAR_BEAR_AMBIENT;
			   }

			   protected SoundEvent getHurtSound(DamageSource pDamageSource) {
			      return SoundEvents.POLAR_BEAR_HURT;
			   }

			   protected SoundEvent getDeathSound() {
			      return SoundEvents.POLAR_BEAR_DEATH;
			   }

			   protected void playStepSound(BlockPos pPos, BlockState pBlock) {
			      this.playSound(SoundEvents.POLAR_BEAR_STEP, 0.25F, 0.5F);
			   }
		   
	   public void travel(Vec3 pTravelVector) {
		      if (this.isAlive()) {
		         LivingEntity livingentity = this.getControllingPassenger();
		         if (this.isVehicle() && livingentity != null && this.attackAnimationTick <= 0) {
					this.setYRot(livingentity.getYRot());
					this.yRotO = this.getYRot();
		            this.setXRot(livingentity.getXRot() * 0.5F);
		            this.setRot(this.getYRot(), this.getXRot());
		            this.yBodyRot = this.getYRot();
		            this.yHeadRot = this.yBodyRot;
		            float f = livingentity.xxa * 0.5F;
		            float f1 = livingentity.zza;
		            if (f1 <= 0.0F) {
		               f1 *= 0.25F;
		            }

		            this.flyingSpeed = this.getSpeed() * 0.1F;
		            if (this.isControlledByLocalInstance()) {
		               this.setSpeed((float)this.getAttributeValue(Attributes.MOVEMENT_SPEED));
		               super.travel(new Vec3((double)f, pTravelVector.y, (double)f1));
		            } else if (livingentity instanceof Player) {
		               this.setDeltaMovement(Vec3.ZERO);
		            }

		            this.calculateEntityAnimation(this, false);
		            this.tryCheckInsideBlocks();
		         } else {
		            this.flyingSpeed = 0.02F;
		            super.travel(pTravelVector);
		         }
		      }
		   }
	
	   @Nullable
	   public LivingEntity getControllingPassenger() {
	      if (this.isSaddled()) {
	         Entity entity = this.getFirstPassenger();
	         if (entity instanceof LivingEntity) {
	            return (LivingEntity)entity;
	         }
	      }

	      return null;
	   }
	   
	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SADDLED, false);
		this.entityData.define(SITTING, false);
	}
	
	@Override
	public void addAdditionalSaveData(CompoundTag p_21484_) {
		super.addAdditionalSaveData(p_21484_);
		p_21484_.putBoolean("Saddled", this.getSaddled());
		p_21484_.putBoolean("Sitting", this.isSitting());
	}
	
	@Override
	public void readAdditionalSaveData(CompoundTag p_21450_) {
		super.readAdditionalSaveData(p_21450_);
		this.setSaddled(p_21450_.getBoolean("Saddled"));
		this.setSitting(p_21450_.getBoolean("Sitting"));
	}
	   
	   public boolean getSaddled() {
		   return this.entityData.get(SADDLED);
	   }
	   
	   public void setSaddled(boolean value) {
		   this.entityData.set(SADDLED, value);
	   }
	   
	   public boolean isSitting() {
		   return this.entityData.get(SITTING);
	   }
	   
	   public void setSitting(boolean value) {
		   this.entityData.set(SITTING, value);
	   }
	   
	   @Override
	public boolean isFood(ItemStack pStack) {
		return pStack.is(TagInit.Items.REGAL_TIGER_BRED_WITH);
	}
	   
		public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
			boolean flag = this.isFood(pPlayer.getItemInHand(pHand));
			if (this.isSitting() && pPlayer.getItemInHand(pHand).isEmpty()) {
				if (!this.level.isClientSide) {
					this.standAnimationTick = this.standAnimationLength;
					this.level.broadcastEntityEvent(this, (byte) 9);
				}
				
				return InteractionResult.sidedSuccess(this.level.isClientSide);
			} else if (!flag && !pPlayer.getItemInHand(pHand).is(TagInit.Items.HEALS_REGAL_TIGER) && this.isSaddled() && !this.isVehicle() && !pPlayer.isSecondaryUseActive()) {
				if (!this.level.isClientSide) {
					pPlayer.startRiding(this);
				}

				return InteractionResult.sidedSuccess(this.level.isClientSide);
			} else {
				InteractionResult interactionresult = super.mobInteract(pPlayer, pHand);
				if (!interactionresult.consumesAction()) {
					ItemStack itemstack = pPlayer.getItemInHand(pHand);
					if (pPlayer.getItemInHand(pHand).is(TagInit.Items.HEALS_REGAL_TIGER) && this.getHealth() < this.getMaxHealth()) {
						this.heal(3);
						this.playSound(SoundEvents.CAT_EAT, 1.0F, MiscUtils.randomSoundPitch() * 0.5F);
						return InteractionResult.sidedSuccess(this.level.isClientSide);
					} else {
						if (pHand == InteractionHand.MAIN_HAND && this.isSaddled() && pPlayer.isCrouching() && pPlayer.getItemInHand(pHand).isEmpty()) {
							pPlayer.setItemInHand(pHand, new ItemStack(Items.SADDLE));
							this.playSound(SoundEvents.PIG_SADDLE, 0.5F, 1.0F);
							this.setSaddled(false);
							return InteractionResult.sidedSuccess(this.level.isClientSide);
						} else {
							return itemstack.is(Items.SADDLE) ? itemstack.interactLivingEntity(pPlayer, this, pHand)
									: InteractionResult.PASS;
						}
					}
				} else {
					return interactionresult;
				}
			}
		}
		
		@Override
		public void setInLove(Player pPlayer) {
			this.playSound(SoundEvents.CAT_EAT, 1.0F, MiscUtils.randomSoundPitch() * 0.5F);
			super.setInLove(pPlayer);
		}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
		return EntityTypeInit.REGAL_TIGER.get().create(pLevel);
	}
	
	protected void dropEquipment() {
		super.dropEquipment();
		if (this.isSaddled()) {
			this.spawnAtLocation(Items.SADDLE);
		}

	}

	@Override
	public boolean isSaddleable() {
		return this.isAlive() && !this.isBaby();
	}

	@Override
	public void equipSaddle(SoundSource pSource) {
		this.setSaddled(true);
		if (pSource != null) {
			this.level.playSound((Player) null, this, SoundEvents.PIG_SADDLE, pSource, 0.5F, 1.0F);
		}
	}

	@Override
	public boolean isSaddled() {
		return this.getSaddled();
	}

	@Override
	public void onPlayerJump(int pJumpPower) {
		if (this.orderedPounceCooldown <= 0 && this.isOnGround() && this.attackAnimationTick <= 0) {
			this.orderedPounceDamage = pJumpPower / 10;
			this.orderedPounceSpeed = pJumpPower / 20;
			this.pounceWasOrdered = true;
		}
	}

	@Override
	public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
		return false;
	}
	   
	@Override
	public boolean canJump() {
		return this.isSaddled() && this.orderedPounceCooldown <= 0 && this.attackAnimationTick <= 0;
	}

	@Override
	public void handleStartJump(int pJumpPower) {
		if (this.orderedPounceCooldown <= 0 && this.isOnGround() && this.attackAnimationTick <= 0) {
			this.level.broadcastEntityEvent(this, (byte) 4);
			this.attackAnimationTick = this.attackAnimationLength;
			this.orderedPounceDamage = pJumpPower / 10;
			this.orderedPounceSpeed = pJumpPower / 30;
			this.pounceWasOrdered = true;
		}
	}
	
	@Override
	public void baseTick() {
		super.baseTick();

		if (this.attackAnimationTick > 0) {
			this.attackAnimationTick--;
		}
		
		if (this.level.isClientSide && this.attackAnimationTick <= 0) {
			this.attackAnimationState.stop();
		}
		
		if (this.sitAnimationTick > 0) {
			this.sitAnimationTick--;
		}
		
		if (this.level.isClientSide && this.sitAnimationTick <= 0) {
			this.sitAnimationState.stop();
		}
		
		if (this.cleanAnimationTick > 0) {
			this.cleanAnimationTick--;
		}
		
		if (this.level.isClientSide && this.cleanAnimationTick <= 0) {
			this.cleanAnimationState.stop();
		}
		
		if (this.standAnimationTick > 0) {
			this.standAnimationTick--;
		}
		
		if (this.level.isClientSide && this.standAnimationTick <= 0) {
			this.standAnimationState.stop();
		}
		
		if (this.pounceWasOrdered && this.attackAnimationTick > this.attackAnimationActionPoint) {
			this.setDeltaMovement(0, this.getDeltaMovement().y, 0);
			this.getNavigation().stop();
		}
		
		if (this.pounceWasOrdered && this.isOnGround() && this.attackAnimationTick == this.attackAnimationActionPoint) {
			this.setDeltaMovement(this.getDeltaMovement().add(PositionUtils.getOffsetMotion(this, 0, 0.35, this.orderedPounceSpeed, this.yBodyRot)));
		}
		
		if (!this.level.isClientSide && this.pounceWasOrdered && this.attackAnimationTick < this.attackAnimationActionPoint && this.attackAnimationTick >= this.attackAnimationLength - 17) {
			for (LivingEntity entity : this.level.getNearbyEntities(LivingEntity.class, TargetingConditions.forCombat(), this, this.getBoundingBox().inflate(0.1))) {
				boolean entityIsPassenger = !this.getPassengers().isEmpty() && this.getPassengers().contains(entity);
				if (entity != this && !entityIsPassenger) {
					entity.hurt(DamageSource.mobAttack(this), this.orderedPounceDamage);
					entity.hurtMarked = true;
					entity.setDeltaMovement(entity.getDeltaMovement().add(this.getDeltaMovement()));
				}
			}
		}
		
		if (this.pounceWasOrdered && this.attackAnimationTick == 1) {
			this.pounceWasOrdered = false;
			this.orderedPounceDamage = 0;
			this.orderedPounceSpeed = 0;
			this.orderedPounceCooldown = 60;
		}
		
		if (this.orderedPounceCooldown > 0) {
			this.orderedPounceCooldown --;
		}
	}
	
	public void handleEntityEvent(byte p_219360_) {
		if (p_219360_ == 4) {
			this.attackAnimationTick = this.attackAnimationLength;
			this.attackAnimationState.start(this.tickCount);
		} else if (p_219360_ == 11) {
			this.sitAnimationTick = this.sitAnimationLength;
			this.sitAnimationState.start(this.tickCount);
		} else if (p_219360_ == 8) {
			this.cleanAnimationTick = this.cleanAnimationLength;
			this.cleanAnimationState.start(this.tickCount);
		} else if (p_219360_ == 9) {
			this.standAnimationTick = this.standAnimationLength;
			this.standAnimationState.start(this.tickCount);
			this.sitAnimationTick = 0;
			this.cleanAnimationTick = 0;
			this.sitAnimationState.stop();
			this.cleanAnimationState.stop();
		} else {
			super.handleEntityEvent(p_219360_);
		}

	}

	@Override
	public void handleStopJump() {
		
	}

}
