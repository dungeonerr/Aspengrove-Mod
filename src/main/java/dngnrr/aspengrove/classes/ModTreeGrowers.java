package dngnrr.aspengrove.classes;

import dngnrr.aspengrove.Aspengrove;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.Optional;

public class ModTreeGrowers {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN_SELECTOR =

            ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspen_selector"));
    public static final ResourceKey<PlacedFeature> ASPEN_TREE_PLACED =

            ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspen_tree_placed"));
    public static final TreeGrower ASPEN = new TreeGrower(
            "aspen",
            Optional.empty(),
            Optional.of(ASPEN_SELECTOR),
            Optional.empty()
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_ORANGE_MUSHROOM =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, "huge_orange_mushroom_selector"));
    public static final TreeGrower HUGE_ORANGE_MUSHROOM_GROWER = new TreeGrower(
            "huge_orange_mushroom",
            Optional.empty(),
            Optional.of(HUGE_ORANGE_MUSHROOM),
            Optional.empty()
    );

    public static void initialize() {
    }
}