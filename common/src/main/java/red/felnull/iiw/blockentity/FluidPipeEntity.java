package red.felnull.iiw.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class FluidPipeEntity extends IIWTubeBaseBlockEntity {
    public FluidPipeEntity(BlockPos blockPos, BlockState blockState) {
        super(IIWBlockEntitys.FLUID_PIPE, blockPos, blockState);
    }
}
