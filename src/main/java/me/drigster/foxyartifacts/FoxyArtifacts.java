package me.drigster.foxyartifacts;

import me.drigster.foxyartifacts.events.foxEvents;
import me.drigster.foxyartifacts.events.bookEvents;
import me.drigster.foxyartifacts.events.salmonEvents;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class FoxyArtifacts extends JavaPlugin {

    private static FoxyArtifacts INSTANCE;

    @Override
    public void onEnable() {
        this.INSTANCE = this;
        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new salmonEvents(), this);
        pm.registerEvents(new foxEvents(), this);
        //pm.registerEvents(new bookEvents(), this);
    }

    public static FoxyArtifacts getInstance() {
        return INSTANCE;
    }
}
