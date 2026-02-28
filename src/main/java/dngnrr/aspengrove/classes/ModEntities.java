package dngnrr.aspengrove.classes;

import dngnrr.aspengrove.Aspengrove;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
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
        Identifier id = Identifier.fromNamespaceAndPath(Aspengrove.MOD_ID, name);

        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, id);

        EntityType<T> type = builder.build(key);

        return Registry.register(BuiltInRegistries.ENTITY_TYPE, id, type);
    }

    private static EntityType.EntityFactory<Boat> boatFactory(Supplier<Item> droppedItem) {
        return (type, world) -> new Boat(type, world, droppedItem);
    }

    private static EntityType.EntityFactory<ChestBoat> chestBoatFactory(Supplier<Item> droppedItem) {
        return (type, world) -> new ChestBoat(type, world, droppedItem);
    }

    public static void initialize() {
    }
}