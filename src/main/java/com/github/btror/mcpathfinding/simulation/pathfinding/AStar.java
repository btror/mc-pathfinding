package com.github.btror.mcpathfinding.simulation.pathfinding;

import com.github.btror.mcpathfinding.simulation.Simulation;
import com.github.btror.mcpathfinding.simulation.util.Node;

public class AStar extends Simulation {

    public AStar(int[][][] stormZone, int[] simulationStrikeStart, int[] simulationStrikeTarget) {
        super(stormZone, simulationStrikeStart, simulationStrikeTarget);
    }

    @Override
    public void start() {
        simulationNodeStrikeCurrent = new Node(
                simulationStrikeStart[0],
                simulationStrikeStart[1],
                simulationStrikeStart[2],
                0
        );
        simulationNodeStrikeTarget = new Node(
                simulationStrikeTarget[0],
                simulationStrikeTarget[1],
                simulationStrikeTarget[2],
                0
        );
        simulationStormZone[simulationStrikeStart[0]][simulationStrikeStart[1]][simulationStrikeStart[2]] = simulationNodeStrikeCurrent;
        simulationStormZone[simulationStrikeTarget[0]][simulationStrikeTarget[1]][simulationStrikeTarget[2]] = simulationNodeStrikeTarget;

        for (int i = 0; i < stormZone.length; i++) {
            for (int j = 0; j < stormZone[i].length; j++) {
                for (int k = 0; k < stormZone[i][j].length; k++) {
                    if (stormZone[i][j][k] == 0) {
                        Node node = new Node(i, j, k, 0);
                        simulationStormZone[i][j][k] = node;
                    }
                    if (stormZone[i][j][k] == 1) {
                        Node node = new Node(i, j, k, 1);
                        simulationStormZone[i][j][k] = node;
                    }
                }
            }
        }

        int g = calculateG(simulationNodeStrikeCurrent);
        simulationNodeStrikeCurrent.setG(g);

        int h = calculateH(simulationNodeStrikeCurrent);
        simulationNodeStrikeCurrent.setH(h);

        simulationNodeStrikeCurrent.setF();
        simulationNodeStrikeStart = simulationNodeStrikeCurrent;
        openList.add(simulationNodeStrikeCurrent);
    }

    @Override
    public void calculateNeighborValues() {
        int row = simulationNodeStrikeCurrent.getRow();
        int col = simulationNodeStrikeCurrent.getCol();
        int zNum = simulationNodeStrikeCurrent.getZ();

        if (zNum - 1 > -1 && simulationStormZone[row][col][zNum - 1].getType() == 0
                && !closedList.contains(simulationStormZone[row][col][zNum - 1])) {
            Node[][][] grid = simulationStormZone;
            grid[row][col][zNum - 1].setParent(simulationNodeStrikeCurrent);
            int g = calculateG(grid[row][col][zNum - 1]);
            grid[row][col][zNum - 1].setG(g);
            int h = calculateH(grid[row][col][zNum - 1]);
            grid[row][col][zNum - 1].setH(h);
            grid[row][col][zNum - 1].setF();
            simulationStormZone = grid;
            openList.add(grid[row][col][zNum - 1]);
            stormZone[row][col][zNum - 1] = 2;
        }

        if (col + 1 < simulationStormZone.length && simulationStormZone[row][col + 1][zNum].getType() == 0
                && !closedList.contains(simulationStormZone[row][col + 1][zNum])) {
            Node[][][] grid = simulationStormZone;
            grid[row][col + 1][zNum].setParent(simulationNodeStrikeCurrent);
            int g = calculateG(grid[row][col + 1][zNum]);
            grid[row][col + 1][zNum].setG(g);
            int h = calculateH(grid[row][col + 1][zNum]);
            grid[row][col + 1][zNum].setH(h);
            grid[row][col + 1][zNum].setF();
            simulationStormZone = grid;
            openList.add(grid[row][col + 1][zNum]);
            stormZone[row][col + 1][zNum] = 2;
        }

        if (row - 1 > -1 && simulationStormZone[row - 1][col][zNum].getType() == 0
                && !closedList.contains(simulationStormZone[row - 1][col][zNum])) {
            Node[][][] grid = simulationStormZone;
            grid[row - 1][col][zNum].setParent(simulationNodeStrikeCurrent);
            int g = calculateG(grid[row - 1][col][zNum]);
            grid[row - 1][col][zNum].setG(g);
            int h = calculateH(grid[row - 1][col][zNum]);
            grid[row - 1][col][zNum].setH(h);
            grid[row - 1][col][zNum].setF();
            simulationStormZone = grid;
            openList.add(grid[row - 1][col][zNum]);
            stormZone[row - 1][col][zNum] = 2;
        }

        if (col - 1 > -1 && simulationStormZone[row][col - 1][zNum].getType() == 0
                && !closedList.contains(simulationStormZone[row][col - 1][zNum])) {
            Node[][][] grid = simulationStormZone;
            grid[row][col - 1][zNum].setParent(simulationNodeStrikeCurrent);
            int g = calculateG(grid[row][col - 1][zNum]);
            grid[row][col - 1][zNum].setG(g);
            int h = calculateH(grid[row][col - 1][zNum]);
            grid[row][col - 1][zNum].setH(h);
            grid[row][col - 1][zNum].setF();
            simulationStormZone = grid;
            openList.add(grid[row][col - 1][zNum]);
            stormZone[row][col - 1][zNum] = 2;
        }

        if (row + 1 < simulationStormZone.length && simulationStormZone[row + 1][col][zNum].getType() == 0
                && !closedList.contains(simulationStormZone[row + 1][col][zNum])) {
            Node[][][] grid = simulationStormZone;
            grid[row + 1][col][zNum].setParent(simulationNodeStrikeCurrent);
            int g = calculateG(grid[row + 1][col][zNum]);
            grid[row + 1][col][zNum].setG(g);
            int h = calculateH(grid[row + 1][col][zNum]);
            grid[row + 1][col][zNum].setH(h);
            grid[row + 1][col][zNum].setF();
            simulationStormZone = grid;
            openList.add(grid[row + 1][col][zNum]);
            stormZone[row + 1][col][zNum] = 2;
        }

        if (zNum + 1 < simulationStormZone.length && simulationStormZone[row][col][zNum + 1].getType() == 0
                && !closedList.contains(simulationStormZone[row][col][zNum + 1])) {
            Node[][][] grid = simulationStormZone;
            grid[row][col][zNum + 1].setParent(simulationNodeStrikeCurrent);
            int g = calculateG(grid[row][col][zNum + 1]);
            grid[row][col][zNum + 1].setG(g);
            int h = calculateH(grid[row][col][zNum + 1]);
            grid[row][col][zNum + 1].setH(h);
            grid[row][col][zNum + 1].setF();
            simulationStormZone = grid;
            openList.add(grid[row][col][zNum + 1]);
            stormZone[row][col][zNum + 1] = 2;
        }
    }
}
