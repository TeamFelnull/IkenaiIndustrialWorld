package red.felnull.iiw.integration;

import red.felnull.iiw.IkenaiIndustrialWorld;
import red.felnull.otyacraftengine.api.IOEIntegration;
import red.felnull.otyacraftengine.api.OEIntegration;
import red.felnull.otyacraftengine.api.register.OEModelLoaderPathRegister;

@OEIntegration
public class IkenaiIndustrialWorldOEIntegration implements IOEIntegration {
    @Override
    public void registrationModelLoaderPath(OEModelLoaderPathRegister reg) {
        reg.register(IkenaiIndustrialWorld.MODID);
    }
}
