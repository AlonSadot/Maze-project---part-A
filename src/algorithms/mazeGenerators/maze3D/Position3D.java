package algorithms.mazeGenerators.maze3D;

public class Position3D {
    int value;
    int x;
    int y;
    int z;
    boolean visited ;


    @Override
    public String toString() {
        return "{" +
                + z +
                "," + x +
                "," + y +
                '}';
    }

    public Position3D(int z, int x, int y) {
        this.value =1;
        this.x = x;
        this.y = y;
        this.z = z;
        this.visited = false;
    }

    public int getDepthIndex(){
        return 0;
    }
    public int getRowIndex(){
        return 0;
    }
    public int getColumnIndex(){
        return 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public boolean isVisited() {
        return visited;
    }

    public int getValue() {
        return value;
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

    public void setZ(int z) {
        this.z = z;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
