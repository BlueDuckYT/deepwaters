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
		// the first argument here is a resource location for your dimension type
		// the second argument here is the ModDimension that your DimensionType uses
		// the third argument here is an optional PacketBuffer with extra data you want to pass
		// to your DimensionType, which is in turn passed to your Dimension
		// which allows you to define properties of your Dimension when you register this
		// the fourth argument determines skylight for some reason
		// we'll also need to add a check to prevent the dimension from being registered more than once
		if (DimensionType.byName(DIMENSION_TYPE_RL) == null)
		{
			DimensionManager.registerDimension(DIMENSION_TYPE_RL, ModEventSubscriber.DeepWatersDimension, null, true);
		}

		// this returns a DimensionType for your ResourceLocation; alternatively you can also retrieve the dimensiontype with
		// DimensionType.byName(ResourceLocation)
	}

	@SubscribeEvent
	public static void onServerStartingEvent(FMLServerStartingEvent event)
	{
		CommandDispatcher<CommandSource> commandDispatcher = event.getCommandDispatcher();
		DeepWatersCommand.register(commandDispatcher);
	}
}
