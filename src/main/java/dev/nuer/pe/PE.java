package dev.nuer.pe;

import dev.nuer.pe.command.PeCommand;
import dev.nuer.pe.event.EnchantApplyEvent;
import dev.nuer.pe.event.GuiBuyEvent;
import dev.nuer.pe.file.LoadPEFiles;
import dev.nuer.pe.method.RegisterEnchantments;
import dev.nuer.pe.method.armorequiplistener.ArmorListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;


public final class PE extends JavaPlugin {
    //Instance of the plugin files
    private LoadPEFiles files;
    //Load all of the enchantments from the enchantments.yml
    private HashMap<Integer, String> enchantments;

    @Override
    public void onEnable() {
        getLogger().info("Thanks for using PE!");
        //Generate all of the plugin files
        this.files = new LoadPEFiles();
        //Register the enchantments from enchantments.yml
        this.enchantments = new RegisterEnchantments().registerEnchantments(files, this);

        //Register the armor equip event listener by Borlea
        getServer().getPluginManager().registerEvents(new ArmorListener(files.getConfig().getStringList(
                "blocked")), this);

        getServer().getPluginManager().registerEvents(new GuiBuyEvent(), this);
        getServer().getPluginManager().registerEvents(new EnchantApplyEvent(), this);
        getCommand("pe").setExecutor(new PeCommand(this));
        getCommand("ce").setExecutor(new PeCommand(this));
        getCommand("enchanter").setExecutor(new PeCommand(this));
    }

    @Override
    public void onDisable() {

    }

    /**
     * Getter for the plugin files
     *
     * @return files instance
     */
    public LoadPEFiles getFiles() {
        return files;
    }

    public HashMap<Integer, String> getEnchantments() {
        return enchantments;
    }
}
