package algorithms.mazeGenerators;

public class Position {
    int x;
    int y;

    /**
     * @param xPos - current row
     * @param yPos - current column
     */
    public Position(int xPos, int yPos){
        if (xPos < 0 || yPos< 0)
            throw new IllegalArgumentException("Invalid Position input");
        this.x=xPos;
        this.y=yPos;
    }
    @Override
    public String toString() {
        return "{" +
                 + x +
                "," + y +
                '}';
    }

    /**
     * @param other - other Position
     * @return - returns if this position is equal to the other
     */
    public boolean equals(Position other){
        if (other == null)
            throw new IllegalArgumentException("Invalid Argument received");
        if (this.x == other.getRowIndex() && this.y == other.getColumnIndex())
            return true;
        return false;
    }

    public int getRowIndex() {
        return x;
    }

    public int getColumnIndex() {
        return y;
    }
}
