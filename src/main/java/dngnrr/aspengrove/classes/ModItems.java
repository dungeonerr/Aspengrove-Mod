package dngnrr.aspengrove.classes;

import dngnrr.aspengrove.Aspengrove;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {

    public static final Item ASPEN_BOAT = register("aspen_boat",
            settings -> new BoatItem(ModEntities.ASPEN_BOAT, settings));

    public static final Item ASPEN_CHEST_BOAT = register("aspen_chest_boat",
            settings -> new BoatItem(ModEntities.ASPEN_CHEST_BOAT, settings));

    private static Item register(String name, Function<Item.Properties, Item> factory) {
        Identifier id = Identifier.fromNamespaceAndPath(Aspengrove.MOD_ID, name);
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id);
        Item.Properties properties = new Item.Properties().setId(key).stacksTo(1);

        return Registry.register(BuiltInRegistries.ITEM, id, factory.apply(properties));
    }

    public static void registerFuels() {
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(ASPEN_BOAT, 1200);
            builder.add(ASPEN_CHEST_BOAT, 1200);
        });
    }

    public static void initialize() {
    }
}