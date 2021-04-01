package red.felnull.iiw.block.propertie;

import net.minecraft.util.StringRepresentable;

public enum TubeConnectionState implements StringRepresentable {
    NONE("none"),
    CONNECT("connect"),
    PULL("pull"),
    PUSH("push"),
    BOTH("both"),
    REJECT("reject");

    private final String name;

    TubeConnectionState(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}
