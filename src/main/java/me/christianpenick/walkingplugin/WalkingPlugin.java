package me.christianpenick.walkingplugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.meta.tags.ItemTagType;
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
    public void EntityHoldBlockEvent(PlayerInteractEvent event) {
        // Player object
        Player player = (Player)event.getPlayer();

        // radius of blocks around player
        int radius = 2;

        Material handItemType = player.getInventory().getItemInMainHand().getType();
        Block blockUnderPlayer = player.getLocation().getBlock().getRelative(BlockFace.DOWN);

        if (handItemType.isBlock() && !blockUnderPlayer.isEmpty()) // player.getItemInHand() != null <-- might be necessary check
        {
            Location playerLoc = player.getLocation();
            double pX = playerLoc.getX();
            double pY = playerLoc.getY();
            double pZ = playerLoc.getZ();

            for (int x = -(radius); x <= radius; x ++)
            {
                for (int y = -(radius); y <= radius; y ++)
                {
                    Block b = player.getWorld().getBlockAt((int)pX+x, (int)pY+y, (int)pZ);
                    b.setType(handItemType);
                }
            }
        }
    }
}

