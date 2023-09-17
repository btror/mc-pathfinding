# Spigot Pathfinding Library

The mc-pathfinding library provides pathfinding and animation capabilities for your Minecraft server plugins. This README will guide you on how to use this library in your server plugins.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
  - [Pathfinding Methods](#pathfinding-methods)
  - [Examples](#examples)
- [Contributing](#contributing)
- [Data Model](#data-model)
- [License](#license)

## Installation

To use this library in your Spigot plugin, you should add it as a dependency. Here's how to do it:

1. **Download the Plugin JAR**:

   - Obtain the JAR file from the [Releases](https://github.com/yourusername/McPathfinding/releases) section of this repository.

2. **Add the Dependency to Your Project**:

   - You can add the mc-pathfinding library as a dependency in your project's build configuration (e.g., Maven or Gradle) by specifying the repository and the library version.
   - Example for Maven:
     ```xml
     <dependencies>
       <dependency>
         <groupId>com.example</groupId>
         <artifactId>mc-pathfinding</artifactId>
         <version>1.0.0</version> <!-- Replace with the actual version -->
       </dependency>
     </dependencies>
     ```
   - Example for Gradle:
     ```groovy
     dependencies {
         implementation 'com.example:mc-pathfinding:1.0.0' // Replace with the actual version
     }
     ```

3. **Reload Your Project**:
   - After adding the dependency, reload your project to ensure that the library is properly integrated.

## Usage

### Pathfinding Methods

The plugin provides various pathfinding algorithms that you can use to create animations in your Minecraft world. These algorithms can be triggered using the `astar` and `greedyBestFirstSearch` methods with different parameters. You can use the `search` method to better customize the pathfinding animation.

## Methods

Here is a list of methods available in the McPathfinding library:

| &emsp;&emsp;Method                     | &emsp;&emsp;Description                                                                   |
| -------------------------------------- | ----------------------------------------------------------------------------------------- |
| &emsp;&emsp;astar                      | &emsp;&emsp;Performs A\* pathfinding with the specified parameters.                       |
| &emsp;&emsp;`Location[][][] snapshot`  | &emsp;&emsp;3D array of Location objects representing your Minecraft world's layout.      |
| &emsp;&emsp;`Location startLocation`   | &emsp;&emsp;The starting Location for the pathfinding operation.                          |
| &emsp;&emsp;`Location targetLocation`  | &emsp;&emsp;The target Location to reach.                                                 |
| &emsp;&emsp;`Material material`        | &emsp;&emsp;(optional) A block type that you want to use for visualization.               |
| &emsp;&emsp;`Particle particle`        | &emsp;&emsp;(optional) A visual particle effect to enhance the animation.                 |
| &emsp;&emsp;`boolean diagonalMovement` | &emsp;&emsp;(optional) Indicates whether diagonal movement is allowed during pathfinding. |
| &emsp;&emsp;`long delay`               | &emsp;&emsp;(optional) The delay (in ticks) before starting the animation.                |
| &emsp;&emsp;`long period`              | &emsp;&emsp;(optional) The period (in ticks) at which the animation updates.              |

| &emsp;&emsp;Method                     | &emsp;&emsp;Description                                                                   |
| -------------------------------------- | ----------------------------------------------------------------------------------------- |
| &emsp;&emsp;greedyBestFirstSearch      | &emsp;&emsp;Performs Greedy Best First Search pathfinding with the specified parameters.  |
| &emsp;&emsp;`Location[][][] snapshot`  | &emsp;&emsp;3D array of Location objects representing your Minecraft world's layout.      |
| &emsp;&emsp;`Location startLocation`   | &emsp;&emsp;The starting Location for the pathfinding operation.                          |
| &emsp;&emsp;`Location targetLocation`  | &emsp;&emsp;The target Location to reach.                                                 |
| &emsp;&emsp;`Material material`        | &emsp;&emsp;(optional) A block type that you want to use for visualization.               |
| &emsp;&emsp;`Particle particle`        | &emsp;&emsp;(optional) A visual particle effect to enhance the animation.                 |
| &emsp;&emsp;`boolean diagonalMovement` | &emsp;&emsp;(optional) Indicates whether diagonal movement is allowed during pathfinding. |
| &emsp;&emsp;`long delay`               | &emsp;&emsp;(optional) The delay (in ticks) before starting the animation.                |
| &emsp;&emsp;`long period`              | &emsp;&emsp;(optional) The period (in ticks) at which the animation updates.              |

| &emsp;&emsp;Method                     | &emsp;&emsp;Description                                                              |
| -------------------------------------- | ------------------------------------------------------------------------------------ |
| &emsp;&emsp;search                     | &emsp;&emsp;Initiates a pathfinding animation with the specified parameters.         |
| &emsp;&emsp;`Location[][][] snapshot`  | &emsp;&emsp;3D array of Location objects representing your Minecraft world's layout. |
| &emsp;&emsp;`Location startLocation`   | &emsp;&emsp;The starting Location for the pathfinding operation.                     |
| &emsp;&emsp;`Location targetLocation`  | &emsp;&emsp;The target Location to reach.                                            |
| &emsp;&emsp;`Material material`        | &emsp;&emsp;A block type that you want to use for visualization.                     |
| &emsp;&emsp;`Particle particle`        | &emsp;&emsp;A visual particle effect to enhance the animation.                       |
| &emsp;&emsp;`String algorithm`         | &emsp;&emsp;The pathfinding algorithm to use (e.g., "astar" or "gbfs").              |
| &emsp;&emsp;`boolean diagonalMovement` | &emsp;&emsp;Indicates whether diagonal movement is allowed during pathfinding.       |
| &emsp;&emsp;`long delay`               | &emsp;&emsp;The delay (in ticks) before starting the animation.                      |
| &emsp;&emsp;`long period`              | &emsp;&emsp;The period (in ticks) at which the animation updates.                    |

### Examples

You can customize the pathfinding animations by adjusting the method parameters, such as the material, particle, delay, and period. Experiment with different values to achieve the desired visual effect.

```java
// Examples of a few ways to use the astar and greedyBestFirstSearch methods.
McPathfinding.astar(snapshot, startLocation, targetLocation, material);
McPathfinding.astar(snapshot, startLocation, targetLocation, particle);
McPathfinding.astar(snapshot, startLocation, targetLocation, material, diagonalMovement);
McPathfinding.greedyBestFirstSearch(snapshot, startLocation, targetLocation, material, particle, diagonalMovement);
McPathfinding.greedyBestFirstSearch(snapshot, startLocation, targetLocation, material, delay, period);
McPathfinding.greedyBestFirstSearch(snapshot, startLocation, targetLocation, material, particle, diagonalMovement, delay, period);

// Example of how to use the search method.
McPathfinding.search(snapshot, startLocation, targetLocation, material, particle, algorithm, diagonalMovement, delay, period);
```

Here's a simple example scenario of how the library can be used.

```java
// Create a snapshot of an area in your Minecraft world based on the location of a Player.
Location[][][] snapshot = new Location[20][20][20];

for (int i = 0; i < 20; i++) {
      for (int j = 0; j < 20; j++) {
            for (int k = 0; k < 20; k++) {
                  snapshot[i][j][k] = new Location(
                        player.getLocation().getWorld(),
                        player.getLocation().getX() + i,
                        player.getLocation().getY() + j,
                        player.getLocation().getZ() + k
                  );
            }
      }
}

// Choose a start and target location in the snapshot.
Location snapshotStartLocation = snapshot[0][0][5];
Location snapshotTargetLocation = snapshot[10][15][8];

// Use a pathfinding method to find a path from start to target. A path of gold blocks with electric spark particle effects will be generated to show where the path is.
plugin.astar(snapshot, snapshotStartLocation, snapshotTargetLocation, Material.GOLD_BLOCK, Particle.ELECTRIC_SPARK, true);
```

Feel free to explore more customization options and use different pathfinding methods provided by the plugin to create engaging animations in your Minecraft server.

## Contributing

If you'd like to contribute to the development of this library or report issues, please check out the GitHub repository for more information.

## Data model

TODO: Create a data model section to describe any relevant data structures used in the library.

## License

This project is licensed under the MIT License. See the LICENSE file for details.
