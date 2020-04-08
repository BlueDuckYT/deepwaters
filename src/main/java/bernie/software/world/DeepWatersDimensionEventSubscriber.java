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
		if (event.getPos().getY() <= 229 && event.getPlayer().dimension == DimensionType.byName(ForgeBusEventSubscriber.DIMENSION_TYPE_RL)) {
			if (event.getPlayer().canHarvestBlock(event.getState()) && !event.getPlayer().isCreative()) {
				event.getWorld().destroyBlock(event.getPos(), true);
			} else {
				event.getWorld().destroyBlock(event.getPos(), false);

			}
			event.getWorld().setBlockState(event.getPos(), Blocks.WATER.getDefaultState(), 1);
		}
	}
}
