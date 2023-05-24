package com.infamous.infamous_legends.blocks.entities;

import javax.annotation.Nullable;

import org.slf4j.Logger;

import com.infamous.infamous_legends.events.ShakeCameraEvent;
import com.infamous.infamous_legends.init.BlockEntityTypeInit;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.init.SoundEventInit;
import com.infamous.infamous_legends.utils.MiscUtils;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.Dynamic;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.BlockPositionSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.level.gameevent.vibrations.VibrationListener;

public class FungusBombBlockEntity extends BlockEntity implements VibrationListener.VibrationListenerConfig {
	   private static final Logger LOGGER = LogUtils.getLogger();
	   private int agitationLevel;
	   private int listenCooldown;
	   private int tickCount;
	   private VibrationListener listener = new VibrationListener(new BlockPositionSource(this.worldPosition), 8, this, (VibrationListener.ReceivingEvent)null, 0.0F, 0);
	   public RandomSource random = RandomSource.create();

	   public FungusBombBlockEntity(BlockPos pPos, BlockState pBlockState) {
	      super(BlockEntityTypeInit.FUNGUS_BOMB.get(), pPos, pBlockState);
	   }

	   public VibrationListener getListener() {
	      return this.listener;
	   }

	   public void load(CompoundTag pTag) {
	      super.load(pTag);
	      if (pTag.contains("agitation_level", 99)) {
	         this.agitationLevel = pTag.getInt("agitation_level");
	      }

	      if (pTag.contains("listener", 10)) {
	         VibrationListener.codec(this).parse(new Dynamic<>(NbtOps.INSTANCE, pTag.getCompound("listener"))).resultOrPartial(LOGGER::error).ifPresent((p_222864_) -> {
	            this.listener = p_222864_;
	         });
	      }

	   }

	   protected void saveAdditional(CompoundTag pTag) {
	      super.saveAdditional(pTag);
	      pTag.putInt("agitation_level", this.agitationLevel);
	      VibrationListener.codec(this).encodeStart(NbtOps.INSTANCE, this.listener).resultOrPartial(LOGGER::error).ifPresent((p_222871_) -> {
	         pTag.put("listener", p_222871_);
	      });
	   }

	   public boolean shouldListen(ServerLevel pLevel, GameEventListener pListener, BlockPos pPos, GameEvent pGameEvent, GameEvent.Context pContext) {
	      return !this.isRemoved() && this.tickCount > 1 && this.listenCooldown <= 0;
	   }

	   public void onSignalReceive(ServerLevel pLevel, GameEventListener pListener, BlockPos pSourcePos, GameEvent pGameEvent, @Nullable Entity pSourceEntity, @Nullable Entity pProjectileOwner, float pDistance) {
		   if (this.listenCooldown <= 0) {
			  this.listenCooldown = 20;
			  if (pGameEvent == GameEvent.EXPLODE) {
				  this.agitationLevel = 3;
			  } else {
				  this.agitationLevel ++;
			  }
		      if (this.agitationLevel >= 3) {
		    	  MiscUtils.customExplosion(pLevel, null, DamageSource.explosion((Explosion)null), null, this.getBlockPos().getX(), this.getBlockPos().getY(),
		    			  this.getBlockPos().getZ(), 3.25F, false, Explosion.BlockInteraction.BREAK, SoundEvents.GENERIC_EXPLODE,
							SoundSource.BLOCKS, ParticleTypes.EXPLOSION, ParticleTypes.EXPLOSION_EMITTER, 15.0F, false);
		    	  ShakeCameraEvent.shake(pLevel, 40, 0.075F, this.getBlockPos(), 8);
		      } else {
		    	  pLevel.playSound((Player)null, this.getBlockPos().getX(), this.getBlockPos().getY(), this.getBlockPos().getZ(), SoundEventInit.SPOREBACK_THROW_PROJECTILE.get(), SoundSource.BLOCKS, 1, MiscUtils.randomSoundPitch());
		      }
		   }
	   }
	   
		public static void tick(Level level, BlockPos pos, BlockState state, FungusBombBlockEntity object) {
			object.getListener().tick(level);
			object.tickCount ++;
			
			if (object.listenCooldown > 0) {
				object.listenCooldown--;
			}
			
			if (!level.isClientSide && object.agitationLevel > 0 && object.agitationLevel < 3 && object.random.nextInt(6 - (object.agitationLevel * 2)) == 0) {
				((ServerLevel)level).sendParticles(ParticleTypeInit.SPARK.get(), pos.getX() + 0.5, pos.getY() + 0.8, pos.getZ() + 0.5, object.agitationLevel, 0.25, 0, 0.25, 0.1);
			}
		}

	   public void onSignalSchedule() {
	      this.setChanged();
	   }
	}
