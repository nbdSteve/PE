package dev.nuer.pe.method;

import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.List;

public class GetBookNumber {

    public static String getBookNumber(HashMap<Integer, String> enchantments, List<String> bookLore) {
        for (int i = 1; i <= enchantments.size(); i++) {
            if (bookLore.contains(ChatColor.translateAlternateColorCodes('&', enchantments.get(i)))) {
                return String.valueOf(i);
            }
        }
        return null;
    }
}
