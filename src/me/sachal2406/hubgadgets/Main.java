package me.sachal2406.hubgadgets;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

import me.sachal2406.hubgadgets.ParticleEffect;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

 
public class Main extends JavaPlugin implements Listener {
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main plugin;
	
    private Inventory inv;
    private Inventory invlh;
    private Inventory invlc;
    private Inventory invll;
    private Inventory invlb;
    
	
	FileManager settings = FileManager.getInstance();
        
	ArrayList<Player> jumpers = new ArrayList<Player>();

    	@Override
    	public void onEnable(){
    		
    		inv = Bukkit.getServer().createInventory(null, 36, "§f§lWardrobe Builder");
            invlh = Bukkit.getServer().createInventory(null, 36, "§f§lSelect Helmet Color");
            invlc = Bukkit.getServer().createInventory(null, 36, "§f§lSelect Chestplate Color");
            invll = Bukkit.getServer().createInventory(null, 36, "§f§lSelect Leggings Color");
            invlb = Bukkit.getServer().createInventory(null, 36, "§f§lSelect Boots Color");
            
            ItemStack lh = new ItemStack(Material.LEATHER_HELMET, 1);
            ItemStack ch = new ItemStack(Material.CHAINMAIL_HELMET, 1);
            ItemStack ih = new ItemStack(Material.IRON_HELMET, 1);
            ItemStack gh = new ItemStack(Material.GOLD_HELMET, 1);
            ItemStack dh = new ItemStack(Material.DIAMOND_HELMET, 1);
            
            ItemStack lc = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            ItemStack cc = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
            ItemStack ic = new ItemStack(Material.IRON_CHESTPLATE, 1);
            ItemStack gc = new ItemStack(Material.GOLD_CHESTPLATE, 1);
            ItemStack dc = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
            
            ItemStack ll = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            ItemStack cl = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
            ItemStack il = new ItemStack(Material.IRON_LEGGINGS, 1);
            ItemStack gl = new ItemStack(Material.GOLD_LEGGINGS, 1);
            ItemStack dl = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
            
            ItemStack lb = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemStack cb = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
            ItemStack ib = new ItemStack(Material.IRON_BOOTS, 1);
            ItemStack gb = new ItemStack(Material.GOLD_BOOTS, 1);
            ItemStack db = new ItemStack(Material.DIAMOND_BOOTS, 1);
            
            ItemStack BONEMEAL1 = new ItemStack(Material.INK_SACK, 1, (short)15);
            ItemMeta BONEMEAL1meta = BONEMEAL1.getItemMeta();
            BONEMEAL1.setAmount(1);
            BONEMEAL1meta.setDisplayName("§bSelect color");
            BONEMEAL1.setItemMeta(BONEMEAL1meta);
            
            ItemStack BONEMEAL2 = new ItemStack(Material.INK_SACK, 1, (short)15);
            ItemMeta BONEMEAL2meta = BONEMEAL2.getItemMeta();
            BONEMEAL2.setAmount(2);
            BONEMEAL2meta.setDisplayName("§bSelect color");
            BONEMEAL2.setItemMeta(BONEMEAL2meta);
            
            ItemStack BONEMEAL3 = new ItemStack(Material.INK_SACK, 1, (short)15);
            BONEMEAL3.setAmount(3);
            ItemMeta BONEMEAL3meta = BONEMEAL3.getItemMeta();
            BONEMEAL3meta.setDisplayName("§bSelect color");
            BONEMEAL3.setItemMeta(BONEMEAL3meta);
            
            ItemStack BONEMEAL4 = new ItemStack(Material.INK_SACK, 1, (short)15);
            BONEMEAL4.setAmount(4);
            ItemMeta BONEMEAL4meta = BONEMEAL4.getItemMeta();
            BONEMEAL4meta.setDisplayName("§bSelect color");
            BONEMEAL4.setItemMeta(BONEMEAL4meta);
            
            
            
            ItemStack white = new ItemStack(Material.INK_SACK, 1, (short)15);
            ItemMeta whitemeta = white.getItemMeta();
            whitemeta.setDisplayName("White");
            white.setItemMeta(whitemeta);
            
            ItemStack orange = new ItemStack(Material.INK_SACK, 1, (short)14);
            ItemMeta orangemeta = orange.getItemMeta();
            orangemeta.setDisplayName("Orange");
            orange.setItemMeta(orangemeta);
            
            ItemStack magenta = new ItemStack(Material.INK_SACK, 1, (short)13);
            ItemMeta magentameta = magenta.getItemMeta();
            magentameta.setDisplayName("Magenta");
            magenta.setItemMeta(magentameta);
            
            ItemStack lightblue = new ItemStack(Material.INK_SACK, 1, (short)12);
            ItemMeta lightbluemeta = lightblue.getItemMeta();
            lightbluemeta.setDisplayName("Light Blue");
            lightblue.setItemMeta(lightbluemeta);
            
            ItemStack yellow = new ItemStack(Material.INK_SACK, 1, (short)11);
            ItemMeta yellowmeta = yellow.getItemMeta();
            yellowmeta.setDisplayName("Yellow");
            yellow.setItemMeta(yellowmeta);
            
            ItemStack lime = new ItemStack(Material.INK_SACK, 1, (short)10);
            ItemMeta limemeta = lime.getItemMeta();
            limemeta.setDisplayName("Lime");
            lime.setItemMeta(limemeta);
            
            ItemStack pink = new ItemStack(Material.INK_SACK, 1, (short)9);
            ItemMeta pinkmeta = pink.getItemMeta();
            pinkmeta.setDisplayName("Pink");
            pink.setItemMeta(pinkmeta);
            
            ItemStack gray = new ItemStack(Material.INK_SACK, 1, (short)8);
            ItemMeta graymeta = gray.getItemMeta();
            graymeta.setDisplayName("Gray");
            gray.setItemMeta(graymeta);
            
            ItemStack silver = new ItemStack(Material.INK_SACK, 1, (short)7);
            ItemMeta silvermeta = silver.getItemMeta();
            silvermeta.setDisplayName("Silver");
            silver.setItemMeta(silvermeta);
            
            ItemStack cyan = new ItemStack(Material.INK_SACK, 1, (short)6);
            ItemMeta cyanmeta = cyan.getItemMeta();
            cyanmeta.setDisplayName("Cyan");
            cyan.setItemMeta(cyanmeta);
            
            ItemStack purple = new ItemStack(Material.INK_SACK, 1, (short)5);
            ItemMeta purplemeta = purple.getItemMeta();
            purplemeta.setDisplayName("Purple");
            purple.setItemMeta(purplemeta);
            
            ItemStack blue = new ItemStack(Material.INK_SACK, 1, (short)4);
            ItemMeta bluemeta = blue.getItemMeta();
            bluemeta.setDisplayName("Blue");
            blue.setItemMeta(bluemeta);
            
            ItemStack brown = new ItemStack(Material.INK_SACK, 1, (short)3);
            ItemMeta brownmeta = brown.getItemMeta();
            brownmeta.setDisplayName("Brown");
            brown.setItemMeta(brownmeta);
            
            ItemStack green = new ItemStack(Material.INK_SACK, 1, (short)2);
            ItemMeta greenmeta = green.getItemMeta();
            greenmeta.setDisplayName("Green");
            green.setItemMeta(greenmeta);
            
            ItemStack red = new ItemStack(Material.INK_SACK, 1, (short)1);
            ItemMeta redmeta = red.getItemMeta();
            redmeta.setDisplayName("Red");
            red.setItemMeta(redmeta);
            
            ItemStack black = new ItemStack(Material.INK_SACK, 1, (short)0);
            ItemMeta blackmeta = black.getItemMeta();
            blackmeta.setDisplayName("Black");
            black.setItemMeta(blackmeta);
            
            
            ItemStack glass5 = new ItemStack(Material.GLASS, 1);
            glass5.setAmount(1);
            ItemMeta glassmeta5 = glass5.getItemMeta();
            glassmeta5.setDisplayName("§bNone");
            glass5.setItemMeta(glassmeta5);
            
            ItemStack arrow = new ItemStack(Material.ARROW, 1);
            arrow.setAmount(1);
            ItemMeta arrowmeta = arrow.getItemMeta();
            arrowmeta.setDisplayName("§cCancel");
            arrow.setItemMeta(arrowmeta);
            
            
            ItemStack glass1 = new ItemStack(Material.GLASS);
            ItemMeta glassmeta1 = glass1.getItemMeta();
            glassmeta1.setDisplayName("§cClear Slot");
            glass1.setAmount(1);
            glass1.setItemMeta(glassmeta1);
            
            ItemStack glass2 = new ItemStack(Material.GLASS);
            ItemMeta glassmeta2 = glass2.getItemMeta();
            glassmeta2.setDisplayName("§cClear Slot");
            glass2.setAmount(2);
            glass2.setItemMeta(glassmeta2);
            
            ItemStack glass3 = new ItemStack(Material.GLASS);
            ItemMeta glassmeta3 = glass3.getItemMeta();
            glassmeta3.setDisplayName("§cClear Slot");
            glass3.setAmount(3);
            glass3.setItemMeta(glassmeta3);
            
            ItemStack glass4 = new ItemStack(Material.GLASS);
            ItemMeta glass4meta = glass4.getItemMeta();
            glass4meta.setDisplayName("§cClear Slot");
            glass4.setAmount(4);
            glass4.setItemMeta(glass4meta);
          
            inv.setItem(2, lh);
            inv.setItem(3, ch);
            inv.setItem(4, ih);
            inv.setItem(5, gh);
            inv.setItem(6, dh);
            
            inv.setItem(11, lc);
            inv.setItem(12, cc);
            inv.setItem(13, ic);
            inv.setItem(14, gc);
            inv.setItem(15, dc);
            
            inv.setItem(20, ll);
            inv.setItem(21, cl);
            inv.setItem(22, il);
            inv.setItem(23, gl);
            inv.setItem(24, dl);

            inv.setItem(29, lb);
            inv.setItem(30, cb);
            inv.setItem(31, ib);
            inv.setItem(32, gb);
            inv.setItem(33, db);
            
            
            inv.setItem(0, BONEMEAL1);
            inv.setItem(9, BONEMEAL2);
            inv.setItem(18, BONEMEAL3);
            inv.setItem(27, BONEMEAL4);
            
            
            inv.setItem(8, glass1);
            inv.setItem(17, glass2);
            inv.setItem(26, glass3);
            inv.setItem(35, glass4);
            
            
            invlh.setItem(0, white);
            invlh.setItem(1, orange);
            invlh.setItem(2, magenta);
            invlh.setItem(3, lightblue);
            invlh.setItem(4, yellow);
            invlh.setItem(5, lime);
            invlh.setItem(6, pink);
            invlh.setItem(7, gray);
            invlh.setItem(8, silver);
            
            invlh.setItem(10, cyan);
            invlh.setItem(11, purple);
            invlh.setItem(12, blue);
            invlh.setItem(13, brown);
            invlh.setItem(14, green);
            invlh.setItem(15, red);
            invlh.setItem(16, black);
            
            invlh.setItem(30, glass5);
            invlh.setItem(32, arrow);
            
            
            invlc.setItem(0, white);
            invlc.setItem(1, orange);
            invlc.setItem(2, magenta);
            invlc.setItem(3, lightblue);
            invlc.setItem(4, yellow);
            invlc.setItem(5, lime);
            invlc.setItem(6, pink);
            invlc.setItem(7, gray);
            invlc.setItem(8, silver);
            
            invlc.setItem(10, cyan);
            invlc.setItem(11, purple);
            invlc.setItem(12, blue);
            invlc.setItem(13, brown);
            invlc.setItem(14, green);
            invlc.setItem(15, red);
            invlc.setItem(16, black);
            
            invlc.setItem(30, glass5);
            invlc.setItem(32, arrow);
            
            
            invll.setItem(0, white);
            invll.setItem(1, orange);
            invll.setItem(2, magenta);
            invll.setItem(3, lightblue);
            invll.setItem(4, yellow);
            invll.setItem(5, lime);
            invll.setItem(6, pink);
            invll.setItem(7, gray);
            invll.setItem(8, silver);
            
            invll.setItem(10, cyan);
            invll.setItem(11, purple);
            invll.setItem(12, blue);
            invll.setItem(13, brown);
            invll.setItem(14, green);
            invll.setItem(15, red);
            invll.setItem(16, black);
            
            invll.setItem(30, glass5);
            invll.setItem(32, arrow);
            
            
            invlb.setItem(0, white);
            invlb.setItem(1, orange);
            invlb.setItem(2, magenta);
            invlb.setItem(3, lightblue);
            invlb.setItem(4, yellow);
            invlb.setItem(5, lime);
            invlb.setItem(6, pink);
            invlb.setItem(7, gray);
            invlb.setItem(8, silver);
            
            invlb.setItem(10, cyan);
            invlb.setItem(11, purple);
            invlb.setItem(12, blue);
            invlb.setItem(13, brown);
            invlb.setItem(14, green);
            invlb.setItem(15, red);
            invlb.setItem(16, black);
            
            invlb.setItem(30, glass5);
            invlb.setItem(32, arrow);
    		
    		arecipe();
    		brecipe();
    		crecipe();
    		drecipe();
    		
    		settings.setup(this);
    		
    		getServer().getPluginManager().registerEvents(this, this);
    		this.logger.info("[HubGadgets] enabled");
    		
    	}
        
        
     // ==================================== LAUNCHPAD BEGGINING ====================================  
        
