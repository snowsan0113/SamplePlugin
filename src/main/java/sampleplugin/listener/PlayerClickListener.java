package sampleplugin.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class PlayerClickListener implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        Block block = event.getClickedBlock();
        Action action = event.getAction();

        Bukkit.broadcastMessage("プレイヤー: " + player.getName() + "\n" +
                "アイテム: " + (item == null ? "なし" : item.getType()) + "\n" +
                "ブロック: " + (block == null ? "なし" : block.getType()) + "\n" +
                "クリック種類: " + action);
    }

}
