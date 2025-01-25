package ca.mcmaster.se2aa4.mazerunner.maze;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze {
    private static final Logger logger = LogManager.getLogger();
    private char[][] grid;
    private int entryX = -100, entryY = -100;
    private int exitX = -100, exitY = -100;

    public Maze(char[][] grid) {
        this.grid = grid;
        findEntryAndExit(); //calls functions to find and take note of entry and exit points
        recordEntryAndExit();
    }

    public char[][] getGrid() {
        return grid;
    }

    public int getEntryX() {
        return entryX;
    }

    public int getEntryY() {
        return entryY;
    }

    public int getExitX() {
        return exitX;
    }

    public int getExitY() {
        return exitY;
    }

    private void findEntryAndExit() {
        // checks for the entry and exit points on the borders
        for (int y = 0; y < grid.length; y++) { //increments by 1 and checks each row
            for (int x = 0; x < grid[y].length; x++) { //increments by 1 and checks each column
                if (grid[y][x] == ' ' && (x == 0 || y == 0 || y == grid.length - 1 || x == grid[y].length - 1)) { //checks if spot is blank and on border
                    if (entryX == -100 && entryY == -100) { //if entries not updated, update them first, otherwise the exits
                        entryX = x;
                        entryY = y;
                    } else {
                        exitX = x;
                        exitY = y;
                        return;
                    }
                }
            }
        }
    }

    private void recordEntryAndExit() {
        if (entryX != -100 && entryY != -100) { //if entries identified
            logger.info("Entry point(row,column): (" + entryY + "," + entryX + ")");
        } else { //otherwise show entry not found error
            logger.error("The entry point was not found in the maze.");
        }

        if (exitX != -100 && exitY != -100) { //if exits identified
            logger.info("Exit point(row,column): (" + exitY + "," + exitX + ")");
        } else { //otherwise show exit not found error
            logger.error("The exit point was not found in the maze.");
        }
    }
}
