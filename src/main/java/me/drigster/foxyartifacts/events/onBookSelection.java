package me.drigster.foxyartifacts.events;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.List;

public class onBookSelection implements Listener {
    @EventHandler
    private void HeldEvent(PlayerItemHeldEvent e){
        onBookSelected(e.getPlayer());
    }

    @EventHandler
    private void HeldEvent(PlayerSwapHandItemsEvent e){
        onBookSelected(e.getPlayer());
    }

    @EventHandler
    private void HeldEvent(PlayerPickupItemEvent e){
        onBookSelected(e.getPlayer());
    }

    @EventHandler
    private void HeldEvent(InventoryOpenEvent e){
        List<HumanEntity> Vivers = e.getViewers();
        for (HumanEntity player : Vivers){
            player.sendMessage("you opened inventory");
        }
    }

    private void onBookSelected(Player player){
        ItemStack Item = player.getInventory().getItemInMainHand();

        if (Item.equals(Material.WRITTEN_BOOK)){
            BookMeta Meta = (BookMeta)Item.getItemMeta();
            player.sendMessage("BOOK");
            System.out.println(Meta);

            Meta.setTitle("ChangedTitle");
            Meta.setPage(1, player.getName());
            Item.setItemMeta(Meta);
        }
        else {
            player.sendMessage("NOT BOOK");
        }
    }
}
