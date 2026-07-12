package dngnrr.aspengrove.classes;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class AspenGroveBiomes {
    public static final ResourceKey<Biome> ASPEN_GROVE = ResourceKey.create(
            Registries.BIOME,
            Identifier.fromNamespaceAndPath("aspengrove", "aspen_grove")
    );

    public static void registerBiomes() {
        // а пусто нахуй
    }
}