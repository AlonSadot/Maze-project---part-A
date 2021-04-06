package algorithms.mazeGenerators.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm{

    protected Queue<AState> queue;

    public BreadthFirstSearch() {
        this.queue = new LinkedList<>();
        this.visitedStates = 0;
        this.name = "Breadth First Search";
        this.visited = new HashMap<>();
    }

    @Override
    public Solution solve(ISearchable domain) {

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

//    public void checkPossibleStatess(ArrayList<AState> possibleStates){
//        if (!possibleStates.isEmpty()){
//            for (AState s : possibleStates){
//                if (!visited.containsKey(s.getHashCode())){
//                    s.setCost(s.getCost() + s.cameFrom.getCost());
//                    this.queue.add(s);
//                    visited.put(s.getHashCode(),s);
//                }
//            }
//        }
//    }

}

