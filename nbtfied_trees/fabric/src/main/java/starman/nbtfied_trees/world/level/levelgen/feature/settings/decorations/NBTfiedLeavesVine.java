package starman.nbtfied_trees.world.level.levelgen.feature.settings.decorations;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class NBTfiedLeavesVine extends TreeDecorator {

    public static final MapCodec<NBTfiedLeavesVine> CODEC = RecordCodecBuilder.mapCodec(builder ->
            builder.group(
                    BuiltInRegistries.BLOCK.byNameCodec().flatXmap(mustExtendVineBlock(), mustExtendVineBlock()).fieldOf("vine_block").forGetter(TYGLeavesVineDecorator -> TYGLeavesVineDecorator.vineBlock),
                    Codec.FLOAT.fieldOf("probability").forGetter(TYGLeavesVineDecorator -> TYGLeavesVineDecorator.probability)
            ).apply(builder, ((vineBlock, probability) -> new NBTfiedLeavesVine((VineBlock) vineBlock, probability)))
    );


    static Function<Block, DataResult<Block>> mustExtendVineBlock() {
        return block -> block instanceof VineBlock ? DataResult.success(block) : DataResult.error(() -> String.format("\"%s\" is not an instance of `VineBlock`.", BuiltInRegistries.BLOCK.getKey(block)));
    }

    private final VineBlock vineBlock;
    private final float probability;

    public NBTfiedLeavesVine(VineBlock vineBlock,float probability) {
        this.vineBlock = vineBlock;
        this.probability = probability;
    }

    protected @NotNull TreeDecoratorType<?> type() {
        return NBTfiedDecorationsTypes.LEAVE_VINE;
    }

    public void place(Context context) {
        RandomSource randomSource = context.random();
        context.leaves().forEach((pos) -> {
            BlockPos pos1;
            if (randomSource.nextFloat() <= this.probability) {
                pos1 = pos.west();
                if (context.isAir(pos1)) {
                    addHangingVine(pos1, VineBlock.EAST, context);
                }
            }

            if (randomSource.nextFloat() <= this.probability) {
                pos1 = pos.east();
                if (context.isAir(pos1)) {
                    addHangingVine(pos1, VineBlock.WEST, context);
                }
            }

            if (randomSource.nextFloat() <= this.probability) {
                pos1 = pos.north();
                if (context.isAir(pos1)) {
                    addHangingVine(pos1, VineBlock.SOUTH, context);
                }
            }

            if (randomSource.nextFloat() <= this.probability) {
                pos1 = pos.south();
                if (context.isAir(pos1)) {
                    addHangingVine(pos1, VineBlock.NORTH, context);
                }
            }
        });
    }

    private void addHangingVine(BlockPos pos, BooleanProperty booleanProperty, Context context) {
        placeVine(context, pos, booleanProperty);
        int count = 4;

        for (pos = pos.below(); context.isAir(pos) && count > 0; --count) {
            placeVine(context, pos, booleanProperty);
            pos = pos.below();
        }
    }

    public void placeVine(Context context, BlockPos blockPos, BooleanProperty booleanProperty) {
        context.setBlock(blockPos, this.vineBlock.defaultBlockState().setValue(booleanProperty, true));
    }
}