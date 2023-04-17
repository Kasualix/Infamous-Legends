package com.infamous.infamous_legends.spawner;

import java.util.List;
import java.util.Optional;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class LegendsSpawnerData {
//    public static final SpawnerData DEFAULT = new SpawnerData(new ResourceLocation("minecraft:pig"), new CompoundTag(), 1, 1, List.of(FactionRank.SOLDIER), EntityBoostConfig.DEFAULT, new IntRange(0, 10000), new IntRange(0, 10000), new IntRange(0, 10000), new IntRange(-64, 320), ResourceSet.getEmpty(Registry.BIOME_REGISTRY), ResourceSet.getEmpty(Registry.BIOME_REGISTRY));
    public static final Codec<LegendsSpawnerData> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
                    ForgeRegistries.ENTITY_TYPES.getCodec().fieldOf("entity_type").forGetter(data -> data.entityType),
                    CompoundTag.CODEC.optionalFieldOf("tag", new CompoundTag()).forGetter(data -> data.tag),
                    SpawnerResourceCost.CODEC.listOf().fieldOf("spawn_cost").forGetter(data -> data.spawnCosts),
                    ForgeRegistries.BLOCKS.getCodec().fieldOf("corner_block").forGetter(data -> data.cornerBlock),
                    ForgeRegistries.BLOCKS.getCodec().fieldOf("center_block").forGetter(data -> data.centerBlock),
                    Codec.INT.optionalFieldOf("max_spawns", 1).forGetter(data -> data.maxSpawns)
            ).apply(builder, LegendsSpawnerData::new));

    private final EntityType<?> entityType;
    private final CompoundTag tag;
    private final List<SpawnerResourceCost> spawnCosts;
    private final Block cornerBlock;
    private final Block centerBlock;
    private final Integer maxSpawns;

    public LegendsSpawnerData(EntityType<?> entityType, CompoundTag tag, List<SpawnerResourceCost> spawnCosts, Block cornerBlock, Block centerBlock, Integer maxSpawns) {
        this.entityType = entityType;
        this.tag = tag;
        this.spawnCosts = spawnCosts;
        this.cornerBlock = cornerBlock;
        this.centerBlock = centerBlock;
        this.maxSpawns = maxSpawns;
    }

    public EntityType<?> getEntityType() {
        return entityType;
    }

    public CompoundTag getTag() {
        return tag;
    }

    public List<SpawnerResourceCost> getSpawnCosts() {
        return spawnCosts;
    }

    public Block getCornerBlock() {
        return cornerBlock;
    }

    public Block getCenterBlock() {
        return centerBlock;
    }

    public Entity spawnEntity(ServerLevel level, BlockPos spawnPos, MobSpawnType spawnReason) {
        Entity entity;
        if (!this.getTag().isEmpty()) {
            CompoundTag compoundnbt = this.getTag().copy();
            compoundnbt.putString("id", this.getEntityType().toString());
            entity = EntityType.loadEntityRecursive(compoundnbt, level, createdEntity -> createdEntity);
        } else {
            entity = entityType.create(level);
        }
        if (entity == null) {
            return null;
        }
        entity.moveTo(spawnPos.getX() + 0.5D, spawnPos.getY(), spawnPos.getZ() + 0.5D, entity.getYRot(), entity.getXRot());
        if (entity instanceof Mob mobEntity) {
            if (net.minecraftforge.common.ForgeHooks.canEntitySpawn(mobEntity, level, spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), null, spawnReason) == -1)
                return null;
            if (this.getTag().isEmpty()) {
                mobEntity.finalizeSpawn(level, level.getCurrentDifficultyAt(new BlockPos(spawnPos)), MobSpawnType.EVENT, null, null);
            }
        }
        level.addFreshEntityWithPassengers(entity.getRootVehicle());
        return entity;
    }

    public boolean validateSpawnCost(NonNullList<ItemStack> addedItems) {
        for (SpawnerResourceCost spawnCost : this.spawnCosts) {
            Optional<ItemStack> first = addedItems.stream().filter(itemStack -> itemStack.getItem().equals(spawnCost.getItem())).findFirst();
            if(first.isPresent()) {
                ItemStack itemStack = first.get();
                if (itemStack.getCount() < spawnCost.getCount()) {
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }

    public boolean isSpawnCostItem(Item item) {
        for (SpawnerResourceCost spawnCost : this.spawnCosts) {
            if (spawnCost.getItem().equals(item)) {
                return true;
            }
        }
        return false;
    }
}
