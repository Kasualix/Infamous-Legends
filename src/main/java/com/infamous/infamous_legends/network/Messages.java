package com.infamous.infamous_legends.network;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.network.message.LegendsSpawnerDataSyncPacket;
import com.infamous.infamous_legends.network.message.PlankGolemTypeSyncPacket;
import com.infamous.infamous_legends.network.message.ServerToClientShakeCameraPacket;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class Messages {

    public static SimpleChannel INSTANCE = NetworkRegistry.ChannelBuilder.named(
                    new ResourceLocation(InfamousLegends.MOD_ID, "messages"))
            .clientAcceptedVersions("1"::equals)
            .serverAcceptedVersions("1"::equals)
            .networkProtocolVersion(() -> "1")
            .simpleChannel();

    private static int packetId = 0;

    private static int id() {
        return packetId++;
    }

    public static void register() {
        INSTANCE.messageBuilder(ServerToClientShakeCameraPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(ServerToClientShakeCameraPacket::new)
                .encoder(ServerToClientShakeCameraPacket::toBytes)
                .consumerNetworkThread(ServerToClientShakeCameraPacket::handle)
                .add();

        INSTANCE.messageBuilder(LegendsSpawnerDataSyncPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .encoder(LegendsSpawnerDataSyncPacket::encode).decoder(LegendsSpawnerDataSyncPacket::decode)
                .consumerMainThread(LegendsSpawnerDataSyncPacket::onPacketReceived)
                .add();
        
        INSTANCE.messageBuilder(PlankGolemTypeSyncPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
        .encoder(PlankGolemTypeSyncPacket::encode).decoder(PlankGolemTypeSyncPacket::decode)
        .consumerMainThread(PlankGolemTypeSyncPacket::onPacketReceived)
        .add();


    }

    public static <MSG> void sendToServer(MSG message) {
        if (Minecraft.getInstance().getConnection() != null) {
            INSTANCE.sendToServer(message);
        }
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}