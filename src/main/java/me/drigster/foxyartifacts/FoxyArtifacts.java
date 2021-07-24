package me.drigster.foxyartifacts;

import me.drigster.foxyartifacts.events.foxEvent;
import me.drigster.foxyartifacts.events.onBookSelection;
import me.drigster.foxyartifacts.events.salmonEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class FoxyArtifacts extends JavaPlugin {

    private static FoxyArtifacts INSTANCE;

    @Override
    public void onEnable() {
        this.INSTANCE = this;
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new salmonEvent(), this);
        pm.registerEvents(new foxEvent(), this);
        pm.registerEvents(new onBookSelection(), this);
    }

    public static FoxyArtifacts getInstance() {
        return INSTANCE;
    }
}
