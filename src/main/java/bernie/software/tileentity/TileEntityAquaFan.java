package bernie.software.tileentity;

import bernie.software.block.aquastone.AquastoneFan;
import bernie.software.registry.DeepWatersTileEntities;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class TileEntityAquaFan extends TileEntity {
	public TileEntityAquaFan() {
		super(DeepWatersTileEntities.AQUASTONE_FAN.get());
	}
	
	public float rotation=0;
}
