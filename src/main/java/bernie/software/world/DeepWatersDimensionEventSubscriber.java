package bernie.software.world;

import bernie.software.ForgeBusEventSubscriber;
import net.minecraft.block.Blocks;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class DeepWatersDimensionEventSubscriber
{
	@SubscribeEvent
	public static void onBlockBroken(final BlockEvent.BreakEvent event)
	{
		if (event.getPos().getY() <= 230 && event.getPlayer().dimension == DimensionType.byName(ForgeBusEventSubscriber.DIMENSION_TYPE_RL)) {

			event.getWorld().destroyBlock(event.getPos(), true);
			event.getWorld().setBlockState(event.getPos(), Blocks.WATER.getDefaultState(), 1);
		}
	}
}
