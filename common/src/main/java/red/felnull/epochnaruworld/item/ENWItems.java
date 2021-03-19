package red.felnull.epochnaruworld.item;

import me.shedaniel.architectury.registry.DeferredRegister;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;
import red.felnull.epochnaruworld.EpochNaruWorld;

public class ENWItems {
    private static final DeferredRegister<Item> MOD_ITEMS_REGISTER = DeferredRegister.create(EpochNaruWorld.MODID, Registry.ITEM_REGISTRY);
   // public static final Item TEST = register("test_item");
    public static final Item SECOND_REFINED_BRICK = register("second_refined_brick");

    private static Item register(String name) {
        return register(name, new Item(new Item.Properties().tab(ENWCreativeModeTab.MOD_TAB)));
    }

    private static Item register(String name, Item item) {
        MOD_ITEMS_REGISTER.register(name, () -> item);
        return item;
    }

    public static void init() {
        MOD_ITEMS_REGISTER.register();
    }
}
