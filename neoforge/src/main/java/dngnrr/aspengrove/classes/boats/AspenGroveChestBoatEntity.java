package dngnrr.aspengrove.classes.boats;

import dngnrr.aspengrove.classes.AspenGroveBoatType;
import dngnrr.aspengrove.classes.AspenGroveEntities;
import dngnrr.aspengrove.classes.AspenGroveItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class AspenGroveChestBoatEntity extends ChestBoat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_MOD =
            SynchedEntityData.defineId(AspenGroveChestBoatEntity.class, EntityDataSerializers.INT);

    public AspenGroveChestBoatEntity(EntityType<? extends ChestBoat> type, Level level) {
        super(type, level);
    }

    public AspenGroveChestBoatEntity(Level level, double x, double y, double z) {
        this(AspenGroveEntities.ASPEN_CHEST_BOAT, level);
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
        return AspenGroveBoatType.values()[this.entityData.get(DATA_ID_TYPE_MOD)];
    }

    @Override
    public Item getDropItem() {
        return AspenGroveItems.ASPEN_CHEST_BOAT;
    }
}