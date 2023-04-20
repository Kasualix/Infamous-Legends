package com.infamous.infamous_legends.blocks;

import com.infamous.infamous_legends.entities.BigBeak;
import com.infamous.infamous_legends.init.EntityTypeInit;
import com.infamous.infamous_legends.utils.PositionUtils;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BigBeakEggBlock extends Block {
	   public static final int MAX_HATCH_LEVEL = 2;
	   private static final VoxelShape ONE_EGG_AABB = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);
	   public static final IntegerProperty HATCH = BlockStateProperties.HATCH;

	   public BigBeakEggBlock(BlockBehaviour.Properties p_57759_) {
	      super(p_57759_);
	      this.registerDefaultState(this.stateDefinition.any().setValue(HATCH, Integer.valueOf(0)));
	   }

	   public void randomTick(BlockState p_222644_, ServerLevel p_222645_, BlockPos p_222646_, RandomSource p_222647_) {
	      if (this.shouldUpdateHatchLevel(p_222645_)) {
	         int i = p_222644_.getValue(HATCH);
	         if (i < 2) {
	            p_222645_.playSound((Player)null, p_222646_, SoundEvents.TURTLE_EGG_CRACK, SoundSource.BLOCKS, 0.7F, 0.9F + p_222647_.nextFloat() * 0.2F);
	            p_222645_.setBlock(p_222646_, p_222644_.setValue(HATCH, Integer.valueOf(i + 1)), 2);
	         } else {
	            p_222645_.playSound((Player)null, p_222646_, SoundEvents.TURTLE_EGG_BREAK, SoundSource.BLOCKS, 0.7F, 0.9F + p_222647_.nextFloat() * 0.2F);
	            p_222645_.removeBlock(p_222646_, false);

				p_222645_.levelEvent(2001, p_222646_, Block.getId(p_222644_));
				BigBeak bigBeak = EntityTypeInit.BIG_BEAK.get().create(p_222645_);
				bigBeak.setAge(-24000);
				bigBeak.moveTo(p_222646_, 0.0F, 0.0F);
				p_222645_.addFreshEntity(bigBeak);
				bigBeak.setDeltaMovement(PositionUtils.getOffsetMotion(bigBeak, 0, 0, 0.1, bigBeak.yBodyRot));
				
	            for(ServerPlayer serverplayerentity1 : p_222645_.getEntitiesOfClass(ServerPlayer.class, bigBeak.getBoundingBox().inflate(10.0D))) {
		               CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayerentity1, bigBeak);
		        }
	         }
	      }

	   }

	   private boolean shouldUpdateHatchLevel(Level p_57766_) {
	         return p_57766_.random.nextInt(10) == 0;
	   }

	   public VoxelShape getShape(BlockState p_57809_, BlockGetter p_57810_, BlockPos p_57811_, CollisionContext p_57812_) {
	      return ONE_EGG_AABB;
	   }

	   protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_57799_) {
	      p_57799_.add(HATCH);
	   }
	   
	   public void fallOn(Level p_154845_, BlockState p_154846_, BlockPos p_154847_, Entity p_154848_, float p_154849_) {
		   	  if (!p_154845_.isClientSide && this.canDestroyEgg(p_154845_, p_154848_) && p_154845_.random.nextInt(3) == 0) {
		   		  p_154845_.playSound((Player)null, p_154847_, SoundEvents.TURTLE_EGG_BREAK, SoundSource.BLOCKS, 0.7F, 0.9F + p_154845_.random.nextFloat() * 0.2F);
		   		  p_154845_.destroyBlock(p_154847_, false);
		   	  }

		      super.fallOn(p_154845_, p_154846_, p_154847_, p_154848_, p_154849_);
		   }
	   
	   private boolean canDestroyEgg(Level p_57768_, Entity p_57769_) {
		      if (!(p_57769_ instanceof BigBeak) && !(p_57769_ instanceof Bat)) {
		         if (!(p_57769_ instanceof LivingEntity)) {
		            return false;
		         } else {
		            return p_57769_ instanceof Player || net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(p_57768_, p_57769_);
		         }
		      } else {
		         return false;
		      }
		   }
	}
