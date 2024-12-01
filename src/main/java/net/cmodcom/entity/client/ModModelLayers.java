package net.cmodcom.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.cmodcom.CMod;

public class ModModelLayers {
    public static final EntityModelLayer MEDTANK =
            new EntityModelLayer(new Identifier(CMod.MOD_ID,"medtank"), "main");
}
