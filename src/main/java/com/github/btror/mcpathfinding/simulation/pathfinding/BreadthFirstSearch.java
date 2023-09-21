package com.github.btror.mcpathfinding.simulation.pathfinding;

import com.github.btror.mcpathfinding.simulation.Simulation;
import com.github.btror.mcpathfinding.simulation.util.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends Simulation {

    private final Queue<Node> queue;

    public BreadthFirstSearch() {
        queue = new LinkedList<>();
    }

    public BreadthFirstSearch(int[][][] simulationSnapshot, int[] simulationStart, int[] simulationTarget) {
        super(simulationSnapshot, simulationStart, simulationTarget);
        queue = new LinkedList<>();
    }

    @Override
    public void start() {
        nodeCurrent = new Node(
                simulationStart[0],
                simulationStart[1],
                simulationStart[2],
                0);
        nodeTarget = new Node(
                simulationTarget[0],
                simulationTarget[1],
                simulationTarget[2],
                0);
        nodeSnapshot[simulationStart[0]][simulationStart[1]][simulationStart[2]] = nodeCurrent;
        nodeSnapshot[simulationTarget[0]][simulationTarget[1]][simulationTarget[2]] = nodeTarget;

        queue.offer(nodeCurrent);
    }

    @Override
    public void calculateNeighborValues() {
        if (queue.isEmpty()) {
            // If the queue is empty, the search is complete
            return;
        }

        Node currentNode = queue.poll();
        int row = currentNode.getRow();
        int col = currentNode.getCol();
        int zNum = currentNode.getZ();

        // Explore all neighbors (including diagonals if allowed)
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                for (int z = -1; z <= 1; z++) {
                    if (r == 0 && c == 0 && z == 0) continue; // Skip the current node

                    int newRow = row + r;
                    int newCol = col + c;
                    int newZ = zNum + z;

                    // Check if the neighbor is within bounds
                    if (isValid(newRow, newCol, newZ)) {
                        Node neighbor = nodeSnapshot[newRow][newCol][newZ];
                        if (neighbor.getType() == 0 && !closedList.contains(neighbor)) {
                            neighbor.setParent(currentNode);
                            queue.offer(neighbor);
                            simulationSnapshot[newRow][newCol][newZ] = 2;
                        }
                    }
                }
            }
        }
    }
}
