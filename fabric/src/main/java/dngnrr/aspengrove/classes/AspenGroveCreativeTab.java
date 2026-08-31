package dngnrr.aspengrove.classes;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;

import net.minecraft.world.item.*;

public class AspenGroveCreativeTab {
    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> {
            entries.insertAfter(Items.BIRCH_BUTTON,
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

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entries -> {
            entries.insertAfter(Items.BIRCH_LOG,
                    AspenGroveBlocks.ASPEN_LOG
            );
            entries.insertAfter(Items.BIRCH_LEAVES,
                    AspenGroveBlocks.ASPEN_LEAVES
            );
            entries.insertAfter(Items.RED_MUSHROOM_BLOCK,
                    AspenGroveBlocks.ORANGE_MUSHROOM_BLOCK
            );
            entries.insertAfter(Items.BIRCH_SAPLING,
                    AspenGroveBlocks.ASPEN_SAPLING
            );
            entries.insertAfter(Items.RED_MUSHROOM,
                    AspenGroveBlocks.ORANGE_MUSHROOM
            );
            entries.insertAfter(Items.POPPY,
                    AspenGroveBlocks.HONEYFLOWER
            );
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> {
            entries.insertAfter(Items.BIRCH_HANGING_SIGN,
                    AspenGroveBlocks.ASPEN_SIGN_ITEM,
                    AspenGroveBlocks.ASPEN_HANGING_SIGN_ITEM
            );
            entries.insertAfter(Items.BIRCH_SHELF,
                    AspenGroveBlocks.ASPEN_SHELF
            );
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> {
            entries.insertAfter(Items.BONE_MEAL,
                    AspenGroveItems.BOUQUET
            );
            entries.insertAfter(Items.BIRCH_CHEST_BOAT,
                    AspenGroveItems.ASPEN_BOAT,
                    AspenGroveItems.ASPEN_CHEST_BOAT
            );
        });
    }
}