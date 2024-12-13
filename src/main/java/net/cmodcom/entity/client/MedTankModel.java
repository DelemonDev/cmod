package net.cmodcom.entity.client;

import net.cmodcom.entity.custom.MedTankEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class MedTankModel<T extends MedTankEntity> extends SinglePartEntityModel<T> {
	private final ModelPart MedTank;
	public MedTankModel(ModelPart root) {
		this.MedTank = root.getChild("MedTank");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData MedTank = modelPartData.addChild("MedTank", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData Body = MedTank.addChild("Body", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -5.0F, -8.0F, 12.0F, 5.0F, 17.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData Turret = MedTank.addChild("Turret", ModelPartBuilder.create().uv(0, 36).cuboid(-1.0F, -3.0F, -10.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F))
		.uv(0, 22).cuboid(-4.0F, -5.0F, -4.0F, 8.0F, 5.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, 0.0F));

		ModelPartData Wheels = MedTank.addChild("Wheels", ModelPartBuilder.create().uv(34, 35).cuboid(7.0F, -2.0F, -5.0F, 2.0F, 2.0F, 11.0F, new Dilation(0.0F))
		.uv(34, 22).cuboid(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(MedTankEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		MedTank.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return MedTank;
	}

}