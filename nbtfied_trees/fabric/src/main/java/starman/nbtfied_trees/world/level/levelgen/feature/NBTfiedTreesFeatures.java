package starman.nbtfied_trees.world.level.levelgen.feature;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import starman.nbtfied_trees.NBTfiedTrees;
import starman.nbtfied_trees.world.level.levelgen.feature.settings.NBTTreeFeatureConfig;
import starman.nbtfied_trees.world.level.levelgen.feature.settings.NBTTreeFeatureConfigV2;

public class NBTfiedTreesFeatures {

    public static final Feature<NBTTreeFeatureConfig> NBT_TREE_V1 = register(
            "nbt_tree_v1",
            new NBTTreeFeature(NBTTreeFeatureConfig.CODEC.stable())
    );

    public static final Feature<NBTTreeFeatureConfigV2> NBT_TREE_V2 = register(
            "nbt_tree_v2",
            new NBTTreeFeatureV2(NBTTreeFeatureConfigV2.CODEC.stable())
    );

    private static <T extends Feature<?>> T register(String name, T feature) {
        return Registry.register(BuiltInRegistries.FEATURE, NBTfiedTrees.id(name), feature);
    }

    public static void register() {
        NBTfiedTrees.LOGGER.info("Registering Features for " + NBTfiedTrees.MOD_NAME);
    }
}