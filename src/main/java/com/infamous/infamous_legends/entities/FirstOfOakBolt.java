package com.infamous.infamous_legends.entities;

import com.infamous.infamous_legends.golem_types.FirstOfOakWood1Type;
import com.infamous.infamous_legends.init.EntityTypeInit;
import com.infamous.infamous_legends.init.FirstOfOakWood1TypeInit;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.utils.MiscUtils;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.NetworkHooks;

public class FirstOfOakBolt extends AbstractArrow {

	private static final EntityDataAccessor<String> TYPE = SynchedEntityData.defineId(FirstOfOakBolt.class, EntityDataSerializers.STRING);
	
	private int life;
	   
	public FirstOfOakBolt(EntityType<? extends FirstOfOakBolt> p_37561_, Level p_37562_) {
		super(p_37561_, p_37562_);
		this.pickup = AbstractArrow.Pickup.DISALLOWED;
	}

	public FirstOfOakBolt(Level p_37569_, LivingEntity p_37570_) {
		super(EntityTypeInit.FIRST_OF_OAK_BOLT.get(), p_37570_, p_37569_);
		this.pickup = AbstractArrow.Pickup.DISALLOWED;
	}
	
	protected void defineSynchedData() {
	    super.defineSynchedData();
		this.entityData.define(TYPE, "oak");
	}
	
	public void addAdditionalSaveData(CompoundTag pCompound) {
		super.addAdditionalSaveData(pCompound);
		pCompound.putString("Type", this.getWoodType().getName());
	}

	public void readAdditionalSaveData(CompoundTag pCompound) {
		super.readAdditionalSaveData(pCompound);
		if (pCompound.contains("Type", 8)) {
			this.setType(FirstOfOakWood1TypeInit.getWood1TypeByName(pCompound.getString("Type")));
		}
	}
	
	public void setType(FirstOfOakWood1Type type) {
		this.entityData.set(TYPE, type.getName());
	}

	public FirstOfOakWood1Type getWoodType() {
		FirstOfOakWood1Type type = FirstOfOakWood1TypeInit.getWood1TypeByName(this.entityData.get(TYPE));
		if (type == null) {
			this.setType(FirstOfOakWood1TypeInit.getWood1TypeByName("oak"));
			type = FirstOfOakWood1TypeInit.getWood1TypeByName(this.entityData.get(TYPE));
		}
		return type;
	}
	
	@Override
	protected boolean canHitEntity(Entity p_36743_) {
		boolean mobThatCantBeHurt = this.getOwner() != null && this.getOwner() instanceof FirstOfOak
				&& MiscUtils.nonEnemy(this.getOwner(), p_36743_);
		return !mobThatCantBeHurt && super.canHitEntity(p_36743_);
	}
	
	@Override
	protected void onHit(HitResult pResult) {
		super.onHit(pResult);
		if (!this.level.isClientSide) {
			((ServerLevel)this.level).sendParticles(ParticleTypeInit.DUST.get(), this.getX(), this.getY(), this.getZ(), 5, 0, 0, 0, 1);
			this.playSound(SoundEvents.GENERIC_EXPLODE, 1.0F, MiscUtils.randomSoundPitch() * 1.25F);
		}
	}
	
	protected void onHitEntity(EntityHitResult p_37573_) {
		if (!this.level.isClientSide) {
			Entity entity = p_37573_.getEntity();
			float f = 35F;
			Entity entity1 = this.getOwner();
			DamageSource damagesource = DamageSource.arrow(this, (Entity) (entity1 == null ? this : entity1));
			SoundEvent soundevent = SoundEvents.ARROW_HIT;
			if (entity.hurt(damagesource, f)) {
				if (entity.getType() == EntityType.ENDERMAN) {
					return;
				}
			}
	
			this.discard();
			
			this.playSound(soundevent, 1.0F, MiscUtils.randomSoundPitch() * 0.75F);
		}
	}

	@Override
	protected boolean tryPickup(Player pPlayer) {
		return false;
	}

	@Override
	protected ItemStack getPickupItem() {
		return null;
	}
	
	   @Override
		protected void tickDespawn() {
			++this.life;
			if (this.life >= 200) {
				this.discard();
			}
		}
	   
	   @Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
