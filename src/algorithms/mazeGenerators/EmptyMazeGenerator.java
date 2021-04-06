package algorithms.mazeGenerators;

import java.util.Random;

public class EmptyMazeGenerator extends AMazeGenerator{

    @Override
    public Maze generate(int row, int column) {
        Maze newMaze = new Maze(row,column);

        for (int i=0;i<row;i++){
            for (int j=0; j<column;j++){
                newMaze.matrix[i][j]=0;
            }
        }

        Random rand = new Random();
        int start = rand.nextInt((row-1 - 0) + 1) + 0;
        int end = rand.nextInt((row-1 - 0) + 1) + 0;

        newMaze.matrix[start][0]=0;
        newMaze.matrix[end][column-1]=0;

        newMaze.entrance = new Position(start,0);
        newMaze.exit = new Position(end,column-1);

        return newMaze;
    }

}



