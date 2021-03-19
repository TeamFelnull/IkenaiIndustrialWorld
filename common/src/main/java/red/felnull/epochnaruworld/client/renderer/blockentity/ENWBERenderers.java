package red.felnull.epochnaruworld.client.renderer.blockentity;

import red.felnull.epochnaruworld.block.ENWBlocks;
import red.felnull.epochnaruworld.client.renderer.item.TankItemRenderer;
import red.felnull.otyacraftengine.client.util.IKSGClientUtil;

public class ENWBERenderers {
    public static void init() {
        TankItemRenderer tir = new TankItemRenderer();
        IKSGClientUtil.registerItemRenderer(ENWBlocks.POOR_TANK.asItem(), tir);
        IKSGClientUtil.registerItemRenderer(ENWBlocks.SIMPLE_TANK.asItem(), tir);
        IKSGClientUtil.registerItemRenderer(ENWBlocks.BASIC_TANK.asItem(), tir);
    }
}
