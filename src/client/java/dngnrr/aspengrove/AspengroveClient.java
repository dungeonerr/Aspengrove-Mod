package dngnrr.aspengrove;

import dngnrr.aspengrove.classes.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;

public class AspengroveClient implements ClientModInitializer {
    public static final String MOD_ID = "aspengrove";

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.ASPEN_BOAT, context ->
                new AspenBoatRenderer(context, false)
        );
        EntityRendererRegistry.register(ModEntities.ASPEN_CHEST_BOAT, context ->
                new AspenBoatRenderer(context, true)
        );

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ASPEN_LEAVES, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ASPEN_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_ASPEN_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HONEYFLOWER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_HONEYFLOWER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORANGE_MUSHROOM, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_ORANGE_MUSHROOM, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ASPEN_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ASPEN_TRAPDOOR, RenderType.cutout());

        Material signMaterial = new Material(Sheets.SIGN_SHEET, ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, "entity/signs/aspen"));
        Material hangingSignMaterial = new Material(Sheets.SIGN_SHEET, ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, "entity/signs/hanging/aspen"));

        Sheets.SIGN_MATERIALS.put(ModWoodTypes.ASPEN, signMaterial);
        Sheets.HANGING_SIGN_MATERIALS.put(ModWoodTypes.ASPEN, hangingSignMaterial);
    }

    public static ModelLayerLocation createModelLayerLocation(String name) {
        return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, name), "main");
    }
}