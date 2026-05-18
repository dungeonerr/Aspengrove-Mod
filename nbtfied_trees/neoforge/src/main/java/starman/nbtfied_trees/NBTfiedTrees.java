package starman.nbtfied_trees;

import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import starman.nbtfied_trees.data.worldgen.features.NBTfiedConfiguredFeatures;
import starman.nbtfied_trees.data.worldgen.features.NBTfiedPlacedFeatures;
import starman.nbtfied_trees.world.level.levelgen.feature.NBTfiedTreesFeatures;
import starman.nbtfied_trees.world.level.levelgen.feature.settings.decorations.NBTfiedDecorationsTypes;

@Mod(NBTfiedTrees.MOD_ID)
public class NBTfiedTrees {

    public static final String MOD_ID = "nbtfied_trees";
    public static final String MOD_NAME = "NBTfied Trees";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath("nbtfied_trees", path);
    }

    public NBTfiedTrees(IEventBus modEventBus) {
        LOGGER.info("Initializing {}", MOD_NAME);

        NBTfiedTreesFeatures.register(modEventBus);
        NBTfiedDecorationsTypes.register(modEventBus);
        NBTfiedConfiguredFeatures.register();
        NBTfiedPlacedFeatures.register();
    }
}