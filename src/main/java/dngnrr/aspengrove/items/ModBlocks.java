import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

import static dngnrr.aspengrove.Aspengrove.MOD_ID;

public class ModBlocks {
     private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
       // Create a registry key for the block
         ResourceKey<Block> blockKey = keyOfBlock(name);
           // Create the block instance
             Block block = blockFactory.apply(settings.setId(blockKey));

               // Sometimes, you may not want to register an item for the block.
                 // Eg: if it's a technical block like minecraft:moving_piston or minecraft:end_gateway
                   if (shouldRegisterItem) {
                      // Items need to be registered with a different type of registry key, but the ID
                         // can be the same.
                            ResourceKey<Item> itemKey = keyOfItem(name);

                               BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
                                  Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
                                    }

                                      return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
                                       }

                                        private static ResourceKey<Block> keyOfBlock(String name) {
                                          return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Aspengrove.MOD_ID, name));
                                           }

                                            private static ResourceKey<Item> keyOfItem(String name) {
                                              return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Aspengrove.MOD_ID, name));
                                               }
public static final Block ASPEN_LOG = register(
  		"aspen_log",
      		Block::new,
          		BlockBehaviour.Properties.of().sound(SoundType.WOOD),
              		true
                  );
)
                                               }
}