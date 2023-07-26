package me.christianpenick.walkingplugin;

import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class WalkingPlugin extends JavaPlugin implements Listener
{

    public WalkingPlugin(){

    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Parkour plugin started.");
        this.getServer().getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Parkour plugin ended.");
    }


    @EventHandler
    public void EntityHoldBlockEvent(Entity event) {

        if(event.getEntityType() == EntityType.PLAYER) {
            Player player = (Player)event.getEntity();
            if (player.getHand() != EquipmentSlot.HAND)
            Block userBlock = (Player)event.getBlock();
        }

    }
}
