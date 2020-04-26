// Made with Blockbench 3.5.0
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package bernie.software.client.renderer.model;

import bernie.software.entity.vehicle.SurgeVehicle;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class SurgeModel extends EntityModel<SurgeVehicle> {
	private final ModelRenderer Main;
	private final ModelRenderer Hatch;
	private final ModelRenderer Body;
	private final ModelRenderer Right_Screw;
	private final ModelRenderer Left_Screw;

	public SurgeModel() {
		textureWidth = 94;
		textureHeight = 47;

		Main = new ModelRenderer(this);
		Main.setRotationPoint(0.0F, 24.0F, -3.0F);
		

		Hatch = new ModelRenderer(this);
		Hatch.setRotationPoint(0.0F, -3.1F, -4.0F);
		Main.addChild(Hatch);
		Hatch.setTextureOffset(70, 24).addBox(-2.0F, -2.5F, -6.1F, 4.0F, 1.0F, 6.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, -1.0F, -0.3F);
		Main.addChild(Body);
		Body.setTextureOffset(0, 21).addBox(4.0F, -5.5F, -10.7F, 1.0F, 6.0F, 20.0F, 0.0F, false);
		Body.setTextureOffset(0, 21).addBox(-10.0F, -5.5F, -8.7F, 1.0F, 6.0F, 20.0F, 0.0F, false);
		Body.setTextureOffset(0, 21).addBox(9.0F, -5.5F, -8.7F, 1.0F, 6.0F, 20.0F, 0.0F, false);
		Body.setTextureOffset(0, 21).addBox(-5.0F, -5.5F, -10.7F, 1.0F, 6.0F, 20.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(5.0F, -5.5F, -9.7F, 4.0F, 1.0F, 20.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(-9.0F, -5.5F, -9.7F, 4.0F, 1.0F, 20.0F, 0.0F, false);
		Body.setTextureOffset(42, 26).addBox(5.0F, -0.5F, -9.7F, 4.0F, 1.0F, 20.0F, 0.0F, false);
		Body.setTextureOffset(42, 26).addBox(-9.0F, -0.5F, -9.7F, 4.0F, 1.0F, 20.0F, 0.0F, false);
		Body.setTextureOffset(28, 2).addBox(-3.0F, -4.5F, -9.7F, 6.0F, 4.0F, 14.0F, 0.0F, false);
		Body.setTextureOffset(72, 18).addBox(-3.0F, -3.5F, -11.7F, 6.0F, 2.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(0, 6).addBox(-4.0F, -3.5F, -6.7F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		Body.setTextureOffset(0, 6).addBox(3.0F, -3.5F, -6.7F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		Body.setTextureOffset(54, 13).addBox(-3.0F, -3.0F, 5.3F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(1, 0).addBox(2.0F, -3.5F, 4.3F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(-3.0F, -3.5F, 4.3F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		Right_Screw = new ModelRenderer(this);
		Right_Screw.setRotationPoint(-7.0F, -3.5F, 1.0F);
		Main.addChild(Right_Screw);
		Right_Screw.setTextureOffset(0, 0).addBox(0.0F, -2.0F, -10.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Right_Screw.setTextureOffset(46, 0).addBox(-1.0F, -1.0F, -11.0F, 2.0F, 2.0F, 22.0F, 0.0F, false);
		Right_Screw.setTextureOffset(0, 0).addBox(0.0F, -2.0F, 6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Right_Screw.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, 5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Right_Screw.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, 9.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Right_Screw.setTextureOffset(0, 0).addBox(-2.0F, 0.0F, 4.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Right_Screw.setTextureOffset(0, 0).addBox(-2.0F, 0.0F, 8.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Right_Screw.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 3.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Right_Screw.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 7.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Right_Screw.setTextureOffset(0, 0).addBox(0.0F, -2.0F, 2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Right_Screw.setTextureOffset(0, 0).addBox(0.0F, -2.0F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Right_Screw.setTextureOffset(0, 0).addBox(0.0F, -2.0F, -6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Right_Screw.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, 1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Right_Screw.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -3.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Right_Screw.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -7.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Right_Screw.setTextureOffset(0, 0).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Right_Screw.setTextureOffset(0, 0).addBox(-2.0F, 0.0F, -4.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Right_Screw.setTextureOffset(0, 0).addBox(-2.0F, 0.0F, -8.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Right_Screw.setTextureOffset(0, 0).addBox(0.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Right_Screw.setTextureOffset(0, 0).addBox(0.0F, 0.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Right_Screw.setTextureOffset(0, 0).addBox(0.0F, 0.0F, -9.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		Left_Screw = new ModelRenderer(this);
		Left_Screw.setRotationPoint(7.0F, -3.5F, 1.0F);
		Main.addChild(Left_Screw);
		Left_Screw.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -10.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Left_Screw.setTextureOffset(46, 0).addBox(-1.0F, -1.0F, -11.0F, 2.0F, 2.0F, 22.0F, 0.0F, false);
		Left_Screw.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, 6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Left_Screw.setTextureOffset(0, 0).addBox(0.0F, -2.0F, 5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Left_Screw.setTextureOffset(0, 0).addBox(0.0F, -2.0F, 9.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Left_Screw.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 4.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Left_Screw.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 8.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Left_Screw.setTextureOffset(0, 0).addBox(-2.0F, 0.0F, 3.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Left_Screw.setTextureOffset(0, 0).addBox(-2.0F, 0.0F, 7.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Left_Screw.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, 2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Left_Screw.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Left_Screw.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Left_Screw.setTextureOffset(0, 0).addBox(0.0F, -2.0F, 1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Left_Screw.setTextureOffset(0, 0).addBox(0.0F, -2.0F, -3.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Left_Screw.setTextureOffset(0, 0).addBox(0.0F, -2.0F, -7.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Left_Screw.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Left_Screw.setTextureOffset(0, 0).addBox(0.0F, 0.0F, -4.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Left_Screw.setTextureOffset(0, 0).addBox(0.0F, 0.0F, -8.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Left_Screw.setTextureOffset(0, 0).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Left_Screw.setTextureOffset(0, 0).addBox(-2.0F, 0.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Left_Screw.setTextureOffset(0, 0).addBox(-2.0F, 0.0F, -9.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(SurgeVehicle entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		if (entity.getControllingPassenger() != null)
		{
			this.Right_Screw.rotateAngleZ = ageInTicks * 0.3F;
			this.Left_Screw.rotateAngleZ = ageInTicks * 0.3F;

		}

		this.Main.rotateAngleY = entity.rotationYaw * ((float) Math.PI / 180F) / 180;
		//float pitch = entityIn.rotationPitch * ((float) Math.PI / 180F);
		//this.Main.rotateAngleX = pitch;

//		this.Main.rotateAngleX = 0;
		//his.Main.rotateAngleY = entityIn.rotationYaw * ((float) Math.PI / 180F);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Main.render(matrixStack, buffer, packedLight, packedOverlay);
		Hatch.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		Right_Screw.render(matrixStack, buffer, packedLight, packedOverlay);
		Left_Screw.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}