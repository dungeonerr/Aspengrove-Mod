package dngnrr.aspengrove.classes;

import dngnrr.aspengrove.Aspengrove;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.resources.Identifier;

import java.util.Optional;

public class ModTreeGrowers {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN_SELECTOR =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspen_selector"));

    public static final ResourceKey<PlacedFeature> ASPEN_TREE_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspen_tree_placed"));

    public static final TreeGrower ASPEN = new TreeGrower(
            "aspen",
            Optional.empty(),
            Optional.of(ASPEN_SELECTOR),
            Optional.empty()
    );

    public static void initialize() {
    }
}