package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState {

    /**
     * maze state constructor
     * @param position - position of the state
     * @param state - the current state
     * @param cost - cost of the current state
     */
    public MazeState(Position position,AState state, double cost) {
        if (position == null)
            throw new IllegalArgumentException("Invalid Input");
        this.object = position;
        this.cameFrom = state;
        this.cost = cost;
    }

    @Override
    public String getHashCode() {
        String hash = object.toString();
        return hash;
    }

    /**
     * @param other - other AState
     * @return - returns if this state is equal to the other
     */
    @Override
    public boolean equals(AState other) {
        if (other == null)
            throw new IllegalArgumentException("Invalid Input");
        Position a = (Position)object;
        Position b = (Position)other.getObject();
        return a.equals(b);
    }

}

