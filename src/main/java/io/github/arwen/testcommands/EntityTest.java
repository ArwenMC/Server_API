package io.github.arwen.testcommands;

import io.github.arwen.entitybuilder.EntityBuilder;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class EntityTest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            Entity entity = new EntityBuilder(EntityType.POLAR_BEAR, player.getLocation())
                    .setAge(EntityBuilder.EntityAge.BABY)
                    .setCustomName("Polar Bear")
                    .setCustomNameVisible(true)
                    .spawn();

            player.sendMessage(ChatColor.GREEN + "Spawned PolarBear");
        }
            // If the player (or console) uses our command correct, we can return true
            return true;
        }



}
