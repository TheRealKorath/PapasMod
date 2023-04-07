package com.korath.papasmod.datagen;


import com.korath.papasmod.PapasMod;
import com.korath.papasmod.block.ModBlocks;
import com.korath.papasmod.block.custom.ItemCreationBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PapasMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //blockWithItem(ModBlocks.BLACK_OPAL_BLOCK);
        ModelFile blackOpalBlockLit = models().cubeAll("block/black_opal_block", modLoc("block/black_opal_block"));
        ModelFile blackOpalBlockUnlit = models().cubeAll("block/black_opal_block_unlit", modLoc("block/black_opal_block_unlit"));
        var builder = getVariantBuilder(ModBlocks.BLACK_OPAL_BLOCK.get());
        builder
                .partialState()
                    .with(ItemCreationBlock.ENABLED, true)
                    .modelForState().modelFile(blackOpalBlockLit)
                    .addModel()
                .partialState()
                    .with(ItemCreationBlock.ENABLED, false)
                    .modelForState().modelFile(blackOpalBlockUnlit)
                    .addModel();
        simpleBlockItem(ModBlocks.BLACK_OPAL_BLOCK.get(), blackOpalBlockLit);

        blockWithItem(ModBlocks.JADE_ORE);
        blockWithItem(ModBlocks.JADE_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}