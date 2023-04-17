package com.infamous.infamous_legends.blocks.entities;

import com.infamous.infamous_legends.init.BlockEntityTypeInit;
import com.infamous.infamous_legends.init.LegendsSpawnerDataInit;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.spawner.LegendsSpawnerData;
import com.infamous.infamous_legends.utils.MiscUtils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class LegendsSpawnerBlockEntity extends BlockEntity {

    private LegendsSpawnerData legendsSpawnerData;
    public int tickCount = 0;
    private boolean hasValidatedSpawnerData = false;
    private NonNullList<ItemStack> addedItems = NonNullList.withSize(36, ItemStack.EMPTY);
    
    public RandomSource random = RandomSource.create();

    public LegendsSpawnerBlockEntity(BlockPos pPos, BlockState pState) {
        super(BlockEntityTypeInit.LEGENDS_SPAWNER.get(), pPos, pState);
    }
    
    public LegendsSpawnerData getLegendsSpawnerData() {
    	return this.legendsSpawnerData;
    }

    public static void clientTick(Level level, BlockPos blockPos, BlockState blockState, LegendsSpawnerBlockEntity blockEntity) {
        blockEntity.doClientTick(level, blockPos);
        System.out.print("\r\n" + "client: " + blockEntity.addedItems);
    }

    public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, LegendsSpawnerBlockEntity blockEntity) {
        blockEntity.doServerTick((ServerLevel) level, blockPos);
        System.out.print("\r\n" + "server: " + blockEntity.addedItems);
    }

    private void doServerTick(ServerLevel level, BlockPos blockPos) {
        if (tickCount > 20 && tickCount % 20 == 0) {
            validateSpawnerData(level, blockPos);
            if (hasValidatedSpawnerData && legendsSpawnerData == null) {
                ejectItems(level, blockPos);
            }
        }
        if (tickCount > 20 && tickCount % 10 == 0 && legendsSpawnerData != null && legendsSpawnerData.validateSpawnCost(addedItems)) {
        	level.sendParticles(ParticleTypeInit.SPAWNER_FLAME.get(), blockPos.getX() + 0.5, blockPos.getY() + 0.5, blockPos.getZ() + 0.5, 1, 0, 0, 0, 0);
        }
        tickCount++;
    }
    
    private void doClientTick(Level level, BlockPos blockPos) {
        if (tickCount > 20 && tickCount % 20 == 0) {
            validateSpawnerData(level, blockPos);
        }
        if (tickCount > 20 && legendsSpawnerData != null && this.random.nextBoolean()) {
        	level.addParticle(ParticleTypeInit.SPAWNER_MAGIC_SWIRL.get(), blockPos.getX() + 0.5D, blockPos.getY(), blockPos.getZ() - (21 / 32.0F), 0, 0, 0);
        }
        tickCount++;
    }
    
    @Override
    public AABB getRenderBoundingBox() {
    	return super.getRenderBoundingBox().inflate(10);
    }

    private void validateSpawnerData(Level level, BlockPos blockPos) {
    	hasValidatedSpawnerData = true;
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
                        return;
                    }
                } else {
                    if (cornerBlock == null) {
                        cornerBlock = block;
                    } else if (!cornerBlock.equals(block)) {
                        legendsSpawnerData = null;
                        return;
                    }
                }
            }
        }
        LegendsSpawnerData spawnerDataByBlocks = LegendsSpawnerDataInit.getSpawnerDataByBlocks(cornerBlock, centerBlock);
        if (spawnerDataByBlocks == null || !spawnerDataByBlocks.equals(legendsSpawnerData)) {
            legendsSpawnerData = spawnerDataByBlocks;
        }
    }

    private void ejectItems(Level level, BlockPos blockPos) {
        addedItems.forEach(itemStack -> {if(!itemStack.equals(ItemStack.EMPTY)) level.addFreshEntity(new ItemEntity(level, blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), itemStack));});
        addedItems.clear();
    }

    public boolean addItem(ItemStack itemStack, BlockPos pos, Player player) {
    	if (this.legendsSpawnerData == null) {
    		validateSpawnerData(level, pos);
    	}
        if(this.level.isClientSide) { return true; }
        int firstEmptySlot = addedItems.indexOf(ItemStack.EMPTY);
        boolean hasItem = false;
        if(!legendsSpawnerData.isSpawnCostItem(itemStack.getItem())){
            return false;
        }
        for (int i = 0; i < addedItems.size(); i++) {
            ItemStack addedItem = addedItems.get(i);
            if (addedItem.getItem().equals(itemStack.getItem())) {
                addedItem.grow(1);
                if (!player.getAbilities().instabuild) {
                	itemStack.shrink(1);
                }
                this.level.playSound((Player)null, worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), SoundEvents.RESPAWN_ANCHOR_CHARGE, SoundSource.PLAYERS, 1, MiscUtils.randomSoundPitch());
                hasItem = true;
                break;
            }
        }
        if (!hasItem && firstEmptySlot != -1) {
            addedItems.set(firstEmptySlot, new ItemStack(itemStack.getItem()));
            if (!player.getAbilities().instabuild) {
            	itemStack.shrink(1);
            }
            this.level.playSound((Player)null, worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), SoundEvents.RESPAWN_ANCHOR_CHARGE, SoundSource.PLAYERS, 1, MiscUtils.randomSoundPitch());
        }
        return true;
    }

    public boolean spawnEntity(BlockPos pos, Player player, InteractionHand hand) {
        if(legendsSpawnerData != null && level instanceof ServerLevel serverLevel) {
            boolean validSpawnCost = legendsSpawnerData.validateSpawnCost(addedItems);
            if(validSpawnCost){
            	this.level.playSound((Player)null, worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), SoundEvents.BEACON_POWER_SELECT, SoundSource.PLAYERS, 1, MiscUtils.randomSoundPitch());
            	this.level.playSound((Player)null, worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), SoundEvents.FIRECHARGE_USE, SoundSource.PLAYERS, 1, MiscUtils.randomSoundPitch() * 0.5F);
                Entity entity = legendsSpawnerData.spawnEntity(serverLevel, this.getSpawnPos(worldPosition), MobSpawnType.SPAWNER);
                if (entity != null) {
                	if (!this.level.isClientSide) {
                		((ServerLevel)this.level).sendParticles(ParticleTypeInit.SPAWNER_MAGIC.get(), entity.getX(), entity.getY(0.5), entity.getZ(), 40, entity.getBbWidth() / 2, entity.getBbHeight() / 2, entity.getBbWidth() / 2, 1);
                	}
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
                    return true;
                }
            }
        }
        return false;
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
        
        ListTag listtag = new ListTag();
        
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
