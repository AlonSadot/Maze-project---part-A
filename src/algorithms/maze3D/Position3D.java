package algorithms.maze3D;

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

    /**
     * @param z - current depth
     * @param x - current row
     * @param y - current column
     */
    public Position3D(int z, int x, int y) {
        if (z < 0 || x < 0 || y < 0)
            throw new IllegalArgumentException("Invalid Position Input");
        this.value =1;
        this.x = x;
        this.y = y;
        this.z = z;
        this.visited = false;
    }

    /**
     * @param other - other Position
     * @return - returns if this position is equal to the other
     */
    public boolean equals(Position3D other){
        if (other == null)
            throw new IllegalArgumentException("Invalid Input");
        if (this.x == other.getRowIndex() && this.y == other.getColumnIndex() && this.z == other.getDepthIndex())
            return true;
        return false;
    }

    public int getRowIndex() { return x; }

    public int getColumnIndex() {
        return y;
    }

    public int getDepthIndex() {
        return z;
    }

}
