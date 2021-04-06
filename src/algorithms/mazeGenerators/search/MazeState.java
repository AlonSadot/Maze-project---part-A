package algorithms.mazeGenerators.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState {

    public MazeState(Position position,AState state, double cost) {
        this.object = position;
        this.cameFrom = state;
        this.cost = cost;
    }

    @Override
    public String getHashCode() {
        String hash = object.toString();
        return hash;
    }

    @Override
    public boolean equals(AState other) {
        Position a = (Position)object;
        Position b = (Position)other.getObject();
        return a.equals(b);
    }

}

