package net.cmodcom.datagen;

import net.cmodcom.block.ModBlocks;
import net.cmodcom.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    private static final List<ItemConvertible> Steel_SMELTABLES = List.of(ModItems.RAW_STEEL, ModBlocks.STEEL_ORE, ModBlocks.DEEP_STEEL_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, Steel_SMELTABLES, RecipeCategory.MISC, ModItems.STEEL,
                0.7f, 200, "steel");
        offerBlasting(exporter, Steel_SMELTABLES, RecipeCategory.MISC, ModItems.STEEL,
                0.7f, 100, "steel");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.STEEL, RecipeCategory.DECORATIONS,
                ModBlocks.Steel_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_STEEL, RecipeCategory.DECORATIONS,
                ModBlocks.RAW_Steel_BLOCK);
    }
}
