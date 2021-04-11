package algorithms.maze3D;

public class Maze3D {
    Position3D entrance;
    Position3D exit;
    private int[][][] matrix;

    /**
     * @param depth - maze's depth
     * @param row - number of the maze's rows
     * @param column- number of the maze's columns
     */
    public Maze3D(int depth, int row, int column){
        if (row < 2 || column < 2 || depth < 2)
            throw new IllegalArgumentException("Invalid Maze Dimensions input");
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

    /**
     * Prints the 3D maze
     */
    public void print(){
        System.out.println("{");
        for(int depth = 0; depth < matrix.length; depth++){
            for(int row = 0; row < matrix[0].length; row++) {
                System.out.print("{ ");
                for (int col = 0; col < matrix[0][0].length; col++) {
                    if (depth == entrance.getDepthIndex() && row == entrance.getRowIndex() && col == entrance.getColumnIndex()) // if the position is the start - mark with S
                        System.out.print("S ");
                    else {
                        if (depth == exit.getDepthIndex() && row == exit.getRowIndex() && col == exit.getColumnIndex()) // if the position is the goal - mark with E
                            System.out.print("E ");
                        else
                            System.out.print(matrix[depth][row][col] + " ");
                    }
                }
                System.out.println("}");
            }
            if(depth < matrix.length - 1) {
                System.out.print("---");
                for (int i = 0; i < matrix[0][0].length; i++)
                    System.out.print("--");
                System.out.println();
            }
        }
        System.out.println("}");
    }

    /*
    // Function below are indicators of the possible neighbors
    */
    public boolean checkUp(Position3D s){
        if (s.getRowIndex() != 0 && matrix[s.getDepthIndex()][s.getRowIndex()-1][s.getColumnIndex()]== 0){
            return true;
        }
        return false;
    }

    public boolean checkDown(Position3D s){
        if (s.getRowIndex() != matrix[0].length-1 && matrix[s.getDepthIndex()][s.getRowIndex()+1][s.getColumnIndex()] == 0){
            return true;
        }
        return false;
    }
    public boolean checkLeft(Position3D s){
        if (s.getColumnIndex() != 0 && (matrix[s.getDepthIndex()][s.getRowIndex()][s.getColumnIndex()-1] == 0)){
            return true;
        }
        return false;
    }
    public boolean checkRight(Position3D s){
        if (s.getColumnIndex() != matrix[0][0].length-1 && matrix[s.getDepthIndex()][s.getRowIndex()][s.getColumnIndex()+1] == 0){
            return true;
        }
        return false;
    }
    public boolean checkTop(Position3D s){
        if (s.getDepthIndex() != matrix.length-1 && matrix[s.getDepthIndex()+1][s.getRowIndex()][s.getColumnIndex()] == 0){
            return true;
        }
        return false;
    }
    public boolean checkBottom(Position3D s){
        if (s.getDepthIndex() != 0 && matrix[s.getDepthIndex()-1][s.getRowIndex()][s.getColumnIndex()] == 0){
            return true;
        }
        return false;
    }


}
