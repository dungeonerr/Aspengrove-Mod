package starman.nbtfied_trees.mixin.chunk;

import starman.nbtfied_trees.NBTfiedTrees;
import starman.nbtfied_trees.world.level.chunk.RandomTickScheduler;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntArrayTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ProtoChunk;
import net.minecraft.world.level.chunk.storage.RegionStorageInfo;
import net.minecraft.world.level.chunk.storage.SerializableChunkData;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(SerializableChunkData.class)
public class MixinChunkSerializer {

    @Shadow
    @Final
    private CompoundTag structureData;

    @Inject(method = "copyOf", at = @At(value = "RETURN"))
    private static void writeScheduledRandomTicks(ServerLevel level, ChunkAccess chunk, CallbackInfoReturnable<SerializableChunkData> cir) {
        if (!(chunk instanceof RandomTickScheduler scheduler)) return;

        List<BlockPos> ticks = scheduler.getScheduledRandomTicks();

        if (ticks != null && !ticks.isEmpty()) {
            CompoundTag modTag = new CompoundTag();
            ListTag list = new ListTag();
            for (BlockPos pos : ticks) {
                list.add(new IntArrayTag(new int[]{pos.getX(), pos.getY(), pos.getZ()}));
            }
            modTag.put("scheduled_random_ticks", list);

            SerializableChunkData result = cir.getReturnValue();
            if (result != null && result.structureData() != null) {
                result.structureData().put(NBTfiedTrees.MOD_ID, modTag);
            }
        }
    }

    @Inject(method = "read", at = @At("RETURN"))
    private void readScheduledRandomTicks(ServerLevel level, PoiManager poiManager, RegionStorageInfo regionInfo, ChunkPos pos, CallbackInfoReturnable<ProtoChunk> cir) {
        if (this.structureData == null) return;

        this.structureData.getCompound(NBTfiedTrees.MOD_ID).ifPresent(modTag -> {
            modTag.getList("scheduled_random_ticks").ifPresent(listTag -> {
                ProtoChunk chunk = cir.getReturnValue();
                if (chunk instanceof RandomTickScheduler scheduler) {
                    for (int i = 0; i < listTag.size(); i++) {
                        Tag entry = listTag.get(i);
                        if (entry instanceof IntArrayTag intArray && intArray.size() == 3) {
                            int[] coords = intArray.getAsIntArray();
                            scheduler.getScheduledRandomTicks().add(new BlockPos(coords[0], coords[1], coords[2]));
                        }
                    }
                }
            });
        });
    }
}