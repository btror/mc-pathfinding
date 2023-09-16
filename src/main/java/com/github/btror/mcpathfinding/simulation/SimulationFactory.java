package com.github.btror.mcpathfinding.simulation;

import com.github.btror.mcpathfinding.simulation.pathfinding.AStar;
import com.github.btror.mcpathfinding.simulation.pathfinding.GreedyBestFirstSearch;

public class SimulationFactory {

    public static Simulation getSimulation(String algorithm) {
        switch (algorithm.toUpperCase()) {
            case "ASTAR":
            case "A-STAR":
            case "A*":
                return new AStar();
            case "GREEDY BEST FIRST SEARCH":
            case "GREEDY-BEST-FIRST-SEARCH":
            case "GREEDY BFS":
            case "GREEDY-BFS":
            case "GBFS":
                return new GreedyBestFirstSearch();
        }

        return null;
    }
}
