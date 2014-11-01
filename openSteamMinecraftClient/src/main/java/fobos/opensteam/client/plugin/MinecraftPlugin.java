package fobos.opensteam.client.plugin;

import fobos.opensteam.client.Client;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

/**
 * Created by md on 10/25/14.
 */
public class MinecraftPlugin extends JavaPlugin {

    private Client client;

    @Override
    public void onEnable() {
        client = new Client();
        getServer().getPluginManager().registerEvents(new PlayerListener(client), this);
        getLogger().log(Level.INFO, "<<<<<<<<<<<<<<<<<< MinecraftPlugin ENABLED >>>>>>>>>>>>>>>>>>>>>>>");
    }


}
