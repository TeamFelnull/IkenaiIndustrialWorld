package red.felnull.iiw;

import red.felnull.iiw.block.IIWBlocks;
import red.felnull.iiw.blockentity.IIWBlockEntitys;
import red.felnull.iiw.fluid.IIWFluids;
import red.felnull.iiw.item.IIWItems;

public class IkenaiIndustrialWorld {
    public static final String MODID = "ikenaiindustrialworld";

    public static void init() {
        IIWItems.init();
        IIWBlocks.init();
        IIWBlockEntitys.init();
        IIWFluids.init();
    }
}
