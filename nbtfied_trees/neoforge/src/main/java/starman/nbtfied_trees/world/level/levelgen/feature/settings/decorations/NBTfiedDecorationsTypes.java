package starman.nbtfied_trees.world.level.levelgen.feature.settings.decorations;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import starman.nbtfied_trees.NBTfiedTrees;

public class NBTfiedDecorationsTypes {

    public static final DeferredRegister<TreeDecoratorType<?>> DECORATORS =
            DeferredRegister.create(BuiltInRegistries.TREE_DECORATOR_TYPE, NBTfiedTrees.MOD_ID);

    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<NBTfiedTrunkVine>> TRUNK_VINE =
            DECORATORS.register("trunk_vine", () -> new TreeDecoratorType<>(NBTfiedTrunkVine.CODEC));

    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<NBTfiedLeavesVine>> LEAVE_VINE =
            DECORATORS.register("leave_vine", () -> new TreeDecoratorType<>(NBTfiedLeavesVine.CODEC));

    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<AttachedToLogsDecorations>> ATTACHED_TO_LOGS =
            DECORATORS.register("attached_to_logs", () -> new TreeDecoratorType<>(AttachedToLogsDecorations.CODEC));

    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<AttachedToFruitLeavesDecorations>> ATTACHED_TO_FRUIT_LEAVES =
            DECORATORS.register("attached_to_fruit_leaves", () -> new TreeDecoratorType<>(AttachedToFruitLeavesDecorations.CODEC));

    public static void register(IEventBus modEventBus) {
        DECORATORS.register(modEventBus);
    }
}