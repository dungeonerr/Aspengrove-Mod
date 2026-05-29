package dngnrr.aspengrove;

import dngnrr.aspengrove.classes.*;
import dngnrr.aspengrove.classes.client.AspenGroveClient;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(AspenGrove.MOD_ID)
public class AspenGrove {
    public static final String MOD_ID = "aspengrove";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public Aspengrove(IEventBus modEventBus) {
        AspenGroveBlocks.initialize(modEventBus);
        AspenGroveEntities.init(modEventBus);
        AspenGroveItems.initialize(modEventBus);
        AspenGroveCreativeTab.init(modEventBus);
        AspenGroveColors.initialize();
        AspenGroveWoodTypes.initialize();
        AspenGroveTags.initialize();
        AspenGroveTreeGrowers.initialize();

        modEventBus.addListener(this::commonSetup);

        if (FMLEnvironment.getDist() == Dist.CLIENT) {
            new AspenGroveClient(modEventBus);
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModBiomes.registerBiomes();
            registerFlammability();
            ModBlocks.addToBlockEntityTypes();
            LOGGER.info("Aspen Grove Initialized!");
        });
    }

    private void registerFlammability() {
        FireBlock fire = (FireBlock) Blocks.FIRE;
        fire.setFlammable(AspenGroveBlocks.ASPEN_LOG.get(), 5, 5);
        fire.setFlammable(AspenGroveBlocks.ASPEN_WOOD.get(), 5, 5);
        fire.setFlammable(AspenGroveBlocks.STRIPPED_ASPEN_LOG.get(), 5, 5);
        fire.setFlammable(AspenGroveBlocks.STRIPPED_ASPEN_WOOD.get(), 5, 5);
        fire.setFlammable(AspenGroveBlocks.ASPEN_PLANKS.get(), 5, 20);
        fire.setFlammable(AspenGroveBlocks.ASPEN_STAIRS.get(), 5, 20);
        fire.setFlammable(AspenGroveBlocks.ASPEN_SLAB.get(), 5, 20);
        fire.setFlammable(AspenGroveBlocks.ASPEN_FENCE.get(), 5, 20);
        fire.setFlammable(AspenGroveBlocks.ASPEN_FENCE_GATE.get(), 5, 20);
        fire.setFlammable(AspenGroveBlocks.ASPEN_LEAVES.get(), 30, 60);
    }
}