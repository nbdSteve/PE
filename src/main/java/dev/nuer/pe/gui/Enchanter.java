package dev.nuer.pe.gui;

import dev.nuer.pe.PE;
import dev.nuer.pe.file.LoadPEFiles;
import dev.nuer.pe.method.itemcreation.CraftItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public class Enchanter {
    //Register main class
    private Plugin plugin = PE.getPlugin(PE.class);
    //Register plugin files
    private LoadPEFiles files = ((PE) plugin).getFiles();
    private HashMap<Integer, String> enchantments = ((PE) plugin).getEnchantments();

    public void enchanterGui(Player player) {
        //Create gui
        Inventory gui = plugin.getServer().createInventory(null, files.getGui().getInt("size"),
                ChatColor.translateAlternateColorCodes('&', files.getGui().getString("name")));
        addBooksToGui(gui);
        player.openInventory(gui);
    }

    private void addBooksToGui(Inventory inventory) {
        for (int i = 1; i <= 55; i++) {
            if (enchantments.containsKey(i)) {
                ItemStack book =  CraftItem.craftItem(String.valueOf(i), Material.getMaterial(files.getEnchantments().getString(i + ".material").toUpperCase()),
                        files, ChatColor.translateAlternateColorCodes('&', "&k{}"));
                inventory.setItem(files.getEnchantments().getInt(i + ".gui-slot"), book);
            }
        }
    }
}
