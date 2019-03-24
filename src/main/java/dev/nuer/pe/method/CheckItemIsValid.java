package dev.nuer.pe.method;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class CheckItemIsValid {
    private ItemStack item;

    public boolean isInventoryClickValid(InventoryClickEvent inventoryClickEvent) {
        if (inventoryClickEvent.getCurrentItem() != null) {
            if (inventoryClickEvent.getCurrentItem().getType() != Material.AIR) {
                if (inventoryClickEvent.getCurrentItem().hasItemMeta()) {
                    if (inventoryClickEvent.getCurrentItem().getItemMeta().hasLore()) {
                        if (inventoryClickEvent.getCurrentItem().getItemMeta().getDisplayName() != (" ") ||
                                inventoryClickEvent.getCurrentItem().getItemMeta().getDisplayName() != null) {
                            this.item = inventoryClickEvent.getCurrentItem();
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public ItemStack getItem() {
        return item;
    }

    public ItemMeta getItemMeta() {
        return item.getItemMeta();
    }

    public List<String> getItemLore() {
        return item.getItemMeta().getLore();
    }
}
