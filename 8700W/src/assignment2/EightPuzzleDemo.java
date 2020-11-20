package assignment2;

import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.environment.eightpuzzle.BidirectionalEightPuzzleProblem;
import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.environment.eightpuzzle.ManhattanHeuristicFunction;
import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.problem.Problem;
import aima.core.search.local.HillClimbingSearch;
import aima.core.search.local.SimulatedAnnealingSearch;

public class EightPuzzleDemo {
	
	static Set<EightPuzzleBoard> usedBoards = new HashSet<EightPuzzleBoard>();
	
	static EightPuzzleBoard getUniqueEightPuzzleState() {
		EightPuzzleBoard board = null;
		while (board == null) {
			board = new EightPuzzleBoard(Util.getRandomEightPuzzleState());
			if (usedBoards.contains(board)) {
				board = null;
			} else {
				usedBoards.add(board);
			}			
		}
		return board;
	}

	private static void eightPuzzleSimulatedAnnealingDemo() {
		System.out.println("\nEightPuzzleDemo Simulated Annealing Search");
		for (int i=0; i<1000; i++) {
			
			EightPuzzleBoard initialState = getUniqueEightPuzzleState();
			System.out.println("Initial State:\n" + initialState.toString());
			try {
				Problem problem = new BidirectionalEightPuzzleProblem(initialState);
				SimulatedAnnealingSearch search = new SimulatedAnnealingSearch(new ManhattanHeuristicFunction());
				SearchAgent agent = new SearchAgent(problem, search);
				System.out.println("Final State:\n" + search.getLastSearchState());
				printInstrumentation(agent.getInstrumentation());

				if (problem.isGoalState(search.getLastSearchState())) {
					System.out.println("achieved in: " + i);
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("\nEightPuzzleDemo Simulated Annealing Search done");
	}
	
	private static void eightPuzzleHillClimbingSearchDemo() {
		System.out.println("\nEightPuzzleDemo HillClimbingSearch");
		for (int i=0; i<1000; i++) {
			
			EightPuzzleBoard initialState = getUniqueEightPuzzleState();
			System.out.println("Initial State:\n" + initialState.toString());
			try {
				Problem problem = new BidirectionalEightPuzzleProblem(initialState);
				HillClimbingSearch search = new HillClimbingSearch(new ManhattanHeuristicFunction());
				SearchAgent agent = new SearchAgent(problem, search);
				printActions(agent.getActions());
				System.out.println("Final State:\n" + search.getLastSearchState());
				printInstrumentation(agent.getInstrumentation());
				if (problem.isGoalState(search.getLastSearchState())) {
					System.out.println("achieved in: " + i);
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("\nEightPuzzleDemo ClimbingSearchDemo done");
	}
	
	
	private static void printInstrumentation(Properties properties) {
		properties.keySet().stream().map(key -> key + "=" + properties.get(key)).forEach(System.out::println);
	}

	private static void printActions(List<Action> actions) {
		actions.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
//		eightPuzzleSimulatedAnnealingDemo();
		eightPuzzleHillClimbingSearchDemo();
	}

}
