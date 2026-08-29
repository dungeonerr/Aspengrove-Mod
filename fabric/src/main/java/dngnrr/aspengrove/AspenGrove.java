package dngnrr.aspengrove;

import dngnrr.aspengrove.classes.*;

import org.slf4j.*;

import net.fabricmc.api.ModInitializer;

public class AspenGrove implements ModInitializer {
    public static final String MOD_ID = "aspengrove";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        AspenGroveColors.initialize();
        AspenGroveWoodTypes.initialize();
        AspenGroveBlocks.initialize();
        AspenGroveCreativeTab.initialize();
        AspenGroveTreeGrowers.initialize();
        AspenGroveEntities.initialize();
        AspenGroveItems.initialize();
        AspenGroveRegisters.initialize();
        AspenGroveBiomes.initialize();

        LOGGER.info("Aspen Grove Initialized!");
    }
}