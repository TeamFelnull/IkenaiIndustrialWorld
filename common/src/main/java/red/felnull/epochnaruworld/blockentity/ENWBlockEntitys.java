package red.felnull.epochnaruworld.blockentity;

import me.shedaniel.architectury.registry.DeferredRegister;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import red.felnull.epochnaruworld.EpochNaruWorld;
import red.felnull.epochnaruworld.block.ENWBlocks;
import red.felnull.otyacraftengine.util.IKSGBlockEntityUtil;

public class ENWBlockEntitys {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES_REGISTER = DeferredRegister.create(EpochNaruWorld.MODID, Registry.BLOCK_ENTITY_TYPE_REGISTRY);
    public static final BlockEntityType<TankBlockEntity> TANK = register("tank", TankBlockEntity::new, ENWBlocks.POOR_TANK, ENWBlocks.SIMPLE_TANK, ENWBlocks.BASIC_TANK);

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, IKSGBlockEntityUtil.IKSGBlockEntitySupplier<? extends BlockEntity> blockEntitySupplier, Block... blocks) {
        BlockEntityType<T> be = IKSGBlockEntityUtil.craeteBlockEntityType(blockEntitySupplier, blocks);
        BLOCK_ENTITY_TYPES_REGISTER.register(name, () -> be);
        return be;
    }

    public static void init() {
        BLOCK_ENTITY_TYPES_REGISTER.register();
    }
}
