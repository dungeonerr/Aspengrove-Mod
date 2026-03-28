package dngnrr.aspengrove.classes;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import dngnrr.aspengrove.Aspengrove;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Function;
import java.lang.reflect.Field;
import java.util.Set;
import java.util.HashSet;

public class ModBlocks {
    public static void initialize() {
        addToBlockEntityTypes();
    }

    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        ResourceKey<Item> itemKey = keyOfItem(name);

        Block block = blockFactory.apply(settings);
        if (shouldRegisterItem) {
            Item.Properties itemSettings = new Item.Properties();
            BlockItem blockItem = new BlockItem(block, itemSettings);
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, name));
    }

    public static final Block ASPEN_LOG = register(
            "aspen_log",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .sound(SoundType.WOOD)
                    .strength(2.0F)
                    .ignitedByLava()
                    .instrument(NoteBlockInstrument.BASS),
            true
    );

    public static final Block STRIPPED_ASPEN_LOG = register(
            "stripped_aspen_log",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .sound(SoundType.WOOD)
                    .strength(2.0F)
                    .ignitedByLava()
                    .instrument(NoteBlockInstrument.BASS),
            true
    );

    public static final Block ASPEN_WOOD = register(
            "aspen_wood",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .sound(SoundType.WOOD)
                    .strength(2.0F)
                    .ignitedByLava()
                    .instrument(NoteBlockInstrument.BASS),
            true
    );

    public static final Block STRIPPED_ASPEN_WOOD = register(
            "stripped_aspen_wood",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .sound(SoundType.WOOD)
                    .strength(2.0F)
                    .ignitedByLava()
                    .instrument(NoteBlockInstrument.BASS),
            true
    );

    public static final Block ASPEN_PLANKS = register(
            "aspen_planks",
            Block::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOD)
                    .sound(SoundType.WOOD)
                    .strength(2.0F)
                    .ignitedByLava()
                    .instrument(NoteBlockInstrument.BASS),
            true
    );

    public static final Block ASPEN_SLAB = register(
            "aspen_slab",
            SlabBlock::new,
            BlockBehaviour.Properties
                    .ofFullCopy(ModBlocks.ASPEN_PLANKS),
            true
    );

    public static final Block ASPEN_STAIRS = register(
            "aspen_stairs",
            (settings) -> new StairBlock(ASPEN_PLANKS.defaultBlockState(), settings),
            BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS),
            true
    );

    public static final Block ASPEN_FENCE = register(
            "aspen_fence",
            FenceBlock::new,
            BlockBehaviour.Properties
                    .ofFullCopy(ModBlocks.ASPEN_PLANKS),
            true
    );

    public static final Block ASPEN_FENCE_GATE = register(
            "aspen_fence_gate",
            (settings) -> new FenceGateBlock(WoodType.OAK, settings),
            BlockBehaviour.Properties
                    .ofFullCopy(ModBlocks.ASPEN_PLANKS)
                    .noOcclusion(),
            true
    );

    public static final Block ASPEN_PRESSURE_PLATE = register(
            "aspen_pressure_plate",
            (settings) -> new PressurePlateBlock(BlockSetType.OAK, settings),
            BlockBehaviour.Properties
                    .ofFullCopy(ModBlocks.ASPEN_PLANKS)
                    .noCollission()
                    .strength(0.5f),
            true
    );

    public static final Block ASPEN_BUTTON = register(
            "aspen_button",
            (settings) -> new ButtonBlock(BlockSetType.OAK, 30, settings),
            BlockBehaviour.Properties
                    .ofFullCopy(ModBlocks.ASPEN_PLANKS)
                    .noCollission()
                    .strength(0.5f),
            true
    );

    public static final Block ASPEN_DOOR = register(
            "aspen_door",
            (settings) -> new DoorBlock(BlockSetType.OAK, settings),
            BlockBehaviour.Properties
                    .ofFullCopy(ModBlocks.ASPEN_PLANKS)
                    .ignitedByLava()
                    .noOcclusion(),
            true
    );

    public static final Block ASPEN_TRAPDOOR = register(
            "aspen_trapdoor",
            (settings) -> new TrapDoorBlock(BlockSetType.OAK, settings),
            BlockBehaviour.Properties
                    .ofFullCopy(ModBlocks.ASPEN_PLANKS)
                    .ignitedByLava()
                    .noOcclusion(),
            true
    );

    public static final Block ASPEN_SIGN = Registry.register(
            BuiltInRegistries.BLOCK,
            ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspen_sign"),
            new StandingSignBlock(ModWoodTypes.ASPEN, BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS)
                    .noCollission()
                    .strength(1.0F)
            )
    );

    public static final Block ASPEN_WALL_SIGN = Registry.register(
            BuiltInRegistries.BLOCK,
            ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspen_wall_sign"),
            new WallSignBlock(ModWoodTypes.ASPEN, BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS)
                    .noCollission()
                    .strength(1.0F)
                    .dropsLike(ASPEN_SIGN)
            )
    );

    public static final Item ASPEN_SIGN_ITEM = Registry.register(
            BuiltInRegistries.ITEM,
            ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspen_sign"),
            new SignItem(
                    new Item.Properties()
                            .stacksTo(16),
                    ASPEN_SIGN,
                    ASPEN_WALL_SIGN
            )
    );

    public static final Block ASPEN_HANGING_SIGN = Registry.register(
            BuiltInRegistries.BLOCK,
            ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspen_hanging_sign"),
            new CeilingHangingSignBlock(ModWoodTypes.ASPEN, BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS)
                    .noCollission()
                    .strength(1.0F)
            )
    );

    public static final Block ASPEN_WALL_HANGING_SIGN = Registry.register(
            BuiltInRegistries.BLOCK,
            ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspen_wall_hanging_sign"),
            new WallHangingSignBlock(ModWoodTypes.ASPEN, BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS)
                    .noCollission()
                    .strength(1.0F)
                    .dropsLike(ASPEN_HANGING_SIGN)
            )
    );

    public static final Item ASPEN_HANGING_SIGN_ITEM = Registry.register(
            BuiltInRegistries.ITEM,
            ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspen_hanging_sign"),
            new HangingSignItem(
                    ASPEN_HANGING_SIGN,
                    ASPEN_WALL_HANGING_SIGN,
                    new Item.Properties()
                            .stacksTo(16)
            )
    );

    public static final Block ASPEN_LEAVES = register(
            "aspen_leaves",
            LeavesBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.2f)
                    .noOcclusion()
                    .randomTicks()
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)
                    .isSuffocating((state, level, pos) -> false)
                    .isViewBlocking((state, level, pos) -> false),
            true
    );

    public static final Block ASPEN_SAPLING = register(
            "aspen_sapling",
            (settings) -> new SaplingBlock(ModTreeGrowers.ASPEN, settings),
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)
                    .noOcclusion()
                    .ignitedByLava(),
            true
    );

    public static final Block POTTED_ASPEN_SAPLING = register(
            "potted_aspen_sapling",
            (properties) -> new FlowerPotBlock(ASPEN_SAPLING, properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)
                    .mapColor(MapColor.GRASS),
            true
    );

    public static final Block HONEYFLOWER = register(
            "honeyflower",
            (properties) -> new FlowerBlock(MobEffects.HEALTH_BOOST, 10, properties),
            BlockBehaviour.Properties
                    .ofFullCopy(Blocks.POPPY),
            true
    );

    public static final Block POTTED_HONEYFLOWER = register(
            "potted_honeyflower",
            (properties) -> new FlowerPotBlock(HONEYFLOWER, properties),
            BlockBehaviour.Properties
                    .ofFullCopy(Blocks.POTTED_POPPY),
            true
    );

    public static final Block ORANGE_MUSHROOM = register(
            "orange_mushroom",
            (properties) -> new MushroomBlock(ModTreeGrowers.HUGE_ORANGE_MUSHROOM, properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM)
                    .mapColor(MapColor.COLOR_ORANGE),
            true
    );

    public static final Block POTTED_ORANGE_MUSHROOM = register(
            "potted_orange_mushroom",
            (properties) -> new FlowerPotBlock(ORANGE_MUSHROOM, properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM)
                    .mapColor(MapColor.COLOR_ORANGE),
            true
    );

    public static final Block ORANGE_MUSHROOM_BLOCK = register(
            "orange_mushroom_block",
            HugeMushroomBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)
                    .mapColor(MapColor.COLOR_ORANGE),
            true
    );

    public static void registerCompostables() {
        ComposterBlock.COMPOSTABLES.put(ASPEN_LEAVES.asItem(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ASPEN_SAPLING.asItem(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(HONEYFLOWER.asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(ORANGE_MUSHROOM.asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(ORANGE_MUSHROOM_BLOCK.asItem(), 0.85F);
    }

    public static void registerFuels() {
        FuelRegistry.INSTANCE.add(ASPEN_PLANKS, 300);
        FuelRegistry.INSTANCE.add(ASPEN_LOG, 300);
        FuelRegistry.INSTANCE.add(STRIPPED_ASPEN_LOG, 300);
        FuelRegistry.INSTANCE.add(ASPEN_WOOD, 300);
        FuelRegistry.INSTANCE.add(STRIPPED_ASPEN_WOOD, 300);
        FuelRegistry.INSTANCE.add(ASPEN_FENCE, 300);
        FuelRegistry.INSTANCE.add(ASPEN_FENCE_GATE, 300);
        FuelRegistry.INSTANCE.add(ASPEN_STAIRS, 300);
        FuelRegistry.INSTANCE.add(ASPEN_BUTTON, 300);
        FuelRegistry.INSTANCE.add(ASPEN_PRESSURE_PLATE, 300);
        FuelRegistry.INSTANCE.add(ASPEN_DOOR, 300);
        FuelRegistry.INSTANCE.add(ASPEN_TRAPDOOR, 300);
        FuelRegistry.INSTANCE.add(ASPEN_SIGN_ITEM, 200);
        FuelRegistry.INSTANCE.add(ASPEN_HANGING_SIGN_ITEM, 200);
        FuelRegistry.INSTANCE.add(ASPEN_SLAB, 150);
    }

    public static void registerStrippables() {
        StrippableBlockRegistry.register(ASPEN_LOG, STRIPPED_ASPEN_LOG);
        StrippableBlockRegistry.register(ASPEN_WOOD, STRIPPED_ASPEN_WOOD);
    }

    public static void registerFlammables() {
        FireBlock fireBlock = (FireBlock) Blocks.FIRE;
        fireBlock.setFlammable(ASPEN_LOG, 5, 5);
        fireBlock.setFlammable(STRIPPED_ASPEN_LOG, 5, 5);
        fireBlock.setFlammable(ASPEN_WOOD, 5, 5);
        fireBlock.setFlammable(STRIPPED_ASPEN_WOOD, 5, 5);
        fireBlock.setFlammable(ASPEN_PLANKS, 5, 20);
        fireBlock.setFlammable(ASPEN_SLAB, 5, 20);
        fireBlock.setFlammable(ASPEN_STAIRS, 5, 20);
        fireBlock.setFlammable(ASPEN_FENCE, 5, 20);
        fireBlock.setFlammable(ASPEN_FENCE_GATE, 5, 20);
        fireBlock.setFlammable(ASPEN_LEAVES, 30, 60);
        fireBlock.setFlammable(ASPEN_SAPLING, 30, 60);
        fireBlock.setFlammable(ASPEN_SIGN, 20, 5);
        fireBlock.setFlammable(ASPEN_WALL_SIGN, 20, 5);
        fireBlock.setFlammable(ASPEN_HANGING_SIGN, 20, 5);
        fireBlock.setFlammable(ASPEN_WALL_HANGING_SIGN, 20, 5);
    }

    private static void addToBlockEntityTypes() {
        try {
            Field targetField = null;
            for (Field field : BlockEntityType.class.getDeclaredFields()) {
                if (Set.class.isAssignableFrom(field.getType())) {
                    targetField = field;
                    break;
                }
            }
            if (targetField == null) return;

            targetField.setAccessible(true);

            injectToSet(targetField, BlockEntityType.SIGN, ASPEN_SIGN, ASPEN_WALL_SIGN);
            injectToSet(targetField, BlockEntityType.HANGING_SIGN, ASPEN_HANGING_SIGN, ASPEN_WALL_HANGING_SIGN);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void injectToSet(Field field, BlockEntityType<?> type, Block... blocks) throws IllegalAccessException {
        Set<Block> currentSet = (Set<Block>) field.get(type);
        try {
            for (Block b : blocks) currentSet.add(b);
        } catch (UnsupportedOperationException e) {
            Set<Block> newSet = new HashSet<>(currentSet);
            for (Block b : blocks) newSet.add(b);
            field.set(type, newSet);
        }
    }
}