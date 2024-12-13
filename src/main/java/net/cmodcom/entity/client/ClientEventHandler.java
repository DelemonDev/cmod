package net.cmodcom.entity.client;


import net.cmodcom.entity.custom.MedTankEntity;
import net.cmodcom.item.ModItems;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import net.cmodcom.network.FireAmmoPacket;

public class ClientEventHandler {
    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (MinecraftClient.getInstance().player != null && MinecraftClient.getInstance().player.hasVehicle() && MinecraftClient.getInstance().player.getVehicle() instanceof MedTankEntity tank) {
                if (InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_SPACE) && tank.getAmmoCooldown() == 0 && MinecraftClient.getInstance().player.getInventory().count(ModItems.TANKAMMO) > 0) {
                    FireAmmoPacket.send(); // the basic function of the firing
                }
            }
        });
    }
}