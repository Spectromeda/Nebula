package org.nebulamc.plugin.listeners;

import net.ess3.api.events.AfkStatusChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.nebulamc.plugin.Nebula;

import java.util.UUID;


public class AFKStatusChangeListener implements Listener {

    static Nebula plugin;

    public AFKStatusChangeListener(Nebula main){
        plugin = main;
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    public void onAfk(AfkStatusChangeEvent event){
        Player player = Bukkit.getPlayer(event.getAffected().getName());
        if (event.getValue()){
            UUID uuid = player.getUniqueId();
            Location playerLoc = player.getLocation();
            Location afkWarp = new Location(Bukkit.getWorld("nebula"), 1013.5, 84, 1006.5,-180 ,-4);
            player.teleport(afkWarp);
        }
    }

}