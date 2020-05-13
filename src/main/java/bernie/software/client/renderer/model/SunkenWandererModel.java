package bernie.software.client.renderer.model;// Made with Blockbench 3.5.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import bernie.software.entity.SunkenWanderer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

import static java.lang.Math.abs;

public class SunkenWandererModel extends EntityModel<SunkenWanderer>
{
	private final ModelRenderer Main;
	private final ModelRenderer BaseBody;
	private final ModelRenderer Neck;
	private final ModelRenderer Head;
	private final ModelRenderer Jaw;
	private final ModelRenderer Head2;
	private final ModelRenderer LHeadBone;
	private final ModelRenderer RHeadBone;
	private final ModelRenderer Tail;
	private final ModelRenderer Tail1;
	private final ModelRenderer Tail2;
	private final ModelRenderer Tail3;
	private final ModelRenderer TailFin;
	private final ModelRenderer TailFinBot;
	private final ModelRenderer TailFinTop;
	private final ModelRenderer LPectoralFin;
	private final ModelRenderer LPectoralFin2;
	private final ModelRenderer RPectoralFin;
	private final ModelRenderer RPectoralFin2;

	public SunkenWandererModel() {
		textureWidth = 64;
		textureHeight = 64;

		Main = new ModelRenderer(this);
		Main.setRotationPoint(0.0F, 29.0F, -9.0F);


		BaseBody = new ModelRenderer(this);
		BaseBody.setRotationPoint(0.0F, -7.65F, 5.6F);
		Main.addChild(BaseBody);
		BaseBody.setTextureOffset(0, 0).addBox(-2.75F, -1.85F, -4.6F, 6.0F, 4.0F, 9.0F, 0.0F, false);

		Neck = new ModelRenderer(this);
		Neck.setRotationPoint(0.5F, -0.1F, -4.6F);
		BaseBody.addChild(Neck);
		Neck.setTextureOffset(16, 25).addBox(-2.75F, -1.25F, -4.0F, 5.0F, 3.0F, 4.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -0.25F, -4.0F);
		Neck.addChild(Head);


		Jaw = new ModelRenderer(this);
		Jaw.setRotationPoint(0.0F, 1.5F, 0.0F);
		Head.addChild(Jaw);
		setRotationAngle(Jaw, 0.4363F, 0.0F, 0.0F);
		Jaw.setTextureOffset(30, 25).addBox(-2.0F, -0.5F, -3.0F, 4.0F, 1.0F, 3.0F, 0.0F, false);

		Head2 = new ModelRenderer(this);
		Head2.setRotationPoint(0.0F, -0.25F, -4.0F);
		Neck.addChild(Head2);
		Head2.setTextureOffset(0, 28).addBox(-2.5F, -1.0F, -4.0F, 5.0F, 2.0F, 4.0F, 0.0F, false);

		LHeadBone = new ModelRenderer(this);
		LHeadBone.setRotationPoint(3.5F, -0.25F, 0.3F);
		Head2.addChild(LHeadBone);
		setRotationAngle(LHeadBone, 0.6981F, 0.0F, 0.7854F);
		LHeadBone.setTextureOffset(13, 32).addBox(-2.3232F, -0.6354F, -2.8864F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		RHeadBone = new ModelRenderer(this);
		RHeadBone.setRotationPoint(-3.75F, -0.25F, 0.3F);
		Head2.addChild(RHeadBone);
		setRotationAngle(RHeadBone, 0.6981F, 0.0F, -0.7854F);
		RHeadBone.setTextureOffset(30, 7).addBox(0.25F, -0.5F, -3.0F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.4F, 0.15F, 4.4F);
		BaseBody.addChild(Tail);


		Tail1 = new ModelRenderer(this);
		Tail1.setRotationPoint(0.0F, -0.25F, 0.0F);
		Tail.addChild(Tail1);
		Tail1.setTextureOffset(0, 20).addBox(-2.75F, -1.175F, -1.0F, 5.0F, 3.0F, 5.0F, 0.0F, false);

		Tail2 = new ModelRenderer(this);
		Tail2.setRotationPoint(0.1125F, 0.1437F, 4.0F);
		Tail1.addChild(Tail2);
		Tail2.setTextureOffset(17, 17).addBox(-2.6125F, -1.5688F, 0.0F, 5.0F, 3.0F, 5.0F, 0.0F, false);

		Tail3 = new ModelRenderer(this);
		Tail3.setRotationPoint(-0.05F, -0.25F, 5.0F);
		Tail2.addChild(Tail3);
		Tail3.setTextureOffset(29, 29).addBox(-1.5625F, -0.5688F, 0.0F, 3.0F, 2.0F, 5.0F, 0.0F, false);

		TailFin = new ModelRenderer(this);
		TailFin.setRotationPoint(-0.0375F, 0.2854F, 5.0F);
		Tail3.addChild(TailFin);
		TailFin.setTextureOffset(0, 0).addBox(-1.025F, -1.8542F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		TailFinBot = new ModelRenderer(this);
		TailFinBot.setRotationPoint(-0.025F, 1.6083F, 0.0F);
		TailFin.addChild(TailFinBot);
		setRotationAngle(TailFinBot, 0.7854F, 0.0F, 0.0F);
		TailFinBot.setTextureOffset(0, 11).addBox(0.1F, 0.2875F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, false);

		TailFinTop = new ModelRenderer(this);
		TailFinTop.setRotationPoint(-0.025F, -2.1417F, 0.0F);
		TailFin.addChild(TailFinTop);
		setRotationAngle(TailFinTop, -0.7854F, 0.0F, 0.0F);
		TailFinTop.setTextureOffset(0, 18).addBox(0.125F, -3.5357F, -0.8232F, 0.0F, 4.0F, 2.0F, 0.0F, false);

		LPectoralFin = new ModelRenderer(this);
		LPectoralFin.setRotationPoint(3.75F, 0.4F, 0.65F);
		BaseBody.addChild(LPectoralFin);
		setRotationAngle(LPectoralFin, 0.0F, 0.0F, 0.2618F);
		LPectoralFin.setTextureOffset(21, 0).addBox(-0.7756F, -0.4441F, -3.0F, 4.0F, 1.0F, 6.0F, 0.0F, false);

		LPectoralFin2 = new ModelRenderer(this);
		LPectoralFin2.setRotationPoint(4.2823F, 0.1167F, 0.25F);
		LPectoralFin.addChild(LPectoralFin2);
		setRotationAngle(LPectoralFin2, 0.0F, 0.0F, 0.2618F);
		LPectoralFin2.setTextureOffset(24, 13).addBox(-3.142F, -0.0289F, -2.0F, 6.0F, 0.0F, 4.0F, 0.0F, false);

		RPectoralFin = new ModelRenderer(this);
		RPectoralFin.setRotationPoint(-2.75F, 0.4F, 0.65F);
		BaseBody.addChild(RPectoralFin);
		setRotationAngle(RPectoralFin, 0.0F, 0.0F, -0.2618F);
		RPectoralFin.setTextureOffset(0, 13).addBox(-4.4574F, -0.5735F, -3.0F, 4.0F, 1.0F, 6.0F, 0.0F, false);

		RPectoralFin2 = new ModelRenderer(this);
		RPectoralFin2.setRotationPoint(-4.7652F, -0.0127F, 0.25F);
		RPectoralFin.addChild(RPectoralFin2);
		setRotationAngle(RPectoralFin2, 0.0F, 0.0F, -0.2618F);
		RPectoralFin2.setTextureOffset(12, 13).addBox(-3.358F, -0.0289F, -2.0F, 6.0F, 0.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(SunkenWanderer entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.Tail.rotateAngleY = MathHelper.sin(limbSwing * 0.2F) * 0.3F;
		this.Tail2.rotateAngleY = MathHelper.sin(limbSwing * 0.2F) * 0.3F;
		this.TailFin.rotateAngleY = MathHelper.sin(limbSwing * 0.2F) * 0.3F;


		this.LPectoralFin.rotateAngleZ = abs(MathHelper.sin(limbSwing * 0.2F) * 0.7f);
		this.LPectoralFin2.rotateAngleZ = abs(MathHelper.sin(limbSwing * 0.2F) * 0.7f);
		this.RPectoralFin.rotateAngleZ = -1 * abs(MathHelper.sin(limbSwing * 0.2F) * 0.7f);
		this.RPectoralFin2.rotateAngleZ = -1 * abs(MathHelper.sin(limbSwing * 0.2F) * 0.7f);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setLivingAnimations(SunkenWanderer entityIn, float limbSwing, float limbSwingAmount, float partialTick)
	{
		if(entityIn.isAttacking() || (this.Jaw.rotateAngleX >= -6.1F && this.Jaw.rotateAngleX <= -5.9))
		{
			this.Jaw.rotateAngleX = -1 * abs(MathHelper.sin(limbSwing * 0.2F)) * 0.9F + 0.5F;
		}
	}
}