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
public static final CreativeModeTab ASPEN_LOG = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
Identifier.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspengrove"),
FabricItemGroup.builder().title(Component.translatable("itemGroup.aspengrove"))
.icon(() -> new ItemStack(ModBlocks.ASPEN_LOG)).displayItems((displayContext, entries) -> {
entries.accept(ModBlocks.ASPEN_LOG);
}).build());
public static void initialize() {}
}