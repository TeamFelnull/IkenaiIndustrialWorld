package red.felnull.epochnaruworld.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import red.felnull.epochnaruworld.blockentity.TankBlockEntity;
import red.felnull.otyacraftengine.client.renderer.blockentity.IkisugiBlockEntityRenderer;
import red.felnull.otyacraftengine.fluid.IkisugiFluidTank;

public class TankRenderer extends IkisugiBlockEntityRenderer<TankBlockEntity> {
    public TankRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(TankBlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        renderTank(poseStack, multiBufferSource, blockEntity.getTank(), i, j);
    }

    public static void renderTank(PoseStack poseStack, MultiBufferSource multiBufferSource, IkisugiFluidTank tank, int combinedLight, int combinedOverlay) {
        Minecraft.getInstance().getItemRenderer().renderStatic(new ItemStack(Items.APPLE), ItemTransforms.TransformType.FIXED, combinedLight, combinedOverlay, poseStack, multiBufferSource, 0);
    }
}
