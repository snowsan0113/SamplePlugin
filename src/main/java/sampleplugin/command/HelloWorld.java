package sampleplugin.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelloWorld implements CommandExecutor {

    //コマンド実行するときに使うやつ
    @Override
    public boolean onCommand(CommandSender send, Command cmd, String s, String[] args) {
        //実行されたコマンドが、「/helloworld」かを判定する
        if (cmd.getName().equalsIgnoreCase("helloworld")) {
            //CommandSenderという型にある、メッセージを送る処理
            send.sendMessage("helloworld!");
        }
        return false;
    }

}
