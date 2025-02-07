package ca.mcmaster.se2aa4.mazerunner.maze;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class MazeLoader {
    public static Maze loadMaze(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            List<char[]> lines = new ArrayList<>();
            String line;

            while ((line = reader.readLine())!=null) {
		System.out.println("Reading line: " + line);  //for debug
		if (line.isEmpty()) continue;
                if (!line.matches("[# SE]+")) {
                    throw new IOException("Invalid format for maze: " + line);
                }
                lines.add(line.toCharArray());
            }

        if (lines.isEmpty()) {
            throw new IOException("The maze file is empty");
        }
        char[][] grid = lines.toArray(new char[lines.size()][]);
        return new Maze(grid);
	}
    }

}
