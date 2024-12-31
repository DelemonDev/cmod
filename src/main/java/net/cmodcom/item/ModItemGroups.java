package net.cmodcom.item;

import net.cmodcom.CMod;
import net.cmodcom.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup Tank_Group = Registry.register(Registries.ITEM_GROUP,
            new Identifier(CMod.MOD_ID, "steel"),
            FabricItemGroup.builder().displayName(Text.translatable("Tank Materials"))
                    .icon(() -> new ItemStack(ModItems.STEEL)).entries((displayContext, entries) -> {
                        entries.add(ModItems.STEEL);
                        entries.add(ModItems.RAW_STEEL);
                        entries.add(ModItems.TANKHEAD);
                        entries.add(ModItems.TANKBODY);
                        entries.add(ModItems.CANNONSHOOT);
                        entries.add(ModItems.TIRE);
                        entries.add(ModItems.TANKAMMO);
                        entries.add(ModBlocks.Steel_BLOCK);
                        entries.add(ModBlocks.RAW_Steel_BLOCK);
                        entries.add(ModBlocks.DEEP_STEEL_ORE);
                        entries.add(ModBlocks.STEEL_ORE);
                        entries.add(ModItems.MEDTANK_SPAWN_EGG);
                        entries.add(ModItems.SKULK_PETRIFICATION_STONE);
                        entries.add(ModItems.CUSTOM_BUNDLE);

                    }).build());
    public static void registerItemGroups(){
        CMod.LOGGER.info("Registering Item Groups for " + CMod.MOD_ID);
    }
}
