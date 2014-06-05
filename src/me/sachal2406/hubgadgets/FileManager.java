package me.sachal2406.hubgadgets;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import me.sachal2406.hubgadgets.Config;
 
public class FileManager {
 
        private FileManager(){ }
       
        static FileManager instance = new FileManager();
       
        public static FileManager getInstance() {
                return instance;
        }
       
        public void setup(Plugin p) {
        		if(!p.getDataFolder().exists()) {
                    p.getDataFolder().mkdir();
                }
                
                Config.reload();
                Config.load();
                Config.save();
                Config.reload();	
                
        }
       
        public FileConfiguration getConfig() {
                return Config.getConfig();
        }
       
       
        public void saveConfig() {
        	Config.save();
        }
       
        public void reloadConfig() {
        	Config.reload();
        }
}
