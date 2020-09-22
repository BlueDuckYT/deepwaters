// Made with Blockbench 3.5.0
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package blueduck.deepwaters.client.renderer.model;

import blueduck.deepwaters.entity.BlufferFish;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

import static java.lang.Math.abs;

public class BlufferFishModel extends EntityModel<BlufferFish> {
	private final ModelRenderer body;
	private final ModelRenderer jaw;
	private final ModelRenderer leftfin;
	private final ModelRenderer rightfin;
	private final ModelRenderer tail;

	public BlufferFishModel() {
		textureWidth = 32;
		textureHeight = 32;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, 0.0F, false);

		jaw = new ModelRenderer(this);
		jaw.setRotationPoint(0.0F, 0.0F, -4.5F);
		body.addChild(jaw);
		setRotationAngle(jaw, 0.1745F, 0.0F, 0.0F);
		jaw.setTextureOffset(0, 15).addBox(-4.0F, -4.0F, -0.5F, 8.0F, 4.0F, 1.0F, 0.0F, false);

		leftfin = new ModelRenderer(this);
		leftfin.setRotationPoint(4.0603F, 18.0F, -1.342F);
		setRotationAngle(leftfin, -0.1745F, 0.6981F, 0.0F);
		leftfin.setTextureOffset(0, 16).addBox(-0.3972F, 2.8062F, 0.8417F, 0.0F, 2.0F, 4.0F, 0.0F, false);

		rightfin = new ModelRenderer(this);
		rightfin.setRotationPoint(-3.9397F, 18.0F, -1.342F);
		setRotationAngle(rightfin, -0.1745F, -0.6981F, 0.0F);
		rightfin.setTextureOffset(0, 16).addBox(0.8884F, 2.8062F, 0.8417F, 0.0F, 2.0F, 4.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 18.0F, 4.0F);
		setRotationAngle(tail, -0.0873F, 0.0F, 0.0F);
		tail.setTextureOffset(0, 0).addBox(0.0F, 0.9886F, -0.7385F, 0.0F, 4.0F, 4.0F, 0.0F, false);
		tail.setTextureOffset(16, 18).addBox(0.0F, -1.0114F, 3.2615F, 0.0F, 8.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
//		jaw.render(matrixStack, buffer, packedLight, packedOverlay);
		leftfin.render(matrixStack, buffer, packedLight, packedOverlay);
		rightfin.render(matrixStack, buffer, packedLight, packedOverlay);
		tail.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(BlufferFish entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.jaw.rotateAngleX = abs((MathHelper.sin(limbSwing * 1) * 0.5F));
		this.leftfin.rotateAngleY = abs((MathHelper.sin(limbSwing) * 1.5F));
		this.rightfin.rotateAngleY = (-1F * abs((MathHelper.sin(limbSwing) * 1.5F)));
		this.tail.rotateAngleY = (MathHelper.sin(limbSwing * 3) * 0.6F);
	}
}