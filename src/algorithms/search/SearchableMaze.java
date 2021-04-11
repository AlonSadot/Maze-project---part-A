package algorithms.search;
import algorithms.mazeGenerators.Position;
import algorithms.mazeGenerators.Maze;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable{
    Maze maze;
    MazeState startState;
    MazeState goalState;

    /**
     * searchable maze constructor
     * @param maze - the maze that the searchable maze is based on
     */
    public SearchableMaze(Maze maze) {
        if (maze == null)
            throw new IllegalArgumentException("Invalid Input");
        this.maze = maze;
        this.startState = new MazeState(maze.getStartPosition(),null,0);
        this.goalState = new MazeState(maze.getGoalPosition(),null,0);
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
        if (state == null)
            throw new IllegalArgumentException("Invalid Input");
        ArrayList<AState> possibleStates = new ArrayList<>();
        Position ms = (Position)state.getObject();

        if (maze.checkUp(ms))
            possibleStates.add(new MazeState(new Position(ms.getRowIndex()-1,ms.getColumnIndex()),state,10));
        if (maze.checkUpRight(ms))
            possibleStates.add(new MazeState(new Position(ms.getRowIndex()-1,ms.getColumnIndex()+1),state,15));
        if (maze.checkRight(ms))
            possibleStates.add(new MazeState(new Position(ms.getRowIndex(),ms.getColumnIndex()+1),state,10));
        if (maze.checkDownRight(ms))
            possibleStates.add(new MazeState(new Position(ms.getRowIndex()+1,ms.getColumnIndex()+1),state,15));
        if (maze.checkDown(ms))
            possibleStates.add(new MazeState(new Position(ms.getRowIndex()+1,ms.getColumnIndex()),state,10));
        if (maze.checkDownLeft(ms))
            possibleStates.add(new MazeState(new Position(ms.getRowIndex()+1,ms.getColumnIndex()-1),state,15));
        if (maze.checkLeft(ms))
            possibleStates.add(new MazeState(new Position(ms.getRowIndex(),ms.getColumnIndex()-1),state,10));
        if (maze.checkUpLeft(ms))
            possibleStates.add(new MazeState(new Position(ms.getRowIndex()-1,ms.getColumnIndex()-1),state,15));

        return possibleStates;
    }


}