package blueduck.deepwaters.client.renderer.events;

import blueduck.deepwaters.client.gui.WorldLoadingScreen;
import blueduck.deepwaters.world.DeepWatersDimension;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.WorkingScreen;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class OpenGuiEvent {
	@SubscribeEvent
	public static void openGUI(GuiOpenEvent event) {
		try {
//			DeepWatersMod.logger.log(Level.INFO,Minecraft.getInstance().player.dimension.getClass());
			if (from.getRegistryName()==Minecraft.getInstance().player.world.dimension.getType().getRegistryName()||
			Minecraft.getInstance().world.dimension instanceof DeepWatersDimension) {
//				DeepWatersMod.logger.log(Level.INFO,"h");
				if (event.getGui() instanceof WorkingScreen) {
					WorldLoadingScreen screen=new WorldLoadingScreen();
					screen.resetProgressAndMessage(event.getGui().getTitle());
					event.setGui(screen);
				}
			}
		} catch (Exception err) {}
	}
	
	public static DimensionType from;
	
	@SubscribeEvent
	public static void onDimensionChanged(PlayerEvent.PlayerChangedDimensionEvent event) {
		from=event.getTo();
	}
}
