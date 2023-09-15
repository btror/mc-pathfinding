package com.github.btror.mcpathfinding.simulation;

import com.github.btror.mcpathfinding.simulation.util.Node;
import com.github.btror.mcpathfinding.simulation.util.NodeComparator;

import java.util.ArrayList;
import java.util.PriorityQueue;

public abstract class Simulation {
    protected final int[][][] stormZone;
    protected final int[] simulationStrikeStart;
    protected final int[] simulationStrikeTarget;

    protected Node[][][] simulationStormZone;
    protected Node simulationNodeStrikeStart;
    protected Node simulationNodeStrikeTarget;
    protected Node simulationNodeStrikeCurrent;

    protected final PriorityQueue<Node> openList;
    protected final ArrayList<Node> closedList;

    /**
     * Constructor.
     * <p>
     * Creates a storm simulation.
     * <p>
     * Simulation Integer Mappings:
     * 0 = open space (can be explored in pathfinding)
     * 1 = blocked space (cannot be explored in pathfinding)
     * 2 = visited space (already explored in pathfinding)
     * 3 = final path space (space in the final path)
     * 4 = start space
     * 5 = target space
     */
    public Simulation(
            int[][][] stormZone,
            int[] simulationStrikeStart,
            int[] simulationStrikeTarget
    ) {
        this.stormZone = stormZone;
        this.simulationStrikeStart = simulationStrikeStart;
        this.simulationStrikeTarget = simulationStrikeTarget;
        this.simulationStormZone = new Node[this.stormZone.length][this.stormZone[0].length][this.stormZone[0][0].length];
        this.openList = new PriorityQueue<>(10, new NodeComparator());
        this.closedList = new ArrayList<>();
    }

    /**
     * Kick off storm simulation pathfinding.
     */
    public abstract void start();

    /**
     * Creates the final pathfinding path (supposed to emulate the storm bolt).
     *
     * @return final path found.
     */
    public boolean getPath() {
        boolean pathFound = true;
        while (!openList.isEmpty() && !simulationNodeStrikeCurrent.equals(simulationNodeStrikeTarget)) {
            simulationNodeStrikeCurrent = openList.peek();
            openList.remove(openList.peek());

            if (simulationNodeStrikeCurrent.equals(simulationNodeStrikeTarget)) {
                closedList.add(simulationNodeStrikeCurrent);

                ArrayList<Node> path = generatePath();

                for (int i = path.size() - 1; i > -1; i--) {
                    int row = path.get(i).getRow();
                    int col = path.get(i).getCol();
                    int zNum = path.get(i).getZ();
                    if (stormZone[row][col][zNum] == 2) {
                        stormZone[row][col][zNum] = 3;
                    }
                }
                break;
            } else {
                try {
                    calculateNeighborValues();
                } catch (NullPointerException e) {
                    System.out.println(e.getMessage());
                }
                stormZone[simulationNodeStrikeStart.getRow()][simulationNodeStrikeStart.getCol()][simulationNodeStrikeStart.getZ()] = 4;
                stormZone[simulationNodeStrikeTarget.getRow()][simulationNodeStrikeTarget.getCol()][simulationNodeStrikeTarget.getZ()] = 5;
                try {
                    assert openList.peek() != null;
                } catch (NullPointerException e) {
                    pathFound = false;
                }
                closedList.add(simulationNodeStrikeCurrent);
            }
        }

        if (openList.size() == 0) {
            pathFound = false;
        }

        return pathFound;
    }

    /**
     * Calculate node movement cost.
     *
     * @param node simulation node.
     * @return movement cost.
     */
    protected int calculateG(Node node) {
        int row = node.getRow();
        int col = node.getCol();
        int zNum = node.getZ();
        if (row == simulationNodeStrikeCurrent.getRow() && col == simulationNodeStrikeCurrent.getCol() && zNum == simulationNodeStrikeCurrent.getZ()) {
            return 0;
        }

        Node parent = node.getParent();
        if (parent == null) {
            int xDistance;
            if (col > simulationNodeStrikeCurrent.getCol()) {
                xDistance = col - simulationNodeStrikeCurrent.getCol();
            } else {
                xDistance = simulationNodeStrikeCurrent.getCol() - col;
            }

            int yDistance;
            if (row > simulationNodeStrikeCurrent.getRow()) {
                yDistance = row - simulationNodeStrikeCurrent.getRow();
            } else {
                yDistance = simulationNodeStrikeCurrent.getRow() - row;
            }

            int zDistance;
            if (zNum > simulationNodeStrikeCurrent.getZ()) {
                zDistance = zNum - simulationNodeStrikeCurrent.getZ();
            } else {
                zDistance = simulationNodeStrikeCurrent.getZ() - zNum;
            }

            return (xDistance * 10) + (yDistance * 10) + (zDistance * 10);
        }

        return 10 + parent.getG();
    }

    /**
     * Calculate node heuristic value.
     *
     * @param node simulation node.
     * @return heuristic value.
     */
    protected int calculateH(Node node) {
        int row = node.getRow();
        int col = node.getCol();
        int zNum = node.getZ();
        int x = 0;
        int y = 0;
        int z = 0;

        while (col < simulationNodeStrikeTarget.getCol() || col > simulationNodeStrikeTarget.getCol()) {
            x += 10;
            if (col < simulationNodeStrikeTarget.getCol()) {
                col++;
            }
            if (col > simulationNodeStrikeTarget.getCol()) {
                col--;
            }
        }

        while (row < simulationNodeStrikeTarget.getRow() || row > simulationNodeStrikeTarget.getRow()) {
            y += 10;
            if (row < simulationNodeStrikeTarget.getRow()) {
                row++;
            }
            if (row > simulationNodeStrikeTarget.getRow()) {
                row--;
            }
        }

        while (zNum < simulationNodeStrikeTarget.getZ() || zNum > simulationNodeStrikeTarget.getZ()) {
            z += 10;
            if (zNum < simulationNodeStrikeTarget.getZ()) {
                zNum++;
            }
            if (zNum > simulationNodeStrikeTarget.getZ()) {
                zNum--;
            }
        }

        return x + y + z;
    }

    /**
     * Calculate neighboring node values.
     */
    protected abstract void calculateNeighborValues();

    /**
     * Generate final pathfinding path.
     *
     * @return final path.
     */
    private ArrayList<Node> generatePath() {
        ArrayList<Node> path = new ArrayList<>();
        Node temp = simulationNodeStrikeCurrent;
        path.add(temp);
        while (temp.getParent() != null) {
            temp = temp.getParent();
            path.add(temp);
        }

        return path;
    }

    /**
     * Get storm simulation.
     *
     * @return storm simulation.
     */
    public int[][][] getSimulationStormZone() {
        return stormZone;
    }
}
