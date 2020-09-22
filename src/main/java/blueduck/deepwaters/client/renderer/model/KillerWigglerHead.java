package blueduck.deepwaters.client.renderer.model;

// Made with Blockbench 3.5.0
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

import java.util.ArrayList;

public class KillerWigglerHead extends AbstractWormPart
{
	private final ModelRenderer head;
	private final ModelRenderer right_claws;
	private final ModelRenderer right_claws_top;
	private final ModelRenderer right_claws_bottom;
	private final ModelRenderer left_claws;
	private final ModelRenderer left_claws_top;
	private final ModelRenderer left_claws_bottom;
	private final ModelRenderer center_claws_up;
	private final ModelRenderer center_claws_down;
	private final ModelRenderer getModel;

	@Override
	public ModelRenderer getModel() {
		return head;
	}

	@Override
	ArrayList<ModelRenderer.ModelBox> bodyBoxes() {
		return null;
	}

	public KillerWigglerHead() {
		textureWidth = 512;
		textureHeight = 512;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -9.0F, 9.0F);
		head.setTextureOffset(42, 46).addBox(-13.0F, -9.4F, -20.0F, 2.0F, 18.0F, 18.0F, 0.0F, false);
		head.setTextureOffset(42, 46).addBox(11.0F, -9.4F, -20.0F, 2.0F, 18.0F, 18.0F, 0.0F, false);
		head.setTextureOffset(0, 82).addBox(-11.0F, -9.4F, -22.0F, 22.0F, 18.0F, 4.0F, 0.0F, false);
		head.setTextureOffset(64, 40).addBox(-11.0F, -9.4F, -2.0F, 22.0F, 18.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(0, 64).addBox(-6.0F, -7.9F, -22.5F, 12.0F, 12.0F, 4.0F, 0.0F, false);
		head.setTextureOffset(0, 20).addBox(-11.0F, -11.4F, -20.0F, 22.0F, 2.0F, 18.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-11.0F, 8.6F, -20.0F, 22.0F, 2.0F, 18.0F, 0.0F, false);
		head.setTextureOffset(62, 0).addBox(-7.0F, 4.6F, -26.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		head.setTextureOffset(62, 0).addBox(3.0F, 4.6F, -26.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		head.setTextureOffset(16, 172).addBox(-7.0F, 10.6F, -22.9F, 4.0F, 4.0F, 6.0F, 0.0F, false);
		head.setTextureOffset(16, 172).addBox(3.0F, 10.6F, -22.9F, 4.0F, 4.0F, 6.0F, 0.0F, false);

		right_claws = new ModelRenderer(this);
		right_claws.setRotationPoint(-12.0F, -1.2F, -13.6494F);
		head.addChild(right_claws);
		setRotationAngle(right_claws, 0.0F, -0.4363F, 0.0F);


		right_claws_top = new ModelRenderer(this);
		right_claws_top.setRotationPoint(0.0F, -3.0F, 0.0F);
		right_claws.addChild(right_claws_top);
		right_claws_top.setTextureOffset(84, 0).addBox(-9.8715F, -2.0F, -10.0F, 4.0F, 4.0F, 8.0F, 0.0F, false);
		right_claws_top.setTextureOffset(84, 12).addBox(-9.8715F, -2.0F, -2.0F, 10.0F, 4.0F, 4.0F, 0.0F, true);

		right_claws_bottom = new ModelRenderer(this);
		right_claws_bottom.setRotationPoint(0.0F, 3.0F, 0.0F);
		right_claws.addChild(right_claws_bottom);
		right_claws_bottom.setTextureOffset(84, 12).addBox(-9.8715F, -2.0F, -2.0F, 10.0F, 4.0F, 4.0F, 0.0F, true);
		right_claws_bottom.setTextureOffset(84, 0).addBox(-9.8715F, -2.0F, -10.0F, 4.0F, 4.0F, 8.0F, 0.0F, false);

		left_claws = new ModelRenderer(this);
		left_claws.setRotationPoint(12.0F, -1.2F, -13.6494F);
		head.addChild(left_claws);
		setRotationAngle(left_claws, 0.0F, 0.4363F, 0.0F);


		left_claws_top = new ModelRenderer(this);
		left_claws_top.setRotationPoint(0.0F, -3.0F, 0.0F);
		left_claws.addChild(left_claws_top);
		left_claws_top.setTextureOffset(84, 12).addBox(-0.1285F, -2.0F, -2.0F, 10.0F, 4.0F, 4.0F, 0.0F, false);
		left_claws_top.setTextureOffset(84, 0).addBox(5.8715F, -2.0F, -10.0F, 4.0F, 4.0F, 8.0F, 0.0F, false);

		left_claws_bottom = new ModelRenderer(this);
		left_claws_bottom.setRotationPoint(0.0F, 3.0F, 0.0F);
		left_claws.addChild(left_claws_bottom);
		left_claws_bottom.setTextureOffset(84, 12).addBox(-0.1285F, -2.0F, -2.0F, 10.0F, 4.0F, 4.0F, 0.0F, false);
		left_claws_bottom.setTextureOffset(84, 0).addBox(5.8715F, -2.0F, -10.0F, 4.0F, 4.0F, 8.0F, 0.0F, false);

		center_claws_up = new ModelRenderer(this);
		center_claws_up.setRotationPoint(0.55F, 23.0F, 10.5F);
		head.addChild(center_claws_up);
		setRotationAngle(center_claws_up, 0.8727F, 0.0F, 0.0F);
		center_claws_up.setTextureOffset(0, 20).addBox(-6.45F, -39.01F, -16.0443F, 2.0F, 2.0F, 6.0F, 0.0F, false);
		center_claws_up.setTextureOffset(0, 20).addBox(3.35F, -39.01F, -16.0443F, 2.0F, 2.0F, 6.0F, 0.0F, false);

		center_claws_down = new ModelRenderer(this);
		center_claws_down.setRotationPoint(-0.45F, 26.2866F, 12.1896F);
		head.addChild(center_claws_down);
		setRotationAngle(center_claws_down, -0.0873F, 0.0F, 0.0F);
		center_claws_down.setTextureOffset(0, 20).addBox(-5.55F, -11.076F, -41.4911F, 2.0F, 2.0F, 6.0F, 0.0F, false);
		center_claws_down.setTextureOffset(0, 20).addBox(4.45F, -11.076F, -41.4911F, 2.0F, 2.0F, 6.0F, 0.0F, false);

		getModel = new ModelRenderer(this);
		getModel.setRotationPoint(0.0F, 0.0F, 0.0F);

	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		head.render(matrixStack, buffer, packedLight, packedOverlay);
//		right_claws.render(matrixStack, buffer, packedLight, packedOverlay);
//		right_claws_top.render(matrixStack, buffer, packedLight, packedOverlay);
//		right_claws_bottom.render(matrixStack, buffer, packedLight, packedOverlay);
//		left_claws.render(matrixStack, buffer, packedLight, packedOverlay);
//		left_claws_top.render(matrixStack, buffer, packedLight, packedOverlay);
//		left_claws_bottom.render(matrixStack, buffer, packedLight, packedOverlay);
//		center_claws_up.render(matrixStack, buffer, packedLight, packedOverlay);
//		center_claws_down.render(matrixStack, buffer, packedLight, packedOverlay);
//		getModel.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}