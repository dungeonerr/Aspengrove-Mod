package dngnrr.aspengrove.items;

import dngnrr.aspengrove.Aspengrove;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ItemLore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static dngnrr.aspengrove.Aspengrove.MOD_ID;

public class ModCreativeTab {
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final CreativeModeTab ASPEN_LOG = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(Aspengrove.MOD_ID, "Aspengrove"),
            FabricItemGroup.builder().title(Component.translatable("itemGroup.aspengrove"))
                        entries.accept(ModBlocks.MAMA_DANJENA_BLOCK);
                    }).build());

    public static void initialize() {}
}