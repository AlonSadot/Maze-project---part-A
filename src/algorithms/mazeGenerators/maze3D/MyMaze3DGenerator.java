package algorithms.mazeGenerators.maze3D;

import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;
import algorithms.mazeGenerators.MyMazeGenerator;

import java.util.ArrayList;
import java.util.Random;

public class MyMaze3DGenerator extends AMaze3DGenerator{

    @Override
    public Maze3D generate(int depth, int row, int column) {

        Random rand = new Random();
        int y,x;
        x = (int) (rand.nextInt((int) (row*0.75 - row*0.25) + 1) + row*0.25);
        y = (int) (rand.nextInt((int) (column*0.75 - column*0.25) + 1) + column*0.25);

        Maze3D newMaze = new Maze3D(depth,row,column);
        MyMazeGenerator mg = new MyMazeGenerator();
        newMaze.matrix[0] = mg.generateMuff(row,column,x,y).matrix;
        for(int i=1; i<depth;i++){
            if (i%2==1){
                newMaze.matrix[i] = generateWallLevel(row, column,x,y);
            }
            else{
                newMaze.matrix[i] = mg.generateMuff(row,column,x,y).matrix;
                x = rand.nextInt((row-1 - 0) + 1) + 0;
                y = rand.nextInt((column-1 - 0) + 1) + 0;
                while (true){
                    if(newMaze.matrix[i][x][y] == 0)
                        break;
                    x = rand.nextInt((row-1 - 0) + 1) + 0;
                    y = rand.nextInt((column-1 - 0) + 1) + 0;
                }
            }
        }
        generatePositions(depth,row,column,newMaze);
        return newMaze;
    }
    private int[][] generateWallLevel(int row, int column ,int x, int y){
        int[][] matrix = new int[row][column];
        for (int i=0;i<row;i++){
            for (int j=0; j<column;j++){
                matrix[i][j]=1;
            }
        }
        matrix[x][y]=0;
        return matrix;
    }

