package dngnrr.aspengrove.classes.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AspenBoatRenderer extends BoatRenderer {
    public AspenBoatRenderer(EntityRendererProvider.Context context, ModelLayerLocation modelLayer) {
        super(context, modelLayer);
    }
}