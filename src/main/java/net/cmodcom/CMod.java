package net.cmodcom;

import net.cmodcom.block.ModBlocks;
import net.cmodcom.entity.ModEntities;
import net.cmodcom.entity.custom.MedTankEntity;
import net.cmodcom.item.ModItemGroups;
import net.cmodcom.item.ModItems;
import net.cmodcom.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CMod implements ModInitializer {
	public static final String MOD_ID = "chmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");
		FabricDefaultAttributeRegistry.register(ModEntities.MEDTANK, MedTankEntity.createMobAttributes());
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModWorldGeneration.generateModWorldGen();
	}
}