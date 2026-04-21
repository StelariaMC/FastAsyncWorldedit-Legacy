package com.boydti.fawe.bukkit.regions;

import com.boydti.fawe.bukkit.FaweBukkit;
import com.boydti.fawe.regions.FaweMaskManager;
import com.sk89q.worldedit.world.World;
import org.bukkit.plugin.Plugin;

public class ASkyBlockHook extends FaweMaskManager<World> {
    public ASkyBlockHook(Plugin plugin, FaweBukkit faweBukkit) {
        super("askyblock");
    }
}