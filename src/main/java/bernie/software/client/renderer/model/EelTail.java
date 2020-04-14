package bernie.software.client.renderer.model;
import bernie.software.client.renderer.model.AbstractWormPart;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.entity.Entity;
// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public class EelTail extends AbstractWormPart {
	private final RendererModel eel1;

	@Override
	public RendererModel getModel() {
		return eel1;
	}

	public EelTail() {
		textureWidth = 32;
		textureHeight = 16;

		eel1 = new RendererModel(this);
		eel1.setRotationPoint(-0, 0, 0);
		eel1.cubeList.add(new ModelBox(eel1, 17, 4, -0.0F, 0.5F, 1.8675f, 0, 1, 2, 0.0F, false));
		eel1.cubeList.add(new ModelBox(eel1, 17, 4, -0.0F, -1.5f, 1.8675f, 0, 1, 2, 0.0F, false));
		eel1.cubeList.add(new ModelBox(eel1, 7, 0, -0.5F, -0.5F, 0.8675f, 1, 1, 4, 0.0F, false));
		eel1.offsetX=1f;
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {

		eel1.render(f5);
	}
	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

}