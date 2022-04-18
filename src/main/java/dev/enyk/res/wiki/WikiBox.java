package dev.enyk.res.wiki;

import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.util.math.MatrixStack;

public class WikiBox extends WWidget {
    
    private String text;
    private int width;
    private int height = 15;

    public WikiBox(String text, boolean longBox) {
        this.text = text;
        if (longBox) {
            this.width = 165;
        }
    }

    public WikiBox(String text) {
        this.text = text;
        this.width = 80;
    }

    public WikiBox(String text, int width, int height) {
        this.text = text;
        this.width = width;
        this.height = height;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        ScreenDrawing.coloredRect(matrices, x, y, width, height, 0xff000000);
        ScreenDrawing.coloredRect(matrices, x + 1, y + 1, width - 2, height - 2, 0xffffffff);

        ScreenDrawing.drawString(matrices, text, x + 5, y + 4 + (int)((height - 15) / 2), 0xff000000);
        
    }
}
