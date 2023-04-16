package com.infamous.infamous_legends.init;

import com.infamous.dungeons_libraries.data.util.CodecJsonDataManager;
import com.infamous.infamous_legends.network.message.LegendsSpawnerDataSyncPacket;
import com.infamous.infamous_legends.spawner.LegendsSpawnerData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.Map;

public class LegendsSpawnerDataInit {
    public static final CodecJsonDataManager<LegendsSpawnerData> LEGENDS_SPAWNER_DATA_REGISTRY = new CodecJsonDataManager<>("legends_spawner_data", LegendsSpawnerData.CODEC);

    public static LegendsSpawnerData getSpawnerData(ResourceLocation resourceLocation) {
        return LEGENDS_SPAWNER_DATA_REGISTRY.getData().getOrDefault(resourceLocation, null);
    }

    public static LegendsSpawnerData getSpawnerDataByBlocks(Block cornerBlock, Block centerBlock) {
        return LEGENDS_SPAWNER_DATA_REGISTRY.getData().values().stream()
                .filter(spawnerData -> spawnerData.getCornerBlock().equals(cornerBlock) && spawnerData.getCenterBlock().equals(centerBlock))
                .findFirst()
                .orElse(null);
    }

    public static LegendsSpawnerDataSyncPacket toPacket(Map<ResourceLocation, LegendsSpawnerData> map) {
        return new LegendsSpawnerDataSyncPacket(map);
    }

    public static ResourceLocation getSpawnerDataKey(LegendsSpawnerData legendsSpawnerData) {
        return LEGENDS_SPAWNER_DATA_REGISTRY.getData().entrySet().stream()
                .filter(entry -> entry.getValue().equals(legendsSpawnerData))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
