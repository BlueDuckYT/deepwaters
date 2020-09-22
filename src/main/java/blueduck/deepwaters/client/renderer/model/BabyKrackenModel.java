package blueduck.deepwaters.client.renderer.model;// Made with Blockbench 3.5.1
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import blueduck.deepwaters.entity.BabyKracken;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

import static java.lang.Math.abs;

public class BabyKrackenModel extends EntityModel<BabyKracken>
{
	private final ModelRenderer Main;
	private final ModelRenderer Head;
	private final ModelRenderer Arm1;
	private final ModelRenderer Arm11;
	private final ModelRenderer Arm12;
	private final ModelRenderer Arm13;
	private final ModelRenderer Arm2;
	private final ModelRenderer Arm21;
	private final ModelRenderer Arm22;
	private final ModelRenderer Arm23;
	private final ModelRenderer Arm3;
	private final ModelRenderer Arm31;
	private final ModelRenderer Arm32;
	private final ModelRenderer Arm33;
	private final ModelRenderer Arm4;
	private final ModelRenderer Arm41;
	private final ModelRenderer Arm42;
	private final ModelRenderer Arm43;
	private final ModelRenderer Arm5;
	private final ModelRenderer Arm51;
	private final ModelRenderer Arm52;
	private final ModelRenderer Arm53;
	private final ModelRenderer Arm6;
	private final ModelRenderer Arm61;
	private final ModelRenderer Arm62;
	private final ModelRenderer Arm63;
	private final ModelRenderer Arm7;
	private final ModelRenderer Arm71;
	private final ModelRenderer Arm72;
	private final ModelRenderer Arm73;
	private final ModelRenderer Arm8;
	private final ModelRenderer Arm81;
	private final ModelRenderer Arm82;
	private final ModelRenderer Arm83;

