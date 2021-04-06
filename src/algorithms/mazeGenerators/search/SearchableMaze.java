package algorithms.mazeGenerators.search;
import algorithms.mazeGenerators.Position;
import algorithms.mazeGenerators.Maze;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable{
    Maze maze;
    MazeState startState;
    MazeState goalState;

    public SearchableMaze(Maze maze) {
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

    @Override
    public ArrayList<AState> getAllSuccessors(AState state) {

        ArrayList<AState> possibleStates = new ArrayList<>();
        Position ms = (Position)state.getObject();

        if (maze.checkUp(ms))
            possibleStates.add(new MazeState(new Position(ms.getX()-1,ms.getY()),state,10));
        if (maze.checkUpRight(ms))
            possibleStates.add(new MazeState(new Position(ms.getX()-1,ms.getY()+1),state,15));
        if (maze.checkRight(ms))
            possibleStates.add(new MazeState(new Position(ms.getX(),ms.getY()+1),state,10));
        if (maze.checkDownRight(ms))
            possibleStates.add(new MazeState(new Position(ms.getX()+1,ms.getY()+1),state,15));
        if (maze.checkDown(ms))
            possibleStates.add(new MazeState(new Position(ms.getX()+1,ms.getY()),state,10));
        if (maze.checkDownLeft(ms))
            possibleStates.add(new MazeState(new Position(ms.getX()+1,ms.getY()-1),state,15));
        if (maze.checkLeft(ms))
            possibleStates.add(new MazeState(new Position(ms.getX(),ms.getY()-1),state,10));
        if (maze.checkUpLeft(ms))
            possibleStates.add(new MazeState(new Position(ms.getX()-1,ms.getY()-1),state,15));

        return possibleStates;
    }


}