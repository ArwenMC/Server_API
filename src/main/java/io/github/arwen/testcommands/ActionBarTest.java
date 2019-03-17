package io.github.arwen.testcommands;

import io.github.arwen.actionbar.ActionBar;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ActionBarTest implements CommandExecutor {

    public String actionbar = ChatColor.RED  + "Testing";

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

                ActionBar.send(player, actionbar);

        }
        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}
