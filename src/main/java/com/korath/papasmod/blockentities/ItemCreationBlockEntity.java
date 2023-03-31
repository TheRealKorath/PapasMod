package com.korath.papasmod.blockentities;

import com.korath.papasmod.block.custom.ItemCreationBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ItemCreationBlockEntity extends BlockEntity {

   private int ticksToWait = 600;

    public ItemCreationBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ITEM_CREATOR.get(), pos, state);

    }


    public void tick(Level level, BlockPos pos, BlockState state)
    {
        if(!state.getValue(ItemCreationBlock.ENABLED).booleanValue())
        {
            if(ticksToWait<=0)
            {
                level.setBlock(pos, state.cycle(ItemCreationBlock.ENABLED), 3);

            }
            else
                ticksToWait--;
        }
        else
        {
            ticksToWait=600;
        }
    }


}
