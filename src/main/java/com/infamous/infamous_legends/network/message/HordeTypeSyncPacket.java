package com.infamous.infamous_legends.network.message;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.infamous.infamous_legends.hordes.HordeType;
import com.infamous.infamous_legends.init.HordeTypeInit;
import com.mojang.serialization.Codec;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkEvent;

public class HordeTypeSyncPacket {
    private static final Codec<Map<ResourceLocation, HordeType>> MAPPER =
            Codec.unboundedMap(ResourceLocation.CODEC, HordeType.CODEC);

    public final Map<ResourceLocation, HordeType> data;

    public HordeTypeSyncPacket(Map<ResourceLocation, HordeType> data) {
        this.data = data;
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeNbt((CompoundTag) (MAPPER.encodeStart(NbtOps.INSTANCE, this.data).result().orElse(new CompoundTag())));
    }

    public static HordeTypeSyncPacket decode(FriendlyByteBuf buffer) {
        return new HordeTypeSyncPacket(MAPPER.parse(NbtOps.INSTANCE, buffer.readNbt()).result().orElse(new HashMap<>()));
    }

    public void onPacketReceived(Supplier<NetworkEvent.Context> contextGetter) {
        NetworkEvent.Context context = contextGetter.get();
        context.enqueueWork(this::handlePacketOnMainThread);
        context.setPacketHandled(true);
    }

    private void handlePacketOnMainThread() {
        HordeTypeInit.HORDE_TYPE_REGISTRY.setData(this.data);
    }
}
