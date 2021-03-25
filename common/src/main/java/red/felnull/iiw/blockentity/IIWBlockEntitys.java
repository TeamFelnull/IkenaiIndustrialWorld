package red.felnull.iiw.blockentity;

import me.shedaniel.architectury.registry.DeferredRegister;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import red.felnull.iiw.IkenaiIndustrialWorld;
import red.felnull.iiw.block.IIWBlocks;
import red.felnull.otyacraftengine.util.IKSGBlockEntityUtil;

public class IIWBlockEntitys {
    public static final DeferredRegister<BlockEntityType<?>> ENTITY_TYPES = DeferredRegister.create(IkenaiIndustrialWorld.MODID, Registry.BLOCK_ENTITY_TYPE_REGISTRY);
    public static final BlockEntityType<TankBlockEntity> TANK = register("tank", TankBlockEntity::new, IIWBlocks.POOR_TANK, IIWBlocks.SIMPLE_TANK, IIWBlocks.BASIC_TANK);


    private static <T extends BlockEntity> BlockEntityType<T> register(String name, IKSGBlockEntityUtil.IKSGBlockEntitySupplier<? extends BlockEntity> blockEntitySupplier, Block... blocks) {
        BlockEntityType<T> be = IKSGBlockEntityUtil.craeteBlockEntityType(blockEntitySupplier, blocks);
        ENTITY_TYPES.register(name, () -> be);
        return be;
    }

    public static void init() {
        ENTITY_TYPES.register();
    }
}
