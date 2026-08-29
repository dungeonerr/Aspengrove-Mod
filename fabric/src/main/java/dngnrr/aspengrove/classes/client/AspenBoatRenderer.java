package dngnrr.aspengrove.classes.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.entity.*;

public class AspenBoatRenderer extends BoatRenderer {
    private final Identifier customTexture;

    public AspenBoatRenderer(EntityRendererProvider.Context context, ModelLayerLocation modelLayerLocation, String name, boolean isChest) {
        super(context, modelLayerLocation);
        String folder = isChest ? "chest_boat" : "boat";
        this.customTexture = Identifier.fromNamespaceAndPath("aspengrove", "textures/entity/" + folder + "/" + name + ".png");
    }

    protected RenderType renderType() {
        return this.model().renderType(this.customTexture);
    }
}