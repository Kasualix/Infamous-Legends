package com.infamous.infamous_legends.fluids;

import com.infamous.infamous_legends.init.FluidInit;
import com.infamous.infamous_legends.init.ParticleTypeInit;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public abstract class TarFluid extends ForgeFlowingFluid {
	
	protected TarFluid(Properties properties) {
		super(properties);
	}

	public void animateTick(Level pLevel, BlockPos pPos, FluidState pState, RandomSource pRandom) {
	      BlockPos blockpos = pPos.above();
	      if (pState.is(FluidInit.SOURCE_TAR.get()) && pLevel.getBlockState(blockpos).isAir() && !pLevel.getBlockState(blockpos).isSolidRender(pLevel, blockpos)) {
	         if (pRandom.nextInt(50) == 0) {
	            double d0 = (double)pPos.getX() + pRandom.nextDouble();
	            double d1 = (double)pPos.getY() + 1.0D;
	            double d2 = (double)pPos.getZ() + pRandom.nextDouble();
	            pLevel.addParticle(ParticleTypeInit.TAR_BUBBLE.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
	         }
	      }

	   }	

	   public static class Flowing extends TarFluid {
		   
		   public Flowing(Properties properties) {
				super(properties);
			}

			protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> pBuilder) {
		         super.createFluidStateDefinition(pBuilder);
		         pBuilder.add(LEVEL);
		      }

		      public int getAmount(FluidState pState) {
		         return pState.getValue(LEVEL);
		      }

		      public boolean isSource(FluidState pState) {
		         return false;
		      }
		   }

		   public static class Source extends TarFluid {
			   
				public Source(Properties properties) {
					super(properties);
				}

			public int getAmount(FluidState pState) {
		         return 8;
		      }

		      public boolean isSource(FluidState pState) {
		         return true;
		      }
		   }
}
