package me.sachal2406.hubgadgets;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Config {
    private static FileConfiguration config = null;
    private static File configFile = null;
    
    public static void load() {
        config = getConfig();
        
        config.options().header(
        		"############################################################\n" +
        		"# +------------------------------------------------------+ #\n" +
        		"# |             HubGadgets Configuration file            | #\n" +
        		"# +------------------------------------------------------+ #\n" +
        		"############################################################");
        
        config.addDefault("Main-Messages.Prefix", "&7[&cHub Gadgets&7]: &a");
        config.addDefault("Main-Messages.Config-Reloaded", "&aconfig reloaded");
        config.addDefault("MobGuns.Time-Between-Two-Uses", (int)4);
        config.addDefault("MobGuns.Messages.Pig-Launched", "Pig Launched !");
        config.addDefault("MobGuns.Messages.Sheep-Launched", "Sheep Launched !");
        config.addDefault("MobGuns.Messages.Creeper-Launched", "Creeper Launched !");
        config.addDefault("MobGuns.Messages.Villager-Launched", "Villager Launched !");
        config.addDefault("MobGuns.Messages.Ocelot-Launched", "Ocelot Launched !");
        config.addDefault("MobGuns.Messages.Wait-Before-Using-Again", "&cWait before using again !");
        config.addDefault("MobGuns.Messages.Gun-Ready", "&lYour mob launcher is ready to be used !");
        config.addDefault("LaunchPads.Power", (int)2);
        getConfig().options().copyDefaults(true);
        save();
    }
    
    public static void reload() {
        if (configFile == null) {
            configFile = new File("plugins/HubGadgets/config.yml");
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }
    
    public static FileConfiguration getConfig() {
        if (config == null) {
            reload();
        }
        return config;
    }
    
    public static void save() {
        if (config == null || configFile == null) {
            return;
        }
        try {
            config.save(configFile);
        } catch (IOException ex) {
            Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE, "Could not save configFile to " + configFile, ex);
        }
    }
    
}
