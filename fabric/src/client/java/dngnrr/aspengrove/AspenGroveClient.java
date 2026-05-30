package dngnrr.aspengrove;

import dngnrr.aspengrove.classes.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;

public class AspenGroveClient implements ClientModInitializer {
    public static final ModelLayerLocation ASPEN_BOAT_LAYER = register("boat/aspen");
    public static final ModelLayerLocation ASPEN_CHEST_BOAT_LAYER = register("chest_boat/aspen");

    private static ModelLayerLocation register(String name) {
        return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(AspenGrove.MOD_ID, name), "main");
    }

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ASPEN_BOAT_LAYER, BoatModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(ASPEN_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);

        EntityRendererRegistry.register(AspenGroveEntities.ASPEN_BOAT, context -> new AspenBoatRenderer(context, false));
        EntityRendererRegistry.register(AspenGroveEntities.ASPEN_CHEST_BOAT, context -> new AspenBoatRenderer(context, true));

        RenderType cutout = RenderType.cutout();
        BlockRenderLayerMap.INSTANCE.putBlock(AspenGroveBlocks.ASPEN_LEAVES, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(AspenGroveBlocks.ASPEN_SAPLING, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(AspenGroveBlocks.POTTED_ASPEN_SAPLING, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(AspenGroveBlocks.HONEYFLOWER, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(AspenGroveBlocks.POTTED_HONEYFLOWER, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(AspenGroveBlocks.ORANGE_MUSHROOM, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(AspenGroveBlocks.POTTED_ORANGE_MUSHROOM, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(AspenGroveBlocks.ASPEN_DOOR, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(AspenGroveBlocks.ASPEN_TRAPDOOR, cutout);

        Material signMaterial = new Material(Sheets.SIGN_SHEET, ResourceLocation.fromNamespaceAndPath(AspenGrove.MOD_ID, "entity/signs/aspen"));
        Material hangingSignMaterial = new Material(Sheets.SIGN_SHEET, ResourceLocation.fromNamespaceAndPath(AspenGrove.MOD_ID, "entity/signs/hanging/aspen"));

        Sheets.SIGN_MATERIALS.put(AspenGroveWoodTypes.ASPEN, signMaterial);
        Sheets.HANGING_SIGN_MATERIALS.put(AspenGroveWoodTypes.ASPEN, hangingSignMaterial);
    }
}