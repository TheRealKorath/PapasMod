package com.korath.papasmod.particle;

import com.korath.papasmod.PapasMod;
import com.korath.papasmod.particle.custom.HealingOrbParticles;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, PapasMod.MOD_ID);

    public static final RegistryObject<ParticleType<SimpleParticleType>> HEALING_ORB_PARTICLES =
            PARTICLE_TYPES.register("healing_orb_particles", () -> new SimpleParticleType(true));
    public static void register(IEventBus bus)
    {
        PARTICLE_TYPES.register(bus);
    }
}
