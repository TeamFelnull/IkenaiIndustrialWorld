package red.felnull.iiw.client.item;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import red.felnull.iiw.block.propertie.TubeConnectionState;
import red.felnull.iiw.client.blockentity.FluidPipeRenderer;
import red.felnull.otyacraftengine.client.renderer.item.ICustomBEWLRenderer;

public class FluidPipeItemRenderer implements ICustomBEWLRenderer {
    @Override
    public void renderByItem(ItemStack itemStack, ItemTransforms.TransformType transformType, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1) {
        FluidPipeRenderer.renderPipe(Direction.Axis.Y, TubeConnectionState.NONE, TubeConnectionState.NONE, TubeConnectionState.NONE, TubeConnectionState.NONE, TubeConnectionState.CONNECT, TubeConnectionState.CONNECT, poseStack, multiBufferSource, i, i1);
    }
}
