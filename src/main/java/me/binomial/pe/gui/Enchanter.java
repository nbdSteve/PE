package me.binomial.pe.gui;

import me.binomial.pe.PE;
import me.binomial.pe.file.LoadPEFiles;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

public class Enchanter {
    //Register main class
    private Plugin plugin = PE.getPlugin(PE.class);
    //Register plugin files
    private LoadPEFiles files = ((PE) plugin).getFiles();

    public void enchanterGui(Player player) {
        //Create gui
        Inventory gui = plugin.getServer().createInventory(null, files.getGui().getInt("size"),
                ChatColor.translateAlternateColorCodes('&', files.getGui().getString("name")));
        addBooksToGui(gui);
        player.openInventory(gui);
    }

    private void addBooksToGui(Inventory inventory) {

    }
}
