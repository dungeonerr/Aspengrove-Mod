package dngnrr.aspengrove.classes;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final BlockSetType ASPEN_BLOCK_SET_TYPE = BlockSetType.register(new BlockSetType("aspengrove:aspen"));
    public static final WoodType ASPEN = WoodType.register(new WoodType("aspengrove:aspen", ASPEN_BLOCK_SET_TYPE));

    public static void initialize() {
    }
}