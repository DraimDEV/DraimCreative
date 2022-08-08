package net.draimcido.draimcreative.listeners.player;

import net.draimcido.draimcreative.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerInventory implements Listener {

    private final Main main;

    public PlayerInventory(Main main) {
        this.main = main;
    }

    private Main getMain() {
        return this.main;
    }


    /*
     * Этот ивент вызывается, когда игрок в креативе кладёт или
     * берёт предмет в свой инвентарь или хотбар, а так же
     * он удаляет предметы из инвентаря в креативе.
     *
     * e.getAction() является PLACE_ALL по какой-либо причине
     *
     * e.getClick() всегда в CREATIVE
     */
    @EventHandler(ignoreCancelled = true)
    public void onInventoryCreative(InventoryCreativeEvent e) {
        Player p = (Player) e.getWhoClicked();
        Inventory i = e.getClickedInventory();
        ItemStack is = e.getCursor();

    }
}
