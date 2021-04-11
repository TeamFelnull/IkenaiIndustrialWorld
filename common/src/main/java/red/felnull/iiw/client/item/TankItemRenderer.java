package red.felnull.iiw.client.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import red.felnull.iiw.client.blockentity.TankRenderer;
import red.felnull.iiw.item.TankBlockItem;
import red.felnull.otyacraftengine.client.renderer.item.ICustomBEWLRenderer;
import red.felnull.otyacraftengine.client.util.IKSGRenderUtil;
import red.felnull.otyacraftengine.fluid.storage.FluidTank;

import java.util.Optional;

public class TankItemRenderer implements ICustomBEWLRenderer {
    @Override
    public void renderByItem(ItemStack itemStack, ItemTransforms.TransformType transformType, PoseStack poseStack, MultiBufferSource multiBufferSource, int combinedLight, int combinedOverlay) {
        Item item = itemStack.getItem();

        if (item instanceof TankBlockItem) {
            BakedModel model = IKSGRenderUtil.getBakedModel(new ResourceLocation(((TankBlockItem) item).getRegistryName().getNamespace(), "block/tank/" + ((TankBlockItem) item).getRegistryName().getPath()));
            VertexConsumer ivb = multiBufferSource.getBuffer(Sheets.cutoutBlockSheet());
            IKSGRenderUtil.renderBakedModel(poseStack, ivb, null, model, combinedLight, combinedOverlay);
            try {
                Optional<FluidTank> tank = ((TankBlockItem) item).getFluidTank(itemStack);
                Minecraft mc = Minecraft.getInstance();
                tank.ifPresent(n -> TankRenderer.renderTank(mc.level, mc.player.blockPosition(), poseStack, multiBufferSource, n, combinedLight, combinedOverlay));
            } catch (Exception ignored) {

            }
        }

    }
}
