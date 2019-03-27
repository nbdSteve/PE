package dev.nuer.pe.method;

import dev.nuer.pe.file.LoadPEFiles;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemMetaMethods {

    public static void setDisplayName(String filePath, ItemMeta itemMeta, LoadPEFiles files) {
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',
                files.getEnchantments().getString(filePath)));
    }

    public static void setDisplayName(String filePath, ItemMeta itemMeta, LoadPEFiles files, String romanNumeral) {
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',
                files.getEnchantments().getString(filePath)) + " " + romanNumeral);
    }


    public static void addLore(String filePath, List<String> lore, LoadPEFiles files) {
        for (String line : files.getEnchantments().getStringList(filePath)) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addLore(String filePath, List<String> lore, LoadPEFiles files,
                               String placeholder, String replacement) {
        for (String line : files.getEnchantments().getStringList(filePath)) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line).replace(placeholder,
                    replacement));
        }
    }

    public static void removeLore(String loreToRemove, List<String> lore) {
        for (String line : lore) {
            if (line.equals(ChatColor.translateAlternateColorCodes('&', loreToRemove))) {
                lore.remove(line);
            }
        }
    }

    public static void setItemMetaAndLore(ItemStack item, ItemMeta itemMeta, List<String> itemLore) {
        itemMeta.setLore(itemLore);
        item.setItemMeta(itemMeta);
    }
}
