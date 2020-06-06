package bernie.software.block;

import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class PillarBlock extends RotatedPillarBlock
{

	public PillarBlock()
	{
		super(Properties.create(Material.ROCK)
				.hardnessAndResistance(3F, 50F)
				.sound(SoundType.STONE)
				.harvestTool(ToolType.PICKAXE)
				.noDrops()
		);
	}

	public PillarBlock(int light)
	{
		super(Properties.create(Material.ROCK)
				.hardnessAndResistance(-1F, -1F)
				.sound(SoundType.STONE)
				.harvestTool(ToolType.PICKAXE)
				.lightValue(light)
				.noDrops()
		);
	}
}
