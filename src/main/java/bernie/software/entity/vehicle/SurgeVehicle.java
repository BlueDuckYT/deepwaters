package bernie.software.entity.vehicle;


import bernie.software.keyboard;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class SurgeVehicle extends AbstractFishEntity
{

	private boolean forwardInputDown;
	private int lerpSteps;
	private double lerpX;
	private double lerpY;
	private double lerpZ;
	private double lerpYaw;
	private double lerpPitch;

	@Override
	protected void registerGoals()
	{
		return;
	}

	public SurgeVehicle(EntityType<? extends AbstractFishEntity> type, World worldIn)
	{
		super(type, worldIn);
	}

	@Override
	protected ItemStack getFishBucket()
	{
		return null;
	}

	@Override
	protected SoundEvent getFlopSound()
	{
		return null;
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void tick()
	{
		Entity entity = this.getControllingPassenger();
		if (this.getControllingPassenger() != null)
		{
			LivingEntity player = (LivingEntity) entity;
			Vec3d lookVec = entity.getLookVec();
			if (this.inWater && keyboard.isKeyDown)
			{
				this.setMotion(this.getMotion().add(lookVec.x / 13, lookVec.y / 13, lookVec.z / 13));
			}
			Vec3i directionVec = entity.getHorizontalFacing().getDirectionVec();
			this.prevRotationYawHead = player.prevRotationYawHead;
			this.rotationYaw = entity.getRotationYawHead();
			this.setRotationYawHead(entity.getRotationYawHead());

			this.rotationPitch = entity.getPitch(1);
		}
		super.tick();

	}

	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	@Override
	public void livingTick()
	{

		//this.tickLerp();
		super.livingTick();
	}


	private void tickLerp()
	{
		if (this.lerpSteps > 0 && !this.canPassengerSteer())
		{
			double d0 = this.posX + (this.lerpX - this.posX) / (double) this.lerpSteps;
			double d1 = this.posY + (this.lerpY - this.posY) / (double) this.lerpSteps;
			double d2 = this.posZ + (this.lerpZ - this.posZ) / (double) this.lerpSteps;
			double d3 = MathHelper.wrapDegrees(this.lerpYaw - (double) this.rotationYaw);
			this.rotationYaw = (float) ((double) this.rotationYaw + d3 / (double) this.lerpSteps);
			this.rotationPitch = (float) ((double) this.rotationPitch + (this.lerpPitch - (double) this.rotationPitch) / (double) this.lerpSteps);
			--this.lerpSteps;
			this.setPosition(d0, d1, d2);
			this.setRotation(this.rotationYaw, this.rotationPitch);
		}
	}

	/**
	 * Called when the entity is attacked.
	 *
	 * @param source
	 * @param amount
	 */
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		return false;
	}

	public void lerp(float prevRotationYaw, float rotationYaw, float partialTicks)
	{

	}

	public static void KeyInputEvent(final InputEvent.KeyInputEvent event)
	{
	}

	protected void mountTo(PlayerEntity player)
	{
		if (!this.world.isRemote)
		{
			player.rotationYaw = this.rotationYaw;
			player.rotationPitch = this.rotationPitch;
			player.startRiding(this);
		}
	}

	/**
	 * Returns the Y offset from the entity's position for any entity riding this one.
	 */
	@Override
	public double getMountedYOffset()
	{
		return -0.2F;
	}

	@Override
	public void updatePassenger(Entity passenger)
	{
		Entity controllingPassenger = this.getControllingPassenger();
		controllingPassenger.setPosition(this.posX, this.posY + this.getMountedYOffset() + controllingPassenger.getYOffset(), this.posZ);
	}


	@Override
	protected boolean processInteract(PlayerEntity player, Hand hand)
	{
		mountTo(player);
		return true;
	}

	@Nullable
	public Entity getControllingPassenger()
	{
		return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
	}

	public boolean canBeSteered()
	{
		return this.getControllingPassenger() instanceof LivingEntity;
	}

}