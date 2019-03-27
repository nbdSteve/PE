package dev.nuer.pe.event;

import dev.nuer.pe.PE;
import dev.nuer.pe.file.LoadPEFiles;
import dev.nuer.pe.method.CheckItemIsValid;
import dev.nuer.pe.method.GetBookLevel;
import dev.nuer.pe.method.GetBookNumber;
import dev.nuer.pe.method.ItemMetaMethods;
import dev.nuer.pe.method.applyenchant.GetCurrentItemLevel;
import dev.nuer.pe.method.inventory.RomanNumber;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EnchantApplyEvent implements Listener {
    //Register main class
    private Plugin plugin = PE.getPlugin(PE.class);
    //Register plugin files
    private LoadPEFiles files = ((PE) plugin).getFiles();
    private HashMap<Integer, String> enchantments = ((PE) plugin).getEnchantments();

    @EventHandler
    public void enchantApply(InventoryClickEvent applyEvent) {
        if (applyEvent.getAction().equals(InventoryAction.SWAP_WITH_CURSOR)) {
            CheckItemIsValid validItem = new CheckItemIsValid();
            Player player = (Player) applyEvent.getWhoClicked();
            String bookNumber;
            if (validItem.isInventoryCursorItemValid(applyEvent)) {
                bookNumber = GetBookNumber.getBookNumber(enchantments, validItem.getCursorItemLore());
                if (applyEvent.getCurrentItem().getType().toString().contains(files.getEnchantments().getString(bookNumber + ".active-item").toUpperCase())) {
                    ItemMeta currentItemMeta = applyEvent.getCurrentItem().getItemMeta();
                    List<String> newCurrentItemLore = new ArrayList<>();
                    if (applyEvent.getCurrentItem().getItemMeta().hasLore()) {
                        newCurrentItemLore = applyEvent.getCurrentItem().getItemMeta().getLore();
                    }
                    if (!applyEvent.getCurrentItem().hasItemMeta()
                            || GetCurrentItemLevel.getCurrentLevel(applyEvent.getCurrentItem().getItemMeta().getLore(), files, bookNumber) == 0) {
                        ItemMetaMethods.addLore(bookNumber + ".enchantment-lore",
                                newCurrentItemLore, files, "%Level",
                                RomanNumber.toRomanNumeral(GetBookLevel.getBookLevel(validItem.getCursorItemMeta())));
                        currentItemMeta.setLore(newCurrentItemLore);
                        applyEvent.getCurrentItem().setItemMeta(currentItemMeta);
                    } else if (GetCurrentItemLevel.getCurrentLevel(applyEvent.getCurrentItem().getItemMeta().getLore(),
                            files, bookNumber) <= GetBookLevel.getBookLevel(validItem.getCursorItemMeta())) {
                        ItemMetaMethods.removeLore(files.getEnchantments().getString(bookNumber + ".enchantment-lore"), newCurrentItemLore);
                        ItemMetaMethods.addLore(bookNumber + ".enchantment-lore",
                                newCurrentItemLore, files, "%Level",
                                RomanNumber.toRomanNumeral(GetBookLevel.getBookLevel(validItem.getCursorItemMeta())));
                        currentItemMeta.setLore(newCurrentItemLore);
                        applyEvent.getCurrentItem().setItemMeta(currentItemMeta);
                    }
                }
            }
        }
    }
}