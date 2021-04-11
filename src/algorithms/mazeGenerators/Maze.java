
package algorithms.mazeGenerators;

public class Maze {
    Position entrance;
    Position exit;
    private int[][] matrix;

    /**
     * @param row - number of the maze's rows
     * @param column- number of the maze's columns
     */
    public Maze(int row, int column) {
        if (row < 2 || column < 2)
            throw new IllegalArgumentException("Invalid Maze Dimensions input");
        matrix = new int[row][column];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public Position getStartPosition() {
        return entrance;
    }

    public Position getGoalPosition() {
        return exit;
    }

    /**
     * printing function of the 2D maze
     */
    public void print(){
        int[][] temp = matrix;
        temp[entrance.getRowIndex()][entrance.getColumnIndex()]=2;
        temp[exit.getRowIndex()][exit.getColumnIndex()]=3;
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
                    temp[exit.getRowIndex()][exit.getColumnIndex()]=0;
                    body += "E";
                }
            }
            body += " ";
            body += "}";
            body+="\n";
        }
        System.out.println(body);
    }


    /*
    // Function below are indicators of the possible neighbors
     */
    public boolean checkUp(Position s){
        if (s.getRowIndex() != 0 && matrix[s.getRowIndex()-1][s.getColumnIndex()]== 0){
            return true;
        }
        return false;
    }

    public boolean checkDown(Position s){
        if (s.getRowIndex() != matrix.length-1 && matrix[s.getRowIndex()+1][s.getColumnIndex()] == 0){
            return true;
        }
        return false;
    }

    public boolean checkLeft(Position s){
        if (s.getColumnIndex() != 0 && (matrix[s.getRowIndex()][s.getColumnIndex()-1] == 0)){
            return true;
        }
        return false;
    }

    public boolean checkRight(Position s){
        if (s.getColumnIndex() != matrix[0].length-1 && matrix[s.getRowIndex()][s.getColumnIndex()+1] == 0){
            return true;
        }
        return false;
    }


    public boolean checkUpLeft(Position s) {
        if ((checkUp(s) || checkLeft(s)) && s.getRowIndex() != 0 && s.getColumnIndex() != 0 &&
                matrix[s.getRowIndex()-1][s.getColumnIndex()-1] == 0) {
            return true;
        }
        return false;
    }

    public boolean checkDownLeft(Position s) {
        if ((checkDown(s) || checkLeft(s)) && s.getRowIndex() != matrix.length-1 && s.getColumnIndex() != 0 &&
                matrix[s.getRowIndex()+1][s.getColumnIndex()-1] == 0) {
            return true;
        }
        return false;
    }

    public boolean checkUpRight(Position s) {
        if ((checkUp(s) || checkRight(s)) && s.getRowIndex() != 0 && s.getColumnIndex() != matrix[0].length-1 &&
                matrix[s.getRowIndex()-1][s.getColumnIndex()+1] == 0) {
            return true;
        }
        return false;
    }

    public boolean checkDownRight(Position s) {
        if ((checkDown(s) || checkRight(s)) && s.getRowIndex() != matrix.length-1 && s.getColumnIndex() != matrix[0].length-1 &&
                matrix[s.getRowIndex()+1][s.getColumnIndex()+1] == 0) {
            return true;
        }
        return false;
    }


}
