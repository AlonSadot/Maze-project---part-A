package algorithms.mazeGenerators.search;

import java.util.*;
public abstract class ASearchingAlgorithm implements ISearchingAlgorithm {

    protected int visitedStates;
    protected String name;

    protected HashMap<String,AState> visited;

    public int getNumberOfNodesEvaluated() {return visitedStates;}

    public String getName() {return name;}

    public void checkPossibleStates(ArrayList<AState> possibleStates, HashMap<String,AState> visited , Stack<AState> stack, Queue<AState> queue){
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


    protected Solution getSolution(AState bingo, ISearchable domain){
        ArrayList<AState> solution = new ArrayList<>();
        while(!domain.getStartState().equals(bingo)) {
            // for drawing
//            String[] huh = bingo.object.toString().split(",");
//            String s1 = huh[0];
//            s1 = (huh[0].substring(1, s1.length()));
//            String s2 = huh[1];
//            s2 = (huh[1].substring(0, s2.length()-1));
//            int x1,x2;
//            x1 = Integer.parseInt(s1);
//            x2 = Integer.parseInt(s2);
//            ((SearchableMaze)domain).maze.matrix[x1][x2]=5;
            // for drawing
            solution.add((bingo));
            bingo = bingo.getCameFrom();
        }
        // for drawing
//        String[] huh = bingo.object.toString().split(",");
//        String s1 = huh[0];
//        s1 = (huh[0].substring(1, s1.length()));
//        String s2 = huh[1];
//        s2 = (huh[1].substring(0, s2.length()-1));
//        int x1,x2;
//        x1 = Integer.parseInt(s1);
//        x2 = Integer.parseInt(s2);
//        ((SearchableMaze)domain).maze.matrix[x1][x2]=5;
        // for drawing
        solution.add((bingo));
        Collections.reverse(solution);
        Solution finalSolution = new Solution(solution);
//        (((SearchableMaze)domain).maze).printWITHSTYLE();
        return finalSolution;
    }

}
