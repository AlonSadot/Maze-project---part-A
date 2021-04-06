package test;
import algorithms.mazeGenerators.*;
import algorithms.mazeGenerators.maze3D.IMazeGenerator3D;
import algorithms.mazeGenerators.maze3D.Maze3D;
import algorithms.mazeGenerators.maze3D.MyMaze3DGenerator;
import algorithms.mazeGenerators.maze3D.SearchableMaze3D;
import algorithms.mazeGenerators.search.*;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
//        IMazeGenerator mg = new MyMazeGenerator();
//        Maze maze = mg.generate(21, 100);
//        maze.printWITHSTYLE();
        //maze.printWITHSTYLE();
//        for (int i=0 ; i< 15 ; i ++){
//            for (int j =0 ; j < 25; j ++){
//                System.out.print(mg.measureAlgorithmTimeMillis(500,500) + " , ");
//            }
//            System.out.println("");
//        }

        IMazeGenerator3D mg3 = new MyMaze3DGenerator();

        Maze3D maze = mg3.generate(500,500,500);
        long startTime = System.currentTimeMillis();

        SearchableMaze3D searchableMaze = new SearchableMaze3D(maze);
        //solveProblem(searchableMaze, new BreadthFirstSearch());
        solveProblem(searchableMaze, new DepthFirstSearch());
        //solveProblem(searchableMaze, new BestFirstSearch());
        long stopTime  = System.currentTimeMillis();
        System.out.println( stopTime - startTime);

    }
    private static void solveProblem(ISearchable domain, ISearchingAlgorithm searcher) {
        Solution solution = searcher.solve(domain);
        System.out.println(String.format("'%s' algorithm - nodes evaluated: %s", searcher.getName(), searcher.getNumberOfNodesEvaluated()));
        System.out.println("Solution path:");

        ArrayList<AState> solutionPath = solution.getSolutionPath();
        for (int i = 0; i < solutionPath.size(); i++) {
            System.out.println(String.format("%s. %s",i,solutionPath.get(i)));
        }
    }
}