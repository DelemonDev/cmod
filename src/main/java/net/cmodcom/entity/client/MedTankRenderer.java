package net.cmodcom.entity.client;

import net.cmodcom.CMod;
import net.cmodcom.entity.custom.MedTankEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class MedTankRenderer extends MobEntityRenderer<MedTankEntity, MedTankModel<MedTankEntity>> {
    private static final Identifier TEXTURE = new Identifier(CMod.MOD_ID,"textures/entity/tankmed.png");

    public MedTankRenderer(EntityRendererFactory.Context context) {
        super(context, new MedTankModel<>(context.getPart(ModModelLayers.MEDTANK)), 0.6f);
        //shadow f is the entity shadow
    }

    @Override
    public Identifier getTexture(MedTankEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(MedTankEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);

    }
}
