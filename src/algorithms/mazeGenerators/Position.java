package algorithms.mazeGenerators;

public class Position {
    int value;
    int x;
    int y;
    boolean visited;
    public Position(int xPos, int yPos){
        this.value =1;
        this.x=xPos;
        this.y=yPos;
        this.visited=false;
    }
    @Override
    public String toString() {
        return "{" +
                 + x +
                "," + y +
                '}';
    }

    public int getValue() {
        return value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
