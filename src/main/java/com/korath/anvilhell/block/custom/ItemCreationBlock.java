package com.korath.anvilhell.block.custom;

import com.google.common.collect.Lists;
import com.korath.anvilhell.AnvilHell;
import com.korath.anvilhell.block.ModBlocks;
import com.korath.anvilhell.blockentities.ItemCreationBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ItemCreationBlock extends Block implements EntityBlock {

    public static final BooleanProperty ENABLED = BooleanProperty.create("enabled");
    public static final IntegerProperty COOLDOWN = IntegerProperty.create("cooldown",0, 6000);
    private int ticksToWait = 20;
    public ItemCreationBlock(Properties properties) {

        super(properties);


    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity)
    {

        if(!level.isClientSide() && state.getValue(ENABLED).booleanValue() && entity instanceof Player player)
        {
            level.setBlock(pos, state.cycle(ENABLED), 3);
            player.addItem(new ItemStack(getRandomItem(), 1));
            player.sendSystemMessage(Component.literal("create something"));


        }
    }




    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(ENABLED);
    }
    private Item getRandomItem()
    {
        List<Item> items = Lists.newArrayList(ForgeRegistries.ITEMS.getValues());
        int itemCount = items.size();

        int index = RandomSource.createNewThreadLocalInstance().nextInt(itemCount);

        return items.get(index);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return ModBlocks.ITEM_CREATOR.get().create(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide() ? null : (pLevel, pos, pState, blockEntity) -> {
            if(blockEntity instanceof ItemCreationBlockEntity entity)
                entity.tick(pLevel, pos, pState);
        };
    }
}
