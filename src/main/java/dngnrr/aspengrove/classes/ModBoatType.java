package dngnrr.aspengrove.classes;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public enum ModBoatType implements StringRepresentable {
    ASPEN("aspen", () -> ModBlocks.ASPEN_PLANKS);

    private final String name;
    private final Supplier<Block> planks;

    ModBoatType(String name, Supplier<Block> planks) {
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

    public static ModBoatType byName(String name) {
        for (ModBoatType type : values()) {
            if (type.name.equals(name)) return type;
        }
        return ASPEN;
    }
}