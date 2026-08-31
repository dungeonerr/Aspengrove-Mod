package dngnrr.aspengrove;

import net.fabricmc.api.ModInitializer;

import dngnrr.aspengrove.classes.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AspenGrove implements ModInitializer {
    public static final String MOD_ID = "aspengrove";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        AspenGroveColors.initialize();
        AspenGroveWoodTypes.initialize();
        AspenGroveBlocks.initialize();
        AspenGroveBlocks.registerFuels();
        AspenGroveBlocks.registerStrippables();
        AspenGroveBlocks.registerFlammables();
        AspenGroveBlocks.registerCompostables();
        AspenGroveCreativeTab.initialize();
        AspenGroveTags.initialize();
        AspenGroveTreeGrowers.initialize();
        AspenGroveEntities.initialize();
        AspenGroveItems.initialize();
        AspenGroveItems.registerCompostables();
        AspenGroveItems.registerFuels();
        AspenGroveBiomes.initialize();

        LOGGER.info("Aspen Grove Initialized!");
    }
}