package com.boydti.fawe.bukkit.regions;

import com.boydti.fawe.regions.FaweMaskManager;
import com.sk89q.worldedit.world.World;

public class FreeBuildRegion extends FaweMaskManager<World> {
    public FreeBuildRegion() {
        super("freebuild");
    }
}