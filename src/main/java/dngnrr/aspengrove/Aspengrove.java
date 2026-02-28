package dngnrr.aspengrove;

import net.fabricmc.api.ModInitializer;

import dngnrr.aspengrove.classes.*;

public class Aspengrove implements ModInitializer {
    public static final String MOD_ID = "aspengrove";

    @Override
    public void onInitialize() {
        ModWoodTypes.initialize();
        ModBlocks.initialize();
        ModBlocks.registerStrippables();
        ModBlocks.registerFuels();
        ModBlocks.registerFlammables();
        ModCreativeTab.initialize();
        ModTags.initialize();
        ModTreeGrowers.initialize();}
}