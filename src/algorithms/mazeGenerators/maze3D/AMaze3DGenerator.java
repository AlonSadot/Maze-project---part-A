package algorithms.mazeGenerators.maze3D;

public abstract class AMaze3DGenerator implements IMazeGenerator3D{

    public long measureAlgorithmTimeMillis(int depth, int row, int column) {
        long startTime = System.currentTimeMillis();
        generate(depth,row,column);
        long stopTime  = System.currentTimeMillis();
        return stopTime - startTime;
    }

}
