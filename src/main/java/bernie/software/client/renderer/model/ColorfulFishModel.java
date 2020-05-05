// Made with Blockbench 3.5.0
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package bernie.software.client.renderer.model;

import bernie.software.entity.ColorfulFish;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ColorfulFishModel extends EntityModel<ColorfulFish> {
	private final ModelRenderer bb_main;
	private final ModelRenderer LFin;
	private final ModelRenderer RFin;
	private final ModelRenderer Topfin;
	private final ModelRenderer Backfin;

	public ColorfulFishModel() {
		textureWidth = 32;
		textureHeight = 32;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bb_main, 0.0F, -1.5708F, 0.0F);
		bb_main.setTextureOffset(0, 0).addBox(-4.0F, -2.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);

		LFin = new ModelRenderer(this);
		LFin.setRotationPoint(-0.5F, -1.0F, -1.0F);
		bb_main.addChild(LFin);
		LFin.setTextureOffset(0, 4).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, 0.0F, false);

		RFin = new ModelRenderer(this);
		RFin.setRotationPoint(-0.5F, -1.0F, 1.0F);
		bb_main.addChild(RFin);
		RFin.setTextureOffset(0, 6).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 2.0F, 0.0F, false);

		Topfin = new ModelRenderer(this);
		Topfin.setRotationPoint(-0.5F, -2.0F, 0.0F);
		bb_main.addChild(Topfin);
		Topfin.setTextureOffset(0, 8).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 1.0F, 0.0F, 0.0F, false);

		Backfin = new ModelRenderer(this);
		Backfin.setRotationPoint(3.0F, -1.0F, 0.0F);
		bb_main.addChild(Backfin);
		Backfin.setTextureOffset(0, 0).addBox(0.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(ColorfulFish entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        this.LFin.rotateAngleX = MathHelper.sin(limbSwing);
        this.RFin.rotateAngleX = MathHelper.sin(limbSwing) * -1;

        this.Backfin.rotateAngleY = MathHelper.sin(ageInTicks)/2;
		}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
//		LFin.render(matrixStack, buffer, packedLight, packedOverlay);
//		RFin.render(matrixStack, buffer, packedLight, packedOverlay);
//		Topfin.render(matrixStack, buffer, packedLight, packedOverlay);
//		Backfin.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}