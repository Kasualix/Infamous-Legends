package com.infamous.infamous_legends.network.message;

import java.util.function.Supplier;

import com.infamous.infamous_legends.capabilities.MobHordeProvider;
import com.infamous.infamous_legends.hordes.HordeType;
import com.infamous.infamous_legends.init.HordeTypeInit;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.NetworkEvent;

public class ServerToClientHordeSyncPacket {

    private final int entityId;
    private final String hordeName;

    public ServerToClientHordeSyncPacket(HordeType horde, int entityId) {
        this.entityId = entityId;
        this.hordeName = horde.getName();
    }

    public ServerToClientHordeSyncPacket(FriendlyByteBuf buf) {
    	entityId = buf.readInt();
    	hordeName = buf.readUtf();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(entityId);
        buf.writeUtf(hordeName);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {   
        	ClientLevel level = ((ClientLevel)Minecraft.getInstance().player.level);
        	Entity entity = level.getEntity(entityId);
        	
        	entity.getCapability(MobHordeProvider.HORDE).ifPresent((capability) -> {
        		capability.setHorde(HordeTypeInit.getHordeTypeByName(this.hordeName));
        	});
        });
        return true;
    }
}