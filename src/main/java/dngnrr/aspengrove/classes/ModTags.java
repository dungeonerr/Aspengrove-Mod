package dngnrr.aspengrove.classes;

import dngnrr.aspengrove.Aspengrove;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static void setup() {
        Blocks.setup();
        Items.setup();
    }

    public static void initialize() {
    }

    public static class Blocks {
        private static void setup() {
        }

        public static final TagKey<Block> ASPEN_LOGS = create(Identifier.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspen_logs"));

        public static TagKey<Block> create(Identifier name) {
            return TagKey.create(Registries.BLOCK, name);
        }
    }

    public static class Items {
        private static void setup() {
        }

        public static final TagKey<Item> ASPEN_LOGS = create(Identifier.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspen_logs"));

        public static TagKey<Item> create(Identifier name) {
            return TagKey.create(Registries.ITEM, name);
        }
    }
}