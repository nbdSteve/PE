package dev.nuer.pe.method;

import dev.nuer.pe.file.LoadPEFiles;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public class RegisterEnchantments {

    public HashMap<Integer, String> registerEnchantments(LoadPEFiles files, Plugin plugin) {
        HashMap<Integer, String> enchantments = new HashMap<>();
        int enchantmentsRegistered = 0;
        for (int i = 1; i < 300; i++) {
            if (files.getEnchantments().getBoolean(i + ".enabled")) {
                enchantments.put(i, files.getEnchantments().getString(i + ".unique"));
                enchantmentsRegistered++;
            }
        }
        plugin.getLogger().info("Successfully registered " + enchantmentsRegistered + " enchantment(s).");
        return enchantments;
    }
}
