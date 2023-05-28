package com.infamous.infamous_legends.entities;

import com.infamous.infamous_legends.ai.goals.ApproachTargetGoal;
import com.infamous.infamous_legends.ai.goals.BadgerGoToAlertPosGoal;
import com.infamous.infamous_legends.ai.goals.BadgerMeleeAttackGoal;
import com.infamous.infamous_legends.ai.goals.LookAtTargetGoal;
import com.infamous.infamous_legends.init.EntityTypeInit;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
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
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class Badger extends Animal {

	public AnimationState attackAnimationState = new AnimationState();
	public int attackAnimationTick;
	public final int attackAnimationLength = 16;
	public final int attackAnimationActionPoint = 9;
	
	public AnimationState alertAnimationState = new AnimationState();
	
	public BlockPos alertPos;
	public int timeUntilAlertPosReset;
	
	   public Badger(EntityType<? extends Badger> pEntityType, Level pLevel) {
		      super(pEntityType, pLevel);
		   }

	   protected void registerGoals() {
			this.goalSelector.addGoal(0, new FloatGoal(this));
			this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
			this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
			this.goalSelector.addGoal(3, new BadgerGoToAlertPosGoal(this));
			this.goalSelector.addGoal(4, new TemptGoal(this, 1.25D, Ingredient.of(Items.RABBIT), false));
			this.goalSelector.addGoal(5, new BadgerMeleeAttackGoal(this));
			this.goalSelector.addGoal(6, new LookAtTargetGoal(this));
			this.goalSelector.addGoal(7, new ApproachTargetGoal(this, 0, 1.2, true));
			this.goalSelector.addGoal(8, new FollowParentGoal(this, 1.25D));
			this.goalSelector.addGoal(9, new WaterAvoidingRandomStrollGoal(this, 1.0D));
			this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 6.0F));
			this.goalSelector.addGoal(11, new RandomLookAroundGoal(this));
			this.targetSelector.addGoal(0, (new HurtByTargetGoal(this)).setAlertOthers());
			this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Rabbit.class, false));
		}
	   
	   @Override
	public boolean isFood(ItemStack pStack) {
		return pStack.is(Items.RABBIT);
	}

		   public static AttributeSupplier.Builder createAttributes() {
		      return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 15.0D).add(Attributes.MOVEMENT_SPEED, 0.275D).add(Attributes.FOLLOW_RANGE, 15D).add(Attributes.ATTACK_DAMAGE, 2D);
		   }

	@Override
	public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
		return EntityTypeInit.BADGER.get().create(pLevel);
	}
	
	@Override
	public void baseTick() {
		super.baseTick();

		if (this.attackAnimationTick > 0) {
			this.attackAnimationTick--;
		}
		
		if (this.attackAnimationTick <= 0 && this.attackAnimationState.isStarted()) {
			this.attackAnimationState.stop();
		}
		
		if (this.timeUntilAlertPosReset > 0) {
			this.timeUntilAlertPosReset --;
		} else {
			this.alertPos = null;
		}
		
		if (!this.level.isClientSide && this.alertPos != null && !this.alertAnimationState.isStarted()) {
			this.alertAnimationState.start(this.tickCount);
			this.level.broadcastEntityEvent(this, (byte) 9);
		}
		
		if (!this.level.isClientSide && this.alertPos == null && this.alertAnimationState.isStarted()) {
			this.alertAnimationState.stop();
			this.level.broadcastEntityEvent(this, (byte) 10);
		}
	}

	public void handleEntityEvent(byte p_219360_) {
		if (p_219360_ == 4) {
			this.attackAnimationTick = this.attackAnimationLength;
			this.attackAnimationState.start(this.tickCount);
		} else if (p_219360_ == 9) {
			this.alertAnimationState.start(this.tickCount);
		} else if (p_219360_ == 10) {
			this.alertAnimationState.stop();
		} else {
			super.handleEntityEvent(p_219360_);
		}

	}
}
