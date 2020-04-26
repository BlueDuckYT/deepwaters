// Made with Blockbench 3.5.0
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package bernie.software.client.renderer.model;

import bernie.software.entity.MuckGulper;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class MuckGulperModel extends EntityModel<MuckGulper> {
	private final ModelRenderer Body;
	private final ModelRenderer Tail;
	private final ModelRenderer Head;
	private final ModelRenderer Tooth4;
	private final ModelRenderer Tooth2;
	private final ModelRenderer Tooth3;
	private final ModelRenderer Tooth1;
	private final ModelRenderer FinLeft;
	private final ModelRenderer FinRight;

	public MuckGulperModel() {
		textureWidth = 25;
		textureHeight = 25;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 22.0F, -2.0F);
		Body.setTextureOffset(0, 11).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);
		Body.setTextureOffset(16, 12).addBox(0.0F, -2.0F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(16, 12).addBox(0.0F, -2.0F, 1.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, 22.0F, 1.0F);
		Tail.setTextureOffset(16, 12).addBox(0.0F, -2.0F, 1.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		Tail.setTextureOffset(14, 8).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F, true);
		Tail.setTextureOffset(12, 14).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 4.0F, 0.0F, false);
		Tail.setTextureOffset(16, 13).addBox(0.0F, -0.5F, 4.0F, 0.0F, 1.0F, 2.0F, 0.0F, true);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 22.0F, -5.0F);
		Head.setTextureOffset(0, 19).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);

		Tooth4 = new ModelRenderer(this);
		Tooth4.setRotationPoint(1.0F, 0.0F, -2.0F);
		Head.addChild(Tooth4);
		Tooth4.setTextureOffset(14, 21).addBox(0.0F, -1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		Tooth2 = new ModelRenderer(this);
		Tooth2.setRotationPoint(0.0F, -1.0F, -2.0F);
		Head.addChild(Tooth2);
		Tooth2.setTextureOffset(12, 24).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 0.0F, 1.0F, 0.0F, false);

		Tooth3 = new ModelRenderer(this);
		Tooth3.setRotationPoint(-1.0F, 0.0F, -2.0F);
		Head.addChild(Tooth3);
		Tooth3.setTextureOffset(14, 21).addBox(0.0F, -1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		Tooth1 = new ModelRenderer(this);
		Tooth1.setRotationPoint(0.0F, 1.0F, -2.0F);
		Head.addChild(Tooth1);
		Tooth1.setTextureOffset(12, 24).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 0.0F, 1.0F, 0.0F, false);

		FinLeft = new ModelRenderer(this);
		FinLeft.setRotationPoint(1.0F, 22.0F, -3.0F);
		FinLeft.setTextureOffset(13, 21).addBox(0.0F, 0.0F, -1.0F, 2.0F, 0.0F, 3.0F, 0.0F, false);
		FinLeft.setTextureOffset(15, 10).addBox(1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 2.0F, 0.0F, false);

		FinRight = new ModelRenderer(this);
		FinRight.setRotationPoint(-1.0F, 22.0F, -3.0F);
		FinRight.setTextureOffset(13, 18).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 0.0F, 3.0F, 0.0F, false);
		FinRight.setTextureOffset(15, 10).addBox(-2.0F, 0.0F, 2.0F, 1.0F, 0.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(MuckGulper entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.Tooth4.rotateAngleY = (MathHelper.sin(limbSwing * 1.5f) * 0.5f);
		this.Tooth3.rotateAngleY = (-1 * MathHelper.sin(limbSwing * 1.5f) * 0.5f);

		this.Tooth1.rotateAngleX = (MathHelper.cos(limbSwing * 1.5f) * 0.5f);
		this.Tooth2.rotateAngleX = (-1 * MathHelper.cos(limbSwing * 1.5f) * 0.5f);
		this.FinLeft.rotateAngleZ = (MathHelper.cos(limbSwing * 1.5f) * 0.5f);
		this.FinRight.rotateAngleZ = (-1 * MathHelper.cos(limbSwing * 1.5f) * 0.5f);
		this.Head.rotateAngleZ = (MathHelper.sin(limbSwing) * 5);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		Tail.render(matrixStack, buffer, packedLight, packedOverlay);
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Tooth4.render(matrixStack, buffer, packedLight, packedOverlay);
		Tooth2.render(matrixStack, buffer, packedLight, packedOverlay);
		Tooth3.render(matrixStack, buffer, packedLight, packedOverlay);
		Tooth1.render(matrixStack, buffer, packedLight, packedOverlay);
		FinLeft.render(matrixStack, buffer, packedLight, packedOverlay);
		FinRight.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}