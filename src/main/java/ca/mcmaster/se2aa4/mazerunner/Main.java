package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

            // checks for the required "-i" flag
	    String mazeFile = cmd.getOptionValue("i");
            if (mazeFile==null) {
                logger.error("File not provided, missing required -i flag");
                System.exit(1);
            }
            logger.info("Reading the maze from file: " + mazeFile);

            // reads and processes the maze file
            BufferedReader reader = new BufferedReader(new FileReader(mazeFile));
            String line;
            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        System.out.print("WALL ");
                    } else if (line.charAt(idx) == ' ') {
                        System.out.print("PASS ");
                    }
                }
                System.out.print(System.lineSeparator());
            }
	} catch(ParseException e){ //catches exceptions and displays errors accordingly
	    logger.error("Error parsing command line arguments", e);
	} catch(Exception e) {
            logger.error("An error has occured while processing the maze");
        }
	
        logger.info("**** Computing path");
        logger.info("PATH NOT COMPUTED");i
        logger.info("** End of MazeRunner");
    }
}
