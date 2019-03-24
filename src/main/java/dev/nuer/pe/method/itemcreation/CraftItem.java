package dev.nuer.pe.method.itemcreation;

import dev.nuer.pe.file.LoadPEFiles;
import dev.nuer.pe.method.ItemMetaMethods;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CraftItem {

    public static ItemStack craftItem(String bookNumber, Material itemMaterial, LoadPEFiles files, String romanNumeral) {
        ItemStack item = new ItemStack(itemMaterial);
        ItemMeta itemMeta = item.getItemMeta();
        List<String> itemLore = new ArrayList<>();
        ItemMetaMethods.setDisplayName(bookNumber + ".name", itemMeta, files, romanNumeral);
        ItemMetaMethods.addLore(bookNumber + ".lore", itemLore, files, romanNumeral);
        if (files.getEnchantments().getBoolean(bookNumber + ".glowing")) {
            itemMeta.addEnchant(Enchantment.LURE, 10, true);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        ItemMetaMethods.setItemMetaAndLore(item, itemMeta, itemLore);
        return item;
    }
}
