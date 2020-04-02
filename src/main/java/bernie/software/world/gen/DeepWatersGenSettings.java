package bernie.software.world.gen;

import bernie.software.registry.DeepWatersBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.GenerationSettings;

public class DeepWatersGenSettings extends GenerationSettings
{
	public DeepWatersGenSettings() {

	}

	public int getBedrockFloorHeight() {
		return 0;
	}

	public int getBedrockRoofHeight() {
		return 256;
	}
}
