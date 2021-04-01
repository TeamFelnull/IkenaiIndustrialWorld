package red.felnull.iiw.client.blockentity;

import red.felnull.iiw.blockentity.IIWBlockEntitys;
import red.felnull.otyacraftengine.client.util.IKSGClientUtil;

public class IIWBERenderers {
    public static void init() {
        IKSGClientUtil.registerBlockEntityRenderer(IIWBlockEntitys.TANK, TankRenderer::new);
        IKSGClientUtil.registerBlockEntityRenderer(IIWBlockEntitys.FLUID_PIPE, FluidPipeRenderer::new);
    }
}
