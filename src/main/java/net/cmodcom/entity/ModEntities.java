package net.cmodcom.entity;

import net.cmodcom.CMod;
import net.cmodcom.entity.custom.MedTankEntity;
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
}
