package sampleplugin.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelloWorld implements CommandExecutor {

    //コマンド実行するときに使うやつ
    @Override
    public boolean onCommand(CommandSender send, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("helloworld")) {
            send.sendMessage("helloworld!");
        }
        return false;
    }

}
