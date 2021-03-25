package red.felnull.iiw.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import red.felnull.iiw.block.TankBlock;
import red.felnull.otyacraftengine.blockentity.IIkisugibleFluidTankBlockEntity;
import red.felnull.otyacraftengine.fluid.IkisugiFluidTank;

import java.util.Optional;

public class TankBlockEntity extends IIWBaseContainerBlockEntity implements IIkisugibleFluidTankBlockEntity {
    private IkisugiFluidTank tank;
    private final int tierLevel;

    public TankBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(IIWBlockEntitys.TANK, blockPos, blockState);
        this.tierLevel = ((TankBlock) blockState.getBlock()).getTierLevel();
        tank = new IkisugiFluidTank(TankBlock.getTankCapacity(tierLevel));
    }

    @Override
    public CompoundTag save(CompoundTag compoundTag) {
        tank.save(compoundTag);
        return super.save(compoundTag);
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
    public void load(CompoundTag compoundTag) {
        tank.load(compoundTag);
        super.load(compoundTag);
    }

    @Override
    public Optional<IkisugiFluidTank> getFluidTank(Direction direction) {
        return Optional.of(tank);
    }

    public IkisugiFluidTank getTank() {
        return tank;
    }

    public int getTierLevel() {
        return tierLevel;
    }

    @Override
    public void tick() {
        syncble();
    }

    @Override
    public boolean tickble() {
        return true;
    }

    @Override
    public int getContainerSize() {
        return 0;
    }
}
