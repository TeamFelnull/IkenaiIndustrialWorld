package red.felnull.iiw.client.item;

import red.felnull.iiw.block.IIWBlocks;
import red.felnull.otyacraftengine.client.util.IKSGClientUtil;

public class IIWItemRenderers {
    public static void init() {
        TankItemRenderer tir = new TankItemRenderer();
        IKSGClientUtil.registerItemRenderer(IIWBlocks.POOR_TANK, tir);
        IKSGClientUtil.registerItemRenderer(IIWBlocks.SIMPLE_TANK, tir);
        IKSGClientUtil.registerItemRenderer(IIWBlocks.BASIC_TANK, tir);

        IKSGClientUtil.registerItemRenderer(IIWBlocks.PIPE, new FluidPipeItemRenderer());
    }
}
