package dngnrr.aspengrove.classes.client;

import dngnrr.aspengrove.AspenGrove;
import dngnrr.aspengrove.classes.AspenGroveBlocks;
import dngnrr.aspengrove.classes.AspenGroveEntities;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

import java.util.List;

@EventBusSubscriber(Dist.CLIENT)
public class AspenGroveClient {

    @SubscribeEvent
    public static void registerBlockTintSources(RegisterColorHandlersEvent.BlockTintSources event) {
        event.register(
                List.of(BlockTintSources.grass()),
                AspenGroveBlocks.HONEYFLOWER.get()
        );
    }

    public static final ModelLayerLocation ASPEN_BOAT_LAYER =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(AspenGrove.MOD_ID, "boat/aspen"), "main");

    public static final ModelLayerLocation ASPEN_CHEST_BOAT_LAYER =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(AspenGrove.MOD_ID, "chest_boat/aspen"), "main");

    public AspenGroveClient(IEventBus modEventBus) {
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
}