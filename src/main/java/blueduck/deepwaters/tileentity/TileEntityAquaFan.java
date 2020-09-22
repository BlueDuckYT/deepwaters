package blueduck.deepwaters.tileentity;

import blueduck.deepwaters.registry.DeepWatersTileEntities;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAquaFan extends TileEntity {
	public TileEntityAquaFan() {
		super(DeepWatersTileEntities.AQUASTONE_FAN.get());
	}
	
	public float rotation=0;
}
