package dngnrr.aspengrove.classes;

import dngnrr.aspengrove.Aspengrove;
import net.minecraft.resources. ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tagkey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            public static final TagKey<Block> ASPEN_LOGS = createTag(name: "aspen_logs");
            return BlockTags.create(ResourceLocation.fromNamescapeAndPath(Aspengrove.MOD_ID, name));
        }
    }
}