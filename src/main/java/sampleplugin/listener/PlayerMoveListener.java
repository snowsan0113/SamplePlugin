package sampleplugin.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.PlayerInventory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        PlayerInventory inv = player.getInventory();
        if (inv.getItemInMainHand().getType() == Material.STONE) {
            fill(event);
        }
    }

    public void fill(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location loc = player.getLocation();
        World world = player.getWorld();
        Location start = new Location(world, 553, 20, 528); //範囲の開始
        Location end = new Location(world, 540, 80, 516); //範囲の終了

        //xとzを-2ブロック～+2ブロックずつループ
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                Location arena_loc = new Location(world,
                        loc.getBlockX() + x,
                        loc.getBlockY() - 1,
                        loc.getBlockZ() + z);

                if (arena_loc.getBlock().getType() == Material.GRASS) { //塗ろうとしてるところが「草ブロック」かを判定
                    if (containArena(start, end, arena_loc)) { //塗ろうとしてるところが範囲内かを判定
                        arena_loc.getBlock().setType(Material.WOOL); //羊毛にする
                    }
                }
            }
        }
    }

    //範囲内にいるかどうかを見る（※数直線で例えると分かりやすい）
    public boolean containArena(Location start, Location end, Location check_loc) {
        int min_x = Math.min(start.getBlockX(), end.getBlockX());
        int max_x = Math.max(start.getBlockX(), end.getBlockX());

        int min_y = Math.min(start.getBlockY(), end.getBlockY());
        int max_y = Math.max(start.getBlockY(), end.getBlockY());

        int min_z = Math.min(start.getBlockZ(), end.getBlockZ());
        int max_z = Math.max(start.getBlockZ(), end.getBlockZ());

        int x = check_loc.getBlockX();
        int y = check_loc.getBlockY();
        int z = check_loc.getBlockZ();
        return x >= min_x && x <= max_x &&  //xが、最小X以上＆最大X以下
                y >= min_y && y <= max_y && //yが、最小Y以上＆最大Y以下
                z >= min_z && z <= max_z; //zが、最小Z以上＆最大Z以下
    }
}
