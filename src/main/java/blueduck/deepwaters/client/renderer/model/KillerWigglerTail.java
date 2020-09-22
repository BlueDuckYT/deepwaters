package blueduck.deepwaters.client.renderer.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

import java.util.ArrayList;

public class KillerWigglerTail extends AbstractWormPart
{
	private final ModelRenderer tail;
	private final ModelRenderer tail_left;
	private final ModelRenderer tail_right;
	private final ModelRenderer getModel;

	@Override
	public ModelRenderer getModel() {
		return tail;
	}

	@Override
	ArrayList<ModelRenderer.ModelBox> bodyBoxes() {
		return null;
	}

	public KillerWigglerTail() {
		textureWidth = 512;
		textureHeight = 512;

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, -10.0F, -8.0F);
		tail.setTextureOffset(0, 40).addBox(-8.0F, -4.1F, 0.25F, 16.0F, 10.0F, 14.0F, 0.0F, false);

		tail_left = new ModelRenderer(this);
		tail_left.setRotationPoint(4.0F, 0.7F, 91.9F);
		tail.addChild(tail_left);
		tail_left.setTextureOffset(66, 66).addBox(-2.0F, -2.0F, -78.75F, 4.0F, 4.0F, 16.0F, 0.0F, false);

		tail_right = new ModelRenderer(this);
		tail_right.setRotationPoint(-4.0F, 0.7F, 91.9F);
		tail.addChild(tail_right);
		tail_right.setTextureOffset(66, 66).addBox(-2.0F, -2.0F, -78.75F, 4.0F, 4.0F, 16.0F, 0.0F, false);

		getModel = new ModelRenderer(this);
		getModel.setRotationPoint(0.0F, 0.0F, 0.0F);

	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		tail.render(matrixStack, buffer, packedLight, packedOverlay);
		tail_left.render(matrixStack, buffer, packedLight, packedOverlay);
		tail_right.render(matrixStack, buffer, packedLight, packedOverlay);
		getModel.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}