package bernie.software;

import bernie.software.commands.DeepWatersCommand;
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
	public static final ResourceLocation DIMENSION_TYPE_RL = new ResourceLocation("deepwaters", "deepwatersdimension");

	@SubscribeEvent
	public static void onRegisterDimensionsEvent(RegisterDimensionsEvent event)
	{
		if (DimensionType.byName(DIMENSION_TYPE_RL) == null)
		{
			DimensionManager.registerDimension(DIMENSION_TYPE_RL, ModEventSubscriber.DeepWatersDimension, null, true);
		}
	}

	@SubscribeEvent
	public static void onServerStartingEvent(FMLServerStartingEvent event)
	{
		CommandDispatcher<CommandSource> commandDispatcher = event.getCommandDispatcher();
		DeepWatersCommand.register(commandDispatcher);
	}
}
