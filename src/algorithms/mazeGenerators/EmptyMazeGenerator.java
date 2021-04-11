package algorithms.mazeGenerators;

import java.util.Random;

public class EmptyMazeGenerator extends AMazeGenerator{

    /**
     * @param row - Maze's row
     * @param column - Maze's column
     * @return - returns an empty Maze
     */
    @Override
    public Maze generate(int row, int column) {
        if (row < 2 || column < 2)
            throw new IllegalArgumentException("Invalid Maze Dimensions input");
        Maze newMaze = new Maze(row,column);

        for (int i=0;i<row;i++){
            for (int j=0; j<column;j++){
                newMaze.getMatrix()[i][j]=0;
            }
        }

        Random rand = new Random();
        /*
        chooses a random start/end positions on the most right and most left walls
         */
        int start = rand.nextInt((row-1 - 0) + 1) + 0;
        int end = rand.nextInt((row-1 - 0) + 1) + 0;

        newMaze.getMatrix()[start][0]=0; // sets the start position to 0 (path)
        newMaze.getMatrix()[end][column-1]=0; // sets the end position to 0 (path)

        newMaze.entrance = new Position(start,0);
        newMaze.exit = new Position(end,column-1);

        return newMaze;
    }

}



