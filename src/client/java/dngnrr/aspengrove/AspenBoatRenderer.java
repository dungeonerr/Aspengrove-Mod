package dngnrr.aspengrove;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public class AspenBoatRenderer extends BoatRenderer {
    private final Identifier customTexture;

    public AspenBoatRenderer(EntityRendererProvider.Context context, ModelLayerLocation modelLayerLocation, String name, boolean isChest) {
        super(context, modelLayerLocation);

        // В твоей версии путь формируется вручную.
        // Мы игнорируем то, что сделал super(), и создаем свой Identifier.
        String folder = isChest ? "chest_boat" : "boat";
        this.customTexture = Identifier.fromNamespaceAndPath("aspengrove", "textures/entity/" + folder + "/" + name + ".png");
    }

    // В НОВОЙ СИСТЕМЕ (RenderState) текстура берется через этот метод:
    @Override
    protected net.minecraft.client.renderer.rendertype.RenderType renderType() {
        // Мы заставляем модель использовать НАШУ текстуру вместо той, что в super.texture
        return this.model().renderType(this.customTexture);
    }
}