package com.infamous.infamous_legends.init;

import java.util.List;
import java.util.Map;

import com.infamous.dungeons_libraries.data.util.CodecJsonDataManager;
import com.infamous.infamous_legends.hordes.HordeType;
import com.infamous.infamous_legends.network.message.HordeTypeSyncPacket;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.Structure;
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
    		if (horde.getBiomes() != null && !horde.getBiomes().equals("")) {
	    		int tagLocationColonIndex = horde.getBiomes().indexOf(":");
	    		String tagLocationPrefix = tagLocationColonIndex > 0 ? horde.getBiomes().substring(0, tagLocationColonIndex) : null;
	    		String tagLocationName = tagLocationColonIndex > 0 ? horde.getBiomes().substring(tagLocationColonIndex + 1) : null;
	    		ITag<Biome> tag = tagLocationPrefix != null && tagLocationName != null ? ForgeRegistries.BIOMES.tags().getTag(TagInit.Biomes.createBiomeTag(tagLocationPrefix, tagLocationName)) : null;
	    		if (tag != null && biome.is(tag.getKey())) {
	    			return horde;
	    		}
    		}
    	}
    	return null;
    }
    
    public static HordeType getHordeTypeByStructure(ServerLevel level, BlockPos pos, List<HordeType> viableHordes) {
    	for (HordeType horde : viableHordes) {
    		if (horde.getStructures() != null && !horde.getStructures().equals("")) {
	    		int tagLocationColonIndex = horde.getStructures().indexOf(":");
	    		String tagLocationPrefix = tagLocationColonIndex > 0 ? horde.getStructures().substring(0, tagLocationColonIndex) : null;
	    		String tagLocationName = tagLocationColonIndex > 0 ? horde.getStructures().substring(tagLocationColonIndex + 1) : null;
	    		TagKey<Structure> tag = tagLocationPrefix != null && tagLocationName != null ? TagInit.Structures.createStructureTag(tagLocationPrefix, tagLocationName) : null;
	    		if (tag != null && ((ServerLevel)level).structureManager().getStructureWithPieceAt(pos, tag).isValid()) {
	    			return horde;
	    		}
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
