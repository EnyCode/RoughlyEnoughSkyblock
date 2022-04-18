package dev.enyk.res;

import org.lwjgl.glfw.GLFW;

import dev.enyk.res.wiki.WikiGUI;
import dev.enyk.res.wiki.WikiScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.LiteralText;

public class RoughlyEnoughSkyblockClient implements ClientModInitializer {

    private static KeyBinding keyBinding;

    @Override
    public void onInitializeClient() {
        KeyBinding openWiki = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.roughlyenoughskyblock.openWiki",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_LEFT_ALT,
            "category.roughlyenoughskyblock.openWiki"
        ));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openWiki.wasPressed()) {
                MinecraftClient.getInstance().setScreen(new WikiScreen(new WikiGUI()));
            }
        });
    }
    
}
