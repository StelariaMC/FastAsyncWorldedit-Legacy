package com.boydti.fawe.bukkit.regions;

import com.boydti.fawe.bukkit.FaweBukkit;
import com.boydti.fawe.regions.FaweMaskManager;
import com.sk89q.worldedit.world.World;
import org.bukkit.plugin.Plugin;

public class GriefPreventionFeature extends FaweMaskManager<World> {
    public GriefPreventionFeature(Plugin plugin, FaweBukkit faweBukkit) {
        super("griefprevention");
    }
}