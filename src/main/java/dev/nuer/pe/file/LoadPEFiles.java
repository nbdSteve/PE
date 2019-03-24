package dev.nuer.pe.file;

import dev.nuer.pe.file.providedfile.GeneratePEFiles;
import dev.nuer.pe.PE;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

/**
 * Class to load a specified file, to create a new file simply add the name of it to the ENUM.
 * Then add another line to the LoadProvidedFiles method and create a getter for that file.
 */
public class LoadPEFiles {
    //Register main class
    private Plugin pl = PE.getPlugin(PE.class);
    //Hashmap to store files
    private HashMap<Files, GeneratePEFiles> fileList;

    /**
     * Enum to store each file, this is public so we can call method on these
     */
    public enum Files {
        CONFIG, MESSAGES, ENCHANTMENTS, GUI
    }

    /**
     * Generate all of the files in the enum
     */
    public LoadPEFiles() {
        fileList = new HashMap<>();
        fileList.put(Files.CONFIG, new GeneratePEFiles("config.yml"));
        fileList.put(Files.MESSAGES, new GeneratePEFiles("messages.yml"));
        fileList.put(Files.ENCHANTMENTS, new GeneratePEFiles("enchantments.yml"));
        fileList.put(Files.GUI, new GeneratePEFiles("gui.yml"));
        pl.getLogger().info("Loading provided files...");
    }

    public FileConfiguration getConfig() {
        return fileList.get(Files.CONFIG).get();
    }

    public FileConfiguration getMessages() {
        return fileList.get(Files.MESSAGES).get();
    }

    public FileConfiguration getEnchantments() {
        return fileList.get(Files.ENCHANTMENTS).get();
    }

    public FileConfiguration getGui() {
        return fileList.get(Files.GUI).get();
    }

    public void reload() {
        for (Files file : Files.values()) {
            fileList.get(file).reload();
        }
        pl.getLogger().info("Reloading provided files...");
    }
}
