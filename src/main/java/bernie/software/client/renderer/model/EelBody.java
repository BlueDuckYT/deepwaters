package bernie.software.client.renderer.model;
import bernie.software.DeepWatersMod;
import bernie.software.client.renderer.model.AbstractWormPart;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.entity.Entity;
import org.apache.logging.log4j.Level;

import java.util.ArrayList;
// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public class EelBody extends AbstractWormPart {
	private final RendererModel eel2;
	@Override
	public RendererModel getModel() {
		return eel2;
	}
	@Override
	ArrayList<ModelBox> bodyBoxes() {
		ArrayList<ModelBox> bxs=new ArrayList<>();
		bxs.add(new ModelBox(eel2, 0, 0, -0.5F, -0.5F, -0, 1, 1, 5, 0.0F, false));
		DeepWatersMod.logger.log(Level.INFO,"h");
		return bxs;
	}
	public EelBody() {
		textureWidth = 32;
		textureHeight = 16;

		eel2 = new RendererModel(this);
		eel2.setRotationPoint(0, 0, 0);
		eel2.cubeList.add(new ModelBox(eel2, 0, 6, -0, -1.5F, -0, 0, 1, 5, 0.0F, false));
		eel2.cubeList.add(new ModelBox(eel2, 0, 6, -0, 0.5F, -0, 0, 1, 5, 0.0F, false));
		eel2.cubeList.add(new ModelBox(eel2, 0, 0, -0.5F, -0.5F, -0, 1, 1, 5, 0.0F, false));
	}
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		eel2.render(f5);
	}
	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}