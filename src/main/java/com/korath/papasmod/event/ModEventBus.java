package com.korath.papasmod.event;

import com.korath.papasmod.PapasMod;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PapasMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBus {


    /*@SubscribeEvent
    public static void registerParticleFactory(final RegisterParticleProvidersEvent event)
    {
        //event.registerSpriteSet(ModParticles.HEALING_ORB_PARTICLES.get(), HealingOrbParticles.Provider::new);
    }*/
}
