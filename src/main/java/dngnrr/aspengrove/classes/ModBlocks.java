package dngnrr.aspengrove.classes;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import dngnrr.aspengrove.Aspengrove;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;

public class ModBlocks {
    private static Block register(String name,Function<BlockBehaviour.Properties, Block> blockFactory,BlockBehaviour.Properties settings,boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.setId(blockKey));
        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);
            BlockItem blockItem = new BlockItem(block,new Item.Properties( ).setId(itemKey).useBlockDescriptionPrefix( ));
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
            BlockBehaviour.Properties.of( ).sound(SoundType.WOOD).strength(2.0F),
            true
    );

    public static final Block STRIPPED_ASPEN_LOG = register(
            "stripped_aspen_log",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of( ).sound(SoundType.WOOD).strength(2.0F),
            true
    );

    public static final Block ASPEN_WOOD = register(
            "aspen_wood",
            Block::new,
            BlockBehaviour.Properties.of( ).sound(SoundType.WOOD).strength(2.0F),
            true
    );

    public static final Block STRIPPED_ASPEN_WOOD = register(
            "stripped_aspen_wood",
            Block::new,
            BlockBehaviour.Properties.of( ).sound(SoundType.WOOD).strength(2.0F),
            true
    );

    public static final Block ASPEN_PLANKS = register(
            "aspen_planks",
            Block::new,
            BlockBehaviour.Properties.of( ).sound(SoundType.WOOD).strength(2.0F),
            true
    );

    public static final Block ASPEN_LEAVES = register(
            "aspen_leaves",
            Block::new,
            BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(0.2f).isSuffocating((state, world, pos) -> false).isViewBlocking((state, world, pos) -> false).pushReaction(PushReaction.DESTROY),
            true
            );

    public static void initialize() {
    }
}
