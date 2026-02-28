package dngnrr.aspengrove;

import dngnrr.aspengrove.classes.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.Identifier;

public class AspengroveClient implements ClientModInitializer {
    public static final String MOD_ID = "aspengrove";
    public static final ModelLayerLocation ASPEN_BOAT = register("boat/aspen");
    public static final ModelLayerLocation ASPEN_CHEST_BOAT = register("chest_boat/aspen");

    private static ModelLayerLocation register(String name) {
        return new ModelLayerLocation(Identifier.fromNamespaceAndPath(Aspengrove.MOD_ID, name), "main");
    }
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.ASPEN_BOAT, context ->
                new AspenBoatRenderer(context, ModelLayers.OAK_BOAT, "aspen", false)
        );

        EntityRendererRegistry.register(ModEntities.ASPEN_CHEST_BOAT, context ->
                new AspenBoatRenderer(context, ModelLayers.OAK_CHEST_BOAT, "aspen", true)
        );

        BlockRenderLayerMap.putBlock(ModBlocks.ASPEN_LEAVES, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.ASPEN_SAPLING, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.ASPEN_DOOR, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.ASPEN_TRAPDOOR, ChunkSectionLayer.CUTOUT);

        Material signMaterial = new Material(Sheets.SIGN_SHEET, Identifier.fromNamespaceAndPath("aspengrove", "entity/signs/aspen"));
        Material hangingSignMaterial = new Material(Sheets.SIGN_SHEET, Identifier.fromNamespaceAndPath("aspengrove", "entity/signs/hanging/aspen"));

        Sheets.SIGN_MATERIALS.put(ModWoodTypes.ASPEN, signMaterial);
        Sheets.HANGING_SIGN_MATERIALS.put(ModWoodTypes.ASPEN, hangingSignMaterial);
    }
}