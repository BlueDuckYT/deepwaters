package bernie.software.item.events;

import bernie.software.DeepWatersMod;
import bernie.software.item.DeepWatersAbstractRuneItem;
import bernie.software.item.tool.DeepWatersShieldItem;
import bernie.software.utils.renderutils.RenderHelper;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mrcrayfish.obfuscate.client.event.RenderItemEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Level;

import java.awt.*;
import java.util.Date;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class ToolRenderEvents
{
	@SubscribeEvent
	public static void onRenderItem(RenderItemEvent event) {
		try {
			if (event.getItem().getItem() instanceof DeepWatersShieldItem &&event instanceof RenderItemEvent.Gui.Post) {
				Long time=new Date().getTime();
				Long cooldown=(event.getItem().getTag().getLong("COOLDOWN")-(time));
				if (cooldown>=0) {
					GlStateManager.disableTexture();
					GlStateManager.disableLighting();
					GlStateManager.pushMatrix();
					GlStateManager.translatef(-0.65f,-0.2f,-0.5f);
					GlStateManager.rotatef(20f,0,1,0);
					GlStateManager.rotatef(15,1,0,0);
					GlStateManager.translatef(-0.03f,0,0);
					RenderHelper.drawRect(0,-0.05,1.08,0.1,0,0,0,1);
					RenderHelper.drawRect(0,0,1.08,0.1,0.25,0.5,1,1);
					RenderHelper.drawRect(0,0,((((float)Math.abs(cooldown)/DeepWatersShieldItem.getEvent((DeepWatersShieldItem)event.getItem().getItem()).cooldown()))+0.08),0.1,0.2,0.1,0.1,1);
					GlStateManager.popMatrix();
					GlStateManager.enableLighting();
					GlStateManager.enableTexture();
				}
			} else if (event.getItem().getItem() instanceof DeepWatersAbstractRuneItem) {
//				GlStateManager.disableTexture();
				GlStateManager.pushMatrix();
				GlStateManager.disableLighting();
				GlStateManager.translatef(-0.405f,0.275f,0);
				GlStateManager.rotatef(180,1,0,0);
				GlStateManager.rotatef(45,0,1,0);
				GlStateManager.rotatef(22.5f,1,0,1);
//				GlStateManager.enableLighting();
				GlStateManager.scalef(0.6f,0.64f,0.6f);
				GlStateManager.enableTexture();
//				RenderHelper.drawRect(0,0,1,1,0.9,0.9,0.9,1);
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("deepwaters:textures/block/limestone.png"));
				try {
					if (event.getItem().getTag().contains("north")) {
						Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("deepwaters:textures/block/"+event.getItem().getTag().getString("north")+".png"));
					}
				} catch (Exception err) {}
				RenderHelper.drawTexturedRect(0,0,0,0,256,256,1,1,0.9,0.9,0.9,1);
//				GlStateManager.disableTexture();
				GlStateManager.rotatef(-90f,0,1,0);
				GlStateManager.translatef(0,0,-1);
				try {
					if (event.getItem().getTag().contains("east")) {
						Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("deepwaters:textures/block/"+event.getItem().getTag().getString("east")+".png"));
					}
				} catch (Exception err) {}
				RenderHelper.drawTexturedRect(0,0,0,0,256,256,1,1,0.7,0.7,0.7,1);
				GlStateManager.rotatef(-90f,1,0,0);
				GlStateManager.translatef(0,-1,0);
//				GlStateManager.disableLighting();
				try {
					if (event.getItem().getTag().contains("topbottom")) {
						Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("deepwaters:textures/block/"+event.getItem().getTag().getString("topbottom")+".png"));
					}
				} catch (Exception err) {}
				RenderHelper.drawTexturedRect(0,0,0,0,256,256,1,1,1,1,1,1);
//				GlStateManager.disableLighting();
				GlStateManager.popMatrix();
				GlStateManager.enableLighting();
//				GlStateManager.enableTexture();
			}
		} catch (Exception err) {}
	}
}
