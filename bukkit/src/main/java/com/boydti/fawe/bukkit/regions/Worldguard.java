package com.boydti.fawe.bukkit.regions;

import com.boydti.fawe.bukkit.FaweBukkit;
import com.boydti.fawe.regions.FaweMask;
import com.boydti.fawe.regions.FaweMaskManager;
import com.sk89q.worldedit.world.World;
import org.bukkit.plugin.Plugin;

public class Worldguard extends FaweMaskManager<World> {
    public Worldguard(Plugin plugin, FaweBukkit faweBukkit) {
        super("worldguard");
    }
}