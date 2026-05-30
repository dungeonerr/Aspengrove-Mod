package dngnrr.aspengrove.classes.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import dngnrr.aspengrove.AspenGrove;
import dngnrr.aspengrove.classes.AspenGroveBoatType;
import dngnrr.aspengrove.classes.boats.*;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.vehicle.Boat;
import org.joml.Quaternionf;

import java.util.HashMap;
import java.util.Map;

public class AspenBoatRenderer extends EntityRenderer<Boat> {
    private final Map<AspenGroveBoatType, Pair<ResourceLocation, ListModel<Boat>>> boatResources = new HashMap<>();

    public AspenBoatRenderer(EntityRendererProvider.Context context, boolean isChest) {
        super(context);
        for (AspenGroveBoatType type : AspenGroveBoatType.values()) {
            String folder = isChest ? "chest_boat" : "boat";
            ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(AspenGrove.MOD_ID,
                    "textures/entity/" + folder + "/" + type.getSerializedName() + ".png");

            ModelLayerLocation layer = isChest ? AspenGroveClient.ASPEN_CHEST_BOAT_LAYER : AspenGroveClient.ASPEN_BOAT_LAYER;

            ListModel<Boat> model = isChest
                    ? new ChestBoatModel(context.bakeLayer(layer))
                    : new BoatModel(context.bakeLayer(layer));

            boatResources.put(type, Pair.of(texture, model));
        }
    }

    @Override
    public void render(Boat boat, float f, float g, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
        poseStack.pushPose();
        poseStack.translate(0.0D, 0.375D, 0.0D);
        poseStack.mulPose((new Quaternionf()).setAngleAxis((180.0F - f) * ((float)Math.PI / 180F), 0.0F, 1.0F, 0.0F));

        float h = (float)boat.getHurtTime() - g;
        float j = boat.getDamage() - g;
        if (j < 0.0F) j = 0.0F;

        if (h > 0.0F) {
            poseStack.mulPose((new Quaternionf()).setAngleAxis(Mth.sin(h) * h * j / 10.0F * (float)boat.getHurtDir() * ((float)Math.PI / 180F), 1.0F, 0.0F, 0.0F));
        }

        Pair<ResourceLocation, ListModel<Boat>> pair = this.getModResources(boat);
        ResourceLocation resourceLocation = pair.getFirst();
        ListModel<Boat> listModel = pair.getSecond();

        poseStack.scale(-1.0F, -1.0F, 1.0F);
        poseStack.mulPose((new Quaternionf()).setAngleAxis(((float)Math.PI / 2F), 0.0F, 1.0F, 0.0F));

        listModel.setupAnim(boat, g, 0.0F, -0.1F, 0.0F, 0.0F);

        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(listModel.renderType(resourceLocation));
        listModel.renderToBuffer(poseStack, vertexConsumer, i, OverlayTexture.NO_OVERLAY);

        if (!boat.isEyeInFluid(FluidTags.WATER)) {
            VertexConsumer vertexConsumer2 = multiBufferSource.getBuffer(RenderType.waterMask());
            if (listModel instanceof BoatModel boatModel) {
                boatModel.waterPatch().render(poseStack, vertexConsumer2, i, OverlayTexture.NO_OVERLAY);
            }
        }

        poseStack.popPose();
        super.render(boat, f, g, poseStack, multiBufferSource, i);
    }

    @Override
    public ResourceLocation getTextureLocation(Boat boat) {
        return this.getModResources(boat).getFirst();
    }

    private Pair<ResourceLocation, ListModel<Boat>> getModResources(Boat boat) {
        AspenGroveBoatType type = AspenGroveBoatType.ASPEN;
        if (boat instanceof AspenGroveBoatEntity modBoat) {
            type = modBoat.getModVariant();
        } else if (boat instanceof AspenGroveChestBoatEntity modChestBoat) {
            type = modChestBoat.getModVariant();
        }
        return boatResources.getOrDefault(type, boatResources.get(AspenGroveBoatType.ASPEN));
    }
}