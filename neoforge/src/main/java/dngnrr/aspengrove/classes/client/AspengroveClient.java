package dngnrr.aspengrove.classes.client;

import dngnrr.aspengrove.Aspengrove;
import dngnrr.aspengrove.classes.ModEntities;
import dngnrr.aspengrove.classes.ModWoodTypes;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public class AspengroveClient {

    public static final ModelLayerLocation ASPEN_BOAT_LAYER =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(Aspengrove.MOD_ID, "boat/aspen"), "main");

    public static final ModelLayerLocation ASPEN_CHEST_BOAT_LAYER =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(Aspengrove.MOD_ID, "chest_boat/aspen"), "main");

    public AspengroveClient(IEventBus modEventBus) {
        modEventBus.addListener(this::onClientSetup);
        modEventBus.addListener(this::registerLayerDefinitions);
        modEventBus.addListener(this::registerRenderers);
    }

    public void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ASPEN_BOAT_LAYER, BoatModel::createBoatModel);
        event.registerLayerDefinition(ASPEN_CHEST_BOAT_LAYER, BoatModel::createChestBoatModel);
    }

    public void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.ASPEN_BOAT.get(),
                context -> new AspenBoatRenderer(context, ASPEN_BOAT_LAYER));
        event.registerEntityRenderer(ModEntities.ASPEN_CHEST_BOAT.get(),
                context -> new AspenBoatRenderer(context, ASPEN_CHEST_BOAT_LAYER));
    }

    public void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> Sheets.addWoodType(ModWoodTypes.ASPEN));
    }
}