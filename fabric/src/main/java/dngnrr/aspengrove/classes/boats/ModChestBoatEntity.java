package dngnrr.aspengrove.classes.boats;

import dngnrr.aspengrove.classes.ModBoatType;
import dngnrr.aspengrove.classes.ModEntities;
import dngnrr.aspengrove.classes.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class ModChestBoatEntity extends ChestBoat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_MOD =
            SynchedEntityData.defineId(ModChestBoatEntity.class, EntityDataSerializers.INT);

    public ModChestBoatEntity(EntityType<? extends ChestBoat> type, Level level) {
        super(type, level);
    }

    public ModChestBoatEntity(Level level, double x, double y, double z) {
        this(ModEntities.ASPEN_CHEST_BOAT, level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_ID_TYPE_MOD, ModBoatType.ASPEN.ordinal());
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putString("ModType", this.getModVariant().getSerializedName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        if (nbt.contains("ModType", 8)) {
            this.setModVariant(ModBoatType.byName(nbt.getString("ModType")));
        }
    }

    public void setModVariant(ModBoatType type) {
        this.entityData.set(DATA_ID_TYPE_MOD, type.ordinal());
    }

    public ModBoatType getModVariant() {
        return ModBoatType.values()[this.entityData.get(DATA_ID_TYPE_MOD)];
    }

    @Override
    public Item getDropItem() {
        return ModItems.ASPEN_CHEST_BOAT;
    }
}