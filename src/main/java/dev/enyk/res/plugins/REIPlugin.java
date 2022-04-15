package dev.enyk.res.plugins;

import dev.enyk.res.RoughlyEnoughSkyblock;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.entry.EntryRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.item.Items;

public class REIPlugin implements REIClientPlugin {
    //public static final CategoryIdentifier HYPIXEL_CRAFTING = ;
    public static final CategoryIdentifier<HypixelCraftingDisplay> HYPIXEL_CRAFTING = CategoryIdentifier.of(RoughlyEnoughSkyblock.MOD_ID, "plugins/hypixel_crafting");
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.addWorkstations(HYPIXEL_CRAFTING, EntryStacks.of(Items.CRAFTING_TABLE));
    }

    @Override
    public void registerEntries(EntryRegistry registry) {
        // We can do our epic stuff here
    }
}
