package blueduck.deepwaters.block;

import blueduck.deepwaters.block.aquastone.AquastoneFan;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ILightReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import java.util.Random;

public class EntityPusher extends BubbleSource {
	public EntityPusher() {
		super(Block.Properties.create(Material.AIR).notSolid().noDrops());
	}
	
	@Override
	public boolean isSource(Direction side, IWorldReader world, BlockPos pos, BlockState state) {
		return state.get(DropperBlock.FACING).equals(side);
	}
	
	@Override
	public BlockState getBubbleState(BlockState state) {
		return state;
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(DropperBlock.FACING, AquastoneFan.HAS_SOUL_SAND);
	}
	
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		super.onEntityWalk(worldIn, pos, entityIn);
	}
	
	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		entityIn.addVelocity(
				worldIn.getBlockState(pos).get(DropperBlock.FACING).getXOffset()/16f,
				worldIn.getBlockState(pos).get(DropperBlock.FACING).getYOffset()/16f,
				worldIn.getBlockState(pos).get(DropperBlock.FACING).getZOffset()/16f
		);
		if (!entityIn.isInWaterOrBubbleColumn()) {
//			worldIn.playSound(pos.getX(),pos.getY(),pos.getZ(), SoundEvents.BLOCK_BUBBLE_COLUMN_WHIRLPOOL_INSIDE, SoundCategory.BLOCKS,new Random().nextFloat(),new Random().nextFloat(),false);
		}
		if (state.get(AquastoneFan.HAS_SOUL_SAND)) {
			if (entityIn.getAir()<entityIn.getMaxAir()) {
				if (((int)entityIn.getEyeHeight(entityIn.getPose())+entityIn.getPosY())==pos.getY()) {
					entityIn.setAir(entityIn.getAir()+1);
				}
			}
		}
		super.neighborChanged(state,worldIn,pos,state.getBlock(),pos,false);
		super.onEntityCollision(state, worldIn, pos, entityIn);
	}
	
	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		for (int i=0;i<=4;i++) {
			double d0 = (double)pos.getX() + rand.nextDouble();
			double d1 = (double)pos.getY() + rand.nextDouble();
			double d2 = (double)pos.getZ() + rand.nextDouble();
			worldIn.addParticle(ParticleTypes.BUBBLE, d0, d1, d2,
					worldIn.getBlockState(pos).get(DropperBlock.FACING).getXOffset()/1f,
					worldIn.getBlockState(pos).get(DropperBlock.FACING).getYOffset()/1f,
					worldIn.getBlockState(pos).get(DropperBlock.FACING).getZOffset()/1f
			);
			if (!stateIn.get(AquastoneFan.HAS_SOUL_SAND)) {
				worldIn.addParticle(ParticleTypes.BUBBLE_POP, d0, d1, d2,
						worldIn.getBlockState(pos).get(DropperBlock.FACING).getXOffset()/16f,
						worldIn.getBlockState(pos).get(DropperBlock.FACING).getYOffset()/16f,
						worldIn.getBlockState(pos).get(DropperBlock.FACING).getZOffset()/16f
				);
			}
		}
		worldIn.playSound(pos.getX(),pos.getY(),pos.getZ(), SoundEvents.BLOCK_BUBBLE_COLUMN_WHIRLPOOL_AMBIENT, SoundCategory.BLOCKS,rand.nextFloat(),rand.nextFloat(),false);
		super.animateTick(stateIn, worldIn, pos, rand);
	}
	
	@Override
	public boolean shouldDisplayFluidOverlay(BlockState state, ILightReader world, BlockPos pos, IFluidState fluidState) {
		return true;
	}
	
	@Override
	public IFluidState getFluidState(BlockState state) {
		return Fluids.WATER.getStillFluidState(false);
	}
}
