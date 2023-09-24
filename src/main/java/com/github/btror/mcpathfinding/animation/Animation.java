package com.github.btror.mcpathfinding.animation;

import com.github.btror.mcpathfinding.simulation.Simulation;
import com.github.btror.mcpathfinding.simulation.SimulationFactory;
import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class Animation {
    private final JavaPlugin plugin;
    private final Location[][][] snapshot;
    private final Location snapshotStart;
    private final Location snapshotTarget;
    private final Material material;
    private final Particle particle;
    private final boolean tightParticleSpawning;
    private final ArrayList<Location> snapshotPath;
    private final ArrayList<Location> snapshotParticlePath;
    private final Simulation simulation;
    private final long delay;
    private final long period;

    /**
     * @param plugin                plugin instance
     * @param snapshot              worldly area
     * @param snapshotStart         pathfinding start location
     * @param snapshotTarget        pathfinding target location
     * @param material              pathfinding path block type
     * @param particle              pathfinding particle effect
     * @param tightParticleSpawning spawn particles tightly together
     * @param algorithm             pathfinding algorithm to use
     * @param diagonalMovement      pathfinding algorithm using diagonal movement in
     *                              calculations
     * @param delay                 animation delay (TaskTimer delay param)
     * @param period                animation speed (TaskTimer period param)
     * @param beamWidth             beam search algorithm beam width (smaller values
     *                              (1-5) are for more focused searches with lower
     *                              diversity, while larger values (50+ are less
     *                              focused and use more computing power but have
     *                              greater diversity))
     */
    public Animation(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location snapshotStart,
            Location snapshotTarget,
            Material material,
            Particle particle,
            boolean tightParticleSpawning,
            String algorithm,
            boolean diagonalMovement,
            long delay,
            long period,
            int beamWidth) {
        this.plugin = plugin;
        this.snapshot = snapshot;
        this.snapshotStart = snapshotStart;
        this.snapshotTarget = snapshotTarget;
        this.material = material;
        this.particle = particle;
        this.tightParticleSpawning = tightParticleSpawning;
        this.snapshotPath = new ArrayList<>();
        this.snapshotParticlePath = new ArrayList<>();
        this.simulation = SimulationFactory.getSimulation(algorithm);
        assert this.simulation != null;
        this.simulation.setDiagonalMovement(diagonalMovement);
        this.delay = delay;
        this.period = period;
        this.simulation.setBeamWidth(beamWidth);
    }

    public void start() {
        createSimulation();
        if (simulation.getSimulationSnapshot() != null) {
            createPath();
            animate();
        }
    }

    private void createPath() {
        if (simulation.getSimulationPath().size() > 0) {
            if (material != null) {
                for (Integer[] space : simulation.getSimulationPath()) {
                    snapshotPath.add(snapshot[space[0]][space[1]][space[2]]);
                }
            } else {
                snapshotParticlePath.add(
                        snapshot[simulation.getSimulationPath().get(0)[0]][simulation.getSimulationPath()
                                .get(0)[1]][simulation.getSimulationPath().get(0)[2]]);

                for (int i = 1; i < simulation.getSimulationPath().size(); i++) {
                    Integer[] currentSpace = simulation.getSimulationPath().get(i);
                    Integer[] previousSpace = simulation.getSimulationPath().get(i - 1);

                    Location currentLocation = snapshot[currentSpace[0]][currentSpace[1]][currentSpace[2]];

                    if (tightParticleSpawning) {
                        Location previousLocation = snapshot[previousSpace[0]][previousSpace[1]][previousSpace[2]];
                        Location delta = new Location(
                                currentLocation.getWorld(),
                                (previousLocation.getX() + currentLocation.getX()) / 2.0,
                                (previousLocation.getY() + currentLocation.getY()) / 2.0,
                                (previousLocation.getZ() + currentLocation.getZ()) / 2.0);
                        snapshotParticlePath.add(delta);
                    }
                    snapshotParticlePath.add(currentLocation);
                }
            }
        }
    }

    private void animate() {
        if (period == 0) {
            if (material != null) {
                for (Location location : snapshotPath) {
                    location.getBlock().setType(material);
                }
            }
            if (particle != null) {
                for (Location location : snapshotParticlePath) {
                    World world = location.getWorld();
                    assert world != null;
                    world.spawnParticle(
                            particle,
                            location.getX(),
                            location.getY(),
                            location.getZ(),
                            1,
                            0,
                            0,
                            0,
                            0,
                            null,
                            true);
                }
            }
        } else {
            new Path().runTaskTimer(plugin, delay, period);
        }
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
        int[][][] simulationSnapshot = new int[snapshot.length][snapshot[0].length][snapshot[0][0].length];
        int[] simulationStart = new int[3];
        int[] simulationTarget = new int[3];

        for (int i = 0; i < snapshot.length; i++) {
            for (int j = 0; j < snapshot[i].length; j++) {
                for (int k = 0; k < snapshot[i][j].length; k++) {
                    if (snapshot[i][j][k].getBlock().getType() == Material.AIR) {
                        simulationSnapshot[i][j][k] = 0;
                    } else {
                        simulationSnapshot[i][j][k] = 1;
                    }

                    if (snapshot[i][j][k] == snapshotStart) {
                        simulationSnapshot[i][j][k] = 4;
                        simulationStart[0] = i;
                        simulationStart[1] = j;
                        simulationStart[2] = k;
                    }

                    if (snapshot[i][j][k] == snapshotTarget) {
                        simulationSnapshot[i][j][k] = 5;
                        simulationTarget[0] = i;
                        simulationTarget[1] = j;
                        simulationTarget[2] = k;
                    }
                }
            }
        }

        simulation.setSimulationSnapshot(simulationSnapshot);
        simulation.setSimulationStrikeStart(simulationStart);
        simulation.setSimulationStrikeTarget(simulationTarget);
        simulation.start();
        simulation.findPath();
    }

    private class Path extends BukkitRunnable {
        int counter = 0;

        @Override
        public void run() {
            if (material != null) {
                snapshotPath.get(counter).getBlock().setType(material);
            }
            if (particle != null) {
                World world = snapshotPath.get(counter).getWorld();
                assert world != null;
                world.spawnParticle(
                        particle,
                        snapshotPath.get(counter).getX(),
                        snapshotPath.get(counter).getY(),
                        snapshotPath.get(counter).getZ(),
                        1,
                        0,
                        0,
                        0,
                        0,
                        null,
                        true);
            }

            if (counter == snapshotPath.size() - 1) {
                this.cancel();
            }

            counter++;
        }
    }
}
