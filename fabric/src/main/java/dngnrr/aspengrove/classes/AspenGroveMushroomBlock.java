package dngnrr.aspengrove.classes;

import java.util.Optional;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.core.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.levelgen.feature.*;

public class AspenGroveMushroomBlock extends MushroomBlock {
    private final ResourceKey<Feature> feature;

    public AspenGroveMushroomBlock(final ResourceKey<Feature> feature, final BlockBehaviour.Properties properties) {
        super(feature, properties);
        this.feature = feature;
    }

    @Override
    public boolean growMushroom(final ServerLevel level, final BlockPos pos, final BlockState state, final RandomSource random) {
        Optional<? extends Holder<Feature>> featureHolder = level.registryAccess().lookupOrThrow(Registries.FEATURE).get(this.feature);
        if (featureHolder.isEmpty()) {
            return false;
        } else {
            level.removeBlock(pos, false);
            if (((Feature)((Holder)featureHolder.get()).value()).place(level, level.getChunkSource().getGenerator(), random, pos)) {
                return true;
            } else {
                level.setBlockAndUpdate(pos, state);
                return false;
            }
        }
    }

    @Override
    public boolean isValidBonemealTarget(final LevelReader level, final BlockPos pos, final BlockState state, final BonemealSource source) {
        if (level instanceof ServerLevel serverLevel) {
            Optional<? extends Holder<Feature>> featureHolder = serverLevel.registryAccess().lookupOrThrow(Registries.FEATURE).get(this.feature);
            if (featureHolder.isPresent()) {
                Feature feature = (Feature)((Holder)featureHolder.get()).value();
                if (feature instanceof AbstractHugeMushroomFeature mushroomFeature) {
                    int minHeight = 4 + mushroomFeature.foliageRadius();
                    return level.isInsideBuildHeight(pos.above(minHeight));
                } else {
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean isBonemealSuccess(final Level level, final RandomSource random, final BlockPos pos, final BlockState state, final BonemealSource source) {
        return (double)random.nextFloat() < 0.4;
    }

    @Override
    public void performBonemeal(final ServerLevel level, final RandomSource random, final BlockPos pos, final BlockState state, final BonemealSource source) {
        this.growMushroom(level, pos, state, random);
    }
}