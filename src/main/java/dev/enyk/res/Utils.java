package dev.enyk.res;

import net.minecraft.client.MinecraftClient;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.scoreboard.ScoreboardPlayerScore;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.Formatting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {
    
    public static boolean isOnSkyblock = false;
    public static boolean isInDungeons = false;
    public static boolean isInjected = false;

    public static boolean inSkyblock() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player.getScoreboard() != null) {
            if (getSidebar().get(0).contains("SKYBLOCK")) {
                return true;
            }
        }
        return false;
    }

    public static List<String> getSidebar() {
        try {
            assert MinecraftClient.getInstance().player != null;
            Scoreboard scoreboard = MinecraftClient.getInstance().player.getScoreboard();
            ScoreboardObjective objective = scoreboard.getObjectiveForSlot(1);
            List<String> lines = new ArrayList<>();
            for (ScoreboardPlayerScore score : scoreboard.getAllPlayerScores(objective)) {
                Team team = scoreboard.getPlayerTeam(score.getPlayerName());
                if (team != null) {
                    String line = team.getPrefix().getString() + team.getSuffix().getString();
                    if (line.trim().length() > 0) {
                        String formatted = Formatting.strip(line);
                        lines.add(formatted);
                    }
                }
            }

            if (objective != null) {
                lines.add(objective.getDisplayName().getString());
                Collections.reverse(lines);
            }
            return lines;
        } catch (NullPointerException e) {
            return null;
        }
    }
}
