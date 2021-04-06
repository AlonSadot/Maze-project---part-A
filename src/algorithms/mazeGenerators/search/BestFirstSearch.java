package algorithms.mazeGenerators.search;

import java.util.HashMap;
import java.util.PriorityQueue;

public class BestFirstSearch extends BreadthFirstSearch{

    public BestFirstSearch() {
        this.queue = new PriorityQueue<>((o1, o2) -> (int)(o1.getCost()-o2.getCost()));
        this.visitedStates = 0;
        this.name = "Best First Search";
        this.visited = new HashMap<>();
    }
}