package dev.enyk.res;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

import java.util.ArrayList;
import dev.enyk.res.skyblock.FancyStatusBars.ParseActionBar;
import dev.enyk.res.skyblock.FancyStatusBars.RenderStatusBars;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RoughlyEnoughSkyblock implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("roughlyenoughskyblock");

	public static final String MOD_ID = "roughlyenoughskyblock";

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("Loaded Roughly Enough Skyblock");

	}
}