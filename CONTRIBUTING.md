# Contributing to mc-pathfinding

Welcome to mc-pathfinding! We're thrilled that you're interested in contributing. Before you get started, please take a moment to read this document to understand how you can contribute to our project.

## How to Contribute

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/btror/mc-pathfinding.git
   ```

2. Create a new branch for your feature or bug fix:

   ```bash
   git checkout -b feature-or-bug-fix-name
   ```

3. Work on your changes. Ensure that any new features work as expected. Also make sure to increase the project version in pom.xml using the MAJOR.MINOR.PATCH convention.

4. Commit your changes (make sure to increase pom.xml version):

   ```bash
   git commit -m "Description of your changes"
   ```

5. Push to your branch and open a pull request.

   ```bash
   git push origin feature/my-new-feature
   ```

6. Create a Pull Request: Go to the GitHub page of this repository, switch to the branch with your changes, and click the "New Pull Request" button. Provide a clear title and description for your pull request.

7. Pull requests require 2 reviews before merging and they must pass CI (see pull-request.yml). Merge when CI passes and the required reviews are met (or ask [btror](https://github.com/btror) to merge).

8. Once merged, a new release will be created automatically.



## Code Style and Guidelines
When adding new classes or files make sure to follow the [data model](#data-model).

## Data Model

Here's an overview of the key classes and components, along with their roles and relationships.

<details>
<summary>Library Structure</summary>

### `com.github.btror.mcpathfinding`

Main Class `McPathfinding`

- Contains [Pathfinding Methods](#pathfinding-methods) to be used.

### `com.github.btror.mcpathfinding.simulation`

Abstract Class `Simulation`

- Structure for pathfinding algorithm simulations.
- Abstract base class for different pathfinding algorithms.

Class `SimulationFactory`

- Factory class for creating different pathfinding simulations.

### `com.github.btror.mcpathfinding.simulation.pathfinding`

Class `AStarSearch`

- Implementation of the A\* pathfinding algorithm.

Class `GreedyBestFirstSearch`

- Implementation of the Greedy Best-First Search pathfinding algorithm.

### `com.github.btror.mcpathfinding.simulation.util`

Class `Node`

- Represents a node in the pathfinding simulation.
- Stores information about a grid cell, including its position and type.

Class `NodeComparator`

- Implements a comparator for nodes, used for sorting in pathfinding algorithms.

### `com.github.btror.mcpathfinding.animation`

Class `Animation`

- Manages the visualization of the pathfinding process in Minecraft.
- Animates the pathfinding steps, including block changes and particle effects.
</details>


## Issue Tracking
If you find a bug or have a feature request, please open an issue to report it.

## License
By contributing to this project, you agree that your contributions will be licensed under the project's license.

Thank you for your contributions!
