package algorithms.mazeGenerators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmptyMazeGeneratorTest {
    @Test
    public void TestRightDimensions() throws Exception{
        IMazeGenerator mg = new EmptyMazeGenerator();
        Maze maze = mg.generate(45, 21);
        assertEquals(45,maze.getMatrix().length);
        assertEquals(21,maze.getMatrix()[0].length);
    }
    @Test
    public void TestType() throws Exception{
        IMazeGenerator mg = new EmptyMazeGenerator();
        Maze maze = mg.generate(45, 21);
        assertSame(Maze.class, maze.getClass());
    }
    @Test
    public void TestSolveSmallMaze() throws Exception{
        IMazeGenerator mg = new EmptyMazeGenerator();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {mg.generate(1,5);});
        Assertions.assertThrows(IllegalArgumentException.class, () -> {mg.generate(10,-5);});
    }
}
