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
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import dngnrr.aspengrove.Aspengrove;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.resources.Identifier;

import java.util.function.Function;
import java.lang.reflect.Field;
import java.util.Set;

public class ModBlocks {
    public static void initialize() {
        addToBlockEntityTypes();
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
                if (blockState.isFaceSturdy(level, blockPos, net.minecraft.core.Direction.UP)) {
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
        protected void spawnFallingLeavesParticle(Level level,BlockPos blockPos,RandomSource randomSource) {
        }
    }

    private static Block register(String name,Function<BlockBehaviour.Properties, Block> blockFactory,BlockBehaviour.Properties settings,boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.setId(blockKey));
        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);
            BlockItem blockItem = new BlockItem(block,new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM,itemKey,blockItem);
        }
        return Registry.register(BuiltInRegistries.BLOCK,blockKey,block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK,Identifier.fromNamespaceAndPath(Aspengrove.MOD_ID,name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM,Identifier.fromNamespaceAndPath(Aspengrove.MOD_ID,name));
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
                    .mapColor(ModColors.ASPEN_PLANKS)
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
            (settings) -> new StairBlock(ASPEN_PLANKS.defaultBlockState(),settings),
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
            (settings) -> new FenceGateBlock(WoodType.OAK,settings),
            BlockBehaviour.Properties
                    .ofFullCopy(ModBlocks.ASPEN_PLANKS)
                    .noOcclusion(),
            true
    );

    public static final Block ASPEN_PRESSURE_PLATE = register(
            "aspen_pressure_plate",
            (settings) -> new PressurePlateBlock(WoodType.OAK.setType(),settings),
            BlockBehaviour.Properties
                    .ofFullCopy(ModBlocks.ASPEN_PLANKS)
                    .noCollision()
                    .strength(0.5f),
            true
    );

    public static final Block ASPEN_BUTTON = register(
            "aspen_button",
            (settings) -> new ButtonBlock(BlockSetType.OAK,30,settings),
            BlockBehaviour.Properties
                    .ofFullCopy(ModBlocks.ASPEN_PLANKS)
                    .noCollision()
                    .strength(0.5f),
            true
    );

    public static final Block ASPEN_DOOR = register(
            "aspen_door",
            (settings) -> new DoorBlock(BlockSetType.OAK,settings),
            BlockBehaviour.Properties
                    .ofFullCopy(ModBlocks.ASPEN_PLANKS)
                    .isSuffocating((state,world,pos) -> false)
                    .isViewBlocking((state,world,pos) -> false)
                    .noOcclusion(),
            true
    );

    public static final Block ASPEN_TRAPDOOR = register(
            "aspen_trapdoor",
            (settings) -> new TrapDoorBlock(BlockSetType.OAK,settings),
            BlockBehaviour.Properties
                    .ofFullCopy(ModBlocks.ASPEN_PLANKS)
                    .isSuffocating((state,world,pos) -> false)
                    .isViewBlocking((state,world,pos) -> false)
                    .noOcclusion(),
            true
    );

    public static final Block ASPEN_SIGN = Registry.register(
            BuiltInRegistries.BLOCK,
            Identifier.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspen_sign"),
            new StandingSignBlock(ModWoodTypes.ASPEN, BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS)
                    .setId(keyOfBlock("aspen_sign"))
                    .forceSolidOn()
                    .noCollision()
                    .strength(1.0F)
            )
    );

    public static final Block ASPEN_WALL_SIGN = Registry.register(
            BuiltInRegistries.BLOCK,
            Identifier.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspen_wall_sign"),
            new WallSignBlock(ModWoodTypes.ASPEN, BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS)
                    .setId(keyOfBlock("aspen_wall_sign"))
                    .forceSolidOn()
                    .noCollision()
                    .strength(1.0F)
            )
    );
    public static final Item ASPEN_SIGN_ITEM = Registry.register(
            BuiltInRegistries.ITEM,
            Identifier.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspen_sign"),
            new SignItem(
                    ASPEN_SIGN,
                    ASPEN_WALL_SIGN,
                    new Item.Properties()
                            .stacksTo(16)
                            .setId(keyOfItem("aspen_sign")
                            )
            )
    );

    public static final Block ASPEN_HANGING_SIGN = Registry.register(
            BuiltInRegistries.BLOCK,
            Identifier.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspen_hanging_sign"),
            new CeilingHangingSignBlock(ModWoodTypes.ASPEN, BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS)
                    .setId(keyOfBlock("aspen_hanging_sign"))
                    .forceSolidOn()
                    .noCollision()
                    .strength(1.0F)
            )
    );

    public static final Block ASPEN_WALL_HANGING_SIGN = Registry.register(
            BuiltInRegistries.BLOCK,
            Identifier.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspen_wall_hanging_sign"),
            new WallHangingSignBlock(ModWoodTypes.ASPEN, BlockBehaviour.Properties
                    .ofFullCopy(ASPEN_PLANKS)
                    .setId(keyOfBlock("aspen_wall_hanging_sign"))
                    .forceSolidOn()
                    .noCollision()
                    .strength(1.0F)
            )
    );

    public static final Item ASPEN_HANGING_SIGN_ITEM = Registry.register(
            BuiltInRegistries.ITEM,
            Identifier.fromNamespaceAndPath(Aspengrove.MOD_ID, "aspen_hanging_sign"),
            new HangingSignItem(
                    ASPEN_HANGING_SIGN,
                    ASPEN_WALL_HANGING_SIGN,
                    new Item.Properties()
                            .stacksTo(16)
                            .setId(keyOfItem("aspen_hanging_sign"))
            )
    );

    public static final Block ASPEN_SHELF = register(
            "aspen_shelf",
            ShelfBlock::new,
            BlockBehaviour.Properties
                    .ofFullCopy(ModBlocks.ASPEN_PLANKS)
                    .sound(SoundType.SHELF),
            true
    );

    public static final Block ASPEN_LEAVES = register(
            "aspen_leaves",
            AspenLeavesBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(ModColors.ASPEN_LEAVES)
                    .sound(SoundType.GRASS)
                    .strength(0.2f)
                    .isSuffocating((state,world,pos) -> false)
                    .isViewBlocking((state,world,pos) -> false)
                    .pushReaction(PushReaction.DESTROY)
                    .noOcclusion()
                    .randomTicks()
                    .ignitedByLava(),
            true
    );

    public static final Block ASPEN_SAPLING = register(
            "aspen_sapling",
            (settings) -> new SaplingBlock(ModTreeGrowers.ASPEN,settings),
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollision()
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
        FuelRegistryEvents.BUILD.register((builder,context) -> {
            builder.add(ASPEN_PLANKS,300);
            builder.add(ASPEN_LOG,300);
            builder.add(STRIPPED_ASPEN_LOG,300);
            builder.add(ASPEN_WOOD,300);
            builder.add(STRIPPED_ASPEN_WOOD,300);
            builder.add(ASPEN_FENCE,300);
            builder.add(ASPEN_FENCE_GATE,300);
            builder.add(ASPEN_STAIRS,300);
            builder.add(ASPEN_BUTTON,300);
            builder.add(ASPEN_PRESSURE_PLATE,300);
            builder.add(ASPEN_DOOR,300);
            builder.add(ASPEN_TRAPDOOR,300);
            builder.add(ASPEN_SHELF,300);
            builder.add(ASPEN_SIGN_ITEM,200);
            builder.add(ASPEN_HANGING_SIGN_ITEM,200);
            builder.add(ASPEN_SLAB,150);
        });
    }

    public static void registerStrippables() {
        StrippableBlockRegistry.register(ASPEN_LOG,STRIPPED_ASPEN_LOG);
        StrippableBlockRegistry.register(ASPEN_WOOD,STRIPPED_ASPEN_WOOD);
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
            Set<Block> signBlocks = (Set<Block>) targetField.get(BlockEntityType.SIGN);
            boolean modified = false;
            try {
                modified = signBlocks.add(ASPEN_SIGN) | signBlocks.add(ASPEN_WALL_SIGN);
            } catch (UnsupportedOperationException e) {

                Set<Block> newSignBlocks = new java.util.HashSet<>(signBlocks);
                newSignBlocks.add(ASPEN_SIGN);
                newSignBlocks.add(ASPEN_WALL_SIGN);
                targetField.set(BlockEntityType.SIGN, newSignBlocks);
                modified = true;
            }
            if (modified) {
                System.out.println("[AspenGrove] Successfully added signs to BlockEntityType.SIGN");
            }
            Set<Block> hangingSignBlocks = (Set<Block>) targetField.get(BlockEntityType.HANGING_SIGN);
            modified = false;
            try {
                modified = hangingSignBlocks.add(ASPEN_HANGING_SIGN) | hangingSignBlocks.add(ASPEN_WALL_HANGING_SIGN);
            } catch (UnsupportedOperationException e) {
                Set<Block> newHangingSignBlocks = new java.util.HashSet<>(hangingSignBlocks);
                newHangingSignBlocks.add(ASPEN_HANGING_SIGN);
                newHangingSignBlocks.add(ASPEN_WALL_HANGING_SIGN);
                targetField.set(BlockEntityType.HANGING_SIGN, newHangingSignBlocks);
                modified = true;
            }
            if (modified) {
                System.out.println("[AspenGrove] Successfully added hanging signs to BlockEntityType.HANGING_SIGN");
            }
            Set<Block> shelfBlocks = (Set<Block>) targetField.get(BlockEntityType.SHELF);
            modified = false;
            try {
                modified = shelfBlocks.add(ASPEN_SHELF);
            } catch (UnsupportedOperationException e) {
                Set<Block> newShelfBlocks = new java.util.HashSet<>(shelfBlocks);
                newShelfBlocks.add(ASPEN_SHELF);
                targetField.set(BlockEntityType.SHELF, newShelfBlocks);
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