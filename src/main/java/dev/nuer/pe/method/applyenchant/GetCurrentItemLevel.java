package dev.nuer.pe.method.applyenchant;

import dev.nuer.pe.file.LoadPEFiles;
import dev.nuer.pe.method.inventory.RomanNumber;
import org.bukkit.ChatColor;

import java.util.List;

public class GetCurrentItemLevel {

    public static int getCurrentLevel(List<String> lore, LoadPEFiles files, String bookNumber) {
        List<String> enchantmentLore = files.getEnchantments().getStringList(bookNumber +
                ".enchantment-lore");
        for (String line : lore) {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                String[] enchantment = enchantmentLore.get(0).split(" ");
                System.out.println(ChatColor.stripColor(enchantment[0] + " " + RomanNumber.toRomanNumeral(i)));
                System.out.println(lore);
                if (line.contains(ChatColor.stripColor(enchantment[0] + " " + RomanNumber.toRomanNumeral(i)))) {
                    return i;
                }
            }
        }
        return 0;
    }
}