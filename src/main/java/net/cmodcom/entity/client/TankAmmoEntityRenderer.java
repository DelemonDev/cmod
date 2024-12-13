package net.cmodcom.entity.client;

import net.cmodcom.CMod;
import net.cmodcom.entity.custom.TankAmmoEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class TankAmmoEntityRenderer extends EntityRenderer<TankAmmoEntity> {

    public static final Identifier TEXTURE = new Identifier(CMod.MOD_ID, "textures/entity/tankammo.png");

    protected TankAmmoModel model;
    public TankAmmoEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        model = new TankAmmoModel(context.getPart(ModModelLayers.TANKAMMO));
    }

    @Override
    public Identifier getTexture(TankAmmoEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(TankAmmoEntity entity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();

        // Apply transformations
        matrixStack.translate(0.0D, -1.0, 0.0D); // Adjusted to center the model
        matrixStack.scale(1.0F, 1.0F, 1.0F);

        // Bind the texture
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(model.getLayer(TEXTURE));

        // Render the model
        model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);

        matrixStack.pop();
        super.render(entity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}