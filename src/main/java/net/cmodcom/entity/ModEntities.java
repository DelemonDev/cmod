package net.cmodcom.entity;

import net.cmodcom.CMod;
import net.cmodcom.entity.custom.MedTankEntity;
import net.cmodcom.entity.custom.SkulkPetrificationStoneEntity;
import net.cmodcom.entity.custom.TankAmmoEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
        public static final EntityType<MedTankEntity> MEDTANK = Registry.register(Registries.ENTITY_TYPE, new Identifier(CMod.MOD_ID, "medtank"),
                FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MedTankEntity::new)
                        .dimensions(EntityDimensions.fixed(1f, 1f)).build());

        public static final EntityType<TankAmmoEntity> TANKAMMO = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(CMod.MOD_ID, "tankammo"),
                FabricEntityTypeBuilder.<TankAmmoEntity>create(SpawnGroup.MISC, TankAmmoEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                        .trackRangeBlocks(4).trackedUpdateRate(10)
                        .build()
        );

        public static final EntityType<SkulkPetrificationStoneEntity> SKULK_PETRIFICATION_STONE_ENTITY = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(CMod.MOD_ID, "skulk_petrification_stone"),
                FabricEntityTypeBuilder.<SkulkPetrificationStoneEntity>create(SpawnGroup.MISC, SkulkPetrificationStoneEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build()
        );

}