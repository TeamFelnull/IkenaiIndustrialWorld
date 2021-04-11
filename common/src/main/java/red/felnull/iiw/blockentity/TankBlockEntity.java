package red.felnull.iiw.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import red.felnull.iiw.block.TankBlock;
import red.felnull.otyacraftengine.blockentity.container.IkisugiFluidContainerBlockEntity;
import red.felnull.otyacraftengine.fluid.storage.FluidTank;

public class TankBlockEntity extends IkisugiFluidContainerBlockEntity {

    public TankBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(IIWBlockEntitys.TANK, blockPos, blockState);
    }

    public int getTierLevel() {
        if (getBlockState().getBlock() instanceof TankBlock) {
            return ((TankBlock) getBlockState().getBlock()).getTierLevel();
        }
        return 0;
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
        return 1;
    }

    @Override
    public void createTanks(NonNullList<FluidTank> nonNullList) {
        nonNullList.set(0, FluidTank.createEmpty(TankBlock.getTankCapacity(getTierLevel())));
    }
}
