package dngnrr.aspengrove.mixin;

import com.google.common.collect.ImmutableList;
import dngnrr.aspengrove.classes.AspenGroveBlocks;
import net.minecraft.core.component.BlockTransformer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.component.BlockTransformerMappings;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.stateproviders.CopyPropertiesProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockTransformerMappings.class)
public class BlockTransformerMixin {

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/google/common/collect/ImmutableList;builder()Lcom/google/common/collect/ImmutableList$Builder;"
            )
    )
    private static ImmutableList.Builder<BlockTransformer.BlockTransformData> captureBuilder() {
        ImmutableList.Builder<BlockTransformer.BlockTransformData> builder = ImmutableList.builder();

        builder.add(createStrippable(AspenGroveBlocks.ASPEN_LOG, AspenGroveBlocks.STRIPPED_ASPEN_LOG));
        builder.add(createStrippable(AspenGroveBlocks.ASPEN_WOOD, AspenGroveBlocks.STRIPPED_ASPEN_WOOD));

        return builder;
    }

    private static BlockTransformer.BlockTransformData createStrippable(net.minecraft.world.level.block.Block from, net.minecraft.world.level.block.Block to) {
        return BlockTransformer.BlockTransformData.builder(
                BlockPredicate.matchesBlocks(from),
                new CopyPropertiesProvider(to)
        ).sound(SoundEvents.AXE_STRIP).build();
    }
}