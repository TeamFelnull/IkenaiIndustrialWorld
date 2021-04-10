package red.felnull.iiw.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import red.felnull.otyacraftengine.blockentity.container.IkisugiContainerBlockEntity;

public abstract class IIWBaseContainerBlockEntity extends IkisugiContainerBlockEntity {
    protected IIWBaseContainerBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }
}
