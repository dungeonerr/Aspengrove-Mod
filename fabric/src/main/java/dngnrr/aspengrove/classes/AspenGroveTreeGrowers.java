package dngnrr.aspengrove.classes;

import dngnrr.aspengrove.AspenGrove;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.Optional;

public class AspenGroveTreeGrowers {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN_SELECTOR =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(AspenGrove.MOD_ID, "aspen"));

    public static final ResourceKey<PlacedFeature> ASPEN_TREE_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(AspenGrove.MOD_ID, "aspen"));

    public static final TreeGrower ASPEN = new TreeGrower(
            "aspen",
            Optional.empty(),
            Optional.of(ASPEN_SELECTOR),
            Optional.empty()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_ORANGE_MUSHROOM_SELECTOR =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(AspenGrove.MOD_ID, "huge_orange_mushroom_"));

    public static void initialize() {
    }
}