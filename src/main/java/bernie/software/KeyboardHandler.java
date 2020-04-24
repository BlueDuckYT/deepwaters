package bernie.software;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class KeyboardHandler
{
	public static boolean isKeyDown = false;

	@SubscribeEvent
	public static void onKeyPress(final InputEvent.KeyInputEvent event)
	{
		Minecraft mc = Minecraft.getInstance();
		if (mc.player != null)
		{
			isKeyDown = mc.gameSettings.keyBindForward.isKeyDown();
		}
	}
}
