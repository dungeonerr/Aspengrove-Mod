package dngnrr.aspengrove.classes;

import dngnrr.aspengrove.AspenGrove;

import java.util.function.Function;
import java.lang.reflect.Field;
import java.util.Set;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.sounds.AmbientLeavesBlockSoundPlayer;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.block.entity.*;

public class AspenGroveBlocks {
    public static void initialize() {
        addToBlockEntityTypes();
    }

    private static Block register(String name,Function<BlockBehaviour.Properties, Block> blockFactory,BlockBehaviour.Properties settings) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.setId(blockKey));
        return Registry.register(BuiltInRegistries.BLOCK,blockKey,block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK,Identifier.fromNamespaceAndPath(AspenGrove.MOD_ID,name));
    }

    public static final Block ASPEN_LOG = register(
            "aspen_log",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .sound(SoundType.WOOD)
                    .strength(2.0F)
                    .ignitedByLava()
                    .instrument(NoteBlockInstrument.BASS)
    );

    public static final Block STRIPPED_ASPEN_LOG = register(
            "stripped_aspen_log",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .sound(SoundType.WOOD)
                    .strength(2.0F)
                    .ignitedByLava()
                    .instrument(NoteBlockInstrument.BASS)
    );

    public static final Block ASPEN_WOOD = register(
            "aspen_wood",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .sound(SoundType.WOOD)
                    .strength(2.0F)
                    .ignitedByLava()
                    .instrument(NoteBlockInstrument.BASS)
    );

    public static final Block STRIPPED_ASPEN_WOOD = register(
            "stripped_aspen_wood",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .sound(SoundType.WOOD)
                    .strength(2.0F)
                    .ignitedByLava()
                    .instrument(NoteBlockInstrument.BASS)
    );

    public static final Block ASPEN_PLANKS = register(
            "aspen_planks",
            Block::new,
            BlockBehaviour.Properties.of()
                    .mapColor(AspenGroveColors.ASPEN_PLANKS)
                    .sound(SoundType.WOOD)
                    .strength(2.0F)
                    .ignitedByLava()
                    .instrument(NoteBlockInstrument.BASS)
    );

    public static final Block ASPEN_SLAB = register(
            "aspen_slab",
            SlabBlock::new,
            BlockBehaviour.Properties
                    .ofFullCopy(AspenGroveBlocks.ASPEN_PLANKS)
    );

    public static final Block ASPEN_STAIRS = register(
            "aspen_stairs",
            (settings) -> new StairBlock(ASPEN_PLANKS.defaultBlockState(),settings),
            BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS)
    );

    public static final Block ASPEN_FENCE = register(
            "aspen_fence",
            FenceBlock::new,
            BlockBehaviour.Properties
                    .ofFullCopy(AspenGroveBlocks.ASPEN_PLANKS)
    );

    public static final Block ASPEN_FENCE_GATE = register(
            "aspen_fence_gate",
            (settings) -> new FenceGateBlock(WoodType.OAK,settings),
            BlockBehaviour.Properties
                    .ofFullCopy(AspenGroveBlocks.ASPEN_PLANKS)
                    .noOcclusion()
    );

    public static final Block ASPEN_PRESSURE_PLATE = register(
            "aspen_pressure_plate",
            (settings) -> new PressurePlateBlock(WoodType.OAK.setType(),settings),
            BlockBehaviour.Properties
                    .ofFullCopy(AspenGroveBlocks.ASPEN_PLANKS)
                    .noCollision()
                    .strength(0.5f)
    );

    public static final Block ASPEN_BUTTON = register(
            "aspen_button",
            (settings) -> new ButtonBlock(BlockSetType.OAK,30,settings),
            BlockBehaviour.Properties
                    .ofFullCopy(AspenGroveBlocks.ASPEN_PLANKS)
                    .noCollision()
                    .strength(0.5f)
    );

    public static final Block ASPEN_DOOR = register(
            "aspen_door",
            (settings) -> new DoorBlock(BlockSetType.OAK,settings),
            BlockBehaviour.Properties
                    .ofFullCopy(AspenGroveBlocks.ASPEN_PLANKS)
                    .isSuffocating((state,world,pos) -> false)
                    .isViewBlocking((state,world,pos, aabb) -> false)
                    .noOcclusion()
    );

    public static final Block ASPEN_TRAPDOOR = register(
            "aspen_trapdoor",
            (settings) -> new TrapDoorBlock(BlockSetType.OAK,settings),
            BlockBehaviour.Properties
                    .ofFullCopy(AspenGroveBlocks.ASPEN_PLANKS)
                    .isSuffocating((state,world,pos) -> false)
                    .isViewBlocking((state,world,pos, aabb) -> false)
                    .noOcclusion()
    );

    public static final Block ASPEN_SIGN = Registry.register(
            BuiltInRegistries.BLOCK,
            Identifier.fromNamespaceAndPath(AspenGrove.MOD_ID, "aspen_sign"),
            new StandingSignBlock(AspenGroveWoodTypes.ASPEN, BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS)
                    .setId(keyOfBlock("aspen_sign"))
                    .forceSolidOn()
                    .noCollision()
                    .strength(1.0F)
            )
    );

    public static final Block ASPEN_WALL_SIGN = Registry.register(
            BuiltInRegistries.BLOCK,
            Identifier.fromNamespaceAndPath(AspenGrove.MOD_ID, "aspen_wall_sign"),
            new WallSignBlock(AspenGroveWoodTypes.ASPEN, BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS)
                    .setId(keyOfBlock("aspen_wall_sign"))
                    .forceSolidOn()
                    .noCollision()
                    .strength(1.0F)
            )
    );

    public static final Block ASPEN_HANGING_SIGN = Registry.register(
            BuiltInRegistries.BLOCK,
            Identifier.fromNamespaceAndPath(AspenGrove.MOD_ID, "aspen_hanging_sign"),
            new CeilingHangingSignBlock(AspenGroveWoodTypes.ASPEN, BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS)
                    .setId(keyOfBlock("aspen_hanging_sign"))
                    .forceSolidOn()
                    .noCollision()
                    .strength(1.0F)
            )
    );

    public static final Block ASPEN_WALL_HANGING_SIGN = Registry.register(
            BuiltInRegistries.BLOCK,
            Identifier.fromNamespaceAndPath(AspenGrove.MOD_ID, "aspen_wall_hanging_sign"),
            new WallHangingSignBlock(AspenGroveWoodTypes.ASPEN, BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS)
                    .setId(keyOfBlock("aspen_wall_hanging_sign"))
                    .forceSolidOn()
                    .noCollision()
                    .strength(1.0F)
            )
    );

    public static final Block ASPEN_SHELF = register(
            "aspen_shelf",
            ShelfBlock::new,
            BlockBehaviour.Properties
                    .ofFullCopy(AspenGroveBlocks.ASPEN_PLANKS)
                    .sound(SoundType.SHELF)
    );

    public static final Block ASPEN_LEAVES = register(
            "aspen_leaves",
            (properties) -> new AspenGroveLeavesBlock(AmbientLeavesBlockSoundPlayer.noAmbientSound(), properties),
            BlockBehaviour.Properties.of()
                    .mapColor(AspenGroveColors.ASPEN_LEAVES)
                    .sound(SoundType.GRASS)
                    .strength(0.2f)
                    .isSuffocating((state,world,pos) -> false)
                    .isViewBlocking((state,world,pos, aabb) -> false)
                    .noOcclusion()
                    .randomTicks()
                    .ignitedByLava()
    );

    public static final Block ASPEN_SAPLING = register(
            "aspen_sapling",
            (settings) -> new SaplingBlock(AspenGroveTreeGrowers.ASPEN, settings),
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollision()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .noOcclusion()
                    .ignitedByLava()
    );

    public static final Block POTTED_ASPEN_SAPLING = register(
            "potted_aspen_sapling",
            (properties) -> new FlowerPotBlock(ASPEN_SAPLING, properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)
                    .mapColor(MapColor.GRASS)
    );

    public static final Block HONEYFLOWER = register(
            "honeyflower",
            (properties) -> new FlowerBlock(MobEffects.HEALTH_BOOST, 10, properties),
            BlockBehaviour.Properties
                    .ofFullCopy(Blocks.POPPY)
    );

    public static final Block POTTED_HONEYFLOWER = register(
            "potted_honeyflower",
            (properties) -> new FlowerPotBlock(HONEYFLOWER, properties),
            BlockBehaviour.Properties
                    .ofFullCopy(Blocks.POTTED_POPPY)
    );

    public static final Block ORANGE_MUSHROOM = register(
            "orange_mushroom",
            (properties) -> new AspenGroveMushroomBlock(AspenGroveTreeGrowers.HUGE_ORANGE_MUSHROOM_SELECTOR, properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM)
                    .mapColor(MapColor.COLOR_ORANGE)
    );

    public static final Block POTTED_ORANGE_MUSHROOM = register(
            "potted_orange_mushroom",
            (properties) -> new FlowerPotBlock(ORANGE_MUSHROOM, properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM)
                    .mapColor(MapColor.COLOR_ORANGE)
    );

    public static final Block ORANGE_MUSHROOM_BLOCK = register(
            "orange_mushroom_block",
            HugeMushroomBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)
                    .mapColor(MapColor.COLOR_ORANGE)
    );

    private static void addToBlockEntityTypes() {
        try {
            Field targetField = null;
            for (Field field : BlockEntityType.class.getDeclaredFields()) {
                if (Set.class.isAssignableFrom(field.getType())) {
                    java.lang.reflect.Type genericType = field.getGenericType();
                    if (genericType instanceof java.lang.reflect.ParameterizedType pt) {
                        java.lang.reflect.Type[] actualTypes = pt.getActualTypeArguments();
                        if (actualTypes.length == 1 && actualTypes[0] == Block.class) {
                            targetField = field;
                            break;
                        }
                    }
                }
            }
            if (targetField == null) {
                System.err.println("[AspenGrove] CRITICAL: Could not find Set<Block> field in BlockEntityType");
                return;
            }
            targetField.setAccessible(true);
            Set<Block> signBlocks = (Set<Block>) targetField.get(BlockEntityTypes.SIGN);
            boolean modified = false;
            try {
                modified = signBlocks.add(ASPEN_SIGN) | signBlocks.add(ASPEN_WALL_SIGN);
            } catch (UnsupportedOperationException e) {

                Set<Block> newSignBlocks = new java.util.HashSet<>(signBlocks);
                newSignBlocks.add(ASPEN_SIGN);
                newSignBlocks.add(ASPEN_WALL_SIGN);
                targetField.set(BlockEntityTypes.SIGN, newSignBlocks);
                modified = true;
            }
            if (modified) {
                System.out.println("[AspenGrove] Successfully added signs to BlockEntityType.SIGN");
            }
            Set<Block> hangingSignBlocks = (Set<Block>) targetField.get(BlockEntityTypes.HANGING_SIGN);
            modified = false;
            try {
                modified = hangingSignBlocks.add(ASPEN_HANGING_SIGN) | hangingSignBlocks.add(ASPEN_WALL_HANGING_SIGN);
            } catch (UnsupportedOperationException e) {
                Set<Block> newHangingSignBlocks = new java.util.HashSet<>(hangingSignBlocks);
                newHangingSignBlocks.add(ASPEN_HANGING_SIGN);
                newHangingSignBlocks.add(ASPEN_WALL_HANGING_SIGN);
                targetField.set(BlockEntityTypes.HANGING_SIGN, newHangingSignBlocks);
                modified = true;
            }
            if (modified) {
                System.out.println("[AspenGrove] Successfully added hanging signs to BlockEntityType.HANGING_SIGN");
            }
            Set<Block> shelfBlocks = (Set<Block>) targetField.get(BlockEntityTypes.SHELF);
            modified = false;
            try {
                modified = shelfBlocks.add(ASPEN_SHELF);
            } catch (UnsupportedOperationException e) {
                Set<Block> newShelfBlocks = new java.util.HashSet<>(shelfBlocks);
                newShelfBlocks.add(ASPEN_SHELF);
                targetField.set(BlockEntityTypes.SHELF, newShelfBlocks);
                modified = true;
            }
            if (modified) {
                System.out.println("[AspenGrove] Successfully added shelves to BlockEntityType.SHELF");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}