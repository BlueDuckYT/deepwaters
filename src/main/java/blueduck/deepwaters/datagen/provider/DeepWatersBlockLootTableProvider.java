package blueduck.deepwaters.datagen.provider;

import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;
import net.minecraft.world.storage.loot.LootTable;

import java.util.function.Function;
import java.util.function.Supplier;

public abstract class DeepWatersBlockLootTableProvider extends BlockLootTables {

    public void registerTable(Supplier<? extends Block> block, Function<Block, LootTable.Builder> factory) {
        super.registerLootTable(block.get(), factory);
    }

    public void dropSelf(Supplier<? extends Block> block) {
        super.registerDropSelfLootTable(block.get());
    }

    public void dropAsSilk(Supplier<? extends Block> block) {
        super.registerSilkTouch(block.get());
    }

    public void dropWithSilk(Supplier<? extends Block> block, Supplier<? extends IItemProvider> drop) {
        registerLootTable(block.get(), (result) -> droppingWithSilkTouch(result, drop.get()));
    }

    public void dropWithFortune(Supplier<? extends Block> block, Supplier<? extends Item> drop) {
        super.registerLootTable(block.get(), (result) -> droppingItemWithFortune(result, drop.get()));
    }

}
