package com.infamous.infamous_legends.entities;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;
import com.infamous.infamous_legends.events.ShakeCameraEvent;
import com.infamous.infamous_legends.init.EntityTypeInit;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.utils.MiscUtils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;

public class BoulderProjectile extends ThrowableProjectile {
	
	private static final List<EntityDataAccessor<Optional<BlockState>>> BLOCK_STATES = Lists.newArrayList(SynchedEntityData
			.defineId(BoulderProjectile.class, EntityDataSerializers.BLOCK_STATE), SynchedEntityData
			.defineId(BoulderProjectile.class, EntityDataSerializers.BLOCK_STATE), SynchedEntityData
			.defineId(BoulderProjectile.class, EntityDataSerializers.BLOCK_STATE), SynchedEntityData
			.defineId(BoulderProjectile.class, EntityDataSerializers.BLOCK_STATE), SynchedEntityData
			.defineId(BoulderProjectile.class, EntityDataSerializers.BLOCK_STATE), SynchedEntityData
			.defineId(BoulderProjectile.class, EntityDataSerializers.BLOCK_STATE), SynchedEntityData
			.defineId(BoulderProjectile.class, EntityDataSerializers.BLOCK_STATE), SynchedEntityData
			.defineId(BoulderProjectile.class, EntityDataSerializers.BLOCK_STATE));
	
    protected static final EntityDataAccessor<BlockPos> START_POS = SynchedEntityData.defineId(BoulderProjectile.class, EntityDataSerializers.BLOCK_POS);
	   
	public Explosion.BlockInteraction blockInteraction = Explosion.BlockInteraction.DESTROY;

	   public BoulderProjectile(EntityType<? extends BoulderProjectile> p_37391_, Level p_37392_) {
		      super(p_37391_, p_37392_);
		      this.setStartPos(this.blockPosition());
		   }

		   public BoulderProjectile(Level p_37399_, LivingEntity p_37400_) {
		      super(EntityTypeInit.BOULDER_PROJECTILE.get(), p_37400_, p_37399_);
		      this.setStartPos(this.blockPosition());
		   }

		   public BoulderProjectile(Level p_37394_, double p_37395_, double p_37396_, double p_37397_) {
		      super(EntityTypeInit.BOULDER_PROJECTILE.get(), p_37395_, p_37396_, p_37397_, p_37394_);
		      this.setStartPos(this.blockPosition());
		   }
		   
			public void setStartPos(BlockPos pStartPos) {
				this.entityData.set(START_POS, pStartPos);
			}

			public BlockPos getStartPos() {
				return this.entityData.get(START_POS);
			}
		   
		   public Optional<BlockState> getBlockState(int stateIndex) {
			   return this.entityData.get(BLOCK_STATES.get(stateIndex));
		   }
		   
		   public void setBlockState(BlockState newState, int stateIndex) {
			   this.entityData.set(BLOCK_STATES.get(stateIndex), Optional.of(newState));
		   }
		   
		   @Override
		public void tick() {
			super.tick();				
			if (this.level.isClientSide) {
				for (int i = 0; i < 4; i++) {
					this.level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, this.getBlockState(this.random.nextInt(8)).get()), this.getRandomX(0.5F), this.getRandomY(), this.getRandomZ(0.5F), 0, 0, 0);
				}
			}
		}
		   
			@Override
			protected boolean canHitEntity(Entity p_36743_) {
				boolean mobThatCantBeHurt = this.getOwner() != null && this.getOwner() instanceof FirstOfStone
						&& MiscUtils.nonEnemy(this.getOwner(), p_36743_);
				return !mobThatCantBeHurt && super.canHitEntity(p_36743_);
			}
			
			@Override
			protected void addAdditionalSaveData(CompoundTag pCompound) {
				super.addAdditionalSaveData(pCompound);
				for (int i = 0; i < BLOCK_STATES.size(); i++) {
					if (this.getBlockState(i).isPresent()) {
				      pCompound.put("BlockState" + i, NbtUtils.writeBlockState(this.getBlockState(i).get()));
					}
				}
			}
			
			@Override
			protected void readAdditionalSaveData(CompoundTag pCompound) {
				super.readAdditionalSaveData(pCompound);
				for (int i = 0; i < BLOCK_STATES.size(); i++) {
				      this.setBlockState(NbtUtils.readBlockState(pCompound.getCompound("BlockState" + i)), i);
				}
			}

		@Override
		protected void defineSynchedData() {
			for (int i = 0; i < BLOCK_STATES.size(); i++) {
				this.entityData.define(BLOCK_STATES.get(i), Optional.of(Blocks.DIRT.defaultBlockState()));
			}
			this.entityData.define(START_POS, BlockPos.ZERO);
		}
		
		@Override
		protected void onHit(HitResult p_37260_) {
			super.onHit(p_37260_);
			if (!this.level.isClientSide) {
				ShakeCameraEvent.shake(this.level, 40, 0.075F, this.blockPosition(), 10);
				((ServerLevel)this.level).sendParticles(ParticleTypeInit.DUST.get(), this.getX(), this.getY(), this.getZ(), 40, 1D, 1D, 1D, 0.0D);
				for (int i = 0; i < 8; i++) {
					this.playSound(this.getBlockState(i).get().getSoundType().getBreakSound(), 2.0F, 0.75F);
					((ServerLevel)this.level).sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, this.getBlockState(i).get()), this.getX(), this.getY(), this.getZ(), 20, 1D, 1D, 1D, 0.0D);
				}
				this.playSound(SoundEvents.GENERIC_EXPLODE, 2.0F, 0.75F);
				for (Entity entity : this.level.getEntities(this, this.getBoundingBox().inflate(3))) {
					if (entity instanceof LivingEntity && !MiscUtils.nonEnemy(this, entity)) {
						boolean flag = entity.hurt(DamageSource.explosion(this.getOwner() instanceof LivingEntity ? ((LivingEntity)this.getOwner()) : null), 30);
						if (this.distanceTo(entity) > 0.2) {
							double d0 = entity.getX() - this.getX();
							double d1 = entity.getZ() - this.getZ();
							double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
							entity.push(d0 / d2 * 2.0D, 0.3D, d1 / d2 * 2.0D);
						}
					}
				}
				this.discard();
			}
		}
}