    private void generatePositions(int depth, int row, int column, Maze3D newMaze){
        Random rand = new Random();
        int startX = rand.nextInt(((row-1) - 1) + 1) + 1;
        int startZ = rand.nextInt(((depth-1) - 1) + 1) + 1;
        int endX = rand.nextInt(((row-1) - 1) + 1) + 1;
        int endZ = rand.nextInt(((depth-1) - 1) + 1) + 1;

        while (true){
            if(newMaze.matrix[startZ][startX][1] == 0  && startZ%2==0 && startZ != endZ)
                break;
            if (startZ +1 <= depth-1  && startZ%2==0 && startZ != endZ){
                if (newMaze.matrix[startZ+1][startX][0]== 0 )
                    break;
            }
            if (startZ -1 >= 0 && startZ%2==0 && startZ != endZ){
                if (newMaze.matrix[startZ-1][startX][0]== 0 )
                    break;
            }
            startX = rand.nextInt((row-1 - 0) + 1) + 0;
            startZ = rand.nextInt((depth-1 - 0) + 1) + 0;
        }
        while (true){
            if(newMaze.matrix[endZ][endX][column-2]== 0 && endZ%2==0 && startZ != endZ)
                break;
            if (endZ +1 <= depth-1 && endZ%2==0 && startZ != endZ){
                if (newMaze.matrix[endZ+1][endX][column-1]== 0)
                    break;
            }
            if (endZ -1 >= 0 && endZ%2==0 && startZ != endZ){
                if (newMaze.matrix[endZ-1][endX][column-1]== 0)
                    break;
            }
            endX = rand.nextInt((row-1 - 0) + 1) + 0;
            endZ = rand.nextInt((depth-1 - 0) + 1) + 0;
        }

//        newMaze.matrix[startZ][startX][0]=0;
//        newMaze.matrix[endZ][endX][column-1]=0;


        newMaze.entrance = new Position3D(startZ,startX,0);
        newMaze.exit = new Position3D(endZ,endX,column-1);
    }


//    @Override
//    public Maze3D generate(int depth, int row, int column) {
//
//        ArrayList<int[]> wallList = new ArrayList<>();
//
//        Random rand = new Random();
//        Maze3D newMaze = new Maze3D(depth, row, column);
//
//
//        for (int i=0;i<depth;i++){
//            for (int j=0; j<row;j++){
//                for (int k=0;k<column;k++){
//                    newMaze.matrix[i][j][k]=3;
//                }
//            }
//        }
//
//        int z,y,x;
//        z = (int) (rand.nextInt((int) (depth*0.75 - depth*0.25) + 1) + depth*0.25);
//        x = (int) (rand.nextInt((int) (row*0.75 - row*0.25) + 1) + row*0.25);
//        y = (int) (rand.nextInt((int) (column*0.75 - column*0.25) + 1) + column*0.25);
//        Position3D startPos= new Position3D(z,x,y);
//        newMaze.matrix[z][x][y]=0; // THIS IS THE STARTING POINT
//        addNeighbors(newMaze,z,x,y,depth, row,column ,wallList,1);
//
//        int[] randomPoint , randomNeighbor;
//
//        ArrayList<int[]> currNeighbors = new ArrayList<>();
//
//        while (!wallList.isEmpty() ) {
//
//            randomPoint = wallList.remove(rand.nextInt(wallList.size()));
//
//            addNeighbors(newMaze,randomPoint[0],randomPoint[1],randomPoint[2],depth, row,column ,currNeighbors,0);
//            randomNeighbor = currNeighbors.get(rand.nextInt(currNeighbors.size()));
//
//            newMaze.matrix[randomPoint[0] + (randomNeighbor[0] - randomPoint[0])/2][randomPoint[1] + (randomNeighbor[1] - randomPoint[1])/2][randomPoint[2] + (randomNeighbor[2] - randomPoint[2])/2]=0;
//            newMaze.matrix[randomPoint[0]][randomPoint[1]][randomPoint[2]]=0;
//
//            currNeighbors.clear();
//            addNeighbors(newMaze,randomPoint[0],randomPoint[1],randomPoint[2],depth, row,column ,wallList,1);
//        }
//
//        Finalize(newMaze,depth,row,column);
//
//        return newMaze;
//    }
//
//    public void addNeighbors(Maze3D maze,int z , int x, int y ,int depth, int row, int column , ArrayList<int[]> list, int state) {
//        if (x + 2 <= row - 1 ) {
//            if (maze.matrix[z][x + 2][y] == state+2  || (state == 0 && maze.matrix[z][x + 2][y] == state)) {
//                list.add(new int[]{z,x + 2,y});
//                if (state != 0)
//                    maze.matrix[z][x + 2][y]-=2;
//            }
//        }
//        if (x - 2 >= 0) {
//            if (maze.matrix[z][x - 2][y] == state+2 || (state == 0 && maze.matrix[z][x - 2][y] == state)) {
//                list.add(new int[]{z,x - 2,y});
//                if (state != 0)
//                    maze.matrix[z][x - 2][y]-=2;
//            }
//        }
//        if (y + 2 <= column - 1) {
//            if (maze.matrix[z][x][y + 2] == state+2 || (state == 0 && maze.matrix[z][x][y+ 2] == state)) {
//                list.add(new int[]{z,x,y + 2});
//                if (state != 0)
//                    maze.matrix[z][x][y + 2]-=2;
//            }
//        }
//        if (y - 2 >= 0) {
//            if (maze.matrix[z][x][y - 2] == state+2 || (state == 0 && maze.matrix[z][x][y- 2] == state)) {
//                list.add(new int[]{z,x,y - 2});
//                if (state != 0)
//                    maze.matrix[z][x][y - 2]-=2;
//            }
//        }
//        if (z - 2 >= 0) {
//            if (maze.matrix[z-2][x][y] == state+2 || (state == 0 && maze.matrix[z - 2][x][y] == state)) {
//                list.add(new int[]{z - 2,x,y});
//                if (state != 0)
//                    maze.matrix[z - 2][x][y]-=2;
//            }
//        }
//        if (z + 2 <= depth - 1) {
//            if (maze.matrix[z+ 2][x][y ] == state+2 || (state == 0 && maze.matrix[z+ 2][x][y] == state)) {
//                list.add(new int[]{z+2,x,y});
//                if (state != 0)
//                    maze.matrix[z+ 2][x][y]-=2;
//            }
//        }
//    }
//    public void Finalize(Maze3D newMaze, int depth, int row, int column){
//
//        for (int i=0;i<depth;i++){
//            for (int j=0; j<row;j++){
//                for (int k=0;k<column;k++){
//                    if (newMaze.matrix[i][j][k]==3)
//                        newMaze.matrix[i][j][k]=1;
//                }
//            }
//        }
//
//        Random rand = new Random();
//        int startX = rand.nextInt(((row-1) - 1) + 1) + 1;
//        int startZ = rand.nextInt(((depth-1) - 1) + 1) + 1;
//        int endX = rand.nextInt(((row-1) - 1) + 1) + 1;
//        int endZ = rand.nextInt(((depth-1) - 1) + 1) + 1;
//
//        while (true){
//            if(newMaze.matrix[startZ][startX][1] == 0)
//                break;
//            if (startZ +1 <= depth-1){
//                if (newMaze.matrix[startZ+1][startX][0]== 0 )
//                    break;
//            }
//            if (startZ -1 >= 0){
//                if (newMaze.matrix[startZ-1][startX][0]== 0 )
//                    break;
//            }
//            startX = rand.nextInt((row-1 - 0) + 1) + 0;
//            startZ = rand.nextInt((depth-1 - 0) + 1) + 0;
//        }
//        while (true){
//            if(newMaze.matrix[endZ][endX][column-2]== 0)
//                break;
//            if (endZ +1 <= depth-1){
//                if (newMaze.matrix[endZ+1][endX][column-1]== 0)
//                    break;
//            }
//            if (endZ -1 >= 0){
//                if (newMaze.matrix[endZ-1][endX][column-1]== 0)
//                    break;
//            }
//            endX = rand.nextInt((row-1 - 0) + 1) + 0;
//            endZ = rand.nextInt((depth-1 - 0) + 1) + 0;
//        }
//
//        newMaze.matrix[startZ][startX][0]=2;
//        newMaze.matrix[endZ][endX][column-1]=3;
//
//        newMaze.entrance = new int[]{startZ,startX,0};
//        newMaze.exit = new int[]{endZ,endX,column-1};
//    }
}


