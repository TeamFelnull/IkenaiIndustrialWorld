package red.felnull.iiw.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;
import red.felnull.iiw.block.TankBlock;
import red.felnull.otyacraftengine.fluid.storage.FluidTank;
import red.felnull.otyacraftengine.item.IkisugiBlockItem;
import red.felnull.otyacraftengine.item.storage.IContainerFluidTankItem;

import java.util.List;
import java.util.Optional;

public class TankBlockItem extends IkisugiBlockItem implements IContainerFluidTankItem {
    private final int tierLevel;

    public TankBlockItem(Block block, int tierLevel, Item.Properties properties) {
        super(block, properties);
        this.tierLevel = tierLevel;
    }

    public int getTierLevel() {
        return tierLevel;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        Optional<FluidTank> tank = getFluidTank(itemStack);
        tank.ifPresent(n -> {
            list.add(new TextComponent("Fluid :").append(n.getFluidStack().getName()).append(" - " + n.getAmount() + "/" + n.getCapacity()).withStyle(ChatFormatting.GRAY));
        });
    }

    @Override
    public int getPriorityFluidTankNumber() {
        return 0;
    }

    @Override
    public int getFluidTankCont() {
        return 1;
    }

    @Override
    public ItemStack getEmptyFluidTankItem() {
        return new ItemStack(this);
    }

    @Override
    public int getCapacity(ItemStack itemStack) {
        return TankBlock.getTankCapacity(getTierLevel());
    }
}
