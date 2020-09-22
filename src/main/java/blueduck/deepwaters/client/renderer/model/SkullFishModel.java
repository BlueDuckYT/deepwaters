// Made with Blockbench 3.5.0
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package blueduck.deepwaters.client.renderer.model;

import blueduck.deepwaters.entity.SkullFish;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class SkullFishModel extends EntityModel<SkullFish> {
	private final ModelRenderer Body;
	private final ModelRenderer Tail;
	private final ModelRenderer Head;
	private final ModelRenderer LeftFin;
	private final ModelRenderer RightFin;

	public SkullFishModel() {
		textureWidth = 16;
		textureHeight = 16;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 23.0F, -1.0F);
		Body.setTextureOffset(0, 1).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		Body.setTextureOffset(10, 4).addBox(0.0F, -2.0F, -1.0F, 0.0F, 1.0F, 3.0F, 0.0F, false);
		Body.setTextureOffset(8, 4).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, 23.0F, 1.0F);
		Tail.setTextureOffset(10, 5).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 3.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 23.0F, -2.05F);
		Head.setTextureOffset(8, 0).addBox(-1.0F, -1.0F, -2.05F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(8, 4).addBox(-0.5F, -0.5F, -1.95F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		LeftFin = new ModelRenderer(this);
		LeftFin.setRotationPoint(1.0F, 23.0F, -1.5F);
		LeftFin.setTextureOffset(0, 9).addBox(0.0F, 0.0F, -0.5F, 2.0F, 0.0F, 3.0F, 0.0F, false);

		RightFin = new ModelRenderer(this);
		RightFin.setRotationPoint(-1.0F, 23.0F, -1.5F);
		RightFin.setTextureOffset(0, 6).addBox(-2.0F, 0.0F, -0.5F, 2.0F, 0.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(SkullFish entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        this.LeftFin.rotateAngleZ = MathHelper.sin(limbSwing);
        this.RightFin.rotateAngleZ = MathHelper.sin(limbSwing) * -1;
        this.Tail.rotateAngleY = (MathHelper.sin(limbSwing) * 0.75f);
        this.Head.rotateAngleX = (Math.abs(MathHelper.sin(limbSwing)) * -.05f);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		Tail.render(matrixStack, buffer, packedLight, packedOverlay);
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftFin.render(matrixStack, buffer, packedLight, packedOverlay);
		RightFin.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}