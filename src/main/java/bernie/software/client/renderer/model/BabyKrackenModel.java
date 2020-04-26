// Made with Blockbench 3.5.0
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package bernie.software.client.renderer.model;

import bernie.software.entity.BabyKracken;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

import static java.lang.Math.abs;

public class BabyKrackenModel extends EntityModel<BabyKracken> {
	private final ModelRenderer hexapus;
	private final ModelRenderer head;
	private final ModelRenderer leg1;
	private final ModelRenderer leg1part2;
	private final ModelRenderer leg1part3;
	private final ModelRenderer leg2;
	private final ModelRenderer leg2part2;
	private final ModelRenderer leg2part3;
	private final ModelRenderer leg3;
	private final ModelRenderer leg3part2;
	private final ModelRenderer leg3part3;
	private final ModelRenderer leg4;
	private final ModelRenderer leg4part2;
	private final ModelRenderer leg4part3;
	private final ModelRenderer leg5;
	private final ModelRenderer leg5part2;
	private final ModelRenderer leg5part3;
	private final ModelRenderer leg6;
	private final ModelRenderer leg6part2;
	private final ModelRenderer leg6part3;
	private final ModelRenderer leg7;
	private final ModelRenderer leg7part2;
	private final ModelRenderer leg7part3;
	private final ModelRenderer leg8;
	private final ModelRenderer leg8part2;
	private final ModelRenderer leg8part4;

