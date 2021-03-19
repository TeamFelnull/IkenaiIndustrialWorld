package red.felnull.epochnaruworld.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import red.felnull.epochnaruworld.block.shape.TankShape;
import red.felnull.epochnaruworld.blockentity.TankBlockEntity;
import red.felnull.otyacraftengine.util.IKSGFluidUtil;

public class TankBlock extends AbstractENWBaseEntityBlock {
    private final int tierLevel;

    public TankBlock(int tierLevel, Properties properties) {
        super(properties);
        this.tierLevel = tierLevel;
    }

    public int getTierLevel() {
        return tierLevel;
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return TankShape.AXIS_AABB;
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {

        IKSGFluidUtil.interactWithFluidTank(player, interactionHand, level, blockPos, blockHitResult.getDirection());
        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new TankBlockEntity(blockPos, blockState);
    }

    public static int getTankCapacity(int tierLevel) {
        return (int) Math.pow(2, tierLevel) * 16000;
    }

}
