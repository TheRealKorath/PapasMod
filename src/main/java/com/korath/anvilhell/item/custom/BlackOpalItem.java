package com.korath.anvilhell.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BlackOpalItem extends Item {


    public BlackOpalItem(Properties properties) {
        super(properties);
    }



    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND)
        {
            player.sendSystemMessage(Component.literal("A voice in your head says: Your lucky number is: " + getRandonNumber()));
            player.getCooldowns().addCooldown(this, 120);
        }
        return super.use(level, player, hand);
    }

    private int getRandonNumber()
    {
        return RandomSource.createNewThreadLocalInstance().nextInt(10);
    }
}
