package red.felnull.iiw.client.blockentity;

import com.mojang.blaze3d.systems.RenderSystem;
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
import red.felnull.iiw.block.propertie.TubeConnectionState;
import red.felnull.iiw.blockentity.FluidPipeEntity;
import red.felnull.otyacraftengine.client.renderer.blockentity.IkisugiBlockEntityRenderer;
import red.felnull.otyacraftengine.client.util.IKSGRenderUtil;

public class FluidPipeRenderer extends IkisugiBlockEntityRenderer<FluidPipeEntity> {
    private static final ResourceLocation FITTINGS = new ResourceLocation(IkenaiIndustrialWorld.MODID, "block/pipe/pipe_fittings");
    private static final ResourceLocation CONNECT = new ResourceLocation(IkenaiIndustrialWorld.MODID, "block/pipe/pipe_connect");


    public FluidPipeRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(FluidPipeEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        BlockState state = blockEntity.getBlockState();
        renderPipe(state.getValue(IIWTubeBaseBlock.AXIS), state.getValue(IIWTubeBaseBlock.NORTH), state.getValue(IIWTubeBaseBlock.EAST), state.getValue(IIWTubeBaseBlock.SOUTH), state.getValue(IIWTubeBaseBlock.WEST), state.getValue(IIWTubeBaseBlock.UP), state.getValue(IIWTubeBaseBlock.DOWN), poseStack, multiBufferSource, i, j);
    }

    public static void renderPipe(Direction.Axis axis, TubeConnectionState north, TubeConnectionState east, TubeConnectionState south, TubeConnectionState west, TubeConnectionState up, TubeConnectionState down, PoseStack poseStack, MultiBufferSource multiBufferSource, int combinedLight, int combinedOverlay) {
        VertexConsumer ivb = multiBufferSource.getBuffer(Sheets.cutoutBlockSheet());

        BakedModel fittings = IKSGRenderUtil.getBakedModel(FITTINGS);

        poseStack.pushPose();

        for (Direction direction : Direction.values()) {
            poseStack.pushPose();
            BakedModel pi = null;

            poseStack.translate(0.5D, 0.5D, 0.5D);
            if (direction == Direction.NORTH) {
                IKSGRenderUtil.matrixRotateDegreefX(poseStack, -90);
                pi = getModeByState(north);
            } else if (direction == Direction.SOUTH) {
                IKSGRenderUtil.matrixRotateDegreefX(poseStack, 90);
                pi = getModeByState(south);
            } else if (direction == Direction.EAST) {
                IKSGRenderUtil.matrixRotateDegreefZ(poseStack, -90);
                pi = getModeByState(east);
            } else if (direction == Direction.WEST) {
                IKSGRenderUtil.matrixRotateDegreefZ(poseStack, 90);
                pi = getModeByState(west);
            } else if (direction == Direction.DOWN) {
                IKSGRenderUtil.matrixRotateDegreefX(poseStack, 180);
                pi = getModeByState(down);
            } else if (direction == Direction.UP) {
                pi = getModeByState(up);
            }
            poseStack.translate(-0.5D, -0.5D, -0.5D);

            if (pi != null)
                IKSGRenderUtil.renderBakedModel(poseStack, ivb, null, pi, combinedLight, combinedOverlay);

            poseStack.popPose();
        }


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
        poseStack.popPose();

        poseStack.popPose();

    }

    public static BakedModel getModeByState(TubeConnectionState state) {
        if (state != TubeConnectionState.NONE)
            return IKSGRenderUtil.getBakedModel(CONNECT);

        return null;
    }

}
