package dngnrr.aspengrove.classes;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

public class AspenGroveCreativeTab {
    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> {
            entries.insertAfter(Items.BIRCH_BUTTON,
                    AspenGroveItems.ASPEN_LOG_ITEM,
                    AspenGroveItems.ASPEN_WOOD_ITEM,
                    AspenGroveItems.STRIPPED_ASPEN_LOG_ITEM,
                    AspenGroveItems.STRIPPED_ASPEN_WOOD_ITEM,
                    AspenGroveItems.ASPEN_PLANKS_ITEM,
                    AspenGroveItems.ASPEN_STAIRS_ITEM,
                    AspenGroveItems.ASPEN_SLAB_ITEM,
                    AspenGroveItems.ASPEN_FENCE_ITEM,
                    AspenGroveItems.ASPEN_FENCE_GATE_ITEM,
                    AspenGroveItems.ASPEN_DOOR_ITEM,
                    AspenGroveItems.ASPEN_TRAPDOOR_ITEM,
                    AspenGroveItems.ASPEN_PRESSURE_PLATE_ITEM,
                    AspenGroveItems.ASPEN_BUTTON_ITEM
            );
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entries -> {
            entries.insertAfter(Items.BIRCH_BUTTON,
                    AspenGroveItems.ASPEN_LOG_ITEM
            );
            entries.insertAfter(Items.BIRCH_LEAVES,
                    AspenGroveItems.ASPEN_LEAVES_ITEM
            );
            entries.insertAfter(Items.RED_MUSHROOM_BLOCK,
                    AspenGroveItems.ORANGE_MUSHROOM_BLOCK_ITEM
            );
            entries.insertAfter(Items.BIRCH_SAPLING,
                    AspenGroveItems.ASPEN_SAPLING_ITEM
            );
            entries.insertAfter(Items.RED_MUSHROOM,
                    AspenGroveItems.ORANGE_MUSHROOM_ITEM
            );
            entries.insertAfter(Items.POPPY,
                    AspenGroveItems.HONEYFLOWER_ITEM
            );
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> {
            entries.insertAfter(Items.BIRCH_HANGING_SIGN,
                    AspenGroveItems.ASPEN_SIGN_ITEM,
                    AspenGroveItems.ASPEN_HANGING_SIGN_ITEM
            );
            entries.insertAfter(Items.BIRCH_SHELF,
                    AspenGroveItems.ASPEN_SHELF_ITEM
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