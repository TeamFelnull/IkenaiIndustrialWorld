package red.felnull.iiw.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;
import red.felnull.otyacraftengine.util.IKSGRegistryUtil;

public class IIWFoods {
    public static final FoodProperties SLIME_BALL = new FoodProperties.Builder().nutrition(2).saturationMod(0.8F).effect(new MobEffectInstance(MobEffects.CONFUSION, 100, 0), 1.0F).build();
    public static final FoodProperties WHEAT = new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).build();
    public static final FoodProperties KELP = new FoodProperties.Builder().nutrition(1).saturationMod(0.2F).build();
    public static final FoodProperties NETHER_WART = new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.WITHER, 100, 0), 1.0F).build();
    public static final FoodProperties INK_SAC = new FoodProperties.Builder().nutrition(1).saturationMod(0.2F).effect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 0), 1.0F).build();
    public static final FoodProperties GLOW_INK_SAC = new FoodProperties.Builder().nutrition(1).saturationMod(0.2F).effect(new MobEffectInstance(MobEffects.GLOWING, 100, 0), 1.0F).build();

    public static void init() {
        IKSGRegistryUtil.replaceFood(Items.SLIME_BALL, SLIME_BALL);
        IKSGRegistryUtil.replaceFood(Items.WHEAT, WHEAT);
        IKSGRegistryUtil.replaceFood(Items.KELP, KELP);
        IKSGRegistryUtil.replaceFood(Items.NETHER_WART, NETHER_WART);
        IKSGRegistryUtil.replaceFood(Items.INK_SAC, INK_SAC);
        IKSGRegistryUtil.replaceFood(Items.GLOW_INK_SAC, GLOW_INK_SAC);
    }
}
