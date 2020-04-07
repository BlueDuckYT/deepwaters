package bernie.software.datagen;

import bernie.software.datagen.provider.DeepWatersBlockStateProvider;
import bernie.software.registry.DeepWatersBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class DeepWatersBlockStates extends DeepWatersBlockStateProvider
{

	public DeepWatersBlockStates(DataGenerator dataGenerator, ExistingFileHelper fileHelper)
	{
		super(dataGenerator, fileHelper);
	}

	public static List<RegistryObject<Block>> NormalBlocks = new ArrayList<>();

	@Override
	public String getName()
	{
		return "Deepwaters Block States";
	}

	@Override
	protected void registerStatesAndModels()
	{
		grassBlock(DeepWatersBlocks.MOSSY_OCEAN_FLOOR, "ocean_floor");
		normalBlock(DeepWatersBlocks.SALT_ORE);
		for (RegistryObject<Block> block : NormalBlocks) {
			normalBlock(block);
		}

	}
}
