package dev.nuer.pe.method;

import org.bukkit.ChatColor;
import org.bukkit.inventory.meta.ItemMeta;

public class GetBookLevel {

    public static int getBookLevel(ItemMeta itemMeta) {
        String[] bookLevel = itemMeta.getDisplayName().split(" ");
        switch (ChatColor.translateAlternateColorCodes('&', bookLevel[bookLevel.length - 1])) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                return 1;
        }
    }
}
