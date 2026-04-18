package starman.nbtfied_trees.world.level.levelgen.feature.settings.decorations;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import org.jetbrains.annotations.NotNull;

public class NBTfiedTrunkVine extends TreeDecorator {

    public static final MapCodec<NBTfiedTrunkVine> CODEC = RecordCodecBuilder.mapCodec(builder ->
            builder.group(
                    BuiltInRegistries.BLOCK.byNameCodec().flatXmap(NBTfiedLeavesVine.mustExtendVineBlock(), NBTfiedLeavesVine.mustExtendVineBlock()).fieldOf("vine_block").forGetter(bygLeavesVineDecorator -> bygLeavesVineDecorator.vineBlock),
                    Codec.FLOAT.fieldOf("probability").forGetter(bygLeavesVineDecorator -> bygLeavesVineDecorator.probability)
            ).apply(builder, ((vineBlock, probability) -> new NBTfiedTrunkVine((VineBlock) vineBlock, probability)))
    );


    private final VineBlock vineBlock;
    private final float probability;

    public NBTfiedTrunkVine(VineBlock vineBlock,float probability) {
        this.vineBlock = vineBlock;
        this.probability = probability;
    }

    protected @NotNull TreeDecoratorType<?> type() {
        return NBTfiedDecorationsTypes.TRUNK_VINE;
    }

    public void place(Context context) {
        RandomSource randomSource = context.random();
        context.logs().forEach((pos) -> {
            BlockPos pos1;
            if (randomSource.nextFloat() <= this.probability) {
                pos1 = pos.west();
                if (context.isAir(pos1)) {
                    placeVine(context, pos1, VineBlock.EAST);
                }
            }

            if (randomSource.nextFloat() <= this.probability) {
                pos1 = pos.east();
                if (context.isAir(pos1)) {
                    placeVine(context, pos1, VineBlock.WEST);
                }
            }

            if (randomSource.nextFloat() <= this.probability) {
                pos1 = pos.north();
                if (context.isAir(pos1)) {
                    placeVine(context, pos1, VineBlock.SOUTH);
                }
            }

            if (randomSource.nextFloat() <= this.probability) {
                pos1 = pos.south();
                if (context.isAir(pos1)) {
                    placeVine(context, pos1, VineBlock.NORTH);
                }
            }
        });
    }

    public void placeVine(Context context, BlockPos blockPos, BooleanProperty booleanProperty) {
        context.setBlock(blockPos, this.vineBlock.defaultBlockState().setValue(booleanProperty, true));
    }
}