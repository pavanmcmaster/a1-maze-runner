package ca.mcmaster.se2aa4.mazerunner.maze;

import ca.mcmaster.se2aa4.mazerunner.player.Player;
import ca.mcmaster.se2aa4.mazerunner.player.Position;

public class MazeExplorer {
    private Maze maze;
    private Player player;

    public MazeExplorer(Maze maze, Player player) {
        this.maze = maze;
        this.player = player;
    }
    private void displayPosition() { //displays positon
        char[][] grid = maze.getGrid();
        Position position = player.getPosition();
        grid[position.getY()][position.getX()] = '*';
        for (char[] row : grid) {
            System.out.println(row);
        }
    }
}
