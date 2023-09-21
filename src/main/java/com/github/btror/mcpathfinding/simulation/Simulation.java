package com.github.btror.mcpathfinding.simulation;

import com.github.btror.mcpathfinding.simulation.util.Node;
import com.github.btror.mcpathfinding.simulation.util.NodeComparator;

import java.util.ArrayList;
import java.util.PriorityQueue;

public abstract class Simulation {
    protected int[][][] simulationSnapshot;
    protected int[] simulationStart;
    protected int[] simulationTarget;
    protected ArrayList<Integer[]> simulationPath;

    protected Node[][][] nodeSnapshot;
    protected Node nodeStart;
    protected Node nodeTarget;
    protected Node nodeCurrent;

    protected PriorityQueue<Node> openList;
    protected ArrayList<Node> closedList;

    protected boolean diagonalMovement;
    protected int beamWidth;

    public Simulation() {
        this.openList = new PriorityQueue<>(10, new NodeComparator());
        this.closedList = new ArrayList<>();
        this.simulationPath = new ArrayList<>();
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
    public Simulation(
            int[][][] simulationSnapshot,
            int[] simulationStart,
            int[] simulationTarget) {
        this.simulationSnapshot = simulationSnapshot;
        this.simulationStart = simulationStart;
        this.simulationTarget = simulationTarget;
        this.nodeSnapshot = new Node[simulationSnapshot.length][simulationSnapshot[0].length][simulationSnapshot[0][0].length];
        this.openList = new PriorityQueue<>(10, new NodeComparator());
        this.closedList = new ArrayList<>();
        this.simulationPath = new ArrayList<>();
    }

    public abstract void start();

    protected abstract void calculateNeighborValues();

    public void findPath() {
        while (!openList.isEmpty() && !nodeCurrent.equals(nodeTarget)) {
            nodeCurrent = openList.peek();
            openList.remove(openList.peek());

            if (nodeCurrent.equals(nodeTarget)) {
                closedList.add(nodeCurrent);

                ArrayList<Node> path = generatePath();

                for (int i = path.size() - 1; i > -1; i--) {
                    int row = path.get(i).getRow();
                    int col = path.get(i).getCol();
                    int zNum = path.get(i).getZ();
                    if (simulationSnapshot[row][col][zNum] == 2) {
                        simulationSnapshot[row][col][zNum] = 3;
                        simulationPath.add(new Integer[] { row, col, zNum });
                    }
                }
                break;
            } else {
                try {
                    calculateNeighborValues();
                } catch (NullPointerException e) {
                    System.out.println(e.getMessage());
                }
                simulationSnapshot[nodeStart.getRow()][nodeStart.getCol()][nodeStart.getZ()] = 4;
                simulationSnapshot[nodeTarget.getRow()][nodeTarget.getCol()][nodeTarget.getZ()] = 5;
                try {
                    assert openList.peek() != null;
                } catch (NullPointerException ignored) {
                }
                closedList.add(nodeCurrent);
            }
        }
    }

    protected int calculateG(Node node) {
        int row = node.getRow();
        int col = node.getCol();
        int zNum = node.getZ();
        if (row == nodeCurrent.getRow() && col == nodeCurrent.getCol() && zNum == nodeCurrent.getZ()) {
            return 0;
        }

        Node parent = node.getParent();
        if (parent == null) {
            int xDistance;
            if (col > nodeCurrent.getCol()) {
                xDistance = col - nodeCurrent.getCol();
            } else {
                xDistance = nodeCurrent.getCol() - col;
            }

            int yDistance;
            if (row > nodeCurrent.getRow()) {
                yDistance = row - nodeCurrent.getRow();
            } else {
                yDistance = nodeCurrent.getRow() - row;
            }

            int zDistance;
            if (zNum > nodeCurrent.getZ()) {
                zDistance = zNum - nodeCurrent.getZ();
            } else {
                zDistance = nodeCurrent.getZ() - zNum;
            }

            return (xDistance * 10) + (yDistance * 10) + (zDistance * 10);
        }

        return 10 + parent.getG();
    }

    protected int calculateH(Node node) {
        int row = node.getRow();
        int col = node.getCol();
        int zNum = node.getZ();
        int x = 0;
        int y = 0;
        int z = 0;

        while (col < nodeTarget.getCol() || col > nodeTarget.getCol()) {
            x += 10;
            if (col < nodeTarget.getCol()) {
                col++;
            }
            if (col > nodeTarget.getCol()) {
                col--;
            }
        }

        while (row < nodeTarget.getRow() || row > nodeTarget.getRow()) {
            y += 10;
            if (row < nodeTarget.getRow()) {
                row++;
            }
            if (row > nodeTarget.getRow()) {
                row--;
            }
        }

        while (zNum < nodeTarget.getZ() || zNum > nodeTarget.getZ()) {
            z += 10;
            if (zNum < nodeTarget.getZ()) {
                zNum++;
            }
            if (zNum > nodeTarget.getZ()) {
                zNum--;
            }
        }

        return x + y + z;
    }

    private ArrayList<Node> generatePath() {
        ArrayList<Node> path = new ArrayList<>();
        Node temp = nodeCurrent;
        path.add(temp);
        while (temp.getParent() != null) {
            temp = temp.getParent();
            path.add(temp);
        }

        return path;
    }

    protected boolean isValid(int row, int col, int z) {
        return row >= 0 && row < simulationSnapshot.length &&
                col >= 0 && col < simulationSnapshot[0].length &&
                z >= 0 && z < simulationSnapshot[0][0].length;
    }

    public void setSimulationSnapshot(int[][][] simulationSnapshot) {
        this.nodeSnapshot = new Node[simulationSnapshot.length][simulationSnapshot[0].length][simulationSnapshot[0][0].length];
        this.simulationSnapshot = simulationSnapshot;
    }

    public void setSimulationStrikeStart(int[] simulationStart) {
        this.simulationStart = simulationStart;
    }

    public void setSimulationStrikeTarget(int[] simulationTarget) {
        this.simulationTarget = simulationTarget;
    }

    public void setDiagonalMovement(boolean diagonalMovement) {
        this.diagonalMovement = diagonalMovement;
    }

    public void setBeamWidth(int beamWidth) {
        this.beamWidth = beamWidth;
    }

    public int[][][] getSimulationSnapshot() {
        return simulationSnapshot;
    }

    public ArrayList<Integer[]> getSimulationPath() {
        return this.simulationPath;
    }
}
