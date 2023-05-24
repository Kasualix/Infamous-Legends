package com.infamous.infamous_legends.blocks;

import javax.annotation.Nullable;

import com.infamous.infamous_legends.blocks.entities.FungusBombBlockEntity;
import com.infamous.infamous_legends.events.ShakeCameraEvent;
import com.infamous.infamous_legends.init.BlockEntityTypeInit;
import com.infamous.infamous_legends.utils.MiscUtils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FungusBombBlock extends BaseEntityBlock {

	private static final VoxelShape AABB = Shapes.or(Block.box(1.0D, 0.0D, 2.0D, 15.0D, 12.0D, 14.0D), Block.box(9.0D, 0.0D, -1.0D, 12.0D, 5.0D, 2.0D), Block.box(-2.0D, 0.0D, 6.0D, 1.0D, 5.0D, 9.0D), Block.box(15.0D, 0.0D, 5.0D, 18.0D, 6.0D, 8.0D), Block.box(5.0D, 0.0D, 14.0D, 8.0D, 6.0D, 17.0D));
	
	   public FungusBombBlock(BlockBehaviour.Properties p_57759_) {
	      super(p_57759_);
	   }
	   
	   public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
	        return BlockEntityTypeInit.FUNGUS_BOMB.get().create(pPos, pState);
	    }
	   
	   @Nullable
	   public <T extends BlockEntity> GameEventListener getListener(ServerLevel pLevel, T pBlockEntity) {
	      return pBlockEntity instanceof FungusBombBlockEntity ? ((FungusBombBlockEntity)pBlockEntity).getListener() : null;
	   }
	   
	   @Nullable
		public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153094_, BlockState p_153095_,
				BlockEntityType<T> p_153096_) {
			return createTickerHelper(p_153096_, BlockEntityTypeInit.FUNGUS_BOMB.get(),
					FungusBombBlockEntity::tick);
		}
	   
	   @Override
	public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest,
			FluidState fluid) {
		   if (!player.getAbilities().instabuild && player.getItemInHand(InteractionHand.MAIN_HAND).getEnchantmentLevel(Enchantments.SILK_TOUCH) <= 0) {
			   MiscUtils.customExplosion(level, null, DamageSource.explosion((Explosion)null), null, pos.getX(), pos.getY(),
					   pos.getZ(), 3.25F, false, Explosion.BlockInteraction.BREAK, SoundEvents.GENERIC_EXPLODE,
							SoundSource.BLOCKS, ParticleTypes.EXPLOSION, ParticleTypes.EXPLOSION_EMITTER, 15.0F, false);
		    	  ShakeCameraEvent.shake(level, 40, 0.075F, pos, 8);
		   }
		return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
	}

	   /**
	    * The type of render function called. MODEL for mixed tesr and static model, MODELBLOCK_ANIMATED for TESR-only,
	    * LIQUID for vanilla liquids, INVISIBLE to skip all rendering
	    * @deprecated call via {@link net.minecraft.world.level.block.state.BlockBehaviour.BlockStateBase#getRenderShape}
	    * whenever possible. Implementing/overriding is fine.
	    */
	   public RenderShape getRenderShape(BlockState pState) {
	      return RenderShape.MODEL;
	   }
	   
		public VoxelShape getShape(BlockState p_57809_, BlockGetter p_57810_, BlockPos p_57811_,
				CollisionContext p_57812_) {
			return AABB;
		}
}
