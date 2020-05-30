package bernie.software.datagen;

import bernie.software.datagen.provider.DeepWatersBlockLootTableProvider;
import bernie.software.registry.DeepWatersBlocks;
import bernie.software.registry.DeepWatersEntities;
import bernie.software.registry.DeepWatersItems;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.EntityLootTables;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.EntityHasProperty;
import net.minecraft.world.storage.loot.conditions.KilledByPlayer;
import net.minecraft.world.storage.loot.functions.LootingEnchantBonus;
import net.minecraft.world.storage.loot.functions.SetCount;
import net.minecraft.world.storage.loot.functions.Smelt;
import net.minecraftforge.fml.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class DeepWatersLootTables extends LootTableProvider
{

	public DeepWatersLootTables(DataGenerator dataGenerator)
	{
		super(dataGenerator);
	}

	@Override
	public String getName()
	{
		return "Deepwaters LootTables";
	}

	@Override
	protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables()
	{
		return ImmutableList.of(Pair.of(Blocks::new, LootParameterSets.BLOCK), Pair.of(Entities::new, LootParameterSets.ENTITY));
	}

	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationresults)
	{

	}

	public static List<RegistryObject<Block>> NormalItemDropBlocks = new ArrayList<>();

	public static class Blocks extends DeepWatersBlockLootTableProvider
	{
		@Override
		protected void addTables()
		{
			for (RegistryObject<Block> block : NormalItemDropBlocks)
			{
				dropSelf(block);
			}
			dropWithSilk(DeepWatersBlocks.MOSSY_OCEAN_FLOOR, DeepWatersBlocks.OCEAN_FLOOR);
			dropSelf(DeepWatersBlocks.DEADWOOD_DOOR);
			dropSelf(DeepWatersBlocks.SCRAP_DOOR);
			dropSelf(DeepWatersBlocks.AQUA_STONE);
			dropSelf(DeepWatersBlocks.AQUA_COMPARE);
			dropSelf(DeepWatersBlocks.AQUA_REPEAT);
			dropSelf(DeepWatersBlocks.AQUA_BLOCK);
			dropSelf(DeepWatersBlocks.AQUA_TORCH);
			dropSelf(DeepWatersBlocks.AQUA_TORCH_WALL);
			dropSelf(DeepWatersBlocks.AQUA_STONE_BUTTON);
			dropSelf(DeepWatersBlocks.SUNKEN_WASTES_LAMP);
			dropSelf(DeepWatersBlocks.PORTAL_PILLAR);
			dropSelf(DeepWatersBlocks.DEADWOOD_LOG);
			dropSelf(DeepWatersBlocks.BUBBLE_MACHINE);
			dropWithSilk(DeepWatersBlocks.ACTIVATED_PORTAL_PILLAR, DeepWatersBlocks.PORTAL_PILLAR);

			dropWithFortune(DeepWatersBlocks.SALT_ORE, DeepWatersItems.SALT_CRYSTAL);
			dropWithFortune(DeepWatersBlocks.CRYSTALINE_CORAL, DeepWatersItems.CRYSTALINE_CORAL);
			dropWithFortune(DeepWatersBlocks.DEAD_CRYSTALINE_CORAL, DeepWatersItems.DEAD_CRYSTALINE_CORAL);
		}

		@Override
		protected Iterable<Block> getKnownBlocks()
		{
			return DeepWatersBlocks.BLOCKS.getEntries().stream().map(Supplier::get).collect(Collectors.toList());
		}

	}

	public static class Entities extends EntityLootTables
	{

		@Override
		protected void addTables()
		{
			this.registerLootTable(DeepWatersEntities.KILLER_WIGGLER.get(), LootTable.builder().addLootPool(LootPool.builder().rolls(ConstantRange.of(1)).addEntry(ItemLootEntry.builder(DeepWatersItems.PRISMARINE_INGOT.get()).acceptFunction(SetCount.builder(RandomValueRange.of(1F, 3F)))).acceptFunction(LootingEnchantBonus.builder(RandomValueRange.of(1F, 2F))).acceptCondition(KilledByPlayer.builder())));
			this.registerLootTable(DeepWatersEntities.BLUFFERFISH.get(), LootTable.builder().addLootPool(LootPool.builder().rolls(ConstantRange.of(1)).addEntry(ItemLootEntry.builder(DeepWatersItems.BLUFFERFISH.get()).acceptFunction(SetCount.builder(ConstantRange.of(1))).acceptFunction(Smelt.func_215953_b().acceptCondition(EntityHasProperty.builder(LootContext.EntityTarget.THIS, ON_FIRE))).acceptFunction(LootingEnchantBonus.builder(RandomValueRange.of(0F, 1F))))));
			this.registerLootTable(DeepWatersEntities.STING_RAY.get(), LootTable.builder());
			this.registerLootTable(DeepWatersEntities.BABY_KRACKEN.get(), LootTable.builder());
			this.registerLootTable(DeepWatersEntities.MUCK_GULPER.get(), LootTable.builder().addLootPool(LootPool.builder().rolls(ConstantRange.of(1)).addEntry(ItemLootEntry.builder(DeepWatersItems.MUCK_GULPER.get()).acceptFunction(SetCount.builder(ConstantRange.of(1))).acceptFunction(Smelt.func_215953_b().acceptCondition(EntityHasProperty.builder(LootContext.EntityTarget.THIS, ON_FIRE))).acceptFunction(LootingEnchantBonus.builder(RandomValueRange.of(0F, 1F))))));
			this.registerLootTable(DeepWatersEntities.CORAL_CRAWLER.get(), LootTable.builder());
			this.registerLootTable(DeepWatersEntities.DONUT_FISH.get(), LootTable.builder());
			this.registerLootTable(DeepWatersEntities.COLORFUL_FISH.get(), LootTable.builder());
			this.registerLootTable(DeepWatersEntities.LEG_FISH.get(), LootTable.builder());
			this.registerLootTable(DeepWatersEntities.DEEP_GLIDER.get(), LootTable.builder());
			this.registerLootTable(DeepWatersEntities.SKULL_FISH.get(), LootTable.builder());
			this.registerLootTable(DeepWatersEntities.JUNGLE_FISH.get(), LootTable.builder());
		}

		@Override
		protected Iterable<EntityType<?>> getKnownEntities()
		{
			return DeepWatersEntities.ENTITIES.getEntries().stream().map(Supplier::get).collect(Collectors.toList());
		}
	}

}
