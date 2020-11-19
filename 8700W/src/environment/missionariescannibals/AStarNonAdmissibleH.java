package environment.missionariescannibals;

import aima.core.search.informed.*;

import java.util.List;
import java.util.Optional;

import aima.core.agent.Action;
import aima.core.environment.eightpuzzle.BidirectionalEightPuzzleProblem;
import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.environment.eightpuzzle.EightPuzzleFunctions;
import aima.core.environment.map.*;
import aima.core.search.framework.Node;
import aima.core.search.agent.SearchAgent;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.problem.GeneralProblem;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.informed.AStarSearch;
import aima.core.util.datastructure.XYLocation;

public class AStarNonAdmissibleH {

	public static final EightPuzzleBoard GOAL_STATE = new EightPuzzleBoard(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 });
	public static double getHeuristicDistance(Node<EightPuzzleBoard, Action> node) {
		EightPuzzleBoard currState = node.getState();
		int result = 0;
		for (int val = 1; val <= 8; val++) {
			XYLocation locCurr = currState.getLocationOf(val);
			XYLocation locGoal = GOAL_STATE.getLocationOf(val);
			result += Math.sqrt(Math.abs(locGoal.getX() + locCurr.getX()));
			
			result += Math.sqrt(Math.abs(locGoal.getY() + locCurr.getY()));
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		EightPuzzleBoard board = new EightPuzzleBoard(new int[] { 7, 1, 8, 0, 4, 6, 2, 3, 5 });

		Problem<EightPuzzleBoard, Action> problem = new BidirectionalEightPuzzleProblem(board);
		AStarSearch<EightPuzzleBoard, Action> search = new AStarSearch<>(new GraphSearch<>(), AStarNonAdmissibleH::getHeuristicDistance);
		SearchAgent<Object, EightPuzzleBoard, Action> agent = new SearchAgent<>(problem, search);
		
		Optional<List<Action>> actions = search.findActions(problem);
		actions.ifPresent(qActions -> qActions.forEach(System.out::println));
	    System.out.println(search.getMetrics());
	    System.out.println("\n--- Done ---");
	}
}
