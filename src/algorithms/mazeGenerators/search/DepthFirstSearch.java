package algorithms.mazeGenerators.search;


import java.util.*;

public class DepthFirstSearch extends ASearchingAlgorithm{

    private Stack<AState> stack;

    public DepthFirstSearch() {
        this.stack = new Stack<>();
        this.visitedStates =0;
        this.name = "Depth First Search";
        this.visited = new HashMap<String,AState>();
    }

    @Override
    public Solution solve(ISearchable domain) {
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
