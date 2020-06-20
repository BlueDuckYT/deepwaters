package bernie.software.world.gen;

import net.minecraft.world.gen.EndGenerationSettings;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.OverworldGenSettings;

//public class DeepWatersGenSettings extends GenerationSettings
public class DeepWatersGenSettings extends EndGenerationSettings
{
	public int getBedrockRoofHeight() {
		return 0;
	}
	private final int field_202212_j = 4;
	private final int field_202213_k = 4;
	private final int field_202214_l = -1;
	private final int field_202215_m = 63;

	public int getBiomeSize() {
		return 4;
	}

	public int getRiverSize() {
		return 4;
	}

	public int getBiomeId() {
		return -1;
	}

	public int getBedrockFloorHeight() {
		return 128;
	}

}
