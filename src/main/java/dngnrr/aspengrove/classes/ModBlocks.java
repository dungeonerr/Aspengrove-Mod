package dngnrr.aspengrove.classes;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import dngnrr.aspengrove.Aspengrove;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.resources.Identifier;

import java.util.function.Function;

public class ModBlocks {

    private static class AspenLeavesBlock extends LeavesBlock {
        public static final MapCodec<AspenLeavesBlock> CODEC = simpleCodec(AspenLeavesBlock::new);

        public AspenLeavesBlock(BlockBehaviour.Properties properties) {
            super(0.05f, properties);
        }

        @Override
        public MapCodec<? extends LeavesBlock> codec() {
            return CODEC;
        }

        @Override
        public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
            super.animateTick(state, level, pos, random);

            if (random.nextFloat() < 0.05f) {

                int count = 1 + random.nextInt(1);

                for (int i = 0; i < count; i++) {
                    double x = pos.getX() + random.nextDouble();
                    double y = pos.getY() - 0.1 - random.nextDouble() * 0.3;
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
        protected void spawnFallingLeavesParticle(Level level,BlockPos blockPos,RandomSource randomSource) {

        }
    }

    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.setId(blockKey));
        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);
            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }
        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Aspengrove.MOD_ID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Aspengrove.MOD_ID, name));
    }

    public static final Block ASPEN_LOG = register(
            "aspen_log",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(2.0F),
            true
    );

    public static final Block STRIPPED_ASPEN_LOG = register(
            "stripped_aspen_log",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(2.0F),
            true
    );

    public static final Block ASPEN_WOOD = register(
            "aspen_wood",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(2.0F),
            true
    );

    public static final Block STRIPPED_ASPEN_WOOD = register(
            "stripped_aspen_wood",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(2.0F),
            true
    );

    public static final Block ASPEN_PLANKS = register(
            "aspen_planks",
            Block::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOD)
                    .sound(SoundType.WOOD)
                    .strength(2.0F),
            true
    );

    public static final Block ASPEN_SLAB = register(
            "aspen_slab",
            SlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOD)
                    .sound(SoundType.WOOD)
                    .strength(2.0F),
            true
    );

    public static final Block ASPEN_STAIRS = register(
            "aspen_stairs",
            (settings) -> new StairBlock(ASPEN_PLANKS.defaultBlockState(), settings),
            BlockBehaviour.Properties.ofFullCopy(ASPEN_PLANKS),
            true
    );

    public static final Block ASPEN_FENCE = register(
            "aspen_fence",
            FenceBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOD)
                    .sound(SoundType.WOOD)
                    .strength(2.0F),
            true
    );

    public static final Block ASPEN_FENCE_GATE = register(
            "aspen_fence_gate",
            (settings) -> new FenceGateBlock(WoodType.OAK, settings),
            BlockBehaviour.Properties.ofFullCopy(ModBlocks.ASPEN_PLANKS)
                    .noOcclusion(),
            true
    );

    public static final Block ASPEN_PRESSURE_PLATE = register(
            "aspen_pressure_plate",
            (settings) -> new PressurePlateBlock(WoodType.OAK.setType(), settings),
            BlockBehaviour.Properties
                    .ofFullCopy(ModBlocks.ASPEN_PLANKS)
                    .noCollision()
                    .strength(0.5f),
            true
    );

    public static final Block ASPEN_BUTTON = register(
            "aspen_button",
            (settings) -> new ButtonBlock(BlockSetType.OAK, 30, settings),
            BlockBehaviour.Properties.ofFullCopy(ModBlocks.ASPEN_PLANKS)
                    .noCollision()
                    .strength(0.5f),
            true
    );

    public static final Block ASPEN_LEAVES = register(
            "aspen_leaves",
            AspenLeavesBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.GRASS)
                    .sound(SoundType.GRASS)
                    .strength(0.2f)
                    .isSuffocating((state, world, pos) -> false)
                    .isViewBlocking((state, world, pos) -> false)
                    .pushReaction(PushReaction.DESTROY)
                    .noOcclusion()
                    .randomTicks(),
            true
    );

    public static void registerFuels() {
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(ASPEN_PLANKS, 300);
            builder.add(ASPEN_LOG, 300);
            builder.add(STRIPPED_ASPEN_LOG, 300);
            builder.add(ASPEN_WOOD, 300);
            builder.add(STRIPPED_ASPEN_WOOD, 300);
            builder.add(ASPEN_FENCE, 300);
            builder.add(ASPEN_FENCE_GATE, 300);
            builder.add(ASPEN_STAIRS, 300);
            builder.add(ASPEN_SLAB, 150);
        });
    }

    public static void registerStrippables() {
        StrippableBlockRegistry.register(ASPEN_LOG, STRIPPED_ASPEN_LOG);
        StrippableBlockRegistry.register(ASPEN_WOOD, STRIPPED_ASPEN_WOOD);
    }

    public static void initialize() {
    }
}