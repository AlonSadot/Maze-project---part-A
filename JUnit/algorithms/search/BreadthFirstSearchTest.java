package algorithms.search;

import algorithms.maze3D.IMaze3DGenerator;
import algorithms.maze3D.Maze3D;
import algorithms.maze3D.MyMaze3DGenerator;
import algorithms.maze3D.SearchableMaze3D;
import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BreadthFirstSearchTest {

    @Test
    public void TestSolveSolution() throws Exception{
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze = mg.generate(21, 21);
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        ISearchingAlgorithm searcher = new BreadthFirstSearch();
        ArrayList<AState> arr = new ArrayList<AState>();
        Solution s = new Solution(arr);
        assertSame(s.getClass(),searcher.solve(searchableMaze).getClass());
    }
    @Test
    public void TestSolve3D() throws Exception{
        IMaze3DGenerator mg3D = new MyMaze3DGenerator();
        Maze3D maze3D = mg3D.generate(21,21, 21);
        SearchableMaze3D searchableMaze3D = new SearchableMaze3D(maze3D);
        ISearchingAlgorithm searcher = new BreadthFirstSearch();
        ArrayList<AState> arr = new ArrayList<AState>();
        Solution s = new Solution(arr);
        assertSame(s.getClass(),searcher.solve(searchableMaze3D).getClass());
    }
    @Test
    public void TestSolveErrorNull() throws Exception{
        ISearchingAlgorithm searcher = new BreadthFirstSearch();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {searcher.solve(null);});
    }
}