package dev.seano.animalbikes.client.datagen;

import dev.seano.animalbikes.items.ABItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ABModelProvider extends FabricModelProvider {

    public ABModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ABItems.CREEPER_BIKE, Models.GENERATED);
        itemModelGenerator.register(ABItems.PIG_BIKE, Models.GENERATED);
    }
}
