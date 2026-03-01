package dngnrr.aspengrove;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public class AspenBoatRenderer extends BoatRenderer {
    private final Identifier customTexture;

    public AspenBoatRenderer(EntityRendererProvider.Context context, ModelLayerLocation modelLayerLocation, String name, boolean isChest) {
        super(context, modelLayerLocation);

        String folder = isChest ? "chest_boat" : "boat";
        this.customTexture = Identifier.fromNamespaceAndPath("aspengrove", "textures/entity/" + folder + "/" + name + ".png");
    }

    @Override
    protected net.minecraft.client.renderer.rendertype.RenderType renderType() {
        return this.model().renderType(this.customTexture);
    }
}