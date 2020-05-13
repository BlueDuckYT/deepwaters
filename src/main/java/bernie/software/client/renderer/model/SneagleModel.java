package bernie.software.client.renderer.model;// Made with Blockbench 3.5.1
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import bernie.software.entity.Sneagle;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class SneagleModel extends EntityModel<Sneagle>
{
	private final ModelRenderer main;
	private final ModelRenderer Shellbase;
	private final ModelRenderer head;
	private final ModelRenderer eyeR;
	private final ModelRenderer eyeL;
	private final ModelRenderer body;

	public SneagleModel() {
		textureWidth = 64;
		textureHeight = 50;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);


		Shellbase = new ModelRenderer(this);
		Shellbase.setRotationPoint(-1.0F, -6.31F, 5.51F);
		main.addChild(Shellbase);
		setRotationAngle(Shellbase, -0.0873F, 0.0F, 0.0F);
		Shellbase.setTextureOffset(30, 30).addBox(-3.475F, -4.549F, -5.4229F, 7.0F, 10.0F, 10.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(-1.0F, -1.56F, -4.75F);
		main.addChild(head);


		eyeR = new ModelRenderer(this);
		eyeR.setRotationPoint(-1.5608F, 0.1675F, 0.2037F);
		head.addChild(eyeR);
		setRotationAngle(eyeR, 0.0F, 0.0F, -0.0873F);
		eyeR.setTextureOffset(0, 4).addBox(-0.1213F, -6.8363F, -0.5252F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		eyeR.setTextureOffset(4, 4).addBox(-0.6728F, -8.3263F, -0.9737F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		eyeL = new ModelRenderer(this);
		eyeL.setRotationPoint(1.7393F, 0.1675F, 0.2037F);
		head.addChild(eyeL);
		setRotationAngle(eyeL, 0.0F, 0.0F, 0.0873F);
		eyeL.setTextureOffset(0, 4).addBox(-0.8622F, -6.8363F, -0.5252F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		eyeL.setTextureOffset(0, 0).addBox(-1.4137F, -8.3263F, -0.9737F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(body);
		body.setTextureOffset(0, 0).addBox(-4.378F, -1.0F, -7.728F, 7.0F, 1.0F, 16.0F, 0.0F, false);
		body.setTextureOffset(0, 17).addBox(-3.93F, -1.49F, -6.9F, 6.0F, 1.0F, 14.0F, 0.0F, false);
	}

	/**
	 * Sets this entity's model rotation angles
	 *
	 * @param entityIn
	 * @param limbSwing
	 * @param limbSwingAmount
	 * @param ageInTicks
	 * @param netHeadYaw
	 * @param headPitch
	 */
	@Override
	public void setRotationAngles(Sneagle entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{

	}


	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}