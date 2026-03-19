package dngnrr.aspengrove.classes;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

public class ModBiomes {
    public static final ResourceKey<Biome> ASPEN_GROVE = ResourceKey.create(
            Registries.BIOME,
            Identifier.fromNamespaceAndPath("aspengrove", "aspen_grove")
    );

    public static void registerBiomes() {
        BiomePlacement.replaceOverworld(Biomes.FOREST, ASPEN_GROVE, 0.27);
        BiomePlacement.replaceOverworld(Biomes.BIRCH_FOREST, ASPEN_GROVE, 0.27);
        BiomePlacement.replaceOverworld(Biomes.TAIGA, ASPEN_GROVE, 0.27);
    }
}