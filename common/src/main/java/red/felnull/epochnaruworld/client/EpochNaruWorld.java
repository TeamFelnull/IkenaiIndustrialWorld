package red.felnull.epochnaruworld.client;

import red.felnull.epochnaruworld.client.renderer.blockentity.ENWBERenderers;
import red.felnull.epochnaruworld.client.renderer.item.ENWItemRenderers;

public class EpochNaruWorld {
    public static void clientInit() {
        ENWBERenderers.init();
        ENWItemRenderers.init();
    }
}
