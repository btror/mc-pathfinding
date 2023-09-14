# mc-pathfinding

### Class Structure

### Class: Animation
#### Description: spawns blocks and handles timing & synchronization.
#### Usage: runs simulations until a successful simulation occurs. Successful simulations are mapped to objects (blocks & entities) that are spawned in an animated fashion.
<br>

### Class: Simulation
#### Description: uses pathfinding algorithms to solve simulation mazes. Simulation mazes are snapshots of parts of the minecraft world (blocks & entities) that are mapped to Nodes for easier processing.
#### Usage: maps snapshots to 3D integer arrays to represent a digital version of the world that uses pathfinding algorithms to traverse from a start point to a target point.
#### Subclass: Node
#### - Description: the objects that make up a simulation maze with integer properties.
#### - Usage: contains properties for f score, g score, and h score and their methods.
#### Subclass: NodeComparator
#### - Description: compares node heuristics.
#### - Usage: uses node f-scores to compare heuristics.
#### Subclass: AStar
#### - Description: uses A* pathfinding algorithm to calculate heuristics (f = g + h, g = start node position to current node position, h = current node position to target position).
#### Subclass: GreedyBestFirstSearch
#### - Description: uses Greedy BFS pathfinding algorithm to calculate heuristics (f = h, h = current node position to target position).
