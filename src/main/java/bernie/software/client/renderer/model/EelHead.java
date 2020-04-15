package bernie.software.client.renderer.model;
import bernie.software.client.renderer.model.AbstractWormPart;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.entity.Entity;
// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public class EelHead extends AbstractWormPart {
	private final RendererModel eel3;

	@Override
	public RendererModel getModel() {
		return eel3;
	}

	public EelHead() {
		textureWidth = 32;
		textureHeight = 16;

		eel3 = new RendererModel(this);
		eel3.setRotationPoint(-0, 0, 0);
		eel3.cubeList.add(new ModelBox(eel3, 18, 0, -0F, 0.5F, -2.136f, 0, 1, 2, 0.0F, false));
		eel3.cubeList.add(new ModelBox(eel3, 18, 0, -0F, -1.5F, -2.136f, 0, 1, 2, 0.0F, false));
		eel3.cubeList.add(new ModelBox(eel3, 13, 0, -0.5F, -0.5F, -3.136f, 1, 1, 3, 0.0F, false));
		eel3.offsetZ=0;
//		eel3.offsetX=1f;
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		eel3.render(f5);
	}
	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

}