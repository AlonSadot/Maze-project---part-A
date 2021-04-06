
package algorithms.mazeGenerators;


import algorithms.mazeGenerators.maze3D.Position3D;

public class Maze {
    Position entrance;
    Position exit;
    public int[][] matrix;
    public Maze(int row, int column) {
        matrix = new int[row][column];
    }

    public Position getStartPosition() {
        return entrance;
    }

    public Position getGoalPosition() {
        return exit;
    }


    public void printWITHSTYLE(){
        final char WALL_CHAR = '█';
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (matrix[i][j] == 1)
                    System.out.print(WALL_CHAR + " ");
                else if (matrix[i][j] == 0)
                    System.out.print(" " + " ");
                else if (matrix[i][j] == 2){
                    System.out.print("S" + " ");
                    matrix[i][j]=0;
                }
                else if (matrix[i][j] == 3){
                    matrix[i][j]=0 ;
                    System.out.print("E" + " ");
                }
                else{
                    System.out.print("*" + " ");
                    matrix[i][j]=0;
                }

            }
            System.out.println(" ");
        }
    }
    public void print(){
        int[][] temp = matrix;
        temp[entrance.getX()][entrance.getY()]=2;
        temp[exit.getX()][exit.getY()]=3;
        String body = "";
        for (int[] r : matrix){
            body += "{";
            for (int i : r){
                body += " ";
                if (i != 2 && i != 3)
                    body += i;
                else if (i == 2){
                    body += "S";
                }
                else{
                    temp[exit.getX()][exit.getY()]=0;
                    body += "E";
                }
            }
            body += " ";
            body += "}";
            body+="\n";
        }
        System.out.println(body);
    }



    public boolean checkUp(Position s){
        if (s.getX() != 0 && matrix[s.getX()-1][s.getY()]== 0){
            return true;
        }
        return false;
    }

    public boolean checkDown(Position s){
        if (s.getX() != matrix.length-1 && matrix[s.getX()+1][s.getY()] == 0){
            return true;
        }
        return false;
    }

    public boolean checkLeft(Position s){
        if (s.getY() != 0 && (matrix[s.getX()][s.getY()-1] == 0)){
            return true;
        }
        return false;
    }

    public boolean checkRight(Position s){
        if (s.getY() != matrix[0].length-1 && matrix[s.getX()][s.getY()+1] == 0){
            return true;
        }
        return false;
    }


    public boolean checkUpLeft(Position s) {
        if ((checkUp(s) || checkLeft(s)) && s.getX() != 0 && s.getY() != 0 &&
                matrix[s.getX()-1][s.getY()-1] == 0) {
            return true;
        }
        return false;
    }

    public boolean checkDownLeft(Position s) {
        if ((checkDown(s) || checkLeft(s)) && s.getX() != matrix.length-1 && s.getY() != 0 &&
                matrix[s.getX()+1][s.getY()-1] == 0) {
            return true;
        }
        return false;
    }

    public boolean checkUpRight(Position s) {
        if ((checkUp(s) || checkRight(s)) && s.getX() != 0 && s.getY() != matrix[0].length-1 &&
                matrix[s.getX()-1][s.getY()+1] == 0) {
            return true;
        }
        return false;
    }

    public boolean checkDownRight(Position s) {
        if ((checkDown(s) || checkRight(s)) && s.getX() != matrix.length-1 && s.getY() != matrix[0].length-1 &&
                matrix[s.getX()+1][s.getY()+1] == 0) {
            return true;
        }
        return false;
    }


}
