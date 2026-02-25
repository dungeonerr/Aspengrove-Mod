package dngnrr.aspengrove;

import net.fabricmc.api.ModInitializer;

import dngnrr.aspengrove.classes.*;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

public class Aspengrove implements ModInitializer {
    public static final String MOD_ID = "aspengrove";

    @Override
    public void onInitialize() {
        ModBlocks.initialize();
        ModBlocks.registerStrippables();
        ModBlocks.registerFuels();
        ModBlocks.registerFlammables();
        ModCreativeTab.initialize();
        ModTags.initialize();
        ModTreeGrowers.initialize();
    }
}
