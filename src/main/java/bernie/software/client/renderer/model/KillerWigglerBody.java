package bernie.software.client.renderer.model;

import bernie.software.entity.KillerWiggler;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class KillerWigglerBody extends EntityModel {
	private final RendererModel body_part1;
	private final RendererModel LL1;
	private final RendererModel pt1_LL1;
	private final RendererModel pt2_LL1;
	private final RendererModel RL1;
	private final RendererModel pt1_RL1;
	private final RendererModel pt2_RL1;

	public RendererModel getModel() {
		return body_part1;
	}

	public KillerWigglerBody() {
		textureWidth = 512;
		textureHeight = 512;

		body_part1 = new RendererModel(this);
		body_part1.setRotationPoint(0.0F, -8.5F, -8.0F);
		body_part1.cubeList.add(new ModelBox(body_part1, 156, 28, -9.0F, -6.6F, 1.0F, 18, 12, 14, 0.0F, false));
		body_part1.cubeList.add(new ModelBox(body_part1, 0, 0, -2.0F, -10.6F, 5.8F, 4, 4, 4, 0.0F, false));

		LL1 = new RendererModel(this);
		LL1.setRotationPoint(7.29F, -0.33F, 7.8F);
		body_part1.addChild(LL1);

		pt1_LL1 = new RendererModel(this);
		pt1_LL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(pt1_LL1, 0.0F, 0.0F, -0.8727F);
		LL1.addChild(pt1_LL1);
		pt1_LL1.cubeList.add(new ModelBox(pt1_LL1, 0, 124, -2.0006F, -0.0032F, -3.0F, 4, 18, 6, 0.0F, false));

		pt2_LL1 = new RendererModel(this);
		pt2_LL1.setRotationPoint(12.5781F, 10.487F, 0.0F);
		setRotationAngle(pt2_LL1, 0.0F, 0.0F, -0.1745F);
		LL1.addChild(pt2_LL1);
		pt2_LL1.cubeList.add(new ModelBox(pt2_LL1, 90, 60, -2.0F, 0.0F, -2.0F, 4, 16, 4, 0.0F, false));

		RL1 = new RendererModel(this);
		RL1.setRotationPoint(-7.29F, -0.33F, 7.8F);
		body_part1.addChild(RL1);

		pt1_RL1 = new RendererModel(this);
		pt1_RL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(pt1_RL1, 0.0F, 0.0F, 0.8727F);
		RL1.addChild(pt1_RL1);
		pt1_RL1.cubeList.add(new ModelBox(pt1_RL1, 0, 124, -1.9994F, -0.0032F, -3.0F, 4, 18, 6, 0.0F, false));

		pt2_RL1 = new RendererModel(this);
		pt2_RL1.setRotationPoint(-12.5781F, 10.487F, 0.0F);
		setRotationAngle(pt2_RL1, 0.0F, 0.0F, 0.1745F);
		RL1.addChild(pt2_RL1);
		pt2_RL1.cubeList.add(new ModelBox(pt2_RL1, 90, 60, -2.0F, 0.0F, -2.0F, 4, 16, 4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body_part1.render(f5);
	}
	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}