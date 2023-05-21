package com.infamous.infamous_legends.hordes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.ForgeRegistries;

public class MobHordeIdentity {
    public static final Codec<MobHordeIdentity> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
                    Codec.STRING.optionalFieldOf("entityType", new String()).forGetter(data -> data.entityType),
                    Codec.STRING.optionalFieldOf("horde", new String()).forGetter(data -> data.horde),
                    Codec.BOOL.optionalFieldOf("modifyAttributes", true).forGetter(data -> data.modifyAttributes)
            ).apply(builder, MobHordeIdentity::new));

    private final String entityType;
    private final String horde;
    private final boolean modifyAttributes;

    public MobHordeIdentity(String entityType, String horde, boolean modifyAttributes) {
        this.entityType = entityType;
        this.horde = horde;
        this.modifyAttributes = modifyAttributes;
    }
    
    public EntityType<?> getEntityType() {
        return ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(entityType));
    }
    
    public String getHorde() {
        return horde;
    }
    
    public boolean modifyAttributes() {
    	return modifyAttributes;
    }
}
