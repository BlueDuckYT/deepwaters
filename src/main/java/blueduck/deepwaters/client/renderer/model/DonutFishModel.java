// Made with Blockbench 3.5.0
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package blueduck.deepwaters.client.renderer.model;

import blueduck.deepwaters.entity.DonutFish;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class DonutFishModel extends EntityModel<DonutFish> {
	private final ModelRenderer Tail;
	private final ModelRenderer Body;
	private final ModelRenderer Fin;
	private final ModelRenderer Head;

	public DonutFishModel() {
		textureWidth = 16;
		textureHeight = 16;

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, 22.0F, 2.0F);
		Tail.setTextureOffset(2, 7).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		Tail.setTextureOffset(4, 7).addBox(0.0F, 0.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 22.0F, 0.0F);
		Body.setTextureOffset(0, 0).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(4, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(-0.5F, -2.0F, 1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(10, 0).addBox(-0.5F, 1.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		Fin = new ModelRenderer(this);
		Fin.setRotationPoint(0.0F, 20.0F, 0.0F);
		Fin.setTextureOffset(2, 7).addBox(0.0F, -2.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		Fin.setTextureOffset(4, 7).addBox(0.0F, -1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Fin.setTextureOffset(2, 7).addBox(0.0F, -1.0F, -2.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 22.0F, -2.0F);
		Head.setTextureOffset(0, 5).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(0, 7).addBox(0.0F, 0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(DonutFish entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.Tail.rotateAngleY = (MathHelper.sin(limbSwing * 2.5f) * 0.5F);
		this.Fin.rotateAngleZ = (MathHelper.sin(limbSwing * 2.5f) * 0.5F);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Tail.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		Fin.render(matrixStack, buffer, packedLight, packedOverlay);
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}