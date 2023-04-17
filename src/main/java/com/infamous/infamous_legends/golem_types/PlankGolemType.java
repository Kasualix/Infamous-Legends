package com.infamous.infamous_legends.golem_types;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class PlankGolemType {
    public static final Codec<PlankGolemType> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
                    ForgeRegistries.BLOCKS.getCodec().fieldOf("planks").forGetter(data -> data.planks),
                    Codec.STRING.optionalFieldOf("name", new String()).forGetter(data -> data.name),
                    Codec.STRING.optionalFieldOf("textureLocation", new String()).forGetter(data -> data.textureLocation),
                    Codec.STRING.optionalFieldOf("glowTextureLocation", new String()).forGetter(data -> data.glowTextureLocation)
            ).apply(builder, PlankGolemType::new));

    private final Block planks;
    private final String name;
    private final String textureLocation;
    private final String glowTextureLocation;

    public PlankGolemType(Block planks, String name, String textureLocation, String glowTextureLocation) {
        this.planks = planks;
        this.name = name;
        this.textureLocation = textureLocation;
        this.glowTextureLocation = glowTextureLocation;
    }

    public Block getPlanks() {
        return planks;
    }
    
    public String getName() {
        return name;
    }
    
    public String getTextureLocation() {
        return textureLocation;
    }
    
    public String getGlowTextureLocation() {
        return glowTextureLocation;
    }
}
