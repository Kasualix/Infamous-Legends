package com.infamous.infamous_legends.network.message;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.infamous.infamous_legends.golem_types.PlankGolemType;
import com.infamous.infamous_legends.init.PlankGolemTypeInit;
import com.mojang.serialization.Codec;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkEvent;

public class PlankGolemTypeSyncPacket {
    private static final Codec<Map<ResourceLocation, PlankGolemType>> MAPPER =
            Codec.unboundedMap(ResourceLocation.CODEC, PlankGolemType.CODEC);

    public final Map<ResourceLocation, PlankGolemType> data;

    public PlankGolemTypeSyncPacket(Map<ResourceLocation, PlankGolemType> data) {
        this.data = data;
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeNbt((CompoundTag) (MAPPER.encodeStart(NbtOps.INSTANCE, this.data).result().orElse(new CompoundTag())));
    }

    public static PlankGolemTypeSyncPacket decode(FriendlyByteBuf buffer) {
        return new PlankGolemTypeSyncPacket(MAPPER.parse(NbtOps.INSTANCE, buffer.readNbt()).result().orElse(new HashMap<>()));
    }

    public void onPacketReceived(Supplier<NetworkEvent.Context> contextGetter) {
        NetworkEvent.Context context = contextGetter.get();
        context.enqueueWork(this::handlePacketOnMainThread);
        context.setPacketHandled(true);
    }

    private void handlePacketOnMainThread() {
        PlankGolemTypeInit.PLANK_GOLEM_TYPE_REGISTRY.setData(this.data);
    }
}
