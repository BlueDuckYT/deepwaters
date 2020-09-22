// Made with Blockbench 3.5.0
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package blueduck.deepwaters.client.renderer.model;

import blueduck.deepwaters.entity.JungleFish;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class JungleFishModel extends EntityModel<JungleFish> {
	private final ModelRenderer Fish;
	private final ModelRenderer fintop1;
	private final ModelRenderer fintop2;
	private final ModelRenderer finbottom1;
	private final ModelRenderer finbottom2;
	private final ModelRenderer mainfin;

	public JungleFishModel() {
		textureWidth = 16;
		textureHeight = 16;

		Fish = new ModelRenderer(this);
		Fish.setRotationPoint(0.0F, 21.0F, -2.0F);
		Fish.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);

		fintop1 = new ModelRenderer(this);
		fintop1.setRotationPoint(0.0F, -1.0F, 0.0F);
		Fish.addChild(fintop1);
		fintop1.setTextureOffset(4, 0).addBox(0.0F, -2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		fintop2 = new ModelRenderer(this);
		fintop2.setRotationPoint(0.0F, -1.0F, 2.0F);
		Fish.addChild(fintop2);
		fintop2.setTextureOffset(0, 7).addBox(0.0F, -2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		finbottom1 = new ModelRenderer(this);
		finbottom1.setRotationPoint(0.0F, 1.0F, 0.0F);
		Fish.addChild(finbottom1);
		finbottom1.setTextureOffset(0, 0).addBox(0.0F, 0.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		finbottom2 = new ModelRenderer(this);
		finbottom2.setRotationPoint(0.0F, 1.0F, 2.0F);
		Fish.addChild(finbottom2);
		finbottom2.setTextureOffset(2, 0).addBox(0.0F, 0.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		mainfin = new ModelRenderer(this);
		mainfin.setRotationPoint(0.0F, 0.0F, 3.0F);
		Fish.addChild(mainfin);
		mainfin.setTextureOffset(0, 0).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 3.0F, 0.0F, false);
		mainfin.setTextureOffset(2, 4).addBox(0.0F, -2.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		mainfin.setTextureOffset(0, 4).addBox(0.0F, 1.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(JungleFish entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        this.mainfin.rotateAngleY = MathHelper.sin(ageInTicks);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Fish.render(matrixStack, buffer, packedLight, packedOverlay);
//		fintop1.render(matrixStack, buffer, packedLight, packedOverlay);
//		fintop2.render(matrixStack, buffer, packedLight, packedOverlay);
//		finbottom1.render(matrixStack, buffer, packedLight, packedOverlay);
//		finbottom2.render(matrixStack, buffer, packedLight, packedOverlay);
//		mainfin.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}