package com.infamous.infamous_legends.entities;

import javax.annotation.Nullable;

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
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PlayerRideableJumping;
import net.minecraft.world.entity.Saddleable;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class BigBeak extends Animal implements PlayerRideableJumping, Saddleable {

	private static final EntityDataAccessor<Boolean> SADDLED = SynchedEntityData
			.defineId(BigBeak.class, EntityDataSerializers.BOOLEAN);
	
	private static final EntityDataAccessor<Boolean> JUMPING = SynchedEntityData
			.defineId(BigBeak.class, EntityDataSerializers.BOOLEAN);
	
	private static final EntityDataAccessor<Boolean> GLIDING = SynchedEntityData
			.defineId(BigBeak.class, EntityDataSerializers.BOOLEAN);
	
	public double glideSpeed;
	
	public float glidingYRot;
	
	public int timeUntilStopJumpingAllowed;
	
	public BigBeak(EntityType<? extends BigBeak> type, Level level) {
		super(type, level);		
	}
	
	   protected void registerGoals() {
		      this.goalSelector.addGoal(0, new FloatGoal(this));
		      this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		      this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));
		      this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, Ingredient.of(TagInit.Items.BIG_BEAK_BRED_WITH), false));
		      this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1D));
		      this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		      this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
		      this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		   }
	   
	   @Override
	public float getStepHeight() {
		return 1;
	}
	   
	   @Override
	public double getPassengersRidingOffset() {
		return 22 / 16.0D;
	}

		   public static AttributeSupplier.Builder createAttributes() {
		      return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 30.0D).add(Attributes.MOVEMENT_SPEED, 0.2D);
		   }
		   
		   @Override
		public float getVoicePitch() {
			return super.getVoicePitch() * 0.25F;
		}
		   
		   protected SoundEvent getAmbientSound() {
			      return SoundEvents.PARROT_AMBIENT;
			   }

			   protected SoundEvent getHurtSound(DamageSource pDamageSource) {
			      return SoundEvents.PARROT_HURT;
			   }

			   protected SoundEvent getDeathSound() {
			      return SoundEvents.PARROT_DEATH;
			   }

			   protected void playStepSound(BlockPos pPos, BlockState pBlock) {
			      this.playSound(SoundEvents.PARROT_STEP, 0.25F, 0.5F);
			   }
		   
	   public void travel(Vec3 pTravelVector) {
		      if (this.isAlive()) {
		         LivingEntity livingentity = this.getControllingPassenger();
		         if (this.isVehicle() && livingentity != null) {
		        	 if (this.isGliding()) {
		        		 this.glidingYRot = Mth.lerp(0.05F, glidingYRot, livingentity.getYRot());
		        	 }
					this.setYRot(this.isGliding() ? Mth.wrapDegrees(glidingYRot) : livingentity.getYRot());
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
		this.entityData.define(JUMPING, false);
		this.entityData.define(GLIDING, false);
	}
	
	@Override
	public void addAdditionalSaveData(CompoundTag p_21484_) {
		super.addAdditionalSaveData(p_21484_);
		p_21484_.putBoolean("Saddled", this.getSaddled());
		p_21484_.putBoolean("IsJumping", this.isJumping());
		p_21484_.putBoolean("IsGliding", this.isGliding());
	}
	
	@Override
	public void readAdditionalSaveData(CompoundTag p_21450_) {
		super.readAdditionalSaveData(p_21450_);
		this.setSaddled(p_21450_.getBoolean("Saddled"));
		this.setJumpingData(p_21450_.getBoolean("IsJumping"));
		this.setGliding(p_21450_.getBoolean("IsGliding"));
	}
	   
	   public boolean getSaddled() {
		   return this.entityData.get(SADDLED);
	   }
	   
	   public void setSaddled(boolean value) {
		   this.entityData.set(SADDLED, value);
	   }
	   
	   public boolean isJumping() {
		   return this.entityData.get(JUMPING);
	   }
	   
	   public void setJumpingData(boolean value) {
		   this.entityData.set(JUMPING, value);
	   }
	   
	   public boolean isGliding() {
		   return this.entityData.get(GLIDING);
	   }
	   
	   public void setGliding(boolean value) {
		   this.entityData.set(GLIDING, value);
	   }
	   
	   @Override
	public boolean isFood(ItemStack pStack) {
		return pStack.is(TagInit.Items.BIG_BEAK_BRED_WITH);
	}
	   
		public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
			boolean flag = this.isFood(pPlayer.getItemInHand(pHand));
			if (!flag && !pPlayer.getItemInHand(pHand).is(TagInit.Items.HEALS_BIG_BEAK) && this.isSaddled() && !this.isVehicle() && !pPlayer.isSecondaryUseActive()) {
				if (!this.level.isClientSide) {
					pPlayer.startRiding(this);
				}

				return InteractionResult.sidedSuccess(this.level.isClientSide);
			} else {
				InteractionResult interactionresult = super.mobInteract(pPlayer, pHand);
				if (!interactionresult.consumesAction()) {
					ItemStack itemstack = pPlayer.getItemInHand(pHand);
					if (pPlayer.getItemInHand(pHand).is(TagInit.Items.HEALS_BIG_BEAK) && this.getHealth() < this.getMaxHealth()) {
						this.heal(3);
						this.playSound(SoundEvents.PARROT_EAT, 1.0F, MiscUtils.randomSoundPitch() * 0.75F);
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
	public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
		return EntityTypeInit.BIG_BEAK.get().create(pLevel);
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
		if (!this.isInWater()) {
			if (this.isOnGround()) {
				this.timeUntilStopJumpingAllowed = 2;
				this.setOnGround(false);
				this.setDeltaMovement(this.getDeltaMovement().add(0, pJumpPower * 0.0125, 0));
				this.setJumpingData(true);
			} else {
				if (!this.isGliding()) {
					this.hasImpulse = true;
					this.setJumpingData(false);
					this.glideSpeed = pJumpPower * 0.0065;
					this.setDeltaMovement(this.getDeltaMovement().add(PositionUtils.getOffsetMotion(this, 0, 0, this.glideSpeed, this.yBodyRot)));
					this.setGliding(true);
			         LivingEntity livingentity = this.getControllingPassenger();
			         if (this.isVehicle() && livingentity != null) {
		        		this.glidingYRot = livingentity.getYRot();
						this.setYRot(this.isGliding() ? Mth.wrapDegrees(glidingYRot) : livingentity.getYRot());
						this.yRotO = this.getYRot();
			         }
				}
			}
		}
	}

	@Override
	public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
	      if (pFallDistance > 1.0F) {
	          this.playSound(SoundEvents.HORSE_LAND, 0.4F, 1.25F);
	       }
		return false;
	}
	   
	@Override
	public boolean canJump() {
		return this.isSaddled();
	}

	@Override
	public void handleStartJump(int pJumpPower) {
		if (!this.isInWater()) {
			if (this.isOnGround()) {
				this.timeUntilStopJumpingAllowed = 2;
				this.setJumpingData(true);
				this.playSound(SoundEvents.GOAT_LONG_JUMP, 0.4F, 1.0F);
			} else {
				if (!this.isGliding()) {
					this.setJumpingData(false);
					this.setGliding(true);
					this.playSound(SoundEvents.BAT_TAKEOFF, 0.5F, MiscUtils.randomSoundPitch() * 0.5F);
				}
			}
		}
	}
	
	@Override
	public void baseTick() {
		super.baseTick();
		
		if (this.timeUntilStopJumpingAllowed > 0) {
			this.timeUntilStopJumpingAllowed --;
		}
		
		if (this.timeUntilStopJumpingAllowed <= 0 && (this.isOnGround() || this.isInWater()) && (this.isJumping() || this.isGliding())) {
			this.setJumpingData(false);
			this.setGliding(false);
		}
		
	      if (this.isGliding()) {
	    	  Vec3 offsetMotion = PositionUtils.getOffsetMotion(this, 0, 0, this.glideSpeed, this.yBodyRot);
	    	 this.setDeltaMovement(new Vec3(offsetMotion.x, this.getDeltaMovement().y, offsetMotion.z));
	    	 if (this.getDeltaMovement().y < 0.0D) {
	    		 this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.65D, 1.0D));
	    	 }
	      }
	}

	@Override
	public void handleStopJump() {
		
	}

}
