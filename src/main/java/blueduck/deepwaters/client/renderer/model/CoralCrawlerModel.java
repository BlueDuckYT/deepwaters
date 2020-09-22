// Made with Blockbench 3.5.0
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package blueduck.deepwaters.client.renderer.model;

import blueduck.deepwaters.entity.CoralCrawler;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class CoralCrawlerModel extends EntityModel<CoralCrawler> {
	private final ModelRenderer body;
	private final ModelRenderer body2;
	private final ModelRenderer tube1parts;
	private final ModelRenderer tube1part1;
	private final ModelRenderer tube1part2;
	private final ModelRenderer tube2;
	private final ModelRenderer tube2parts;
	private final ModelRenderer tube2part2;
	private final ModelRenderer rightleg;
	private final ModelRenderer leftlegs;
	private final ModelRenderer leftLegBack;
	private final ModelRenderer leftLegFront;

	public CoralCrawlerModel() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(-0.5F, 16.5F, 1.0F);
		setRotationAngle(body, -0.1745F, 0.0F, 0.2618F);
		body.setTextureOffset(0, 0).addBox(-4.5F, -1.5F, -5.0F, 9.0F, 3.0F, 10.0F, 0.0F, false);
		body.setTextureOffset(21, 21).addBox(-3.5F, 0.9319F, -4.0F, 7.0F, 2.0F, 7.0F, 0.0F, false);

		body2 = new ModelRenderer(this);
		body2.setRotationPoint(-1.2765F, -3.3978F, 0.5F);
		body.addChild(body2);
		setRotationAngle(body2, 0.0F, 0.0F, -0.2618F);
		body2.setTextureOffset(14, 27).addBox(1.7315F, -6.9345F, -1.4848F, 2.0F, 10.0F, 3.0F, 0.0F, false);
		body2.setTextureOffset(0, 13).addBox(-3.2235F, 1.0F, -4.0F, 7.0F, 3.0F, 7.0F, 0.0F, false);
		body2.setTextureOffset(21, 13).addBox(-1.2235F, 0.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);

		tube1parts = new ModelRenderer(this);
		tube1parts.setRotationPoint(4.7765F, -5.1022F, 0.0F);
		body2.addChild(tube1parts);
		setRotationAngle(tube1parts, 0.0F, 0.0F, -0.4363F);
		tube1parts.setTextureOffset(0, 13).addBox(-3.0F, 2.1522F, -0.5F, 3.0F, 2.0F, 0.0F, 0.0F, false);

		tube1part1 = new ModelRenderer(this);
		tube1part1.setRotationPoint(-0.6726F, 0.9063F, 1.0F);
		tube1parts.addChild(tube1part1);
		setRotationAngle(tube1part1, 0.0F, 0.0F, 0.3491F);
		tube1part1.setTextureOffset(21, 18).addBox(-4.3274F, -0.5F, 0.5F, 6.0F, 1.0F, 0.0F, 0.0F, false);

		tube1part2 = new ModelRenderer(this);
		tube1part2.setRotationPoint(1.092F, -1.8794F, 0.0F);
		tube1parts.addChild(tube1part2);
		setRotationAngle(tube1part2, 0.0F, 0.0F, -0.2618F);
		tube1part2.setTextureOffset(31, 31).addBox(-2.092F, -0.5F, -0.5F, 4.0F, 1.0F, 0.0F, 0.0F, false);

		tube2 = new ModelRenderer(this);
		tube2.setRotationPoint(-1.0F, 1.0F, 2.0F);
		body2.addChild(tube2);
		setRotationAngle(tube2, -0.3491F, 0.0F, -0.2618F);
		tube2.setTextureOffset(0, 23).addBox(-2.2235F, -12.0F, -3.0F, 3.0F, 13.0F, 4.0F, 0.0F, false);

		tube2parts = new ModelRenderer(this);
		tube2parts.setRotationPoint(-3.3966F, -6.8067F, -0.753F);
		tube2.addChild(tube2parts);
		setRotationAngle(tube2parts, 0.0F, 0.0F, 0.1745F);
		tube2parts.setTextureOffset(33, 13).addBox(-1.827F, -0.7045F, -1.253F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		tube2part2 = new ModelRenderer(this);
		tube2part2.setRotationPoint(4.7214F, -1.6819F, -0.6578F);
		tube2parts.addChild(tube2part2);
		setRotationAngle(tube2part2, 0.7854F, 0.0F, -0.6109F);
		tube2part2.setTextureOffset(10, 23).addBox(-1.5483F, -0.5F, -0.5F, 5.0F, 2.0F, 2.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-5.0F, 20.0F, 1.5F);
		setRotationAngle(rightleg, 0.0F, 0.0F, 0.0873F);
		rightleg.setTextureOffset(24, 30).addBox(-1.0F, -4.0F, -1.5F, 2.0F, 8.0F, 3.0F, 0.0F, false);

		leftlegs = new ModelRenderer(this);
		leftlegs.setRotationPoint(3.0F, 18.0F, 0.5F);
		setRotationAngle(leftlegs, 0.0F, -0.0873F, 0.0F);
		

		leftLegBack = new ModelRenderer(this);
		leftLegBack.setRotationPoint(0.0F, 0.0F, -2.5F);
		leftlegs.addChild(leftLegBack);
		leftLegBack.setTextureOffset(28, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		leftLegFront = new ModelRenderer(this);
		leftLegFront.setRotationPoint(0.0F, 1.0F, 2.5F);
		leftlegs.addChild(leftLegFront);
		leftLegFront.setTextureOffset(28, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(CoralCrawler entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.leftLegBack.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftLegFront.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

		this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
//		body2.render(matrixStack, buffer, packedLight, packedOverlay);
//		tube1parts.render(matrixStack, buffer, packedLight, packedOverlay);
//		tube1part1.render(matrixStack, buffer, packedLight, packedOverlay);
//		tube1part2.render(matrixStack, buffer, packedLight, packedOverlay);
//		tube2.render(matrixStack, buffer, packedLight, packedOverlay);
//		tube2parts.render(matrixStack, buffer, packedLight, packedOverlay);
//		tube2part2.render(matrixStack, buffer, packedLight, packedOverlay);
		rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
		leftlegs.render(matrixStack, buffer, packedLight, packedOverlay);
//		leftLegBack.render(matrixStack, buffer, packedLight, packedOverlay);
//		leftLegFront.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}