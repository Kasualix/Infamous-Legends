package com.infamous.infamous_legends.hordes;

import java.util.ArrayList;
import java.util.List;

import com.infamous.dungeons_libraries.items.gearconfig.GearConfigAttributeModifier;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class HordeType {
    public static final Codec<HordeType> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
                    Codec.STRING.optionalFieldOf("name", new String()).forGetter(data -> data.name),
                    GearConfigAttributeModifier.CODEC.listOf().optionalFieldOf("attributes", new ArrayList<>()).forGetter(eliteMobConfig -> eliteMobConfig.attributes)
            ).apply(builder, HordeType::new));

    private final String name;
    private final List<GearConfigAttributeModifier> attributes;

    public HordeType(String name, List<GearConfigAttributeModifier> attributes) {
        this.name = name;
        this.attributes = attributes;
    }
    
    public String getName() {
        return name;
    }
    
    public List<GearConfigAttributeModifier> getAttributes() {
        return attributes;
    }
}
