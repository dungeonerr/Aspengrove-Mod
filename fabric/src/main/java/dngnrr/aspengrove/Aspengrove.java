package dngnrr.aspengrove;

import net.fabricmc.api.ModInitializer;
import dngnrr.aspengrove.classes.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Aspengrove implements ModInitializer {
    public static final String MOD_ID = "aspengrove";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModColors.initialize();
        ModWoodTypes.initialize();
        ModBlocks.initialize();
        ModBlocks.registerFuels();
        ModBlocks.registerStrippables();
        ModBlocks.registerFlammables();
        ModBlocks.registerCompostables();
        ModEntities.initialize();
        ModItems.initialize();
        ModCreativeTab.initialize();
        ModTags.initialize();
        ModTreeGrowers.initialize();
        ModBiomes.registerBiomes();

        LOGGER.info("Aspen Grove Initialized!");
    }
}