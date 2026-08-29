package dngnrr.aspengrove.classes;

import dngnrr.aspengrove.AspenGrove;

import java.util.function.*;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.providers.number.NumberProviders;
import net.minecraft.core.*;
import net.minecraft.core.registries.*;
import net.minecraft.resources.*;
import net.minecraft.world.item.*;

public class AspenGroveItems {
    public static final Item ASPEN_BOAT = register("aspen_boat", properties -> new BoatItem(AspenGroveEntities.ASPEN_BOAT, properties.stacksTo(1).cookingFuel(NumberProviders.COOKING_TIME_BOATS)));
    public static final Item ASPEN_CHEST_BOAT = register("aspen_chest_boat", properties -> new BoatItem(AspenGroveEntities.ASPEN_CHEST_BOAT, properties.stacksTo(1).cookingFuel(NumberProviders.COOKING_TIME_BOATS)));
    public static final Item BOUQUET = register("bouquet", properties -> new Item(properties.stacksTo(16).compostable(NumberProviders.COMPOSTABLE_LOW_MEDIUM)));

    public static final Item ASPEN_LOG_ITEM = register("aspen_log", properties -> new BlockItem(AspenGroveBlocks.ASPEN_LOG, properties.useBlockDescriptionPrefix().cookingFuel(NumberProviders.COOKING_TIME_WOOD_BLOCKS).stacksTo(64)));
    public static final Item STRIPPED_ASPEN_LOG_ITEM = register("stripped_aspen_log", properties -> new BlockItem(AspenGroveBlocks.STRIPPED_ASPEN_LOG, properties.useBlockDescriptionPrefix().cookingFuel(NumberProviders.COOKING_TIME_WOOD_BLOCKS).stacksTo(64)));
    public static final Item ASPEN_WOOD_ITEM = register("aspen_wood", properties -> new BlockItem(AspenGroveBlocks.ASPEN_WOOD, properties.useBlockDescriptionPrefix().cookingFuel(NumberProviders.COOKING_TIME_WOOD_BLOCKS).stacksTo(64)));
    public static final Item STRIPPED_ASPEN_WOOD_ITEM = register("stripped_aspen_wood", properties -> new BlockItem(AspenGroveBlocks.STRIPPED_ASPEN_WOOD, properties.useBlockDescriptionPrefix().cookingFuel(NumberProviders.COOKING_TIME_WOOD_BLOCKS).stacksTo(64)));
    public static final Item ASPEN_PLANKS_ITEM = register("aspen_planks", properties -> new BlockItem(AspenGroveBlocks.ASPEN_PLANKS, properties.useBlockDescriptionPrefix().cookingFuel(NumberProviders.COOKING_TIME_WOOD_BLOCKS).stacksTo(64)));
    public static final Item ASPEN_SLAB_ITEM = register("aspen_slab", properties -> new BlockItem(AspenGroveBlocks.ASPEN_SLAB, properties.useBlockDescriptionPrefix().cookingFuel(NumberProviders.COOKING_TIME_WOOD_SLABS).stacksTo(64)));
    public static final Item ASPEN_STAIRS_ITEM = register("aspen_stairs", properties -> new BlockItem(AspenGroveBlocks.ASPEN_STAIRS, properties.useBlockDescriptionPrefix().cookingFuel(NumberProviders.COOKING_TIME_WOOD_BLOCKS).stacksTo(64)));
    public static final Item ASPEN_FENCE_ITEM = register("aspen_fence", properties -> new BlockItem(AspenGroveBlocks.ASPEN_FENCE, properties.useBlockDescriptionPrefix().cookingFuel(NumberProviders.COOKING_TIME_WOOD_BLOCKS).stacksTo(64)));
    public static final Item ASPEN_FENCE_GATE_ITEM = register("aspen_fence_gate", properties -> new BlockItem(AspenGroveBlocks.ASPEN_FENCE_GATE, properties.useBlockDescriptionPrefix().cookingFuel(NumberProviders.COOKING_TIME_WOOD_BLOCKS).stacksTo(64)));
    public static final Item ASPEN_PRESSURE_PLATE_ITEM = register("aspen_pressure_plate", properties -> new BlockItem(AspenGroveBlocks.ASPEN_PRESSURE_PLATE, properties.useBlockDescriptionPrefix().cookingFuel(NumberProviders.COOKING_TIME_WOOD_BLOCKS).stacksTo(64)));
    public static final Item ASPEN_BUTTON_ITEM = register("aspen_button", properties -> new BlockItem(AspenGroveBlocks.ASPEN_BUTTON, properties.useBlockDescriptionPrefix().cookingFuel(NumberProviders.COOKING_TIME_WOOD_ITEMS_EXTRA_SMALL).stacksTo(64)));
    public static final Item ASPEN_DOOR_ITEM = register("aspen_door", properties -> new BlockItem(AspenGroveBlocks.ASPEN_DOOR, properties.useBlockDescriptionPrefix().cookingFuel(NumberProviders.COOKING_TIME_WOOD_ITEMS_LARGE).stacksTo(64)));
    public static final Item ASPEN_TRAPDOOR_ITEM = register("aspen_trapdoor", properties -> new BlockItem(AspenGroveBlocks.ASPEN_TRAPDOOR, properties.useBlockDescriptionPrefix().cookingFuel(NumberProviders.COOKING_TIME_WOOD_BLOCKS).stacksTo(64)));
    public static final Item ASPEN_SIGN_ITEM = registerBlock("aspen_sign", AspenGroveBlocks.ASPEN_SIGN, (b, p) -> new StandingAndWallBlockItem(b, AspenGroveBlocks.ASPEN_WALL_SIGN, Direction.DOWN, p), (Item.Properties)(new Item.Properties()).cookingFuel(NumberProviders.COOKING_TIME_WOOD_ITEMS_LARGE).stacksTo(16).signText());
    public static final Item ASPEN_HANGING_SIGN_ITEM = Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(AspenGrove.MOD_ID, "aspen_hanging_sign"), new HangingSignItem(AspenGroveBlocks.ASPEN_HANGING_SIGN, AspenGroveBlocks.ASPEN_WALL_HANGING_SIGN, new Item.Properties().cookingFuel(NumberProviders.COOKING_TIME_WOOD_BLOCKS).stacksTo(16).setId(item("aspen_hanging_sign"))));
    public static final Item ASPEN_SHELF_ITEM = register("aspen_shelf", properties -> new BlockItem(AspenGroveBlocks.ASPEN_SHELF, properties.useBlockDescriptionPrefix().cookingFuel(NumberProviders.COOKING_TIME_WOOD_BLOCKS).stacksTo(64)));
    public static final Item ASPEN_LEAVES_ITEM = register("aspen_leaves", properties -> new BlockItem(AspenGroveBlocks.ASPEN_LEAVES, properties.useBlockDescriptionPrefix().stacksTo(64).compostable(NumberProviders.COMPOSTABLE_LOW)));
    public static final Item ASPEN_SAPLING_ITEM = register("aspen_sapling", properties -> new BlockItem(AspenGroveBlocks.ASPEN_SAPLING, properties.useBlockDescriptionPrefix().stacksTo(64).compostable(NumberProviders.COMPOSTABLE_LOW)));
    public static final Item HONEYFLOWER_ITEM = register("honeyflower", properties -> new BlockItem(AspenGroveBlocks.HONEYFLOWER, properties.useBlockDescriptionPrefix().stacksTo(64).compostable(NumberProviders.COMPOSTABLE_MEDIUM)));
    public static final Item ORANGE_MUSHROOM_ITEM = register("orange_mushroom", properties -> new BlockItem(AspenGroveBlocks.ORANGE_MUSHROOM, properties.useBlockDescriptionPrefix().stacksTo(64).compostable(NumberProviders.COMPOSTABLE_MEDIUM)));
    public static final Item ORANGE_MUSHROOM_BLOCK_ITEM = register("orange_mushroom_block", properties -> new BlockItem(AspenGroveBlocks.ORANGE_MUSHROOM_BLOCK, properties.useBlockDescriptionPrefix().stacksTo(64).compostable(NumberProviders.COMPOSTABLE_MEDIUM_HIGH)));

    private static ResourceKey<Item> item(String name) {
        return ResourceKey.create(Registries.ITEM,Identifier.fromNamespaceAndPath(AspenGrove.MOD_ID, name));
    }

    private static Item registerBlock(final String name, final Block block, final BiFunction<Block, Item.Properties, Item> itemFactory, final Item.Properties properties) {
        Identifier id = Identifier.fromNamespaceAndPath(AspenGrove.MOD_ID, name);
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id);

        return registerItem(key, (p) -> itemFactory.apply(block, p), properties.useBlockDescriptionPrefix().requiredFeatures(block.requiredFeatures()));
    }

    private static Item registerItem(final ResourceKey<Item> id, final Function<Item.Properties, Item> itemFactory, final Item.Properties properties) {
        Item item = itemFactory.apply(properties.setId(id));
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }

        return (Item)Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    private static Item register(String name, Function<Item.Properties, Item> factory) {
        Identifier id = Identifier.fromNamespaceAndPath(AspenGrove.MOD_ID, name);
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id);
        Item.Properties properties = new Item.Properties().setId(key).stacksTo(1);
        return Registry.register(BuiltInRegistries.ITEM, id, factory.apply(properties));
    }

    public static void initialize() {
    }
}