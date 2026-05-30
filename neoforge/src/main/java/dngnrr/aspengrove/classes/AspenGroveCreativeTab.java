package dngnrr.aspengrove.classes;

import dngnrr.aspengrove.AspenGrove;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class AspenGroveCreativeTab {
    public static CreativeModeTab ASPENGROVE_TAB;

    public static void initialize() {
        ASPENGROVE_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
                ResourceLocation.fromNamespaceAndPath(AspenGrove.MOD_ID, "aspengrove"),
                CreativeModeTab.builder()
                        .title(Component.translatable("itemGroup.aspengrove"))
                        .icon(() -> new ItemStack(AspenGroveBlocks.ASPEN_LOG))
                        .displayItems((parameters, output) -> {
                            output.accept(AspenGroveBlocks.ASPEN_LOG);
                            output.accept(AspenGroveBlocks.ASPEN_WOOD);
                            output.accept(AspenGroveBlocks.STRIPPED_ASPEN_LOG);
                            output.accept(AspenGroveBlocks.STRIPPED_ASPEN_WOOD);
                            output.accept(AspenGroveBlocks.ASPEN_PLANKS);
                            output.accept(AspenGroveBlocks.ASPEN_STAIRS);
                            output.accept(AspenGroveBlocks.ASPEN_SLAB);
                            output.accept(AspenGroveBlocks.ASPEN_FENCE);
                            output.accept(AspenGroveBlocks.ASPEN_FENCE_GATE);
                            output.accept(AspenGroveBlocks.ASPEN_DOOR);
                            output.accept(AspenGroveBlocks.ASPEN_TRAPDOOR);
                            output.accept(AspenGroveBlocks.ASPEN_PRESSURE_PLATE);
                            output.accept(AspenGroveBlocks.ASPEN_BUTTON);
                            output.accept(AspenGroveBlocks.ASPEN_SIGN_ITEM);
                            output.accept(AspenGroveBlocks.ASPEN_HANGING_SIGN_ITEM);
                            output.accept(AspenGroveItems.ASPEN_BOAT);
                            output.accept(AspenGroveItems.ASPEN_CHEST_BOAT);
                            output.accept(AspenGroveBlocks.ASPEN_LEAVES);
                            output.accept(AspenGroveBlocks.ASPEN_SAPLING);
                            output.accept(AspenGroveBlocks.HONEYFLOWER);
                            output.accept(AspenGroveBlocks.ORANGE_MUSHROOM);
                            output.accept(AspenGroveBlocks.ORANGE_MUSHROOM_BLOCK);
                            output.accept(AspenGroveItems.BOUQUET);
                        }).build());
    }
}