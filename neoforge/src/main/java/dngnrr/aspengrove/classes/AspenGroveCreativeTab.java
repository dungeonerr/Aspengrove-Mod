package dngnrr.aspengrove.classes;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraft.world.item.*;

@EventBusSubscriber
public class AspenGroveCreativeTab {

    @SubscribeEvent
    public static void onBuildCreativeModeTabContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.insertAfter(
                    Items.BIRCH_BUTTON.getDefaultInstance(),
                    AspenGroveBlocks.ASPEN_LOG.asItem().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    AspenGroveBlocks.ASPEN_LOG.asItem().getDefaultInstance(),
                    AspenGroveBlocks.ASPEN_WOOD.asItem().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    AspenGroveBlocks.ASPEN_WOOD.asItem().getDefaultInstance(),
                    AspenGroveBlocks.STRIPPED_ASPEN_LOG.asItem().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    AspenGroveBlocks.STRIPPED_ASPEN_LOG.asItem().getDefaultInstance(),
                    AspenGroveBlocks.STRIPPED_ASPEN_WOOD.asItem().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    AspenGroveBlocks.STRIPPED_ASPEN_WOOD.asItem().getDefaultInstance(),
                    AspenGroveBlocks.ASPEN_PLANKS.asItem().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    AspenGroveBlocks.ASPEN_PLANKS.asItem().getDefaultInstance(),
                    AspenGroveBlocks.ASPEN_STAIRS.asItem().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    AspenGroveBlocks.ASPEN_STAIRS.asItem().getDefaultInstance(),
                    AspenGroveBlocks.ASPEN_SLAB.asItem().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    AspenGroveBlocks.ASPEN_SLAB.asItem().getDefaultInstance(),
                    AspenGroveBlocks.ASPEN_FENCE.asItem().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    AspenGroveBlocks.ASPEN_FENCE.asItem().getDefaultInstance(),
                    AspenGroveBlocks.ASPEN_FENCE_GATE.asItem().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    AspenGroveBlocks.ASPEN_FENCE_GATE.asItem().getDefaultInstance(),
                    AspenGroveBlocks.ASPEN_DOOR.asItem().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    AspenGroveBlocks.ASPEN_DOOR.asItem().getDefaultInstance(),
                    AspenGroveBlocks.ASPEN_TRAPDOOR.asItem().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    AspenGroveBlocks.ASPEN_TRAPDOOR.asItem().getDefaultInstance(),
                    AspenGroveBlocks.ASPEN_PRESSURE_PLATE.asItem().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    AspenGroveBlocks.ASPEN_PRESSURE_PLATE.asItem().getDefaultInstance(),
                    AspenGroveBlocks.ASPEN_BUTTON.asItem().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
        }

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.insertAfter(
                    Items.BIRCH_LOG.getDefaultInstance(),
                    AspenGroveBlocks.ASPEN_LOG.asItem().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    Items.BIRCH_LEAVES.getDefaultInstance(),
                    AspenGroveBlocks.ASPEN_LEAVES.asItem().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    Items.RED_MUSHROOM_BLOCK.getDefaultInstance(),
                    AspenGroveBlocks.ORANGE_MUSHROOM_BLOCK.asItem().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    Items.BIRCH_SAPLING.getDefaultInstance(),
                    AspenGroveBlocks.ASPEN_SAPLING.asItem().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    Items.RED_MUSHROOM.getDefaultInstance(),
                    AspenGroveBlocks.ORANGE_MUSHROOM.asItem().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    Items.POPPY.getDefaultInstance(),
                    AspenGroveBlocks.HONEYFLOWER.asItem().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
        }

        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.insertAfter(
                    Items.BIRCH_HANGING_SIGN.getDefaultInstance(),
                    AspenGroveBlocks.ASPEN_SIGN_ITEM.getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    AspenGroveBlocks.ASPEN_SIGN_ITEM.getDefaultInstance(),
                    AspenGroveBlocks.ASPEN_HANGING_SIGN_ITEM.getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
        }

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.insertAfter(
                    Items.BONE_MEAL.getDefaultInstance(),
                    AspenGroveItems.BOUQUET.getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    Items.BIRCH_CHEST_BOAT.getDefaultInstance(),
                    AspenGroveItems.ASPEN_BOAT.getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    AspenGroveItems.ASPEN_BOAT.getDefaultInstance(),
                    AspenGroveItems.ASPEN_CHEST_BOAT.getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
        }
    }

    public static void initialize() {
    }
}