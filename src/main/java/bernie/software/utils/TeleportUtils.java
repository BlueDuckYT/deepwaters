package bernie.software.utils;

import bernie.software.ForgeBusEventSubscriber;
import bernie.software.ModEventSubscriber;
import bernie.software.world.DeepWatersTeleporter;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.versions.forge.ForgeVersion;

public class TeleportUtils
{
	public static void attemptSendPlayer(Entity entity, boolean forcedEntry)
	{

		if (!entity.isAlive() || entity.world.isRemote)
		{
			return;
		}

		if (entity.isPassenger() || entity.isBeingRidden() || !entity.isNonBoss())
		{
			return;
		}

		if (!forcedEntry && entity.timeUntilPortal > 0)
		{
			return;
		}

		// set a cooldown before this can run again
		entity.timeUntilPortal = 10;

		//int destination = getDestination(entity);

		//entity.changeDimension(destination, DeepWatersTeleporter.getTeleporterForDim(entity.getServer(), DimensionType.getById(destin)));
		//Minecraft.

	}
}
