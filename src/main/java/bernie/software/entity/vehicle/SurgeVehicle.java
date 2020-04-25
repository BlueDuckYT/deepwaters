package bernie.software.entity.vehicle;


import bernie.software.KeyboardHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class SurgeVehicle extends WaterMobEntity
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

	public SurgeVehicle(EntityType<? extends WaterMobEntity> type, World worldIn)
	{
		super(type, worldIn);
	}

//	@Override
//	protected ItemStack getFishBucket()
//	{
//		return null;
//	}
//
//	@Override
//	protected SoundEvent getFlopSound()
//	{
//		return null;
//	}

	/**
	 * Called to update the entity's position/logic.
	 */

	public ItemStackHandler inventory = initInventory();
	private LazyOptional<ItemStackHandler> itemHandler = LazyOptional.of(() -> inventory);

	protected ItemStackHandler initInventory()
	{
		return new ItemStackHandler()
		{
			@Override
			protected void onContentsChanged(final int slot)
			{
				int tempload = 0;
				for (int i = 0; i < getSlots(); i++)
				{
					if (!getStackInSlot(i).isEmpty())
					{
						tempload++;
					}
				}
				final int newValue;
				if (tempload > 31)
				{
					newValue = 4;
				}
				else if (tempload > 16)
				{
					newValue = 3;
				}
				else if (tempload > 8)
				{
					newValue = 2;
				}
				else if (tempload > 3)
				{
					newValue = 1;
				}
				else
				{
					newValue = 0;
				}
			}
		};
	}

	@Override
	public boolean replaceItemInInventory(final int inventorySlot, final ItemStack itemStackIn)
	{
		if (inventorySlot >= 0 && inventorySlot < inventory.getSlots())
		{
			inventory.setStackInSlot(inventorySlot, itemStackIn);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void remove(final boolean keepData)
	{
		super.remove(keepData);
		if (!keepData && itemHandler != null)
		{
			itemHandler.invalidate();
			itemHandler = null;
		}
	}

	@Override
	public <T> LazyOptional<T> getCapability(final Capability<T> capability, @Nullable final Direction facing)
	{
		if (isAlive() && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && itemHandler != null)
		{
			return itemHandler.cast();
		}
		return super.getCapability(capability, facing);
	}

	@Override
	public void tick()
	{
		Entity entity = getControllingPassenger();
		if (getControllingPassenger() != null)
		{
			LivingEntity player = (LivingEntity) entity;
			Minecraft mc = Minecraft.getInstance();
			Vec3d lookVec = entity.getLookVec();
			if (inWater && KeyboardHandler.isKeyDown)
			{
				setMotion(getMotion().add(lookVec.x / 10, lookVec.y / 10, lookVec.z / 10));
			}
			if (KeyboardHandler.isKeyDown)
			{
//                ((PlayerEntity) entity).openContainer();
			}

			Vec3i directionVec = entity.getHorizontalFacing().getDirectionVec();
			prevRotationYawHead = player.prevRotationYawHead;
			rotationYaw = entity.getRotationYawHead();
			setRotationYawHead(entity.getRotationYawHead());
			float pitch = entity.getPitch(1);
			//this.rotationPitch = pitch;
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
		if (lerpSteps > 0 && !canPassengerSteer())
		{
			double d0 = posX + (lerpX - posX) / (double) lerpSteps;
			double d1 = posY + (lerpY - posY) / (double) lerpSteps;
			double d2 = posZ + (lerpZ - posZ) / (double) lerpSteps;
			double d3 = MathHelper.wrapDegrees(lerpYaw - (double) rotationYaw);
			rotationYaw = (float) ((double) rotationYaw + d3 / (double) lerpSteps);
			rotationPitch = (float) ((double) rotationPitch + (lerpPitch - (double) rotationPitch) / (double) lerpSteps);
			--lerpSteps;
			setPosition(d0, d1, d2);
			setRotation(rotationYaw, rotationPitch);
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
		if (super.attackEntityFrom(source, amount))
		{
			remove();
		}
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
		if (!world.isRemote)
		{
			player.rotationYaw = rotationYaw;
			player.rotationPitch = rotationPitch;
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
		Entity controllingPassenger = getControllingPassenger();
		controllingPassenger.setPosition(posX,
				posY + getMountedYOffset() + controllingPassenger.getYOffset(), posZ);
	}


	@Override
	protected boolean processInteract(PlayerEntity player, Hand hand)
	{
		mountTo(player);
		return true;
	}

	@Override
	public boolean isPushedByWater()
	{
		return false;
	}


	@Override
	@Nullable
	public Entity getControllingPassenger()
	{
		return getPassengers().isEmpty() ? null : getPassengers().get(0);
	}

	@Override
	public boolean canBeSteered()
	{
		return getControllingPassenger() instanceof LivingEntity;
	}

}