package me.binomial.pe.event;

import me.binomial.pe.PE;
import me.binomial.pe.file.LoadPEFiles;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;

public class EnchantmentApplyEvent {
    //Register main class
    private Plugin plugin = PE.getPlugin(PE.class);
    //Register plugin files
    private LoadPEFiles files = ((PE) plugin).getFiles();

    @EventHandler
    public void onApply(InventoryClickEvent applyEvent) {
        if (applyEvent.getAction().equals(InventoryAction.SWAP_WITH_CURSOR)) {

        }
    }
}
