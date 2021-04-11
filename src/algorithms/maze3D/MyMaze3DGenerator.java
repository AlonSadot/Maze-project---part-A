package algorithms.maze3D;

import java.util.ArrayList;
import java.util.Random;

public class MyMaze3DGenerator extends AMaze3DGenerator{

    /**
     * @param depth - maze's depth
     * @param row - maze's number of rows
     * @param column - maze's number of columns
     * @return returns a newly generated 3D maze based on Prim's minimal spanning tree algorithm
     */
    @Override
    public Maze3D generate(int depth, int row, int column) {
        if (depth < 2 || row < 2 || column < 2)
            throw new IllegalArgumentException("Invalid Maze Dimensions Input");
        ArrayList<int[]> wallList = new ArrayList<>();

        Random rand = new Random();
        Maze3D newMaze = new Maze3D(depth, row, column);

        for (int i=0;i<depth;i++){
            for (int j=0; j<row;j++){
                for (int k=0;k<column;k++){
                    newMaze.getMap()[i][j][k]=3;
                }
            }
        }
        int z,y,x;
        z = (int) (rand.nextInt((int) (depth*0.75 - depth*0.25) + 1) + depth*0.25);
        x = (int) (rand.nextInt((int) (row*0.75 - row*0.25) + 1) + row*0.25);
        y = (int) (rand.nextInt((int) (column*0.75 - column*0.25) + 1) + column*0.25);
        newMaze.getMap()[z][x][y]=0; // THIS IS THE STARTING POINT
        addNeighbors(newMaze,z,x,y,depth, row,column ,wallList,1);

        int[] randomPoint , randomNeighbor;

        ArrayList<int[]> currNeighbors = new ArrayList<>();

        while (!wallList.isEmpty() ) {

            randomPoint = wallList.remove(rand.nextInt(wallList.size()));

            addNeighbors(newMaze,randomPoint[0],randomPoint[1],randomPoint[2],depth, row,column ,currNeighbors,0);
            randomNeighbor = currNeighbors.get(rand.nextInt(currNeighbors.size()));

            newMaze.getMap()[randomPoint[0] + (randomNeighbor[0] - randomPoint[0])/2][randomPoint[1] + (randomNeighbor[1] - randomPoint[1])/2][randomPoint[2] + (randomNeighbor[2] - randomPoint[2])/2]=0;
            newMaze.getMap()[randomPoint[0]][randomPoint[1]][randomPoint[2]]=0;

            currNeighbors.clear();
            addNeighbors(newMaze,randomPoint[0],randomPoint[1],randomPoint[2],depth, row,column ,wallList,1);
        }

        Finalize(newMaze,depth,row,column);

        return newMaze;
    }

    /**
     * function that adds the available neighbors based on their current state
     */
    private void addNeighbors(Maze3D maze,int z , int x, int y ,int depth, int row, int column , ArrayList<int[]> list, int state) {
        if (x + 2 <= row - 1 ) {
            if (maze.getMap()[z][x + 2][y] == state+2  || (state == 0 && maze.getMap()[z][x + 2][y] == state)) {
                list.add(new int[]{z,x + 2,y});
                if (state != 0)
                    maze.getMap()[z][x + 2][y]-=2;
            }
        }
        if (x - 2 >= 0) {
            if (maze.getMap()[z][x - 2][y] == state+2 || (state == 0 && maze.getMap()[z][x - 2][y] == state)) {
                list.add(new int[]{z,x - 2,y});
                if (state != 0)
                    maze.getMap()[z][x - 2][y]-=2;
            }
        }
        if (y + 2 <= column - 1) {
            if (maze.getMap()[z][x][y + 2] == state+2 || (state == 0 && maze.getMap()[z][x][y+ 2] == state)) {
                list.add(new int[]{z,x,y + 2});
                if (state != 0)
                    maze.getMap()[z][x][y + 2]-=2;
            }
        }
        if (y - 2 >= 0) {
            if (maze.getMap()[z][x][y - 2] == state+2 || (state == 0 && maze.getMap()[z][x][y- 2] == state)) {
                list.add(new int[]{z,x,y - 2});
                if (state != 0)
                    maze.getMap()[z][x][y - 2]-=2;
            }
        }
        if (z - 2 >= 0) {
            if (maze.getMap()[z-2][x][y] == state+2 || (state == 0 && maze.getMap()[z - 2][x][y] == state)) {
                list.add(new int[]{z - 2,x,y});
                if (state != 0)
                    maze.getMap()[z - 2][x][y]-=2;
            }
        }
        if (z + 2 <= depth - 1) {
            if (maze.getMap()[z+ 2][x][y ] == state+2 || (state == 0 && maze.getMap()[z+ 2][x][y] == state)) {
                list.add(new int[]{z+2,x,y});
                if (state != 0)
                    maze.getMap()[z+ 2][x][y]-=2;
            }
        }
    }

    /**
     * function that sets a random starting\finishing position to the maze
     */
    public void Finalize(Maze3D newMaze, int depth, int row, int column){

        for (int i=0;i<depth;i++){
            for (int j=0; j<row;j++){
                for (int k=0;k<column;k++){
                    if (newMaze.getMap()[i][j][k]==3)
                        newMaze.getMap()[i][j][k]=1;
                }
            }
        }

        Random rand = new Random();
        int startX = rand.nextInt(((row-1) - 1) + 1) + 1;
        int startZ = rand.nextInt(((depth-1) - 1) + 1) + 1;
        int endX = rand.nextInt(((row-1) - 1) + 1) + 1;
        int endZ = rand.nextInt(((depth-1) - 1) + 1) + 1;

        while (true){
            if(newMaze.getMap()[startZ][startX][1] == 0)
                break;
            if (startZ +1 <= depth-1){
                if (newMaze.getMap()[startZ+1][startX][0]== 0 )
                    break;
            }
            if (startZ -1 >= 0){
                if (newMaze.getMap()[startZ-1][startX][0]== 0 )
                    break;
            }
            startX = rand.nextInt((row-1 - 0) + 1) + 0;
            startZ = rand.nextInt((depth-1 - 0) + 1) + 0;
        }
        while (true){
            if(newMaze.getMap()[endZ][endX][column-2]== 0)
                break;
            if (endZ +1 <= depth-1){
                if (newMaze.getMap()[endZ+1][endX][column-1]== 0)
                    break;
            }
            if (endZ -1 >= 0){
                if (newMaze.getMap()[endZ-1][endX][column-1]== 0)
                    break;
            }
            endX = rand.nextInt((row-1 - 0) + 1) + 0;
            endZ = rand.nextInt((depth-1 - 0) + 1) + 0;
        }

        newMaze.getMap()[startZ][startX][0]=0;
        newMaze.getMap()[endZ][endX][column-1]=0;

        newMaze.entrance = new Position3D(startZ,startX,0);
        newMaze.exit = new Position3D(endZ,endX,column-1);
    }
}

