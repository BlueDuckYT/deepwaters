package bernie.software.world;

import bernie.software.DeepWatersMod;
import bernie.software.ForgeBusEventSubscriber;
import bernie.software.entity.CoralCrawler;
import bernie.software.registry.DeepWatersBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Level;

import java.util.Random;

@Mod.EventBusSubscriber
public class DeepWatersDimensionEventSubscriber
{
	private static BlockState WATER = Blocks.WATER.getDefaultState();

	//Handle Oxygenator
	@SubscribeEvent
	public static void onBlockBroken(final BlockEvent.BreakEvent event)
	{
		boolean replace = true;
		IWorld world = event.getWorld();
		BlockPos pos = event.getPos();
		int xPos = pos.getX();
		int yPos = pos.getY();
		int zPos = pos.getZ();
		for (int x = -8; x < 9; x++)
		{
			for (int y = -8; y < 9; y++)
			{
				for (int z = -8; z < 9; z++)
				{
					if (world.getBlockState(new BlockPos(xPos + x, yPos + y, zPos + z)).getBlock().equals(DeepWatersBlocks.OXYGENATOR.get()))
					{
						replace = false;
					}
				}
			}
		}
		if (!world.getBlockState(new BlockPos(xPos + 1, yPos, zPos)).equals(WATER))
		{
			if (!world.getBlockState(new BlockPos(xPos - 1, yPos, zPos)).equals(WATER))
			{
				if (!world.getBlockState(new BlockPos(xPos, yPos + 1, zPos)).equals(WATER))
				{
					if (!world.getBlockState(new BlockPos(xPos, yPos - 1, zPos)).equals(WATER))
					{
						if (!world.getBlockState(new BlockPos(xPos, yPos, zPos + 1)).equals(WATER))
						{
							if (!world.getBlockState(new BlockPos(xPos, yPos, zPos - 1)).equals(WATER))
							{
								replace = false;
							}
						}
					}
				}
			}
		}

		PlayerEntity player = event.getPlayer();
		if (replace && yPos <= 229 && player.dimension == DimensionType.byName(ForgeBusEventSubscriber.DIMENSION_TYPE_RL))
		{
			if (player.canHarvestBlock(event.getState()) && !player.isCreative())
			{
				world.destroyBlock(pos, true);
			}
			else
			{
				world.destroyBlock(pos, false);

			}
			world.setBlockState(pos, WATER, 1);
		}
	}


	@SubscribeEvent
	public static void entitySpawnEvent(LivingSpawnEvent.CheckSpawn event)
	{
		try
		{
			SpawnReason spawnReason = event.getSpawnReason();
			if (spawnReason.equals(SpawnReason.NATURAL) || spawnReason.equals(SpawnReason.CHUNK_GENERATION))
			{
				Entity entity = event.getEntity();
				IWorld world = event.getWorld();
				if (entity instanceof CoralCrawler)
				{
					if (!attemptLandFind(event))
					{
						if (!attemptLandFind(event))
						{
							if (!attemptLandFind(event))
							{
								if (!attemptLandFind(event))
								{
									entity.remove();
									event.setCanceled(true);
								}
							}
						}
					}

					int i = 0;
					for (i = 0; i <= 10; i++)
					{
						if (world.hasWater(entity.getPosition().down(i)))
						{
							entity.remove();
							event.setCanceled(true);
						}
					}
				}
				else if (entity instanceof AbstractFishEntity)
				{
					if (!world.hasWater(new BlockPos(event.getX(), event.getY() - 1, event.getZ())) &&
							!world.hasWater(new BlockPos(event.getX(), event.getY(), event.getZ())))
					{
						entity.remove();
						event.setCanceled(true);
					}
				}
			}
		} catch (Exception err)
		{
			DeepWatersMod.logger.log(Level.ERROR, err);
		}
	}

	public static boolean attemptLandFind(LivingSpawnEvent event)
	{
		IWorld world = event.getWorld();
		Entity entity = event.getEntity();
		BlockPos pos = entity.getPosition();
		int height = world.getHeight(Heightmap.Type.MOTION_BLOCKING, (int) entity.posX, (int) entity.posZ);

		if (HasWaterBelow(world, pos))
		{
			Random random = world.getRandom();
			Vec3d newPos = new Vec3d(random.nextInt(100), 0, random.nextInt(100));
			newPos = newPos.add(entity.getPositionVec());
			entity.setPosition(newPos.getX(), newPos.getY(), newPos.getZ());
			entity.setPosition(entity.posX, height + 1, entity.posZ);
			if (HasWaterBelow(world, new BlockPos(newPos)))
			{
				return false;
			}
		}
		return true;
	}

	private static boolean HasWaterBelow(IWorld world, BlockPos pos)
	{
		return world.hasWater(pos) || world.hasWater(pos.down()) || world.hasWater(pos.down(2)) || world.hasWater(pos.down(3));
	}

}
