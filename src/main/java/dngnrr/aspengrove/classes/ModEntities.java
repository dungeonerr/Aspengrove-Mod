package dngnrr.aspengrove.classes;

import dngnrr.aspengrove.Aspengrove;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ModEntities {
    public static final EntityType<Boat> ASPEN_BOAT = register(
            "aspen_boat",
            EntityType.Builder.<Boat>of(boatFactory(() -> ModItems.ASPEN_BOAT), MobCategory.MISC)
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
    );

    public static final EntityType<ChestBoat> ASPEN_CHEST_BOAT = register(
            "aspen_chest_boat",
            EntityType.Builder.<ChestBoat>of(chestBoatFactory(() -> ModItems.ASPEN_CHEST_BOAT), MobCategory.MISC)
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
    );

    private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, name);
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, id);
        EntityType<T> type = builder.build();
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, id, type);
    }

    private static EntityType.EntityFactory<Boat> boatFactory(Supplier<Item> droppedItem) {
        return Boat::new;
    }

    private static EntityType.EntityFactory<ChestBoat> chestBoatFactory(Supplier<Item> droppedItem) {
        return ChestBoat::new;
    }

    public static void initialize() {
    }
}