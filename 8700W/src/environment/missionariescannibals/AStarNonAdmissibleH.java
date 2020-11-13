package environment.missionariescannibals;

import aima.core.search.informed.*;
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
import aima.core.search.framework.qsearch.QueueSearch;
import aima.core.search.framework.qsearch.TreeSearch;
import aima.core.search.informed.AStarSearch;

public class AStarNonAdmissibleH {

	public static void main(String[] args) {
		EightPuzzleBoard board = new EightPuzzleBoard(new int[] { 7, 1, 8,
				0, 4, 6, 2, 3, 5 });

		Problem<EightPuzzleBoard, Action> problem = new BidirectionalEightPuzzleProblem(board);
		AStarSearch<EightPuzzleBoard, Action> search = new AStarSearch<>(new GraphSearch<>(), EightPuzzleFunctions::getManhattanDistance);
		SearchAgent<EightPuzzleBoard, Action> agent = new SearchAgent<>(problem, search);
	}
}
