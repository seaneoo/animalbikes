package dev.seano.animalbikes.items;

import dev.seano.animalbikes.entities.AbstractBikeEntity;
import dev.seano.animalbikes.network.UseAnimalBikeItemS2CPayload;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
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
            return ActionResult.PASS;
        }

        PlayerEntity player = context.getPlayer();
        if (player != null) {
            context.getStack().decrementUnlessCreative(1, player);
            if (player instanceof ServerPlayerEntity serverPlayer) {
                ServerPlayNetworking.send(serverPlayer, new UseAnimalBikeItemS2CPayload());
            }
        }

        entityType.spawn((ServerWorld) world, context.getBlockPos().up(), SpawnReason.MOB_SUMMONED);
        return ActionResult.SUCCESS;
    }
}
