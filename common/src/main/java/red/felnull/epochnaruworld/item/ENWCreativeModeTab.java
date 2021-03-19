package red.felnull.epochnaruworld.item;

import me.shedaniel.architectury.registry.CreativeTabs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import red.felnull.epochnaruworld.EpochNaruWorld;

public class ENWCreativeModeTab {
    public static final CreativeModeTab MOD_TAB = CreativeTabs.create(new ResourceLocation(EpochNaruWorld.MODID, EpochNaruWorld.MODID), () -> new ItemStack(ENWItems.SECOND_REFINED_BRICK));
}
