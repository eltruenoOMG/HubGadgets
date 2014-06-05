package me.sachal2406.hubgadgets;

import java.util.logging.Logger;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main plugin;
	
	SettingsManager settings = SettingsManager.getInstance();
	
	
	
	@Override
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " a ete desactive");
		
	}
		
	
	@Override
	public void onEnable(){
		settings.setup(this);
		getServer().getPluginManager().registerEvents(this, this);
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info("------------------------------------- Infos FR ----------------------------------------------");
		this.logger.info("[MobGuns]" + " Version " + pdfFile.getVersion() + " a été activé");
		this.logger.info("Ce serveur utilise " + getServer().getVersion() + " sur l'ip " + getServer().getIp() + ":" + getServer().getPort() + "!");
		this.logger.info("[MobGuns] Chargement de la config...");
		this.logger.info("Fin du chargement du plugin.");
		this.logger.info("Merci de l'avoir téléchargé!");
		this.logger.info("---------------------------------------------------------------------------------------------");
		this.logger.info("------------------------------------- Infos EN ----------------------------------------------");
		this.logger.info("[MobGuns]" + " Version " + pdfFile.getVersion() + " has been activated");
		this.logger.info("This server's using " + getServer().getVersion() + " with the IP " + getServer().getIp() + ":" + getServer().getPort() + "!");
		this.logger.info("[MobGuns] Loading config...");
		this.logger.info("Plugin loading successfully finished.");
		this.logger.info("Thanks for downloading!");
		this.logger.info("---------------------------------------------------------------------------------------------");	
    }
	
    
}
