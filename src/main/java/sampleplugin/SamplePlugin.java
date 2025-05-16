package sampleplugin;

import org.bukkit.plugin.java.JavaPlugin;
import sampleplugin.command.HelloWorld;

public final class SamplePlugin extends JavaPlugin {

    //プラグインが有効になったときに、処理したいやつ
    @Override
    public void onEnable() {
        getCommand("helloworld").setExecutor(new HelloWorld());

        getLogger().info("プラグインが有効になりました");
    }

    ////プラグインが無効になったときに、処理したいやつ
    @Override
    public void onDisable() {

    }
}
