package fobos.opensteam.client.plugin;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

/**
 * Created by md on 10/25/14.
 */
public class MinecraftPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getLogger().log(Level.INFO, "<<<<<<<<<<<<<<<<<< MinecraftPlugin ENABLED >>>>>>>>>>>>>>>>>>>>>>>");
    }


}
