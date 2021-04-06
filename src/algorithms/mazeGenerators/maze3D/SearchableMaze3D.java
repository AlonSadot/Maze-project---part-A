package algorithms.mazeGenerators.maze3D;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;
import algorithms.mazeGenerators.search.AState;
import algorithms.mazeGenerators.search.ISearchable;
import algorithms.mazeGenerators.search.MazeState;

import java.util.ArrayList;

public class SearchableMaze3D implements ISearchable {

    Maze3D maze;
    Maze3DState startState;
    Maze3DState goalState;

    public SearchableMaze3D(Maze3D maze) {
        this.maze = maze;
        this.startState = new Maze3DState(maze.getStartPosition(),null,0);
        this.goalState = new Maze3DState(maze.getGoalPosition(),null,0);
    }

    @Override
    public AState getStartState() {
        return startState;
    }

    @Override
    public AState getGoalState() {
        return goalState;
    }

    @Override
    public ArrayList<AState> getAllSuccessors(AState state) {

        ArrayList<AState> possibleStates = new ArrayList<>();
        Position3D ms = (Position3D)state.getObject();

        if (maze.checkUp(ms))
            possibleStates.add(new Maze3DState(new Position3D(ms.getZ(),ms.getX()-1,ms.getY()),state,10));
        if (maze.checkRight(ms))
            possibleStates.add(new Maze3DState(new Position3D(ms.getZ(),ms.getX(),ms.getY()+1),state,10));
        if (maze.checkDown(ms))
            possibleStates.add(new Maze3DState(new Position3D(ms.getZ(),ms.getX()+1,ms.getY()),state,10));
        if (maze.checkLeft(ms))
            possibleStates.add(new Maze3DState(new Position3D(ms.getZ(),ms.getX(),ms.getY()-1),state,10));
        if (maze.checkTop(ms))
            possibleStates.add(new Maze3DState(new Position3D(ms.getZ()+1,ms.getX(),ms.getY()),state,10));
        if (maze.checkBottom(ms))
            possibleStates.add(new Maze3DState(new Position3D(ms.getZ()-1,ms.getX(),ms.getY()),state,10));

        return possibleStates;
    }


}
