package com.korath.papasmod.blockentities;

import com.korath.papasmod.PapasMod;
import com.korath.papasmod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PapasMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<ItemCreationBlockEntity>> ITEM_CREATOR = BLOCK_ENTITIES.register("item_creator",
            () -> BlockEntityType.Builder.of(ItemCreationBlockEntity::new, ModBlocks.BLACK_OPAL_BLOCK.get()).build(null));

    public static void register(IEventBus bus)
    {
        BLOCK_ENTITIES.register(bus);
    }
}
