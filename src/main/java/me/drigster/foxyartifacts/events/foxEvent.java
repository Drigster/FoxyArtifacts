package me.drigster.foxyartifacts.events;

import me.drigster.foxyartifacts.FoxyArtifacts;
import me.drigster.foxyartifacts.mobs.foxGod;
import net.minecraft.server.v1_16_R3.EntityLiving;
import net.minecraft.server.v1_16_R3.WorldServer;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.scheduler.BukkitScheduler;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class foxEvent implements Listener {

    FoxyArtifacts plugin = FoxyArtifacts.getInstance();

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {
        LivingEntity dead = e.getEntity();
        Player killer = dead.getKiller();
        if (dead.getType().equals(EntityType.FOX)) {
            if (killer == null) {
                return;
            }
            Location location = killer.getLocation();
            WorldServer world = ((CraftWorld) killer.getWorld()).getHandle();
            List<foxGod> foxes = new ArrayList<>();
            if (killer.getGameMode().equals(GameMode.CREATIVE)) {
                return;
            }
            Bukkit.broadcastMessage(killer.getName() + " вызвал небесную кару!");
            int r = 4;
            Location l = location.subtract(r, 0, r / 2.0);
            for (double i = 0; i < 2 * Math.PI; i = i + (Math.PI / 3)) {
                double x = Math.sin(i) * r;
                double z = Math.cos(i) * r;

                DecimalFormat df = new DecimalFormat("#.00");

                l = l.add(x, 0, z);
                foxGod fox = new foxGod(l);
                fox.setGoalTarget(((CraftPlayer) killer).getHandle());
                world.addEntity(fox);
                foxes.add(fox);
            }
            BukkitScheduler scheduler = plugin.getServer().getScheduler();
            for (foxGod fox : foxes) {
                scheduler.runTaskLater(plugin, new Runnable() {
                    @Override
                    public void run() {
                        (killer.playSound(fox.getBukkitEntity().getLocation(), Sound.ENTITY_ILLUSIONER_CAST_SPELL, 2, 1);
                        killer.spawnParticle(Particle.EXPLOSION_NORMAL, fox.locX(), fox.locY(), fox.locZ(), 60);
                        world.removeEntity(fox);
                    }
                }, 20 * 10);
            }
        }
    }
}
