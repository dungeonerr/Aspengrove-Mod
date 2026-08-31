package dngnrr.aspengrove.classes.client;

import dngnrr.aspengrove.AspenGrove;
import dngnrr.aspengrove.classes.AspenGroveBlocks;
import dngnrr.aspengrove.classes.AspenGroveEntities;
import dngnrr.aspengrove.classes.AspenGroveWoodTypes;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.GrassColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber(Dist.CLIENT)
public class AspenGroveClient {

    @SubscribeEvent
    public static void registerBlockTintSources(RegisterColorHandlersEvent.Block event) {
        event.getBlockColors().register((state, level, pos, tintIndex) -> {
            if (level == null || pos == null) {
                return GrassColor.getDefaultColor();
            }
            return BiomeColors.getAverageGrassColor(level, pos);
        }, AspenGroveBlocks.HONEYFLOWER.get());
    }

    public static final ModelLayerLocation ASPEN_BOAT_LAYER =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(AspenGrove.MOD_ID, "boat/aspen"), "main");

    public static final ModelLayerLocation ASPEN_CHEST_BOAT_LAYER =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(AspenGrove.MOD_ID, "chest_boat/aspen"), "main");

    public AspenGroveClient(IEventBus modEventBus) {
        modEventBus.addListener(this::onClientSetup);
        modEventBus.addListener(this::registerLayerDefinitions);
        modEventBus.addListener(this::registerRenderers);
    }

    public void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ASPEN_BOAT_LAYER, BoatModel::createBoatModel);
        event.registerLayerDefinition(ASPEN_CHEST_BOAT_LAYER, BoatModel::createChestBoatModel);
    }

    public void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(AspenGroveEntities.ASPEN_BOAT.get(),
                context -> new AspenBoatRenderer(context, ASPEN_BOAT_LAYER));
        event.registerEntityRenderer(AspenGroveEntities.ASPEN_CHEST_BOAT.get(),
                context -> new AspenBoatRenderer(context, ASPEN_CHEST_BOAT_LAYER));
    }

    public void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> Sheets.addWoodType(AspenGroveWoodTypes.ASPEN));

        ItemBlockRenderTypes.setRenderLayer(AspenGroveBlocks.ASPEN_LEAVES.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(AspenGroveBlocks.ASPEN_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(AspenGroveBlocks.POTTED_ASPEN_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(AspenGroveBlocks.HONEYFLOWER.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(AspenGroveBlocks.POTTED_HONEYFLOWER.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(AspenGroveBlocks.ORANGE_MUSHROOM.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(AspenGroveBlocks.POTTED_ORANGE_MUSHROOM.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(AspenGroveBlocks.ASPEN_DOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(AspenGroveBlocks.ASPEN_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
    }
}