package starman.nbtfied_trees.world.level.levelgen.feature.settings.decorations;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import starman.nbtfied_trees.NBTfiedTrees;

public class NBTfiedDecorationsTypes {

    public static final TreeDecoratorType<NBTfiedTrunkVine> TRUNK_VINE = register("trunk_vine", NBTfiedTrunkVine.CODEC);
    public static final TreeDecoratorType<NBTfiedLeavesVine> LEAVE_VINE = register("leave_vine", NBTfiedLeavesVine.CODEC);
    public static final TreeDecoratorType<AttachedToLogsDecorations> ATTACHED_TO_LOGS = register("attached_to_logs", AttachedToLogsDecorations.CODEC);
    public static final TreeDecoratorType<AttachedToFruitLeavesDecorations> ATTACHED_TO_FRUIT_LEAVES = register("attached_to_fruit_leaves", AttachedToFruitLeavesDecorations.CODEC);

    private static <P extends TreeDecorator> TreeDecoratorType<P> register(String id, MapCodec<P> codec) {
        return Registry.register(BuiltInRegistries.TREE_DECORATOR_TYPE, NBTfiedTrees.id(id), new TreeDecoratorType<>(codec));
    }

    public static void register() {
    }
}