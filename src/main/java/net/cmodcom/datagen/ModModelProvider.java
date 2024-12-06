package net.cmodcom.datagen;

import net.cmodcom.block.ModBlocks;
import net.cmodcom.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Steel_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STEEL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEP_STEEL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_Steel_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.STEEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_STEEL, Models.GENERATED);
    }
}
