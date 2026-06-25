package dngnrr.aspengrove.classes;

import dngnrr.aspengrove.AspenGrove;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class AspenGroveTreeGrowers {
    public static final ResourceKey<Feature> ASPEN_SELECTOR =
            ResourceKey.create(Registries.FEATURE, Identifier.fromNamespaceAndPath(AspenGrove.MOD_ID, "aspen"));

    public static final ResourceKey<PlacedFeature> ASPEN_TREE_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(AspenGrove.MOD_ID, "aspen"));

    public static final TreeGrower ASPEN = new TreeGrower(
            "azalea",
            WeightedList.of(AspenGroveTreeGrowers.ASPEN_SELECTOR),
            WeightedList.of(),
            WeightedList.of(),
            AspenGroveTreeGrowers.ASPEN_SELECTOR
    );


    public static final ResourceKey<Feature> HUGE_ORANGE_MUSHROOM_SELECTOR =
            ResourceKey.create(Registries.FEATURE, Identifier.fromNamespaceAndPath(AspenGrove.MOD_ID, "huge_orange_mushroom"));

    public static void initialize() {
    }
}