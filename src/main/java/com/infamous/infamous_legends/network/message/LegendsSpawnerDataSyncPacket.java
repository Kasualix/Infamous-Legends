package com.infamous.infamous_legends.network.message;

import com.infamous.infamous_legends.init.LegendsSpawnerDataInit;
import com.infamous.infamous_legends.spawner.LegendsSpawnerData;
import com.mojang.serialization.Codec;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LegendsSpawnerDataSyncPacket {
    private static final Codec<Map<ResourceLocation, LegendsSpawnerData>> MAPPER =
            Codec.unboundedMap(ResourceLocation.CODEC, LegendsSpawnerData.CODEC);

    public final Map<ResourceLocation, LegendsSpawnerData> data;

    public LegendsSpawnerDataSyncPacket(Map<ResourceLocation, LegendsSpawnerData> data) {
        this.data = data;
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeNbt((CompoundTag) (MAPPER.encodeStart(NbtOps.INSTANCE, this.data).result().orElse(new CompoundTag())));
    }

    public static LegendsSpawnerDataSyncPacket decode(FriendlyByteBuf buffer) {
        return new LegendsSpawnerDataSyncPacket(MAPPER.parse(NbtOps.INSTANCE, buffer.readNbt()).result().orElse(new HashMap<>()));
    }

    public void onPacketReceived(Supplier<NetworkEvent.Context> contextGetter) {
        NetworkEvent.Context context = contextGetter.get();
        context.enqueueWork(this::handlePacketOnMainThread);
        context.setPacketHandled(true);
    }

    private void handlePacketOnMainThread() {
        LegendsSpawnerDataInit.LEGENDS_SPAWNER_DATA_REGISTRY.setData(this.data);
    }
}
