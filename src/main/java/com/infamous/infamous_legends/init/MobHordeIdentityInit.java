package com.infamous.infamous_legends.init;

import java.util.List;
import java.util.Map;

import com.infamous.dungeons_libraries.data.util.CodecJsonDataManager;
import com.infamous.infamous_legends.hordes.HordeType;
import com.infamous.infamous_legends.hordes.MobHordeIdentity;
import com.infamous.infamous_legends.network.message.MobHordeIdentitySyncPacket;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;

public class MobHordeIdentityInit {
    public static final CodecJsonDataManager<MobHordeIdentity> MOB_HORDE_IDENTITY_REGISTRY = new CodecJsonDataManager<>("mob_horde_identity", MobHordeIdentity.CODEC);

    public static MobHordeIdentity getMobHordeIdentity(ResourceLocation resourceLocation) {
        return MOB_HORDE_IDENTITY_REGISTRY.getData().getOrDefault(resourceLocation, null);
    }

    public static List<MobHordeIdentity> getMobHordeIdentitiesByEntityType(EntityType<?> entityType) {
        return MOB_HORDE_IDENTITY_REGISTRY.getData().values().stream()
                .filter(mobHordeIdentity -> mobHordeIdentity.getEntityType().equals(entityType)).toList();
    }
    
    public static MobHordeIdentity getMobHordeIdentityByEntityTypeAndHorde(EntityType<?> entityType, HordeType horde) {
        return MOB_HORDE_IDENTITY_REGISTRY.getData().values().stream()
                .filter(mobHordeIdentity -> mobHordeIdentity.getEntityType().equals(entityType) && HordeTypeInit.getHordeTypeByName(mobHordeIdentity.getHorde()) == horde).findFirst().orElse(null);
    }

    public static MobHordeIdentitySyncPacket toPacket(Map<ResourceLocation, MobHordeIdentity> map) {
        return new MobHordeIdentitySyncPacket(map);
    }

    public static ResourceLocation getMobHordeIdentityKey(MobHordeIdentity MobHordeIdentity) {
        return MOB_HORDE_IDENTITY_REGISTRY.getData().entrySet().stream()
                .filter(entry -> entry.getValue().equals(MobHordeIdentity))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
