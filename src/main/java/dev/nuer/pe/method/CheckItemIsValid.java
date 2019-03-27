package dev.nuer.pe.method;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class CheckItemIsValid {
    private ItemStack currentItem;
    private ItemStack cursorItem;

    public boolean isInventoryCurrentItemValid(InventoryClickEvent inventoryClickEvent) {
        if (inventoryClickEvent.getCurrentItem() != null) {
            if (inventoryClickEvent.getCurrentItem().getType() != Material.AIR) {
                if (inventoryClickEvent.getCurrentItem().hasItemMeta()) {
                    if (inventoryClickEvent.getCurrentItem().getItemMeta().hasLore()) {
                        if (inventoryClickEvent.getCurrentItem().getItemMeta().getDisplayName() != (" ") ||
                                inventoryClickEvent.getCurrentItem().getItemMeta().getDisplayName() != null) {
                            this.currentItem = inventoryClickEvent.getCurrentItem();
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isInventoryCursorItemValid(InventoryClickEvent inventoryClickEvent) {
        if (inventoryClickEvent.getCursor() != null) {
            if (inventoryClickEvent.getCursor().getType() != Material.AIR) {
                if (inventoryClickEvent.getCursor().hasItemMeta()) {
                    if (inventoryClickEvent.getCursor().getItemMeta().hasLore()) {
                        if (inventoryClickEvent.getCursor().getItemMeta().getDisplayName() != (" ") ||
                                inventoryClickEvent.getCursor().getItemMeta().getDisplayName() != null) {
                            this.cursorItem = inventoryClickEvent.getCursor();
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public ItemStack getCurrentItem() {
        return currentItem;
    }

    public ItemMeta getCurrentItemMeta() {
        return currentItem.getItemMeta();
    }

    public List<String> getCurrentItemLore() {
        return currentItem.getItemMeta().getLore();
    }

    public ItemStack getCursorItem() {
        return cursorItem;
    }

    public ItemMeta getCursorItemMeta() {
        return cursorItem.getItemMeta();
    }

    public List<String> getCursorItemLore() {
        return cursorItem.getItemMeta().getLore();
    }
}
