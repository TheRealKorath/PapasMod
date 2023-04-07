package com.korath.papasmod.item;

import com.korath.papasmod.PapasMod;
import com.korath.papasmod.item.custom.HealingGemItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PapasMod.MOD_ID);

    public static final RegistryObject<Item> JADE = ITEMS.register("jade",
            () -> new HealingGemItem(new Item.Properties()));

    public static final RegistryObject<Item> RAW_JADE = ITEMS.register("raw_jade",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus bus)
    {
        ITEMS.register(bus);
    }
}
