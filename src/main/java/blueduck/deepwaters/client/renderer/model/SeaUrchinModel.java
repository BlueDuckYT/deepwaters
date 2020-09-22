package blueduck.deepwaters.client.renderer.model;// Made with Blockbench 3.5.0
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import blueduck.deepwaters.entity.SeaUrchin;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class SeaUrchinModel extends EntityModel<SeaUrchin>
{
	private final ModelRenderer Main;
	private final ModelRenderer Leg;
	private final ModelRenderer Leg2;
	private final ModelRenderer Leg3;
	private final ModelRenderer Leg4;
	private final ModelRenderer Leg5;
	private final ModelRenderer Leg6;
	private final ModelRenderer Leg7;
	private final ModelRenderer Leg8;
	private final ModelRenderer Arm;
	private final ModelRenderer Arm2;
	private final ModelRenderer Arm3;
	private final ModelRenderer Arm4;
	private final ModelRenderer Arm5;
	private final ModelRenderer Arm6;
	private final ModelRenderer Arm7;
	private final ModelRenderer Arm8;

	public SeaUrchinModel() {
		textureWidth = 64;
		textureHeight = 64;

		Main = new ModelRenderer(this);
		Main.setRotationPoint(0.0F, 24.0F, 0.0F);
		Main.setTextureOffset(0, 0).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 6.0F, 12.0F, 0.0F, false);
		Main.setTextureOffset(0, 26).addBox(-1.0F, -12.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		Leg = new ModelRenderer(this);
		Leg.setRotationPoint(0.0F, 16.6F, 7.4F);
		setRotationAngle(Leg, -0.7854F, 0.0F, 0.0F);
		Leg.setTextureOffset(0, 26).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		Leg2 = new ModelRenderer(this);
		Leg2.setRotationPoint(0.0F, 16.6F, -7.4F);
		setRotationAngle(Leg2, 0.7854F, 0.0F, 0.0F);
		Leg2.setTextureOffset(0, 26).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		Leg3 = new ModelRenderer(this);
		Leg3.setRotationPoint(-6.4F, 16.6F, -6.4F);
		setRotationAngle(Leg3, 0.7854F, 0.7854F, 0.0F);
		Leg3.setTextureOffset(0, 26).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		Leg4 = new ModelRenderer(this);
		Leg4.setRotationPoint(-6.4F, 16.6F, 6.6F);
		setRotationAngle(Leg4, 0.7854F, 2.3562F, 0.0F);
		Leg4.setTextureOffset(0, 26).addBox(-0.8586F, -2.8F, -0.8F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		Leg5 = new ModelRenderer(this);
		Leg5.setRotationPoint(6.3F, 16.6F, 6.3F);
		setRotationAngle(Leg5, 0.7854F, -2.3562F, 0.0F);
		Leg5.setTextureOffset(0, 26).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		Leg6 = new ModelRenderer(this);
		Leg6.setRotationPoint(6.4F, 16.6F, -6.7F);
		setRotationAngle(Leg6, 0.7854F, -0.7854F, 0.0F);
		Leg6.setTextureOffset(0, 26).addBox(-0.8586F, -2.8F, -0.8F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		Leg7 = new ModelRenderer(this);
		Leg7.setRotationPoint(7.5F, 16.6F, 0.4F);
		setRotationAngle(Leg7, -0.7854F, 1.5708F, 0.0F);
		Leg7.setTextureOffset(0, 26).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		Leg8 = new ModelRenderer(this);
		Leg8.setRotationPoint(-7.5F, 16.6F, 0.4F);
		setRotationAngle(Leg8, -0.7854F, -1.5708F, 0.0F);
		Leg8.setTextureOffset(0, 26).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		Arm = new ModelRenderer(this);
		Arm.setRotationPoint(0.0F, 21.0F, 7.0F);
		setRotationAngle(Arm, -1.5708F, 0.0F, 0.0F);
		Arm.setTextureOffset(0, 26).addBox(-1.0F, -3.0F, 1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		Arm2 = new ModelRenderer(this);
		Arm2.setRotationPoint(0.0F, 21.0F, -7.0F);
		setRotationAngle(Arm2, -1.5708F, 3.1416F, 0.0F);
		Arm2.setTextureOffset(0, 26).addBox(-1.0F, -3.0F, 1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		Arm3 = new ModelRenderer(this);
		Arm3.setRotationPoint(-7.0F, 21.0F, 0.0F);
		setRotationAngle(Arm3, -1.5708F, -1.5708F, 0.0F);
		Arm3.setTextureOffset(0, 26).addBox(-1.0F, -3.0F, 1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		Arm4 = new ModelRenderer(this);
		Arm4.setRotationPoint(7.0F, 21.0F, 0.0F);
		setRotationAngle(Arm4, -1.5708F, 1.5708F, 0.0F);
		Arm4.setTextureOffset(0, 26).addBox(-1.0F, -3.0F, 1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		Arm5 = new ModelRenderer(this);
		Arm5.setRotationPoint(6.4F, 21.0F, -6.0F);
		setRotationAngle(Arm5, -1.5708F, 2.3562F, 0.0F);
		Arm5.setTextureOffset(0, 26).addBox(-1.0F, -3.0F, 1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		Arm6 = new ModelRenderer(this);
		Arm6.setRotationPoint(-6.6F, 21.0F, -6.0F);
		setRotationAngle(Arm6, -1.5708F, -2.3562F, 0.0F);
		Arm6.setTextureOffset(0, 26).addBox(-1.0F, -3.0F, 1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		Arm7 = new ModelRenderer(this);
		Arm7.setRotationPoint(-6.6F, 21.0F, 6.0F);
		setRotationAngle(Arm7, -1.5708F, -0.8727F, 0.0F);
		Arm7.setTextureOffset(0, 26).addBox(-1.0F, -3.0F, 1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		Arm8 = new ModelRenderer(this);
		Arm8.setRotationPoint(6.4F, 21.0F, 6.0F);
		setRotationAngle(Arm8, -1.5708F, 0.7854F, 0.0F);
		Arm8.setTextureOffset(0, 26).addBox(-1.0F, -3.0F, 1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(SeaUrchin entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Main.render(matrixStack, buffer, packedLight, packedOverlay);
		Leg.render(matrixStack, buffer, packedLight, packedOverlay);
		Leg2.render(matrixStack, buffer, packedLight, packedOverlay);
		Leg3.render(matrixStack, buffer, packedLight, packedOverlay);
		Leg4.render(matrixStack, buffer, packedLight, packedOverlay);
		Leg5.render(matrixStack, buffer, packedLight, packedOverlay);
		Leg6.render(matrixStack, buffer, packedLight, packedOverlay);
		Leg7.render(matrixStack, buffer, packedLight, packedOverlay);
		Leg8.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm2.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm3.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm4.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm5.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm6.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm7.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm8.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}