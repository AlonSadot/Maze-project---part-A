package algorithms.mazeGenerators;

import java.util.Random;
import java.util.ArrayList;
import java.util.Hashtable;

public class MyMazeGenerator extends AMazeGenerator {
    /**
     * @param row - maze's row
     * @param column - maze's column
     * @return - returns a new generated maze
     * generates a maze by Prim's minimal spanning tree algorithm
     */
    @Override
    public Maze generate(int row, int column){
        if (row < 2 || column < 2)
            throw new IllegalArgumentException("Invalid Maze Dimensions input");
        Random rand = new Random();
        int x=(int) (rand.nextInt((int) (row*0.75 - row*0.25) + 1) + row*0.25), y=(int) (rand.nextInt((int)(column*0.75 - column*0.25) + 1) + column*0.25);

        ArrayList<int[]> wallList = new ArrayList<>();
        Maze newMaze = new Maze(row, column);

        for (int i=0;i<row;i++){
            for (int j=0; j<column;j++){
                newMaze.getMatrix()[i][j]=3;
            }
        }
        newMaze.getMatrix()[x][y]=0;
        addNeighbors(newMaze,x , y, row,column ,wallList,1);

        int[] randomPoint , randomNeighbor;
        ArrayList<int[]> currNeighbors = new ArrayList<>();

        while (!wallList.isEmpty()) {
            randomPoint = wallList.remove(rand.nextInt(wallList.size()));
            addNeighbors(newMaze,randomPoint[0],randomPoint[1], row,column ,currNeighbors,0);

            randomNeighbor = currNeighbors.get(rand.nextInt(currNeighbors.size()));

            newMaze.getMatrix()[randomPoint[0] + (randomNeighbor[0] - randomPoint[0])/2][randomPoint[1] + (randomNeighbor[1] - randomPoint[1])/2]=0;
            newMaze.getMatrix()[randomPoint[0]][randomPoint[1]]=0;

            currNeighbors.clear();
            addNeighbors(newMaze, randomPoint[0], randomPoint[1], row,column ,wallList,1);
        }
        Finalize(newMaze,row,column);
        return newMaze;
    }

    /**
     * function that adds the available neighbors based on their current state
     */
    private void addNeighbors(Maze maze, int x, int y, int row, int column , ArrayList<int[]> list, int state) {
        if (x + 2 <= row - 1 ) {
            if (maze.getMatrix()[x + 2][y] == state+2  || (state == 0 && maze.getMatrix()[x + 2][y] == state)) {
                list.add(new int[]{x + 2,y});
                if (state != 0)
                    maze.getMatrix()[x + 2][y]-=2;
            }
        }
        if (x - 2 >= 0) {
            if (maze.getMatrix()[x - 2][y] == state+2 || (state == 0 && maze.getMatrix()[x - 2][y] == state)) {
                list.add(new int[]{x - 2,y});
                if (state != 0)
                    maze.getMatrix()[x - 2][y]-=2;
            }
        }
        if (y + 2 <= column - 1) {
            if (maze.getMatrix()[x][y + 2] == state+2 || (state == 0 && maze.getMatrix()[x ][y+ 2] == state)) {
                list.add(new int[]{x,y + 2});
                if (state != 0)
                    maze.getMatrix()[x][y + 2]-=2;
            }
        }
        if (y - 2 >= 0) {
            if (maze.getMatrix()[x][y - 2] == state+2 || (state == 0 && maze.getMatrix()[x ][y- 2] == state)) {
                list.add(new int[]{x,y - 2});
                if (state != 0)
                    maze.getMatrix()[x][y - 2]-=2;
            }
        }
    }

    /**
     * function that sets a random starting\finishing position to the maze
     */
    public void Finalize(Maze newMaze, int row, int column){
        for (int i=0;i<row;i++){
            for (int j=0; j<column;j++){
                if (newMaze.getMatrix()[i][j]==3)
                    newMaze.getMatrix()[i][j]=1;
            }
        }
        Random rand = new Random();
        int start = rand.nextInt((row-1 - 0) + 1) + 0;
        int end = rand.nextInt((row-1 - 0) + 1) + 0;
        while (true){
            if (column == 2){
                start = 0;
                newMaze.getMatrix()[start][1]=0;
                break;
            }
            if(newMaze.getMatrix()[start][1] == 0)
                break;
            start = rand.nextInt((row-1 - 0) + 1) + 0;
        }
        while (true){
            if (column == 2){
                end = row-1;
                newMaze.getMatrix()[end][column-2]=0;
                break;
            }
            if(newMaze.getMatrix()[end][column-2] == 0)
                break;
            end = rand.nextInt((row-1 - 0) + 1) + 0;
        }
        newMaze.getMatrix()[start][0]=0;
        newMaze.getMatrix()[end][column-1]=0;
        newMaze.entrance = new Position(start,0);
        newMaze.exit = new Position(end,column-1);
    }


}