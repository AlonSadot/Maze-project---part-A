package algorithms.maze3D;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMaze3DGeneratorTest {

    @Test
    public void TestRightDimensions() throws Exception{
        IMaze3DGenerator mg3 = new MyMaze3DGenerator();
        Maze3D maze = mg3.generate(5,7,8);
        assertEquals(5,maze.getMap().length);
        assertEquals(7,maze.getMap()[0].length);
        assertEquals(8,maze.getMap()[0][0].length);
    }

    @Test
    public void TestType() throws Exception{
        IMaze3DGenerator mg3 = new MyMaze3DGenerator();
        Maze3D maze = mg3.generate(5,7,8);;
        assertSame(Maze3D.class, maze.getClass());
    }

    @Test
    public void TestSolveSmallMaze() throws Exception{
        IMaze3DGenerator mg3 = new MyMaze3DGenerator();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {mg3.generate(1,6,17);});
        Assertions.assertThrows(IllegalArgumentException.class, () -> {mg3.generate(-6,6,9);});
        Assertions.assertThrows(IllegalArgumentException.class, () -> {mg3.generate(6,6,0);});
    }


}