package com.infamous.infamous_legends.network.message;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.infamous.infamous_legends.hordes.MobHordeIdentity;
import com.infamous.infamous_legends.init.MobHordeIdentityInit;
import com.mojang.serialization.Codec;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkEvent;

public class MobHordeIdentitySyncPacket {
    private static final Codec<Map<ResourceLocation, MobHordeIdentity>> MAPPER =
            Codec.unboundedMap(ResourceLocation.CODEC, MobHordeIdentity.CODEC);

    public final Map<ResourceLocation, MobHordeIdentity> data;

    public MobHordeIdentitySyncPacket(Map<ResourceLocation, MobHordeIdentity> data) {
        this.data = data;
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeNbt((CompoundTag) (MAPPER.encodeStart(NbtOps.INSTANCE, this.data).result().orElse(new CompoundTag())));
    }

    public static MobHordeIdentitySyncPacket decode(FriendlyByteBuf buffer) {
        return new MobHordeIdentitySyncPacket(MAPPER.parse(NbtOps.INSTANCE, buffer.readNbt()).result().orElse(new HashMap<>()));
    }

    public void onPacketReceived(Supplier<NetworkEvent.Context> contextGetter) {
        NetworkEvent.Context context = contextGetter.get();
        context.enqueueWork(this::handlePacketOnMainThread);
        context.setPacketHandled(true);
    }

    private void handlePacketOnMainThread() {
        MobHordeIdentityInit.MOB_HORDE_IDENTITY_REGISTRY.setData(this.data);
    }
}
