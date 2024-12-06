package net.cmodcom.datagen;


import net.cmodcom.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.Steel_BLOCK)
                .add(ModBlocks.RAW_Steel_BLOCK)
                .add(ModBlocks.STEEL_ORE)
                .add(ModBlocks.DEEP_STEEL_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.Steel_BLOCK)
                .add(ModBlocks.RAW_Steel_BLOCK)
                .add(ModBlocks.STEEL_ORE)
                .add(ModBlocks.DEEP_STEEL_ORE);
    }
}
