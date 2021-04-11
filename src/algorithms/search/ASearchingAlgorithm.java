package algorithms.search;

import java.util.*;
public abstract class ASearchingAlgorithm implements ISearchingAlgorithm {

    protected int visitedStates;
    protected String name;

    protected HashMap<String,AState> visited;

    public int getNumberOfNodesEvaluated() {return visitedStates;}

    public String getName() {return name;}

    /**
     * @param possibleStates - array of possible states
     * @param visited - hashMap of visited states
     * @param stack - stack of states (can be null)
     * @param queue - queue of states (can be null)
     * function adds possible states to the stack\queue
     */
    public void checkPossibleStates(ArrayList<AState> possibleStates, HashMap<String,AState> visited , Stack<AState> stack, Queue<AState> queue){
        if (possibleStates == null || visited == null || (stack == null && queue == null))
            throw new IllegalArgumentException("Invalid Maze Dimensions Input");
        if (!possibleStates.isEmpty()){
            for (AState s : possibleStates){
                if (!visited.containsKey(s.getHashCode())){
                    s.setCost(s.getCost() + s.cameFrom.getCost());
                    if (stack!= null)
                        stack.add(s);
                    if (queue!=null)
                        queue.add(s);
                    visited.put(s.getHashCode(),s);
                }
            }
        }
    }


    /**
     * @param bingo - final state in seasrch
     * @param domain - the searchable domain
     * @return returns the solution of the maze
     */
    protected Solution getSolution(AState bingo, ISearchable domain){
        if (bingo == null || domain == null)
            throw new IllegalArgumentException("Invalid Input");
        ArrayList<AState> solution = new ArrayList<>();
        while(!domain.getStartState().equals(bingo)) {
            solution.add((bingo));
            bingo = bingo.getCameFrom();
        }
        solution.add((bingo));
        Collections.reverse(solution);
        Solution finalSolution = new Solution(solution);
        return finalSolution;
    }

}
