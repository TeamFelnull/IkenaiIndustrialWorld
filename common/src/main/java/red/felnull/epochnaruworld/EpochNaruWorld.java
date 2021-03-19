package red.felnull.epochnaruworld;

import red.felnull.epochnaruworld.block.ENWBlocks;
import red.felnull.epochnaruworld.blockentity.ENWBlockEntitys;
import red.felnull.epochnaruworld.fluid.ENWFluids;
import red.felnull.epochnaruworld.item.ENWItems;

public class EpochNaruWorld {
    public static final String MODID = "epochnaruworld";

    public static void init() {
        ENWBlocks.init();
        ENWItems.init();
        ENWFluids.init();
        ENWBlockEntitys.init();
    }
}
