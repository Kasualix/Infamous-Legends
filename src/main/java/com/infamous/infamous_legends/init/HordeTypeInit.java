package com.infamous.infamous_legends.init;

import java.util.Map;

import com.infamous.dungeons_libraries.data.util.CodecJsonDataManager;
import com.infamous.infamous_legends.hordes.HordeType;
import com.infamous.infamous_legends.network.message.HordeTypeSyncPacket;

import net.minecraft.resources.ResourceLocation;

public class HordeTypeInit {
    public static final CodecJsonDataManager<HordeType> HORDE_TYPE_REGISTRY = new CodecJsonDataManager<>("horde_type", HordeType.CODEC);

    public static HordeType getHordeType(ResourceLocation resourceLocation) {
        return HORDE_TYPE_REGISTRY.getData().getOrDefault(resourceLocation, null);
    }

    public static HordeType getHordeTypeByName(String name) {
        return HORDE_TYPE_REGISTRY.getData().values().stream()
                .filter(spawnerData -> spawnerData.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public static HordeTypeSyncPacket toPacket(Map<ResourceLocation, HordeType> map) {
        return new HordeTypeSyncPacket(map);
    }

    public static ResourceLocation getHordeTypeKey(HordeType HordeType) {
        return HORDE_TYPE_REGISTRY.getData().entrySet().stream()
                .filter(entry -> entry.getValue().equals(HordeType))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
