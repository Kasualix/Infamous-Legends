package com.infamous.infamous_legends.network.message;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.infamous.infamous_legends.golem_types.FirstOfOakWood2Type;
import com.infamous.infamous_legends.init.FirstOfOakWood2TypeInit;
import com.mojang.serialization.Codec;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkEvent;

public class FirstOfOakWood2TypeSyncPacket {
    private static final Codec<Map<ResourceLocation, FirstOfOakWood2Type>> MAPPER =
            Codec.unboundedMap(ResourceLocation.CODEC, FirstOfOakWood2Type.CODEC);

    public final Map<ResourceLocation, FirstOfOakWood2Type> data;

    public FirstOfOakWood2TypeSyncPacket(Map<ResourceLocation, FirstOfOakWood2Type> data) {
        this.data = data;
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeNbt((CompoundTag) (MAPPER.encodeStart(NbtOps.INSTANCE, this.data).result().orElse(new CompoundTag())));
    }

    public static FirstOfOakWood2TypeSyncPacket decode(FriendlyByteBuf buffer) {
        return new FirstOfOakWood2TypeSyncPacket(MAPPER.parse(NbtOps.INSTANCE, buffer.readNbt()).result().orElse(new HashMap<>()));
    }

    public void onPacketReceived(Supplier<NetworkEvent.Context> contextGetter) {
        NetworkEvent.Context context = contextGetter.get();
        context.enqueueWork(this::handlePacketOnMainThread);
        context.setPacketHandled(true);
    }

    private void handlePacketOnMainThread() {
    	FirstOfOakWood2TypeInit.FIRST_OF_OAK_WOOD_2_TYPE_REGISTRY.setData(this.data);
    }
}
