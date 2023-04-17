package com.infamous.infamous_legends.init;

import java.util.Map;

import com.infamous.dungeons_libraries.data.util.CodecJsonDataManager;
import com.infamous.infamous_legends.golem_types.PlankGolemType;
import com.infamous.infamous_legends.network.message.PlankGolemTypeSyncPacket;

import net.minecraft.resources.ResourceLocation;

public class PlankGolemTypeInit {
    public static final CodecJsonDataManager<PlankGolemType> PLANK_GOLEM_TYPE_REGISTRY = new CodecJsonDataManager<>("plank_golem_type", PlankGolemType.CODEC);

    public static PlankGolemType getPlankGolemType(ResourceLocation resourceLocation) {
        return PLANK_GOLEM_TYPE_REGISTRY.getData().getOrDefault(resourceLocation, null);
    }

    public static PlankGolemType getPlankGolemTypeByName(String name) {
        return PLANK_GOLEM_TYPE_REGISTRY.getData().values().stream()
                .filter(spawnerData -> spawnerData.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public static PlankGolemTypeSyncPacket toPacket(Map<ResourceLocation, PlankGolemType> map) {
        return new PlankGolemTypeSyncPacket(map);
    }

    public static ResourceLocation getPlankGolemTypeKey(PlankGolemType PlankGolemType) {
        return PLANK_GOLEM_TYPE_REGISTRY.getData().entrySet().stream()
                .filter(entry -> entry.getValue().equals(PlankGolemType))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
