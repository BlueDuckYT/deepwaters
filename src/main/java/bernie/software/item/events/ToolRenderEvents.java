package bernie.software.item.events;

import bernie.software.utils.pre_one_thirteen_funcs;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mrcrayfish.obfuscate.client.event.RenderItemEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Date;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class ToolRenderEvents
{
	@SubscribeEvent
	public static void onRenderItem(RenderItemEvent.Gui.Post event) {
		try {
			if (event.getItem().getItem().getRegistryName().toString().equals("deepwaters:prismarine_shield")) {
				Long time=new Date().getTime();
				Long cooldown=(event.getItem().getTag().getLong("COOLDOWN")-(time-10000));
				if (cooldown>=0) {
					GlStateManager.disableTexture();
					GlStateManager.disableLighting();
					GlStateManager.pushMatrix();
					GlStateManager.translatef(-0.65f,-0.2f,-0.5f);
					GlStateManager.rotatef(20f,0,1,0);
					GlStateManager.rotatef(15,1,0,0);
					GlStateManager.translatef(-0.03f,0,0);
					pre_one_thirteen_funcs.drawRect(0,-0.05,1.08,0.1,0,0,0,1);
					pre_one_thirteen_funcs.drawRect(0,0,1.08,0.1,0.25,0.5,1,1);
					pre_one_thirteen_funcs.drawRect(0,0,((((float)Math.abs(cooldown/100))/100)+0.08),0.1,0.2,0.1,0.1,1);
					GlStateManager.popMatrix();
					GlStateManager.enableLighting();
					GlStateManager.enableTexture();
				}
			}
		} catch (Exception err) {}
	}
}
