package me.drigster.foxyartifacts.events;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class salmonEvents implements Listener {

    @EventHandler
    public void onSalmonEat(PlayerItemConsumeEvent e){
        ItemStack Item = e.getItem();
        Player player = e.getPlayer();
        World world = player.getLocation().getWorld();
        if (Item.getType().equals(Material.SALMON)){
            world.strikeLightningEffect(player.getLocation());
            world.playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, SoundCategory.AMBIENT, 10, 1);
            PotionEffect effect = new PotionEffect(PotionEffectType.HARM, 1, 1000);
            player.addPotionEffect(effect);
            Bukkit.broadcastMessage(player.getName() + " вызвал небесную кару!");
        }
        if (Item.getType().equals(Material.COOKED_SALMON)){
            world.strikeLightningEffect(player.getLocation());
            world.playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, SoundCategory.AMBIENT, 10, 1);
            PotionEffect effect = new PotionEffect(PotionEffectType.HARM, 1, 1000);
            player.addPotionEffect(effect);
            Bukkit.broadcastMessage(player.getName() + " вызвал небесную кару!");
        }
    }

    @EventHandler
    public void onFurnaceSmelted(FurnaceSmeltEvent e){
        if (e.getResult().getType().equals(Material.COOKED_SALMON)){
            Location location = e.getBlock().getLocation();
            World world = location.getWorld();
            world.strikeLightning(location);
            world.createExplosion(location, 3, false);
            Bukkit.broadcastMessage("Кто-то вызвал небесную кару!");
        }
    }
}
