package dngnrr.aspengrove;

import dngnrr.aspengrove.classes.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.Identifier;

public class AspengroveClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.ASPEN_LEAVES,ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.ASPEN_SAPLING,ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.ASPEN_DOOR,ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.ASPEN_TRAPDOOR,ChunkSectionLayer.CUTOUT);

        Material signMaterial = new Material(Sheets.SIGN_SHEET, Identifier.fromNamespaceAndPath("aspengrove", "entity/signs/aspen"));
        Material hangingSignMaterial = new Material(Sheets.SIGN_SHEET, Identifier.fromNamespaceAndPath("aspengrove", "entity/signs/hanging/aspen"));

        Sheets.SIGN_MATERIALS.put(ModWoodTypes.ASPEN, signMaterial);
        Sheets.HANGING_SIGN_MATERIALS.put(ModWoodTypes.ASPEN, hangingSignMaterial);
    }
}