package bernie.software.world.gen.structures;

import bernie.software.utils.GeneralUtils;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.List;
import java.util.Random;

class DeepWatersPortalPiece
{
	private static final ResourceLocation PORTAL = GeneralUtils.Location("deepwatersportal");

	static void start(TemplateManager templateManager, BlockPos pos, Rotation rotation, List<StructurePiece> pieceList, Random random)
	{
		int x = pos.getX();
		int z = pos.getZ();

		//This is how we factor in rotation for multi-piece structures.
		//
		//I would recommend using the OFFSET map above to have each piece at correct height relative of each other
		//and keep the X and Z equal to 0. And then in rotations, have the centermost piece have a rotation
		//of 0, 0, 0 and then have all other pieces' rotation be based off of the bottommost left corner of
		//that piece (the corner that is smallest in X and Z).
		//
		//Lots of trial and error may be needed to get this right for your structure.
		BlockPos rotationOffSet = new BlockPos(0, 0, 0).rotate(rotation);
		BlockPos blockpos = rotationOffSet.add(x, pos.getY(), z);
		pieceList.add(new DeepWatersPortalPiece.Piece(templateManager, PORTAL, blockpos, rotation));
	}

	/*
	 * Here's where some voodoo happens. Most of this doesn't need to be touched but you do have to pass in the
	 * IStructurePieceType you registered into the super constructors.
	 *
	 * The method you will most likely want to touch is the handleDataMarker method.
	 */
	public static class Piece extends TemplateStructurePiece
	{
		private ResourceLocation resourceLocation;
		private Rotation rotation;


		Piece(TemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos, Rotation rotationIn)
		{
			super(StructureInit.PortalPieceType, 0);
			resourceLocation = resourceLocationIn;
			BlockPos blockpos = new BlockPos(0, 0, 0);
			templatePosition = pos.add(blockpos.getX(), blockpos.getY(), blockpos.getZ());
			rotation = rotationIn;
			setupPiece(templateManagerIn);
		}


		Piece(TemplateManager templateManagerIn, CompoundNBT tagCompound)
		{
			super(StructureInit.PortalPieceType, tagCompound);
			resourceLocation = new ResourceLocation(tagCompound.getString("Template"));
			rotation = Rotation.valueOf(tagCompound.getString("Rot"));
			setupPiece(templateManagerIn);
		}


		private void setupPiece(TemplateManager templateManager)
		{
			Template template = templateManager.getTemplateDefaulted(resourceLocation);
			PlacementSettings placementsettings = (new PlacementSettings()).setRotation(rotation).setMirror(Mirror.NONE);
			setup(template, templatePosition, placementsettings);
		}


		/**
		 * (abstract) Helper method to read subclass data from NBT
		 */
		@Override
		protected void readAdditional(CompoundNBT tagCompound)
		{
			super.readAdditional(tagCompound);
			tagCompound.putString("Template", resourceLocation.toString());
			tagCompound.putString("Rot", rotation.name());
		}

		@Override
		protected void handleDataMarker(String function, BlockPos pos, IWorld worldIn, Random rand, MutableBoundingBox sbb)
		{

		}

		/**
		 * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at the
		 * end, it adds Fences...
		 *
		 * @param worldIn
		 * @param randomIn
		 * @param structureBoundingBoxIn
		 * @param chunkPosIn
		 */
		@Override
		public boolean addComponentParts(IWorld worldIn, Random randomIn, MutableBoundingBox structureBoundingBoxIn, ChunkPos chunkPosIn)
		{
			PlacementSettings placementsettings = (new PlacementSettings()).setRotation(rotation).setMirror(Mirror.NONE);
			BlockPos blockpos = new BlockPos(0, 0, 0);
			templatePosition.add(Template.transformedBlockPos(placementsettings, new BlockPos(0 - blockpos.getX(), 0, 0 - blockpos.getZ())));
			return super.addComponentParts(worldIn, randomIn, structureBoundingBoxIn, chunkPosIn);
		}
	}
}
