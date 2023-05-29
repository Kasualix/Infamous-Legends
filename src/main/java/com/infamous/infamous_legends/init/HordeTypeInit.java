package com.infamous.infamous_legends.init;

import java.util.List;
import java.util.Map;

import org.jetbrains.annotations.NotNull;

import com.infamous.dungeons_libraries.data.util.CodecJsonDataManager;
import com.infamous.infamous_legends.hordes.HordeType;
import com.infamous.infamous_legends.network.message.HordeTypeSyncPacket;

import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITag;

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
    
    public static HordeType getHordeTypeByBiome(Holder<Biome> biome, List<HordeType> viableHordes) {
    	for (HordeType horde : viableHordes) {
    		int tagLocationColonIndex = horde.getBiomes().indexOf(":");
    		String tagLocationPrefix = horde.getBiomes().substring(0, tagLocationColonIndex);
    		String tagLocationName = horde.getBiomes().substring(tagLocationColonIndex + 1);
    		ITag<Biome> tag = ForgeRegistries.BIOMES.tags().getTag(TagInit.Biomes.createBiomeTag(tagLocationPrefix, tagLocationName));
    		if (biome.is(tag.getKey())) {
    			return horde;
    		}
    	}
    	return null;
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
