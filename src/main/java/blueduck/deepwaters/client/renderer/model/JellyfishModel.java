package blueduck.deepwaters.client.renderer.model;
// Made with Blockbench 3.5.1
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import blueduck.deepwaters.entity.Jellyfish;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class JellyfishModel extends EntityModel<Jellyfish>
{
	private final ModelRenderer head;
	private final ModelRenderer Arms;
	private final ModelRenderer JArm1;
	private final ModelRenderer Arm31;
	private final ModelRenderer Arm3;
	private final ModelRenderer JArm2;
	private final ModelRenderer Arm5;
	private final ModelRenderer Arm6;
	private final ModelRenderer JArm3;
	private final ModelRenderer Arm10;
	private final ModelRenderer Arm11;
	private final ModelRenderer JArm4;
	private final ModelRenderer Arm2;
	private final ModelRenderer Arm4;
	private final ModelRenderer JArm5;
	private final ModelRenderer Arm7;
	private final ModelRenderer Arm8;

	public JellyfishModel() {
		textureWidth = 28;
		textureHeight = 26;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 12.0F, 0.0F);
		head.setTextureOffset(0, 9).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-3.5F, 1.25F, -3.5F, 7.0F, 2.0F, 7.0F, 0.0F, false);

		Arms = new ModelRenderer(this);
		Arms.setRotationPoint(0.75F, 7.0F, 0.2F);
		head.addChild(Arms);


		JArm1 = new ModelRenderer(this);
		JArm1.setRotationPoint(-3.25F, -3.75F, -0.225F);
		Arms.addChild(JArm1);


		Arm31 = new ModelRenderer(this);
		Arm31.setRotationPoint(0.0F, 0.0F, 0.0F);
		JArm1.addChild(Arm31);
		Arm31.setTextureOffset(24, 15).addBox(-0.5F, -0.25F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

		Arm3 = new ModelRenderer(this);
		Arm3.setRotationPoint(0.0F, 3.5F, 0.0F);
		JArm1.addChild(Arm3);
		setRotationAngle(Arm3, 0.0F, -1.5708F, 0.0F);
		Arm3.setTextureOffset(24, 15).addBox(-0.5F, -3.75F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

		JArm2 = new ModelRenderer(this);
		JArm2.setRotationPoint(-0.7F, -3.75F, 2.275F);
		Arms.addChild(JArm2);


		Arm5 = new ModelRenderer(this);
		Arm5.setRotationPoint(1.0F, -0.25F, 0.275F);
		JArm2.addChild(Arm5);
		setRotationAngle(Arm5, 0.0F, -1.5708F, 0.0F);
		Arm5.setTextureOffset(24, 15).addBox(-0.75F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

		Arm6 = new ModelRenderer(this);
		Arm6.setRotationPoint(0.0F, -0.25F, 0.025F);
		JArm2.addChild(Arm6);
		Arm6.setTextureOffset(24, 15).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

		JArm3 = new ModelRenderer(this);
		JArm3.setRotationPoint(-0.7F, -3.75F, -0.25F);
		Arms.addChild(JArm3);


		Arm10 = new ModelRenderer(this);
		Arm10.setRotationPoint(1.0F, -0.25F, 4.275F);
		JArm3.addChild(Arm10);
		setRotationAngle(Arm10, 0.0F, -1.5708F, 0.0F);
		Arm10.setTextureOffset(24, 15).addBox(-4.75F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

		Arm11 = new ModelRenderer(this);
		Arm11.setRotationPoint(0.0F, -0.25F, 4.025F);
		JArm3.addChild(Arm11);
		Arm11.setTextureOffset(24, 15).addBox(-0.5F, 0.0F, -4.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

		JArm4 = new ModelRenderer(this);
		JArm4.setRotationPoint(1.725F, -3.75F, 0.0F);
		Arms.addChild(JArm4);


		Arm2 = new ModelRenderer(this);
		Arm2.setRotationPoint(1.0F, -0.25F, 0.025F);
		JArm4.addChild(Arm2);
		setRotationAngle(Arm2, 0.0F, -1.5708F, 0.0F);
		Arm2.setTextureOffset(24, 15).addBox(-0.75F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

		Arm4 = new ModelRenderer(this);
		Arm4.setRotationPoint(0.0F, -0.25F, -0.225F);
		JArm4.addChild(Arm4);
		Arm4.setTextureOffset(24, 15).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

		JArm5 = new ModelRenderer(this);
		JArm5.setRotationPoint(-0.7F, -3.75F, -2.725F);
		Arms.addChild(JArm5);


		Arm7 = new ModelRenderer(this);
		Arm7.setRotationPoint(1.0F, -0.25F, 4.275F);
		JArm5.addChild(Arm7);
		setRotationAngle(Arm7, 0.0F, -1.5708F, 0.0F);
		Arm7.setTextureOffset(24, 15).addBox(-4.75F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

		Arm8 = new ModelRenderer(this);
		Arm8.setRotationPoint(0.0F, -0.25F, 4.025F);
		JArm5.addChild(Arm8);
		Arm8.setTextureOffset(24, 15).addBox(-0.5F, 0.0F, -4.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Jellyfish entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		head.render(matrixStack, buffer, packedLight, packedOverlay);

	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}