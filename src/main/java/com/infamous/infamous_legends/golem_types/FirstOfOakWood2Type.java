package com.infamous.infamous_legends.golem_types;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class FirstOfOakWood2Type {
    public static final Codec<FirstOfOakWood2Type> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
                    ForgeRegistries.BLOCKS.getCodec().fieldOf("wood").forGetter(data -> data.wood),
                    Codec.STRING.optionalFieldOf("name", new String()).forGetter(data -> data.name),
                    Codec.STRING.optionalFieldOf("textureLocation", new String()).forGetter(data -> data.textureLocation),
                    Codec.STRING.optionalFieldOf("glowTextureLocation", new String()).forGetter(data -> data.glowTextureLocation)
            ).apply(builder, FirstOfOakWood2Type::new));

    private final Block wood;
    private final String name;
    private final String textureLocation;
    private final String glowTextureLocation;

    public FirstOfOakWood2Type(Block wood, String name, String textureLocation, String glowTextureLocation) {
        this.wood = wood;
        this.name = name;
        this.textureLocation = textureLocation;
        this.glowTextureLocation = glowTextureLocation;
    }

    public Block getWood() {
        return wood;
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
