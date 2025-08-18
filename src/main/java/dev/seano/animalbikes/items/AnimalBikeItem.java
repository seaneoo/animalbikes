package dev.seano.animalbikes.items;

import dev.seano.animalbikes.entities.AbstractBikeEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class AnimalBikeItem extends Item {

    private final EntityType<? extends AbstractBikeEntity> entityType;

    public AnimalBikeItem(RegistryKey<Item> registryKey, EntityType<? extends AbstractBikeEntity> entityType) {
        super(new Item.Settings().maxCount(1).registryKey(registryKey));
        this.entityType = entityType;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if (world.isClient) {
            return ActionResult.SUCCESS;
        }

        PlayerEntity player = context.getPlayer();
        if (player != null) {
            context.getStack().decrementUnlessCreative(1, player);
            // todo change this message and move to a translation key
            player.sendMessage(Text.empty().append("Sneak right click with an empty hand to reacquire the wheel."),
                    true);
        }

        entityType.spawn((ServerWorld) world, context.getBlockPos().up(), SpawnReason.MOB_SUMMONED);
        return ActionResult.SUCCESS;
    }
}
