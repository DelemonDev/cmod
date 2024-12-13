package net.cmodcom.item;

import net.cmodcom.CMod;
import net.cmodcom.entity.ModEntities;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
    public static final Item STEEL = registerItem("steel", new Item(new FabricItemSettings()));
    public static final Item RAW_STEEL = registerItem("raw_steel", new Item(new FabricItemSettings()));
    public static final Item TIRE = registerItem("tire", new Item(new FabricItemSettings()));
    public static final Item CANNONSHOOT = registerItem("cannonshoot", new Item(new FabricItemSettings()));
    public static final Item TANKHEAD = registerItem("tankhead", new Item(new FabricItemSettings()));
    public static final Item TANKBODY = registerItem("tankbody", new Item(new FabricItemSettings()));
    public static final Item TANKAMMO = registerItem("tank_ammo", new Item(new FabricItemSettings()));
    public static final Item MEDTANK = registerItem("medtank", new Item(new FabricItemSettings()));
    public static final Item MEDTANK_SPAWN_EGG = Registry.register(
            Registries.ITEM,
            new Identifier(CMod.MOD_ID, "medtank_spawn_egg"),
            new SpawnEggItem(ModEntities.MEDTANK, 0x000000, 0xFFFFFF, new FabricItemSettings())
    );


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(STEEL);
        entries.add(RAW_STEEL);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(CMod.MOD_ID, name ), item);
    }
    public static void registerModItems()
    {
        CMod.LOGGER.info("Register Items" + CMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }

}
