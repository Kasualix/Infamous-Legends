package com.infamous.infamous_legends.init;

import java.util.Map;

import com.infamous.dungeons_libraries.data.util.CodecJsonDataManager;
import com.infamous.infamous_legends.golem_types.FirstOfOakWood1Type;
import com.infamous.infamous_legends.network.message.FirstOfOakWood1TypeSyncPacket;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class FirstOfOakWood1TypeInit {
    public static final CodecJsonDataManager<FirstOfOakWood1Type> FIRST_OF_OAK_WOOD_1_TYPE_REGISTRY = new CodecJsonDataManager<>("first_of_oak_wood_1_type", FirstOfOakWood1Type.CODEC);

    public static FirstOfOakWood1Type getWood1Type(ResourceLocation resourceLocation) {
        return FIRST_OF_OAK_WOOD_1_TYPE_REGISTRY.getData().getOrDefault(resourceLocation, null);
    }

    public static FirstOfOakWood1Type getWood1TypeByName(String name) {
        return FIRST_OF_OAK_WOOD_1_TYPE_REGISTRY.getData().values().stream()
                .filter(spawnerData -> spawnerData.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
    
    public static FirstOfOakWood1Type getWood1TypeByWood(Block wood) {
        return FIRST_OF_OAK_WOOD_1_TYPE_REGISTRY.getData().values().stream()
                .filter(spawnerData -> spawnerData.getPlanks() == wood)
                .findFirst()
                .orElse(null);
    }

    public static FirstOfOakWood1TypeSyncPacket toPacket(Map<ResourceLocation, FirstOfOakWood1Type> map) {
        return new FirstOfOakWood1TypeSyncPacket(map);
    }

    public static ResourceLocation getWood1TypeKey(FirstOfOakWood1Type PlankGolemType) {
        return FIRST_OF_OAK_WOOD_1_TYPE_REGISTRY.getData().entrySet().stream()
                .filter(entry -> entry.getValue().equals(PlankGolemType))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
