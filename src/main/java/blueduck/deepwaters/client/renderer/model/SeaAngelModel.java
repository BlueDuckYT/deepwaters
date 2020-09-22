package blueduck.deepwaters.client.renderer.model;// Made with Blockbench 3.5.1
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import blueduck.deepwaters.entity.SeaAngel;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class SeaAngelModel extends EntityModel<SeaAngel>
{
	private final ModelRenderer Main;
	private final ModelRenderer Lfin;
	private final ModelRenderer Lfin2;
	private final ModelRenderer neck;

	public SeaAngelModel() {
		textureWidth = 32;
		textureHeight = 32;

		Main = new ModelRenderer(this);
		Main.setRotationPoint(0.0F, 24.0F, 0.0F);
		Main.setTextureOffset(0, 0).addBox(-2.0F, -10.0F, -2.0F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		Main.setTextureOffset(0, 7).addBox(-2.0F, -13.5F, -1.75F, 3.0F, 2.5F, 2.5F, 0.0F, false);
		Main.setTextureOffset(8, 14).addBox(-1.5F, -13.25F, -1.5F, 2.0F, 1.75F, 2.0F, 0.0F, false);
		Main.setTextureOffset(12, 3).addBox(-2.0F, -16.0F, -0.5F, 1.0F, 3.0F, 0.0F, 0.0F, false);
		Main.setTextureOffset(0, 0).addBox(0.0F, -16.0F, -0.5F, 1.0F, 3.0F, 0.0F, 0.0F, false);
		Main.setTextureOffset(8, 9).addBox(-1.5F, -6.0F, -1.5F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		Main.setTextureOffset(0, 11).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Lfin = new ModelRenderer(this);
		Lfin.setRotationPoint(1.625F, -7.5F, -0.5F);
		Main.addChild(Lfin);
		setRotationAngle(Lfin, 0.0F, 0.0F, -0.6981F);
		Lfin.setTextureOffset(6, 11).addBox(-0.875F, -2.0F, 0.0F, 1.75F, 4.0F, 0.0F, 0.0F, false);

		Lfin2 = new ModelRenderer(this);
		Lfin2.setRotationPoint(-2.625F, -7.5F, -0.5F);
		Main.addChild(Lfin2);
		setRotationAngle(Lfin2, 0.0F, 0.0F, 0.6981F);
		Lfin2.setTextureOffset(4, 11).addBox(-0.875F, -2.0F, 0.0F, 1.75F, 4.0F, 0.0F, 0.0F, false);

		neck = new ModelRenderer(this);
		neck.setRotationPoint(0.0F, 0.0F, 0.0F);
		Main.addChild(neck);
		neck.setTextureOffset(9, 0).addBox(-1.5F, -11.25F, -1.5F, 2.0F, 1.5F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(SeaAngel entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Main.render(matrixStack, buffer, packedLight, packedOverlay);
		//Lfin.render(matrixStack, buffer, packedLight, packedOverlay);
		//Lfin2.render(matrixStack, buffer, packedLight, packedOverlay);
		//neck.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}