package com.korath.papasmod.item.custom;

import com.korath.papasmod.itementities.ModItemEntities;
import com.korath.papasmod.itementities.custom.HealOrbEntity;
import com.korath.papasmod.sound.ModSounds;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HealingGemItem extends Item {


    public HealingGemItem(Properties properties) {
        super(properties);
    }



    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        ItemStack itemStack = player.getItemInHand(hand);
        if(!level.isClientSide())
        {
            if(hand == InteractionHand.OFF_HAND || player.isCrouching())
            {
                healSelf(player, level, itemStack);
            }
            else {
                HealOrbEntity healOrb = new HealOrbEntity(ModItemEntities.HEAL_ORB.get(), player, level);
                healOrb.setDeltaMovement(player.getForward());
                level.addFreshEntity(healOrb);
                itemStack.shrink(1);
                healOrb.playSound(ModSounds.HEAL_ORB_FIRED.get());
                player.getCooldowns().addCooldown(this, 40);
            }

            return InteractionResultHolder.consume(itemStack);
        }
        return InteractionResultHolder.pass(player.getItemInHand(hand));

    }

    private void healSelf(Player player, Level level,ItemStack itemStack)
    {
        player.heal(4f);
        level.playSound(null, player.blockPosition(), ModSounds.HEAL_ORB_HIT.get(), SoundSource.PLAYERS);
        itemStack.shrink(1);
        player.getCooldowns().addCooldown(this, 40);
        HealOrbEntity.spawnHealingParticles( player.blockPosition(), (ServerLevel)level);
    }


}
