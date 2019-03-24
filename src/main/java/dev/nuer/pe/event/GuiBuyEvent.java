package dev.nuer.pe.event;

import dev.nuer.pe.PE;
import dev.nuer.pe.file.LoadPEFiles;
import dev.nuer.pe.method.inventory.RomanNumber;
import dev.nuer.pe.method.cosmetic.SpawnFirework;
import dev.nuer.pe.method.CheckItemIsValid;
import dev.nuer.pe.method.inventory.ExpCheck;
import dev.nuer.pe.method.GetBookNumber;
import dev.nuer.pe.method.itemcreation.CraftItem;
import dev.nuer.pe.method.message.PlayerMessage;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Random;

/**
 * Class that handles when a player is buying a custom enchantment book
 */
public class GuiBuyEvent implements Listener {
    //Register main class
    private Plugin plugin = PE.getPlugin(PE.class);
    //Register plugin files
    private LoadPEFiles files = ((PE) plugin).getFiles();
    //Instance of registered enchantments hashmap
    private HashMap<Integer, String> enchantments = ((PE) plugin).getEnchantments();

    @EventHandler
    public void onGuiClick(InventoryClickEvent guiBuyEvent) {
        //Check that this is the enchanter gui
        if (guiBuyEvent.getInventory().getName().equals(ChatColor.translateAlternateColorCodes('&', files.getGui().getString("name")))) {
            guiBuyEvent.setCancelled(true);
            //Create an instance of this class, so we can get the item lore and meta
            CheckItemIsValid validItem = new CheckItemIsValid();
            //Get the player
            Player player = (Player) guiBuyEvent.getWhoClicked();
            //Store the book number
            String bookNumber;
            //Check that the item they are clicking is an actual book
            if (validItem.isInventoryClickValid(guiBuyEvent)) {
                //Get the book number from the hashmap of registered enchantments
                bookNumber = GetBookNumber.getBookNumber(enchantments, validItem.getItemLore());
                //Check that the player has space in their inventory
                if (player.getInventory().firstEmpty() != -1) {
                    //Check to see if the player has enough exp, then subtract it
                    if (ExpCheck.checkPlayer(player, files, bookNumber)) {
                        player.setLevel(player.getLevel() - files.getEnchantments().getInt(bookNumber + ".exp-cost"));
                        int bookLevel = new Random().nextInt(files.getEnchantments().getInt(bookNumber + ".max-level") + 1);
                        String romanNumeral = RomanNumber.toRomanNumeral(bookLevel);
                        player.getInventory().addItem(CraftItem.craftItem(bookNumber, Material.getMaterial(files.getEnchantments().getString(bookNumber + ".material").toUpperCase()), files, romanNumeral));
                        new SpawnFirework(player);
                        new PlayerMessage("successful-purchase", player, files);
                    } else {
                        new PlayerMessage("insufficient-exp", player, files);
                    }
                } else {
                    new PlayerMessage("inventory-full", player, files);
                    player.closeInventory();
                }
            }
        }
    }
}