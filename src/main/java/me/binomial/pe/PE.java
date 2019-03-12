package me.binomial.pe;

import me.binomial.pe.file.LoadPEFiles;
import me.binomial.pe.method.armorequiplistener.ArmorListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class PE extends JavaPlugin {
    //Instance of the plugin files
    private LoadPEFiles files;

    @Override
    public void onEnable() {
        getLogger().info("Thanks for using PE!");
        //Generate all of the plugin files
        this.files = new LoadPEFiles();

        //Register the armor equip event listener by Borlea
        getServer().getPluginManager().registerEvents(new ArmorListener(files.getConfig().getStringList(
                "blocked")), this);
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
}
