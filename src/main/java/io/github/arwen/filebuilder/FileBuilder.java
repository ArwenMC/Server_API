package io.github.arwen.filebuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;

public class FileBuilder
{
    private File file;
    private FileConfiguration cfg;

    public FileBuilder(String path, String file)
    {
        this.file = new File(path, file);
        cfg = org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(this.file);
    }

    public FileBuilder addDefault(String path, Object value) {
        cfg.addDefault(path, value);
        return this;
    }

    public FileBuilder copyDefaults(boolean copyDefaults) { cfg.options().copyDefaults(copyDefaults);
        return this;
    }

    public FileBuilder set(String path, Object value) { cfg.set(path, value);
        return this;
    }

    public FileBuilder save() {
        try { cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }


    public File getFile() { return file; }

    public void reload() {
        try {
            cfg.load(file);
        } catch (IOException|InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public boolean exists() { return file.exists(); }

    public boolean contains(String value) {
        return cfg.contains(value);
    }

    public Object getObject(String path) { return cfg.get(path); }

    public String getString(String path) {
        return cfg.getString(path);
    }

    public int getInt(String path) { return cfg.getInt(path); }

    public double getDouble(String path) {
        return cfg.getDouble(path);
    }

    public long getLong(String path) { return cfg.getLong(path); }

    public boolean getBoolean(String path) {
        return cfg.getBoolean(path);
    }

    public List<String> getStringList(String path) { return cfg.getStringList(path); }

    public List<Boolean> getBooleanList(String path) {
        return cfg.getBooleanList(path);
    }

    public List<Double> getDoubleList(String path) { return cfg.getDoubleList(path); }

    public List<Integer> getIntegerList(String path) {
        return cfg.getIntegerList(path);
    }

    public Set<String> getKeys(boolean keys) { return cfg.getKeys(keys); }

    public ConfigurationSection getConfigurationSection(String section) {
        return cfg.getConfigurationSection(section);
    }

    public void delete() { file.delete(); }
}