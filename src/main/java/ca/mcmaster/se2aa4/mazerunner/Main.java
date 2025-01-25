package ca.mcmaster.se2aa4.mazerunner;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.maze.mazeloader
import ca.mcmaster.se2aa4.mazerunner.maze.mazeexplorer;
import ca.mcmaster.se2aa4.mazerunner.player.Player;
import ca.mcmaster.se2aa4.mazerunner.player.Position;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.cli.*; 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

	//Setting up Apache CLI library options/parsing arguments
	Options options = new Options();
        options.addOptions("i", true, "Input the maze file");

        CommandLineParser parser = new DefaultParser();

        try {
	    CommandLine cmd = parser.parse(options, args);
	    String mazeFile = cmd.getOptionValue("i");
            if (mazeFile!=null) {
		logger.info("Reading the maze from file: " + mazeFile);
                Maze maze = mazeloader.loadMaze(mazeFile);
                logger.info("Maze has loaded successfully");
                printMaze(maze);
            } else {
                logger.error("File not provided, missing required -i flag");
            }
	} catch(ParseException e){ //catches exceptions and displays errors accordingly
	    logger.error("Error parsing command line arguments", e);
	} catch(IOException e){
	    logger.error("Error when trying to load the maze: ", e);
	} catch(Exception e) {
            logger.error("An error has occured while processing the maze");
        }
	
    private static void printMaze(Maze maze) { //prints the maze
        char[][] grid = maze.getGrid();
        for (char[] row : grid) {
            System.out.println(row);
        }
    }
}
