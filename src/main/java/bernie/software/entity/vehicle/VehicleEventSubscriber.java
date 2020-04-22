package bernie.software.entity.vehicle;

import bernie.software.DeepWatersMod;
import com.mrcrayfish.backpacked.integration.Curios;
import com.mrcrayfish.backpacked.inventory.ExtendedPlayerInventory;
import com.mrcrayfish.backpacked.inventory.container.ExtendedPlayerContainer;
import com.mrcrayfish.backpacked.network.PacketHandler;
import com.mrcrayfish.backpacked.network.message.MessageUpdateBackpack;
import com.mrcrayfish.backpacked.proxy.ClientProxy;
import com.mrcrayfish.backpacked.proxy.CommonProxy;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.screen.inventory.CreativeScreen;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.GuiContainerEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.PacketDistributor;
import top.theillusivec4.curios.api.CuriosAPI;
import top.theillusivec4.curios.api.imc.CurioIMCMessage;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Author: MrCrayfish
 */
@Mod(DeepWatersMod.ModID)
public class Backpacked
{
	public static final ResourceLocation EMPTY_BACKPACK_SLOT = new ResourceLocation(DeepWatersMod.ModID, "item/empty_backpack_slot");

	public static final CommonProxy PROXY = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);

	private static boolean curiosLoaded = false;

	private static Field xPosField;
	private static Field yPosField;
	private static Field inventoryField;
	private static Field containerField;

	public Backpacked()
	{
		MinecraftForge.EVENT_BUS.register(this);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onEnqueueIMC);
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.commonSpec);
		curiosLoaded = ModList.get().isLoaded("curios");
	}

	private void onCommonSetup(FMLCommonSetupEvent event)
	{
		PacketHandler.init();
	}

	private void onClientSetup(FMLClientSetupEvent event)
	{
		PROXY.setupClient();
	}

	private void onEnqueueIMC(InterModEnqueueEvent event)
	{
		if(!curiosLoaded)
			return;

		InterModComms.sendTo("curios", CuriosAPI.IMC.REGISTER_TYPE, () -> new CurioIMCMessage("backpacked").setSize(1));
		InterModComms.sendTo("curios", CuriosAPI.IMC.REGISTER_ICON, () -> new Tuple<>("backpacked", new ResourceLocation(Reference.MOD_ID, "item/empty_backpack_slot")));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onPlayerRenderScreen(GuiContainerEvent.DrawBackground event)
	{
		if(curiosLoaded)
			return;

		ContainerScreen screen = event.getGuiContainer();
		if(screen instanceof InventoryScreen)
		{
			InventoryScreen inventoryScreen = (InventoryScreen) screen;
			int left = inventoryScreen.getGuiLeft();
			int top = inventoryScreen.getGuiTop();
			inventoryScreen.getMinecraft().getTextureManager().bindTexture(ContainerScreen.INVENTORY_BACKGROUND);
			Screen.blit(left + 76, top + 43, 18, 18, 76, 61, 18, 18, 256, 256);
		}
		else if(screen instanceof CreativeScreen)
		{
			CreativeScreen creativeScreen = (CreativeScreen) screen;
			if(creativeScreen.getSelectedTabIndex() == ItemGroup.INVENTORY.getIndex())
			{
				int left = creativeScreen.getGuiLeft();
				int top = creativeScreen.getGuiTop();
				creativeScreen.getMinecraft().getTextureManager().bindTexture(ContainerScreen.INVENTORY_BACKGROUND);
				Screen.blit(left + 126, top + 19, 18, 18, 76, 61, 18, 18, 256, 256);
			}
		}
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onTextureStitch(TextureStitchEvent.Pre event)
	{
		if(event.getMap().getBasePath().equals(AtlasTexture.LOCATION_BLOCKS_TEXTURE))
		{
			event.addSprite(EMPTY_BACKPACK_SLOT);
		}
	}

	@SubscribeEvent
	public void onPlayerClone(PlayerEvent.Clone event)
	{
		if(curiosLoaded)
			return;

		PlayerEntity oldPlayer = event.getOriginal();
		if(oldPlayer.inventory instanceof ExtendedPlayerInventory && event.getPlayer().inventory instanceof ExtendedPlayerInventory)
		{
			((ExtendedPlayerInventory) event.getPlayer().inventory).copyBackpack((ExtendedPlayerInventory) oldPlayer.inventory);
		}
	}

	@SubscribeEvent
	public void onStartTracking(PlayerEvent.StartTracking event)
	{

		if(curiosLoaded)
			return;

		PlayerEntity player = event.getPlayer();
		if(player.inventory instanceof ExtendedPlayerInventory)
		{
			if(!((ExtendedPlayerInventory) player.inventory).getBackpackItems().get(0).isEmpty())
			{
				PacketHandler.instance.send(PacketDistributor.TRACKING_ENTITY.with(() -> player), new MessageUpdateBackpack(player.getEntityId(), true));
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event)
	{
		if(curiosLoaded)
			return;

		if(event.phase != TickEvent.Phase.START)
			return;

		PlayerEntity player = event.player;
		if(!player.world.isRemote && player.inventory instanceof ExtendedPlayerInventory)
		{
			ExtendedPlayerInventory inventory = (ExtendedPlayerInventory) player.inventory;
			if(!inventory.backpackArray.get(0).equals(inventory.backpackInventory.get(0)))
			{
				PacketHandler.instance.send(PacketDistributor.TRACKING_ENTITY.with(() -> player), new MessageUpdateBackpack(player.getEntityId(), !inventory.backpackInventory.get(0).isEmpty()));
				inventory.backpackArray.set( 0, inventory.backpackInventory.get(0));
			}
		}
	}

	/*
	 * Hooks into PlayerEntity constructor to allow manipulation of fields.
	 * Linked via ASM, do not remove!
	 */
	public static void onPlayerInit(PlayerEntity player)
	{
		if(curiosLoaded)
			return;
		Backpacked.patchInventory(player);
	}

	private static void patchInventory(PlayerEntity player)
	{
		if(inventoryField == null)
		{
			inventoryField = getFieldAndSetAccessible(PlayerEntity.class, "field_71071_by");
		}
		if(containerField == null)
		{
			containerField = getFieldAndSetAccessible(PlayerEntity.class, "field_71069_bz");
		}
		try
		{
			ExtendedPlayerInventory inventory = new ExtendedPlayerInventory(player);
			inventoryField.set(player, inventory);

			ExtendedPlayerContainer container = new ExtendedPlayerContainer(inventory, !player.world.isRemote, player);
			containerField.set(player, container);
			player.openContainer = container;
		}
		catch(IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}

	private static Field getFieldAndSetAccessible(Class clazz, String obfName)
	{
		Field field = ObfuscationReflectionHelper.findField(clazz, obfName);
		field.setAccessible(true);

		try
		{
			Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
		}
		catch(IllegalAccessException | NoSuchFieldException e)
		{
			e.printStackTrace();
		}

		return field;
	}

	/*
	 * Fixes the backpack slot in the creative inventory to be positioned correctly.
	 * Linked via ASM, do not remove!
	 */
	@OnlyIn(Dist.CLIENT)
	public static void patchCreativeSlots(CreativeScreen.CreativeContainer creativeContainer)
	{
		if(curiosLoaded)
			return;

		creativeContainer.inventorySlots.stream().filter(slot -> slot.inventory instanceof ExtendedPlayerInventory && slot.getSlotIndex() == 41).findFirst().ifPresent(slot ->
		{
			Backpacked.setSlotPosition(slot, 127, 20);
		});
	}

	/*
	 * Fixes an issue in net.minecraft.network.play.client.CCreativeInventoryActionPacket where a
	 * slot index flag excludes the backpack slot. Linked via ASM, do not remove!
	 */
	public static int getCreativeSlotMax(ServerPlayerEntity player)
	{
		if(!curiosLoaded && player.inventory instanceof ExtendedPlayerInventory)
		{
			return 46;
		}
		return 45;
	}

	public static boolean isCuriosLoaded()
	{
		return curiosLoaded;
	}

	public static ItemStack getBackpackStack(PlayerEntity player)
	{
		AtomicReference<ItemStack> backpack = new AtomicReference<>(ItemStack.EMPTY);
		if(Backpacked.isCuriosLoaded())
		{
			backpack.set(Curios.getBackpackStack(player));
		}
		if(player.inventory instanceof ExtendedPlayerInventory)
		{
			ExtendedPlayerInventory inventory = (ExtendedPlayerInventory) player.inventory;
			backpack.set(inventory.getBackpackItems().get(0));
		}
		return backpack.get();
	}

	private static void setSlotPosition(Slot slot, int x, int y)
	{
		try
		{
			if(xPosField == null)
			{
				Field xPos = ObfuscationReflectionHelper.findField(Slot.class, "field_75223_e");
				xPos.setAccessible(true);
				Field xPosModifiers = Field.class.getDeclaredField("modifiers");
				xPosModifiers.setAccessible(true);
				xPosModifiers.setInt(xPos, xPos.getModifiers() & ~Modifier.FINAL);
				xPosField = xPos;
			}
			if(yPosField == null)
			{
				Field yPos = ObfuscationReflectionHelper.findField(Slot.class, "field_75221_f");
				yPos.setAccessible(true);
				Field yPosModifiers = Field.class.getDeclaredField("modifiers");
				yPosModifiers.setAccessible(true);
				yPosModifiers.setInt(yPos, yPos.getModifiers() & ~Modifier.FINAL);
				yPosField = yPos;
			}
			xPosField.set(slot, x);
			yPosField.set(slot, y);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
