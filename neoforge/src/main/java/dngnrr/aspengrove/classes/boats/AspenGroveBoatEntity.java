package dngnrr.aspengrove.classes.boats;

import dngnrr.aspengrove.classes.AspenGroveBoatType;
import dngnrr.aspengrove.classes.AspenGroveEntities;
import dngnrr.aspengrove.classes.AspenGroveItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class AspenGroveBoatEntity extends Boat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_MOD =
            SynchedEntityData.defineId(AspenGroveBoatEntity.class, EntityDataSerializers.INT);

    public AspenGroveBoatEntity(EntityType<? extends Boat> type, Level level) {
        super(type, level);
    }

    public AspenGroveBoatEntity(Level level, double x, double y, double z) {
        super(AspenGroveEntities.ASPEN_BOAT, level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_ID_TYPE_MOD, AspenGroveBoatType.ASPEN.ordinal());
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
            this.setModVariant(AspenGroveBoatType.byName(nbt.getString("ModType")));
        }
    }

    public void setModVariant(AspenGroveBoatType type) {
        this.entityData.set(DATA_ID_TYPE_MOD, type.ordinal());
    }

    public AspenGroveBoatType getModVariant() {
        int id = this.entityData.get(DATA_ID_TYPE_MOD);
        AspenGroveBoatType[] types = AspenGroveBoatType.values();
        if (id < 0 || id >= types.length) {
            return AspenGroveBoatType.ASPEN;
        }
        return types[id];
    }

    @Override
    public Item getDropItem() {
        return AspenGroveItems.ASPEN_BOAT;
    }
}