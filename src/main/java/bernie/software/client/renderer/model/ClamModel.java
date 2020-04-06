package bernie.software.client.renderer.model;
import bernie.software.entity.Clam;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;

import java.util.Random;
import static java.lang.Math.abs;
import static java.lang.Math.round;
// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public class ClamModel extends EntityModel<Clam> {
	private final RendererModel bb_main;
	private final RendererModel top;

	public ClamModel() {
		textureWidth = 64;
		textureHeight = 64;

		bb_main = new RendererModel(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 15, -7.0F, -1.0F, -7.0F, 14, 1, 14, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 17, -7.0F, -2.0F, -7.0F, 0, 1, 14, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 28, 30, -7.0F, -3.0F, 7.0F, 14, 2, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 16, 7.0F, -2.0F, -7.0F, 0, 1, 14, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 50, -7.0F, -2.0F, -7.0F, 14, 1, 0, 0.0F, false));

		top = new RendererModel(this);
		top.setRotationPoint(0.0F, 24.0F, 6.0F);
		top.cubeList.add(new ModelBox(top, 0, 17, 7.0F, -3.0F, -13.0F, 0, 1, 14, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 0, 17, -7.0F, -3.0F, -13.0F, 0, 1, 14, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 0, 41, -7.0F, -3.0F, -13.0F, 14, 1, 0, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 0, 0, -7.0F, -4.0F, -13.0F, 14, 1, 14, 0.0F, false));
	}

	@Override
	public void render(Clam entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bb_main.render(f5);
		top.render(f5);
	}
	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	private static boolean Chompin = false;
	private static int timeSpentChompin = 0;
	private static Random random = new Random();
	private static int currentChompLength;
	@Override
	public void setRotationAngles(Clam entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)
	{
		if(Math.floor(ageInTicks) % 200 == 0 && Chompin == false)
		{
			Chompin = true;
			currentChompLength =  70 + random.nextInt(150);
		}
		if(Chompin)
		{
			timeSpentChompin++;
			this.top.rotateAngleX =  (float) (-1 * abs((MathHelper.sin((float) ageInTicks * 0.2F) * 0.5F)));
		}
		else {
			this.top.rotateAngleX = 0;
	}
		int rounded = Math.round(this.top.rotateAngleX);
		if(timeSpentChompin > currentChompLength && rounded == 0)
		{
			Chompin = false;
			timeSpentChompin = 0;
		}
		else if(timeSpentChompin > currentChompLength){
			this.top.rotateAngleX =  (float) (-1 * abs((MathHelper.sin((float) ageInTicks * 0.2F) * 0.5F)));
		}

	}


}