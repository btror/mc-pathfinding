package com.github.btror.mcpathfinding.simulation.tests;

import com.github.btror.mcpathfinding.simulation.Simulation;
import com.github.btror.mcpathfinding.simulation.SimulationFactory;
import com.github.btror.mcpathfinding.simulation.pathfinding.AStarSearch;
import com.github.btror.mcpathfinding.simulation.pathfinding.BeamSearch;
import com.github.btror.mcpathfinding.simulation.pathfinding.GreedyBestFirstSearch;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SimulationFactoryTest {

    @Test
    public void testGetSimulation_astar() {
        Simulation simulation1 = SimulationFactory.getSimulation("a*");
        Simulation simulation2 = SimulationFactory.getSimulation("astar");
        Simulation simulation3 = SimulationFactory.getSimulation("a-star");
        Simulation simulation4 = SimulationFactory.getSimulation("A*");
        Simulation simulation5 = SimulationFactory.getSimulation("AstAr");
        Simulation simulation6 = SimulationFactory.getSimulation("a-STar");

        assertEquals(simulation1.getClass(), AStarSearch.class);
        assertEquals(simulation2.getClass(), AStarSearch.class);
        assertEquals(simulation3.getClass(), AStarSearch.class);
        assertEquals(simulation4.getClass(), AStarSearch.class);
        assertEquals(simulation5.getClass(), AStarSearch.class);
        assertEquals(simulation6.getClass(), AStarSearch.class);
    }

    @Test
    public void testGetSimulation_greedyBestFirstSearch() {
        Simulation simulation1 = SimulationFactory.getSimulation("greedy best first search");
        Simulation simulation2 = SimulationFactory.getSimulation("greedy-best-first-search");
        Simulation simulation3 = SimulationFactory.getSimulation("greedy bfs");
        Simulation simulation4 = SimulationFactory.getSimulation("greedy-bfs");
        Simulation simulation5 = SimulationFactory.getSimulation("gbfs");
        Simulation simulation6 = SimulationFactory.getSimulation("GREEDY best first search");
        Simulation simulation7 = SimulationFactory.getSimulation("GBFS");

        assertEquals(simulation1.getClass(), GreedyBestFirstSearch.class);
        assertEquals(simulation2.getClass(), GreedyBestFirstSearch.class);
        assertEquals(simulation3.getClass(), GreedyBestFirstSearch.class);
        assertEquals(simulation4.getClass(), GreedyBestFirstSearch.class);
        assertEquals(simulation5.getClass(), GreedyBestFirstSearch.class);
        assertEquals(simulation6.getClass(), GreedyBestFirstSearch.class);
        assertEquals(simulation7.getClass(), GreedyBestFirstSearch.class);
    }

    @Test
    public void testGetSimulation_beamSearch() {
        Simulation simulation1 = SimulationFactory.getSimulation("beam");
        Simulation simulation2 = SimulationFactory.getSimulation("beam search");
        Simulation simulation3 = SimulationFactory.getSimulation("beam-search");
        Simulation simulation4 = SimulationFactory.getSimulation("BEAM");
        Simulation simulation5 = SimulationFactory.getSimulation("beAM");
        Simulation simulation6 = SimulationFactory.getSimulation("BEAM-search");

        assertEquals(simulation1.getClass(), BeamSearch.class);
        assertEquals(simulation2.getClass(), BeamSearch.class);
        assertEquals(simulation3.getClass(), BeamSearch.class);
        assertEquals(simulation4.getClass(), BeamSearch.class);
        assertEquals(simulation5.getClass(), BeamSearch.class);
        assertEquals(simulation6.getClass(), BeamSearch.class);
    }
}
