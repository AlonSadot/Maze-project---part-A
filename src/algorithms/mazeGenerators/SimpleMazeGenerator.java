package algorithms.mazeGenerators;

import java.util.Random;


public class SimpleMazeGenerator extends AMazeGenerator{

    /**
     * @param row - number of the maze's rows
     * @param column - number of the maze's columns
     * @return returns a simple maze generated randomly
     */
    @Override
   public Maze generate(int row, int column) {
        if (row < 2 || column < 2)
            throw new IllegalArgumentException("Invalid Maze Dimensions input");
        Maze newMaze = new Maze(row,column);

        for (int i=0;i<row;i++){
            for (int j=0; j<column;j++){
                newMaze.getMatrix()[i][j]=1;
            }
        }

        Random rand = new Random();
        int currColumn=0 , randomNum , startX;
        int currRow = rand.nextInt(row-1);
        startX = currRow;

        while (currColumn < column-1){
            randomNum = rand.nextInt(3-0)+1;
            if (randomNum == 0 || randomNum == 1){
                currColumn++;
                newMaze.getMatrix()[currRow][currColumn]=0;
            }
            else if (randomNum ==2 && currRow+1 < row){
                currRow++;
                newMaze.getMatrix()[currRow][currColumn]=0;
            }
            else if (randomNum ==3 && currRow > 0){
                currRow--;
                newMaze.getMatrix()[currRow][currColumn]=0;
            }
        }

        int x,y;

        for (int i=0 ; i<=(row*column)/1.5;i++){
            x = rand.nextInt(row-1);
            y = rand.nextInt(column-1);
            newMaze.getMatrix()[x][y]=0;
        }

        newMaze.getMatrix()[startX][0]=0;
        newMaze.getMatrix()[currRow][currColumn]=0;

        newMaze.entrance = new Position(startX,0);
        newMaze.exit = new Position(currRow,currColumn);

        return newMaze;
    }
}
