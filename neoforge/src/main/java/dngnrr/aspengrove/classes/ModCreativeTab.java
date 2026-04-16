package dngnrr.aspengrove.classes;

import dngnrr.aspengrove.Aspengrove;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab {
    public static CreativeModeTab ASPENGROVE_TAB;

    public static void init() {
        ASPENGROVE_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
                ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspengrove"),
                CreativeModeTab.builder()
                        .title(Component.translatable("itemGroup.aspengrove"))
                        .icon(() -> new ItemStack(ModBlocks.ASPEN_LOG))
                        .displayItems((parameters, output) -> {
                            output.accept(ModBlocks.ASPEN_LOG);
                            output.accept(ModBlocks.ASPEN_WOOD);
                            output.accept(ModBlocks.STRIPPED_ASPEN_LOG);
                            output.accept(ModBlocks.STRIPPED_ASPEN_WOOD);
                            output.accept(ModBlocks.ASPEN_PLANKS);
                            output.accept(ModBlocks.ASPEN_STAIRS);
                            output.accept(ModBlocks.ASPEN_SLAB);
                            output.accept(ModBlocks.ASPEN_FENCE);
                            output.accept(ModBlocks.ASPEN_FENCE_GATE);
                            output.accept(ModBlocks.ASPEN_DOOR);
                            output.accept(ModBlocks.ASPEN_TRAPDOOR);
                            output.accept(ModBlocks.ASPEN_PRESSURE_PLATE);
                            output.accept(ModBlocks.ASPEN_BUTTON);
                            output.accept(ModBlocks.ASPEN_SIGN_ITEM);
                            output.accept(ModBlocks.ASPEN_HANGING_SIGN_ITEM);
                            output.accept(ModItems.ASPEN_BOAT);
                            output.accept(ModItems.ASPEN_CHEST_BOAT);
                            output.accept(ModBlocks.ASPEN_LEAVES);
                            output.accept(ModBlocks.ASPEN_SAPLING);
                            output.accept(ModBlocks.HONEYFLOWER);
                            output.accept(ModBlocks.ORANGE_MUSHROOM);
                            output.accept(ModBlocks.ORANGE_MUSHROOM_BLOCK);
                            output.accept(ModItems.BOUQUET);
                        }).build());
    }

    public static void initialize() {
    }
}