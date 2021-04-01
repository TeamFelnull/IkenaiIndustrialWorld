package red.felnull.iiw.block.propertie;

import net.minecraft.world.level.block.state.properties.EnumProperty;

public class IIWBlockStateProperties {
    public static final EnumProperty<TubeConnectionState> NORTH_TUBE_STATE = EnumProperty.create("north", TubeConnectionState.class);
    public static final EnumProperty<TubeConnectionState> EAST_TUBE_STATE = EnumProperty.create("east", TubeConnectionState.class);
    public static final EnumProperty<TubeConnectionState> SOUTH_TUBE_STATE = EnumProperty.create("south", TubeConnectionState.class);
    public static final EnumProperty<TubeConnectionState> WEST_TUBE_STATE = EnumProperty.create("west", TubeConnectionState.class);
    public static final EnumProperty<TubeConnectionState> UP_TUBE_STATE = EnumProperty.create("up", TubeConnectionState.class);
    public static final EnumProperty<TubeConnectionState> DOWN_TUBE_STATE = EnumProperty.create("down", TubeConnectionState.class);
}
