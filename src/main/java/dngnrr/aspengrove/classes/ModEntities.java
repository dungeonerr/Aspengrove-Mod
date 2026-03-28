package dngnrr.aspengrove.classes;

import dngnrr.aspengrove.Aspengrove;
import dngnrr.aspengrove.classes.boats.ModBoatEntity;
import dngnrr.aspengrove.classes.boats.ModChestBoatEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {
    public static final EntityType<ModBoatEntity> ASPEN_BOAT = register("aspen_boat",
            EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC)
                    .sized(1.375F, 0.5625F)
                    .clientTrackingRange(10));

    public static final EntityType<ModChestBoatEntity> ASPEN_CHEST_BOAT = register("aspen_chest_boat",
            EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC)
                    .sized(1.375F, 0.5625F)
                    .clientTrackingRange(10));

    private static <T extends net.minecraft.world.entity.Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, name);
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, id, builder.build(id.toString()));
    }

    public static void initialize() {}
}