package dngnrr.aspengrove.mixin;

import dngnrr.aspengrove.classes.AspenGroveBiomes;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterList;
import net.minecraft.world.level.biome.Climate;
import com.mojang.datafixers.util.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.util.List;
import java.util.ArrayList;

@Mixin(MultiNoiseBiomeSourceParameterList.class)
public class MultiNoisePresetMixin {

    @Inject(method = "parameters", at = @At("RETURN"), cancellable = true)
    public void onGetParameters(CallbackInfoReturnable<Climate.ParameterList<net.minecraft.resources.ResourceKey<net.minecraft.world.level.biome.Biome>>> cir) {
        if (cir.getReturnValue().values().size() > 10) {
            List<Pair<Climate.ParameterPoint, net.minecraft.resources.ResourceKey<net.minecraft.world.level.biome.Biome>>> mutableList = new ArrayList<>(cir.getReturnValue().values());

            mutableList.add(Pair.of(
                    Climate.parameters(0.5F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                    AspenGroveBiomes.ASPEN_GROVE
            ));

            cir.setReturnValue(new Climate.ParameterList<>(mutableList));
        }
    }
}