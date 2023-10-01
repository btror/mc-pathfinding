package com.github.btror.mcpathfinding.simulation.tests;

import com.github.btror.mcpathfinding.simulation.Simulation;
import com.github.btror.mcpathfinding.simulation.pathfinding.AStarSearch;
import com.github.btror.mcpathfinding.simulation.pathfinding.BeamSearch;
import com.github.btror.mcpathfinding.simulation.pathfinding.GreedyBestFirstSearch;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SimulationTest {

    private int[][][] mockSimulationSnapshot;

    @Before
    public void setUp() {
        mockSimulationSnapshot = createSimulationSnapshot();
    }

    @Test
    public void testSearch_astarSearch() {
        Simulation simulation = new AStarSearch();

        mockSimulationSnapshot = createSimulationSnapshot();
        simulation.setSimulationSnapshot(mockSimulationSnapshot);

        int[] simulationStart = {0, 0, 0};
        simulation.setSimulationStrikeStart(simulationStart);

        int[] simulationTarget = {5, 5, 5};
        simulation.setSimulationStrikeTarget(simulationTarget);

        simulation.start();
        simulation.findPath();

        assertEquals(simulation.getNodeSnapshot()[0][0][0].getType(), 4);
        assertEquals(simulation.getNodeSnapshot()[5][5][5].getType(), 5);
        for (int i = 1; i < simulation.getSimulationPath().size() - 1; i++) {
            Integer[] path = simulation.getSimulationPath().get(i);
            assertEquals(simulation.getNodeSnapshot()[path[0]][path[1]][path[2]].getType(), 3);
        }
    }

    @Test
    public void testSearch_beamSearch() {
        Simulation simulation = new BeamSearch();
        simulation.setBeamWidth(5);

        mockSimulationSnapshot = createSimulationSnapshot();
        simulation.setSimulationSnapshot(mockSimulationSnapshot);

        int[] simulationStart = {0, 0, 0};
        simulation.setSimulationStrikeStart(simulationStart);

        int[] simulationTarget = {5, 5, 5};
        simulation.setSimulationStrikeTarget(simulationTarget);

        simulation.start();
        simulation.findPath();

        assertEquals(simulation.getNodeSnapshot()[0][0][0].getType(), 4);
        assertEquals(simulation.getNodeSnapshot()[5][5][5].getType(), 5);
        for (int i = 1; i < simulation.getSimulationPath().size() - 1; i++) {
            Integer[] path = simulation.getSimulationPath().get(i);
            assertEquals(simulation.getNodeSnapshot()[path[0]][path[1]][path[2]].getType(), 3);
        }
    }

    @Test
    public void testSearch_greedyBestFirstSearch() {
        Simulation simulation = new GreedyBestFirstSearch();

        mockSimulationSnapshot = createSimulationSnapshot();
        simulation.setSimulationSnapshot(mockSimulationSnapshot);

        int[] simulationStart = {0, 0, 0};
        simulation.setSimulationStrikeStart(simulationStart);

        int[] simulationTarget = {5, 5, 5};
        simulation.setSimulationStrikeTarget(simulationTarget);

        simulation.start();
        simulation.findPath();

        assertEquals(simulation.getNodeSnapshot()[0][0][0].getType(), 4);
        assertEquals(simulation.getNodeSnapshot()[5][5][5].getType(), 5);
        for (int i = 1; i < simulation.getSimulationPath().size() - 1; i++) {
            Integer[] path = simulation.getSimulationPath().get(i);
            assertEquals(simulation.getNodeSnapshot()[path[0]][path[1]][path[2]].getType(), 3);
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
    public int[][][] createSimulationSnapshot() {
        int[][][] simulationSnapshot = new int[10][10][10];
        for (int i = 0; i < simulationSnapshot.length; i++) {
            for (int j = 0; j < simulationSnapshot[0].length; j++) {
                for (int k = 0; k < simulationSnapshot[0][0].length; k++) {
                    simulationSnapshot[i][j][k] = 0;
                }
            }
        }
        simulationSnapshot[0][1][2] = 1;
        simulationSnapshot[0][2][2] = 1;
        simulationSnapshot[0][3][2] = 1;
        simulationSnapshot[1][3][2] = 1;
        simulationSnapshot[3][3][3] = 1;
        simulationSnapshot[4][3][3] = 1;

        return simulationSnapshot;
    }
}
