package algorithms.mazeGenerators.search;

public interface ISearchingAlgorithm {

    Solution solve(ISearchable domain);

    String getName();

    int getNumberOfNodesEvaluated();

}
