# McPathfinding Project Documentation

## Package: com.github.btror.mcpathfinding.simulation

### Class: Simulation
- **Description**: Uses pathfinding algorithms to solve simulation mazes. Simulation mazes are snapshots of parts of the Minecraft world (blocks & entities) that are mapped to Nodes for easier processing.
- **Usage**: Maps snapshots to 3D integer arrays to represent a digital version of the world that uses pathfinding algorithms to traverse from a start point to a target point.

### Subpackage: util

#### Class: Node
- **Description**: The objects that make up a simulation maze with integer properties.
- **Usage**: Contains properties for f score, g score, and h score and their methods.

#### Class: NodeComparator
- **Description**: Compares node heuristics.
- **Usage**: Uses node f-scores to compare heuristics.

### Subpackage: pathfinding

#### Class: AStar
- **Description**: Uses A* pathfinding algorithm to calculate heuristics (f = g + h, g = start node position to current node position, h = current node position to target position).

#### Class: GreedyBestFirstSearch
- **Description**: Uses Greedy BFS pathfinding algorithm to calculate heuristics (f = h, h = current node position to target position).

### Class: Animation
- **Description**: Spawns blocks and handles timing & synchronization.
- **Usage**: Runs simulations until a successful simulation occurs. Successful simulations are mapped to objects (blocks & entities) that are spawned in an animated fashion.
