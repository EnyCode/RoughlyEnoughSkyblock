package dev.enyk.res.wiki;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import io.github.cottonmc.cotton.gui.widget.data.Insets;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import dev.enyk.res.RoughlyEnoughSkyblock;
import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;

public class WikiGUI extends LightweightGuiDescription {

    private String titleText;
    private String author;
    private String[] descriptionText;
    private ArrayList<String> wrappedDescription = new ArrayList<>();

    private ArrayList<String> sections;
    private Map<String, String> infoBox = new HashMap<>();
    private ArrayList<String> infoKeys = new ArrayList<>();

    public WikiGUI() {

        WPlainPanel root = new WPlainPanel();
        setRootPanel(root);
        root.setSize(284, 180);
        root.setInsets(Insets.ROOT_PANEL);

        // Hardcode

        titleText = "Aspect of the End";
        author = "Hypixel Skyblock Wiki Team";

        descriptionText = "The Aspect of the End, frequently abbreviated as AOTE, is a Rare Sword unlocked at Ender Pearl VIII. Its ability teleports the user 8 blocks whichever direction the player is looking. It also grants +50 Speed for 3 seconds after teleporting. ".split(" ", -1);

        infoBox = new TreeMap<>();
        infoBox.put("Aspect of the End", "section");
        infoBox.put("Also known as", "AOTE");
        infoBox.put("Type", "Weapon");
        infoBox.put("Rarity", "Rare");
        infoBox.put("Collection", "Ender Pearl VIII");
        infoBox.put("Source", "Crafting");

        // Sprite setup

        WSprite book = new WSprite(new Identifier("roughlyenoughskyblock", "textures/gui/book.png"));
        root.add(book, 12, 0, 408, 270);

        WSprite bookmark = new WSprite(new Identifier("roughlyenoughskyblock", "textures/gui/bookmark.png"));
        root.add(bookmark, 0, 18, 210, 47);

        /*

        WLabel title = new WLabel("Aspect of the End", 0xffffdc3c);
        root.add(title, 35, 26);

        WLabel description = new WLabel("A sword to rival them all...", 0xffc7aa25);
        root.add(description, 45, 35);

        // Main Description
        WLabel mainDescriptionOne = new WLabel("The Aspect of the End, frequently", 0xff000000);// abbreviated as AOTE, is a Rare Sword unlocked at Ender Pearl VIII. Its ability teleports the user 8 blocks whichever direction the player is looking. It also grants +50 Speed for 3 seconds after teleporting. "), 0xff000000);
        root.add(mainDescriptionOne, 35, 60);

        WLabel mainDescriptionTwo = new WLabel("abbreviated as AOTE, is a Rare", 0xff000000);// Sword unlocked at Ender Pearl VIII. Its ability teleports the user 8 blocks whichever direction the player is looking. It also grants +50 Speed for 3 seconds after teleporting. "), 0xff000000);"))

        WLabel mainDescriptionThree = new WLabel("Sword unlocked at Ender Pearl", 0xff000000);

        WLabel mainDescriptionFour = new WLabel("VIII. Its ability teleports the", 0xff000000);

        WLabel mainDescriptionFive = new WLabel("user 8 blocks whichever direction", 0xff000000);

        WLabel mainDescriptionSix = new WLabel("the player is looking. It also", 0xff000000); 

        WLabel mainDescriptionSeven = new WLabel("grants +50 Speed for 3 seconds", 0xff000000);

        WLabel mainDescriptionEight = new WLabel("after teleporting.", 0xff000000);

        root.add(mainDescriptionTwo, 35, 70);
        root.add(mainDescriptionThree, 35, 80);
        root.add(mainDescriptionFour, 35, 90);
        root.add(mainDescriptionFive, 35, 100);
        root.add(mainDescriptionSix, 35, 110);
        root.add(mainDescriptionSeven, 35, 120);
        root.add(mainDescriptionEight, 35, 130);

        WikiBox obtaining = new WikiBox("Obtaining");
        root.add(obtaining, 35, 150);

        WikiBox usage = new WikiBox("Usage");
        root.add(usage, 120, 150);

        WikiBox timeToObtain = new WikiBox("Time to obtain using a minion", true);
        root.add(timeToObtain, 35, 170);

        WikiBox trivia = new WikiBox("Trivia");
        root.add(trivia, 35, 190);

        WikiBox history = new WikiBox("History");
        root.add(history, 120, 190);

        // Info box
        WikiBox infoTitle = new WikiBox("Aspect of the End", 159, 20);

        WikiBox knownAs = new WikiBox("Also known as");
        WikiBox knownAsAnswer = new WikiBox("AOTE");

        WikiBox type = new WikiBox("Type");
        WikiBox typeAnswer = new WikiBox("Weapon");

        WikiBox rarity = new WikiBox("Rarity");
        WikiBox rarityAnswer = new WikiBox("Rare");

        WikiBox collection = new WikiBox("Collection");
        WikiBox collectionAnswer = new WikiBox("Ender Pearl 8");

        WikiBox source = new WikiBox("Also known as");
        WikiBox sourceAnswer = new WikiBox("AOTE");

        WikiBox statsTitle = new WikiBox("Stats", true);

        root.add(infoTitle, 230, 25);
        root.add(knownAs, 230, 44);
        root.add(knownAsAnswer, 309, 44);
        root.add(type, 230, 57);
        root.add(typeAnswer, 309, 57);
        root.add(rarity, 230, 71);
        root.add(rarityAnswer, 309, 71);
        root.add(collection, 230, 85);
        root.add(collectionAnswer, 309, 85);
        root.add(source, 230, 99);
        root.add(sourceAnswer, 309, 99);
        */

        // TODO: Use array and for loop for descriptions, 33 character limit

        // Add title and author
        WLabel title = new WLabel(titleText, 0xffffdc3c);
        root.add(title, 35, 26);

        WLabel description = new WLabel("By " + author, 0xffc7aa25);
        root.add(description, 45, 37);

        // Turn description into wrapped text
        for (String word : descriptionText) {
            String lastItem = wrappedDescription.size() == 0 ? "" : wrappedDescription.get(wrappedDescription.size() - 1);
            if (wrappedDescription.size() == 0 || (lastItem.length() + word.length()) >= 33) {
                wrappedDescription.add(word);
            } else {
                lastItem += " " + word;
                wrappedDescription.set(wrappedDescription.size() - 1, lastItem);
            }
        }

        // Render wrapped text
        for (int count = 0; count < wrappedDescription.size(); count++) {
            root.add(new WLabel(wrappedDescription.get(count), 0xff000000), 35, count * 10 + 60);
        }

        // Get a list of keys
        for (String key : infoBox.keySet()) {
            infoKeys.add(key);
        }

        int y = 25;
        for (int count = 0; count < infoBox.size(); count++) {
            String key = infoKeys.get(count);
            if (infoBox.get(key) == "section") {
                root.add(new WikiBox(key, 159, 20), 230, y);
                y += 19;
            } else {
                root.add(new WikiBox(key), 230, y);
                root.add(new WikiBox(infoBox.get(key)), 309, y);
                y += 14;
            }
        }

        root.validate(this);
    }

    // Remove background to allow book sprite
    @Environment(EnvType.CLIENT)
    @Override
    public void addPainters() {
        rootPanel.setBackgroundPainter(null);
    }
}
