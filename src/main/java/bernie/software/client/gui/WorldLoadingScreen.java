package bernie.software.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.WorkingScreen;
import net.minecraft.client.renderer.texture.Texture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class WorldLoadingScreen extends WorkingScreen {
	@Override
	public void resetProgressAndMessage(ITextComponent component) {
		super.resetProgressAndMessage(component);
	}
	
	private static final ResourceLocation DEMO_BACKGROUND_LOCATION = new ResourceLocation("deepwaters:textures/gui/loading/background.png");
	
	@Override
	public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
		RenderSystem.color4f(1,1,1,1);
		this.minecraft.getTextureManager().bindTexture(DEMO_BACKGROUND_LOCATION);
		Texture texture=this.minecraft.getTextureManager().getTexture(DEMO_BACKGROUND_LOCATION);
		RenderSystem.pushMatrix();
		RenderSystem.scalef(this.width,this.height,1);
		blit(0,0,0,0,1250,703,this.width,this.height);
		RenderSystem.popMatrix();
	}
}
