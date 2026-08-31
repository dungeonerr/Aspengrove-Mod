package dngnrr.aspengrove.classes.client;

import dngnrr.aspengrove.AspenGrove;
import dngnrr.aspengrove.classes.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.GrassColor;

import java.util.List;

public class AspenGroveClient implements ClientModInitializer {
    public static final String MOD_ID = "aspengrove";
    public static final ModelLayerLocation ASPEN_BOAT = register("boat/aspen");
    public static final ModelLayerLocation ASPEN_CHEST_BOAT = register("chest_boat/aspen");

    private static ModelLayerLocation register(String name) {
        return new ModelLayerLocation(Identifier.fromNamespaceAndPath(AspenGrove.MOD_ID, name), "main");
    }
    @Override
    public void onInitializeClient() {
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) {
                return GrassColor.getDefaultColor();
            }
            return net.minecraft.client.renderer.BiomeColors.getAverageGrassColor(world, pos);
        }, AspenGroveBlocks.HONEYFLOWER);

        EntityRendererRegistry.register(AspenGroveEntities.ASPEN_BOAT, context ->
                new AspenBoatRenderer(context, ModelLayers.OAK_BOAT, "aspen", false)
        );
        EntityRendererRegistry.register(AspenGroveEntities.ASPEN_CHEST_BOAT, context ->
                new AspenBoatRenderer(context, ModelLayers.OAK_CHEST_BOAT, "aspen", true)
        );

        BlockRenderLayerMap.putBlock(AspenGroveBlocks.ASPEN_LEAVES, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(AspenGroveBlocks.ASPEN_SAPLING, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(AspenGroveBlocks.POTTED_ASPEN_SAPLING, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(AspenGroveBlocks.HONEYFLOWER, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(AspenGroveBlocks.POTTED_HONEYFLOWER, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(AspenGroveBlocks.ORANGE_MUSHROOM, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(AspenGroveBlocks.POTTED_ORANGE_MUSHROOM, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(AspenGroveBlocks.ASPEN_DOOR, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(AspenGroveBlocks.ASPEN_TRAPDOOR, ChunkSectionLayer.CUTOUT);

        Material signMaterial = new Material(Sheets.SIGN_SHEET, Identifier.fromNamespaceAndPath("aspengrove", "entity/signs/aspen"));
        Material hangingSignMaterial = new Material(Sheets.SIGN_SHEET, Identifier.fromNamespaceAndPath("aspengrove", "entity/signs/hanging/aspen"));

        Sheets.SIGN_MATERIALS.put(AspenGroveWoodTypes.ASPEN, signMaterial);
        Sheets.HANGING_SIGN_MATERIALS.put(AspenGroveWoodTypes.ASPEN, hangingSignMaterial);
    }
}