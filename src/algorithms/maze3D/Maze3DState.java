package algorithms.maze3D;

import algorithms.search.*;



public class Maze3DState extends AState {


    /**
     * @param position - state's current position
     * @param state - the current AState
     * @param cost - the state's cost
     */
    public Maze3DState(Position3D position, AState state, double cost) {
        if (position == null){
            throw new IllegalArgumentException("Invalid Input");
        }
        this.object = position;
        this.cameFrom = state;
        this.cost = cost;
    }

    /**
     * @return return's hashCode of the current state
     */
    @Override
    public String getHashCode() {
        String hash = object.toString();
        return hash;
    }


    /**
     * @param other - other state
     * @return - returns if this state is equal to the other
     */
    @Override
    public boolean equals(AState other) {
        if (other == null ){
            throw new IllegalArgumentException("Invalid Input");
        }
        Position3D a = (Position3D)object;
        Position3D b = (Position3D)other.getObject();
        return a.equals(b);
    }


}
