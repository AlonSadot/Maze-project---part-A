package algorithms.mazeGenerators;

public interface IMazeGenerator {

Maze generate(int row, int column);

long measureAlgorithmTimeMillis(int row, int column);

}
