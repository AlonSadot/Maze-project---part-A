package algorithms.maze3D;

public abstract class AMaze3DGenerator implements IMaze3DGenerator {

    /**
     * @param depth - maze's depth
     * @param row - maze's row size
     * @param column - maze's column size
     * @return - returns amount of time it takes to generate the maze
     */
    public long measureAlgorithmTimeMillis(int depth, int row, int column) {
        long startTime = System.currentTimeMillis();
        generate(depth,row,column);
        long stopTime  = System.currentTimeMillis();
        return stopTime - startTime;
    }
}
