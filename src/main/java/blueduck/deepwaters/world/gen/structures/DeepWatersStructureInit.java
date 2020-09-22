package blueduck.deepwaters.world.gen.structures;

import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class DeepWatersStructureInit
{
	public static IStructurePieceType PortalPieceType = DeepWatersPortalPiece.Piece::new;
	public static IStructurePieceType SunkenShipPieceType = SunkenShipPiece.Piece::new;

}
