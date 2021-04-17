package algorithms.search;

import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchableMazeTest {

    @Test
    void getStartState() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze = mg.generate(21, 21);
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        assertSame(searchableMaze.getStartState().getClass(), MazeState.class);
    }

    @Test
    void getGoalState() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze = mg.generate(21, 21);
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        assertSame(searchableMaze.getGoalState().getClass(), MazeState.class);
    }
}