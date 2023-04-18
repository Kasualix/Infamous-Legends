package com.infamous.infamous_legends.network.message;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.infamous.infamous_legends.golem_types.FirstOfOakWood1Type;
import com.infamous.infamous_legends.init.FirstOfOakWood1TypeInit;
import com.mojang.serialization.Codec;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkEvent;

public class FirstOfOakWood1TypeSyncPacket {
    private static final Codec<Map<ResourceLocation, FirstOfOakWood1Type>> MAPPER =
            Codec.unboundedMap(ResourceLocation.CODEC, FirstOfOakWood1Type.CODEC);

    public final Map<ResourceLocation, FirstOfOakWood1Type> data;

    public FirstOfOakWood1TypeSyncPacket(Map<ResourceLocation, FirstOfOakWood1Type> data) {
        this.data = data;
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeNbt((CompoundTag) (MAPPER.encodeStart(NbtOps.INSTANCE, this.data).result().orElse(new CompoundTag())));
    }

    public static FirstOfOakWood1TypeSyncPacket decode(FriendlyByteBuf buffer) {
        return new FirstOfOakWood1TypeSyncPacket(MAPPER.parse(NbtOps.INSTANCE, buffer.readNbt()).result().orElse(new HashMap<>()));
    }

    public void onPacketReceived(Supplier<NetworkEvent.Context> contextGetter) {
        NetworkEvent.Context context = contextGetter.get();
        context.enqueueWork(this::handlePacketOnMainThread);
        context.setPacketHandled(true);
    }

    private void handlePacketOnMainThread() {
    	FirstOfOakWood1TypeInit.FIRST_OF_OAK_WOOD_1_TYPE_REGISTRY.setData(this.data);
    }
}
