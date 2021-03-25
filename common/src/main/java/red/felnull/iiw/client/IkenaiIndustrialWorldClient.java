package red.felnull.iiw.client;

import red.felnull.iiw.client.blockentity.IIWBERenderers;
import red.felnull.iiw.client.item.IIWItemRenderers;

public class IkenaiIndustrialWorldClient {
    public static void clientInit() {
        IIWBERenderers.init();
        IIWItemRenderers.init();
    }
}
