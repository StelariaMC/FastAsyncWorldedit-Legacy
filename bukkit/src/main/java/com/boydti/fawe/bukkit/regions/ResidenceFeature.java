package com.boydti.fawe.bukkit.regions;

import com.boydti.fawe.bukkit.FaweBukkit;
import com.boydti.fawe.regions.FaweMaskManager;
import com.sk89q.worldedit.world.World;
import org.bukkit.plugin.Plugin;

public class ResidenceFeature extends FaweMaskManager<World> {
    public ResidenceFeature(Plugin plugin, FaweBukkit faweBukkit) {
        super("residence");
    }
}