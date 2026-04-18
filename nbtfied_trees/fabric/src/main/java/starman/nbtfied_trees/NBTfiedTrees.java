package starman.nbtfied_trees;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import starman.nbtfied_trees.data.worldgen.features.NBTfiedConfiguredFeatures;
import starman.nbtfied_trees.data.worldgen.features.NBTfiedPlacedFeatures;
import starman.nbtfied_trees.world.level.levelgen.feature.NBTfiedTreesFeatures;
import starman.nbtfied_trees.world.level.levelgen.feature.settings.decorations.NBTfiedDecorationsTypes;

public class NBTfiedTrees implements ModInitializer {

    public static final String MOD_ID = "nbtfied_trees";
    public static final String MOD_NAME = "NBTfied Trees";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing {}", MOD_NAME);

        NBTfiedTreesFeatures.register();
        NBTfiedConfiguredFeatures.register();
        NBTfiedPlacedFeatures.register();
        NBTfiedDecorationsTypes.register();
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}