package dngnrr.aspengrove.classes;

import net.fabricmc.fabric.api.item.v1.BlockTransformerHelper;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class AspenGroveRegisters {

    public static void registerFlammables() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();
        registry.add(AspenGroveBlocks.ASPEN_LOG, 5, 5);
        registry.add(AspenGroveBlocks.STRIPPED_ASPEN_LOG, 5, 5);
        registry.add(AspenGroveBlocks.ASPEN_WOOD, 5, 5);
        registry.add(AspenGroveBlocks.STRIPPED_ASPEN_WOOD, 5, 5);
        registry.add(AspenGroveBlocks.ASPEN_PLANKS, 5, 20);
        registry.add(AspenGroveBlocks.ASPEN_SLAB, 5, 20);
        registry.add(AspenGroveBlocks.ASPEN_STAIRS, 5, 20);
        registry.add(AspenGroveBlocks.ASPEN_FENCE, 5, 20);
        registry.add(AspenGroveBlocks.ASPEN_FENCE_GATE, 5, 20);
        registry.add(AspenGroveBlocks.ASPEN_LEAVES, 30, 60);
        registry.add(AspenGroveBlocks.ASPEN_SAPLING, 30, 60);
        registry.add(AspenGroveBlocks.ASPEN_SIGN, 20, 5);
        registry.add(AspenGroveBlocks.ASPEN_WALL_SIGN, 20, 5);
        registry.add(AspenGroveBlocks.ASPEN_HANGING_SIGN, 20, 5);
        registry.add(AspenGroveBlocks.ASPEN_WALL_HANGING_SIGN, 20, 5);
    }

    public static void initialize() {
        registerFlammables();
        BlockTransformerHelper.registerStripping(AspenGroveBlocks.ASPEN_LOG, AspenGroveBlocks.STRIPPED_ASPEN_LOG);
        BlockTransformerHelper.registerStripping(AspenGroveBlocks.ASPEN_WOOD, AspenGroveBlocks.STRIPPED_ASPEN_WOOD);
    }
}
