package io.github.arwen;

import io.github.arwen.testcommands.EntityTest;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Server_API extends JavaPlugin {

    private static Server_API instance;

    public Server_API() {
        Server_API.instance = this;
    }

    @Override
    public void onEnable () {

      /*  if (Bukkit.getPluginManager().getPlugin("ProtocolLib") == null) {
            this.getLogger().severe("Please make sure that you have ProtocolLib installed!");
            this.getServer().shutdown();
            return;
        }  */

        this.getCommand("animaltest").setExecutor(new EntityTest());

    }

    @Override
    public void onDisable() {

    }


}
