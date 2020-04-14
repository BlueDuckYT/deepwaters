package bernie.software.world;

import bernie.software.ForgeBusEventSubscriber;
import bernie.software.registry.DeepWatersBlocks;
import bernie.software.registry.DeepWatersItems;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
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
		boolean replace = true;
		for (int x = -8; x < 9; x++) {
			for (int y = -8; y < 9; y++) {
				for (int z = -8; z < 9; z++) {
					if (event.getWorld().getBlockState(new BlockPos(event.getPos().getX() + x, event.getPos().getY() + y, event.getPos().getZ() + z)).getBlock().equals(DeepWatersBlocks.OXYGENATOR.get())) {
						replace = false;
					}
				}
			}
		}
		if (!event.getWorld().getBlockState(new BlockPos(event.getPos().getX() + 1, event.getPos().getY(), event.getPos().getZ())).getBlock().equals(Blocks.WATER)) {
			if (!event.getWorld().getBlockState(new BlockPos(event.getPos().getX() - 1, event.getPos().getY(), event.getPos().getZ())).getBlock().equals(Blocks.WATER)) {
				if (!event.getWorld().getBlockState(new BlockPos(event.getPos().getX(), event.getPos().getY() + 1, event.getPos().getZ())).getBlock().equals(Blocks.WATER)) {
					if (!event.getWorld().getBlockState(new BlockPos(event.getPos().getX(), event.getPos().getY() - 1, event.getPos().getZ())).getBlock().equals(Blocks.WATER)) {
						if (!event.getWorld().getBlockState(new BlockPos(event.getPos().getX(), event.getPos().getY(), event.getPos().getZ() + 1)).getBlock().equals(Blocks.WATER)) {
							if (!event.getWorld().getBlockState(new BlockPos(event.getPos().getX(), event.getPos().getY(), event.getPos().getZ() - 1)).getBlock().equals(Blocks.WATER)) {
								replace = false;
							}
						}
					}
				}
			}
		}


		if (replace && event.getPos().getY() <= 229 && event.getPlayer().dimension == DimensionType.byName(ForgeBusEventSubscriber.DIMENSION_TYPE_RL)) {
			if (event.getPlayer().canHarvestBlock(event.getState()) && !event.getPlayer().isCreative()) {
				event.getWorld().destroyBlock(event.getPos(), true);
			} else {
				event.getWorld().destroyBlock(event.getPos(), false);

			}
			event.getWorld().setBlockState(event.getPos(), Blocks.WATER.getDefaultState(), 1);
		}
	}
}
