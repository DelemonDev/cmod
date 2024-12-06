package net.cmodcom.util;

import net.cmodcom.CMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> EXAMPLE_TAG = createTag();

        private static TagKey<Block> createTag() {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(CMod.MOD_ID, "example_tag"));
        }
    }

    public static class Items {
        public static final TagKey<Item> EXAMPLE_TAG = createTag();

        private static TagKey<Item> createTag() {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(CMod.MOD_ID, "example_tag"));
        }
    }
}