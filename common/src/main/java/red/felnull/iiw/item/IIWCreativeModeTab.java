package red.felnull.iiw.item;

import me.shedaniel.architectury.registry.CreativeTabs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import red.felnull.iiw.IkenaiIndustrialWorld;

public class IIWCreativeModeTab {
    public static final CreativeModeTab MOD_TAB = CreativeTabs.create(new ResourceLocation(IkenaiIndustrialWorld.MODID, IkenaiIndustrialWorld.MODID), () -> new ItemStack(IIWItems.SECOND_REFINED_BRICK));
}
