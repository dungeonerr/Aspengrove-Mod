package dngnrr.aspengrove.classes;

import dngnrr.aspengrove.Aspengrove;
import dngnrr.aspengrove.classes.boats.ModBoatEntity;
import dngnrr.aspengrove.classes.boats.ModChestBoatEntity;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class ModItems {
    public static final Item ASPEN_BOAT = registerBoat("aspen_boat", ModBoatType.ASPEN, false);
    public static final Item ASPEN_CHEST_BOAT = registerBoat("aspen_chest_boat", ModBoatType.ASPEN, true);
    public static final Item BOUQUET = register("bouquet", new Item(new Item.Properties()));

    private static Item registerBoat(String name, ModBoatType type, boolean chest) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, name);

        Item item = new BoatItem(chest, Boat.Type.OAK, new Item.Properties().stacksTo(1)) {
            @Override
            public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
                ItemStack itemStack = player.getItemInHand(hand);
                HitResult hitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY);

                if (hitResult.getType() == HitResult.Type.MISS) {
                    return InteractionResultHolder.pass(itemStack);
                }

                Vec3 viewVec = player.getViewVector(1.0F);
                List<Entity> list = level.getEntities(player, player.getBoundingBox().expandTowards(viewVec.scale(5.0)).inflate(1.0), EntitySelector.NO_SPECTATORS.and(Entity::canBeCollidedWith));

                if (!list.isEmpty()) {
                    Vec3 eyePos = player.getEyePosition();
                    for (Entity entity : list) {
                        AABB aabb = entity.getBoundingBox().inflate(entity.getPickRadius());
                        if (aabb.contains(eyePos)) return InteractionResultHolder.pass(itemStack);
                    }
                }

                if (hitResult.getType() == HitResult.Type.BLOCK) {
                    Boat boat = chest
                            ? new ModChestBoatEntity(ModEntities.ASPEN_CHEST_BOAT, level)
                            : new ModBoatEntity(ModEntities.ASPEN_BOAT, level);

                    boat.setPos(hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z);
                    boat.setYRot(player.getYRot());

                    if (boat instanceof ModBoatEntity mb) mb.setModVariant(type);
                    if (boat instanceof ModChestBoatEntity mcb) mcb.setModVariant(type);

                    if (!level.noCollision(boat, boat.getBoundingBox())) {
                        return InteractionResultHolder.fail(itemStack);
                    }

                    if (!level.isClientSide) {
                        level.addFreshEntity(boat);
                        level.gameEvent(player, GameEvent.ENTITY_PLACE, hitResult.getLocation());
                        itemStack.consume(1, player);
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                    return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
                }

                return InteractionResultHolder.pass(itemStack);
            }
        };
        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    private static Item register(String name, Item item) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Aspengrove.MOD_ID, name);
        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static void registerFuels() {
        FuelRegistry.INSTANCE.add(ASPEN_BOAT, 1200);
        FuelRegistry.INSTANCE.add(ASPEN_CHEST_BOAT, 1200);
    }

    public static void registerCompostables() {
        ComposterBlock.COMPOSTABLES.put(BOUQUET, 0.65F);
    }

    public static void initialize() {
        registerFuels();
        registerCompostables();
    }
}