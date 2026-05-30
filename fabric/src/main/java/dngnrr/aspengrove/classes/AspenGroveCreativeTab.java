package dngnrr.aspengrove.classes;

import dngnrr.aspengrove.AspenGrove;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class AspenGroveCreativeTab {
    public static final CreativeModeTab ASPENGROVE_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath(AspenGrove.MOD_ID,"aspengrove"),
            FabricItemGroup.builder( ).title(Component.translatable("itemGroup.aspengrove"))
                    .icon(() -> new ItemStack(AspenGroveBlocks.ASPEN_LOG)).displayItems((displayContext, entries) -> {
                        entries.accept(AspenGroveBlocks.ASPEN_LOG);
                        entries.accept(AspenGroveBlocks.ASPEN_WOOD);
                        entries.accept(AspenGroveBlocks.STRIPPED_ASPEN_LOG);
                        entries.accept(AspenGroveBlocks.STRIPPED_ASPEN_WOOD);
                        entries.accept(AspenGroveBlocks.ASPEN_PLANKS);
                        entries.accept(AspenGroveBlocks.ASPEN_STAIRS);
                        entries.accept(AspenGroveBlocks.ASPEN_SLAB);
                        entries.accept(AspenGroveBlocks.ASPEN_FENCE);
                        entries.accept(AspenGroveBlocks.ASPEN_FENCE_GATE);
                        entries.accept(AspenGroveBlocks.ASPEN_DOOR);
                        entries.accept(AspenGroveBlocks.ASPEN_TRAPDOOR);
                        entries.accept(AspenGroveBlocks.ASPEN_PRESSURE_PLATE);
                        entries.accept(AspenGroveBlocks.ASPEN_BUTTON);
                        entries.accept(AspenGroveBlocks.ASPEN_SIGN_ITEM);
                        entries.accept(AspenGroveBlocks.ASPEN_HANGING_SIGN_ITEM);
                        entries.accept(AspenGroveItems.ASPEN_BOAT);
                        entries.accept(AspenGroveItems.ASPEN_CHEST_BOAT);
                        entries.accept(AspenGroveBlocks.ASPEN_LEAVES);
                        entries.accept(AspenGroveBlocks.ASPEN_SAPLING);
                        entries.accept(AspenGroveBlocks.HONEYFLOWER);
                        entries.accept(AspenGroveBlocks.ORANGE_MUSHROOM);
                        entries.accept(AspenGroveBlocks.ORANGE_MUSHROOM_BLOCK);
                        entries.accept(AspenGroveItems.BOUQUET);
                    }).build( ));

    public static void initialize() {
    }
}