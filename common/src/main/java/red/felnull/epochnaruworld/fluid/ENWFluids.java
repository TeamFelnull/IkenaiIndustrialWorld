package red.felnull.epochnaruworld.fluid;

import me.shedaniel.architectury.registry.DeferredRegister;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import red.felnull.epochnaruworld.EpochNaruWorld;
import red.felnull.epochnaruworld.item.ENWCreativeModeTab;
import red.felnull.otyacraftengine.fluid.FluidProperties;
import red.felnull.otyacraftengine.fluid.IkisugiFluid;
import red.felnull.otyacraftengine.util.IKSGFluidUtil;
import red.felnull.otyacraftengine.util.IKSGMath;

public class ENWFluids {
    private static final DeferredRegister<Fluid> MOD_FLUID_REGISTER = DeferredRegister.create(EpochNaruWorld.MODID, Registry.FLUID_REGISTRY);
    private static final DeferredRegister<Item> MOD_BUCKETITEMS_REGISTER = DeferredRegister.create(EpochNaruWorld.MODID, Registry.ITEM_REGISTRY);
    private static final DeferredRegister<Block> MOD_BLOCKS_REGISTER = DeferredRegister.create(EpochNaruWorld.MODID, Registry.BLOCK_REGISTRY);

    public static final IkisugiFluid STEAM = register("steam", new FluidProperties().color(14474460).temperature(IKSGMath.toKelvin(100)).gas());
    public static final IkisugiFluid OIL = register("oil", new FluidProperties().color(1315860).rarity(Rarity.UNCOMMON));

    private static IkisugiFluid register(String name, FluidProperties properties) {
        return IKSGFluidUtil.register(new ResourceLocation(EpochNaruWorld.MODID, name), properties, ENWCreativeModeTab.MOD_TAB, MOD_FLUID_REGISTER, MOD_BUCKETITEMS_REGISTER, MOD_BLOCKS_REGISTER);
    }

    public static void init() {
        MOD_FLUID_REGISTER.register();
        MOD_BUCKETITEMS_REGISTER.register();
        MOD_BLOCKS_REGISTER.register();
    }
}
