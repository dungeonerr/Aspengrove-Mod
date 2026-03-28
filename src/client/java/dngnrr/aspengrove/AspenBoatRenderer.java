package dngnrr.aspengrove;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

public class AspenBoatRenderer extends BoatRenderer {
    private final ResourceLocation customTexture;

    public AspenBoatRenderer(EntityRendererProvider.Context context, boolean isChest) {
        super(context, isChest);
        String folder = isChest ? "chest_boat" : "boat";
        this.customTexture = ResourceLocation.fromNamespaceAndPath("aspengrove", "textures/entity/" + folder + "/aspen.png");
    }

    @Override
    public ResourceLocation getTextureLocation(Boat boat) {
        return this.customTexture;
    }
}