	public BabyKrackenModel() {
		textureWidth = 128;
		textureHeight = 128;

		hexapus = new ModelRenderer(this);
		hexapus.setRotationPoint(0.0F, -2.0F, 1.0F);
		

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 1.0F, -1.0F);
		hexapus.addChild(head);
		head.setTextureOffset(0, 0).addBox(-8.0F, -10.0F, -8.0F, 16.0F, 17.0F, 16.0F, 0.0F, false);
		head.setTextureOffset(58, 44).addBox(-5.0F, -7.0F, 9.0F, 10.0F, 11.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(26, 48).addBox(9.0F, -6.0F, -4.0F, 1.0F, 9.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(42, 33).addBox(-5.0F, -12.0F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
		head.setTextureOffset(44, 44).addBox(-9.0F, -8.0F, -6.0F, 1.0F, 13.0F, 12.0F, 0.0F, false);
		head.setTextureOffset(0, 33).addBox(-7.0F, -11.0F, -7.0F, 14.0F, 1.0F, 14.0F, 0.0F, false);
		head.setTextureOffset(62, 62).addBox(-10.0F, -6.0F, -4.0F, 1.0F, 9.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(48, 0).addBox(-7.0F, -9.0F, 8.0F, 14.0F, 15.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 48).addBox(8.0F, -8.0F, -6.0F, 1.0F, 13.0F, 12.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-3.0F, -7.0F, -9.0F, 6.0F, 10.0F, 1.0F, 0.0F, false);

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(7.0F, 8.0F, -8.0F);
		hexapus.addChild(leg1);
		leg1.setTextureOffset(40, 77).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg1part2 = new ModelRenderer(this);
		leg1part2.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg1.addChild(leg1part2);
		leg1part2.setTextureOffset(32, 73).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg1part3 = new ModelRenderer(this);
		leg1part3.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg1part2.addChild(leg1part3);
		leg1part3.setTextureOffset(24, 73).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(7.0F, 8.0F, -1.0F);
		hexapus.addChild(leg2);
		leg2.setTextureOffset(16, 73).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg2part2 = new ModelRenderer(this);
		leg2part2.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg2.addChild(leg2part2);
		leg2part2.setTextureOffset(8, 73).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg2part3 = new ModelRenderer(this);
		leg2part3.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg2part2.addChild(leg2part3);
		leg2part3.setTextureOffset(0, 73).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(7.0F, 8.0F, 6.0F);
		hexapus.addChild(leg3);
		leg3.setTextureOffset(72, 56).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg3part2 = new ModelRenderer(this);
		leg3part2.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg3.addChild(leg3part2);
		leg3part2.setTextureOffset(72, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg3part3 = new ModelRenderer(this);
		leg3part3.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg3part2.addChild(leg3part3);
		leg3part3.setTextureOffset(72, 24).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(-7.0F, 8.0F, 6.0F);
		hexapus.addChild(leg4);
		leg4.setTextureOffset(72, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg4part2 = new ModelRenderer(this);
		leg4part2.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg4.addChild(leg4part2);
		leg4part2.setTextureOffset(50, 69).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg4part3 = new ModelRenderer(this);
		leg4part3.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg4part2.addChild(leg4part3);
		leg4part3.setTextureOffset(42, 69).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg5 = new ModelRenderer(this);
		leg5.setRotationPoint(-7.0F, 8.0F, -1.0F);
		hexapus.addChild(leg5);
		leg5.setTextureOffset(34, 65).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg5part2 = new ModelRenderer(this);
		leg5part2.setRotationPoint(0.0F, 7.0F, 0.0F);
		leg5.addChild(leg5part2);
		leg5part2.setTextureOffset(26, 65).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg5part3 = new ModelRenderer(this);
		leg5part3.setRotationPoint(0.0F, 5.0F, 0.0F);
		leg5part2.addChild(leg5part3);
		leg5part3.setTextureOffset(64, 24).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg6 = new ModelRenderer(this);
		leg6.setRotationPoint(-7.0F, 8.0F, -8.0F);
		hexapus.addChild(leg6);
		leg6.setTextureOffset(64, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg6part2 = new ModelRenderer(this);
		leg6part2.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg6.addChild(leg6part2);
		leg6part2.setTextureOffset(44, 48).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg6part3 = new ModelRenderer(this);
		leg6part3.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg6part2.addChild(leg6part3);
		leg6part3.setTextureOffset(36, 48).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg7 = new ModelRenderer(this);
		leg7.setRotationPoint(0.0F, 8.0F, 6.0F);
		hexapus.addChild(leg7);
		leg7.setTextureOffset(22, 48).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg7part2 = new ModelRenderer(this);
		leg7part2.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg7.addChild(leg7part2);
		leg7part2.setTextureOffset(14, 48).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg7part3 = new ModelRenderer(this);
		leg7part3.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg7part2.addChild(leg7part3);
		leg7part3.setTextureOffset(0, 48).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg8 = new ModelRenderer(this);
		leg8.setRotationPoint(0.0F, 8.0F, -8.0F);
		hexapus.addChild(leg8);
		leg8.setTextureOffset(42, 33).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg8part2 = new ModelRenderer(this);
		leg8part2.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg8.addChild(leg8part2);
		leg8part2.setTextureOffset(6, 39).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg8part4 = new ModelRenderer(this);
		leg8part4.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg8part2.addChild(leg8part4);
		leg8part4.setTextureOffset(0, 33).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(BabyKracken entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.hexapus.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);

		this.leg2.rotateAngleZ = (-1 * abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.leg2part2.rotateAngleZ = (-1 * abs(MathHelper.sin(limbSwing)) * 0.4f);
		this.leg2part3.rotateAngleZ = (-1 * abs(MathHelper.sin(limbSwing)) * 0.5f);

		this.leg5.rotateAngleZ = (abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.leg5part2.rotateAngleZ = (abs(MathHelper.sin(limbSwing)) * 0.4f);
		this.leg5part3.rotateAngleZ = (abs(MathHelper.sin(limbSwing)) * 0.5f);

		this.leg8.rotateAngleX = (-1 * abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.leg8part2.rotateAngleX = (-1 * abs(MathHelper.sin(limbSwing)) * 0.4f);
		this.leg8part4.rotateAngleX = (-1 * abs(MathHelper.sin(limbSwing)) * 0.5f);

		this.leg7.rotateAngleX = (abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.leg7part2.rotateAngleX = (abs(MathHelper.sin(limbSwing)) * 0.4f);
		this.leg7part3.rotateAngleX = (abs(MathHelper.sin(limbSwing)) * 0.5f);


		this.leg1.rotateAngleX = (-1 * abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.leg1.rotateAngleZ = (-1 * abs(MathHelper.sin(limbSwing )) * 0.3f);
		this.leg1part2.rotateAngleX = (-1 * abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.leg1part2.rotateAngleZ = (-1 * abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.leg1part3.rotateAngleX = (-1 * abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.leg1part3.rotateAngleZ = (-1 * abs(MathHelper.sin(limbSwing )) * 0.3f);

		this.leg4.rotateAngleX = (abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.leg4.rotateAngleZ = (abs(MathHelper.sin(limbSwing )) * 0.3f);
		this.leg4part2.rotateAngleX = (abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.leg4part2.rotateAngleZ = (abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.leg4part3.rotateAngleX = (abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.leg4part3.rotateAngleZ = (abs(MathHelper.sin(limbSwing )) * 0.3f);

		this.leg6.rotateAngleX = (-1 *abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.leg6.rotateAngleZ = (abs(MathHelper.sin(limbSwing )) * 0.3f);
		this.leg6part2.rotateAngleX = (-1 * abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.leg6part2.rotateAngleZ = (abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.leg6part3.rotateAngleX = (-1 * abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.leg6part3.rotateAngleZ = (abs(MathHelper.sin(limbSwing )) * 0.3f);

		this.leg3.rotateAngleX = (abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.leg3.rotateAngleZ = (-1 * abs(MathHelper.sin(limbSwing )) * 0.3f);
		this.leg3part2.rotateAngleX = (abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.leg3part2.rotateAngleZ = (-1 * abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.leg3part3.rotateAngleX = (abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.leg3part3.rotateAngleZ = (-1 * abs(MathHelper.sin(limbSwing )) * 0.3f);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		hexapus.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		leg1.render(matrixStack, buffer, packedLight, packedOverlay);
		leg1part2.render(matrixStack, buffer, packedLight, packedOverlay);
		leg1part3.render(matrixStack, buffer, packedLight, packedOverlay);
		leg2.render(matrixStack, buffer, packedLight, packedOverlay);
		leg2part2.render(matrixStack, buffer, packedLight, packedOverlay);
		leg2part3.render(matrixStack, buffer, packedLight, packedOverlay);
		leg3.render(matrixStack, buffer, packedLight, packedOverlay);
		leg3part2.render(matrixStack, buffer, packedLight, packedOverlay);
		leg3part3.render(matrixStack, buffer, packedLight, packedOverlay);
		leg4.render(matrixStack, buffer, packedLight, packedOverlay);
		leg4part2.render(matrixStack, buffer, packedLight, packedOverlay);
		leg4part3.render(matrixStack, buffer, packedLight, packedOverlay);
		leg5.render(matrixStack, buffer, packedLight, packedOverlay);
		leg5part2.render(matrixStack, buffer, packedLight, packedOverlay);
		leg5part3.render(matrixStack, buffer, packedLight, packedOverlay);
		leg6.render(matrixStack, buffer, packedLight, packedOverlay);
		leg6part2.render(matrixStack, buffer, packedLight, packedOverlay);
		leg6part3.render(matrixStack, buffer, packedLight, packedOverlay);
		leg7.render(matrixStack, buffer, packedLight, packedOverlay);
		leg7part2.render(matrixStack, buffer, packedLight, packedOverlay);
		leg7part3.render(matrixStack, buffer, packedLight, packedOverlay);
		leg8.render(matrixStack, buffer, packedLight, packedOverlay);
		leg8part2.render(matrixStack, buffer, packedLight, packedOverlay);
		leg8part4.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}