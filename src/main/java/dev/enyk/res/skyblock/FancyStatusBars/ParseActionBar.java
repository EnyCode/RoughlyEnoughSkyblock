package dev.enyk.res.skyblock.FancyStatusBars;

import java.util.Map;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ParseActionBar {
    // §c120/120❤     §a10§a❈ Defense     §b100/100✎ Mana

    

    public static Map<String, Integer> statsParser(String overlayMessage) {
        
        final Pattern HealthParser = Pattern.compile("(?<health>[0-9]+)/(?<maxHealth>[0-9]+)❤(?<wand>\\\\+(?<wandHeal>[0-9]+)[▆▅▄▃▂▁])?     (?<defense>[0-9]+)?(❈ Defense)?(?<other>( (?<align>\\\\|\\\\|\\\\|))?(?<manaLoss>-[0-9]+)?( {2}(?<tether>T[0-9]+!?))?.*)?     (?<mana>[0-9,]+)/(?<maxMana>[0-9,]+)✎(| Mana| (?<overflow>-?[0-9,]+)ʬ)");
        final String noColorMessage = overlayMessage.replaceAll("§.", "");
        final Matcher normalMatch = HealthParser.matcher(noColorMessage);

        Map<String, Integer> stats = new HashMap<>();

        if (normalMatch.matches()) {
            
            /*stats.add(normalMatch.group("health"));
            stats.add(normalMatch.group("maxHealth"));
            stats.add(normalMatch.group("mana"));
            stats.add(normalMatch.group("maxMana"));*/

            stats.put("health", Integer.parseInt(normalMatch.group("health")));
            stats.put("maxHealth", Integer.parseInt(normalMatch.group("maxHealth")));
            stats.put("mana", Integer.parseInt(normalMatch.group("mana")));
            stats.put("maxMana", Integer.parseInt(normalMatch.group("maxMana")));
        }

        return stats;
    }

}