package me.drigster.foxyartifacts.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map.Entry;

public class salmonEvent implements Listener {

    @EventHandler
    public void onSalmonEat(PlayerItemConsumeEvent e){
        ItemStack Item = e.getItem();
        Player player = e.getPlayer();
        World world = player.getLocation().getWorld();
        player.sendMessage("salmon " + Item);
        if (Item.getType().equals(Material.SALMON)){
            world.strikeLightning(player.getLocation());
            Bukkit.broadcastMessage(player.getName() + " вызвал небесную кару!");
        }
        if (Item.getType().equals(Material.COOKED_SALMON)){
            world.strikeLightning(player.getLocation());
            Bukkit.broadcastMessage(player.getName() + " вызвал небесную кару!");
        }
    }

    @EventHandler
    public void onFurnaceSmelted(FurnaceSmeltEvent e){
        Bukkit.broadcastMessage("Кто-то вызвал небесную кару!");
        if (e.getResult().getType().equals(Material.COOKED_SALMON)){
            Location location = e.getBlock().getLocation();
            World world = location.getWorld();
            world.strikeLightning(location);
            world.createExplosion(location, 3, false);
        }
    }
}
