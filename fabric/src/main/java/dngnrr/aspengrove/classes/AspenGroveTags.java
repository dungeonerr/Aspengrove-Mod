package dngnrr.aspengrove.classes;

import dngnrr.aspengrove.AspenGrove;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class AspenGroveTags {

    public static class Blocks {
        public static final TagKey<Block> ASPEN_LOGS = create(ResourceLocation.fromNamespaceAndPath(AspenGrove.MOD_ID, "aspen_logs"));

        public static TagKey<Block> create(ResourceLocation name) {
            return TagKey.create(Registries.BLOCK, name);
        }

        private static void setup() {
        }
    }

    public static class Items {
        public static final TagKey<Item> ASPEN_LOGS = create(ResourceLocation.fromNamespaceAndPath(AspenGrove.MOD_ID, "aspen_logs"));

        public static TagKey<Item> create(ResourceLocation name) {
            return TagKey.create(Registries.ITEM, name);
        }

        private static void setup() {
        }
    }

    public static void initialize() {
        Blocks.setup();
        Items.setup();
    }
}