package dngnrr.aspengrove.classes.client;

import dngnrr.aspengrove.Aspengrove;
import dngnrr.aspengrove.classes.*;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public class AspengroveClient {
    public static final ModelLayerLocation ASPEN_BOAT_LAYER = register("boat/aspen");
    public static final ModelLayerLocation ASPEN_CHEST_BOAT_LAYER = register("chest_boat/aspen");

    private static ModelLayerLocation register(String name) {
        return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, name), "main");
    }

    public AspengroveClient(IEventBus modEventBus) {
        modEventBus.addListener(this::onClientSetup);
        modEventBus.addListener(this::registerLayers);
        modEventBus.addListener(this::registerRenderers);
    }

    private void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            Sheets.addWoodType(ModWoodTypes.ASPEN);

            RenderType cutout = RenderType.cutout();
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ASPEN_LEAVES, cutout);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ASPEN_SAPLING, cutout);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_ASPEN_SAPLING, cutout);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.HONEYFLOWER, cutout);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_HONEYFLOWER, cutout);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ORANGE_MUSHROOM, cutout);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_ORANGE_MUSHROOM, cutout);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ASPEN_DOOR, cutout);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ASPEN_TRAPDOOR, cutout);
        });
    }

    private void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ASPEN_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(ASPEN_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
    }

    private void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.ASPEN_BOAT, context -> new AspenBoatRenderer(context, false));
        event.registerEntityRenderer(ModEntities.ASPEN_CHEST_BOAT, context -> new AspenBoatRenderer(context, true));
    }
}