package starman.nbtfied_trees.data.worldgen.features;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import starman.nbtfied_trees.NBTfiedTrees;
import starman.nbtfied_trees.world.level.levelgen.feature.NBTfiedTreesFeatures;
import starman.nbtfied_trees.world.level.levelgen.feature.settings.NBTTreeFeatureConfig;
import starman.nbtfied_trees.world.level.levelgen.feature.settings.NBTTreeFeatureConfigV2;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class NBTfiedConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> V1_TEST_TREE1 = registerKey("v1_test_tree_1");
    public static final ResourceKey<ConfiguredFeature<?, ?>> V1_TEST_TREE2 = registerKey("v1_test_tree_2");
    public static final ResourceKey<ConfiguredFeature<?, ?>> V1_TEST_TREE3 = registerKey("v1_test_tree_3");
    public static final ResourceKey<ConfiguredFeature<?, ?>> V1_UPSIDE_DOWN_TEST_TREE1 = registerKey("v1_upside_down_test_tree1");
    public static final ResourceKey<ConfiguredFeature<?, ?>> V1_UPSIDE_DOWN_TEST_TREE2 = registerKey("v1_upside_down_test_tree2");
    public static final ResourceKey<ConfiguredFeature<?, ?>> V1_UPSIDE_DOWN_TEST_TREE3 = registerKey("v1_upside_down_test_tree3");
    public static final ResourceKey<ConfiguredFeature<?, ?>> V1_SIDEWAYS_TEST_TREE1 = registerKey("v1_sideways_test_tree1");
    public static final ResourceKey<ConfiguredFeature<?, ?>> V1_SIDEWAYS_TEST_TREE2 = registerKey("v1_sideways_test_tree2");
    public static final ResourceKey<ConfiguredFeature<?, ?>> V1_SIDEWAYS_TEST_TREE3 = registerKey("v1_sideways_test_tree3");
    public static final ResourceKey<ConfiguredFeature<?, ?>> V1_TEST_MUSHROOM1 = registerKey("v1_test_mushroom_1");
    public static final ResourceKey<ConfiguredFeature<?, ?>> V1_TEST_MUSHROOM2 = registerKey("v1_test_mushroom_2");
    public static final ResourceKey<ConfiguredFeature<?, ?>> V2_TEST_TREE1 = registerKey("v2_test_tree_1");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        register(context, V1_TEST_TREE1, NBTfiedTreesFeatures.NBT_TREE_V1, new NBTTreeFeatureConfig.Builder()
                .baseLocation(NBTfiedTrees.id("features/trees/testv1/test_tree_trunk1"))
                .canopyLocation(NBTfiedTrees.id("features/trees/testv1/test_tree_canopy1"))
                .height(UniformInt.of(5, 10))
                .logProvider(BlockStateProvider.simple(Blocks.ACACIA_LOG))
                .leavesProvider(BlockStateProvider.simple(Blocks.ACACIA_LEAVES))
                .logTarget(Set.of(Blocks.OAK_LOG))
                .leavesTarget(Set.of(Blocks.OAK_LEAVES))
                .growableOn(BlockPredicate.matchesTag(BlockTags.DIRT))
                .maxLogDepth(3)
                .treeDecorators(List.of(new AlterGroundDecorator(SimpleStateProvider.simple(Blocks.MOSS_BLOCK))))
                .build());

        register(context, V1_TEST_TREE2, NBTfiedTreesFeatures.NBT_TREE_V1, new NBTTreeFeatureConfig.Builder()
                .baseLocation(NBTfiedTrees.id("features/trees/testv1/test_tree_trunk1"))
                .canopyLocation(NBTfiedTrees.id("features/trees/testv1/test_tree_canopy1"))
                .height(UniformInt.of(5, 10))
                .logProvider(BlockStateProvider.simple(Blocks.JUNGLE_LOG))
                .leavesProvider(BlockStateProvider.simple(Blocks.JUNGLE_LEAVES))
                .logTarget(Set.of(Blocks.OAK_LOG))
                .leavesTarget(Set.of(Blocks.OAK_LEAVES))
                .growableOn(BlockPredicate.matchesTag(BlockTags.DIRT))
                .maxLogDepth(5)
                .treeDecorators(List.of(new LeaveVineDecorator(0.5F), new BeehiveDecorator(0.2F)))
                .build());

        register(context, V1_UPSIDE_DOWN_TEST_TREE1, NBTfiedTreesFeatures.NBT_TREE_V1, new NBTTreeFeatureConfig.Builder()
                .baseLocation(NBTfiedTrees.id("features/trees/testv1/test_tree_trunk1"))
                .canopyLocation(NBTfiedTrees.id("features/trees/testv1/test_tree_canopy1"))
                .height(UniformInt.of(5, 10))
                .logProvider(BlockStateProvider.simple(Blocks.ACACIA_LOG))
                .leavesProvider(BlockStateProvider.simple(Blocks.ACACIA_LEAVES))
                .logTarget(Set.of(Blocks.OAK_LOG))
                .leavesTarget(Set.of(Blocks.OAK_LEAVES))
                .growableOn(BlockPredicate.matchesTag(BlockTags.DIRT))
                .maxLogDepth(3)
                .orientation(NBTTreeFeatureConfig.Orientation.UPSIDE_DOWN)
                .build());

        register(context, V2_TEST_TREE1, NBTfiedTreesFeatures.NBT_TREE_V2, new NBTTreeFeatureConfigV2.Builder()
                .baseLocation(NBTfiedTrees.id("features/trees/testv2/test_tree_trunk1"))
                .canopyLocation(NBTfiedTrees.id("features/trees/testv2/test_tree_canopy1"))
                .height(UniformInt.of(5, 10))
                .logProvider(BlockStateProvider.simple(Blocks.ACACIA_LOG))
                .leavesProvider(List.of(BlockStateProvider.simple(Blocks.OAK_LEAVES)))
                .logTarget(Set.of(Blocks.OAK_LOG))
                .leavesTarget(List.of(Blocks.OAK_LEAVES))
                .growableOn(BlockPredicate.matchesTag(BlockTags.DIRT))
                .maxLogDepth(3)
                .replaceFromNBT(Map.of(Blocks.SHROOMLIGHT, new WeightedStateProvider(WeightedList.<BlockState>builder().add(Blocks.GLOWSTONE.defaultBlockState(), 3).build())))
                .build());
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, NBTfiedTrees.id(name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }

    public static void register() {
    }
}