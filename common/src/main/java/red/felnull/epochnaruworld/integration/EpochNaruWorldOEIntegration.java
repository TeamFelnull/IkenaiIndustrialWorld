package red.felnull.epochnaruworld.integration;

import red.felnull.epochnaruworld.EpochNaruWorld;
import red.felnull.epochnaruworld.biome.ENWBiomes;
import red.felnull.otyacraftengine.api.IOEIntegration;
import red.felnull.otyacraftengine.api.OEIntegration;
import red.felnull.otyacraftengine.api.helper.BiomeRegisterHelper;
import red.felnull.otyacraftengine.api.register.OEModelLoaderPathRegister;

@OEIntegration
public class EpochNaruWorldOEIntegration implements IOEIntegration {
    @Override
    public void biomeRegisterHelper(BiomeRegisterHelper reg) {
        ENWBiomes.init(reg);
    }

    @Override
    public void registrationModelLoaderPath(OEModelLoaderPathRegister reg) {
        reg.register(EpochNaruWorld.MODID);
    }
}
