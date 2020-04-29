// Made with Blockbench 3.5.1
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class aquafan extends EntityModel<Entity> {
	private final ModelRenderer aquafan_model;
	private final ModelRenderer main_ring;
	private final ModelRenderer top_east;
	private final ModelRenderer bottom_east;
	private final ModelRenderer bottom_west;
	private final ModelRenderer top_west;
	private final ModelRenderer eye_rotation;

	public aquafan() {
		textureWidth = 64;
		textureHeight = 64;

		aquafan_model = new ModelRenderer(this);
		aquafan_model.setRotationPoint(-0.35F, 13.68F, 0.0F);
		

		main_ring = new ModelRenderer(this);
		main_ring.setRotationPoint(-7.3571F, -6.4582F, 8.0F);
		aquafan_model.addChild(main_ring);
		main_ring.setTextureOffset(0, 11).addBox(4.4184F, 11.5236F, -11.9998F, 6.0F, 3.0F, 8.0F, 0.0F, false);
		main_ring.setTextureOffset(0, 0).addBox(4.308F, -1.6848F, -11.9998F, 6.0F, 3.0F, 8.0F, 0.0F, false);
		main_ring.setTextureOffset(20, 3).addBox(-0.8472F, 3.3492F, -11.9998F, 3.0F, 6.0F, 8.0F, 0.0F, false);
		main_ring.setTextureOffset(20, 20).addBox(12.613F, 3.5542F, -11.9998F, 3.0F, 6.0F, 8.0F, 0.0F, false);

		top_east = new ModelRenderer(this);
		top_east.setRotationPoint(5.4451F, 2.0748F, 0.02F);
		main_ring.addChild(top_east);
		setRotationAngle(top_east, 0.0F, 0.0F, 0.7854F);
		top_east.setTextureOffset(28, 34).addBox(-2.7554F, -2.1473F, -11.0198F, 1.0F, 8.0F, 6.0F, 0.0F, false);

		bottom_east = new ModelRenderer(this);
		bottom_east.setRotationPoint(0.9451F, 9.5782F, -7.98F);
		main_ring.addChild(bottom_east);
		setRotationAngle(bottom_east, 0.0F, 0.0F, -0.7854F);
		bottom_east.setTextureOffset(36, 11).addBox(-0.3339F, -1.7541F, -3.0198F, 1.0F, 8.0F, 6.0F, 0.0F, false);

		bottom_west = new ModelRenderer(this);
		bottom_west.setRotationPoint(13.9071F, 9.5782F, -7.98F);
		main_ring.addChild(bottom_west);
		setRotationAngle(bottom_west, 0.0F, 0.0F, 0.7854F);
		bottom_west.setTextureOffset(0, 41).addBox(-0.5638F, -1.7233F, -3.0198F, 1.0F, 8.0F, 6.0F, 0.0F, false);

		top_west = new ModelRenderer(this);
		top_west.setRotationPoint(10.4142F, 0.0858F, -8.0F);
		main_ring.addChild(top_west);
		setRotationAngle(top_west, 0.0F, 0.0F, 0.7854F);
		top_west.setTextureOffset(0, 34).addBox(-1.6478F, -0.4656F, -2.9998F, 8.0F, 1.0F, 6.0F, 0.0F, false);

		eye_rotation = new ModelRenderer(this);
		eye_rotation.setRotationPoint(0.0F, 0.0F, 0.0F);
		aquafan_model.addChild(eye_rotation);
		eye_rotation.setTextureOffset(0, 22).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		aquafan_model.render(matrixStack, buffer, packedLight, packedOverlay);
//		main_ring.render(matrixStack, buffer, packedLight, packedOverlay);
//		top_east.render(matrixStack, buffer, packedLight, packedOverlay);
//		bottom_east.render(matrixStack, buffer, packedLight, packedOverlay);
//		bottom_west.render(matrixStack, buffer, packedLight, packedOverlay);
//		top_west.render(matrixStack, buffer, packedLight, packedOverlay);
//		eye_rotation.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}