	public BabyKrackenModel() {
		textureWidth = 64;
		textureHeight = 64;

		Main = new ModelRenderer(this);
		Main.setRotationPoint(0.0F, 23.0F, 0.0F);


		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Main.addChild(Head);
		Head.setTextureOffset(0, 21).addBox(-4.0F, -14.0F, -4.0F, 8.0F, 3.0F, 8.0F, 0.0F, false);
		Head.setTextureOffset(0, 0).addBox(-5.0F, -25.0F, -5.0F, 10.0F, 11.0F, 10.0F, 0.0F, false);

		Arm1 = new ModelRenderer(this);
		Arm1.setRotationPoint(-3.0F, -11.0F, 3.0F);
		Main.addChild(Arm1);


		Arm11 = new ModelRenderer(this);
		Arm11.setRotationPoint(0.0F, 0.0F, 0.0F);
		Arm1.addChild(Arm11);
		Arm11.setTextureOffset(0, 44).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Arm12 = new ModelRenderer(this);
		Arm12.setRotationPoint(0.0F, 4.0F, 0.0F);
		Arm11.addChild(Arm12);
		Arm12.setTextureOffset(16, 38).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Arm13 = new ModelRenderer(this);
		Arm13.setRotationPoint(0.0F, 4.0F, 0.0F);
		Arm12.addChild(Arm13);
		Arm13.setTextureOffset(8, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Arm2 = new ModelRenderer(this);
		Arm2.setRotationPoint(-3.0F, -11.0F, 0.0F);
		Main.addChild(Arm2);


		Arm21 = new ModelRenderer(this);
		Arm21.setRotationPoint(0.0F, 0.0F, 0.0F);
		Arm2.addChild(Arm21);
		Arm21.setTextureOffset(38, 40).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Arm22 = new ModelRenderer(this);
		Arm22.setRotationPoint(0.0F, 4.0F, 0.0F);
		Arm21.addChild(Arm22);
		Arm22.setTextureOffset(32, 36).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Arm23 = new ModelRenderer(this);
		Arm23.setRotationPoint(0.0F, 4.0F, 0.0F);
		Arm22.addChild(Arm23);
		Arm23.setTextureOffset(24, 21).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Arm3 = new ModelRenderer(this);
		Arm3.setRotationPoint(-3.0F, -11.0F, -3.0F);
		Main.addChild(Arm3);


		Arm31 = new ModelRenderer(this);
		Arm31.setRotationPoint(0.0F, 0.0F, 0.0F);
		Arm3.addChild(Arm31);
		Arm31.setTextureOffset(42, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Arm32 = new ModelRenderer(this);
		Arm32.setRotationPoint(0.0F, 4.0F, 0.0F);
		Arm31.addChild(Arm32);
		Arm32.setTextureOffset(8, 38).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Arm33 = new ModelRenderer(this);
		Arm33.setRotationPoint(0.0F, 4.0F, 0.0F);
		Arm32.addChild(Arm33);
		Arm33.setTextureOffset(0, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Arm4 = new ModelRenderer(this);
		Arm4.setRotationPoint(0.0F, -11.0F, -3.0F);
		Main.addChild(Arm4);


		Arm41 = new ModelRenderer(this);
		Arm41.setRotationPoint(0.0F, 0.0F, 0.0F);
		Arm4.addChild(Arm41);
		Arm41.setTextureOffset(40, 10).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Arm42 = new ModelRenderer(this);
		Arm42.setRotationPoint(0.0F, 4.0F, 0.0F);
		Arm41.addChild(Arm42);
		Arm42.setTextureOffset(36, 4).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Arm43 = new ModelRenderer(this);
		Arm43.setRotationPoint(0.0F, 4.0F, 0.0F);
		Arm42.addChild(Arm43);
		Arm43.setTextureOffset(30, 30).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Arm5 = new ModelRenderer(this);
		Arm5.setRotationPoint(3.0F, -11.0F, -3.0F);
		Main.addChild(Arm5);


		Arm51 = new ModelRenderer(this);
		Arm51.setRotationPoint(0.0F, 0.0F, 0.0F);
		Arm5.addChild(Arm51);
		Arm51.setTextureOffset(40, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Arm52 = new ModelRenderer(this);
		Arm52.setRotationPoint(0.0F, 4.0F, 0.0F);
		Arm51.addChild(Arm52);
		Arm52.setTextureOffset(0, 38).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Arm53 = new ModelRenderer(this);
		Arm53.setRotationPoint(0.0F, 4.0F, 0.0F);
		Arm52.addChild(Arm53);
		Arm53.setTextureOffset(30, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Arm6 = new ModelRenderer(this);
		Arm6.setRotationPoint(3.0F, -11.0F, 0.0F);
		Main.addChild(Arm6);


		Arm61 = new ModelRenderer(this);
		Arm61.setRotationPoint(0.0F, 0.0F, 0.0F);
		Arm6.addChild(Arm61);
		Arm61.setTextureOffset(38, 31).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Arm62 = new ModelRenderer(this);
		Arm62.setRotationPoint(0.0F, 4.0F, 0.0F);
		Arm61.addChild(Arm62);
		Arm62.setTextureOffset(32, 21).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Arm63 = new ModelRenderer(this);
		Arm63.setRotationPoint(0.0F, 4.0F, 0.0F);
		Arm62.addChild(Arm63);
		Arm63.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Arm7 = new ModelRenderer(this);
		Arm7.setRotationPoint(3.0F, -11.0F, 3.0F);
		Main.addChild(Arm7);


		Arm71 = new ModelRenderer(this);
		Arm71.setRotationPoint(0.0F, 0.0F, 0.0F);
		Arm7.addChild(Arm71);
		Arm71.setTextureOffset(8, 44).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Arm72 = new ModelRenderer(this);
		Arm72.setRotationPoint(0.0F, 4.0F, 0.0F);
		Arm71.addChild(Arm72);
		Arm72.setTextureOffset(38, 25).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Arm73 = new ModelRenderer(this);
		Arm73.setRotationPoint(0.0F, 4.0F, 0.0F);
		Arm72.addChild(Arm73);
		Arm73.setTextureOffset(16, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Arm8 = new ModelRenderer(this);
		Arm8.setRotationPoint(0.0F, -11.0F, 3.0F);
		Main.addChild(Arm8);


		Arm81 = new ModelRenderer(this);
		Arm81.setRotationPoint(0.0F, 0.0F, 0.0F);
		Arm8.addChild(Arm81);
		Arm81.setTextureOffset(24, 40).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Arm82 = new ModelRenderer(this);
		Arm82.setRotationPoint(0.0F, 4.0F, 0.0F);
		Arm81.addChild(Arm82);
		Arm82.setTextureOffset(24, 34).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Arm83 = new ModelRenderer(this);
		Arm83.setRotationPoint(0.0F, 4.0F, 0.0F);
		Arm82.addChild(Arm83);
		Arm83.setTextureOffset(0, 21).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(BabyKracken entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.Main.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		this.Main.rotateAngleX = headPitch * ((float)Math.PI / 180F);

		this.Arm2.rotateAngleZ = (abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.Arm22.rotateAngleZ = (abs(MathHelper.sin(limbSwing)) * 0.4f);
		this.Arm23.rotateAngleZ = (abs(MathHelper.sin(limbSwing)) * 0.5f);

		this.Arm6.rotateAngleZ = (-1 *abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.Arm62.rotateAngleZ = (-1 *abs(MathHelper.sin(limbSwing)) * 0.4f);
		this.Arm63.rotateAngleZ = (-1 *abs(MathHelper.sin(limbSwing)) * 0.5f);

		this.Arm4.rotateAngleX = (-1 * abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.Arm42.rotateAngleX = (-1 * abs(MathHelper.sin(limbSwing)) * 0.4f);
		this.Arm43.rotateAngleX = (-1 * abs(MathHelper.sin(limbSwing)) * 0.5f);

		this.Arm8.rotateAngleX = (abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.Arm82.rotateAngleX = (abs(MathHelper.sin(limbSwing)) * 0.4f);
		this.Arm83.rotateAngleX = (abs(MathHelper.sin(limbSwing)) * 0.5f);


		this.Arm5.rotateAngleX = (-1 * abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.Arm5.rotateAngleZ = (-1 * abs(MathHelper.sin(limbSwing )) * 0.3f);
		this.Arm52.rotateAngleX = (-1 * abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.Arm52.rotateAngleZ = (-1 * abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.Arm53.rotateAngleX = (-1 * abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.Arm53.rotateAngleZ = (-1 * abs(MathHelper.sin(limbSwing )) * 0.3f);

		this.Arm1.rotateAngleX = (abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.Arm1.rotateAngleZ = (abs(MathHelper.sin(limbSwing )) * 0.3f);
		this.Arm12.rotateAngleX = (abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.Arm12.rotateAngleZ = (abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.Arm13.rotateAngleX = (abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.Arm13.rotateAngleZ = (abs(MathHelper.sin(limbSwing )) * 0.3f);

		this.Arm3.rotateAngleX = (-1 *abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.Arm3.rotateAngleZ = (abs(MathHelper.sin(limbSwing )) * 0.3f);
		this.Arm32.rotateAngleX = (-1 * abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.Arm32.rotateAngleZ = (abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.Arm33.rotateAngleX = (-1 * abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.Arm33.rotateAngleZ = (abs(MathHelper.sin(limbSwing )) * 0.3f);

		this.Arm7.rotateAngleX = (abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.Arm7.rotateAngleZ = (-1 * abs(MathHelper.sin(limbSwing )) * 0.3f);
		this.Arm72.rotateAngleX = (abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.Arm72.rotateAngleZ = (-1 * abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.Arm73.rotateAngleX = (abs(MathHelper.sin(limbSwing)) * 0.3f);
		this.Arm73.rotateAngleZ = (-1 * abs(MathHelper.sin(limbSwing )) * 0.3f);

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Main.render(matrixStack, buffer, packedLight, packedOverlay);
/*		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm1.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm11.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm12.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm13.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm2.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm21.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm22.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm23.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm3.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm31.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm32.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm33.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm4.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm41.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm42.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm43.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm5.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm51.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm52.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm53.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm6.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm61.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm62.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm63.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm7.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm71.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm72.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm73.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm8.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm81.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm82.render(matrixStack, buffer, packedLight, packedOverlay);
		Arm83.render(matrixStack, buffer, packedLight, packedOverlay);*/
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}