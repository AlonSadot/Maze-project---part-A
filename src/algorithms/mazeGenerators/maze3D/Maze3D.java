package algorithms.mazeGenerators.maze3D;

import algorithms.mazeGenerators.Position;

public class Maze3D {
    Position3D entrance;
    Position3D exit;
    public int[][][] matrix;

    public Maze3D(int depth, int row, int column){

        matrix = new int[depth][row][column];

    }

    public int[][][] getMap(){
        return matrix;
    }

    public Position3D getStartPosition(){
        return entrance;
    }

    public Position3D getGoalPosition(){
        return exit;
    }

    public void print(){

        matrix[getStartPosition().getZ()][getStartPosition().getX()][getStartPosition().getY()] =2;
        matrix[getGoalPosition().getZ()][getGoalPosition().getX()][getGoalPosition().getY()] =3;
        final char WALL_CHAR = '█';
        for (int k=0; k<matrix.length;k++){
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            for (int i=0; i<matrix[0].length; i++){
                for (int j=0; j<matrix[0][0].length; j++){
                    if (matrix[k][i][j] == 1)
                        System.out.print(WALL_CHAR + " ");
                    else if (matrix[k][i][j] == 0)
                        System.out.print(" " + " ");
                    else if (matrix[k][i][j] == 2){
                        System.out.print("S" + " ");
                        matrix[k][i][j]=0;
                    }
                    else if (matrix[k][i][j] == 3){
                        matrix[k][i][j]=0;
                        System.out.print("E" + " ");
                    }
                }
                System.out.println(" ");
            }
        }
    }


    public boolean checkUp(Position3D s){
        if (s.getX() != 0 && matrix[s.getZ()][s.getX()-1][s.getY()]== 0){
            return true;
        }
        return false;
    }

    public boolean checkDown(Position3D s){
        if (s.getX() != matrix[0].length-1 && matrix[s.getZ()][s.getX()+1][s.getY()] == 0){
            return true;
        }
        return false;
    }
    public boolean checkLeft(Position3D s){
        if (s.getY() != 0 && (matrix[s.getZ()][s.getX()][s.getY()-1] == 0)){
            return true;
        }
        return false;
    }
    public boolean checkRight(Position3D s){
        if (s.getY() != matrix[0][0].length-1 && matrix[s.getZ()][s.getX()][s.getY()+1] == 0){
            return true;
        }
        return false;
    }
    public boolean checkTop(Position3D s){
        if (s.getZ() != matrix.length-1 && matrix[s.getZ()+1][s.getX()][s.getY()] == 0){
            return true;
        }
        return false;
    }
    public boolean checkBottom(Position3D s){
        if (s.getZ() != 0 && matrix[s.getZ()-1][s.getX()][s.getY()] == 0){
            return true;
        }
        return false;
    }


}
