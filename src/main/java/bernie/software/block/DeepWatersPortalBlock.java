package bernie.software.block;

import bernie.software.DeepWatersMod;
import bernie.software.utils.EntityUtils;
import bernie.software.utils.TeleportUtils;
import bernie.software.utils.WorldUtils;
import bernie.software.world.gen.structures.DeepWatersPortalStructure;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.WorldInfo;

public class DeepWatersPortalBlock extends Block
{

	public DeepWatersPortalBlock(Material material, float hardness, float resist, SoundType sound)
	{
		super(Properties.create(material)
				.hardnessAndResistance(hardness, resist)
				.sound(sound)
				.doesNotBlockMovement()
		);
	}

	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state)
	{
		return ItemStack.EMPTY;
	}

	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn)
	{
		if (TeleportUtils.canEntityBeTeleported(state, worldIn, pos, entityIn))
		{
			MinecraftServer server = entityIn.getServer();
			DimensionType deepWatersDimension = WorldUtils.getDeepWatersDimension();
			DimensionType overworldDimension = DimensionType.OVERWORLD;
			ServerWorld overWorld = server.getWorld(
					overworldDimension);
			ServerWorld deepWatersWorld = server.getWorld(
					deepWatersDimension);

			BlockPos portalCenter = WorldUtils.findPortalCenter(worldIn, pos);
			if (portalCenter == null)
			{
				DeepWatersMod.logger.warn("Could not find portal center");
				return;
			}

			if (entityIn.getEntityWorld().getDimension().getType() != deepWatersDimension)
			{
				int deepWatersSeaLevel = deepWatersWorld.getSeaLevel();
				if (entityIn instanceof ServerPlayerEntity)
				{
					ServerPlayerEntity player = (ServerPlayerEntity) entityIn;
					WorldInfo worldInfo = deepWatersWorld.getWorldInfo();

					TeleportUtils.SendDimensionChangePackets(deepWatersDimension, player, worldInfo);
					int spawnHeight = WorldUtils.getDeepWatersSpawnHeight(deepWatersWorld, portalCenter);
					BlockPos portalCenterDeepWaters = new BlockPos(portalCenter.getX(),
							spawnHeight <= deepWatersSeaLevel ? deepWatersSeaLevel - 1 : spawnHeight,
							portalCenter.getZ());
					if (WorldUtils.findPortalCenter(deepWatersWorld, portalCenterDeepWaters.east(3).south(3)) == null)
					{
						DeepWatersPortalStructure.placePortalAtLocation(deepWatersWorld, deepWatersWorld.getRandom(),
								portalCenterDeepWaters, new NoFeatureConfig());
					}

					BlockPos spawnPos = portalCenterDeepWaters.east(4).up(3);
					TeleportUtils.TeleportPlayerToDimension(deepWatersWorld, player, spawnPos);
				}
				else
				{

					BlockPos spawnPos = new BlockPos(portalCenter.getX(),
							portalCenter.getY() <= deepWatersSeaLevel ? deepWatersSeaLevel - 1 : portalCenter.getY(),
							portalCenter.getZ()).east(4).up(3);
					TeleportUtils.TransferEntityToNewDimension(entityIn, deepWatersWorld, spawnPos);
					EntityUtils.RemoveEntity(worldIn, entityIn, deepWatersWorld, overWorld);
				}
			}
			else
			{
				BlockPos spawnPos = new BlockPos(portalCenter.getX(),
						overWorld.getSeaLevel(),
						portalCenter.getZ()).up(3).west(2).south(1);

				if (entityIn instanceof ServerPlayerEntity)
				{
					ServerPlayerEntity player = (ServerPlayerEntity) entityIn;
					WorldInfo worldInfo = overWorld.getWorldInfo();
					TeleportUtils.SendDimensionChangePackets(overworldDimension, player, worldInfo);
					TeleportUtils.TeleportPlayerToDimension(overWorld, player, spawnPos);
				}
				else
				{
					TeleportUtils.TransferEntityToNewDimension(entityIn, overWorld, spawnPos);
					EntityUtils.RemoveEntity(worldIn, entityIn, overWorld, deepWatersWorld);
				}
			}
		}

	}

}
