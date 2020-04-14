package bernie.software.item.tool;

import bernie.software.registry.DeepWatersItems;
import bernie.software.utils.pre_one_thirteen_funcs;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mrcrayfish.obfuscate.client.event.RenderItemEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Date;

@Mod.EventBusSubscriber
public class ToolEventSubscriber
{
	@SubscribeEvent
	public static void onBreakSpeedEvent(final PlayerEvent.BreakSpeed event)
	{

		PlayerEntity player = event.getPlayer();

		float originalSpeed = event.getOriginalSpeed();
		Item item = player.getHeldItemMainhand().getItem();
		if (player.isInWater() || player.isSwimming() || player.isInWaterOrBubbleColumn() && player.canHarvestBlock(player.getBlockState())) {
			if(item == DeepWatersItems.PRISMARINE_AXE.get() || item == DeepWatersItems.PRISMARINE_PICKAXE.get() || item == DeepWatersItems.PRISMARINE_SHOVEL.get()) {
				event.setNewSpeed(originalSpeed * 10);
			}
		}
	}
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
