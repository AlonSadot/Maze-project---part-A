package algorithms.mazeGenerators.maze3D;

import algorithms.mazeGenerators.search.*;



public class Maze3DState extends AState {

    public Maze3DState(Position3D position, AState state, double cost) {
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
        Position3D a = (Position3D)object;
        Position3D b = (Position3D)other.getObject();
        return a.equals(b);
    }


}
