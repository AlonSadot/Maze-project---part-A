package algorithms.search;
import java.util.ArrayList;

public interface ISearchable {

    AState getStartState();

    AState getGoalState();

    public ArrayList<AState> getAllSuccessors(AState state);

}
