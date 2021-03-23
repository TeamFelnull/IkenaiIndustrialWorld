package red.felnull.iiw.item;

import me.shedaniel.architectury.registry.DeferredRegister;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;
import red.felnull.iiw.IkenaiIndustrialWorld;

public class IIWItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(IkenaiIndustrialWorld.MODID, Registry.ITEM_REGISTRY);

    public static final Item SECOND_REFINED_BRICK = register("second_refined_brick");

    private static Item register(String name) {
        return register(name, new Item(new Item.Properties().tab(IIWCreativeModeTab.MOD_TAB)));
    }

    private static Item register(String name, Item item) {
        ITEMS.register(name, () -> item);
        return item;
    }

    public static void init() {
        ITEMS.register();
    }
}
