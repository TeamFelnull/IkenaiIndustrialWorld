package red.felnull.iiw.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import red.felnull.iiw.block.TankBlock;
import red.felnull.otyacraftengine.fluid.IkisugiFluidTank;

import java.util.Optional;

public class TankBlockEntity extends IIWBaseContainerBlockEntity {
    private final TankBlock tankBlock;

    public TankBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(IIWBlockEntitys.TANK, blockPos, blockState);
        this.tankBlock = (TankBlock) blockState.getBlock();
        setFluidTankCapacity(0, TankBlock.getTankCapacity(getTierLevel()));
    }

    public int getTierLevel() {
        return tankBlock.getTierLevel();
    }

    @Override
    protected Component getDefaultName() {
        return new TranslatableComponent(tankBlock.getDescriptionId());
    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inventory) {
        return null;
    }

    @Override
    public int getFluidTankSize() {
        return 1;
    }

    @Override
    public Optional<IkisugiFluidTank> getFluidTank(Direction side) {
        return Optional.of(getFluidTank(0));
    }
}
