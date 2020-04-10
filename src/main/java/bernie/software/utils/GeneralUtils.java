package bernie.software.utils;

import bernie.software.DeepWatersMod;
import net.minecraft.util.ResourceLocation;

public class GeneralUtils
{
	public static ResourceLocation Location(String name)
	{
		return new ResourceLocation(DeepWatersMod.ModID, name);
	}
}
