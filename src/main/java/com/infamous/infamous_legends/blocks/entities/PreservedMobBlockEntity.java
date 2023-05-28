package com.infamous.infamous_legends.blocks.entities;

import java.util.List;

import com.infamous.infamous_legends.blocks.PreservedMobBlock;
import com.infamous.infamous_legends.blocks.PreservedMobBlock.FreeMethod;
import com.infamous.infamous_legends.entities.Badger;
import com.infamous.infamous_legends.init.BlockEntityTypeInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.ForgeRegistries;

public class PreservedMobBlockEntity extends BlockEntity {
	   
	public String entityType;
	public CompoundTag tag;
	public BlockPos renderTranslation;
	public BlockPos renderRotation;
	public BlockPos renderScale;
	public FreeMethod freeMethod;
	public RandomSource random = RandomSource.create();
	public int freeingFor;
	
	public PreservedMobBlockEntity(BlockPos pPos, BlockState pState) {
        super(BlockEntityTypeInit.PRESERVED_MOB.get(), pPos, pState);
    }

	public void load(CompoundTag pTag) {
	      super.load(pTag);
			this.entityType = pTag.getString("entity_type");

			this.renderTranslation = NbtUtils.readBlockPos(pTag.getCompound("render_translation"));

			this.renderRotation = NbtUtils.readBlockPos(pTag.getCompound("render_rotation"));

			this.renderScale = NbtUtils.readBlockPos(pTag.getCompound("render_scale"));

			this.freeMethod = FreeMethod.byName(pTag.getString("free_method"));
			
			this.tag = (CompoundTag) pTag.get("tag");
		}

	   protected void saveAdditional(CompoundTag pTag) {
	      super.saveAdditional(pTag);
	      pTag.putString("entity_type", this.entityType);
	      
	      pTag.put("tag", this.tag);
	      
	      pTag.put("render_translation", NbtUtils.writeBlockPos(renderTranslation));
	      
	      pTag.put("render_rotation", NbtUtils.writeBlockPos(renderRotation));
	      
	      pTag.put("render_scale", NbtUtils.writeBlockPos(renderScale));
	      
	      pTag.putString("free_method", this.freeMethod.name);
	   }
	   
	   public void setEntityType(EntityType<?> type) {
		   this.entityType = EntityType.getKey(type).toString();
	   }
	   
	   public EntityType<?> getEntityType() {
		   return entityType != null && !entityType.isEmpty() ? ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(entityType)) : null;
	   }
	   
		public static void tick(Level level, BlockPos pos, BlockState state, PreservedMobBlockEntity object) {
			boolean beingFreed = false;
			if (object.freeMethod == FreeMethod.WASH) {
				List<BlockState> blockStates = level.getBlockStates(new AABB(pos.offset(-1, -1, -1), pos.offset(1, 1, 1))).toList();
				int nearbyWater = 0;
				for (BlockState blockState : blockStates) {
					if (blockState.getFluidState().is(FluidTags.WATER)) {
						nearbyWater ++;
					}
				}
				
				if (nearbyWater >= 4) {
					beingFreed = true;
					if (object.random.nextBoolean()) {
						object.makeMeltOrWashParticles(state, level, pos, object.random, false);
					}
					
					if (!level.isClientSide && object.freeingFor >= 200 && (object.random.nextInt(600) == 0 || object.freeingFor >= 2400)) {
						object.freeMob(level, pos, state, object);
					}
				}
				
			} else if (object.freeMethod == FreeMethod.MELT) {
				if (level.getBlockState(pos.below()).getBlock() instanceof BaseFireBlock || level.getBlockState(pos.below()).getBlock() instanceof CampfireBlock) {
					beingFreed = true;
					if (object.random.nextInt(5) == 0) {
						object.makeMeltOrWashParticles(state, level, pos, object.random, true);
					}
					
					if (!level.isClientSide && object.freeingFor >= 200 && (object.random.nextInt(600) == 0 || object.freeingFor >= 2400)) {
						object.freeMob(level, pos, state, object);
					}
				}
			}
			
			if (beingFreed) {
				object.freeingFor ++;
			} else {
				object.freeingFor = 0;
			}
			
			for (Badger livingentity : level.getEntitiesOfClass(Badger.class, new AABB(pos.offset(-15, -15, -15), pos.offset(15, 15, 15)))) {
				if (livingentity.alertPos == null || !(level.getBlockState(livingentity.alertPos).getBlock() instanceof PreservedMobBlock)) {
					livingentity.alertPos = pos;
					livingentity.timeUntilAlertPosReset = 10;
				} else {
					livingentity.timeUntilAlertPosReset = 10;
				}
			}
		}
		
		public void freeMob(Level level, BlockPos pos, BlockState state, PreservedMobBlockEntity object) {
			if (object.getEntityType() != null) {
				Entity entity = object.getEntityType().create(level);
				if (!object.tag.isEmpty()) {
					CompoundTag compoundnbt = object.tag.copy();
					entity.load(compoundnbt);
				}
				entity.moveTo(pos, 0, 0);
				level.addFreshEntity(entity);
			}
			level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
		}
		
		public void makeMeltOrWashParticles(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom, boolean melt) {
		      Direction direction = Direction.getRandom(pRandom);
		      if (direction != Direction.UP) {
		         BlockPos blockpos = pPos.relative(direction);
		         BlockState blockstate = pLevel.getBlockState(blockpos);
		         if (!pState.canOcclude() || !blockstate.isFaceSturdy(pLevel, blockpos, direction.getOpposite())) {
		            double d0 = (double)pPos.getX();
		            double d1 = (double)pPos.getY();
		            double d2 = (double)pPos.getZ();
		            if (direction == Direction.DOWN) {
		               d1 -= 0.05D;
		               d0 += pRandom.nextDouble();
		               d2 += pRandom.nextDouble();
		            } else {
		               d1 += pRandom.nextDouble() * 0.8D;
		               if (direction.getAxis() == Direction.Axis.X) {
		                  d2 += pRandom.nextDouble();
		                  if (direction == Direction.EAST) {
		                     ++d0;
		                  } else {
		                     d0 += 0.05D;
		                  }
		               } else {
		                  d0 += pRandom.nextDouble();
		                  if (direction == Direction.SOUTH) {
		                     ++d2;
		                  } else {
		                     d2 += 0.05D;
		                  }
		               }
		            }

		            pLevel.addParticle(melt ? ParticleTypes.DRIPPING_WATER : new BlockParticleOption(ParticleTypes.BLOCK, pState), d0, d1, d2, 0.0D, 0.0D, 0.0D);
		         }
		      }
		   }
}
