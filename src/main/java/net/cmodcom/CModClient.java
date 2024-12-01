package net.cmodcom;

import net.cmodcom.entity.ModEntities;
import net.cmodcom.entity.client.MedTankModel;
import net.cmodcom.entity.client.MedTankRenderer;
import net.cmodcom.entity.client.ModModelLayers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;


public class CModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.MEDTANK, MedTankRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.MEDTANK, MedTankModel::getTexturedModelData);
    }
}
