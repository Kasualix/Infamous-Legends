package com.infamous.infamous_legends.blocks;

import com.infamous.infamous_legends.blocks.entities.LegendsSpawnerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import static com.infamous.infamous_legends.init.BlockEntityTypeInit.LEGENDS_SPAWNER;

public class LegendsSpawnerBlock extends Block implements EntityBlock {

    public LegendsSpawnerBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return LEGENDS_SPAWNER.get().create(pPos, pState);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, LEGENDS_SPAWNER.get(), level.isClientSide ? LegendsSpawnerBlockEntity::clientTick : LegendsSpawnerBlockEntity::serverTick);
    }

    protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> p_152133_, BlockEntityType<E> p_152134_, BlockEntityTicker<? super E> p_152135_) {
        return p_152134_ == p_152133_ ? (BlockEntityTicker<A>)p_152135_ : null;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
        boolean succes = false;
        if (blockEntity instanceof LegendsSpawnerBlockEntity spawnerBlockEntity) {
            succes = spawnerBlockEntity.addItem(pPlayer.getItemInHand(pHand));
        }
        if(succes){
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }else{
            return InteractionResult.PASS;
        }
    }
}
