package com.infamous.infamous_legends.init;

import java.util.Map;

import com.infamous.dungeons_libraries.data.util.CodecJsonDataManager;
import com.infamous.infamous_legends.golem_types.FirstOfOakWood1Type;
import com.infamous.infamous_legends.golem_types.FirstOfOakWood2Type;
import com.infamous.infamous_legends.network.message.FirstOfOakWood2TypeSyncPacket;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class FirstOfOakWood2TypeInit {
    public static final CodecJsonDataManager<FirstOfOakWood2Type> FIRST_OF_OAK_WOOD_2_TYPE_REGISTRY = new CodecJsonDataManager<>("first_of_oak_wood_2_type", FirstOfOakWood2Type.CODEC);

    public static FirstOfOakWood2Type getWood2Type(ResourceLocation resourceLocation) {
        return FIRST_OF_OAK_WOOD_2_TYPE_REGISTRY.getData().getOrDefault(resourceLocation, null);
    }

    public static FirstOfOakWood2Type getWood2TypeByName(String name) {
        return FIRST_OF_OAK_WOOD_2_TYPE_REGISTRY.getData().values().stream()
                .filter(spawnerData -> spawnerData.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
    
    public static FirstOfOakWood2Type getWood2TypeByWood(Block wood) {
        return FIRST_OF_OAK_WOOD_2_TYPE_REGISTRY.getData().values().stream()
                .filter(spawnerData -> spawnerData.getWood() == wood)
                .findFirst()
                .orElse(null);
    }

    public static FirstOfOakWood2TypeSyncPacket toPacket(Map<ResourceLocation, FirstOfOakWood2Type> map) {
        return new FirstOfOakWood2TypeSyncPacket(map);
    }

    public static ResourceLocation getWood2TypeKey(FirstOfOakWood2Type PlankGolemType) {
        return FIRST_OF_OAK_WOOD_2_TYPE_REGISTRY.getData().entrySet().stream()
                .filter(entry -> entry.getValue().equals(PlankGolemType))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
