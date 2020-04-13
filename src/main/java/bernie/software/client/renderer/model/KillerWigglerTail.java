package bernie.software.client.renderer.model;;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.entity.Entity;
//Made with Blockbench
//Paste this code into your mod.

public class KillerWigglerTail extends EntityModel {
	private final RendererModel tail;
	private final RendererModel tail_left;
	private final RendererModel tail_right;

	public RendererModel getModel() {
		return tail;
	}

	public KillerWigglerTail() {
		textureWidth = 512;
		textureHeight = 512;

		tail = new RendererModel(this);
		tail.setRotationPoint(0.0F, -10.0F, -8.0F);
		tail.cubeList.add(new ModelBox(tail, 0, 40, -8.0F, -4.1F, 0.25F, 16, 10, 14, 0.0F, false));

		tail_left = new RendererModel(this);
		tail_left.setRotationPoint(4.0F, 0.7F, 91.9F);
		tail.addChild(tail_left);
		tail_left.cubeList.add(new ModelBox(tail_left, 66, 66, -2.0F, -2.0F, -78.75F, 4, 4, 16, 0.0F, false));

		tail_right = new RendererModel(this);
		tail_right.setRotationPoint(-4.0F, 0.7F, 91.9F);
		tail.addChild(tail_right);
		tail_right.cubeList.add(new ModelBox(tail_right, 66, 66, -2.0F, -2.0F, -78.75F, 4, 4, 16, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		tail.render(f5);
	}
	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}