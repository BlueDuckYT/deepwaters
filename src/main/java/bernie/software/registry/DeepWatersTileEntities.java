package bernie.software.registry;

import bernie.software.DeepWatersMod;
import bernie.software.block.SunkenGravelBlock;
import bernie.software.block.aquastone.AquastoneFan;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class DeepWatersTileEntities {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, DeepWatersMod.ModID);
//    public static final RegistryObject<TileEntityType<? extends TileEntity>> AQUASTONE_FAN = TILE_ENTITIES.register("aquastone_fan",new supplier(AquastoneFan.TileEntity.class));
//
//    public static class supplier implements Supplier<TileEntityType> {
//        public Class<? extends TileEntity> tileEntityClass;
//        public supplier(Class<? extends TileEntity> te) {
//            tileEntityClass=te;
//        }
//
//        @Override
//        public TileEntityType get() {
//            return TileEntityType.Builder.create(
//                    (Supplier) new supplier2(tileEntityClass), DeepWatersBlocks.AQUA_FAN.get())
//                    .build(null);
//        }
//
//        private class supplier2 implements Supplier<TileEntity> {
//            public Class<? extends TileEntity> tileEntityClass;
//            public supplier2(Class<? extends TileEntity> te) {
//                tileEntityClass=te;
//            }
//
//            @Override
//            public TileEntity get() {
//                try {
//                    return tileEntityClass.newInstance();
//                } catch (Exception err) {}
//                return null;
//            }
//        }
//    }
}
