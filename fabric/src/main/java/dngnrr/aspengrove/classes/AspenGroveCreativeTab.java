package dngnrr.aspengrove.classes;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import net.minecraft.world.item.*;

public class AspenGroveCreativeTab {
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> {
            entries.addAfter(Items.BIRCH_BUTTON,
                    AspenGroveBlocks.ASPEN_LOG,
                    AspenGroveBlocks.ASPEN_WOOD,
                    AspenGroveBlocks.STRIPPED_ASPEN_LOG,
                    AspenGroveBlocks.STRIPPED_ASPEN_WOOD,
                    AspenGroveBlocks.ASPEN_PLANKS,
                    AspenGroveBlocks.ASPEN_STAIRS,
                    AspenGroveBlocks.ASPEN_SLAB,
                    AspenGroveBlocks.ASPEN_FENCE,
                    AspenGroveBlocks.ASPEN_FENCE_GATE,
                    AspenGroveBlocks.ASPEN_DOOR,
                    AspenGroveBlocks.ASPEN_TRAPDOOR,
                    AspenGroveBlocks.ASPEN_PRESSURE_PLATE,
                    AspenGroveBlocks.ASPEN_BUTTON
            );
        });

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entries -> {
            entries.addAfter(Items.BIRCH_LOG,
                    AspenGroveBlocks.ASPEN_LOG
            );
            entries.addAfter(Items.BIRCH_LEAVES,
                    AspenGroveBlocks.ASPEN_LEAVES
            );
            entries.addAfter(Items.RED_MUSHROOM_BLOCK,
                    AspenGroveBlocks.ORANGE_MUSHROOM_BLOCK
            );
            entries.addAfter(Items.BIRCH_SAPLING,
                    AspenGroveBlocks.ASPEN_SAPLING
            );
            entries.addAfter(Items.RED_MUSHROOM,
                    AspenGroveBlocks.ORANGE_MUSHROOM
            );
            entries.addAfter(Items.POPPY,
                    AspenGroveBlocks.HONEYFLOWER
            );
        });

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> {
            entries.addAfter(Items.BIRCH_HANGING_SIGN,
                    AspenGroveBlocks.ASPEN_SIGN_ITEM,
                    AspenGroveBlocks.ASPEN_HANGING_SIGN_ITEM
            );
        });

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> {
            entries.addAfter(Items.BONE_MEAL,
                    AspenGroveItems.BOUQUET
            );
            entries.addAfter(Items.BIRCH_CHEST_BOAT,
                    AspenGroveItems.ASPEN_BOAT,
                    AspenGroveItems.ASPEN_CHEST_BOAT
            );
        });
    }
}