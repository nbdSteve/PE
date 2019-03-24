package dev.nuer.pe.command;

import dev.nuer.pe.PE;
import dev.nuer.pe.gui.Enchanter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PeCommand implements CommandExecutor {
    private PE plugin;
    public PeCommand(PE plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("ce")
                || command.getName().equalsIgnoreCase("enchanter")
                || command.getName().equalsIgnoreCase("pe")) {
            new Enchanter().enchanterGui((Player) sender);
        }
        return true;
    }
}
