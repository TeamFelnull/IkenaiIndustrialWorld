package red.felnull.epochnaruworld.client.renderer.item;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import red.felnull.epochnaruworld.client.renderer.blockentity.TankRenderer;
import red.felnull.epochnaruworld.item.TankBlockItem;
import red.felnull.otyacraftengine.client.renderer.item.ICustomBEWLRenderer;
import red.felnull.otyacraftengine.fluid.IkisugiFluidTank;

import java.util.Optional;

public class TankItemRenderer implements ICustomBEWLRenderer {

    @Override
    public void renderByItem(ItemStack itemStack, ItemTransforms.TransformType transformType, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1) {
        Item item = itemStack.getItem();
        if (item instanceof TankBlockItem) {
            Optional<IkisugiFluidTank> tank = ((TankBlockItem) item).getFluidTank(itemStack);
            tank.ifPresent(n -> {
                TankRenderer.renderTank(poseStack, multiBufferSource, n, i, i1);
            });
        }
    }
}
