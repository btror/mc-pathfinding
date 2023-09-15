package com.github.btror.mcpathfinding.animation;

import com.github.btror.mcpathfinding.McPathfinding;
import com.github.btror.mcpathfinding.simulation.Simulation;
import com.github.btror.mcpathfinding.simulation.pathfinding.AStar;
import org.bukkit.*;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class Animation {
    private final McPathfinding plugin;
    private final Location[][][] snapshot;
    private final ArrayList<Location> path;
    private final Location start;
    private final Location target;
    private int[][][] simulation;

    /**
     * @param plugin   plugin instance
     * @param snapshot worldly area
     * @param start    pathfinding start location
     * @param target   pathfinding target location
     */
    public Animation(
            McPathfinding plugin,
            Location[][][] snapshot,
            Location start,
            Location target
    ) {
        this.plugin = plugin;
        this.snapshot = snapshot;
        this.path = new ArrayList<>();
        this.start = start;
        this.target = target;
    }

    public void start() {
        simulation = createSimulation();
        if (simulation != null) {
            createPath();
            animate();
        }
    }

    private void createPath() {
        for (int i = 0; i < simulation.length; i++) {
            for (int j = 0; j < simulation[0].length; j++) {
                for (int k = 0; k < simulation[0][0].length; k++) {
                    if (simulation[i][j][k] == 3) {
                        path.add(snapshot[i][j][k].getBlock().getLocation());
                    }
                }
            }
        }
    }

    private void animate() {
        new Path().runTaskTimer(plugin, 0, 1);
    }

    /**
     * Simulation Integer Mappings:
     * 0 = open space (can be explored in pathfinding)
     * 1 = blocked space (cannot be explored in pathfinding)
     * 2 = visited space (already explored in pathfinding)
     * 3 = final path space (space in the final path)
     * 4 = start space
     * 5 = target space
     */
    private int[][][] createSimulation() {
        int[][][] simulationStormZone = new int[snapshot.length][snapshot[0].length][snapshot[0][0].length];
        int[] simulationStart = new int[3];
        int[] simulationTarget = new int[3];

        for (int i = 0; i < snapshot.length; i++) {
            for (int j = 0; j < snapshot[i].length; j++) {
                for (int k = 0; k < snapshot[i][j].length; k++) {
                    if (snapshot[i][j][k].getBlock().getType() == Material.AIR) {
                        simulationStormZone[i][j][k] = 0;
                    } else {
                        simulationStormZone[i][j][k] = 1;
                    }

                    if (snapshot[i][j][k] == start) {
                        simulationStormZone[i][j][k] = 4;
                        simulationStart[0] = i;
                        simulationStart[1] = j;
                        simulationStart[2] = k;
                    }

                    if (snapshot[i][j][k] == target) {
                        simulationStormZone[i][j][k] = 5;
                        simulationTarget[0] = i;
                        simulationTarget[1] = j;
                        simulationTarget[2] = k;
                    }
                }
            }
        }

        // TODO: add user defined instantiation factory class maybe
        Simulation simulation = new AStar(simulationStormZone, simulationStart, simulationTarget);
        simulation.start();

        if (simulation.getPath()) {
            return simulation.getSimulationStormZone();
        }

        return null;
    }

    private class Path extends BukkitRunnable {

        @Override
        public void run() {
            for (Location location : path) {
                World world = location.getWorld();
                assert world != null;
                world.spawnParticle(
                        Particle.FIREWORKS_SPARK,
                        location.getX(),
                        location.getY(),
                        location.getZ(),
                        1,
                        0,
                        0,
                        0,
                        0,
                        null,
                        true
                );
            }
            this.cancel();
        }
    }
}
