package bernie.software.event;

import bernie.software.registry.DeepWatersBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.PistonEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;

import static bernie.software.event.ToolEventSubscriber.isPortal;

@Mod.EventBusSubscriber
public class BlockEventSusbcriber
{

	@SubscribeEvent
	public static void onBlockPushEvent(PistonEvent.Pre event)
	{
		Block[] PortalBlocks = {DeepWatersBlocks.PEDESTAL.get(), DeepWatersBlocks.PORTAL_PILLAR.get(), DeepWatersBlocks.PORTAL_PILLAR_END.get(), DeepWatersBlocks.ACTIVATED_PORTAL_PILLAR.get(), DeepWatersBlocks.ACTIVATED_PORTAL_PILLAR_END.get(), DeepWatersBlocks.DEEPWATERSPORTAL.get(), Blocks.PRISMARINE_BRICKS, Blocks.PRISMARINE_BRICK_STAIRS, Blocks.DARK_PRISMARINE};

		BlockPos pos = event.getPos().offset(event.getDirection(), 2);
		World world = (World) event.getWorld();
		if (Arrays.asList(PortalBlocks).contains(world.getBlockState(pos).getBlock()))
		{
			for (Direction dir : Direction.values())
			{
				if (dir == Direction.DOWN || dir == Direction.UP)
				{
					continue;
				}
				BlockPos offset = pos.offset(dir);
				boolean isTouchingPortal = isPortal(world, offset);
				boolean isTouchingPortalBelow = isPortal(world, offset.down(1));

				boolean isPortalAbove = isPortal(world, pos.up(1));
				if ((isTouchingPortal || isTouchingPortalBelow) && !isPortalAbove)
				{
					event.setCanceled(true);
					return;
				}
			}
		}

	}
}
