package com.korath.papasmod.itementities;

import com.korath.papasmod.PapasMod;
import com.korath.papasmod.itementities.custom.HealOrbEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemEntities {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PapasMod.MOD_ID);

    public static final RegistryObject<EntityType<HealOrbEntity>> HEAL_ORB = ENTITY_TYPES.register("heal_orb",
            () -> EntityType.Builder.of((EntityType.EntityFactory<HealOrbEntity>) HealOrbEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).build("heal_orb"));

    public static void register(IEventBus bus)
    {
        ENTITY_TYPES.register(bus);
    }
}
