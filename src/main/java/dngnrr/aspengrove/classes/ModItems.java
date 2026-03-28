package dngnrr.aspengrove.classes;

import dngnrr.aspengrove.Aspengrove;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.ComposterBlock;

import java.util.function.Function;

public class ModItems {
    public static final Item ASPEN_BOAT = register("aspen_boat",
            settings -> new BoatItem(false, Boat.Type.OAK, settings));

    public static final Item ASPEN_CHEST_BOAT = register("aspen_chest_boat",
            settings -> new BoatItem(true, Boat.Type.OAK, settings));

    public static final Item BOUQUET = register("bouquet", Item::new);

    private static Item register(String name, Function<Item.Properties, Item> factory) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, name);
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id);
        Item.Properties properties = new Item.Properties().stacksTo(1);
        return Registry.register(BuiltInRegistries.ITEM, id, factory.apply(properties));
    }

    public static void registerCompostables() {
        ComposterBlock.COMPOSTABLES.put(BOUQUET, 0.9F);
    }

    public static void registerFuels() {
        FuelRegistry.INSTANCE.add(ASPEN_BOAT, 1200);
        FuelRegistry.INSTANCE.add(ASPEN_CHEST_BOAT, 1200);
    }

    public static void initialize() {
    }
}