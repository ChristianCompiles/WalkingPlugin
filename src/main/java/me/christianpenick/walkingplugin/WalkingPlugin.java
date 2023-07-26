package me.christianpenick.walkingplugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class WalkingPlugin extends JavaPlugin implements Listener
{

    public WalkingPlugin(){

    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Walking plugin started.");
        this.getServer().getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Walking plugin ended.");
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        // Player object
        Player player = event.getPlayer();

        // radius of blocks around player
        int radius = 1;

        // Material handItemType = player.getInventory().getItemInMainHand().getType();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        Block blockUnderPlayer = player.getLocation().getBlock().getRelative(0, -1, 0);

        if (itemInHand != null && itemInHand.getType() != Material.AIR && !blockUnderPlayer.isEmpty()) // player.getItemInHand() != null <-- might be necessary check
        {
            Location playerLoc = player.getLocation();
            double pX = playerLoc.getX();
            double pY = playerLoc.getY()-1;
            double pZ = playerLoc.getZ();

            for (int x = -(radius); x <= radius; x ++)
            {
                for (int z = -(radius); z <= radius; z ++)
                {
                    Block b = player.getWorld().getBlockAt((int)pX+x, (int)pY, (int)pZ+z);
                    b.setType(itemInHand.getType());
                }
            }
        }
    }
}

