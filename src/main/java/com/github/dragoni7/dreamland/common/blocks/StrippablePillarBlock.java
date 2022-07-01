package com.github.dragoni7.dreamland.common.blocks;

import java.util.function.Supplier;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

public class StrippablePillarBlock extends RotatedPillarBlock {
	
	private BlockState stripped = null;

	public StrippablePillarBlock(Properties properties, Supplier<? extends Block> strippedBlock) {
		super(properties);
		stripped = strippedBlock.get().defaultBlockState();
	}
	
	@Override
	public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate)
    {
        ItemStack itemStack = context.getItemInHand();
        
        if (!itemStack.canPerformAction(toolAction))
            return null;

        if (ToolActions.AXE_STRIP == toolAction)
        {
            return stripped.setValue(RotatedPillarBlock.AXIS, state.getValue(AXIS));
        }
        
        return null;
    }
}
