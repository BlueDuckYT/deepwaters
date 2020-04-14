package bernie.software.item.events;

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

}
