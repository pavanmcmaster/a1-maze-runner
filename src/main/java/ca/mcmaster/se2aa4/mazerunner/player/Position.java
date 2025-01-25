package ca.mcmaster.se2aa4.mazerunner.player;

public class Position {
    private int x;
    private int y;
    private char direction;
    public Position(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() { //gets x value
        return x;
    }
    public int getY() { //gets y value
        return y;
    }
    public char getDirection() { //finds direction
        return direction;
    }
    public void setX(int x) { //sets x value
        this.x = x;
    }
    public void setY(int y) { //sets y value
        this.y = y;
    }
    public void setDirection(char direction) { //sets direction
        this.direction = direction;
    }
}
