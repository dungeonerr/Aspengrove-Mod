package dngnrr.aspengrove.classes;

import dngnrr.aspengrove.Aspengrove;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab {
    public static final CreativeModeTab ASPENGROVE_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(Aspengrove.MOD_ID,"aspengrove"),
            FabricItemGroup.builder( ).title(Component.translatable("itemGroup.aspengrove"))
                    .icon(() -> new ItemStack(ModBlocks.ASPEN_LOG)).displayItems((displayContext,entries) -> {
                        entries.accept(ModBlocks.ASPEN_LOG);
                        entries.accept(ModBlocks.ASPEN_WOOD);
                        entries.accept(ModBlocks.STRIPPED_ASPEN_LOG);
                        entries.accept(ModBlocks.STRIPPED_ASPEN_WOOD);
                        entries.accept(ModBlocks.ASPEN_PLANKS);
                        entries.accept(ModBlocks.ASPEN_STAIRS);
                        entries.accept(ModBlocks.ASPEN_SLAB);
                        entries.accept(ModBlocks.ASPEN_FENCE);
                        entries.accept(ModBlocks.ASPEN_FENCE_GATE);
                        entries.accept(ModBlocks.ASPEN_DOOR);
                        entries.accept(ModBlocks.ASPEN_TRAPDOOR);
                        entries.accept(ModBlocks.ASPEN_PRESSURE_PLATE);
                        entries.accept(ModBlocks.ASPEN_BUTTON);
                        entries.accept(ModBlocks.ASPEN_SIGN_ITEM);
                        entries.accept(ModBlocks.ASPEN_HANGING_SIGN_ITEM);
                        entries.accept(ModBlocks.ASPEN_LEAVES);
                        entries.accept(ModBlocks.ASPEN_SAPLING);
                    }).build( ));

    public static void initialize() {
    }
}