package dngnrr.aspengrove.classes;

import dngnrr.aspengrove.AspenGrove;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AspenGroveCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AspenGrove.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ASPENGROVE_TAB =
            CREATIVE_MODE_TABS.register("aspengrove", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.aspengrove"))
                    .icon(() -> new ItemStack(ModBlocks.ASPEN_LOG.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(new ItemStack(AspenGroveBlocks.ASPEN_LOG.get()));
                        output.accept(new ItemStack(AspenGroveBlocks.ASPEN_WOOD.get()));
                        output.accept(new ItemStack(AspenGroveBlocks.STRIPPED_ASPEN_LOG.get()));
                        output.accept(new ItemStack(AspenGroveBlocks.STRIPPED_ASPEN_WOOD.get()));
                        output.accept(new ItemStack(AspenGroveBlocks.ASPEN_PLANKS.get()));
                        output.accept(new ItemStack(AspenGroveBlocks.ASPEN_STAIRS.get()));
                        output.accept(new ItemStack(AspenGroveBlocks.ASPEN_SLAB.get()));
                        output.accept(new ItemStack(AspenGroveBlocks.ASPEN_FENCE.get()));
                        output.accept(new ItemStack(AspenGroveBlocks.ASPEN_FENCE_GATE.get()));
                        output.accept(new ItemStack(AspenGroveBlocks.ASPEN_DOOR.get()));
                        output.accept(new ItemStack(AspenGroveBlocks.ASPEN_TRAPDOOR.get()));
                        output.accept(new ItemStack(AspenGroveBlocks.ASPEN_PRESSURE_PLATE.get()));
                        output.accept(new ItemStack(AspenGroveBlocks.ASPEN_BUTTON.get()));
                        output.accept(new ItemStack(AspenGroveBlocks.ASPEN_SIGN_ITEM.get()));
                        output.accept(new ItemStack(AspenGroveBlocks.ASPEN_HANGING_SIGN_ITEM.get()));
                        output.accept(new ItemStack(AspenGroveBlocks.ASPEN_SHELF.get()));
                        output.accept(new ItemStack(AspenGroveItems.ASPEN_BOAT.get()));
                        output.accept(new ItemStack(AspenGroveItems.ASPEN_CHEST_BOAT.get()));
                        output.accept(new ItemStack(AspenGroveBlocks.ASPEN_LEAVES.get()));
                        output.accept(new ItemStack(AspenGroveBlocks.ASPEN_SAPLING.get()));
                        output.accept(new ItemStack(AspenGroveBlocks.HONEYFLOWER.get()));
                        output.accept(new ItemStack(AspenGroveBlocks.ORANGE_MUSHROOM.get()));
                        output.accept(new ItemStack(AspenGroveBlocks.ORANGE_MUSHROOM_BLOCK.get()));
                        output.accept(new ItemStack(AspenGroveItems.BOUQUET.get()));
                    }).build());

    public static void init(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}