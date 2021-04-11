package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm{

    protected Queue<AState> queue;

    /**
     * BreadthFirstSearch constructor
     */
    public BreadthFirstSearch() {
        this.queue = new LinkedList<>();
        this.visitedStates = 0;
        this.name = "Breadth First Search";
        this.visited = new HashMap<>();
    }

    /**
     * @param domain - the searchable domain
     * @return - returns the solution. if no solution found - returns null
     * based on the BFS algorithm
     */
    @Override
    public Solution solve(ISearchable domain) {
        if (domain == null)
            throw new IllegalArgumentException("Invalid Input");
        AState state;
        visited.put(domain.getStartState().getHashCode(), domain.getStartState());
        this.queue.add(domain.getStartState());
        ArrayList<AState> possibleStates;

        while(!this.queue.isEmpty()){
            state = this.queue.poll();
            visitedStates++;
            if ((state.object.toString().equals((domain.getGoalState().object).toString()))){
                return getSolution(state,domain);
            }
            possibleStates = domain.getAllSuccessors(state);
            checkPossibleStates(possibleStates, visited, null, queue);
        }
        return null; // returns null if no solution
    }

}

