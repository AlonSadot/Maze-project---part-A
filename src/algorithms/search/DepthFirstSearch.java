package algorithms.search;


import java.util.*;

public class DepthFirstSearch extends ASearchingAlgorithm{

    private Stack<AState> stack;

    /**
     * DepthFirstSearch constructor
     */
    public DepthFirstSearch() {
        this.stack = new Stack<>();
        this.visitedStates =0;
        this.name = "Depth First Search";
        this.visited = new HashMap<String,AState>();
    }

    /**
     * @param domain - the searchable domain
     * @return - return the solution of the search, returns null if no solution exists
     * based on the DFS algorithm
     */
    @Override
    public Solution solve(ISearchable domain) {
        if (domain == null)
            throw new IllegalArgumentException("Invalid Input");
        stack.push(domain.getStartState());
        AState state;
        ArrayList<AState> possibleStates;
        while(!stack.isEmpty()){
            state = stack.pop();
            if ((state.object.toString().equals((domain.getGoalState().object).toString()))){
                return getSolution(state,domain);
            }
            visited.put(state.getHashCode(),state);
            visitedStates++;
            possibleStates = domain.getAllSuccessors(state);
            checkPossibleStates(possibleStates,visited, stack,null);
        }
        return null;
    }
}
