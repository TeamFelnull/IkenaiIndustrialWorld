package red.felnull.epochnaruworld.block.shape;

import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import red.felnull.otyacraftengine.util.IKSGVoxelShapeUtil;

public class TankShape {
    private static final VoxelShape NORTH_PART1 = IKSGVoxelShapeUtil.makeBox(1.0d, 0.0d, 1.0d, 15.0d, 1.0d, 15.0d);
    private static final VoxelShape NORTH_PART2 = IKSGVoxelShapeUtil.makeBox(1.0d, 15.0d, 1.0d, 15.0d, 16.0d, 15.0d);
    private static final VoxelShape NORTH_PART3 = IKSGVoxelShapeUtil.makeBox(2.0d, 1.0d, 2.0d, 3.0d, 15.0d, 3.0d);
    private static final VoxelShape NORTH_PART4 = IKSGVoxelShapeUtil.makeBox(13.0d, 1.0d, 2.0d, 14.0d, 15.0d, 3.0d);
    private static final VoxelShape NORTH_PART5 = IKSGVoxelShapeUtil.makeBox(13.0d, 1.0d, 13.0d, 14.0d, 15.0d, 14.0d);
    private static final VoxelShape NORTH_PART6 = IKSGVoxelShapeUtil.makeBox(2.0d, 1.0d, 13.0d, 3.0d, 15.0d, 14.0d);
    private static final VoxelShape NORTH_PART7 = IKSGVoxelShapeUtil.makeBox(2.25d, 1.0d, 3.0d, 2.75d, 15.0d, 13.0d);
    private static final VoxelShape NORTH_PART8 = IKSGVoxelShapeUtil.makeBox(13.25d, 1.0d, 3.0d, 13.75d, 15.0d, 13.0d);
    private static final VoxelShape NORTH_PART9 = IKSGVoxelShapeUtil.makeBox(3.0d, 1.0d, 2.25d, 13.0d, 15.0d, 2.75d);
    private static final VoxelShape NORTH_PART10 = IKSGVoxelShapeUtil.makeBox(3.0d, 1.0d, 13.25d, 13.0d, 15.0d, 13.75d);

    public static final VoxelShape AXIS_AABB = Shapes.or(NORTH_PART1, NORTH_PART2, NORTH_PART3, NORTH_PART4, NORTH_PART5, NORTH_PART6, NORTH_PART7, NORTH_PART8, NORTH_PART9, NORTH_PART10);
}
