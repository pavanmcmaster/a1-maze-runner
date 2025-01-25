package ca.mcmaster.se2aa4.mazerunner.player;

import ca.mcmaster.se2aa4.mazerunner.maze.Maze;

public class Player {
    private Position position;

    public Player(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public boolean goForward(Maze maze) { //to go forward
        int newx = position.getX();
        int newy = position.getY();
        switch (position.getDirection()) { //gets direction and uses switch case to go through all possible cases and adjust coordinate accordingly
            case 'N':
                newy--;
                break;
	    case 'S':
                newy++;
                break;
            case 'W':
                newx--;
                break;
            case 'E':
                newx++;
                break;
        }
        position.setX(newx);
        position.setY(newy);
    }

    public void turnRight() { //turn right
        switch (position.getDirection()) {
            case 'N':
                position.setDirection('E');
                break;
            case 'S':
                position.setDirection('W');
                break;
            case 'W':
                position.setDirection('N');
                break;
            case 'E':
                position.setDirection('S');
                break;
        }
    }

    public void turnLeft() { //turn left
        switch (position.getDirection()) {
            case 'N':
                position.setDirection('W');
                break;
            case 'S':
                position.setDirection('E');
                break;
            case 'W':
                position.setDirection('S');
                break;
            case 'E':
                position.setDirection('N');
                break;
        }
    }
}
