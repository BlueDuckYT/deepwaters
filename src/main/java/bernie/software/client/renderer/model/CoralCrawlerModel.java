package bernie.software.client.renderer.model;// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

import bernie.software.entity.CoralCrawler;
import bernie.software.entity.KillerWiggler;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class CoralCrawlerModel extends EntityModel<CoralCrawler>
{
	private final RendererModel body;
	private final RendererModel body2;
	private final RendererModel tube1parts;
	private final RendererModel tube1part1;
	private final RendererModel tube1part2;
	private final RendererModel tube2;
	private final RendererModel tube2parts;
	private final RendererModel tube2part2;
	private final RendererModel rightleg;
	private final RendererModel leftlegs;
	private final RendererModel leftBackLeg;
	private final RendererModel leftFrontLeg;

	public CoralCrawlerModel()
	{
		textureWidth = 64;
		textureHeight = 64;

		body = new RendererModel(this);
		body.setRotationPoint(-0.5F, 16.5F, 1.0F);
		setRotationAngle(body, -0.1745F, 0.0F, 0.2618F);
		body.cubeList.add(new ModelBox(body, 0, 0, -4.5F, -1.5F, -5.0F, 9, 3, 10, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 21, 21, -3.5F, 0.9319F, -4.0F, 7, 2, 7, 0.0F, false));

		body2 = new RendererModel(this);
		body2.setRotationPoint(-1.2765F, -3.3978F, 0.5F);
		setRotationAngle(body2, 0.0F, 0.0F, -0.2618F);
		body.addChild(body2);
		body2.cubeList.add(new ModelBox(body2, 14, 27, 1.7315F, -6.9345F, -1.4848F, 2, 10, 3, 0.0F, false));
		body2.cubeList.add(new ModelBox(body2, 0, 13, -3.2235F, 1.0F, -4.0F, 7, 3, 7, 0.0F, false));
		body2.cubeList.add(new ModelBox(body2, 21, 13, -1.2235F, 0.0F, -2.0F, 4, 1, 4, 0.0F, false));

		tube1parts = new RendererModel(this);
		tube1parts.setRotationPoint(4.7765F, -5.1022F, 0.0F);
		setRotationAngle(tube1parts, 0.0F, 0.0F, -0.4363F);
		body2.addChild(tube1parts);
		tube1parts.cubeList.add(new ModelBox(tube1parts, 0, 13, -3.0F, 2.1522F, -0.5F, 3, 2, 0, 0.0F, false));

		tube1part1 = new RendererModel(this);
		tube1part1.setRotationPoint(-0.6726F, 0.9063F, 1.0F);
		setRotationAngle(tube1part1, 0.0F, 0.0F, 0.3491F);
		tube1parts.addChild(tube1part1);
		tube1part1.cubeList.add(new ModelBox(tube1part1, 21, 18, -4.3274F, -0.5F, 0.5F, 6, 1, 0, 0.0F, false));

		tube1part2 = new RendererModel(this);
		tube1part2.setRotationPoint(1.092F, -1.8794F, 0.0F);
		setRotationAngle(tube1part2, 0.0F, 0.0F, -0.2618F);
		tube1parts.addChild(tube1part2);
		tube1part2.cubeList.add(new ModelBox(tube1part2, 31, 31, -2.092F, -0.5F, -0.5F, 4, 1, 0, 0.0F, false));

		tube2 = new RendererModel(this);
		tube2.setRotationPoint(-1.0F, 1.0F, 2.0F);
		setRotationAngle(tube2, -0.3491F, 0.0F, -0.2618F);
		body2.addChild(tube2);
		tube2.cubeList.add(new ModelBox(tube2, 0, 23, -2.2235F, -12.0F, -3.0F, 3, 13, 4, 0.0F, false));

		tube2parts = new RendererModel(this);
		tube2parts.setRotationPoint(-3.3966F, -6.8067F, -0.753F);
		setRotationAngle(tube2parts, 0.0F, 0.0F, 0.1745F);
		tube2.addChild(tube2parts);
		tube2parts.cubeList.add(new ModelBox(tube2parts, 33, 13, -1.827F, -0.7045F, -1.253F, 3, 2, 2, 0.0F, false));

		tube2part2 = new RendererModel(this);
		tube2part2.setRotationPoint(4.7214F, -1.6819F, -0.6578F);
		setRotationAngle(tube2part2, 0.7854F, 0.0F, -0.6109F);
		tube2parts.addChild(tube2part2);
		tube2part2.cubeList.add(new ModelBox(tube2part2, 10, 23, -1.5483F, -0.5F, -0.5F, 5, 2, 2, 0.0F, false));

		rightleg = new RendererModel(this);
		rightleg.setRotationPoint(-5.0F, 20.0F, 1.5F);
		setRotationAngle(rightleg, 0.0F, 0.0F, 0.0873F);
		rightleg.cubeList.add(new ModelBox(rightleg, 24, 30, -1.0F, -4.0F, -1.5F, 2, 8, 3, 0.0F, false));

		leftlegs = new RendererModel(this);
		leftFrontLeg = new RendererModel(this);
		leftBackLeg = new RendererModel(this);

		leftlegs.setRotationPoint(3.0F, 18.0F, 0.5F);
		setRotationAngle(leftlegs, 0.0F, -0.0873F, 0.0F);
		leftFrontLeg.cubeList.add(new ModelBox(leftlegs, 28, 0, -1.0F, -1.0F, -3.5F, 2, 7, 2, 0.0F, false));
		leftBackLeg.cubeList.add(new ModelBox(leftlegs, 28, 0, -1.0F, -1.0F, 1.5F, 2, 7, 2, 0.0F, false));
		leftlegs.addChild(leftBackLeg);
		leftlegs.addChild(leftFrontLeg);

	}

	@Override
	public void render(CoralCrawler entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		body.render(f5);
	}

	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(CoralCrawler entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)
	{
		this.leftBackLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

		this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
	}
}