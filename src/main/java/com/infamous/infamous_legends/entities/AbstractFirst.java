package com.infamous.infamous_legends.entities;

import java.util.EnumSet;

import com.infamous.infamous_legends.init.ItemInit;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public abstract class AbstractFirst extends AbstractGolem {

	private static final EntityDataAccessor<Boolean> AWAKENED = SynchedEntityData.defineId(AbstractFirst.class, EntityDataSerializers.BOOLEAN);
	
	public AnimationState inactiveAnimationState = new AnimationState();
	public AnimationState awakenAnimationState = new AnimationState();
	public int awakenAnimationTick;
	
	public AbstractFirst(EntityType<? extends AbstractFirst> type, Level level) {
		super(type, level);		
	}
	
	   protected void registerGoals() {
		      this.goalSelector.addGoal(0, new AbstractFirst.DoNothingGoal());
		   }
	
	public abstract int getAwakenAnimationLength();
	
	protected void defineSynchedData() {
	    super.defineSynchedData();
		this.entityData.define(AWAKENED, false);
	}
	
	public void addAdditionalSaveData(CompoundTag pCompound) {
		super.addAdditionalSaveData(pCompound);
		pCompound.putBoolean("Awakened", this.isAwakened());
	}

	public void readAdditionalSaveData(CompoundTag pCompound) {
		super.readAdditionalSaveData(pCompound);
		this.setAwakened(pCompound.getBoolean("Awakened"));
	}
	
	public void setAwakened(boolean value) {
		this.entityData.set(AWAKENED, value);
	}

	public boolean getAwakened() {
		return this.entityData.get(AWAKENED);
	}
	
	public boolean isAwakened() {
		return this.getAwakened() && this.awakenAnimationTick <= 0;
	}
	
	@Override
	public void baseTick() {
		super.baseTick();

		if (this.awakenAnimationTick > 0) {
			this.awakenAnimationTick--;
		}
		
		if (this.awakenAnimationTick <= 0 && this.awakenAnimationState.isStarted()) {
			this.awakenAnimationState.stop();
		}
		
		if (!this.getAwakened() && this.awakenAnimationTick <= 0) {
			this.inactiveAnimationState.startIfStopped(this.tickCount);
		} else if (this.isAwakened() && this.inactiveAnimationState.isStarted()) {
			this.inactiveAnimationState.stop();
		}
	}
	
	@Override
	protected InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
		if (pHand == InteractionHand.MAIN_HAND && !this.getAwakened() && this.awakenAnimationTick <= 0 && ((pPlayer.getItemInHand(pHand).isEmpty() && pPlayer.getAbilities().instabuild)) || (pPlayer.getItemInHand(pHand).getItem() == ItemInit.PRIMORDIAL_HEART.get() && !pPlayer.getAbilities().instabuild)) {
			this.setAwakened(true);
			this.awakenAnimationState.start(this.tickCount);
			this.inactiveAnimationState.stop();
			this.awakenAnimationTick = this.getAwakenAnimationLength();
			if (!pPlayer.getAbilities().instabuild) {
				pPlayer.getItemInHand(pHand).shrink(1);
			}
			return InteractionResult.SUCCESS;
		} else {
			return super.mobInteract(pPlayer, pHand);
		}
	}
	
	@Override
	public boolean isInvulnerable() {
		return !this.isAwakened();
	}
	
	@Override
	public boolean hurt(DamageSource pSource, float pAmount) {
		if (!this.isAwakened() && pSource != DamageSource.OUT_OF_WORLD) {
			return false;
		} else {
			return super.hurt(pSource, pAmount);
		}
	}
	
	public void setDeltaMovement(Vec3 vec) {
		super.setDeltaMovement(new Vec3(!this.isAwakened() ? 0 : vec.x, vec.y, !this.isAwakened() ? 0 : vec.z));
	}
	
	   class DoNothingGoal extends Goal {
		      public DoNothingGoal() {
		         this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
		      }

		      /**
		       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		       * method as well.
		       */
		      public boolean canUse() {
		         return !AbstractFirst.this.isAwakened();
		      }
		   }
}
