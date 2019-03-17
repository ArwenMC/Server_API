package io.github.arwen.hologram;

import com.google.common.collect.Lists;
import io.github.arwen.entitybuilder.EntityBuilder;
import io.github.arwen.filebuilder.FileBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;




public class HologramBuilder
{
    private String name;
    private Location loc;
    private ArrayList<String> lines = new ArrayList();
    private HashMap<Location, Entity> entities = new HashMap();

    public HologramBuilder(String name, Location loc) {
        this.name = name;
        this.loc = loc;
    }

    public HologramBuilder(String name, World world, double x, double y, double z) { Location loc = new Location(world, x, y, z);
        this.name = name;
        this.loc = loc;
    }

    public HologramBuilder(String name, String world, double x, double y, double z) { Location loc = new Location(Bukkit.getWorld(world), x, y, z);
        this.name = name;
        this.loc = loc;
    }

    public HologramBuilder setLine(int line, String text) {
        lines.set(line, text);
        return this;
    }

    public HologramBuilder addLines(List<String> lines) { for (String line : lines) {
        this.lines.add(line);
    }
        return this;
    }

    public HologramBuilder addLine(String text) { lines.add(text);
        return this;
    }

    public HologramBuilder removeLine(String line) { lines.remove(line);
        return this;
    }

    public HologramBuilder spawn() { Location loc = this.loc;
        for (String line : Lists.reverse(lines)) {
            ArmorStand entity = (ArmorStand)new EntityBuilder(EntityType.ARMOR_STAND, this.loc).setCustomName(line).setCustomNameVisible(true).spawn();
            entity.setVisible(false);
            entity.setGravity(false);
            entity.setBasePlate(false);
            entities.put(loc, entity);
            loc = loc.add(0.0D, 0.25D, 0.0D);
        }
        return this;
    }

    public void remove(Location loc) { if (entities.containsKey(loc)) {
        ((Entity)entities.get(loc)).remove();
        entities.remove(loc);
    }
    }

    public void saveInFile(String path, String file) { FileBuilder fb = new FileBuilder(path, file);
        fb.set(name + ".World", loc.getWorld().getName());
        fb.set(name + ".X", Double.valueOf(loc.getX()));
        fb.set(name + ".Y", Double.valueOf(loc.getY()));
        fb.set(name + ".Z", Double.valueOf(loc.getZ()));
        fb.set(name + ".Lines", lines);
        fb.save();
    }

    public void removeFromFile(String path, String file) { FileBuilder fb = new FileBuilder(path, file);
        fb.set(name + ".World", null);
        fb.set(name + ".X", null);
        fb.set(name + ".Y", null);
        fb.set(name + ".Z", null);
        fb.set(name + ".Lines", null);
        fb.save();
    }
}