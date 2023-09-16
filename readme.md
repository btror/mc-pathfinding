# Spigot Pathfinding Library

The mc-pathfinding library provides pathfinding and animation capabilities for your Minecraft server plugins. This README will guide you on how to use this library in your server plugins.


## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Examples](#examples)
- [Contributing](#contributing)
- [License](#license)


## Installation TODO: change to explain how to add library as dependency

1. **Download the Plugin JAR**:
    - Obtain the McPathfinding plugin JAR file from the [Releases](https://github.com/yourusername/McPathfinding/releases) section of this repository.

2. **Place the JAR in Your Plugins Folder**:
    - Copy the downloaded JAR file into your server's `plugins` folder.

3. **Start or Reload Your Server**:
    - Start your Minecraft server or reload it if it's already running.


## Usage TODO: add more details and examples

### Pathfinding Methods

The plugin provides various pathfinding algorithms that you can use to create animations in your Minecraft world. These algorithms can be triggered using the `astar` and `greedyBestFirstSearch` methods with different parameters.

```java
// Example of how to use the astar method
McPathfinding.astar(snapshot, startLocation, targetLocation, Material.GOLD_BLOCK, Particle.ELECTRIC_SPARK, 0, 10);
```


### Method Parameters

`snapshot`: A three-dimensional array of Location objects representing your Minecraft world's layout.

`startLocation`: The starting Location for the pathfinding operation.

`targetLocation`: The target Location to reach.

`material` (optional): A block type that you want to use for visualization.

`particle` (optional): A visual particle effect to enhance the animation.

`delay` (optional): The delay (in ticks) before starting the animation.

`period` (optional): The period (in ticks) at which the animation updates.


### Customization

You can customize the pathfinding animations by adjusting the method parameters, such as the material, particle, delay, and period. Experiment with different values to achieve the desired visual effect.


### Examples

Here's a simple example of how to use the McPathfinding plugin:

```java
// Create a snapshot of your Minecraft world
Location[][][] snapshot = new Location[10][10][10];

// Define the snapshot's spawn location
Location snapshotSpawnLocation = new Location(player.getWorld(), player.getLocation().getX() + 3, player.getLocation().getY(), player.getLocation().getZ() + 3);

// Generate the snapshot
for (int i = 0; i < 10; i++) {
    for (int j = 0; j < 10; j++) {
        for (int k = 0; k < 10; k++) {
            snapshot[i][j][k] = new Location(snapshotSpawnLocation.getWorld(), snapshotSpawnLocation.getX() + i, snapshotSpawnLocation.getY() + j, snapshotSpawnLocation.getZ() + k);
        }
    }
}

// Choose random start and target locations within the snapshot
Location snapshotStartLocation = snapshot[(int) (Math.random() * 9 + 0)][(int) (Math.random() * 9 + 0)][(int) (Math.random() * 9 + 0)];
Location snapshotTargetLocation = snapshot[(int) (Math.random() * 9 + 0)][(int) (Math.random() * 9 + 0)][(int) (Math.random() * 9 + 0)];

// Trigger the A* pathfinding animation with customization options
plugin.astar(snapshot, snapshotStartLocation, snapshotTargetLocation, Material.GOLD_BLOCK, Particle.ELECTRIC_SPARK, 0, 10);
```

Feel free to explore more customization options and use different pathfinding methods provided by the plugin to create engaging animations in your Minecraft server.


## Contributing TODO: be more specific

If you'd like to contribute to the development of this plugin or report issues, please check out the GitHub repository for more information.


## Data model TODO: create data model


## License TODO: find appropriate license

PLACEHOLDER: This project is licensed under the MIT License - see the LICENSE file for details.