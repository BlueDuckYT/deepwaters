// Made with Blockbench 3.5.0
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package bernie.software.client.renderer.model;

import bernie.software.entity.Stingray;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import bernie.software.entity.Stingray;

public class StingrayModel extends EntityModel<Stingray> {
	private final ModelRenderer Stingray;
	private final ModelRenderer Body;
	private final ModelRenderer mouth;
	private final ModelRenderer Lefthand;
	private final ModelRenderer smallfinleft;
	private final ModelRenderer Righthand;
	private final ModelRenderer smallfinright;
	private final ModelRenderer Tail;
	private final ModelRenderer tail1;
	private final ModelRenderer tail2;
	private final ModelRenderer tail3;
	private final ModelRenderer tail4;
	private final ModelRenderer stinger;
	private final ModelRenderer bone;
	private final ModelRenderer AllExcept12;
	private final ModelRenderer AllExcept123;

	public StingrayModel() {
		textureWidth = 128;
		textureHeight = 128;

		Stingray = new ModelRenderer(this);
		Stingray.setRotationPoint(2.0F, 24.0F, 12.0F);
		Stingray.setTextureOffset(6, 6).addBox(1.0F, -5.0F, -19.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		Stingray.setTextureOffset(0, 4).addBox(-7.0F, -5.0F, -19.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(-2.0F, 0.0F, -12.0F);
		Stingray.addChild(Body);
		Body.setTextureOffset(70, 41).addBox(-4.0F, -2.0F, -8.0F, 8.0F, 2.0F, 16.0F, 0.0F, false);
		Body.setTextureOffset(0, 36).addBox(-5.0F, -4.0F, -8.0F, 10.0F, 2.0F, 16.0F, 0.0F, false);
		Body.setTextureOffset(50, 18).addBox(-7.0F, -3.0F, -10.0F, 14.0F, 2.0F, 2.0F, 0.0F, false);

		mouth = new ModelRenderer(this);
		mouth.setRotationPoint(0.0F, -2.0F, -2.0F);
		Body.addChild(mouth);
		setRotationAngle(mouth, 1.8326F, 0.0F, 0.0F);
		mouth.setTextureOffset(50, 22).addBox(-2.0F, -2.2251F, -2.6648F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Lefthand = new ModelRenderer(this);
		Lefthand.setRotationPoint(-4.0F, -0.75F, 0.0F);
		Body.addChild(Lefthand);
		Lefthand.setTextureOffset(4, 18).addBox(-13.0F, -1.25F, -8.0F, 13.0F, 2.0F, 16.0F, 0.0F, false);

		smallfinleft = new ModelRenderer(this);
		smallfinleft.setRotationPoint(-12.0F, 0.75F, 0.0F);
		Lefthand.addChild(smallfinleft);
		smallfinleft.setTextureOffset(50, 0).addBox(-5.0F, -2.0F, -6.0F, 4.0F, 2.0F, 12.0F, 0.0F, false);

		Righthand = new ModelRenderer(this);
		Righthand.setRotationPoint(4.0F, -0.75F, 0.0F);
		Body.addChild(Righthand);
		Righthand.setTextureOffset(4, 0).addBox(0.0F, -1.25F, -8.0F, 13.0F, 2.0F, 16.0F, 0.0F, false);

		smallfinright = new ModelRenderer(this);
		smallfinright.setRotationPoint(13.0F, 0.75F, 0.0F);
		Righthand.addChild(smallfinright);
		smallfinright.setTextureOffset(38, 38).addBox(0.0F, -2.0F, -6.0F, 4.0F, 2.0F, 12.0F, 0.0F, false);

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(-2.0F, -2.0F, -4.0F);
		Stingray.addChild(Tail);
		

		tail1 = new ModelRenderer(this);
		tail1.setRotationPoint(1.0F, 2.0F, -1.0F);
		Tail.addChild(tail1);
		tail1.setTextureOffset(20, 54).addBox(-3.0F, -4.0F, 1.0F, 4.0F, 4.0F, 6.0F, 0.0F, false);

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, 1.0F, 6.0F);
		Tail.addChild(tail2);
		

		tail3 = new ModelRenderer(this);
		tail3.setRotationPoint(0.0F, 0.0F, 12.0F);
		Tail.addChild(tail3);
		

		tail4 = new ModelRenderer(this);
		tail4.setRotationPoint(0.0F, 0.0F, 18.0F);
		Tail.addChild(tail4);
		

		stinger = new ModelRenderer(this);
		stinger.setRotationPoint(0.0F, 0.5F, 5.5F);
		tail4.addChild(stinger);
		

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.1057F, -0.4766F, -17.75F);
		stinger.addChild(bone);
		bone.setTextureOffset(34, 58).addBox(-2.1057F, -2.0234F, 0.25F, 4.0F, 4.0F, 6.0F, 0.0F, false);

		AllExcept12 = new ModelRenderer(this);
		AllExcept12.setRotationPoint(0.067F, 0.0703F, 6.0F);
		bone.addChild(AllExcept12);
		AllExcept12.setTextureOffset(0, 54).addBox(-2.1726F, -2.0937F, 0.25F, 4.0F, 4.0F, 6.0F, 0.0F, false);

		AllExcept123 = new ModelRenderer(this);
		AllExcept123.setRotationPoint(0.0F, 0.25F, 6.25F);
		AllExcept12.addChild(AllExcept123);
		AllExcept123.setTextureOffset(48, 52).addBox(-2.1726F, -2.3437F, 0.0F, 4.0F, 4.0F, 6.0F, 0.0F, false);
		AllExcept123.setTextureOffset(11, 80).addBox(-0.75F, -1.25F, 6.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Stingray entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.bone.rotateAngleY = (MathHelper.sin(limbSwing) * 0.2f);
		this.AllExcept12.rotateAngleY = (MathHelper.sin(limbSwing) * 0.3f);
		this.AllExcept123.rotateAngleY = (MathHelper.sin(limbSwing) * 0.4f);
		this.stinger.rotateAngleY = 0;

		//this.Lefthand.rotateAngleZ = (float) (abs(MathHelper.sin((float) limbSwing) * 0.2));
		//this.smallfinleft.rotateAngleZ = (float) (abs(MathHelper.sin((float) limbSwing) * 0.3));
		this.Lefthand.rotateAngleZ = (MathHelper.sin(limbSwing) * 0.3f);
		this.smallfinleft.rotateAngleZ = (MathHelper.sin(limbSwing) * 0.4f);
		this.Righthand.rotateAngleZ = (-1 * MathHelper.sin(limbSwing) * 0.3f);
		this.smallfinright.rotateAngleZ = (-1 * MathHelper.sin(limbSwing) * 0.4f);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Stingray.render(matrixStack, buffer, packedLight, packedOverlay);
//		Body.render(matrixStack, buffer, packedLight, packedOverlay);
//		mouth.render(matrixStack, buffer, packedLight, packedOverlay);
//		Lefthand.render(matrixStack, buffer, packedLight, packedOverlay);
//		smallfinleft.render(matrixStack, buffer, packedLight, packedOverlay);
//		Righthand.render(matrixStack, buffer, packedLight, packedOverlay);
//		smallfinright.render(matrixStack, buffer, packedLight, packedOverlay);
//		Tail.render(matrixStack, buffer, packedLight, packedOverlay);
//		tail1.render(matrixStack, buffer, packedLight, packedOverlay);
//		tail2.render(matrixStack, buffer, packedLight, packedOverlay);
//		tail3.render(matrixStack, buffer, packedLight, packedOverlay);
//		tail4.render(matrixStack, buffer, packedLight, packedOverlay);
//		stinger.render(matrixStack, buffer, packedLight, packedOverlay);
//		bone.render(matrixStack, buffer, packedLight, packedOverlay);
//		AllExcept12.render(matrixStack, buffer, packedLight, packedOverlay);
//		AllExcept123.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}