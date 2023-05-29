package com.infamous.infamous_legends.init;

import com.infamous.infamous_legends.InfamousLegends;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class TagInit {
	
    public static class EntityTypes {
    	public static final TagKey<EntityType<?>> PIGLIN_ALLIES = tag("piglin_allies");  	
    	public static final TagKey<EntityType<?>> LEGENDS_PIGLIN_NEMESES = tag("legends_piglin_nemeses");
    	public static final TagKey<EntityType<?>> GOLEM_ALLIES = tag("golem_allies");  
    	
    	   private static TagKey<EntityType<?>> tag(String p_203849_) {
    		      return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(InfamousLegends.MOD_ID, p_203849_));
    	   }
    }
    
    public static class Blocks {
    	public static final TagKey<Block> UNBREAKABLE = tag("unbreakable");  	
    	
    	   private static TagKey<Block> tag(String p_203849_) {
    		      return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(InfamousLegends.MOD_ID, p_203849_));
    	   }
    }
    
    public static class Effects {
    	public static final TagKey<MobEffect> SPORKCHOP_EFFECTS = tag("sporkchop_effects");  	
    	
    	   private static TagKey<MobEffect> tag(String p_203849_) {
    		      return TagKey.create(Registry.MOB_EFFECT_REGISTRY, new ResourceLocation(InfamousLegends.MOD_ID, p_203849_));
    	   }
    }
    
    public static class Items {
    	public static final TagKey<Item> BIG_BEAK_BRED_WITH = tag("big_beak_bred_with");  	
    	public static final TagKey<Item> HEALS_BIG_BEAK = tag("heals_big_beak");  
    	public static final TagKey<Item> REGAL_TIGER_BRED_WITH = tag("regal_tiger_bred_with");  	
    	public static final TagKey<Item> HEALS_REGAL_TIGER = tag("heals_regal_tiger");  
    	
    	   private static TagKey<Item> tag(String p_203849_) {
    		      return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(InfamousLegends.MOD_ID, p_203849_));
    	   }
    }
    
    public static class Biomes {
    	//public static final TagKey<Biome> HORDE_OF_THE_BASTION_SPAWN_IN = tag("horde_of_the_bastion_spawn_in");  	
    	
	    	public static TagKey<Biome> createBiomeTag(String prefix, String name) {
	    		return tag(prefix, name);
	    	}
    	
    	   private static TagKey<Biome> tag(String prefix, String name) {
    		      return TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(prefix, name));
    	   }
    }
}
