package red.felnull.iiw.fluid;

import me.shedaniel.architectury.registry.DeferredRegister;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import red.felnull.iiw.IkenaiIndustrialWorld;
import red.felnull.iiw.item.IIWCreativeModeTab;
import red.felnull.otyacraftengine.fluid.FluidProperties;
import red.felnull.otyacraftengine.fluid.IkisugiFluid;
import red.felnull.otyacraftengine.util.IKSGFluidUtil;
import red.felnull.otyacraftengine.util.IKSGMath;
import red.felnull.otyacraftengine.util.IKSGRegistryUtil;

public class IIWFluids {
    private static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(IkenaiIndustrialWorld.MODID, Registry.FLUID_REGISTRY);
    private static final DeferredRegister<Item> BUCKET_ITEMS = DeferredRegister.create(IkenaiIndustrialWorld.MODID, Registry.ITEM_REGISTRY);
    private static final DeferredRegister<Block> LIQUID_BLOCKS = DeferredRegister.create(IkenaiIndustrialWorld.MODID, Registry.BLOCK_REGISTRY);

    public static final IkisugiFluid STEAM = register("steam", new FluidProperties().color(14474460).temperature(IKSGMath.toKelvin(100)).gas());
    public static final IkisugiFluid OIL = register("oil", new FluidProperties().color(1315860).rarity(Rarity.UNCOMMON));

    private static IkisugiFluid register(String name, FluidProperties properties) {
        return IKSGRegistryUtil.registerFluid(new ResourceLocation(IkenaiIndustrialWorld.MODID, name), properties, IIWCreativeModeTab.MOD_TAB, FLUIDS, BUCKET_ITEMS, LIQUID_BLOCKS);
    }

    public static void init() {
        FLUIDS.register();
        BUCKET_ITEMS.register();
        LIQUID_BLOCKS.register();
    }
}
