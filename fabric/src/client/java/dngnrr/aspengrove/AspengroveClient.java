package dngnrr.aspengrove;

import dngnrr.aspengrove.classes.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.resources.Identifier;

public class AspengroveClient implements ClientModInitializer {
    public static final String MOD_ID = "aspengrove";

    public static final ModelLayerLocation ASPEN_BOAT = register("boat/aspen");
    public static final ModelLayerLocation ASPEN_CHEST_BOAT = register("chest_boat/aspen");

    private static ModelLayerLocation register(String name) {
        return new ModelLayerLocation(Identifier.fromNamespaceAndPath(MOD_ID, name), "main");
    }

    @Override
    public void onInitializeClient() {
        ModelLayerRegistry.registerModelLayer(ASPEN_BOAT, BoatModel::createBoatModel);
        ModelLayerRegistry.registerModelLayer(ASPEN_CHEST_BOAT, BoatModel::createChestBoatModel);

        EntityRendererRegistry.register(ModEntities.ASPEN_BOAT, context ->
                new AspenBoatRenderer(context, ASPEN_BOAT, "aspen", false)
        );

        EntityRendererRegistry.register(ModEntities.ASPEN_CHEST_BOAT, context ->
                new AspenBoatRenderer(context, ASPEN_CHEST_BOAT, "aspen", true)
        );

        SpriteId signMaterial = new SpriteId(
                Sheets.SIGN_SHEET,
                Identifier.fromNamespaceAndPath(MOD_ID, "entity/signs/aspen")
        );

        SpriteId hangingSignMaterial = new SpriteId(
                Sheets.SIGN_SHEET,
                Identifier.fromNamespaceAndPath(MOD_ID, "entity/signs/hanging/aspen")
        );

        Sheets.SIGN_SPRITES.put(ModWoodTypes.ASPEN, signMaterial);
        Sheets.HANGING_SIGN_SPRITES.put(ModWoodTypes.ASPEN, hangingSignMaterial);
    }
}