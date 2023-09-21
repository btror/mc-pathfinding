package com.github.btror.mcpathfinding.simulation.pathfinding;

import com.github.btror.mcpathfinding.simulation.Simulation;
import com.github.btror.mcpathfinding.simulation.util.Node;

public class UniformCostSearch extends Simulation {

    public UniformCostSearch() {
    }

    public UniformCostSearch(int[][][] simulationSnapshot, int[] simulationStart, int[] simulationTarget) {
        super(simulationSnapshot, simulationStart, simulationTarget);
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

        for (int i = 0; i < simulationSnapshot.length; i++) {
            for (int j = 0; j < simulationSnapshot[i].length; j++) {
                for (int k = 0; k < simulationSnapshot[i][j].length; k++) {
                    if (simulationSnapshot[i][j][k] == 0) {
                        Node node = new Node(i, j, k, 0);
                        nodeSnapshot[i][j][k] = node;
                    }
                    if (simulationSnapshot[i][j][k] == 1) {
                        Node node = new Node(i, j, k, 1);
                        nodeSnapshot[i][j][k] = node;
                    }
                }
            }
        }

        int g = calculateG(nodeCurrent);
        nodeCurrent.setG(g);

        nodeStart = nodeCurrent;
        openList.add(nodeCurrent);
    }

    @Override
    protected void calculateNeighborValues() {
        int row = nodeCurrent.getRow();
        int col = nodeCurrent.getCol();
        int zNum = nodeCurrent.getZ();

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
                            int g = calculateG(neighbor);
                            if (g < neighbor.getG()) {
                                neighbor.setParent(nodeCurrent);
                                neighbor.setG(g);
                                openList.add(neighbor);
                                simulationSnapshot[newRow][newCol][newZ] = 2;
                            }
                        }
                    }
                }
            }
        }
    }
}
