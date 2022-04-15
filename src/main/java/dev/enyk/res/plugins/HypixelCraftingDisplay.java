package dev.enyk.res.plugins;

import java.util.List;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import java.util.Collections;

public class HypixelCraftingDisplay implements Display {
    private EntryIngredient entryStacks;

	@Override
	public List<EntryIngredient> getInputEntries() {
		return Collections.singletonList(entryStacks);
	}

	@Override
	public List<EntryIngredient> getOutputEntries() {
		return Collections.singletonList(entryStacks);
	}

	@Override
	public CategoryIdentifier<?> getCategoryIdentifier() {
		return REIPlugin.HYPIXEL_CRAFTING;
	}
    
}
