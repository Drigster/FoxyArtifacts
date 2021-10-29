package me.drigster.foxyartifacts.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;

public class bookEvents implements Listener {

    @EventHandler
    public void onInventoryInteract(InventoryClickEvent e){
        Bukkit.broadcastMessage("1 " + e.getCursor().toString());
        ItemStack item = e.getCursor();
        if (e.getCursor().getType().equals(Material.WRITTEN_BOOK) | e.getCurrentItem().getType().equals(Material.WRITTEN_BOOK)){
            Bukkit.broadcastMessage("2 " + e.getAction());
            Bukkit.broadcastMessage("22 " + e.getSlot());
            Bukkit.broadcastMessage("222 " + e.getClickedInventory().getType());
            if (e.getAction().equals(InventoryAction.PLACE_ALL)){
                Bukkit.broadcastMessage("3 " + e.getClickedInventory().getType());
                if (e.getClickedInventory().getType().equals(InventoryType.PLAYER)){
                    BookMeta Meta = (BookMeta)e.getCursor().getItemMeta();
                    e.getWhoClicked().sendMessage("BOOK1C");

                    Meta.setTitle("ChangedTitle");
                    Meta.setPage(1, e.getWhoClicked().getName());
                    e.getCursor().setItemMeta(Meta);
                }
                else {
                    BookMeta Meta = (BookMeta)e.getCursor().getItemMeta();
                    e.getWhoClicked().sendMessage("BOOK1D");

                    Meta.setTitle("DefaultTitle");
                    Meta.setPage(1, e.getWhoClicked().getName());
                    e.getCursor().setItemMeta(Meta);
                }
            }
            if (e.getAction().equals(InventoryAction.MOVE_TO_OTHER_INVENTORY)){
                Bukkit.broadcastMessage("3 " + e.getClickedInventory().getType());
                if (e.getClickedInventory().getType().equals(InventoryType.PLAYER)){
                    BookMeta Meta = (BookMeta)e.getCurrentItem().getItemMeta();
                    e.getWhoClicked().sendMessage("BOOK2D");

                    Meta.setTitle("DefaultTitle");
                    Meta.setPage(1, e.getWhoClicked().getName());
                    e.getCurrentItem().setItemMeta(Meta);
                }
                else {
                    BookMeta Meta = (BookMeta)e.getCurrentItem().getItemMeta();
                    e.getWhoClicked().sendMessage("BOOK2C");

                    Meta.setTitle("ChangedTitle");
                    Meta.setPage(1, e.getWhoClicked().getName());
                    e.getCurrentItem().setItemMeta(Meta);

                    e.getCurrentItem().getItemMeta().setLore(Arrays.asList("Owner: " + e.getWhoClicked().getName()));
                }
            }
            //Bukkit.broadcastMessage(e.getWhoClicked().getName());
            //Bukkit.broadcastMessage(e.getAction().toString());
            //Bukkit.broadcastMessage(e.getCurrentItem().toString());
        }
        Bukkit.broadcastMessage(" ");
    }
}
