package bernie.software.client.renderer.model;// Made with Blockbench 3.5.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import bernie.software.entity.PhantomStingray;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class PhantomStingrayModel extends EntityModel<PhantomStingray>
{
	private final ModelRenderer body;
	private final ModelRenderer leye;
	private final ModelRenderer reye;
	private final ModelRenderer rfin1;
	private final ModelRenderer rfin2;
	private final ModelRenderer lfin1;
	private final ModelRenderer lfin2;
	private final ModelRenderer tail1;
	private final ModelRenderer tail2;
	private final ModelRenderer hook1;
	private final ModelRenderer hook2;

	public PhantomStingrayModel() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 22.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-5.0F, 0.0F, -7.5F, 10.0F, 2.0F, 15.0F, 0.0F, false);

		leye = new ModelRenderer(this);
		leye.setRotationPoint(4.0F, 0.0F, -6.0F);
		body.addChild(leye);
		leye.setTextureOffset(9, 0).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		reye = new ModelRenderer(this);
		reye.setRotationPoint(-4.0F, 0.0F, -6.0F);
		body.addChild(reye);
		reye.setTextureOffset(0, 0).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		rfin1 = new ModelRenderer(this);
		rfin1.setRotationPoint(-5.0F, 1.0F, 0.0F);
		body.addChild(rfin1);
		rfin1.setTextureOffset(0, 33).addBox(-10.0F, 0.0F, -7.5F, 10.0F, 0.0F, 15.0F, 0.0F, false);

		rfin2 = new ModelRenderer(this);
		rfin2.setRotationPoint(-10.0F, 0.0F, 0.0F);
		rfin1.addChild(rfin2);
		rfin2.setTextureOffset(22, 31).addBox(-8.0F, 0.0F, -6.5F, 8.0F, 0.0F, 13.0F, 0.0F, false);

		lfin1 = new ModelRenderer(this);
		lfin1.setRotationPoint(5.0F, 1.0F, 0.0F);
		body.addChild(lfin1);
		lfin1.setTextureOffset(0, 17).addBox(0.0F, 0.0F, -7.5F, 10.0F, 0.0F, 15.0F, 0.0F, false);

		lfin2 = new ModelRenderer(this);
		lfin2.setRotationPoint(10.0F, 0.0F, 0.0F);
		lfin1.addChild(lfin2);
		lfin2.setTextureOffset(22, 17).addBox(0.0F, 0.0F, -6.5F, 8.0F, 0.0F, 13.0F, 0.0F, false);

		tail1 = new ModelRenderer(this);
		tail1.setRotationPoint(0.0F, 1.0F, 7.0F);
		body.addChild(tail1);
		tail1.setTextureOffset(0, 8).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, -22.0F, 5.0F);
		tail1.addChild(tail2);
		tail2.setTextureOffset(0, 23).addBox(-0.5F, 21.5F, 0.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		hook1 = new ModelRenderer(this);
		hook1.setRotationPoint(0.0F, 22.0F, 6.0F);
		tail2.addChild(hook1);
		setRotationAngle(hook1, 0.0F, 3.1416F, 0.0F);
		hook1.setTextureOffset(0, 29).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		hook2 = new ModelRenderer(this);
		hook2.setRotationPoint(0.0F, 0.0F, -3.0F);
		hook1.addChild(hook2);
		hook2.setTextureOffset(0, 14).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(PhantomStingray entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.lfin1.rotateAngleZ = (MathHelper.sin(limbSwing) * 0.3f);
		this.lfin2.rotateAngleZ = (MathHelper.sin(limbSwing) * 0.4f);
		this.rfin1.rotateAngleZ = (-1 * MathHelper.sin(limbSwing) * 0.3f);
		this.rfin2.rotateAngleZ = (-1 * MathHelper.sin(limbSwing) * 0.4f);	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}