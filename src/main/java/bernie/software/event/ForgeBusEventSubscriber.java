package bernie.software.event;

import bernie.software.ModEventSubscriber;
import bernie.software.commands.DeepWatersCommand;
import bernie.software.commands.ForceSpawnCommand;
import bernie.software.registry.DeepWatersCommands;
import bernie.software.utils.GeneralUtils;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;

@Mod.EventBusSubscriber(modid = "deepwaters", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeBusEventSubscriber
{
	public static final ResourceLocation DEEPWATERSDIMENSION = GeneralUtils.Location("deepwatersdimension");

	@SubscribeEvent
	public static void onRegisterDimensionsEvent(RegisterDimensionsEvent event)
	{
		if (DimensionType.byName(DEEPWATERSDIMENSION) == null)
		{
			DimensionManager.registerDimension(DEEPWATERSDIMENSION, ModEventSubscriber.DeepWatersDimension, null, true);
		}
	}

	@SubscribeEvent
	public static void onServerStartingEvent(FMLServerStartingEvent event)
	{
		DeepWatersCommands.register(event.getCommandDispatcher());
	}
}
