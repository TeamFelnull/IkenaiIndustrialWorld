package red.felnull.iiw.block;

import me.shedaniel.architectury.registry.DeferredRegister;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import red.felnull.iiw.IkenaiIndustrialWorld;
import red.felnull.iiw.item.IIWCreativeModeTab;
import red.felnull.iiw.item.TankBlockItem;

import java.util.function.Function;

public class IIWBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(IkenaiIndustrialWorld.MODID, Registry.BLOCK_REGISTRY);
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(IkenaiIndustrialWorld.MODID, Registry.ITEM_REGISTRY);

    public static final Block SECOND_REFINED_BRICS = register("second_refined_bricks", Material.STONE, 2f, 6f);

    public static final Block POOR_TANK = registerTank("poor_tank", 0, Material.STONE);
    public static final Block SIMPLE_TANK = registerTank("simple_tank", 1, Material.STONE);
    public static final Block BASIC_TANK = registerTank("basic_tank", 2, Material.METAL);

    public static Block registerTank(String name, int tier, Material material) {
        return register(name, new TankBlock(tier, BlockBehaviour.Properties.of(material).strength(1f, 1f).noOcclusion()), n -> new TankBlockItem(n, tier, new Item.Properties().tab(IIWCreativeModeTab.MOD_TAB)));
    }

    private static Block register(String name, Material materialIn, float hardness, float resistance) {
        return register(name, new Block(BlockBehaviour.Properties.of(materialIn).strength(hardness, resistance)));
    }

    private static Block register(String name, Material materialIn, SoundType sound, float hardness, float resistance) {
        return register(name, new Block(BlockBehaviour.Properties.of(materialIn).sound(sound).strength(hardness, resistance)));
    }

    private static Block register(String name, Block block) {
        return register(name, block, n -> new BlockItem(n, new Item.Properties().tab(IIWCreativeModeTab.MOD_TAB)));
    }

    private static Block register(String name, Block block, Function<Block, Item> blockitem) {
        BLOCKS.register(name, () -> block);
        BLOCK_ITEMS.register(name, () -> blockitem.apply(block));
        return block;
    }

    public static void init() {
        BLOCKS.register();
        BLOCK_ITEMS.register();
    }
}
