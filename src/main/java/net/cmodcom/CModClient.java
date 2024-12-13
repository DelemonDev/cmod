package net.cmodcom;

import net.cmodcom.entity.ModEntities;
import net.cmodcom.entity.client.*;
import net.cmodcom.entity.custom.TankAmmoEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class CModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.MEDTANK, MedTankRenderer::new);
        EntityRendererRegistry.register(ModEntities.TANKAMMO, TankAmmoEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.MEDTANK, MedTankModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.TANKAMMO, TankAmmoModel::getTexturedModelData);
        ClientEventHandler.register();

    }
}
