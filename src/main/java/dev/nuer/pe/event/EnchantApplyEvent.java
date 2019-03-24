package dev.nuer.pe.event;

import dev.nuer.pe.PE;
import dev.nuer.pe.file.LoadPEFiles;
import dev.nuer.pe.method.CheckItemIsValid;
import dev.nuer.pe.method.GetBookNumber;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public class EnchantApplyEvent implements Listener {
    //Register main class
    private Plugin plugin = PE.getPlugin(PE.class);
    //Register plugin files
    private LoadPEFiles files = ((PE) plugin).getFiles();
    private HashMap<Integer, String> enchantments = ((PE) plugin).getEnchantments();

    @Override
    public void enchantApply(InventoryClickEvent applyEvent) {
        if (applyEvent.getAction().equals(InventoryAction.SWAP_WITH_CURSOR)) {
            CheckItemIsValid validItem = new CheckItemIsValid();
            Player player = (Player) applyEvent.getWhoClicked();
            String bookNumber;
            if (validItem.isInventoryClickValid(applyEvent)) {
                bookNumber = GetBookNumber.getBookNumber(enchantments, validItem.getItemLore());
                if (validItem.getItem().getType().equals())
            }
        }
    }
}
