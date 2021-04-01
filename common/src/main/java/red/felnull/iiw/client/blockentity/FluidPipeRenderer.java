package red.felnull.iiw.client.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import red.felnull.iiw.IkenaiIndustrialWorld;
import red.felnull.iiw.block.IIWTubeBaseBlock;
import red.felnull.iiw.blockentity.FluidPipeEntity;
import red.felnull.otyacraftengine.client.renderer.blockentity.IkisugiBlockEntityRenderer;
import red.felnull.otyacraftengine.client.util.IKSGRenderUtil;

public class FluidPipeRenderer extends IkisugiBlockEntityRenderer<FluidPipeEntity> {
    public FluidPipeRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(FluidPipeEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        BlockState state = blockEntity.getBlockState();
        renderPipe(state.getValue(IIWTubeBaseBlock.AXIS), poseStack, multiBufferSource, i, j);
    }

    public static void renderPipe(Direction.Axis axis, PoseStack poseStack, MultiBufferSource multiBufferSource, int combinedLight, int combinedOverlay) {
        VertexConsumer ivb = multiBufferSource.getBuffer(Sheets.cutoutBlockSheet());

        BakedModel fittings = IKSGRenderUtil.getBakedModel(new ResourceLocation(IkenaiIndustrialWorld.MODID, "block/pipe/pipe_fittings"));
        BakedModel y = IKSGRenderUtil.getBakedModel(new ResourceLocation(IkenaiIndustrialWorld.MODID, "block/pipe/pipe_y"));

        poseStack.pushPose();

        poseStack.translate(0.5D, 0.5D, 0.5D);
        switch (axis) {
            case X:
                IKSGRenderUtil.matrixRotateDegreefZ(poseStack, 90);
                break;
            case Z:
                IKSGRenderUtil.matrixRotateDegreefX(poseStack, 90);
                break;
        }
        poseStack.translate(-0.5D, -0.5D, -0.5D);

        IKSGRenderUtil.renderBakedModel(poseStack, ivb, null, fittings, combinedLight, combinedOverlay);
        IKSGRenderUtil.renderBakedModel(poseStack, ivb, null, y, combinedLight, combinedOverlay);

        poseStack.popPose();

    }

}
