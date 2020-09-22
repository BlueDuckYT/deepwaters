// Made with Blockbench 3.5.0
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package blueduck.deepwaters.client.renderer.model;

import blueduck.deepwaters.entity.LegFish;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class LegFishModel extends EntityModel<LegFish> {
	private final ModelRenderer Body;
	private final ModelRenderer LLeg;
	private final ModelRenderer RLeg;
	private final ModelRenderer Fins;
	private final ModelRenderer Top;
	private final ModelRenderer Left;
	private final ModelRenderer Right;

	public LegFishModel() {
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.setTextureOffset(0, 0).addBox(-4.0F, -9.0F, -11.0F, 8.0F, 5.0F, 14.0F, 0.0F, false);

		LLeg = new ModelRenderer(this);
		LLeg.setRotationPoint(2.0F, -6.5F, 3.0F);
		Body.addChild(LLeg);
		LLeg.setTextureOffset(14, 22).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);

		RLeg = new ModelRenderer(this);
		RLeg.setRotationPoint(-2.0F, -6.5F, 3.0F);
		Body.addChild(RLeg);
		RLeg.setTextureOffset(14, 22).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 8.0F, 0.0F, true);

		Fins = new ModelRenderer(this);
		Fins.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		Top = new ModelRenderer(this);
		Top.setRotationPoint(0.0F, 0.0F, 0.0F);
		Fins.addChild(Top);
		Top.setTextureOffset(34, 42).addBox(0.0F, -13.0F, -9.0F, 0.0F, 7.0F, 15.0F, 0.0F, false);

		Left = new ModelRenderer(this);
		Left.setRotationPoint(4.3F, 19.0F, -6.5F);
		setRotationAngle(Left, 0.0F, 0.0F, -0.3491F);
		Left.setTextureOffset(0, 22).addBox(0.0F, -1.0F, 0.5F, 0.0F, 2.0F, 3.0F, 0.0F, false);

		Right = new ModelRenderer(this);
		Right.setRotationPoint(-4.3F, 19.0F, -6.5F);
		setRotationAngle(Right, 0.0F, 0.0F, 0.3491F);
		Right.setTextureOffset(0, 22).addBox(0.0F, -1.0F, 0.5F, 0.0F, 2.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(LegFish entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        this.LLeg.rotateAngleX = MathHelper.sin(limbSwing) * .5f;
        this.RLeg.rotateAngleX = MathHelper.sin(limbSwing) * -.5f;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
//		LLeg.render(matrixStack, buffer, packedLight, packedOverlay);
//		RLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		Fins.render(matrixStack, buffer, packedLight, packedOverlay);
//		Top.render(matrixStack, buffer, packedLight, packedOverlay);
		Left.render(matrixStack, buffer, packedLight, packedOverlay);
		Right.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}