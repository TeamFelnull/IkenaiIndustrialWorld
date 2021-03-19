package red.felnull.epochnaruworld.client;

import net.fabricmc.api.ClientModInitializer;

public class EpochNaruWorldClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EpochNaruWorld.clientInit();
    }
}
