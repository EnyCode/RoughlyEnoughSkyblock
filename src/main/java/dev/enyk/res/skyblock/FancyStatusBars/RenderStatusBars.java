package dev.enyk.res.skyblock.FancyStatusBars;

import java.util.Map;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider.Immediate;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class RenderStatusBars {
    private MinecraftClient mc = MinecraftClient.getInstance();

    private int health = 100;
    private int maxHealth = 100;
    private int mana = 50;
    private int maxMana = 50;

    // Update all the values necessary
    public void update(String message) {
        // Parse the action bar
        Map<String, Integer> stats = ParseActionBar.statsParser(message);
        if (stats.size() != 0) {
            // Update variables
            health = stats.get("health");
            maxHealth = stats.get("maxHealth");
            mana = stats.get("mana");
            maxMana = stats.get("maxMana");
        }
    }

    // Render the actual status bar
    public void renderAll(MatrixStack matrixStack) {
        // Get height and width of Minecraft
        int height = mc.getWindow().getScaledHeight();
        int width = mc.getWindow().getScaledWidth();

        // Load texture
        final Identifier barTex = new Identifier("roughlyenoughskyblock", "textures/gui/bars.png");

        // Coords for the health bar
        int barXCoord = width / 2 - 91;
        int barYCoord = height - 37;

        RenderSystem.setShaderTexture(0, barTex);

        // Render health bar
        mc.inGameHud.drawTexture(matrixStack, barXCoord, barYCoord, 0, 9, 75, 7);
        mc.inGameHud.drawTexture(matrixStack, barXCoord, barYCoord, 0, 16,
                Math.round(4 + health / (float) maxHealth * 67), 7);

        // Render mana bar
        mc.inGameHud.drawTexture(matrixStack, barXCoord + 107, barYCoord, 0, 9, 75, 7);
        mc.inGameHud.drawTexture(matrixStack, barXCoord + 107, barYCoord, 0, 23,
                Math.round(4 + mana / (float) maxMana * 67), 7);

        // Setup text renders
        Immediate vertexConsumer = mc.getBufferBuilders().getEntityVertexConsumers();

        // Render health text
        OrderedText healthText = Text.of(health + "/" + maxHealth).asOrderedText();
        mc.textRenderer.drawWithOutline(healthText, barXCoord + ((75 - mc.textRenderer.getWidth(healthText)) / 2),
                barYCoord - 5, 0xffff5659, 0xff000000, matrixStack.peek().getPositionMatrix(), vertexConsumer, 255);
        vertexConsumer.draw();

        // Render mana text
        OrderedText manaText = Text.of(mana + "/" + maxMana).asOrderedText();
        mc.textRenderer.drawWithOutline(manaText, barXCoord + 106 + ((75 - mc.textRenderer.getWidth(manaText)) / 2),
                barYCoord - 5, 0xff00fcfb, 0xff000000, matrixStack.peek().getPositionMatrix(), vertexConsumer, 255);
        vertexConsumer.draw();
    }

}
