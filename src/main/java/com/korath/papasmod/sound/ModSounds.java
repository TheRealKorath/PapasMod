package com.korath.papasmod.sound;

import com.korath.papasmod.PapasMod;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, PapasMod.MOD_ID);

    public static final RegistryObject<SoundEvent> HEAL_ORB_FIRED =
            registerSoundEvent("heal_orb_fired");

    public static final RegistryObject<SoundEvent> HEAL_ORB_HIT =
            registerSoundEvent("heal_orb_hit");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name)
    {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(PapasMod.MOD_ID, name)));
    }
    public static void register(IEventBus bus)
    {
        SOUND_EVENTS.register(bus);
    }
}
