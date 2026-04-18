package starman.nbtfied_trees.world.level.levelgen.feature;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import starman.nbtfied_trees.NBTfiedTrees;
import starman.nbtfied_trees.world.level.levelgen.feature.settings.NBTTreeFeatureConfig;
import starman.nbtfied_trees.world.level.levelgen.feature.settings.NBTTreeFeatureConfigV2;

public class NBTfiedTreesFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(BuiltInRegistries.FEATURE, NBTfiedTrees.MOD_ID);

    public static final DeferredHolder<Feature<?>, Feature<NBTTreeFeatureConfig>> NBT_TREE_V1 =
            FEATURES.register("nbt_tree_v1", () -> new NBTTreeFeature(NBTTreeFeatureConfig.CODEC.stable()));

    public static final DeferredHolder<Feature<?>, Feature<NBTTreeFeatureConfigV2>> NBT_TREE_V2 =
            FEATURES.register("nbt_tree_v2", () -> new NBTTreeFeatureV2(NBTTreeFeatureConfigV2.CODEC.stable()));

    public static void register(IEventBus modEventBus) {
        FEATURES.register(modEventBus);
    }
}