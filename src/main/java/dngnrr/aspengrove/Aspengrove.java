package dngnrr.aspengrove;

import net.fabricmc.api.ModInitializer;

import dngnrr.aspengrove.classes.*;

public class Aspengrove implements ModInitializer {
    public static final String MOD_ID = "aspengrove";

    @Override
    public void onInitialize() {
        ModColors.initialize();
        ModWoodTypes.initialize();
        ModBlocks.initialize();
        ModBlocks.registerFuels();
        ModBlocks.registerStrippables();
        ModBlocks.registerFlammables();
        ModCreativeTab.initialize();
        ModTags.initialize();
        ModTreeGrowers.initialize();
        ModEntities.initialize();
        ModItems.initialize();
        ModItems.registerFuels();
        ModBiomes.registerBiomes();
    }
}