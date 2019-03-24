package dev.nuer.pe.method.message;

import dev.nuer.pe.file.LoadPEFiles;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Class that handles sending messages to a player
 */
public class PlayerMessage {

    /**
     * Send a default message to the player
     *
     * @param filePath the message to be sent
     * @param p        the player to send to
     * @param files    LoadPEFiles instance
     */
    public PlayerMessage(String filePath, Player p, LoadPEFiles files) {
        for (String line : files.getMessages().getStringList(filePath)) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    /**
     * Send a message that has a placeholder in it
     *
     * @param filePath    the message to be sent
     * @param p           the player to send to
     * @param files       LoadPEFiles instance
     * @param placeHolder the thing to replace
     * @param replacement the replacement
     */
    public PlayerMessage(String filePath, Player p, LoadPEFiles files, String placeHolder,
                         String replacement) {
        for (String line : files.getMessages().getStringList(filePath)) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', line).replace(placeHolder,
                    replacement));
        }
    }
}