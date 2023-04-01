package com.korath.papasmod.item.custom;

import com.korath.papasmod.itementities.ModItemEntities;
import com.korath.papasmod.itementities.custom.HealOrbEntity;
import com.korath.papasmod.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
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
        ItemStack itemstack = player.getItemInHand(hand);
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND)
        {
            HealOrbEntity healOrb = new HealOrbEntity(ModItemEntities.HEAL_ORB.get(), player, level);
            healOrb.setDeltaMovement(player.getForward());
            level.addFreshEntity(healOrb);
            itemstack.shrink(1);
            healOrb.playSound(ModSounds.HEAL_ORB_FIRED.get());
            //level.playSound(null, healOrb.getX(), healOrb.getY(), healOrb.getZ(),ModSounds.HEAL_ORB_FIRED.get(), SoundSource.PLAYERS,1f,1f );
            player.getCooldowns().addCooldown(this, 20);

            return InteractionResultHolder.consume(itemstack);
        }
        return InteractionResultHolder.pass(player.getItemInHand(hand));

    }

    private int getRandonNumber()
    {
        return RandomSource.createNewThreadLocalInstance().nextInt(10);
    }
}
