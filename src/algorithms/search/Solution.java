package algorithms.search;

import java.util.ArrayList;

public class Solution {
    private ArrayList<AState> path;

    /**
     * @param path - the path of the solution
     */
    public Solution(ArrayList<AState> path) {
        if (path == null)
            throw new IllegalArgumentException("Invalid Input");
        this.path = path;
    }
    public ArrayList<AState> getSolutionPath(){
        return path;
    }
}
