package net.cmodcom.network;

import io.netty.buffer.Unpooled;
import net.cmodcom.entity.custom.MedTankEntity;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

public class FireAmmoPacket {
    public static final Identifier ID = new Identifier("cmodcom", "fire_tnt");

    public static void send() {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        ClientPlayNetworking.send(ID, buf);
    }

    public static void register() {
        ServerPlayNetworking.registerGlobalReceiver(ID, (server, player, handler, buf, responseSender) -> {
            server.execute(() -> {
                if (player.getVehicle() instanceof MedTankEntity tank) {
                    tank.fireAmmo(); //The actually firing
                }
            });
        });
    }
}