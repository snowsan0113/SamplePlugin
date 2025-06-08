package sampleplugin;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import sampleplugin.command.HelloWorld;
import sampleplugin.listener.PlayerClickListener;
import sampleplugin.listener.PlayerMoveListener;

public final class SamplePlugin extends JavaPlugin {

    //プラグインが有効になったときに、処理したいやつ
    @Override
    public void onEnable() {
        //「/helloworld」コマンドがHelloWorldクラスだと定義させるもの
        getCommand("helloworld").setExecutor(new HelloWorld());
        PluginManager plm = getServer().getPluginManager();
        plm.registerEvents(new PlayerClickListener(), this);
        plm.registerEvents(new PlayerMoveListener(), this);

        getLogger().info("プラグインが有効になりました");
    }

    ////プラグインが無効になったときに、処理したいやつ
    @Override
    public void onDisable() {

    }
}
