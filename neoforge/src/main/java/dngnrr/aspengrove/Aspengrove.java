package dngnrr.aspengrove;

import dngnrr.aspengrove.classes.*;
import dngnrr.aspengrove.classes.client.AspengroveClient;
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

@Mod(Aspengrove.MOD_ID)
public class Aspengrove {
    public static final String MOD_ID = "aspengrove";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public Aspengrove(IEventBus modEventBus) {
        ModColors.initialize();
        ModWoodTypes.initialize();
        ModTags.initialize();
        ModTreeGrowers.initialize();

        modEventBus.addListener(this::onRegister);
        modEventBus.addListener(this::commonSetup);

        if (FMLEnvironment.dist == Dist.CLIENT) {
            new AspengroveClient(modEventBus);
        }
    }

    private void onRegister(RegisterEvent event) {
        if (event.getRegistryKey().equals(Registries.BLOCK)) {
            ModBlocks.init();
        } else if (event.getRegistryKey().equals(Registries.ITEM)) {
            ModItems.init();
        } else if (event.getRegistryKey().equals(Registries.ENTITY_TYPE)) {
            ModEntities.init();
        } else if (event.getRegistryKey().equals(Registries.CREATIVE_MODE_TAB)) {
            ModCreativeTab.init();
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModBiomes.registerBiomes();
            registerFlammability();
            registerStrippables();
            LOGGER.info("Aspen Grove Initialized!");
        });
    }

    private void registerFlammability() {
        FireBlock fire = (FireBlock) Blocks.FIRE;
        fire.setFlammable(ModBlocks.ASPEN_LOG, 5, 5);
        fire.setFlammable(ModBlocks.ASPEN_WOOD, 5, 5);
        fire.setFlammable(ModBlocks.STRIPPED_ASPEN_LOG, 5, 5);
        fire.setFlammable(ModBlocks.STRIPPED_ASPEN_WOOD, 5, 5);
        fire.setFlammable(ModBlocks.ASPEN_PLANKS, 5, 20);
        fire.setFlammable(ModBlocks.ASPEN_STAIRS, 5, 20);
        fire.setFlammable(ModBlocks.ASPEN_SLAB, 5, 20);
        fire.setFlammable(ModBlocks.ASPEN_FENCE, 5, 20);
        fire.setFlammable(ModBlocks.ASPEN_FENCE_GATE, 5, 20);
        fire.setFlammable(ModBlocks.ASPEN_LEAVES, 30, 60);
    }

    private void registerStrippables() {
        Map<Block, Block> strippables = new HashMap<>(AxeItem.STRIPPABLES);
        strippables.put(ModBlocks.ASPEN_LOG, ModBlocks.STRIPPED_ASPEN_LOG);
        strippables.put(ModBlocks.ASPEN_WOOD, ModBlocks.STRIPPED_ASPEN_WOOD);
        AxeItem.STRIPPABLES = strippables;
    }
}