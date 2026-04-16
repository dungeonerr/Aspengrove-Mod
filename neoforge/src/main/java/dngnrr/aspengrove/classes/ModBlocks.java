package dngnrr.aspengrove.classes;

import dngnrr.aspengrove.Aspengrove;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
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

    public static Block ASPEN_LOG;
    public static Block STRIPPED_ASPEN_LOG;
    public static Block ASPEN_WOOD;
    public static Block STRIPPED_ASPEN_WOOD;
    public static Block ASPEN_PLANKS;
    public static Block ASPEN_SLAB;
    public static Block ASPEN_STAIRS;
    public static Block ASPEN_FENCE;
    public static Block ASPEN_FENCE_GATE;
    public static Block ASPEN_PRESSURE_PLATE;
    public static Block ASPEN_BUTTON;
    public static Block ASPEN_DOOR;
    public static Block ASPEN_TRAPDOOR;
    public static Block ASPEN_SIGN;
    public static Block ASPEN_WALL_SIGN;
    public static Item ASPEN_SIGN_ITEM;
    public static Block ASPEN_HANGING_SIGN;
    public static Block ASPEN_WALL_HANGING_SIGN;
    public static Item ASPEN_HANGING_SIGN_ITEM;
    public static Block ASPEN_LEAVES;
    public static Block ASPEN_SAPLING;
    public static Block POTTED_ASPEN_SAPLING;
    public static Block HONEYFLOWER;
    public static Block POTTED_HONEYFLOWER;
    public static Block ORANGE_MUSHROOM;
    public static Block POTTED_ORANGE_MUSHROOM;
    public static Block ORANGE_MUSHROOM_BLOCK;

    public static void init() {
        ASPEN_LOG = register(
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

        STRIPPED_ASPEN_LOG = register(
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

        ASPEN_WOOD = register(
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

        STRIPPED_ASPEN_WOOD = register(
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

        ASPEN_PLANKS = register(
                "aspen_planks",
                Block::new,
                BlockBehaviour.Properties.of()
                        .mapColor(ModColors.ASPEN_PLANKS)
                        .sound(SoundType.WOOD)
                        .strength(2.0F)
                        .ignitedByLava()
                        .instrument(NoteBlockInstrument.BASS),
                true
        );

        ASPEN_SLAB = register(
                "aspen_slab",
                SlabBlock::new,
                BlockBehaviour.Properties
                        .ofFullCopy(ModBlocks.ASPEN_PLANKS),
                true
        );

        ASPEN_STAIRS = register(
                "aspen_stairs",
                (settings) -> new StairBlock(ASPEN_PLANKS.defaultBlockState(), settings),
                BlockBehaviour.Properties
                        .ofFullCopy(ASPEN_PLANKS),
                true
        );

        ASPEN_FENCE = register(
                "aspen_fence",
                FenceBlock::new,
                BlockBehaviour.Properties
                        .ofFullCopy(ModBlocks.ASPEN_PLANKS),
                true
        );

        ASPEN_FENCE_GATE = register(
                "aspen_fence_gate",
                (settings) -> new FenceGateBlock(WoodType.OAK, settings),
                BlockBehaviour.Properties
                        .ofFullCopy(ModBlocks.ASPEN_PLANKS)
                        .noOcclusion(),
                true
        );

        ASPEN_PRESSURE_PLATE = register(
                "aspen_pressure_plate",
                (settings) -> new PressurePlateBlock(BlockSetType.OAK, settings),
                BlockBehaviour.Properties
                        .ofFullCopy(ModBlocks.ASPEN_PLANKS)
                        .noCollission()
                        .strength(0.5f),
                true
        );

        ASPEN_BUTTON = register(
                "aspen_button",
                (settings) -> new ButtonBlock(BlockSetType.OAK, 30, settings),
                BlockBehaviour.Properties
                        .ofFullCopy(ModBlocks.ASPEN_PLANKS)
                        .noCollission()
                        .strength(0.5f),
                true
        );

        ASPEN_DOOR = register(
                "aspen_door",
                (settings) -> new DoorBlock(BlockSetType.OAK, settings),
                BlockBehaviour.Properties
                        .ofFullCopy(ModBlocks.ASPEN_PLANKS)
                        .ignitedByLava()
                        .noOcclusion(),
                true
        );

        ASPEN_TRAPDOOR = register(
                "aspen_trapdoor",
                (settings) -> new TrapDoorBlock(BlockSetType.OAK, settings),
                BlockBehaviour.Properties
                        .ofFullCopy(ModBlocks.ASPEN_PLANKS)
                        .ignitedByLava()
                        .noOcclusion(),
                true
        );

        ASPEN_SIGN = Registry.register(
                BuiltInRegistries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspen_sign"),
                new StandingSignBlock(ModWoodTypes.ASPEN, BlockBehaviour.Properties
                        .ofFullCopy(ASPEN_PLANKS)
                        .noCollission()
                        .strength(1.0F)
                )
        );

        ASPEN_WALL_SIGN = Registry.register(
                BuiltInRegistries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspen_wall_sign"),
                new WallSignBlock(ModWoodTypes.ASPEN, BlockBehaviour.Properties
                        .ofFullCopy(ASPEN_PLANKS)
                        .noCollission()
                        .strength(1.0F)
                        .dropsLike(ASPEN_SIGN)
                )
        );

        ASPEN_SIGN_ITEM = Registry.register(
                BuiltInRegistries.ITEM,
                ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspen_sign"),
                new SignItem(
                        new Item.Properties()
                                .stacksTo(16),
                        ASPEN_SIGN,
                        ASPEN_WALL_SIGN
                )
        );

        ASPEN_HANGING_SIGN = Registry.register(
                BuiltInRegistries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspen_hanging_sign"),
                new CeilingHangingSignBlock(ModWoodTypes.ASPEN, BlockBehaviour.Properties
                        .ofFullCopy(ASPEN_PLANKS)
                        .noCollission()
                        .strength(1.0F)
                )
        );

        ASPEN_WALL_HANGING_SIGN = Registry.register(
                BuiltInRegistries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspen_wall_hanging_sign"),
                new WallHangingSignBlock(ModWoodTypes.ASPEN, BlockBehaviour.Properties
                        .ofFullCopy(ASPEN_PLANKS)
                        .noCollission()
                        .strength(1.0F)
                        .dropsLike(ASPEN_HANGING_SIGN)
                )
        );

        ASPEN_HANGING_SIGN_ITEM = Registry.register(
                BuiltInRegistries.ITEM,
                ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspen_hanging_sign"),
                new HangingSignItem(
                        ASPEN_HANGING_SIGN,
                        ASPEN_WALL_HANGING_SIGN,
                        new Item.Properties()
                                .stacksTo(16)
                )
        );

        ASPEN_LEAVES = register(
                "aspen_leaves",
                LeavesBlock::new,
                BlockBehaviour.Properties.of()
                        .mapColor(ModColors.ASPEN_LEAVES)
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

        ASPEN_SAPLING = register(
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

        POTTED_ASPEN_SAPLING = register(
                "potted_aspen_sapling",
                (properties) -> new FlowerPotBlock(ASPEN_SAPLING, properties),
                BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)
                        .mapColor(MapColor.GRASS),
                false
        );

        HONEYFLOWER = register(
                "honeyflower",
                (properties) -> new FlowerBlock(MobEffects.HEALTH_BOOST, 10, properties),
                BlockBehaviour.Properties
                        .ofFullCopy(Blocks.POPPY),
                true
        );

        POTTED_HONEYFLOWER = register(
                "potted_honeyflower",
                (properties) -> new FlowerPotBlock(HONEYFLOWER, properties),
                BlockBehaviour.Properties
                        .ofFullCopy(Blocks.POTTED_POPPY),
                false
        );

        ORANGE_MUSHROOM = register(
                "orange_mushroom",
                (properties) -> new MushroomBlock(ModTreeGrowers.HUGE_ORANGE_MUSHROOM, properties),
                BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM)
                        .mapColor(MapColor.COLOR_ORANGE),
                true
        );

        POTTED_ORANGE_MUSHROOM = register(
                "potted_orange_mushroom",
                (properties) -> new FlowerPotBlock(ORANGE_MUSHROOM, properties),
                BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM)
                        .mapColor(MapColor.COLOR_ORANGE),
                false
        );

        ORANGE_MUSHROOM_BLOCK = register(
                "orange_mushroom_block",
                HugeMushroomBlock::new,
                BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)
                        .mapColor(MapColor.COLOR_ORANGE),
                true
        );

        addToBlockEntityTypes();
    }

    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, name);
        Block block = blockFactory.apply(settings);
        Registry.register(BuiltInRegistries.BLOCK, id, block);
        if (shouldRegisterItem) {
            Registry.register(BuiltInRegistries.ITEM, id, new BlockItem(block, new Item.Properties()));
        }
        return block;
    }

    private static void addToBlockEntityTypes() {

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

    public static void initialize() {
    }
}