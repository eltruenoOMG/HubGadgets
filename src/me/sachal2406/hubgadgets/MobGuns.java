package me.sachal2406.hubgadgets;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

public class MobGuns extends JavaPlugin implements Listener {
	
	SettingsManager settings = SettingsManager.getInstance();
	
	String prefix = settings.getConfig().getString("Prefix").replaceAll("&", "§");
	
	ArrayList<Player> cooldown = new ArrayList<Player>();
	
	public void setup(){
		arecipe();
		brecipe();
		crecipe();
		drecipe();
		
	}
	
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
    	
    	final Player player = e.getPlayer();
    	Location location = player.getLocation();
    	PotionEffectType dr = PotionEffectType.DAMAGE_RESISTANCE;
    		
    	
            	if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)){
           
            	if (e.getItem().getItemMeta().getDisplayName().contains("§cPig")){
            		if(!cooldown.contains(player)) {
            	
                	final Pig pig = (Pig)e.getPlayer().getWorld().spawnEntity(player.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.PIG);
                	
                	pig.setVelocity(player.getLocation().getDirection().multiply(2));
                	pig.addPotionEffect(new PotionEffect(dr, 80, 100));
                	
                  	final BukkitScheduler scheduler = Bukkit.getScheduler();
                  	final int taskrd = scheduler.scheduleSyncRepeatingTask(this, new Runnable() {

                  	  public void run() {
                  		ParticleEffect.RED_DUST.display(pig.getLocation().add(0, 0, 0), 15, 0, 0, 0, 10, 10);
                  	  }

                  	}, 0, 0);
                	
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {

								Location ploc = pig.getLocation();
								World pworld = ploc.getWorld();
								pworld.playEffect(ploc, Effect.POTION_BREAK, 1, 1);
								pworld.playEffect(ploc, Effect.POTION_BREAK, 2, 2);
								pworld.playEffect(ploc, Effect.POTION_BREAK, 3, 3);
								pworld.playEffect(ploc, Effect.POTION_BREAK, 4, 4);
								pworld.playEffect(ploc, Effect.POTION_BREAK, 5, 5);
								pworld.playEffect(ploc, Effect.POTION_BREAK, 6, 6);
								pworld.playEffect(ploc, Effect.POTION_BREAK, 7, 7);
								pworld.playEffect(ploc, Effect.POTION_BREAK, 8, 8);
								pworld.playEffect(ploc, Effect.POTION_BREAK, 9, 9);
								pworld.playEffect(ploc, Effect.POTION_BREAK, 10, 10);
								pworld.playEffect(ploc, Effect.POTION_BREAK, 11, 11);
								pworld.playEffect(ploc, Effect.POTION_BREAK, 12, 12);
								pworld.playEffect(ploc, Effect.POTION_BREAK, 13, 13);
								pworld.playEffect(ploc, Effect.POTION_BREAK, 14, 14);
								pworld.playEffect(ploc, Effect.POTION_BREAK, 15, 15);
								pig.remove();
								scheduler.cancelTask(taskrd);
						}    
                    }, 25);  
                	
                	player.playSound(location, Sound.CHICKEN_EGG_POP, 1, (float) 0.1);
                	player.sendMessage(prefix + settings.config.getString("Pig-Launched").replaceAll("&", "§"));
                	cooldown.add(player);
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {
							
							
							
                                cooldown.remove(player);
                                player.sendMessage(prefix + settings.config.getString("Gun-Ready").replaceAll("&", "§"));
						}    
                    }, 100);          	
    		} else {
    			player.sendMessage(prefix + settings.config.getString("Wait-Before-Using-Again").replaceAll("&", "§"));
    			return;
    		}
            		
         } else if (e.getItem().getItemMeta().getDisplayName().contains("§cSheep")){

     		if(!cooldown.contains(player)) {
     	
         	final Sheep sheep = (Sheep)e.getPlayer().getWorld().spawnEntity(player.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.SHEEP);
         	
         	sheep.setVelocity(player.getLocation().getDirection().multiply(2));
         	sheep.addPotionEffect(new PotionEffect(dr, 80, 100));
         	
          	final BukkitScheduler scheduler = Bukkit.getScheduler();
          	final int taskrd = scheduler.scheduleSyncRepeatingTask(this, new Runnable(){

          	  public void run() {
          		ParticleEffect.RED_DUST.display(sheep.getLocation().add(0, 0, 0), 15, 0, 0, 0, 10, 10);
          	  }

          	}, 0, 0);
         	
             Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {

							Location sloc = sheep.getLocation();
							World sworld = sloc.getWorld();
							sworld.playEffect(sloc, Effect.POTION_BREAK, 1, 1);
							sworld.playEffect(sloc, Effect.POTION_BREAK, 2, 2);
							sworld.playEffect(sloc, Effect.POTION_BREAK, 3, 3);
							sworld.playEffect(sloc, Effect.POTION_BREAK, 4, 4);
							sworld.playEffect(sloc, Effect.POTION_BREAK, 5, 5);
							sworld.playEffect(sloc, Effect.POTION_BREAK, 6, 6);
							sworld.playEffect(sloc, Effect.POTION_BREAK, 7, 7);
							sworld.playEffect(sloc, Effect.POTION_BREAK, 8, 8);
							sworld.playEffect(sloc, Effect.POTION_BREAK, 9, 9);
							sworld.playEffect(sloc, Effect.POTION_BREAK, 10, 10);
							sworld.playEffect(sloc, Effect.POTION_BREAK, 11, 11);
							sworld.playEffect(sloc, Effect.POTION_BREAK, 12, 12);
							sworld.playEffect(sloc, Effect.POTION_BREAK, 13, 13);
							sworld.playEffect(sloc, Effect.POTION_BREAK, 14, 14);
							sworld.playEffect(sloc, Effect.POTION_BREAK, 15, 15);
							sheep.remove();
							scheduler.cancelTask(taskrd);
					}    
             }, 25);  
         	
         	player.playSound(location, Sound.CHICKEN_EGG_POP, 1, (float) 0.1);
         	player.sendMessage(prefix + settings.config.getString("Sheep-Launched").replaceAll("&", "§"));
         	cooldown.add(player);
             Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {
						
						
						
                         cooldown.remove(player);
                         player.sendMessage(prefix + settings.config.getString("Gun-Ready").replaceAll("&", "§"));
					}    
             }, 100);          	
		} else {
			player.sendMessage(prefix + settings.config.getString("Wait-Before-Using-Again").replaceAll("&", "§"));
			return;
		
			
		}
     		
         } else if (e.getItem().getItemMeta().getDisplayName().contains("§cCreeper")){

      		if(!cooldown.contains(player)) {
      	
          	final Creeper creeper = (Creeper)e.getPlayer().getWorld().spawnEntity(player.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.CREEPER);
          	
          	creeper.setVelocity(player.getLocation().getDirection().multiply(2));
          	creeper.addPotionEffect(new PotionEffect(dr, 80, 100));
          	
          	final BukkitScheduler scheduler = Bukkit.getScheduler();
          	final int taskrd = scheduler.scheduleSyncRepeatingTask(this, new Runnable() {

          	  public void run() {
          		ParticleEffect.RED_DUST.display(creeper.getLocation().add(0, 0, 0), 15, 0, 0, 0, 10, 10);
          	  }

          	}, 0, 0);
          	
              Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
 					public void run() {

 							Location cloc = creeper.getLocation();
 							World cworld = cloc.getWorld();
 							cworld.playEffect(cloc, Effect.POTION_BREAK, 1, 1);
 							cworld.playEffect(cloc, Effect.POTION_BREAK, 2, 2);
 							cworld.playEffect(cloc, Effect.POTION_BREAK, 3, 3);
 							cworld.playEffect(cloc, Effect.POTION_BREAK, 4, 4);
 							cworld.playEffect(cloc, Effect.POTION_BREAK, 5, 5);
 							cworld.playEffect(cloc, Effect.POTION_BREAK, 6, 6);
 							cworld.playEffect(cloc, Effect.POTION_BREAK, 7, 7);
 							cworld.playEffect(cloc, Effect.POTION_BREAK, 8, 8);
 							cworld.playEffect(cloc, Effect.POTION_BREAK, 9, 9);
 							cworld.playEffect(cloc, Effect.POTION_BREAK, 10, 10);
 							cworld.playEffect(cloc, Effect.POTION_BREAK, 11, 11);
 							cworld.playEffect(cloc, Effect.POTION_BREAK, 12, 12);
 							cworld.playEffect(cloc, Effect.POTION_BREAK, 13, 13);
 							cworld.playEffect(cloc, Effect.POTION_BREAK, 14, 14);
 							cworld.playEffect(cloc, Effect.POTION_BREAK, 15, 15);
 							creeper.remove();
 							scheduler.cancelTask(taskrd);
 							
 					}    
              }, 25);  
          	
          	player.playSound(location, Sound.CHICKEN_EGG_POP, 1, (float) 0.1);
          	player.sendMessage(prefix + settings.config.getString("Creeper-Launched").replaceAll("&", "§"));
          	cooldown.add(player);
              Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
 					public void run() {
 						
 						
 						
                          cooldown.remove(player);
                          player.sendMessage(prefix + settings.config.getString("Gun-Ready").replaceAll("&", "§"));
 					}    
              }, 100);          	
 		} else {
 			player.sendMessage(prefix + settings.config.getString("Wait-Before-Using-Again").replaceAll("&", "§"));
 			return;
 		}
        } else if (e.getItem().getItemMeta().getDisplayName().contains("§cVillager")){

      		if(!cooldown.contains(player)) {
      	
          	final Villager villager = (Villager)e.getPlayer().getWorld().spawnEntity(player.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.VILLAGER);
          	
          	villager.setVelocity(player.getLocation().getDirection().multiply(2));
          	villager.addPotionEffect(new PotionEffect(dr, 80, 100));
          	
          	final BukkitScheduler scheduler = Bukkit.getScheduler();
          	final int taskrd = scheduler.scheduleSyncRepeatingTask(this, new Runnable() {

          	  public void run() {
          		ParticleEffect.RED_DUST.display(villager.getLocation().add(0, 0, 0), 15, 0, 0, 0, 10, 10);
          	  }

          	}, 0, 0);
          	
              Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
 					public void run() {

 							Location vloc = villager.getLocation();
 							World vworld = vloc.getWorld();
 							vworld.playEffect(vloc, Effect.POTION_BREAK, 1, 1);
 							vworld.playEffect(vloc, Effect.POTION_BREAK, 2, 2);
 							vworld.playEffect(vloc, Effect.POTION_BREAK, 3, 3);
 							vworld.playEffect(vloc, Effect.POTION_BREAK, 4, 4);
 							vworld.playEffect(vloc, Effect.POTION_BREAK, 5, 5);
 							vworld.playEffect(vloc, Effect.POTION_BREAK, 6, 6);
 							vworld.playEffect(vloc, Effect.POTION_BREAK, 7, 7);
 							vworld.playEffect(vloc, Effect.POTION_BREAK, 8, 8);
 							vworld.playEffect(vloc, Effect.POTION_BREAK, 9, 9);
 							vworld.playEffect(vloc, Effect.POTION_BREAK, 10, 10);
 							vworld.playEffect(vloc, Effect.POTION_BREAK, 11, 11);
 							vworld.playEffect(vloc, Effect.POTION_BREAK, 12, 12);
 							vworld.playEffect(vloc, Effect.POTION_BREAK, 13, 13);
 							vworld.playEffect(vloc, Effect.POTION_BREAK, 14, 14);
 							vworld.playEffect(vloc, Effect.POTION_BREAK, 15, 15);
 							villager.remove();
 							scheduler.cancelTask(taskrd);
 							
 					}    
              }, 25);  
          	
          	player.playSound(location, Sound.CHICKEN_EGG_POP, 1, (float) 0.1);
          	player.sendMessage(prefix + settings.config.getString("Villager-Launched").replaceAll("&", "§"));
          	cooldown.add(player);
              Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
 					public void run() {
 						
 						
 						
                          cooldown.remove(player);
                          player.sendMessage(prefix + settings.config.getString("Gun-Ready").replaceAll("&", "§"));
 					}    
              }, 100);          	
 		} else {
 			player.sendMessage(prefix + settings.config.getString("Wait-Before-Using-Again").replaceAll("&", "§"));
 			return;
 		}
        }
            	
          
            	
        } else {

            
            	final ItemStack piglauncher = new ItemStack(Material.BLAZE_ROD, 1);
            	final ItemMeta piglaunchermeta = piglauncher.getItemMeta();
            	piglaunchermeta.setDisplayName("§cPig §aLauncher §7(Right click !)");
            	piglauncher.setItemMeta(piglaunchermeta);
            
            	final ItemStack sheeplauncher = new ItemStack(Material.BLAZE_ROD, 1);
            	final ItemMeta sheeplaunchermeta = sheeplauncher.getItemMeta();
            	sheeplaunchermeta.setDisplayName("§cSheep §aLauncher §7(Right click !)");
            	sheeplauncher.setItemMeta(sheeplaunchermeta);
            
            	final ItemStack creeperlauncher = new ItemStack(Material.BLAZE_ROD, 1);
            	final ItemMeta creeperlaunchermeta = creeperlauncher.getItemMeta();
            	creeperlaunchermeta.setDisplayName("§cCreeper §aLauncher §7(Right click !)");
            	creeperlauncher.setItemMeta(creeperlaunchermeta);
            	
            	final ItemStack villagerlauncher = new ItemStack(Material.BLAZE_ROD, 1);
            	final ItemMeta villagerlaunchermeta = villagerlauncher.getItemMeta();
            	villagerlaunchermeta.setDisplayName("§cVillager §aLauncher §7(Right click !)");
            	villagerlauncher.setItemMeta(villagerlaunchermeta);
            	
            	if (e.getItem().getItemMeta().getDisplayName().contains("§cPig")){
            			
            		e.getItem().setItemMeta(sheeplaunchermeta);
            			
            	} else if (e.getItem().getItemMeta().getDisplayName().contains("§cSheep")){
            			
            		e.getItem().setItemMeta(creeperlaunchermeta);
            			
            	} else if (e.getItem().getItemMeta().getDisplayName().contains("§cCreeper")){
            			
            		e.getItem().setItemMeta(villagerlaunchermeta);
            			
            		} else if (e.getItem().getItemMeta().getDisplayName().contains("§cVillager")){
            			
            			e.getItem().setItemMeta(piglaunchermeta);
            			
            		}
            
        }
    	
            	
    }

    private void arecipe() {
       
        final ItemStack piglauncher = new ItemStack(Material.BLAZE_ROD, 1);
        final ItemMeta piglaunchermeta = piglauncher.getItemMeta();
        piglaunchermeta.setDisplayName("§cPig §aLauncher §7(Right click !)");
        piglauncher.setItemMeta(piglaunchermeta);
    	
    	ShapelessRecipe arecipe = new ShapelessRecipe(piglauncher);
        arecipe.addIngredient(1, Material.BLAZE_ROD);
        arecipe.addIngredient(1, Material.BLAZE_POWDER);
        Bukkit.getServer().addRecipe(arecipe);
        
    	}
    
    private void brecipe() {
        
        final ItemStack sheeplauncher = new ItemStack(Material.BLAZE_ROD, 1);
        final ItemMeta sheeplaunchermeta = sheeplauncher.getItemMeta();
        sheeplaunchermeta.setDisplayName("§cSheep §aLauncher §7(Right click !)");
        sheeplauncher.setItemMeta(sheeplaunchermeta);
    	
    	ShapelessRecipe brecipe = new ShapelessRecipe(sheeplauncher);
        brecipe.addIngredient(1, Material.BLAZE_ROD);
        brecipe.addIngredient(1, Material.WOOL);
        Bukkit.getServer().addRecipe(brecipe);
        
    	}
    private void crecipe() {
        
        final ItemStack creeperlauncher = new ItemStack(Material.BLAZE_ROD, 1);
        final ItemMeta creeperlaunchermeta = creeperlauncher.getItemMeta();
        creeperlaunchermeta.setDisplayName("§cCreeper §aLauncher §7(Right click !)");
        creeperlauncher.setItemMeta(creeperlaunchermeta);
    	
    	ShapelessRecipe crecipe = new ShapelessRecipe(creeperlauncher);
        crecipe.addIngredient(1, Material.BLAZE_ROD);
        crecipe.addIngredient(1, Material.SULPHUR);
        Bukkit.getServer().addRecipe(crecipe);
        
    	}
    private void drecipe() {
    	
    	final ItemStack villagerlauncher = new ItemStack(Material.BLAZE_ROD, 1);
    	final ItemMeta villagerlaunchermeta = villagerlauncher.getItemMeta();
    	villagerlaunchermeta.setDisplayName("§cVillager §aLauncher §7(Right click !)");
    	villagerlauncher.setItemMeta(villagerlaunchermeta);
    	
    	ShapelessRecipe drecipe = new ShapelessRecipe(villagerlauncher);
    	drecipe.addIngredient(1, Material.BLAZE_ROD);
    	drecipe.addIngredient(1, Material.EMERALD);
    	Bukkit.getServer().addRecipe(drecipe);
    }
    
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		if(cmd.getName().equalsIgnoreCase("mg")){
			if(args.length == 0){
			sender.sendMessage("=============================");
			sender.sendMessage("§3§llPlugin by sachal2406");
			sender.sendMessage("§6§lCommands:");
			sender.sendMessage("  §c§l- §c§l§n/mg reload§c§l §3| Reloads the config");
			sender.sendMessage("=============================");
			return true;
			}
		}	
		return true;	
	}
}
