package dev.seano.animalbikes.client.datagen;

import dev.seano.animalbikes.items.ABItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ABRecipeProvider extends FabricRecipeProvider {

    public ABRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                //noinspection unused
                RegistryWrapper.Impl<Item> itemImpl = registries.getOrThrow(RegistryKeys.ITEM);
                createShaped(RecipeCategory.TOOLS, ABItems.CREEPER_BIKE, 1).input('x', Items.TNT)
                        .input('y', Items.SADDLE)
                        .pattern("xxx")
                        .pattern("xyx")
                        .pattern("xxx")
                        .criterion(hasItem(Items.TNT), conditionsFromItem(Items.TNT))
                        .offerTo(exporter);
                createShaped(RecipeCategory.TOOLS, ABItems.PIG_BIKE, 1).input('x', Items.PORKCHOP)
                        .input('y', Items.SADDLE)
                        .pattern("xxx")
                        .pattern("xyx")
                        .pattern("xxx")
                        .criterion(hasItem(Items.PORKCHOP), conditionsFromItem(Items.PORKCHOP))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return ABModelProvider.class.getSimpleName();
    }
}
