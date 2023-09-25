# Contributing to mc-pathfinding

Welcome to mc-pathfinding! We're thrilled that you're interested in contributing. Before you get started, please take a moment to read this document to understand how you can contribute to our project.

## How to Contribute

1. **Fork the Repository:** Click the "Fork" button at the top right of the repository's page on GitHub. This will create a copy of the repository in your GitHub account.

2. **Clone Your Fork:** Clone your forked repository to your local machine using `git clone`.

   ```bash
   git clone https://github.com/your-username/your-project.git
   ```
3. **Create a Branch:** Create a new branch for your work. Use a descriptive name that summarizes your feature or bug fix.

   ```bash
   git checkout -b feature/my-new-feature
   ```
4. **Make Changes:** Make your changes, following the coding conventions and guidelines described in the project.

5. **Test Your Changes:** Ensure that your changes work as expected and that you have added tests if necessary.

6. **Commit Your Changes:** Commit your changes with a clear and concise commit message.

   ```bash
   git commit -m "Description of your changes"
   ```

7. **Push to Your Fork:** Push your changes to your fork on GitHub.

8. Create a Pull Request: Go to the GitHub page of your forked repository, switch to the branch with your changes, and click the "New Pull Request" button. Provide a clear title and description for your pull request.



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
