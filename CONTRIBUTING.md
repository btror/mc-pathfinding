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

A few general rules:

- When adding new classes or files make sure to follow the [data model](#data-model).
- Make sure existing unit tests pass and add new ones if possible.
  - For example, if you add a new pathfinding algorithm you'll need to add unit tests in the `SimulationTest` and `SimulationFactoryTest` files.
- Make sure any new features work properly before creating a PR. You can do this by running your plugin on a local spigot server.
  - Here's a useful tutorial on how to set up up a local server and configure plugins: TODO: insert YT video
  - There's also a file for running testing commands: TODO: create command file to run stuff with everything commented out


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

Class `BeamSearch`

- Implementation of the Beam Search pathfinding algorithm.

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

<details>
<summary>UML Diagram</summary>
<br>

[Lucidchart link](https://lucid.app/lucidchart/ff59dc30-19c4-4c85-8b49-0015e833c6c8/edit?viewport_loc=-1711%2C-1383%2C4042%2C2110%2C0_0&invitationId=inv_5760d042-41fd-4531-af6a-7d3142470512)

<img src="src/main/resources/mc-pathfinding-uml.jpeg" width="540" height="500">
</details>


### Reporting Issues

If you encounter a bug, have a feature request, or have questions about the project, please open an issue on our GitHub
repository. When reporting an issue, be sure to:

- Provide a descriptive title and clear description of the issue.
- Specify the steps to reproduce the problem, if applicable.
- Include any relevant error messages or screenshots.


## Issue Tracking
If you find a bug or have a feature request, please open an issue to report it.

## License
By contributing to this project, you agree that your contributions will be licensed under the project's license.

Thank you for your contributions!
