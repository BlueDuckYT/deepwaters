package bernie.software.datagen;

import bernie.software.datagen.provider.DeepWatersBlockLootTableProvider;
import bernie.software.registry.DeepWatersBlocks;
import bernie.software.registry.DeepWatersEntities;
import bernie.software.registry.DeepWatersItems;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.EntityLootTables;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.KilledByPlayer;
import net.minecraft.world.storage.loot.functions.LootingEnchantBonus;
import net.minecraft.world.storage.loot.functions.SetCount;

import java.util.function.Supplier;
import java.util.stream.Collectors;

public class DeepWatersLootTables extends LootTableProvider {

    public DeepWatersLootTables(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public String getName() {
        return "Deepwaters LootTables";
    }

    public static class Blocks extends DeepWatersBlockLootTableProvider {
        @Override
        protected void addTables() {
            dropSelf(DeepWatersBlocks.OCEAN_FLOOR);
            dropSelf(DeepWatersBlocks.SUNKEN_GRAVEL);
            dropWithSilk(DeepWatersBlocks.MOSSY_OCEAN_FLOOR, DeepWatersBlocks.OCEAN_FLOOR);

            dropWithFortune(DeepWatersBlocks.SALT_ORE, DeepWatersItems.SALT_CRYSTAL);
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return DeepWatersBlocks.BLOCKS.getEntries().stream().map(Supplier::get).collect(Collectors.toList());
        }

    }

    public static class Entities extends EntityLootTables {
        @Override
        protected void addTables() {
            this.registerLootTable(DeepWatersEntities.KILLER_WIGGLER.get(),
                    LootTable.builder().addLootPool(LootPool.builder().rolls(ConstantRange.of(1)).addEntry(ItemLootEntry.builder(Items.DIAMOND).acceptFunction(SetCount.builder(RandomValueRange.of(0.0F, 1.0F))).acceptFunction(LootingEnchantBonus.builder(RandomValueRange.of(0.0F, 1.0F)))).acceptCondition(KilledByPlayer.builder())));
            this.registerLootTable(DeepWatersEntities.BLUFFERFISH.get(),
                    LootTable.builder().addLootPool(LootPool.builder().rolls(ConstantRange.of(1)).addEntry(ItemLootEntry.builder(DeepWatersItems.SALT_CRYSTAL.get()).acceptFunction(SetCount.builder(RandomValueRange.of(0.0F, 3.0F))).acceptFunction(LootingEnchantBonus.builder(RandomValueRange.of(0.0F, 2.0F)))).acceptCondition(KilledByPlayer.builder())));
            this.registerLootTable(DeepWatersEntities.CLAM.get(),
                    LootTable.builder().addLootPool(LootPool.builder().rolls(ConstantRange.of(1)).addEntry(ItemLootEntry.builder(DeepWatersItems.PEARL.get()).acceptFunction(SetCount.builder(RandomValueRange.of(0.0F, 1.0F))).acceptFunction(LootingEnchantBonus.builder(RandomValueRange.of(0.0F, 1.0F)))).acceptCondition(KilledByPlayer.builder())));
            this.registerLootTable(DeepWatersEntities.STING_RAY.get(),
                    LootTable.builder());
        }

        @Override
        protected Iterable<EntityType<?>> getKnownEntities() {
            return DeepWatersEntities.ENTITIES.getEntries().stream().map(Supplier::get).collect(Collectors.toList());
        }
    }

}
