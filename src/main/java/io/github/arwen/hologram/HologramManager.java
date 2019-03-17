package io.github.arwen.hologram;

import io.github.arwen.filebuilder.FileBuilder;

public class HologramManager
{
    public HologramManager() {}

    public void loadHologramsFromFile(String path, String file) {
        FileBuilder fb = new FileBuilder(path, file);
        for (String name : fb.getKeys(false)) {
            HologramBuilder hb = new HologramBuilder(name, fb.getString(name + ".World"), fb.getDouble(name + ".X"), fb.getDouble(name + ".Y"), fb.getDouble(name + ".Z"));
            for (String line : fb.getStringList(name + ".Lines")) {
                hb.addLine(line);
            }
            hb.spawn();
        }
    }
}