    	@EventHandler
    	public void onPlayerMove(PlayerMoveEvent e) {
    		if (e.getTo().getBlock().getRelative(BlockFace.SELF).getType() == Material.GOLD_PLATE) {
    			if (e.getPlayer().getLocation().add(0, -1, 0).getBlock().getRelative(BlockFace.SELF).getType() == Material.REDSTONE_BLOCK) {
    			e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(settings.getConfig().getInt("LaunchPads.Power")));
    			e.getPlayer().setVelocity(new Vector(e.getPlayer().getVelocity().getX(), 1.0D, e.getPlayer().getVelocity().getZ()));
    			jumpers.add(e.getPlayer());
    			
    			ParticleEffect.FIREWORKS_SPARK.display(e.getPlayer().getLocation(), 1F, 1F, 1F, 1F, 50, e.getPlayer());
    			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.BAT_TAKEOFF, 1, 1);
    				}
    			}
    	}
    	
    	@EventHandler
    	public void onPlayerDamager(EntityDamageEvent e) {
    		if (e.getEntity() instanceof Player) {
    			Player p = (Player) e.getEntity();
    			if (e.getCause() == DamageCause.FALL && jumpers.contains(p)) {
    				e.setDamage(0.0);
    				jumpers.remove(p);
    				
    			}
    		}
    	}
    	
    	 // ==================================== LAUNCHPAD END ==================================== 
    	
    	
        // ==================================== MOBGUNS BEGGINING (WITH WARDROBE) ====================================  
    	
    	
    	ArrayList<Player> cooldown = new ArrayList<Player>();
    	ArrayList<Player> cooldownpb = new ArrayList<Player>();
    	ArrayList<Player> cooldownbb = new ArrayList<Player>();
    	
        @EventHandler
        public void onPlayerInteract(PlayerInteractEvent e) {
       	
        	
        	final String prefix = settings.getConfig().getString("Main-Messages.Prefix").replaceAll("&", "§");
        	
        	final Player player = e.getPlayer();
        	Location location = player.getLocation();
        	PotionEffectType dr = PotionEffectType.DAMAGE_RESISTANCE;
        	PotionEffectType slowness = PotionEffectType.SLOW;
        	
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
        	
        	final ItemStack ocelotlauncher = new ItemStack(Material.BLAZE_ROD, 1);
        	final ItemMeta ocelotlaunchermeta = ocelotlauncher.getItemMeta();
        	ocelotlaunchermeta.setDisplayName("§cOcelot §aLauncher §7(Right click !)");
        	ocelotlauncher.setItemMeta(ocelotlaunchermeta);
        	
        	final ItemStack wardrobeItem = new ItemStack(Material.IRON_INGOT, 1);
        	final ItemMeta wardrobeItemmeta = wardrobeItem.getItemMeta();
        	wardrobeItemmeta.setDisplayName("§3§lWardRobe §7(Right click !)");
        	wardrobeItem.setItemMeta(wardrobeItemmeta);
        	
        	ItemStack paintballgun = new ItemStack(Material.GOLD_BARDING, 1);
        	ItemMeta paintballgunmeta = paintballgun.getItemMeta();
        	paintballgunmeta.setDisplayName("§aPaintBall Gun §7(Right click)");
        	paintballgun.setItemMeta(paintballgunmeta);

        	ItemStack batblaster = new ItemStack(Material.IRON_BARDING, 1);
        	ItemMeta batblastermeta = batblaster.getItemMeta();
        	batblastermeta.setDisplayName("§cBat Blaster §7(Right click)");
        	batblaster.setItemMeta(batblastermeta);
        		
        	
        if(e.getItem() != null){	
        	
       		if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {	
       			
                	if (e.getItem().getItemMeta().equals(wardrobeItemmeta)){
                		this.show(player);
                			
                	}
                	if(player.hasPermission("hubgadgets.use.mobgun")){
                		if (e.getItem().getItemMeta().equals(piglaunchermeta)){
                		if(!cooldown.contains(player)) {
                	
                    	final Pig pig = (Pig)e.getPlayer().getWorld().spawnEntity(player.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.PIG);
                    	
                    	pig.setVelocity(player.getLocation().getDirection().multiply(2));
                    	pig.addPotionEffect(new PotionEffect(dr, 80, 100));
                    	pig.addPotionEffect(new PotionEffect(slowness, 80, 100));
                    	
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
                    	player.sendMessage(prefix + settings.getConfig().getString("MobGuns.Messages.Pig-Launched").replaceAll("&", "§"));
                    	cooldown.add(player);
                    	
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
    						public void run() {
    							
    							
    							
                                    cooldown.remove(player);
                                    player.sendMessage(prefix + settings.getConfig().getString("MobGuns.Messages.Gun-Ready").replaceAll("&", "§"));
    						}    
                        }, (int)settings.getConfig().getInt("MobGuns.Time-Between-Two-Uses") * 20);          	
        		} else {
        			player.sendMessage(prefix + settings.getConfig().getString("MobGuns.Messages.Wait-Before-Using-Again").replaceAll("&", "§"));
        			return;
        		}
                		
             } else if (e.getItem().getItemMeta().equals(sheeplaunchermeta)){

         		if(!cooldown.contains(player)) {
         	
             	final Sheep sheep = (Sheep)e.getPlayer().getWorld().spawnEntity(player.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.SHEEP);
             	
             	sheep.setVelocity(player.getLocation().getDirection().multiply(2));
             	sheep.addPotionEffect(new PotionEffect(dr, 80, 100));
             	sheep.addPotionEffect(new PotionEffect(slowness, 80, 100));
             	
              	final BukkitScheduler scheduler = Bukkit.getScheduler();
              	final int taskrd = scheduler.scheduleSyncRepeatingTask(this, new Runnable() {

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
             	player.sendMessage(prefix + settings.getConfig().getString("MobGuns.Messages.Sheep-Launched").replaceAll("&", "§"));
             	cooldown.add(player);
                 Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
    					public void run() {
    						
    						
    						
                             cooldown.remove(player);
                             player.sendMessage(prefix + settings.getConfig().getString("MobGuns.Messages.Gun-Ready").replaceAll("&", "§"));
    					}    
                 }, (int)settings.getConfig().getInt("MobGuns.Time-Between-Two-Uses") * 20);          	
    		} else {
    			player.sendMessage(prefix + settings.getConfig().getString("MobGuns.Messages.Wait-Before-Using-Again").replaceAll("&", "§"));
    			return;
    		
    			
    		}
         		
             }
                	if (e.getItem().getItemMeta().equals(creeperlaunchermeta)){

          		if(!cooldown.contains(player)) {
          	
              	final Creeper creeper = (Creeper)e.getPlayer().getWorld().spawnEntity(player.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.CREEPER);
              	
              	creeper.setVelocity(player.getLocation().getDirection().multiply(2));
              	creeper.addPotionEffect(new PotionEffect(dr, 80, 100));
              	creeper.addPotionEffect(new PotionEffect(slowness, 80, 100));
              	
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
              	player.sendMessage(prefix + settings.getConfig().getString("MobGuns.Messages.Creeper-Launched").replaceAll("&", "§"));
              	cooldown.add(player);
                  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
     					public void run() {
     						
     						
     						
                              cooldown.remove(player);
                              player.sendMessage(prefix + settings.getConfig().getString("MobGuns.Messages.Gun-Ready").replaceAll("&", "§"));
     					}    
                  }, (int)settings.getConfig().getInt("MobGuns.Time-Between-Two-Uses") * 20);          	
     		} else {
     			player.sendMessage(prefix + settings.getConfig().getString("MobGuns.Messages.Wait-Before-Using-Again").replaceAll("&", "§"));
     			return;
     		}
            }
                	if (e.getItem().getItemMeta().equals(villagerlaunchermeta)){

          		if(!cooldown.contains(player)) {
          	
              	final Villager villager = (Villager)e.getPlayer().getWorld().spawnEntity(player.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.VILLAGER);
              	
              	villager.setVelocity(player.getLocation().getDirection().multiply(2));
              	villager.addPotionEffect(new PotionEffect(dr, 80, 100));
              	villager.addPotionEffect(new PotionEffect(slowness, 80, 100));
              	
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
              	player.sendMessage(prefix + settings.getConfig().getString("MobGuns.Messages.Villager-Launched").replaceAll("&", "§"));
              	cooldown.add(player);
                  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
     					public void run() {
     						
     						
     						
                              cooldown.remove(player);
                              player.sendMessage(prefix + settings.getConfig().getString("MobGuns.Messages.Gun-Ready").replaceAll("&", "§"));
     					}    
                  }, (int)settings.getConfig().getInt("MobGuns.Time-Between-Two-Uses") * 20);          	
     		} else {
     			if(!(((int)settings.getConfig().getInt("MobGuns.Time-Between-Two-Uses") * 20) < 1)){ 
     			player.sendMessage(prefix + settings.getConfig().getString("MobGuns.Messages.Wait-Before-Using-Again").replaceAll("&", "§"));
     			return;
     			}
            }
                	}
                	if (e.getItem().getItemMeta().equals(ocelotlaunchermeta)){

          		if(!cooldown.contains(player)) {
          	
              	final Ocelot ocelot = (Ocelot)e.getPlayer().getWorld().spawnEntity(player.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.OCELOT);
              	
              	ocelot.setVelocity(player.getLocation().getDirection().multiply(2));
              	ocelot.addPotionEffect(new PotionEffect(dr, 80, 100));
              	ocelot.addPotionEffect(new PotionEffect(slowness, 80, 100));
              	
              	
              	final BukkitScheduler scheduler = Bukkit.getScheduler();
              	final int taskrd = scheduler.scheduleSyncRepeatingTask(this, new Runnable() {

              	  public void run() {
              		ParticleEffect.RED_DUST.display(ocelot.getLocation().add(0, 0, 0), 15, 0, 0, 0, 10, 10);
              	  }

              	}, 0, 0);
              	
                  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
     					public void run() {

     							Location oloc = ocelot.getLocation();
     							World oworld = oloc.getWorld();
     							oworld.playEffect(oloc, Effect.POTION_BREAK, 1, 1);
     							oworld.playEffect(oloc, Effect.POTION_BREAK, 2, 2);
     							oworld.playEffect(oloc, Effect.POTION_BREAK, 3, 3);
     							oworld.playEffect(oloc, Effect.POTION_BREAK, 4, 4);
     							oworld.playEffect(oloc, Effect.POTION_BREAK, 5, 5);
     							oworld.playEffect(oloc, Effect.POTION_BREAK, 6, 6);
     							oworld.playEffect(oloc, Effect.POTION_BREAK, 7, 7);
     							oworld.playEffect(oloc, Effect.POTION_BREAK, 8, 8);
     							oworld.playEffect(oloc, Effect.POTION_BREAK, 9, 9);
     							oworld.playEffect(oloc, Effect.POTION_BREAK, 10, 10);
     							oworld.playEffect(oloc, Effect.POTION_BREAK, 11, 11);
     							oworld.playEffect(oloc, Effect.POTION_BREAK, 12, 12);
     							oworld.playEffect(oloc, Effect.POTION_BREAK, 13, 13);
     							oworld.playEffect(oloc, Effect.POTION_BREAK, 14, 14);
     							oworld.playEffect(oloc, Effect.POTION_BREAK, 15, 15);
     							ocelot.remove();
     							scheduler.cancelTask(taskrd);
     							
     					}    
                  }, 25);  
              	
              	player.playSound(location, Sound.CHICKEN_EGG_POP, 1, (float) 0.1);
              	player.sendMessage(prefix + settings.getConfig().getString("MobGuns.Messages.Ocelot-Launched").replaceAll("&", "§"));
              	cooldown.add(player);
                  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
     					public void run() {
     						
     						
     						
                              cooldown.remove(player);
                              player.sendMessage(prefix + settings.getConfig().getString("MobGuns.Messages.Gun-Ready").replaceAll("&", "§"));
     					}    
                  }, (int)settings.getConfig().getInt("MobGuns.Time-Between-Two-Uses") * 20);          	
     		} else {
     			player.sendMessage(prefix + settings.getConfig().getString("MobGuns.Messages.Wait-Before-Using-Again").replaceAll("&", "§"));
     			return;
                	}
                	}
                	} else {
                		player.sendMessage(prefix+"§cYou don't have the permission !");
                	}
                	
                	
                	if(e.getItem().getType() == Material.GOLD_BARDING){
                		if(player.hasPermission("hubgadgets.use.pbgun")){
                		if(!cooldownpb.contains(player)){
                		if (e.getItem().getItemMeta().equals(paintballgunmeta)){
                			
                			EnderPearl ep = (EnderPearl)player.launchProjectile(EnderPearl.class);
                			ep.setVelocity(player.getLocation().getDirection().multiply(1.6));
                			this.cooldownpb.add(player);
                			player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
                			
                			Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                				public void run(){
                					cooldownpb.remove(player);
                				}
                			}, 6);
                			
                			}	
                		}
                		} else {
            				player.sendMessage(prefix + "§cYou don't have the permission !");
                		}
                		
                		
                	} else if(e.getItem().getType() == Material.IRON_BARDING){
                	if(player.hasPermission("hubgadgets.use.batblaster")){	
                		if(!cooldownbb.contains(player)){
                			if(e.getItem().getItemMeta().equals(batblastermeta)){
                				final Bat bat = (Bat)player.getWorld().spawnEntity(player.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.BAT);
                				final Bat bat1 = (Bat)player.getWorld().spawnEntity(player.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.BAT);
                				final Bat bat2 = (Bat)player.getWorld().spawnEntity(player.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.BAT);
                				final Bat bat3 = (Bat)player.getWorld().spawnEntity(player.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.BAT);
                				final Bat bat4 = (Bat)player.getWorld().spawnEntity(player.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.BAT);
                				final Bat bat5 = (Bat)player.getWorld().spawnEntity(player.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.BAT);
                				final Bat bat6 = (Bat)player.getWorld().spawnEntity(player.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.BAT);
                				final Bat bat7 = (Bat)player.getWorld().spawnEntity(player.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.BAT);
                				final Bat bat8 = (Bat)player.getWorld().spawnEntity(player.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.BAT);
                				final Bat bat9 = (Bat)player.getWorld().spawnEntity(player.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.BAT);
                				
                				bat.setVelocity(player.getLocation().getDirection().multiply(1.1));
                				bat.setCustomName("§c*piew*");
                				bat1.setVelocity(player.getLocation().getDirection().multiply(1.1));
                				bat1.setCustomName("§c*piew*");
                				bat2.setVelocity(player.getLocation().getDirection().multiply(1.1));
                				bat2.setCustomName("§c*piew*");
                				bat3.setVelocity(player.getLocation().getDirection().multiply(1.1));
                				bat3.setCustomName("§c*piew*");
                				bat4.setVelocity(player.getLocation().getDirection().multiply(1.1));
                				bat4.setCustomName("§c*piew*");
                				bat5.setVelocity(player.getLocation().getDirection().multiply(1.1));
                				bat5.setCustomName("§c*piew*");
                				bat6.setVelocity(player.getLocation().getDirection().multiply(1.1));
                				bat6.setCustomName("§c*piew*");
                				bat7.setVelocity(player.getLocation().getDirection().multiply(1.1));
                				bat7.setCustomName("§c*piew*");
                				bat8.setVelocity(player.getLocation().getDirection().multiply(1.1));
                				bat8.setCustomName("§c*piew*");
                				bat9.setVelocity(player.getLocation().getDirection().multiply(1.1));
                				bat9.setCustomName("§c*piew*");
                				
                				cooldownbb.add(player);
                				
                				player.sendMessage(prefix +"§c*piew* *piew* !");
                				player.playSound(player.getLocation(), Sound.BAT_LOOP, 1, 1);
                              	final BukkitScheduler scheduler = Bukkit.getScheduler();
                              	final int taskrd = scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
        	
                              		
                              	  public void run() {
                              		  bat.setVelocity(bat.getLocation().getDirection().multiply(1.1));
                              		  bat1.setVelocity(bat.getLocation().getDirection().multiply(1.1));
                              		bat2.setVelocity(bat.getLocation().getDirection().multiply(1.1));
                              		bat3.setVelocity(bat.getLocation().getDirection().multiply(1.1));
                              		bat4.setVelocity(bat.getLocation().getDirection().multiply(1.1));
                              		bat5.setVelocity(bat.getLocation().getDirection().multiply(1.1));
                              		bat6.setVelocity(bat.getLocation().getDirection().multiply(1.1));
                              		bat7.setVelocity(bat.getLocation().getDirection().multiply(1.1));
                              		bat8.setVelocity(bat.getLocation().getDirection().multiply(1.1));
                              		bat9.setVelocity(bat.getLocation().getDirection().multiply(1.1));
                              	  }
                              	}, 1, 1);
                				
                				Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                    				public void run(){
                    					player.getWorld().playEffect(bat.getLocation(), Effect.POTION_BREAK, 1, 1);
                    					bat.remove();
                    					bat1.remove();
                    					bat2.remove();
                    					bat3.remove();
                    					bat4.remove();
                    					bat5.remove();
                    					bat6.remove();
                    					bat7.remove();
                    					bat8.remove();
                    					bat9.remove();
                    					scheduler.cancelTask(taskrd);
                    					player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
                    					
                    				}
                    			}, 30);
                				
                				Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                    				public void run(){
                    					cooldownbb.remove(player);
                    				}
                    			}, 60);
                			}
                		} else {
                			player.sendMessage(prefix + settings.getConfig().getString("MobGuns.Messages.Wait-Before-Using-Again"));
                		}
                		} else {
            				player.sendMessage(prefix + "§cYou don't have the permission !");
                		}
                	}	
                	
                	
                } else{
                		if(e.getItem().hasItemMeta()){
                			if (e.getItem().getItemMeta().equals(piglaunchermeta)){
                		
                				e.getItem().setItemMeta(sheeplaunchermeta);
                			
                			} else if (e.getItem().getItemMeta().equals(sheeplaunchermeta)){
                			
                				e.getItem().setItemMeta(creeperlaunchermeta);
                			
                			} else if (e.getItem().getItemMeta().equals(creeperlaunchermeta)){
                			
                				e.getItem().setItemMeta(villagerlaunchermeta);
                			
                			} else if (e.getItem().getItemMeta().equals(villagerlaunchermeta)){
                			
                				e.getItem().setItemMeta(ocelotlaunchermeta);
                				
                			} else if (e.getItem().getItemMeta().equals(ocelotlaunchermeta)){
                    			
                				e.getItem().setItemMeta(piglaunchermeta);
                			}
                		}
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
            arecipe.addIngredient(1, Material.PORK);
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
      
        // ==================================== MOBGUNS END ====================================
 
// ================================================== WARDROBE BEGGINING ==================================================         
        
        public void show(Player p) {
        	if(p.hasPermission("hubgadgets.wardrobe")){
            p.openInventory(inv);
        	} else {
				p.sendMessage(settings.getConfig().getString("Main-Messages.Prefix").replaceAll("&", "§") + "§cYou don't have the permission !");
        	}
    }
  
    
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
      Player player = (Player)event.getWhoClicked();
      ItemStack clicked = event.getCurrentItem();
      Inventory inventory = event.getInventory();
      
      ItemStack glass1 = new ItemStack(Material.INK_SACK, 1, (short)0);
      ItemMeta glassmeta1 = glass1.getItemMeta();
      glassmeta1.setDisplayName("§cClear Slot");
      glass1.setItemMeta(glassmeta1);
      
      ItemStack glass2 = new ItemStack(Material.INK_SACK, 1, (short)0);
      ItemMeta glassmeta2 = glass2.getItemMeta();
      glassmeta2.setDisplayName("§cClear Slot");
      glass2.setItemMeta(glassmeta2);
      
      ItemStack glass3 = new ItemStack(Material.INK_SACK, 1, (short)0);
      ItemMeta glassmeta3 = glass3.getItemMeta();
      glassmeta3.setDisplayName("§cClear Slot");
      glass3.setItemMeta(glassmeta3);
      
      ItemStack glass4 = new ItemStack(Material.INK_SACK, 1, (short)0);
      ItemMeta glass4meta = glass4.getItemMeta();
      glass4meta.setDisplayName("§cClear Slot");
      glass4.setItemMeta(glass4meta);
      
      ItemStack lh = new ItemStack(Material.LEATHER_HELMET, 1);
      ItemStack lc = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      ItemStack ll = new ItemStack(Material.LEATHER_LEGGINGS, 1);
      ItemStack lb = new ItemStack(Material.LEATHER_BOOTS, 1);
      
      ItemStack whiteh = new ItemStack(Material.LEATHER_HELMET, 1);
      LeatherArmorMeta whitehmeta = (LeatherArmorMeta) whiteh.getItemMeta();
      whitehmeta.setColor(Color.WHITE);
      whiteh.setItemMeta(whitehmeta);
      
      ItemStack whitecp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta whitecpmeta = (LeatherArmorMeta) whitecp.getItemMeta();
      whitecpmeta.setColor(Color.WHITE);
      whitecp.setItemMeta(whitecpmeta);
      
      ItemStack whitel = new ItemStack(Material.LEATHER_LEGGINGS, 1);
      LeatherArmorMeta whitelmeta = (LeatherArmorMeta) whitel.getItemMeta();
      whitelmeta.setColor(Color.WHITE);
      whitel.setItemMeta(whitelmeta);
      ItemStack whiteb = new ItemStack(Material.LEATHER_BOOTS, 1);
      LeatherArmorMeta whitebmeta = (LeatherArmorMeta) whiteb.getItemMeta();
      whitebmeta.setColor(Color.WHITE);
      whiteb.setItemMeta(whitebmeta);
      
      
      ItemStack orangeh = new ItemStack(Material.LEATHER_HELMET, 1);
      LeatherArmorMeta orangehmeta = (LeatherArmorMeta) orangeh.getItemMeta();
      orangehmeta.setColor(Color.ORANGE);
      orangeh.setItemMeta(orangehmeta);
      ItemStack orangecp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta orangecpmeta = (LeatherArmorMeta) orangecp.getItemMeta();
      orangecpmeta.setColor(Color.ORANGE);
      orangecp.setItemMeta(orangecpmeta);
      ItemStack orangel = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta orangelmeta = (LeatherArmorMeta) orangel.getItemMeta();
      orangelmeta.setColor(Color.ORANGE);
      orangel.setItemMeta(orangelmeta);
      ItemStack orangeb = new ItemStack(Material.LEATHER_BOOTS, 1);
      LeatherArmorMeta orangebmeta = (LeatherArmorMeta) orangeb.getItemMeta();
      orangebmeta.setColor(Color.ORANGE);
      orangeb.setItemMeta(orangebmeta);
      
      ItemStack magentah = new ItemStack(Material.LEATHER_HELMET, 1);
      LeatherArmorMeta magentahmeta = (LeatherArmorMeta) magentah.getItemMeta();
      magentahmeta.setColor(Color.fromBGR(216, 76, 178));
      magentah.setItemMeta(magentahmeta);
      ItemStack magentacp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta magentacpmeta = (LeatherArmorMeta) magentacp.getItemMeta();
      magentacpmeta.setColor(Color.fromBGR(216, 76, 178));
      magentacp.setItemMeta(magentacpmeta);
      ItemStack magental = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta magentalmeta = (LeatherArmorMeta) magental.getItemMeta();
      magentalmeta.setColor(Color.fromBGR(216, 76, 178));
      magental.setItemMeta(magentalmeta);
      ItemStack magentab = new ItemStack(Material.LEATHER_BOOTS, 1);
      LeatherArmorMeta magentabmeta = (LeatherArmorMeta) magentab.getItemMeta();
      magentabmeta.setColor(Color.fromBGR(216, 76, 178));
      magentab.setItemMeta(magentabmeta);
      
      ItemStack lightblueh = new ItemStack(Material.LEATHER_HELMET, 1);
      LeatherArmorMeta lightbluehmeta = (LeatherArmorMeta) lightblueh.getItemMeta();
      lightbluehmeta.setColor(Color.fromBGR(216, 153, 102));
      lightblueh.setItemMeta(lightbluehmeta);
      ItemStack lightbluecp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta lightbluecpmeta = (LeatherArmorMeta) lightbluecp.getItemMeta();
      lightbluecpmeta.setColor(Color.fromBGR(216, 153, 102));
      lightbluecp.setItemMeta(lightbluecpmeta);
      ItemStack lightbluel = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta lightbluelmeta = (LeatherArmorMeta) lightbluel.getItemMeta();
      lightbluelmeta.setColor(Color.fromBGR(216, 153, 102));
      lightbluel.setItemMeta(lightbluelmeta);
      ItemStack lightblueb = new ItemStack(Material.LEATHER_BOOTS, 1);
      LeatherArmorMeta lightbluebmeta = (LeatherArmorMeta) lightblueb.getItemMeta();
      lightbluebmeta.setColor(Color.fromBGR(216, 153, 102));
      lightblueb.setItemMeta(lightbluebmeta);
     
      ItemStack yellowh = new ItemStack(Material.LEATHER_HELMET, 1);
      LeatherArmorMeta yellowhmeta = (LeatherArmorMeta) yellowh.getItemMeta();
      yellowhmeta.setColor(Color.YELLOW);
      yellowh.setItemMeta(yellowhmeta);
      ItemStack yellowcp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta yellowcpmeta = (LeatherArmorMeta) yellowcp.getItemMeta();
      yellowcpmeta.setColor(Color.YELLOW);
      yellowcp.setItemMeta(yellowcpmeta);
      ItemStack yellowl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta yellowlmeta = (LeatherArmorMeta) yellowl.getItemMeta();
      yellowlmeta.setColor(Color.YELLOW);
      yellowl.setItemMeta(yellowlmeta);
      ItemStack yellowb = new ItemStack(Material.LEATHER_BOOTS, 1);
      LeatherArmorMeta yellowbmeta = (LeatherArmorMeta) yellowb.getItemMeta();
      yellowbmeta.setColor(Color.YELLOW);
      yellowb.setItemMeta(yellowbmeta);
      
      ItemStack limeh = new ItemStack(Material.LEATHER_HELMET, 1);
      LeatherArmorMeta limehmeta = (LeatherArmorMeta) limeh.getItemMeta();
      limehmeta.setColor(Color.LIME);
      limeh.setItemMeta(limehmeta);
      ItemStack limecp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta limecpmeta = (LeatherArmorMeta) limecp.getItemMeta();
      limecpmeta.setColor(Color.LIME);
      limecp.setItemMeta(limecpmeta);
      ItemStack limel = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta limelmeta = (LeatherArmorMeta) limel.getItemMeta();
      limelmeta.setColor(Color.LIME);
      limel.setItemMeta(limelmeta);
      ItemStack limeb = new ItemStack(Material.LEATHER_BOOTS, 1);
      LeatherArmorMeta limebmeta = (LeatherArmorMeta) limeb.getItemMeta();
      limebmeta.setColor(Color.LIME);
      limeb.setItemMeta(limebmeta);
      
      ItemStack pinkh = new ItemStack(Material.LEATHER_HELMET, 1);
      LeatherArmorMeta pinkhmeta = (LeatherArmorMeta) pinkh.getItemMeta();
      pinkhmeta.setColor(Color.fromBGR(165, 127, 242));
      pinkh.setItemMeta(pinkhmeta);
      ItemStack pinkcp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta pinkcpmeta = (LeatherArmorMeta) pinkcp.getItemMeta();
      pinkcpmeta.setColor(Color.fromBGR(165, 127, 242));
      pinkcp.setItemMeta(pinkcpmeta);
      ItemStack pinkl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta pinklmeta = (LeatherArmorMeta) pinkl.getItemMeta();
      pinklmeta.setColor(Color.fromBGR(165, 127, 242));
      pinkl.setItemMeta(pinklmeta);
      ItemStack pinkb = new ItemStack(Material.LEATHER_BOOTS, 1);
      LeatherArmorMeta pinkbmeta = (LeatherArmorMeta) pinkb.getItemMeta();
      pinkbmeta.setColor(Color.fromBGR(165, 127, 242));
      pinkb.setItemMeta(pinkbmeta);
      
      ItemStack grayh = new ItemStack(Material.LEATHER_HELMET, 1);
      LeatherArmorMeta grayhmeta = (LeatherArmorMeta) grayh.getItemMeta();
      grayhmeta.setColor(Color.GRAY);
      grayh.setItemMeta(grayhmeta);
      ItemStack graycp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta graycpmeta = (LeatherArmorMeta) graycp.getItemMeta();
      graycpmeta.setColor(Color.GRAY);
      graycp.setItemMeta(graycpmeta);
      ItemStack grayl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta graylmeta = (LeatherArmorMeta) grayl.getItemMeta();
      graylmeta.setColor(Color.GRAY);
      grayl.setItemMeta(graylmeta);
      ItemStack grayb = new ItemStack(Material.LEATHER_BOOTS, 1);
      LeatherArmorMeta graybmeta = (LeatherArmorMeta) grayb.getItemMeta();
      graybmeta.setColor(Color.GRAY);
      grayb.setItemMeta(graybmeta);
      
      ItemStack silverh = new ItemStack(Material.LEATHER_HELMET, 1);
      LeatherArmorMeta silverhmeta = (LeatherArmorMeta) silverh.getItemMeta();
      silverhmeta.setColor(Color.SILVER);
      silverh.setItemMeta(silverhmeta);
      ItemStack silvercp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta silvercpmeta = (LeatherArmorMeta) silvercp.getItemMeta();
      silvercpmeta.setColor(Color.SILVER);
      silvercp.setItemMeta(silvercpmeta);
      ItemStack silverl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta silverlmeta = (LeatherArmorMeta) silverl.getItemMeta();
      silverlmeta.setColor(Color.SILVER);
      silverl.setItemMeta(silverlmeta);
      ItemStack silverb = new ItemStack(Material.LEATHER_BOOTS, 1);
      LeatherArmorMeta silverbmeta = (LeatherArmorMeta) silverb.getItemMeta();
      silverbmeta.setColor(Color.SILVER);
      silverb.setItemMeta(silverbmeta);
      
      ItemStack cyanh = new ItemStack(Material.LEATHER_HELMET, 1);
      LeatherArmorMeta cyanhmeta = (LeatherArmorMeta) cyanh.getItemMeta();
      cyanhmeta.setColor(Color.fromBGR(153, 127, 76));
      cyanh.setItemMeta(cyanhmeta);
      ItemStack cyancp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta cyancpmeta = (LeatherArmorMeta) cyancp.getItemMeta();
      cyancpmeta.setColor(Color.fromBGR(153, 127, 76));
      cyancp.setItemMeta(cyancpmeta);
      ItemStack cyanl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta cyanlmeta = (LeatherArmorMeta) cyanl.getItemMeta();
      cyanlmeta.setColor(Color.fromBGR(153, 127, 76));
      cyanl.setItemMeta(cyanlmeta);
      ItemStack cyanb = new ItemStack(Material.LEATHER_BOOTS, 1);
      LeatherArmorMeta cyanbmeta = (LeatherArmorMeta) cyanb.getItemMeta();
      cyanbmeta.setColor(Color.fromBGR(153, 127, 76));
      cyanb.setItemMeta(cyanbmeta);
      
      ItemStack purpleh = new ItemStack(Material.LEATHER_HELMET, 1);
      LeatherArmorMeta purplehmeta = (LeatherArmorMeta) purpleh.getItemMeta();
      purplehmeta.setColor(Color.PURPLE);
      purpleh.setItemMeta(purplehmeta);
      ItemStack purplecp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta purplecpmeta = (LeatherArmorMeta) purplecp.getItemMeta();
      purplecpmeta.setColor(Color.PURPLE);
      purplecp.setItemMeta(purplecpmeta);
      ItemStack purplel = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta purplelmeta = (LeatherArmorMeta) purplel.getItemMeta();
      purplelmeta.setColor(Color.PURPLE);
      purplel.setItemMeta(purplelmeta);
      ItemStack purpleb = new ItemStack(Material.LEATHER_BOOTS, 1);
      LeatherArmorMeta purplebmeta = (LeatherArmorMeta) purpleb.getItemMeta();
      purplebmeta.setColor(Color.PURPLE);
      purpleb.setItemMeta(purplebmeta);
      
      ItemStack blueh = new ItemStack(Material.LEATHER_HELMET, 1);
      LeatherArmorMeta bluehmeta = (LeatherArmorMeta) blueh.getItemMeta();
      bluehmeta.setColor(Color.fromBGR(178, 76, 51));
      blueh.setItemMeta(bluehmeta);
      ItemStack bluecp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta bluecpmeta = (LeatherArmorMeta) bluecp.getItemMeta();
      bluecpmeta.setColor(Color.fromBGR(178, 76, 51));
      bluecp.setItemMeta(bluecpmeta);
      ItemStack bluel = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta bluelmeta = (LeatherArmorMeta) bluel.getItemMeta();
      bluelmeta.setColor(Color.fromBGR(178, 76, 51));
      bluel.setItemMeta(bluelmeta);
      ItemStack blueb = new ItemStack(Material.LEATHER_BOOTS, 1);
      LeatherArmorMeta bluebmeta = (LeatherArmorMeta) blueb.getItemMeta();
      bluebmeta.setColor(Color.fromBGR(178, 76, 51));
      blueb.setItemMeta(bluebmeta);
      
      ItemStack brownh = new ItemStack(Material.LEATHER_HELMET, 1);
      LeatherArmorMeta brownhmeta = (LeatherArmorMeta) brownh.getItemMeta();
      brownhmeta.setColor(Color.fromBGR(51, 76, 102));
      brownh.setItemMeta(brownhmeta);
      ItemStack browncp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta browncpmeta = (LeatherArmorMeta) browncp.getItemMeta();
      browncpmeta.setColor(Color.fromBGR(51, 76, 102));
      browncp.setItemMeta(browncpmeta);
      ItemStack brownl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta brownlmeta = (LeatherArmorMeta) brownl.getItemMeta();
      brownlmeta.setColor(Color.fromBGR(51, 76, 102));
      brownl.setItemMeta(brownlmeta);
      ItemStack brownb = new ItemStack(Material.LEATHER_BOOTS, 1);
      LeatherArmorMeta brownbmeta = (LeatherArmorMeta) brownb.getItemMeta();
      brownbmeta.setColor(Color.fromBGR(51, 76, 102));
      brownb.setItemMeta(brownbmeta);
      
      ItemStack greenh = new ItemStack(Material.LEATHER_HELMET, 1);
      LeatherArmorMeta greenhmeta = (LeatherArmorMeta) greenh.getItemMeta();
      greenhmeta.setColor(Color.GREEN);
      greenh.setItemMeta(greenhmeta);
      ItemStack greencp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta greencpmeta = (LeatherArmorMeta) greencp.getItemMeta();
      greencpmeta.setColor(Color.GREEN);
      greencp.setItemMeta(greencpmeta);
      ItemStack greenl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta greenlmeta = (LeatherArmorMeta) greenl.getItemMeta();
      greenlmeta.setColor(Color.GREEN);
      greenl.setItemMeta(greenlmeta);
      ItemStack greenb = new ItemStack(Material.LEATHER_BOOTS, 1);
      LeatherArmorMeta greenbmeta = (LeatherArmorMeta) greenb.getItemMeta();
      greenbmeta.setColor(Color.GREEN);
      greenb.setItemMeta(greenbmeta);
      
      ItemStack redh = new ItemStack(Material.LEATHER_HELMET, 1);
      LeatherArmorMeta redhmeta = (LeatherArmorMeta) redh.getItemMeta();
      redhmeta.setColor(Color.RED);
      redh.setItemMeta(redhmeta);
      ItemStack redcp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta redcpmeta = (LeatherArmorMeta) redcp.getItemMeta();
      redcpmeta.setColor(Color.RED);
      redcp.setItemMeta(redcpmeta);
      ItemStack redl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta redlmeta = (LeatherArmorMeta) redl.getItemMeta();
      redlmeta.setColor(Color.RED);
      redl.setItemMeta(redlmeta);
      ItemStack redb = new ItemStack(Material.LEATHER_BOOTS, 1);
      LeatherArmorMeta redbmeta = (LeatherArmorMeta) redb.getItemMeta();
      redbmeta.setColor(Color.RED);
      redb.setItemMeta(redbmeta);
      
      ItemStack blackh = new ItemStack(Material.LEATHER_HELMET, 1);
      LeatherArmorMeta blackhmeta = (LeatherArmorMeta) blackh.getItemMeta();
      blackhmeta.setColor(Color.BLACK);
      blackh.setItemMeta(blackhmeta);
      ItemStack blackcp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta blackcpmeta = (LeatherArmorMeta) blackcp.getItemMeta();
      blackcpmeta.setColor(Color.BLACK);
      blackcp.setItemMeta(blackcpmeta);
      ItemStack blackl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      LeatherArmorMeta blacklmeta = (LeatherArmorMeta) blackl.getItemMeta();
      blacklmeta.setColor(Color.BLACK);
      blackl.setItemMeta(blacklmeta);
      ItemStack blackb = new ItemStack(Material.LEATHER_BOOTS, 1);
      LeatherArmorMeta blackbmeta = (LeatherArmorMeta) blackb.getItemMeta();
      blackbmeta.setColor(Color.BLACK);
      blackb.setItemMeta(blackbmeta);
      
      if ((inventory.getName().equals(inv.getName())) && 
        (clicked.getType() == Material.LEATHER_HELMET)) {
        event.setCancelled(true);
        player.closeInventory();
        player.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.LEATHER_CHESTPLATE)) {
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.LEATHER_LEGGINGS)) {
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.LEATHER_BOOTS)) {
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS, 1));
          
          
          
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.CHAINMAIL_HELMET)) {
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET, 1));
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.CHAINMAIL_CHESTPLATE)) {
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.CHAINMAIL_LEGGINGS)) {
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.CHAINMAIL_BOOTS)) {
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS, 1));
    
          
          
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.IRON_HELMET)) {
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET, 1));
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.IRON_CHESTPLATE)) {
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.IRON_LEGGINGS)) {
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.IRON_BOOTS)) {
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS, 1));
          
                
          
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.GOLD_HELMET)) {
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.GOLD_CHESTPLATE)) {
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.GOLD_LEGGINGS)) {
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.GOLD_BOOTS)) {
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
          
          
                   
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.DIAMOND_HELMET)) {
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.DIAMOND_CHESTPLATE)) {
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.DIAMOND_LEGGINGS)) {
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.DIAMOND_BOOTS)) {
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
          
          
          
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.GLASS) &&
              clicked.getAmount() == 1) {
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setHelmet(null);
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.GLASS) &&
              clicked.getAmount() == 2) {
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setChestplate(null);
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.GLASS) &&
              clicked.getAmount() == 3) {
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setLeggings(null);
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.GLASS) &&
              clicked.getAmount() == 4) {
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setBoots(null);
          
          
          
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.INK_SACK) &&
              clicked.getAmount() == 1) {
          event.setCancelled(true);
          player.openInventory(invlh);
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.INK_SACK) &&
              clicked.getAmount() == 2) {
          event.setCancelled(true);
          player.openInventory(invlc);
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.INK_SACK) &&
              clicked.getAmount() == 3) {
          event.setCancelled(true);
          player.openInventory(invll);
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.INK_SACK) &&
              clicked.getAmount() == 4) {
          event.setCancelled(true);
          player.openInventory(invlb);
          
          
          
      }else if ((inventory.getName().equals(invlh.getName())) && 
               (clicked.getType() == Material.ARROW)){
          event.setCancelled(true);
          player.closeInventory();
          player.openInventory(inv);
      }else if ((inventory.getName().equals(invlc.getName())) && 
              (clicked.getType() == Material.ARROW)){
         event.setCancelled(true);
         player.closeInventory();
         player.openInventory(inv);
      }else if ((inventory.getName().equals(invll.getName())) && 
              (clicked.getType() == Material.ARROW)){
         event.setCancelled(true);
         player.closeInventory();
         player.openInventory(inv);
      }else if ((inventory.getName().equals(invlb.getName())) && 
              (clicked.getType() == Material.ARROW)){
         event.setCancelled(true);
         player.closeInventory();
         player.openInventory(inv);
          
          
          
      }else if ((inventory.getName().equals(invlh.getName())) && 
              (clicked.getType() == Material.GLASS)){
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setHelmet(lh);
      }else if ((inventory.getName().equals(invlc.getName())) && 
              (clicked.getType() == Material.GLASS)){
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setChestplate(lc);
      }else if ((inventory.getName().equals(invll.getName())) && 
              (clicked.getType() == Material.GLASS)){
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setLeggings(ll);
      }else if ((inventory.getName().equals(invlb.getName())) && 
              (clicked.getType() == Material.GLASS)){
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setBoots(lb);
          
          
          
      }else if ((inventory.getName().equals(invlh.getName())) && 
               (clicked.getItemMeta().getDisplayName().contains("White"))){
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().setHelmet(whiteh);
      }else if ((inventory.getName().equals(invlc.getName())) && 
              (clicked.getItemMeta().getDisplayName().contains("White"))){
         event.setCancelled(true);
         player.closeInventory();
         player.getInventory().setChestplate(whitecp);
      }else if ((inventory.getName().equals(invll.getName())) && 
              (clicked.getItemMeta().getDisplayName().contains("White"))){
         event.setCancelled(true);
         player.closeInventory();
         player.getInventory().setLeggings(whitel);
      }else if ((inventory.getName().equals(invlb.getName())) && 
              (clicked.getItemMeta().getDisplayName().contains("White"))){
         event.setCancelled(true);
         player.closeInventory();
         player.getInventory().setBoots(whiteb);
         
         
      }else if ((inventory.getName().equals(invlh.getName())) && 
              (clicked.getItemMeta().getDisplayName().contains("Orange"))){
         event.setCancelled(true);
         player.closeInventory();
         player.getInventory().setHelmet(orangeh);
     }else if ((inventory.getName().equals(invlc.getName())) && 
             (clicked.getItemMeta().getDisplayName().contains("Orange"))){
        event.setCancelled(true);
        player.closeInventory();
        player.getInventory().setChestplate(orangecp);
     }else if ((inventory.getName().equals(invll.getName())) && 
             (clicked.getItemMeta().getDisplayName().contains("Orange"))){
        event.setCancelled(true);
        player.closeInventory();
        player.getInventory().setLeggings(orangel);
     }else if ((inventory.getName().equals(invlb.getName())) && 
             (clicked.getItemMeta().getDisplayName().contains("Orange"))){
        event.setCancelled(true);
        player.closeInventory();
        player.getInventory().setBoots(orangeb);
        
        
     }else if ((inventory.getName().equals(invlh.getName())) && 
             (clicked.getItemMeta().getDisplayName().contains("Magenta"))){
        event.setCancelled(true);
        player.closeInventory();
        player.getInventory().setHelmet(magentah);
    }else if ((inventory.getName().equals(invlc.getName())) && 
            (clicked.getItemMeta().getDisplayName().contains("Magenta"))){
       event.setCancelled(true);
       player.closeInventory();
       player.getInventory().setChestplate(magentacp);
    }else if ((inventory.getName().equals(invll.getName())) && 
            (clicked.getItemMeta().getDisplayName().contains("Magenta"))){
       event.setCancelled(true);
       player.closeInventory();
       player.getInventory().setLeggings(magental);
    }else if ((inventory.getName().equals(invlb.getName())) && 
            (clicked.getItemMeta().getDisplayName().contains("Magenta"))){
       event.setCancelled(true);
       player.closeInventory();
       player.getInventory().setBoots(magentab);
       
       
    }else if ((inventory.getName().equals(invlh.getName())) && 
            (clicked.getItemMeta().getDisplayName().contains("Light Blue"))){
       event.setCancelled(true);
       player.closeInventory();
       player.getInventory().setHelmet(lightblueh);
   }else if ((inventory.getName().equals(invlc.getName())) && 
           (clicked.getItemMeta().getDisplayName().contains("Light Blue"))){
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(lightbluecp);
   }else if ((inventory.getName().equals(invll.getName())) && 
           (clicked.getItemMeta().getDisplayName().contains("Light Blue"))){
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(lightbluel);
   }else if ((inventory.getName().equals(invlb.getName())) && 
           (clicked.getItemMeta().getDisplayName().contains("Light Blue"))){
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(lightblueb);
      
      
   }else if ((inventory.getName().equals(invlh.getName())) && 
           (clicked.getItemMeta().getDisplayName().contains("Yellow"))){
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(yellowh);
  }else if ((inventory.getName().equals(invlc.getName())) && 
          (clicked.getItemMeta().getDisplayName().contains("Yellow"))){
     event.setCancelled(true);
     player.closeInventory();
     player.getInventory().setChestplate(yellowcp);
  }else if ((inventory.getName().equals(invll.getName())) && 
          (clicked.getItemMeta().getDisplayName().contains("Yellow"))){
     event.setCancelled(true);
     player.closeInventory();
     player.getInventory().setLeggings(yellowl);
  }else if ((inventory.getName().equals(invlb.getName())) && 
          (clicked.getItemMeta().getDisplayName().contains("Yellow"))){
     event.setCancelled(true);
     player.closeInventory();
     player.getInventory().setBoots(yellowb);
     
     
  }else if ((inventory.getName().equals(invlh.getName())) && 
          (clicked.getItemMeta().getDisplayName().contains("Lime"))){
     event.setCancelled(true);
     player.closeInventory();
     player.getInventory().setHelmet(limeh);
 }else if ((inventory.getName().equals(invlc.getName())) && 
         (clicked.getItemMeta().getDisplayName().contains("Lime"))){
    event.setCancelled(true);
    player.closeInventory();
    player.getInventory().setChestplate(limecp);
 }else if ((inventory.getName().equals(invll.getName())) && 
         (clicked.getItemMeta().getDisplayName().contains("Lime"))){
    event.setCancelled(true);
    player.closeInventory();
    player.getInventory().setLeggings(limel);
 }else if ((inventory.getName().equals(invlb.getName())) && 
         (clicked.getItemMeta().getDisplayName().contains("Lime"))){
    event.setCancelled(true);
    player.closeInventory();
    player.getInventory().setBoots(limeb);
    
    
 }else if ((inventory.getName().equals(invlh.getName())) && 
         (clicked.getItemMeta().getDisplayName().contains("Pink"))){
    event.setCancelled(true);
    player.closeInventory();
    player.getInventory().setHelmet(pinkh);
}else if ((inventory.getName().equals(invlc.getName())) && 
        (clicked.getItemMeta().getDisplayName().contains("Pink"))){
   event.setCancelled(true);
   player.closeInventory();
   player.getInventory().setChestplate(pinkcp);
}else if ((inventory.getName().equals(invll.getName())) && 
        (clicked.getItemMeta().getDisplayName().contains("Pink"))){
   event.setCancelled(true);
   player.closeInventory();
   player.getInventory().setLeggings(pinkl);
}else if ((inventory.getName().equals(invlb.getName())) && 
        (clicked.getItemMeta().getDisplayName().contains("Pink"))){
   event.setCancelled(true);
   player.closeInventory();
   player.getInventory().setBoots(pinkb);
   
   
}else if ((inventory.getName().equals(invlh.getName())) && 
        (clicked.getItemMeta().getDisplayName().contains("Gray"))){
   event.setCancelled(true);
   player.closeInventory();
   player.getInventory().setHelmet(grayh);
}else if ((inventory.getName().equals(invlc.getName())) && 
       (clicked.getItemMeta().getDisplayName().contains("Gray"))){
  event.setCancelled(true);
  player.closeInventory();
  player.getInventory().setChestplate(graycp);
}else if ((inventory.getName().equals(invll.getName())) && 
       (clicked.getItemMeta().getDisplayName().contains("Gray"))){
  event.setCancelled(true);
  player.closeInventory();
  player.getInventory().setLeggings(grayl);
}else if ((inventory.getName().equals(invlb.getName())) && 
       (clicked.getItemMeta().getDisplayName().contains("Gray"))){
  event.setCancelled(true);
  player.closeInventory();
  player.getInventory().setBoots(grayb);
  
  
}else if ((inventory.getName().equals(invlh.getName())) && 
       (clicked.getItemMeta().getDisplayName().contains("Silver"))){
  event.setCancelled(true);
  player.closeInventory();
  player.getInventory().setHelmet(silverh);
}else if ((inventory.getName().equals(invlc.getName())) && 
      (clicked.getItemMeta().getDisplayName().contains("Silver"))){
 event.setCancelled(true);
 player.closeInventory();
 player.getInventory().setChestplate(silvercp);
}else if ((inventory.getName().equals(invll.getName())) && 
      (clicked.getItemMeta().getDisplayName().contains("Silver"))){
 event.setCancelled(true);
 player.closeInventory();
 player.getInventory().setLeggings(silverl);
}else if ((inventory.getName().equals(invlb.getName())) && 
      (clicked.getItemMeta().getDisplayName().contains("Silver"))){
 event.setCancelled(true);
 player.closeInventory();
 player.getInventory().setBoots(silverb);
 
 
}else if ((inventory.getName().equals(invlh.getName())) && 
      (clicked.getItemMeta().getDisplayName().contains("Cyan"))){
 event.setCancelled(true);
 player.closeInventory();
 player.getInventory().setHelmet(cyanh);
}else if ((inventory.getName().equals(invlc.getName())) && 
     (clicked.getItemMeta().getDisplayName().contains("Cyan"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setChestplate(cyancp);
}else if ((inventory.getName().equals(invll.getName())) && 
     (clicked.getItemMeta().getDisplayName().contains("Cyan"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setLeggings(cyanl);
}else if ((inventory.getName().equals(invlb.getName())) && 
     (clicked.getItemMeta().getDisplayName().contains("Cyan"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setBoots(cyanb);


}else if ((inventory.getName().equals(invlh.getName())) && 
     (clicked.getItemMeta().getDisplayName().contains("Purple"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setHelmet(purpleh);
}else if ((inventory.getName().equals(invlc.getName())) && 
    (clicked.getItemMeta().getDisplayName().contains("Purple"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setChestplate(purplecp);
}else if ((inventory.getName().equals(invll.getName())) && 
    (clicked.getItemMeta().getDisplayName().contains("Purple"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setLeggings(purplel);
}else if ((inventory.getName().equals(invlb.getName())) && 
    (clicked.getItemMeta().getDisplayName().contains("Purple"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setBoots(purpleb);


}else if ((inventory.getName().equals(invlh.getName())) && 
     (clicked.getItemMeta().getDisplayName().contains("Blue"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setHelmet(blueh);
}else if ((inventory.getName().equals(invlc.getName())) && 
    (clicked.getItemMeta().getDisplayName().contains("Blue"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setChestplate(bluecp);
}else if ((inventory.getName().equals(invll.getName())) && 
    (clicked.getItemMeta().getDisplayName().contains("Blue"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setLeggings(bluel);
}else if ((inventory.getName().equals(invlb.getName())) && 
    (clicked.getItemMeta().getDisplayName().contains("Blue"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setBoots(blueb);


}else if ((inventory.getName().equals(invlh.getName())) && 
     (clicked.getItemMeta().getDisplayName().contains("Brown"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setHelmet(brownh);
}else if ((inventory.getName().equals(invlc.getName())) && 
    (clicked.getItemMeta().getDisplayName().contains("Brown"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setChestplate(browncp);
}else if ((inventory.getName().equals(invll.getName())) && 
    (clicked.getItemMeta().getDisplayName().contains("Brown"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setLeggings(brownl);
}else if ((inventory.getName().equals(invlb.getName())) && 
    (clicked.getItemMeta().getDisplayName().contains("Brown"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setBoots(brownb);


}else if ((inventory.getName().equals(invlh.getName())) && 
     (clicked.getItemMeta().getDisplayName().contains("Green"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setHelmet(greenh);
}else if ((inventory.getName().equals(invlc.getName())) && 
    (clicked.getItemMeta().getDisplayName().contains("Green"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setChestplate(greencp);
}else if ((inventory.getName().equals(invll.getName())) && 
    (clicked.getItemMeta().getDisplayName().contains("Green"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setLeggings(greenl);
}else if ((inventory.getName().equals(invlb.getName())) && 
    (clicked.getItemMeta().getDisplayName().contains("Green"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setBoots(greenb);


}else if ((inventory.getName().equals(invlh.getName())) && 
     (clicked.getItemMeta().getDisplayName().contains("Red"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setHelmet(redh);
}else if ((inventory.getName().equals(invlc.getName())) && 
    (clicked.getItemMeta().getDisplayName().contains("Red"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setChestplate(redcp);
}else if ((inventory.getName().equals(invll.getName())) && 
    (clicked.getItemMeta().getDisplayName().contains("Red"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setLeggings(redl);
}else if ((inventory.getName().equals(invlb.getName())) && 
    (clicked.getItemMeta().getDisplayName().contains("Red"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setBoots(redb);


}else if ((inventory.getName().equals(invlh.getName())) && 
     (clicked.getItemMeta().getDisplayName().contains("Black"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setHelmet(blackh);
}else if ((inventory.getName().equals(invlc.getName())) && 
    (clicked.getItemMeta().getDisplayName().contains("Black"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setChestplate(blackcp);
}else if ((inventory.getName().equals(invll.getName())) && 
    (clicked.getItemMeta().getDisplayName().contains("Black"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setLeggings(blackl);
}else if ((inventory.getName().equals(invlb.getName())) && 
    (clicked.getItemMeta().getDisplayName().contains("Black"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setBoots(blackb);
         	
	} else {
		if (inventory.getName().equals(invlh.getName())
				|| inventory.getName().equals(invlc.getName())
				|| inventory.getName().equals(invll.getName())
				|| inventory.getName().equals(invlb.getName())
				|| inventory.getName().equals(inv.getName())){
			if(clicked != null){
			event.setCancelled(true);
			player.closeInventory();
			}
		}
	}
		if (inventory.getName().equals(invlh.getName())
				|| inventory.getName().equals(invlc.getName())
				|| inventory.getName().equals(invll.getName())
				|| inventory.getName().equals(invlb.getName())
				|| inventory.getName().equals(inv.getName())){
			player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
		}

 } 
        
// ================================================== WARDROBE END OYEAH ==================================================     
    
// ================================================== FUNGUNS BEGGINING ==================================================         
    
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onProjectileHit(final ProjectileHitEvent e){
	
		final Location blockloc = e.getEntity().getLocation().add(0, -1, 0);
		final Material firstblock = blockloc.getBlock().getType();
		final byte firstblockdata = blockloc.getBlock().getData();
		
		if(e.getEntityType() == EntityType.ENDER_PEARL){
			if(firstblock != Material.WOOL){
				if(firstblock != Material.AIR){
			ParticleEffect.displayBlockCrack(e.getEntity().getLocation(), 49, (byte) 1, 0, 0, 0, 25);
			ParticleEffect.displayBlockCrack(e.getEntity().getLocation(), 49, (byte) 1, 0, 0, 0, 25);
			ParticleEffect.displayBlockCrack(e.getEntity().getLocation(), 49, (byte) 1, 0, 0, 0, 25);
			
            
            Random dice = new Random();
            int number;
            number = dice.nextInt(15);
            switch (number) {
            case 1:
            		
            	
            		blockloc.getBlock().setType(Material.WOOL);
            		blockloc.getBlock().setData((byte) 1);
            		
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {
							
							blockloc.getBlock().setType(firstblock);
							blockloc.getBlock().setData(firstblockdata);
							
						}    
                    }, 40); 
            		
                    break;
            case 2:
            		blockloc.getBlock().setType(Material.WOOL);	
            		blockloc.getBlock().setData((byte) 2);
            		
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {
							
							blockloc.getBlock().setType(firstblock);
							blockloc.getBlock().setData(firstblockdata);
						}    
                    }, 40); 
            		
                    break;
            case 3:
            		blockloc.getBlock().setType(Material.WOOL);
            		blockloc.getBlock().setData((byte) 3);
            		
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {
							
							blockloc.getBlock().setType(firstblock);
							blockloc.getBlock().setData(firstblockdata);
						}    
                    }, 40); 
            		
            		break;
            case 4:
        			blockloc.getBlock().setType(Material.WOOL);
        			blockloc.getBlock().setData((byte) 4);
            		
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {
							
							blockloc.getBlock().setType(firstblock);
							blockloc.getBlock().setData(firstblockdata);
						}    
                    }, 40); 
            		
        			break;
            case 5:
	        		blockloc.getBlock().setType(Material.WOOL);
	        		blockloc.getBlock().setData((byte) 5);
            		
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {
							
							blockloc.getBlock().setType(firstblock);
							blockloc.getBlock().setData(firstblockdata);
						}    
                    }, 40); 
            		
	                break;
            case 6:
        			blockloc.getBlock().setType(Material.WOOL);
        			blockloc.getBlock().setData((byte) 6);
            		
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {
							
							blockloc.getBlock().setType(firstblock);
							blockloc.getBlock().setData(firstblockdata);
						}    
                    }, 40); 
            		
        			break;
            case 7:
        			blockloc.getBlock().setType(Material.WOOL);
        			blockloc.getBlock().setData((byte) 7);
            		
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {
							
							blockloc.getBlock().setType(firstblock);
							blockloc.getBlock().setData(firstblockdata);
						}    
                    }, 40); 
            		
        			break;
            case 8:
        			blockloc.getBlock().setType(Material.WOOL);
        			blockloc.getBlock().setData((byte) 8);
            		
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {
							
							blockloc.getBlock().setType(firstblock);
							blockloc.getBlock().setData(firstblockdata);
						}    
                    }, 40); 
            		
        			break;
            case 9:
        			blockloc.getBlock().setType(Material.WOOL);
        			blockloc.getBlock().setData((byte) 9);
            		
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {
							
							blockloc.getBlock().setType(firstblock);
							blockloc.getBlock().setData(firstblockdata);
						}    
                    }, 40); 
            		
                	break;
            case 10:
        			blockloc.getBlock().setType(Material.WOOL);
        			blockloc.getBlock().setData((byte) 10);
            		
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {
							
							blockloc.getBlock().setType(firstblock);
							blockloc.getBlock().setData(firstblockdata);
						}    
                    }, 40); 
            		
                	break;
            case 11:
        			blockloc.getBlock().setType(Material.WOOL);
        			blockloc.getBlock().setData((byte) 11);
            		
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {
							
							blockloc.getBlock().setType(firstblock);
							blockloc.getBlock().setData(firstblockdata);
						}    
                    }, 40); 
            		
                	break;
            case 12:
        			blockloc.getBlock().setType(Material.WOOL);
        			blockloc.getBlock().setData((byte) 12);
            		
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {
							
							blockloc.getBlock().setType(firstblock);
							blockloc.getBlock().setData(firstblockdata);
						}    
                    }, 40); 
            		
        			break;
            case 13:
        			blockloc.getBlock().setType(Material.WOOL);
        			blockloc.getBlock().setData((byte) 13);
            		
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {
							
							blockloc.getBlock().setType(firstblock);
							blockloc.getBlock().setData(firstblockdata);
						}    
                    }, 40); 
            		
        			break;
            case 14:
        			blockloc.getBlock().setType(Material.WOOL);
        			blockloc.getBlock().setData((byte) 14);
            		
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {
							
							blockloc.getBlock().setType(firstblock);
							blockloc.getBlock().setData(firstblockdata);
							
						}    
                    }, 40); 
            		
        			break;
            case 15:
        			blockloc.getBlock().setType(Material.WOOL);
        			blockloc.getBlock().setData((byte) 15);
            		
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {
							
							blockloc.getBlock().setType(firstblock);
							blockloc.getBlock().setData(firstblockdata);
						}    
                    }, 40); 
            		
        			break;
            }
            
			}
			}

		
		}
	}

    
	@EventHandler
	public void onTeleport(PlayerTeleportEvent event) {
	if(event.getCause() == TeleportCause.ENDER_PEARL) {
	event.setCancelled(true);
	}
	}

	@EventHandler
	public void onEntityDamage(EntityDamageEvent e){
		if(e.getCause() == DamageCause.PROJECTILE){
			e.setCancelled(true);
		}
	}
	
// ====================================================== FUNGUNS END =====================================================       
    
    
        public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
    		
        	Player p = (Player)sender;
        	
        	final String prefix = settings.getConfig().getString("Main-Messages.Prefix").replaceAll("&", "§");
        	
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
        	
        	final ItemStack wardrobeItem = new ItemStack(Material.IRON_INGOT, 1);
        	final ItemMeta wardrobeItemmeta = wardrobeItem.getItemMeta();
        	wardrobeItemmeta.setDisplayName("§3§lWardRobe §7(Right click !)");
        	wardrobeItem.setItemMeta(wardrobeItemmeta);
        	
        	ItemStack paintballgun = new ItemStack(Material.GOLD_BARDING, 1);
        	ItemMeta paintballgunmeta = paintballgun.getItemMeta();
        	paintballgunmeta.setDisplayName("§aPaintBall Gun §7(Right click)");
        	paintballgun.setItemMeta(paintballgunmeta);

        	ItemStack batblaster = new ItemStack(Material.IRON_BARDING, 1);
        	ItemMeta batblastermeta = batblaster.getItemMeta();
        	batblastermeta.setDisplayName("§cBat Blaster §7(Right click)");
        	batblaster.setItemMeta(batblastermeta);
        	
    		if(cmd.getName().equalsIgnoreCase("hg")
    				|| cmd.getName().equalsIgnoreCase("hubgadgets")
    				|| cmd.getName().equalsIgnoreCase("gadgets")){
    			if(args.length == 0){
    			sender.sendMessage("§4§l§m*********************************************");
    			sender.sendMessage("§6§l§nHubGadgets");
    			sender.sendMessage("§3§la plugin by §c§nsachal2406 §r§3and §c§nmage1d");
    			sender.sendMessage("§a§lType \"§c§l/hg help§r§a§l\" for help.");
    			p.sendMessage("§4§l§m*********************************************");
    			return true;
    			}
    		if(args[0].equalsIgnoreCase("reload")){
    			if(p.hasPermission("hubgadgets.reload")){
    			settings.reloadConfig();
    			sender.sendMessage(settings.getConfig().getString("Main-Messages.Prefix").replaceAll("&", "§") + settings.getConfig().getString("Main-Messages.Config-Reloaded").replaceAll("&", "§"));
    			} else {
    				p.sendMessage(prefix + "§cYou don't have the permission !");
    			}
    		    } else if(args[0].equalsIgnoreCase("give")){
    			if(p.hasPermission("hubgadgets.give")){
    			if(args.length == 2){
    				if(args[1].equalsIgnoreCase("wardrobe") && p.hasPermission("hubgadgets.wardrobe")){
    						p.getInventory().addItem(wardrobeItem);
    						
    				} else if(args[1].equalsIgnoreCase("mobgun")){
    						p.getInventory().addItem(piglauncher);
    						
    				} else if(args[1].equalsIgnoreCase("BatBlaster")){
    						p.getInventory().addItem(batblaster);
    						
    				} else if(args[1].equalsIgnoreCase("PBGun")){
    						p.getInventory().addItem(paintballgun);
    					
    						
    			} else {
        			p.sendMessage("§4§l§m*****************************************************");
        			p.sendMessage("§3§lAvailable things to give:");
        			p.sendMessage("§9§l - §6§lThe MobGun §r§l| §b/hg give §cMobGun");
        			p.sendMessage("§9§l - §6§lThe PaintBall Gun §r§l| §b/hg give §cPBGun");
        			p.sendMessage("§9§l - §6§lThe Bat Blaster §r§l| §b/hg give §cBatBlaster");
        			p.sendMessage("§9§l - §6§lThe WardRobe §r§l| §b/hg give §cWardrobe");
        			p.sendMessage("§4§l§m*****************************************************");
    			}
    	} else {
			p.sendMessage("§4§l§m*****************************************************");
			p.sendMessage("§3§lAvailable things to give:");
			p.sendMessage("§9§l - §6§lThe MobGun §r§l| §b/hg give §cMobGun");
			p.sendMessage("§9§l - §6§lThe PaintBall Gun §r§l| §b/hg give §cPBGun");
			p.sendMessage("§9§l - §6§lThe Bat Blaster §r§l| §b/hg give §cBatBlaster");
			p.sendMessage("§9§l - §6§lThe WardRobe §r§l| §b/hg give §cWardrobe");
			p.sendMessage("§4§l§m*****************************************************");
    	}
    			} else {
    				p.sendMessage(prefix + "§cYou don't have the permission !");
    			}
    				
    			
    		} else if(args[0].equalsIgnoreCase("help")){
    			p.sendMessage("§4§l§m*****************************************************");
    			p.sendMessage("§3§lCommands:");
    			p.sendMessage("§9§l - §6§l/hg help  §r§l| §bshows this page.");
     			p.sendMessage("§9§l - §6§l/hg give  §r§l| §bgives a Gadget.");
     			p.sendMessage("§9§l - §6§l/hg wardrobe  §r§l| §bopens the wardrobe.");
     			p.sendMessage("§9§l - §6§l/hg reload §r§l| §breloads the plugin.");
     			p.sendMessage("§9§l - §6§l/hg gui §7(SOON..) §r§l| §bopens the Gadgets GUI. §7(SOON..)");
    			p.sendMessage("§4§l§m*****************************************************");
    		} else if(args[0].equalsIgnoreCase("wardrobe")){
    			if(p.hasPermission("hubgadgets.wardrobe")){
    			this.show(p);
    			} else {
    				p.sendMessage(prefix + "§cYou don't have the permission !");
    			}
    		} else if(args[0].equalsIgnoreCase("gui")){
    			if(p.hasPermission("hubgadgets.gui")){
    			p.sendMessage("§4§l§m*****************************************************");
    			p.sendMessage(prefix+"§7§lThe GUI will be added soon !");
    			p.sendMessage("§4§l§m*****************************************************");
    			} else {
    				p.sendMessage(prefix + "§cYou don't have the permission !");
    			}
    		} else {
    			p.sendMessage(prefix + "§cUnknown command ! Type §r§l/hg help§r§c for help.");
    		}
    		}
    		
    		
    		
    		return true;	
    	}
}