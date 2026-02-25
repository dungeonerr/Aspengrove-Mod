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

    public static final SimpleParticleType ASPEN_LEAF_PARTICLE = FabricParticleTypes.simple();

    @Override
    public void onInitialize() {
        ModBlocks.initialize();
        ModBlocks.registerStrippables();
        ModBlocks.registerFuels();
        ModCreativeTab.initialize();
        ModTags.initialize();

        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Identifier.fromNamespaceAndPath(MOD_ID, "aspen_leaf_particle"), ASPEN_LEAF_PARTICLE);
    }
}
