package red.felnull.iiw.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import red.felnull.iiw.block.propertie.IIWBlockStateProperties;
import red.felnull.iiw.block.propertie.TubeConnectionState;

public abstract class IIWTubeBaseBlock extends IIWBaseEntityBlock {
    public static final EnumProperty<TubeConnectionState> NORTH = IIWBlockStateProperties.NORTH_TUBE_STATE;
    public static final EnumProperty<TubeConnectionState> EAST = IIWBlockStateProperties.EAST_TUBE_STATE;
    public static final EnumProperty<TubeConnectionState> SOUTH = IIWBlockStateProperties.SOUTH_TUBE_STATE;
    public static final EnumProperty<TubeConnectionState> WEST = IIWBlockStateProperties.WEST_TUBE_STATE;
    public static final EnumProperty<TubeConnectionState> UP = IIWBlockStateProperties.UP_TUBE_STATE;
    public static final EnumProperty<TubeConnectionState> DOWN = IIWBlockStateProperties.DOWN_TUBE_STATE;
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;

    public IIWTubeBaseBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(NORTH, TubeConnectionState.NONE).setValue(EAST, TubeConnectionState.NONE).setValue(SOUTH, TubeConnectionState.NONE).setValue(WEST, TubeConnectionState.NONE).setValue(UP, TubeConnectionState.NONE).setValue(DOWN, TubeConnectionState.NONE).setValue(AXIS, Direction.Axis.Y));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(NORTH, EAST, WEST, SOUTH, UP, DOWN, AXIS);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockState state = super.getStateForPlacement(blockPlaceContext);

        BlockState updatedState = updateConnection(blockPlaceContext.getLevel(), blockPlaceContext.getClickedPos(), state);

        return updatedState.setValue(AXIS, blockPlaceContext.getClickedFace().getAxis());
    }

    @Override
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        switch (rotation) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                switch (blockState.getValue(AXIS)) {
                    case X:
                        return blockState.setValue(AXIS, Direction.Axis.Z);
                    case Z:
                        return blockState.setValue(AXIS, Direction.Axis.X);
                    default:
                        return blockState;
                }
            default:
                return blockState;
        }
    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        blockState = updateConnection(levelAccessor, blockPos, blockState);
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    public static EnumProperty<TubeConnectionState> getStateProperty(Direction direction) {
        switch (direction) {
            case EAST:
                return EAST;
            case WEST:
                return WEST;
            case NORTH:
                return NORTH;
            case SOUTH:
                return SOUTH;
            case UP:
                return UP;
            case DOWN:
                return DOWN;
        }
        return UP;
    }

    public static BlockState updateConnection(LevelReader level, BlockPos pos, BlockState state) {
        Direction roted = null;
        boolean rotedFlag = false;
        for (Direction direction : Direction.values()) {
            Block block = level.getBlockState(pos.relative(direction)).getBlock();
            if (block instanceof IIWTubeBaseBlock) {
                state = state.setValue(getStateProperty(direction), TubeConnectionState.CONNECT);
                if (!rotedFlag) {
                    roted = direction;
                    rotedFlag = true;
                } else {
                    roted = null;
                }
            } else {
                state = state.setValue(getStateProperty(direction), TubeConnectionState.NONE);
            }
        }

        if (roted != null) {
            state = state.setValue(AXIS, roted.getAxis());
        }

        return state;
    }
}
