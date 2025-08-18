package dev.seano.animalbikes.items;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class AnimalBikeItem extends Item {

    private final EntityType<? extends MobEntity> entityType;

    public AnimalBikeItem(RegistryKey<Item> registryKey, EntityType<? extends MobEntity> entityType) {
        super(new Item.Settings().maxCount(1).registryKey(registryKey));
        this.entityType = entityType;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if (world.isClient) {
            return ActionResult.SUCCESS;
        }

        Item item = context.getStack().getItem();

        PlayerEntity player = context.getPlayer();
        if (player != null) {
            player.sendMessage(Text.empty()
                    .append("used animal bike: ").append(Text.translatable(item.getTranslationKey()))
                    .formatted(Formatting.GRAY), false);
        }

        entityType.spawn((ServerWorld) world, context.getBlockPos().up(), SpawnReason.MOB_SUMMONED);
        return ActionResult.SUCCESS;
    }
}
