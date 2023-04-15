package com.infamous.infamous_legends.blocks.entities;

import com.infamous.infamous_legends.init.BlockEntityTypeInit;
import com.infamous.infamous_legends.init.LegendsSpawnerDataInit;
import com.infamous.infamous_legends.spawner.LegendsSpawnerData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class LegendsSpawnerBlockEntity extends BlockEntity {

    private LegendsSpawnerData legendsSpawnerData;
    private int tickCount = 0;
    private NonNullList<ItemStack> addedItems = NonNullList.withSize(36, ItemStack.EMPTY);

    public LegendsSpawnerBlockEntity(BlockPos pPos, BlockState pState) {
        super(BlockEntityTypeInit.LEGENDS_SPAWNER.get(), pPos, pState);
    }

    public static void clientTick(Level level, BlockPos blockPos, BlockState blockState, LegendsSpawnerBlockEntity blockEntity) {
        // NOOP
    }

    public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, LegendsSpawnerBlockEntity blockEntity) {
        blockEntity.doServerTick((ServerLevel) level, blockPos);
    }

    private void doServerTick(ServerLevel level, BlockPos blockPos) {
        if (tickCount % 20 == 0) {
            validateSpawnerData(level, blockPos);
        }
        tickCount++;
    }

    private void validateSpawnerData(ServerLevel level, BlockPos blockPos) {
        Block cornerBlock = null;
        Block centerBlock = null;
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                BlockState blockState = level.getBlockState(blockPos.mutable().move(x, -1, z));
                Block block = blockState.getBlock();
                if (x == 0 || z == 0) {
                    if (centerBlock == null) {
                        centerBlock = block;
                    } else if (!centerBlock.equals(block)) {
                        legendsSpawnerData = null;
                        ejectItems(level, blockPos);
                        return;
                    }
                } else {
                    if (cornerBlock == null) {
                        cornerBlock = block;
                    } else if (!cornerBlock.equals(block)) {
                        legendsSpawnerData = null;
                        ejectItems(level, blockPos);
                        return;
                    }
                }
            }
        }
        LegendsSpawnerData spawnerDataByBlocks = LegendsSpawnerDataInit.getSpawnerDataByBlocks(cornerBlock, centerBlock);
        if (spawnerDataByBlocks == null || !spawnerDataByBlocks.equals(legendsSpawnerData)) {
            legendsSpawnerData = spawnerDataByBlocks;
            ejectItems(level, blockPos);
        }
    }

    private void ejectItems(ServerLevel level, BlockPos blockPos) {
        addedItems.forEach(itemStack -> level.addFreshEntity(new ItemEntity(level, blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), itemStack)));
        addedItems.clear();
    }

    public boolean addItem(ItemStack itemStack) {
        if(this.level.isClientSide){ return true;}
        int firstEmptySlot = addedItems.indexOf(ItemStack.EMPTY);
        boolean hasItem = false;
        if(!legendsSpawnerData.isSpawnCostItem(itemStack.getItem())){
            return false;
        }
        for (int i = 0; i < addedItems.size(); i++) {
            ItemStack addedItem = addedItems.get(i);
            if (addedItem.getItem().equals(itemStack.getItem())) {
                addedItem.grow(itemStack.getCount());
                itemStack.shrink(itemStack.getCount());
                hasItem = true;
                break;
            }
        }
        if (!hasItem && firstEmptySlot != -1) {
            addedItems.set(firstEmptySlot, itemStack.copy());
            itemStack.shrink(itemStack.getCount());
        }
        spawnEntity();
        return true;
    }

    private void spawnEntity() {
        if(legendsSpawnerData != null && level instanceof ServerLevel serverLevel) {
            boolean validSpawnCost = legendsSpawnerData.validateSpawnCost(addedItems);
            if(validSpawnCost){
                Entity entity = legendsSpawnerData.spawnEntity(serverLevel, getSpawnPos(worldPosition), MobSpawnType.SPAWNER);
                if (entity != null) {
                    legendsSpawnerData.getSpawnCosts().forEach(spawnerResourceCost -> {
                        for (int i = 0; i < addedItems.size(); i++) {
                            ItemStack addedItem = addedItems.get(i);
                            if (addedItem.getItem().equals(spawnerResourceCost.getItem())) {
                                addedItem.shrink(spawnerResourceCost.getCount());
                                if (addedItem.isEmpty()) {
                                    addedItems.set(i, ItemStack.EMPTY);
                                }
                                break;
                            }
                        }
                    });
                }
                spawnEntity();
            }
        }
    }

    private BlockPos getSpawnPos(BlockPos blockPos) {
        int posX = this.level.getRandom().nextInt(3) - 1;
        int posZ = this.level.getRandom().nextInt(3) - 1;
        if(posX == 0 && posZ == 0){
            posX = 1;
        }
        return blockPos.offset(posX, 0, posZ);
    }


    @Override
    public void saveAdditional(CompoundTag pCompound) {
        super.saveAdditional(pCompound);
        ResourceLocation key = LegendsSpawnerDataInit.getSpawnerDataKey(legendsSpawnerData);
        if (legendsSpawnerData != null && key != null) {
            pCompound.putString("LegendsSpawnerData", key.toString());
        }
        if (addedItems.size() > 0) {
            pCompound.put("AddedItems", ContainerHelper.saveAllItems(new CompoundTag(), addedItems));
        }
    }

    @Override
    public void load(CompoundTag pCompound) {
        super.load(pCompound);
        if (pCompound.contains("LegendsSpawnerData")) {
            legendsSpawnerData = LegendsSpawnerDataInit.getSpawnerData(new ResourceLocation(pCompound.getString("LegendsSpawnerData")));
        }
        if (pCompound.contains("AddedItems")) {
            addedItems = NonNullList.withSize(36, ItemStack.EMPTY);
            ContainerHelper.loadAllItems(pCompound.getCompound("AddedItems"), addedItems);
        }
    }



}
