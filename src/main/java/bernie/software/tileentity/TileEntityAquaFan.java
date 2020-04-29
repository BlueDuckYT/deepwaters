package bernie.software.tileentity;

import bernie.software.block.aquastone.AquastoneFan;
import bernie.software.registry.DeepWatersTileEntities;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class TileEntityAquaFan extends TileEntity implements ITickableTileEntity
{

	public TileEntityAquaFan()
	{
		super(DeepWatersTileEntities.AQUASTONE_FAN.get());
	}

	@Override
	public void tick()
	{

	}
}
