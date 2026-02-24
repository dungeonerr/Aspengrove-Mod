package dngnrr.aspengrove;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dngnrr.aspengrove.classes.ModBlocks;
import dngnrr.aspengrove.classes.ModCreativeTab;

public class Aspengrove implements ModInitializer {
public static final String MOD_ID = "aspengrove";
public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
@Override
public void onInitialize() {
ModBlocks.initialize();
ModCreativeTab.initialize();
}
}
