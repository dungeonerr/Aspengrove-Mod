package dngnrr.aspengrove.classes;

import dngnrr.aspengrove.AspenGrove;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class AspenGroveItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AspenGrove.MOD_ID);

    public static final DeferredItem<Item> ASPEN_BOAT = register("aspen_boat",
            settings -> new BoatItem(AspenGroveEntities.ASPEN_BOAT.get(), settings.stacksTo(1)));

    public static final DeferredItem<Item> ASPEN_CHEST_BOAT = register("aspen_chest_boat",
            settings -> new BoatItem(AspenGroveEntities.ASPEN_CHEST_BOAT.get(), settings.stacksTo(1)));

    public static final DeferredItem<Item> BOUQUET = register("bouquet",
            properties -> new Item(properties.stacksTo(16))
    );

    private static DeferredItem<Item> register(String name, Function<Item.Properties, Item> factory) {
        return ITEMS.register(name, (Identifier id) -> {
            ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id);
            Item.Properties properties = new Item.Properties().setId(key);
            return factory.apply(properties);
        });
    }

    public static void initialize(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}