package dngnrr.aspengrove;

import dngnrr.aspengrove.classes.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.particle.EndRodParticle;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class AspengroveClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.ASPEN_LEAVES,ChunkSectionLayer.CUTOUT);
         ParticleFactoryRegistry.getInstance().register(
                 Aspengrove.ASPEN_LEAF_PARTICLE,
            EndRodParticle.Provider::new
        );
    }
}