package dev.nuer.pe.method.inventory;

import dev.nuer.pe.file.LoadPEFiles;
import org.bukkit.entity.Player;

public class ExpCheck {

    public static boolean checkPlayer(Player player, LoadPEFiles files, String bookNumber) {
        if (player.getLevel() > files.getEnchantments().getInt(bookNumber + ".exp-cost")) {
            return true;
        }
        return false;
    }
}
