package dngnrr.aspengrove;

import dngnrr.aspengrove.classes.*;
import dngnrr.aspengrove.classes.client.AspenGroveClient;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Mod(AspenGrove.MOD_ID)
public class AspenGrove {
    public static final String MOD_ID = "aspengrove";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public AspenGrove(IEventBus modEventBus) {
        AspenGroveColors.initialize();
        AspenGroveWoodTypes.initialize();
        AspenGroveTreeGrowers.initialize();

        modEventBus.addListener(this::onRegister);
        modEventBus.addListener(this::commonSetup);

        if (FMLEnvironment.dist == Dist.CLIENT) {
            new AspenGroveClient(modEventBus);
        }
    }

    private void onRegister(RegisterEvent event) {
        if (event.getRegistryKey().equals(Registries.BLOCK)) {
            AspenGroveBlocks.initialize();
        } else if (event.getRegistryKey().equals(Registries.ITEM)) {
            AspenGroveItems.initialize();
        } else if (event.getRegistryKey().equals(Registries.ENTITY_TYPE)) {
            AspenGroveEntities.initialize();
        } else if (event.getRegistryKey().equals(Registries.CREATIVE_MODE_TAB)) {
            AspenGroveCreativeTab.initialize();
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            AspenGroveBiomes.initialize();
            registerFlammability();
            registerStrippables();
            LOGGER.info("Aspen Grove Initialized!");
        });
    }

    private void registerFlammability() {
        FireBlock fire = (FireBlock) Blocks.FIRE;
        fire.setFlammable(AspenGroveBlocks.ASPEN_LOG, 5, 5);
        fire.setFlammable(AspenGroveBlocks.ASPEN_WOOD, 5, 5);
        fire.setFlammable(AspenGroveBlocks.STRIPPED_ASPEN_LOG, 5, 5);
        fire.setFlammable(AspenGroveBlocks.STRIPPED_ASPEN_WOOD, 5, 5);
        fire.setFlammable(AspenGroveBlocks.ASPEN_PLANKS, 5, 20);
        fire.setFlammable(AspenGroveBlocks.ASPEN_STAIRS, 5, 20);
        fire.setFlammable(AspenGroveBlocks.ASPEN_SLAB, 5, 20);
        fire.setFlammable(AspenGroveBlocks.ASPEN_FENCE, 5, 20);
        fire.setFlammable(AspenGroveBlocks.ASPEN_FENCE_GATE, 5, 20);
        fire.setFlammable(AspenGroveBlocks.ASPEN_LEAVES, 30, 60);
    }

    private void registerStrippables() {
        Map<Block, Block> strippables = new HashMap<>(AxeItem.STRIPPABLES);
        strippables.put(AspenGroveBlocks.ASPEN_LOG, AspenGroveBlocks.STRIPPED_ASPEN_LOG);
        strippables.put(AspenGroveBlocks.ASPEN_WOOD, AspenGroveBlocks.STRIPPED_ASPEN_WOOD);
        AxeItem.STRIPPABLES = strippables;
    }
}