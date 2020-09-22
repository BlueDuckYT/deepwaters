package blueduck.deepwaters.client.renderer.model;


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

import java.util.ArrayList;

public class KillerWigglerBody extends AbstractWormPart
{
	private final ModelRenderer body_part1;
	private final ModelRenderer LL1;
	private final ModelRenderer pt1_LL1;
	private final ModelRenderer pt2_LL1;
	private final ModelRenderer RL1;
	private final ModelRenderer pt1_RL1;
	private final ModelRenderer pt2_RL1;
	private final ModelRenderer getModel;

	@Override
	ArrayList<ModelRenderer.ModelBox> bodyBoxes() {
		return null;
	}

	@Override
	public ModelRenderer getModel() {
		return body_part1;
	}

	public KillerWigglerBody() {
		textureWidth = 512;
		textureHeight = 512;

		body_part1 = new ModelRenderer(this);
		body_part1.setRotationPoint(0.0F, -8.5F, -8.0F);
		body_part1.setTextureOffset(156, 28).addBox(-9.0F, -6.6F, 1.0F, 18.0F, 12.0F, 14.0F, 0.0F, false);
		body_part1.setTextureOffset(0, 0).addBox(-2.0F, -10.6F, 5.8F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		LL1 = new ModelRenderer(this);
		LL1.setRotationPoint(7.29F, -0.33F, 7.8F);
		body_part1.addChild(LL1);


		pt1_LL1 = new ModelRenderer(this);
		pt1_LL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		LL1.addChild(pt1_LL1);
		setRotationAngle(pt1_LL1, 0.0F, 0.0F, -0.8727F);
		pt1_LL1.setTextureOffset(0, 124).addBox(-2.0006F, -0.0032F, -3.0F, 4.0F, 18.0F, 6.0F, 0.0F, false);

		pt2_LL1 = new ModelRenderer(this);
		pt2_LL1.setRotationPoint(12.5781F, 10.487F, 0.0F);
		LL1.addChild(pt2_LL1);
		setRotationAngle(pt2_LL1, 0.0F, 0.0F, -0.1745F);
		pt2_LL1.setTextureOffset(90, 60).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 16.0F, 4.0F, 0.0F, false);

		RL1 = new ModelRenderer(this);
		RL1.setRotationPoint(-7.29F, -0.33F, 7.8F);
		body_part1.addChild(RL1);


		pt1_RL1 = new ModelRenderer(this);
		pt1_RL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		RL1.addChild(pt1_RL1);
		setRotationAngle(pt1_RL1, 0.0F, 0.0F, 0.8727F);
		pt1_RL1.setTextureOffset(0, 124).addBox(-1.9994F, -0.0032F, -3.0F, 4.0F, 18.0F, 6.0F, 0.0F, false);

		pt2_RL1 = new ModelRenderer(this);
		pt2_RL1.setRotationPoint(-12.5781F, 10.487F, 0.0F);
		RL1.addChild(pt2_RL1);
		setRotationAngle(pt2_RL1, 0.0F, 0.0F, 0.1745F);
		pt2_RL1.setTextureOffset(90, 60).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 16.0F, 4.0F, 0.0F, false);

		getModel = new ModelRenderer(this);
		getModel.setRotationPoint(0.0F, 0.0F, 0.0F);

	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
//		body_part1.render(matrixStack, buffer, packedLight, packedOverlay);
		LL1.render(matrixStack, buffer, packedLight, packedOverlay);
		pt1_LL1.render(matrixStack, buffer, packedLight, packedOverlay);
		pt2_LL1.render(matrixStack, buffer, packedLight, packedOverlay);
		RL1.render(matrixStack, buffer, packedLight, packedOverlay);
		pt1_RL1.render(matrixStack, buffer, packedLight, packedOverlay);
		pt2_RL1.render(matrixStack, buffer, packedLight, packedOverlay);
		getModel.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}