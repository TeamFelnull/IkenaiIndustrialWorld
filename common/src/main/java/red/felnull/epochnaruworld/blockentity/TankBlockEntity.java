package red.felnull.epochnaruworld.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.BlockState;
import red.felnull.epochnaruworld.block.TankBlock;
import red.felnull.otyacraftengine.blockentity.IIkisugibleFluidTankBlockEntity;
import red.felnull.otyacraftengine.blockentity.IkisugiBlockEntity;
import red.felnull.otyacraftengine.fluid.IkisugiFluidTank;

import java.util.Optional;

public class TankBlockEntity extends IkisugiBlockEntity implements IIkisugibleFluidTankBlockEntity {
    private IkisugiFluidTank tank;
    private final int tierLevel;

    public TankBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ENWBlockEntitys.TANK, blockPos, blockState);
        this.tierLevel = ((TankBlock) blockState.getBlock()).getTierLevel();
        tank = new IkisugiFluidTank(TankBlock.getTankCapacity(tierLevel));
    }

    @Override
    public CompoundTag save(CompoundTag compoundTag) {
        tank.save(compoundTag);
        return super.save(compoundTag);
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
}
