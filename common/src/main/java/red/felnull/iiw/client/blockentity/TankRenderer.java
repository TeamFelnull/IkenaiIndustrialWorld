package red.felnull.iiw.client.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import me.shedaniel.architectury.fluid.FluidStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import red.felnull.iiw.blockentity.TankBlockEntity;
import red.felnull.otyacraftengine.client.renderer.blockentity.IkisugiBlockEntityRenderer;
import red.felnull.otyacraftengine.client.util.IKSGRenderUtil;
import red.felnull.otyacraftengine.fluid.storage.FluidTank;

public class TankRenderer extends IkisugiBlockEntityRenderer<TankBlockEntity> {

    public TankRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(TankBlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        renderTank(blockEntity.getLevel(), blockEntity.getBlockPos(), poseStack, multiBufferSource, blockEntity.getFluidTank(0), i, j);
    }

    public static void renderTank(BlockAndTintGetter getter, BlockPos pos, PoseStack poseStack, MultiBufferSource multiBufferSource, FluidTank tank, int combinedLight, int combinedOverlay) {
        if (tank.isEmpty())
            return;
        FluidStack fluidStack = tank.getFluidStack();
        float pix = 1f / 16f;
        IKSGRenderUtil.renderFluid(fluidStack.getFluid(), getter, pos, poseStack, multiBufferSource, (double) tank.getAmount() / (double) tank.getCapacity(), pix * 3, pix * 1, pix * 3, pix * 10, pix * 14, combinedLight, combinedOverlay);
    }
}
