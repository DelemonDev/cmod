package net.cmodcom.datagen;

import net.cmodcom.block.ModBlocks;
import net.cmodcom.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    private static final List<ItemConvertible> Steel_SMELTABLES = List.of(ModItems.RAW_STEEL, ModBlocks.STEEL_ORE, ModBlocks.DEEP_STEEL_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TIRE, 1)
                .pattern("SSS")
                .pattern("STS")
                .pattern("SSS")
                .input('S', Items.DRIED_KELP)
                .input('T', ModItems.STEEL)
                .criterion(hasItem(Items.DRIED_KELP), conditionsFromItem(Items.DRIED_KELP))
                .criterion(hasItem(ModItems.STEEL), conditionsFromItem(ModItems.STEEL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TIRE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CANNONSHOOT, 1)
                .pattern("   ")
                .pattern("SSS")
                .pattern("   ")
                .input('S', ModItems.STEEL)
                .criterion(hasItem(ModItems.STEEL), conditionsFromItem(ModItems.STEEL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CANNONSHOOT)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TANKBODY, 1)
                .pattern(" S ")
                .pattern("SSS")
                .pattern("   ")
                .input('S', ModItems.STEEL)
                .criterion(hasItem(ModItems.STEEL), conditionsFromItem(ModItems.STEEL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TANKBODY)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TANKHEAD, 1)
                .pattern("   ")
                .pattern("SSC")
                .pattern("   ")
                .input('S', ModItems.STEEL)
                .input('C', ModItems.CANNONSHOOT)
                .criterion(hasItem(ModItems.STEEL), conditionsFromItem(ModItems.STEEL))
                .criterion(hasItem(ModItems.CANNONSHOOT), conditionsFromItem(ModItems.CANNONSHOOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TANKHEAD)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TANKAMMO, 3)
                .pattern(" S ")
                .pattern(" C ")
                .pattern(" G ")
                .input('S', ModItems.STEEL)
                .input('C', Items.GOLD_INGOT)
                .input('G', Items.GUNPOWDER)
                .criterion(hasItem(ModItems.STEEL), conditionsFromItem(ModItems.STEEL))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TANKAMMO)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MEDTANK_SPAWN_EGG, 1)
                .pattern(" C ")
                .pattern(" S ")
                .pattern("GGG")
                .input('S', ModItems.TANKBODY)
                .input('C', ModItems.TANKHEAD)
                .input('G', ModItems.TIRE)
                .criterion(hasItem(ModItems.TANKBODY), conditionsFromItem(ModItems.TANKBODY))
                .criterion(hasItem(ModItems.TANKHEAD), conditionsFromItem(ModItems.TANKHEAD))
                .criterion(hasItem(ModItems.TIRE), conditionsFromItem(ModItems.TIRE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.MEDTANK_SPAWN_EGG)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CUSTOM_BUNDLE, 1)
                .pattern(" SS")
                .pattern("LSS")
                .pattern(" SS")
                .input('S', Items.LEATHER)
                .input('L', Items.STRING)
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CUSTOM_BUNDLE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SKULK_PETRIFICATION_STONE, 4)
                .pattern("SSS")
                .pattern("SLS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('L', Items.SCULK)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SKULK_PETRIFICATION_STONE)));

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
