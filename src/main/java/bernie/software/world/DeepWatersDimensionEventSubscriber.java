package bernie.software.world;

import bernie.software.DeepWatersMod;
import bernie.software.ForgeBusEventSubscriber;
import bernie.software.entity.CoralCrawler;
import bernie.software.registry.DeepWatersBlocks;
import bernie.software.registry.DeepWatersItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Level;

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
	static int i=0;
	@SubscribeEvent
	public static void entitySpawnEvent(LivingSpawnEvent.CheckSpawn event) {
		try {
			if (event.getSpawnReason().equals(SpawnReason.NATURAL)||event.getSpawnReason().equals(SpawnReason.CHUNK_GENERATION)) {
				if (event.getEntity() instanceof CoralCrawler) {
					if (!attemptLandFind(event)) {
						if (!attemptLandFind(event)) {
							if (!attemptLandFind(event)) {
								if (!attemptLandFind(event)) {
									event.getEntity().remove();
									event.setCanceled(true);
								}
							}
						}
					}
					for (i=0;i<=10;i++) {
						if (event.getWorld().hasWater(event.getEntity().getPosition().down(i))) {
							event.getEntity().remove();
							event.setCanceled(true);
						}
					}
				} else if (event.getEntity() instanceof AbstractFishEntity) {
					if (!event.getWorld().hasWater(new BlockPos(event.getX(),event.getY()-1,event.getZ()))&&
						!event.getWorld().hasWater(new BlockPos(event.getX(),event.getY(),event.getZ()))) {
						event.getEntity().remove();
						event.setCanceled(true);
					}
				}
			}
		} catch (Exception err) {}
	}
	public static boolean attemptLandFind(LivingSpawnEvent event) {
		if (event.getWorld().hasWater(event.getEntity().getPosition())||
			event.getWorld().hasWater(event.getEntity().getPosition().down())||
			event.getWorld().hasWater(event.getEntity().getPosition().down(2))||
			event.getWorld().hasWater(event.getEntity().getPosition().down(3))) {
			Vec3d newPos=new Vec3d(event.getWorld().getRandom().nextInt(100),0,event.getWorld().getRandom().nextInt(100));
			newPos=newPos.add(event.getEntity().getPositionVec());
			event.getEntity().setPosition(newPos.getX(),newPos.getY(),newPos.getZ());
			event.getEntity().setPosition(event.getEntity().posX,event.getWorld().getHeight(Heightmap.Type.MOTION_BLOCKING,(int)event.getEntity().posX,(int)event.getEntity().posZ)+1,event.getEntity().posZ);
			if (event.getWorld().hasWater(new BlockPos(newPos))||
				event.getWorld().hasWater(new BlockPos(newPos).down())||
				event.getWorld().hasWater(new BlockPos(newPos).down(2))||
				event.getWorld().hasWater(new BlockPos(newPos).down(3))) {
				return false;
			}
		}
		return true;
	}
}
