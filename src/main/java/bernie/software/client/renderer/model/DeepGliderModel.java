// Made with Blockbench 3.5.0
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package bernie.software.client.renderer.model;

import bernie.software.entity.DeepGlider;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class DeepGliderModel extends EntityModel<DeepGlider> {
	private final ModelRenderer Angler;
	private final ModelRenderer fronthead;
	private final ModelRenderer tail;
	private final ModelRenderer propeller;
	private final ModelRenderer rotator;
	private final ModelRenderer rotator2;
	private final ModelRenderer rotator3;
	private final ModelRenderer thinny;
	private final ModelRenderer thinny2;
	private final ModelRenderer sidefin;
	private final ModelRenderer lowerjaw;
	private final ModelRenderer teeth2;
	private final ModelRenderer teeth4;
	private final ModelRenderer sidefin2;

	public DeepGliderModel() {
		textureWidth = 32;
		textureHeight = 32;

		Angler = new ModelRenderer(this);
		Angler.setRotationPoint(0.0F, 22.0F, -4.0F);
		Angler.setTextureOffset(12, 5).addBox(-1.0F, -1.0F, 6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Angler.setTextureOffset(0, 7).addBox(-2.0F, -2.0F, 3.0F, 4.0F, 4.0F, 3.0F, 0.0F, false);
		Angler.setTextureOffset(0, 0).addBox(-2.0F, -3.0F, 0.0F, 4.0F, 4.0F, 3.0F, 0.0F, false);

		fronthead = new ModelRenderer(this);
		fronthead.setRotationPoint(-2.0F, 4.0F, -1.0F);
		Angler.addChild(fronthead);
		

		tail = new ModelRenderer(this);
		tail.setRotationPoint(-0.5F, 0.5F, 8.0F);
		Angler.addChild(tail);
		tail.setTextureOffset(11, 0).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		propeller = new ModelRenderer(this);
		propeller.setRotationPoint(0.5F, -0.5F, 2.0F);
		tail.addChild(propeller);
		

		rotator = new ModelRenderer(this);
		rotator.setRotationPoint(0.0F, 0.0F, 0.0F);
		propeller.addChild(rotator);
		setRotationAngle(rotator, 0.0F, 0.0F, 2.3562F);
		rotator.setTextureOffset(11, 8).addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		rotator2 = new ModelRenderer(this);
		rotator2.setRotationPoint(0.0F, 0.0F, 0.0F);
		propeller.addChild(rotator2);
		setRotationAngle(rotator2, 0.0F, 0.0F, -2.3562F);
		rotator2.setTextureOffset(0, 8).addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		rotator3 = new ModelRenderer(this);
		rotator3.setRotationPoint(0.0F, 0.0F, 0.0F);
		propeller.addChild(rotator3);
		rotator3.setTextureOffset(11, 0).addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		thinny = new ModelRenderer(this);
		thinny.setRotationPoint(0.0F, -2.0F, 5.0F);
		Angler.addChild(thinny);
		setRotationAngle(thinny, -0.3491F, 0.0F, 0.0F);
		thinny.setTextureOffset(6, 12).addBox(0.0F, -1.0603F, -0.658F, 0.0F, 2.0F, 3.0F, 0.0F, false);

		thinny2 = new ModelRenderer(this);
		thinny2.setRotationPoint(0.0F, -3.0F, 5.0F);
		Angler.addChild(thinny2);
		setRotationAngle(thinny2, 0.2618F, 0.0F, 0.0F);
		thinny2.setTextureOffset(0, 11).addBox(0.0F, -0.9739F, -3.8191F, 0.0F, 2.0F, 3.0F, 0.0F, false);

		sidefin = new ModelRenderer(this);
		sidefin.setRotationPoint(-2.0F, 0.0F, 3.0F);
		Angler.addChild(sidefin);
		setRotationAngle(sidefin, 0.0F, -0.6109F, 0.0F);
		sidefin.setTextureOffset(0, 14).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 2.0F, 0.0F, false);

		lowerjaw = new ModelRenderer(this);
		lowerjaw.setRotationPoint(0.0F, 1.0F, 3.0F);
		Angler.addChild(lowerjaw);
		lowerjaw.setTextureOffset(11, 11).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 1.0F, 3.0F, 0.0F, false);

		teeth2 = new ModelRenderer(this);
		teeth2.setRotationPoint(-2.0F, 0.0F, -2.0F);
		lowerjaw.addChild(teeth2);
		setRotationAngle(teeth2, 0.0F, 0.0F, -0.0873F);
		teeth2.setTextureOffset(0, 6).addBox(0.0F, -2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		teeth4 = new ModelRenderer(this);
		teeth4.setRotationPoint(2.0F, 0.0F, -2.0F);
		lowerjaw.addChild(teeth4);
		setRotationAngle(teeth4, 0.0F, 0.0F, 0.0873F);
		teeth4.setTextureOffset(0, 0).addBox(-0.3F, -2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		sidefin2 = new ModelRenderer(this);
		sidefin2.setRotationPoint(2.0F, 0.0F, 3.0F);
		Angler.addChild(sidefin2);
		setRotationAngle(sidefin2, 0.0F, 0.6109F, 0.0F);
		sidefin2.setTextureOffset(12, 13).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(DeepGlider entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        this.propeller.rotateAngleZ += 0.5;
        this.lowerjaw.rotateAngleX = Math.abs(MathHelper.sin(limbSwing) * .5f);
        this.sidefin.rotateAngleY = Math.abs(MathHelper.sin(limbSwing) * .25f) * -1;
        this.sidefin2.rotateAngleY = Math.abs(MathHelper.sin(limbSwing) * .25f);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Angler.render(matrixStack, buffer, packedLight, packedOverlay);
		fronthead.render(matrixStack, buffer, packedLight, packedOverlay);
		tail.render(matrixStack, buffer, packedLight, packedOverlay);
		propeller.render(matrixStack, buffer, packedLight, packedOverlay);
		rotator.render(matrixStack, buffer, packedLight, packedOverlay);
		rotator2.render(matrixStack, buffer, packedLight, packedOverlay);
		rotator3.render(matrixStack, buffer, packedLight, packedOverlay);
		thinny.render(matrixStack, buffer, packedLight, packedOverlay);
		thinny2.render(matrixStack, buffer, packedLight, packedOverlay);
		sidefin.render(matrixStack, buffer, packedLight, packedOverlay);
		lowerjaw.render(matrixStack, buffer, packedLight, packedOverlay);
		teeth2.render(matrixStack, buffer, packedLight, packedOverlay);
		teeth4.render(matrixStack, buffer, packedLight, packedOverlay);
		sidefin2.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}