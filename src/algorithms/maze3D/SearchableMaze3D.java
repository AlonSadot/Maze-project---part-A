package algorithms.maze3D;

import algorithms.search.AState;
import algorithms.search.ISearchable;

import java.util.ArrayList;

public class SearchableMaze3D implements ISearchable {

    Maze3D maze;
    Maze3DState startState;
    Maze3DState goalState;


    /**
     * searchable maze constructor
     * @param maze - the maze that the searchable maze is based on
     */
    public SearchableMaze3D(Maze3D maze) {
        if (maze == null)
            throw new IllegalArgumentException("Invalid Input");
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


    /**
     * @param state - current state
     * @return returns a list of the possible successors of the given state
     */
    @Override
    public ArrayList<AState> getAllSuccessors(AState state) {

        ArrayList<AState> possibleStates = new ArrayList<>();
        Position3D ms = (Position3D)state.getObject();

        if (maze.checkUp(ms))
            possibleStates.add(new Maze3DState(new Position3D(ms.getDepthIndex(),ms.getRowIndex()-1,ms.getColumnIndex()),state,10));
        if (maze.checkRight(ms))
            possibleStates.add(new Maze3DState(new Position3D(ms.getDepthIndex(),ms.getRowIndex(),ms.getColumnIndex()+1),state,10));
        if (maze.checkDown(ms))
            possibleStates.add(new Maze3DState(new Position3D(ms.getDepthIndex(),ms.getRowIndex()+1,ms.getColumnIndex()),state,10));
        if (maze.checkLeft(ms))
            possibleStates.add(new Maze3DState(new Position3D(ms.getDepthIndex(),ms.getRowIndex(),ms.getColumnIndex()-1),state,10));
        if (maze.checkTop(ms))
            possibleStates.add(new Maze3DState(new Position3D(ms.getDepthIndex()+1,ms.getRowIndex(),ms.getColumnIndex()),state,10));
        if (maze.checkBottom(ms))
            possibleStates.add(new Maze3DState(new Position3D(ms.getDepthIndex()-1,ms.getRowIndex(),ms.getColumnIndex()),state,10));

        return possibleStates;
    }


}
