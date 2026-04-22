package dngnrr.aspengrove.classes;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import dngnrr.aspengrove.Aspengrove;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Set;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Aspengrove.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Aspengrove.MOD_ID);

    public static void initialize(IEventBus bus) {
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }

    private static class AspenLeavesBlock extends LeavesBlock {
        public static final MapCodec<AspenLeavesBlock> CODEC = simpleCodec(AspenLeavesBlock::new);
        public AspenLeavesBlock(BlockBehaviour.Properties properties) {
            super(0.05f,properties);
        }

        @Override
        public MapCodec<? extends LeavesBlock> codec() {
            return CODEC;
        }

        @Override
        public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
            super.animateTick(state, level, pos, random);
            if (random.nextFloat() < 0.05f) {
                BlockPos blockPos = pos.below();
                BlockState blockState = level.getBlockState(blockPos);
                if (blockState.isFaceSturdy(level, blockPos, Direction.UP)) {
                    return;
                }

                int count = 1 + random.nextInt(1);
                for (int i = 0; i < count; i++) {
                    double x = pos.getX() + random.nextDouble();
                    double y = pos.getY() - 0.1;
                    double z = pos.getZ() + random.nextDouble();
                    double xSpeed = (random.nextDouble() - 0.5) * 0.02;
                    double ySpeed = -0.04 - random.nextDouble() * 0.03;
                    double zSpeed = (random.nextDouble() - 0.5) * 0.02;
                    float[] color = new float[]{1.0F, 0.84F, 0.0F};
                    level.addParticle(
                            ColorParticleOption.create(ParticleTypes.TINTED_LEAVES, color[0], color[1], color[2]),
                            x, y, z,
                            xSpeed, ySpeed, zSpeed
                    );
                }
            }
        }

        @Override
        protected void spawnFallingLeavesParticle(Level level, BlockPos blockPos, RandomSource randomSource) {
        }
    }

    public static final DeferredBlock<RotatedPillarBlock> ASPEN_LOG = BLOCKS.registerBlock(
            "aspen_log",
            RotatedPillarBlock::new,
            p -> p
                    .mapColor(MapColor.SAND)
                    .sound(SoundType.WOOD)
                    .strength(2.0F)
                    .ignitedByLava()
                    .instrument(NoteBlockInstrument.BASS)
    );
    public static final DeferredItem<BlockItem> ASPEN_LOG_ITEM =
            ITEMS.registerSimpleBlockItem("aspen_log", ASPEN_LOG);

    public static final DeferredBlock<RotatedPillarBlock> STRIPPED_ASPEN_LOG = BLOCKS.registerBlock(
            "stripped_aspen_log",
            RotatedPillarBlock::new,
            p -> p
                    .mapColor(MapColor.SAND)
                    .sound(SoundType.WOOD)
                    .strength(2.0F)
                    .ignitedByLava()
                    .instrument(NoteBlockInstrument.BASS)
    );
    public static final DeferredItem<BlockItem> STRIPPED_ASPEN_LOG_ITEM =
            ITEMS.registerSimpleBlockItem("stripped_aspen_log", STRIPPED_ASPEN_LOG);

    public static final DeferredBlock<RotatedPillarBlock> ASPEN_WOOD = BLOCKS.registerBlock(
            "aspen_wood",
            RotatedPillarBlock::new,
            p -> p
                    .mapColor(MapColor.SAND)
                    .sound(SoundType.WOOD)
                    .strength(2.0F)
                    .ignitedByLava()
                    .instrument(NoteBlockInstrument.BASS)
    );
    public static final DeferredItem<BlockItem> ASPEN_WOOD_ITEM =
            ITEMS.registerSimpleBlockItem("aspen_wood", ASPEN_WOOD);

    public static final DeferredBlock<RotatedPillarBlock> STRIPPED_ASPEN_WOOD = BLOCKS.registerBlock(
            "stripped_aspen_wood",
            RotatedPillarBlock::new,
            p -> p
                    .mapColor(MapColor.SAND)
                    .sound(SoundType.WOOD)
                    .strength(2.0F)
                    .ignitedByLava()
                    .instrument(NoteBlockInstrument.BASS)
    );
    public static final DeferredItem<BlockItem> STRIPPED_ASPEN_WOOD_ITEM =
            ITEMS.registerSimpleBlockItem("stripped_aspen_wood", STRIPPED_ASPEN_WOOD);

    public static final DeferredBlock<Block> ASPEN_PLANKS = BLOCKS.registerBlock(
            "aspen_planks",
            Block::new,
            p -> p
                    .mapColor(ModColors.ASPEN_PLANKS)
                    .sound(SoundType.WOOD)
                    .strength(2.0F)
                    .ignitedByLava()
                    .instrument(NoteBlockInstrument.BASS)
    );
    public static final DeferredItem<BlockItem> ASPEN_PLANKS_ITEM =
            ITEMS.registerSimpleBlockItem("aspen_planks", ASPEN_PLANKS);

    public static final DeferredBlock<SlabBlock> ASPEN_SLAB = BLOCKS.registerBlock(
            "aspen_slab",
            SlabBlock::new,
            p -> BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS.get())
    );
    public static final DeferredItem<BlockItem> ASPEN_SLAB_ITEM =
            ITEMS.registerSimpleBlockItem("aspen_slab", ASPEN_SLAB);

    public static final DeferredBlock<StairBlock> ASPEN_STAIRS = BLOCKS.registerBlock(
            "aspen_stairs",
            (p) -> new StairBlock(ASPEN_PLANKS.get().defaultBlockState(), p),
            p -> BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS.get())
    );
    public static final DeferredItem<BlockItem> ASPEN_STAIRS_ITEM =
            ITEMS.registerSimpleBlockItem("aspen_stairs", ASPEN_STAIRS);

    public static final DeferredBlock<FenceBlock> ASPEN_FENCE = BLOCKS.registerBlock(
            "aspen_fence",
            FenceBlock::new,
            p -> BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS.get())
    );
    public static final DeferredItem<BlockItem> ASPEN_FENCE_ITEM =
            ITEMS.registerSimpleBlockItem("aspen_fence", ASPEN_FENCE);

    public static final DeferredBlock<FenceGateBlock> ASPEN_FENCE_GATE = BLOCKS.registerBlock(
            "aspen_fence_gate",
            (p) -> new FenceGateBlock(WoodType.OAK, p),
            p -> BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS.get())
                    .noOcclusion()
    );
    public static final DeferredItem<BlockItem> ASPEN_FENCE_GATE_ITEM =
            ITEMS.registerSimpleBlockItem("aspen_fence_gate", ASPEN_FENCE_GATE);

    public static final DeferredBlock<PressurePlateBlock> ASPEN_PRESSURE_PLATE = BLOCKS.registerBlock(
            "aspen_pressure_plate",
            (p) -> new PressurePlateBlock(BlockSetType.OAK, p),
            p -> BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS.get())
                    .noCollision()
                    .strength(0.5f)
    );
    public static final DeferredItem<BlockItem> ASPEN_PRESSURE_PLATE_ITEM =
            ITEMS.registerSimpleBlockItem("aspen_pressure_plate", ASPEN_PRESSURE_PLATE);

    public static final DeferredBlock<ButtonBlock> ASPEN_BUTTON = BLOCKS.registerBlock(
            "aspen_button",
            (p) -> new ButtonBlock(BlockSetType.OAK, 30, p),
            p -> BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS.get())
                    .noCollision()
                    .strength(0.5f)
    );
    public static final DeferredItem<BlockItem> ASPEN_BUTTON_ITEM =
            ITEMS.registerSimpleBlockItem("aspen_button", ASPEN_BUTTON);

    public static final DeferredBlock<DoorBlock> ASPEN_DOOR = BLOCKS.registerBlock(
            "aspen_door",
            (p) -> new DoorBlock(BlockSetType.OAK, p),
            p -> BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS.get())
                    .isSuffocating((s, w, pos) -> false)
                    .isViewBlocking((s, w, pos) -> false)
                    .noOcclusion()
    );
    public static final DeferredItem<BlockItem> ASPEN_DOOR_ITEM =
            ITEMS.registerSimpleBlockItem("aspen_door", ASPEN_DOOR);

    public static final DeferredBlock<TrapDoorBlock> ASPEN_TRAPDOOR = BLOCKS.registerBlock(
            "aspen_trapdoor",
            (p) -> new TrapDoorBlock(BlockSetType.OAK, p),
            p -> BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS.get())
                    .isSuffocating((s, w, pos) -> false)
                    .isViewBlocking((s, w, pos) -> false)
                    .noOcclusion()
    );
    public static final DeferredItem<BlockItem> ASPEN_TRAPDOOR_ITEM =
            ITEMS.registerSimpleBlockItem("aspen_trapdoor", ASPEN_TRAPDOOR);

    public static final DeferredBlock<StandingSignBlock> ASPEN_SIGN = BLOCKS.registerBlock(
            "aspen_sign",
            (p) -> new StandingSignBlock(ModWoodTypes.ASPEN, p),
            p -> BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS.get())
                    .forceSolidOn()
                    .noCollision()
                    .strength(1.0F)
    );

    public static final DeferredBlock<WallSignBlock> ASPEN_WALL_SIGN = BLOCKS.registerBlock(
            "aspen_wall_sign",
            (p) -> new WallSignBlock(ModWoodTypes.ASPEN, p),
            p -> BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS.get())
                    .forceSolidOn()
                    .noCollision()
                    .strength(1.0F)
    );

    public static final DeferredItem<SignItem> ASPEN_SIGN_ITEM = ITEMS.registerItem(
            "aspen_sign",
            (p) -> new SignItem(ASPEN_SIGN.get(), ASPEN_WALL_SIGN.get(), p),
            p -> p
                    .stacksTo(16)
    );

    public static final DeferredBlock<CeilingHangingSignBlock> ASPEN_HANGING_SIGN = BLOCKS.registerBlock(
            "aspen_hanging_sign",
            (p) -> new CeilingHangingSignBlock(ModWoodTypes.ASPEN, p),
            p -> BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS.get())
                    .forceSolidOn()
                    .noCollision()
                    .strength(1.0F)
    );

    public static final DeferredBlock<WallHangingSignBlock> ASPEN_WALL_HANGING_SIGN = BLOCKS.registerBlock(
            "aspen_wall_hanging_sign",
            (p) -> new WallHangingSignBlock(ModWoodTypes.ASPEN, p),
            p -> BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS.get())
                    .forceSolidOn()
                    .noCollision()
                    .strength(1.0F)
    );

    public static final DeferredItem<HangingSignItem> ASPEN_HANGING_SIGN_ITEM = ITEMS.registerItem(
            "aspen_hanging_sign",
            (p) -> new HangingSignItem(ASPEN_HANGING_SIGN.get(), ASPEN_WALL_HANGING_SIGN.get(), p),
            p -> p
                    .stacksTo(16)
    );

    public static final DeferredBlock<ShelfBlock> ASPEN_SHELF = BLOCKS.registerBlock(
            "aspen_shelf",
            ShelfBlock::new,
            p -> BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS.get())
                    .sound(SoundType.SHELF)
    );
    public static final DeferredItem<BlockItem> ASPEN_SHELF_ITEM =
            ITEMS.registerSimpleBlockItem("aspen_shelf", ASPEN_SHELF);

    public static final DeferredBlock<AspenLeavesBlock> ASPEN_LEAVES = BLOCKS.registerBlock(
            "aspen_leaves",
            AspenLeavesBlock::new,
            p -> p
                    .mapColor(ModColors.ASPEN_LEAVES)
                    .sound(SoundType.GRASS)
                    .strength(0.2f)
                    .isSuffocating((s,w,pos) -> false)
                    .isViewBlocking((s,w,pos) -> false)
                    .pushReaction(PushReaction.DESTROY)
                    .noOcclusion()
                    .randomTicks()
                    .ignitedByLava()
    );
    public static final DeferredItem<BlockItem> ASPEN_LEAVES_ITEM =
            ITEMS.registerSimpleBlockItem("aspen_leaves", ASPEN_LEAVES);

    public static final DeferredBlock<SaplingBlock> ASPEN_SAPLING = BLOCKS.registerBlock(
            "aspen_sapling",
            (p) -> new SaplingBlock(ModTreeGrowers.ASPEN, p),
            p -> p.mapColor(MapColor.PLANT)
                    .noCollision()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)
                    .noOcclusion()
                    .ignitedByLava()
    );
    public static final DeferredItem<BlockItem> ASPEN_SAPLING_ITEM =
            ITEMS.registerSimpleBlockItem("aspen_sapling", ASPEN_SAPLING);

    public static final DeferredBlock<FlowerPotBlock> POTTED_ASPEN_SAPLING = BLOCKS.registerBlock(
            "potted_aspen_sapling",
            (p) -> new FlowerPotBlock(ASPEN_SAPLING.get(), p),
            p -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.POTTED_OAK_SAPLING)
                    .mapColor(MapColor.GRASS)
    );

    public static final DeferredBlock<FlowerBlock> HONEYFLOWER = BLOCKS.registerBlock(
            "honeyflower",
            (p) -> new FlowerBlock(MobEffects.HEALTH_BOOST, 10, p),
            p -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.POPPY)
    );
    public static final DeferredItem<BlockItem> HONEYFLOWER_ITEM =
            ITEMS.registerSimpleBlockItem("honeyflower", HONEYFLOWER);

    public static final DeferredBlock<FlowerPotBlock> POTTED_HONEYFLOWER = BLOCKS.registerBlock(
            "potted_honeyflower",
            (p) -> new FlowerPotBlock(HONEYFLOWER.get(), p),
            p -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.POTTED_POPPY)
    );

    public static final DeferredBlock<ModMushroomBlock> ORANGE_MUSHROOM = BLOCKS.registerBlock(
            "orange_mushroom",
            (p) -> new ModMushroomBlock(ModTreeGrowers.HUGE_ORANGE_MUSHROOM_SELECTOR, p),
            p -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.RED_MUSHROOM)
                    .mapColor(MapColor.COLOR_ORANGE)
    );
    public static final DeferredItem<BlockItem> ORANGE_MUSHROOM_ITEM =
            ITEMS.registerSimpleBlockItem("orange_mushroom", ORANGE_MUSHROOM);

    public static final DeferredBlock<FlowerPotBlock> POTTED_ORANGE_MUSHROOM = BLOCKS.registerBlock(
            "potted_orange_mushroom",
            (p) -> new FlowerPotBlock(ORANGE_MUSHROOM.get(), p),
            p -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.POTTED_RED_MUSHROOM)
                    .mapColor(MapColor.COLOR_ORANGE)
    );

    public static final DeferredBlock<HugeMushroomBlock> ORANGE_MUSHROOM_BLOCK = BLOCKS.registerBlock(
            "orange_mushroom_block",
            HugeMushroomBlock::new,
            p -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)
                    .mapColor(MapColor.COLOR_ORANGE)
    );
    public static final DeferredItem<BlockItem> ORANGE_MUSHROOM_BLOCK_ITEM =
            ITEMS.registerSimpleBlockItem("orange_mushroom_block", ORANGE_MUSHROOM_BLOCK);

    public static void addToBlockEntityTypes() {
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
            if (targetField == null) return;
            targetField.setAccessible(true);

            updateBlockEntitySet(targetField, BlockEntityType.SIGN, ASPEN_SIGN.get(), ASPEN_WALL_SIGN.get());
            updateBlockEntitySet(targetField, BlockEntityType.HANGING_SIGN, ASPEN_HANGING_SIGN.get(), ASPEN_WALL_HANGING_SIGN.get());
            updateBlockEntitySet(targetField, BlockEntityType.SHELF, ASPEN_SHELF.get());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateBlockEntitySet(Field field, BlockEntityType<?> type, Block... blocks) throws IllegalAccessException {
        Set<Block> set = (Set<Block>) field.get(type);
        try {
            Collections.addAll(set, blocks);
        } catch (UnsupportedOperationException e) {
            Set<Block> newSet = new java.util.HashSet<>(set);
            Collections.addAll(newSet, blocks);
            field.set(type, newSet);
        }
    }
}