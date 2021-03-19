package red.felnull.epochnaruworld.client.renderer.item;

import red.felnull.epochnaruworld.block.ENWBlocks;
import red.felnull.otyacraftengine.client.util.IKSGClientUtil;

public class ENWItemRenderers {
    public static void init() {
        TankItemRenderer tir = new TankItemRenderer();
        IKSGClientUtil.registerItemRenderer(ENWBlocks.POOR_TANK, tir);
        IKSGClientUtil.registerItemRenderer(ENWBlocks.SIMPLE_TANK, tir);
        IKSGClientUtil.registerItemRenderer(ENWBlocks.BASIC_TANK, tir);
    }
}
