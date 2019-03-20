package me.binomial.pe.method.inventory;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CursorCheck {

    public CursorCheck(InventoryClickEvent inventoryClickEvent, Player player) {
        isValidItem(inventoryClickEvent);
    }

    private boolean isValidItem(InventoryClickEvent inventoryClickEvent) {
        if (inventoryClickEvent.getCurrentItem() != null) {
            if (inventoryClickEvent.getCurrentItem().getType() != Material.AIR) {
                if (inventoryClickEvent.getCurrentItem().hasItemMeta()) {
                    if (inventoryClickEvent.getCurrentItem().getItemMeta().hasLore()) {
                        if (inventoryClickEvent.getCurrentItem().getItemMeta().getDisplayName() != (" ") ||
                                inventoryClickEvent.getCurrentItem().getItemMeta().getDisplayName() != null) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
