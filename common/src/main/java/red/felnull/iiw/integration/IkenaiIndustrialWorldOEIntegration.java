package red.felnull.iiw.integration;

import red.felnull.iiw.IkenaiIndustrialWorld;
import red.felnull.otyacraftengine.api.IOEIntegration;
import red.felnull.otyacraftengine.api.helper.BiomeRegisterHelper;
import red.felnull.otyacraftengine.api.register.OEModelLoaderPathRegister;

public class IkenaiIndustrialWorldOEIntegration implements IOEIntegration {
    @Override
    public void biomeRegisterHelper(BiomeRegisterHelper reg) {

    }

    @Override
    public void registrationModelLoaderPath(OEModelLoaderPathRegister reg) {
        reg.register(IkenaiIndustrialWorld.MODID);
    }
}
