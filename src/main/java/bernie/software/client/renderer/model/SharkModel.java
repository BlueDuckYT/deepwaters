package bernie.software.client.renderer.model;// Made with Blockbench 3.5.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import bernie.software.entity.Shark;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

import static java.lang.Math.abs;

public class SharkModel extends EntityModel<Shark>
{
	private final ModelRenderer Main;
	private final ModelRenderer Neck;
	private final ModelRenderer Neck2;
	private final ModelRenderer Head;
	private final ModelRenderer Jaw;
	private final ModelRenderer Body;
	private final ModelRenderer LPectoralFin;
	private final ModelRenderer LPectoralFin2;
	private final ModelRenderer RPectoralFin;
	private final ModelRenderer RPectoralFin2;
	private final ModelRenderer FinDorsal;
	private final ModelRenderer FinDorsal2;
	private final ModelRenderer FinDorsal3;
	private final ModelRenderer Tail;
	private final ModelRenderer BodyTail;
	private final ModelRenderer BodyTail2;
	private final ModelRenderer BodyTail3;
	private final ModelRenderer TailFin;
	private final ModelRenderer TailFinUp;
	private final ModelRenderer TailFinDown;

	public SharkModel()
	{
		textureWidth = 128;
		textureHeight = 128;

		Main = new ModelRenderer(this);
		Main.setRotationPoint(-0.1F, 15.0F, 0.0F);

		Neck = new ModelRenderer(this);
		Neck.setRotationPoint(-0.004F, -6.63F, -6.55F);
		Main.addChild(Neck);
		Neck.setTextureOffset(24, 48).addBox(-3.93F, 0.425F, -5.67F, 8.0F, 7.0F, 6.0F, 0.0F, false);

		Neck2 = new ModelRenderer(this);
		Neck2.setRotationPoint(0.044F, 0.0F, -5.59F);
		Neck.addChild(Neck2);
		Neck2.setTextureOffset(54, 31).addBox(-3.004F, 1.56F, -4.095F, 6.0F, 5.0F, 4.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.044F, 4.0F, -9.605F);
		Neck.addChild(Head);
		Head.setTextureOffset(0, 53).addBox(-2.504F, -2.035F, -8.11F, 5.0F, 4.0F, 8.0F, 0.0F, false);
		Head.setTextureOffset(69, 17).addBox(-2.265F, 1.54F, -7.585F, 0.0F, 1.0F, 7.0F, 0.0F, false);
		Head.setTextureOffset(64, 10).addBox(-2.015F, 1.54F, -7.835F, 4.0F, 1.0F, 0.0F, 0.0F, false);
		Head.setTextureOffset(69, 17).addBox(2.235F, 1.54F, -7.585F, 0.0F, 1.0F, 7.0F, 0.0F, false);

		Jaw = new ModelRenderer(this);
		Jaw.setRotationPoint(-0.1168F, 2.2958F, -0.4124F);
		Head.addChild(Jaw);
		setRotationAngle(Jaw, 0.3491F, 0.0F, 0.0F);
		Jaw.setTextureOffset(56, 0).addBox(-1.7722F, -0.498F, -5.0785F, 4.0F, 1.0F, 5.0F, 0.0F, false);
		Jaw.setTextureOffset(64, 10).addBox(-1.6472F, -1.198F, -4.9285F, 0.0F, 1.0F, 5.0F, 0.0F, false);
		Jaw.setTextureOffset(64, 10).addBox(2.1028F, -1.198F, -4.9285F, 0.0F, 1.0F, 5.0F, 0.0F, false);
		Jaw.setTextureOffset(64, 10).addBox(-1.7222F, -1.198F, -4.9285F, 4.0F, 1.0F, 0.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.04F, -6.33F, -1.46F);
		Main.addChild(Body);
		Body.setTextureOffset(0, 21).addBox(-4.91F, 0.06F, -4.42F, 10.0F, 7.0F, 11.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(-4.39F, -1.21F, -4.92F, 9.0F, 9.0F, 12.0F, 0.0F, false);

		LPectoralFin = new ModelRenderer(this);
		LPectoralFin.setRotationPoint(4.811F, 3.9505F, 0.5F);
		Body.addChild(LPectoralFin);
		setRotationAngle(LPectoralFin, 0.0F, 0.0F, 0.6981F);
		LPectoralFin.setTextureOffset(31, 21).addBox(-0.5325F, 0.8378F, -3.96F, 9.0F, 2.0F, 8.0F, 0.0F, false);

		LPectoralFin2 = new ModelRenderer(this);
		LPectoralFin2.setRotationPoint(7.9694F, 1.671F, 0.75F);
		LPectoralFin.addChild(LPectoralFin2);
		setRotationAngle(LPectoralFin2, 0.0F, -0.3491F, 0.0F);
		LPectoralFin2.setTextureOffset(40, 48).addBox(-1.2993F, 0.0281F, -2.5642F, 10.0F, 0.0F, 6.0F, 0.0F, false);

		RPectoralFin = new ModelRenderer(this);
		RPectoralFin.setRotationPoint(-5.141F, 5.4505F, 0.5F);
		Body.addChild(RPectoralFin);
		setRotationAngle(RPectoralFin, 0.0F, 0.0F, -0.6981F);
		RPectoralFin.setTextureOffset(31, 21).addBox(-7.3404F, 0.0101F, -3.96F, 9.0F, 2.0F, 8.0F, 0.0F, true);

		RPectoralFin2 = new ModelRenderer(this);
		RPectoralFin2.setRotationPoint(-5.6732F, 0.9176F, 0.75F);
		RPectoralFin.addChild(RPectoralFin2);
		setRotationAngle(RPectoralFin2, 0.0F, 0.3491F, 0.0F);
		RPectoralFin2.setTextureOffset(40, 48).addBox(-9.869F, -0.0462F, -2.8188F, 10.0F, 0.0F, 6.0F, 0.0F, true);

		FinDorsal = new ModelRenderer(this);
		FinDorsal.setRotationPoint(-0.02F, -1.15F, 0.365F);
		Body.addChild(FinDorsal);
		setRotationAngle(FinDorsal, -0.0873F, 0.0F, 0.0F);
		FinDorsal.setTextureOffset(56, 10).addBox(-0.94F, -1.2831F, -2.8378F, 2.0F, 3.0F, 7.0F, 0.0F, false);

		FinDorsal2 = new ModelRenderer(this);
		FinDorsal2.setRotationPoint(0.75F, -1.3355F, 0.7821F);
		FinDorsal.addChild(FinDorsal2);
		setRotationAngle(FinDorsal2, -0.1745F, 0.0F, 0.0F);
		FinDorsal2.setTextureOffset(57, 19).addBox(-1.25F, -2.0612F, -2.6191F, 1.0F, 4.0F, 5.0F, 0.0F, false);

		FinDorsal3 = new ModelRenderer(this);
		FinDorsal3.setRotationPoint(0.0F, -2.287F, 0.6881F);
		FinDorsal2.addChild(FinDorsal3);
		setRotationAngle(FinDorsal3, -0.5236F, 0.0F, 0.0F);
		FinDorsal3.setTextureOffset(0, 36).addBox(-0.73F, -5.0212F, -1.7724F, 0.0F, 7.0F, 3.0F, 0.0F, false);

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.04F, -2.83F, 5.63F);
		Main.addChild(Tail);

		BodyTail = new ModelRenderer(this);
		BodyTail.setRotationPoint(0.0F, 0.25F, 0.0F);
		Tail.addChild(BodyTail);
		BodyTail.setTextureOffset(0, 39).addBox(-3.995F, -3.325F, -0.33F, 8.0F, 7.0F, 7.0F, 0.0F, false);

		BodyTail2 = new ModelRenderer(this);
		BodyTail2.setRotationPoint(-0.25F, 0.5F, 6.8F);
		Tail.addChild(BodyTail2);
		BodyTail2.setTextureOffset(52, 54).addBox(-3.38F, -2.94F, -0.33F, 7.0F, 6.0F, 5.0F, 0.0F, false);

		BodyTail3 = new ModelRenderer(this);
		BodyTail3.setRotationPoint(-0.25F, 0.5F, 11.39F);
		Tail.addChild(BodyTail3);
		BodyTail3.setTextureOffset(31, 31).addBox(-2.89F, -2.305F, -0.08F, 6.0F, 5.0F, 11.0F, 0.0F, false);

		TailFin = new ModelRenderer(this);
		TailFin.setRotationPoint(0.05F, 0.0F, 10.01F);
		BodyTail3.addChild(TailFin);
		TailFin.setTextureOffset(0, 0).addBox(-1.43F, -4.365F, -0.675F, 3.0F, 9.0F, 3.0F, 0.0F, false);

		TailFinUp = new ModelRenderer(this);
		TailFinUp.setRotationPoint(0.11F, -3.035F, 1.365F);
		TailFin.addChild(TailFinUp);
		setRotationAngle(TailFinUp, -0.6981F, 0.0F, 0.0F);
		TailFinUp.setTextureOffset(31, 17).addBox(-0.055F, -7.65F, -2.3619F, 0.0F, 8.0F, 4.0F, 0.0F, false);

		TailFinDown = new ModelRenderer(this);
		TailFinDown.setRotationPoint(0.06F, 3.635F, 1.34F);
		TailFin.addChild(TailFinDown);
		setRotationAngle(TailFinDown, 0.6981F, 0.0F, 0.0F);
		TailFinDown.setTextureOffset(0, 17).addBox(-0.005F, -0.5219F, -2.1636F, 0.0F, 8.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Shark entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		this.Tail.rotateAngleY = MathHelper.sin(limbSwing * 0.2F) * 0.3F;
		this.BodyTail3.rotateAngleY = MathHelper.sin(limbSwing * 0.2F) * 0.3F;
		this.TailFin.rotateAngleY = MathHelper.sin(limbSwing * 0.2F) * 0.3F;

		this.FinDorsal2.rotateAngleZ = MathHelper.sin(limbSwing * 0.2F) * 0.3F;
		this.FinDorsal3.rotateAngleZ = MathHelper.sin(limbSwing * 0.2F) * 0.3F;

		this.LPectoralFin.rotateAngleZ = abs(MathHelper.sin(limbSwing * 0.2F) * 0.7f);
		this.LPectoralFin2.rotateAngleZ = abs(MathHelper.sin(limbSwing * 0.2F) * 0.7f);
		this.RPectoralFin.rotateAngleZ = -1 * abs(MathHelper.sin(limbSwing * 0.2F) * 0.7f);
		this.RPectoralFin2.rotateAngleZ = -1 * abs(MathHelper.sin(limbSwing * 0.2F) * 0.7f);
	}

	@Override
	public void setLivingAnimations(Shark entityIn, float limbSwing, float limbSwingAmount, float partialTick)
	{
		if(entityIn.isAttacking() || (this.Jaw.rotateAngleX >= -6.1F && this.Jaw.rotateAngleX <= -5.9))
		{
			this.Jaw.rotateAngleX = -1 * abs(MathHelper.sin(limbSwing * 0.2F)) * 0.9F + 0.5F;
		}
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		Main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}