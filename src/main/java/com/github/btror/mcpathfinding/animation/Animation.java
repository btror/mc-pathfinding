package com.github.btror.mcpathfinding.animation;

import com.github.btror.mcpathfinding.McPathfinding;
import com.github.btror.mcpathfinding.simulation.Simulation;
import com.github.btror.mcpathfinding.simulation.util.SimulationFactory;
import org.bukkit.*;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class Animation {
    private final McPathfinding plugin;
    private final Location[][][] snapshot;
    private final Location snapshotStart;
    private final Location snapshotTarget;
    private final ArrayList<Location> snapshotPath;
    private final Simulation simulation;
    private final long delay;
    private final long period;

    /**
     * @param plugin         plugin instance
     * @param snapshot       worldly area
     * @param snapshotStart  pathfinding start location
     * @param snapshotTarget pathfinding target location
     * @param algorithm      pathfinding algorithm to use
     * @param delay          animation delay (TaskTimer delay param)
     * @param period         animation speed (TaskTimer period param)
     */
    public Animation(
            McPathfinding plugin,
            Location[][][] snapshot,
            Location snapshotStart,
            Location snapshotTarget,
            String algorithm,
            boolean diagonalMovement,
            long delay,
            long period
    ) {
        this.plugin = plugin;
        this.snapshot = snapshot;
        this.snapshotStart = snapshotStart;
        this.snapshotTarget = snapshotTarget;
        this.snapshotPath = new ArrayList<>();
        this.simulation = SimulationFactory.getSimulation(algorithm);
        assert this.simulation != null;
        this.simulation.setDiagonalMovement(diagonalMovement);
        this.delay = delay;
        this.period = period;
    }

    public void start() {
        createSimulation();
        if (simulation.getSimulationSnapshot() != null) {
            createPath();
            animate();
        }
    }

    private void createPath() {
        int[][][] simulationStormZone = simulation.getSimulationSnapshot();
        for (int i = 0; i < simulationStormZone.length; i++) {
            for (int j = 0; j < simulationStormZone[0].length; j++) {
                for (int k = 0; k < simulationStormZone[0][0].length; k++) {
                    if (simulationStormZone[i][j][k] == 3) {
                        snapshotPath.add(snapshot[i][j][k].getBlock().getLocation());
                    }
                }
            }
        }
    }

    private void animate() {
        new Path().runTaskTimer(plugin, delay, period);
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
    private void createSimulation() {
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

                    if (snapshot[i][j][k] == snapshotStart) {
                        simulationStormZone[i][j][k] = 4;
                        simulationStart[0] = i;
                        simulationStart[1] = j;
                        simulationStart[2] = k;
                    }

                    if (snapshot[i][j][k] == snapshotTarget) {
                        simulationStormZone[i][j][k] = 5;
                        simulationTarget[0] = i;
                        simulationTarget[1] = j;
                        simulationTarget[2] = k;
                    }
                }
            }
        }

        simulation.setSimulationSnapshot(simulationStormZone);
        simulation.setSimulationStrikeStart(simulationStart);
        simulation.setSimulationStrikeTarget(simulationTarget);
        simulation.start();
        simulation.findPath();
    }

    private class Path extends BukkitRunnable {

        @Override
        public void run() {
            for (Location location : snapshotPath) {
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
