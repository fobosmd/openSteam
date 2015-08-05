package fobos.opensteam.client.plugin;

import fobos.opensteam.client.Client;
import fobos.opensteam.common.entity.ItemEntity;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.List;

/**
 * Created by Kirill Listopad on 10/25/14.
 */
public class PlayerListener implements Listener {
    private Client client;

    public PlayerListener(Client client){
        this.client = client;
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent evt){
        List<ItemEntity> items = client.getItems();
        Player player = evt.getPlayer();
        PlayerInventory inventory = player.getInventory();
        ItemStack[] stacks = new ItemStack[items.size()];

        for (int i = 0; i < items.size(); i++) {
            stacks[i] = new ItemStack(Material.getMaterial(items.get(i).getMaterialName()), 1);
        }
        inventory.addItem(stacks);
    }
}
