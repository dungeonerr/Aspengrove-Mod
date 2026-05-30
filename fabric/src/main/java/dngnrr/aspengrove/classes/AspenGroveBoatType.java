package dngnrr.aspengrove.classes;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public enum AspenGroveBoatType implements StringRepresentable {
    ASPEN("aspen", () -> AspenGroveBlocks.ASPEN_PLANKS);

    private final String name;
    private final Supplier<Block> planks;

    AspenGroveBoatType(String name, Supplier<Block> planks) {
        this.name = name;
        this.planks = planks;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }

    public Block getPlanks() {
        return this.planks.get();
    }

    public static AspenGroveBoatType byName(String name) {
        for (AspenGroveBoatType type : values()) {
            if (type.name.equals(name)) return type;
        }
        return ASPEN;
    }
}