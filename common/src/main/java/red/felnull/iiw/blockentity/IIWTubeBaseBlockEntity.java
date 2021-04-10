package red.felnull.iiw.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import red.felnull.otyacraftengine.blockentity.container.IkisugiFluidContainerBlockEntity;
import red.felnull.otyacraftengine.fluid.storage.FluidTank;

public class IIWTubeBaseBlockEntity extends IkisugiFluidContainerBlockEntity {
    protected IIWTubeBaseBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    @Override
    public void createTanks(NonNullList<FluidTank> nonNullList) {

    }

    @Override
    protected Component getDefaultName() {
        return null;
    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inventory) {
        return null;
    }

    @Override
    public int getFluidTankCount() {
        return 0;
    }
}
