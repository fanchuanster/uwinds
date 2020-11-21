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
	final static int timesMax = 1000;
	
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

	private static int eightPuzzleSimulatedAnnealingDemo() {
		System.out.println("\nEightPuzzleDemo Simulated Annealing Search");
		int succeeded = 0;
		usedBoards.clear();
		for (int i=0; i<timesMax; i++) {
			
			EightPuzzleBoard initialState = getUniqueEightPuzzleState();
//			System.out.println("Initial State:\n" + initialState.toString());
			try {
				Problem problem = new BidirectionalEightPuzzleProblem(initialState);
				SimulatedAnnealingSearch search = new SimulatedAnnealingSearch(new ManhattanHeuristicFunction());
				SearchAgent agent = new SearchAgent(problem, search);
				
				if (problem.isGoalState(search.getLastSearchState())) {
					System.out.println("achieved in: " + i);
					System.out.println("Final State:\n" + search.getLastSearchState());
					printInstrumentation(agent.getInstrumentation());
					succeeded += 1;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("\nEightPuzzleDemo Simulated Annealing Search done");
		return succeeded;
	}
	
	private static int eightPuzzleHillClimbingSearchDemo() {
		System.out.println("\nEightPuzzleDemo HillClimbingSearch");
		int succeeded = 0;
		usedBoards.clear();
		for (int i=0; i<timesMax; i++) {
			
			EightPuzzleBoard initialState = getUniqueEightPuzzleState();
//			System.out.println("Initial State:\n" + initialState.toString());
			try {
				Problem problem = new BidirectionalEightPuzzleProblem(initialState);
				HillClimbingSearch search = new HillClimbingSearch(new ManhattanHeuristicFunction());
				SearchAgent agent = new SearchAgent(problem, search);
//				printActions(agent.getActions());
				
				if (problem.isGoalState(search.getLastSearchState())) {
					System.out.println("achieved in: " + i);
					System.out.println("Final State:\n" + search.getLastSearchState());
					printInstrumentation(agent.getInstrumentation());
					succeeded += 1;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("\nEightPuzzleDemo ClimbingSearchDemo done");
		return succeeded;
	}
	
	private static int eightPuzzleHillClimbingFirstChoiceDemo() {
		System.out.println("\nEightPuzzleDemo HillClimbingSearchFirstChoice");
		int succeeded = 0;
		usedBoards.clear();
		for (int i=0; i<timesMax; i++) {
			
			EightPuzzleBoard initialState = getUniqueEightPuzzleState();
//			System.out.println("Initial State:\n" + initialState.toString());
			try {
				Problem problem = new BidirectionalEightPuzzleProblem(initialState);
				HillClimbingSearch search = new HillClimbingSearchFirstChoice(new ManhattanHeuristicFunction());
				SearchAgent agent = new SearchAgent(problem, search);
//				printActions(agent.getActions());
				
				if (problem.isGoalState(search.getLastSearchState())) {
					System.out.println("Final State:\n" + search.getLastSearchState());
					printInstrumentation(agent.getInstrumentation());
					System.out.println("achieved in: " + i);
					succeeded += 1;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("\nEightPuzzleDemo HillClimbingSearchFirstChoice done");
		return succeeded;
	}
	
	
	private static void printInstrumentation(Properties properties) {
		properties.keySet().stream().map(key -> key + "=" + properties.get(key)).forEach(System.out::println);
	}

	private static void printActions(List<Action> actions) {
		actions.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		int succes = eightPuzzleHillClimbingSearchDemo();
		int successFC = eightPuzzleHillClimbingFirstChoiceDemo();
		int successSA= eightPuzzleSimulatedAnnealingDemo();
		System.out.println("\nSuccess out of " + timesMax + " tries:");
		System.out.println(String.format("HillClimbingSearch: %d", succes));
		System.out.println(String.format("HillClimbing First choice: %d", successFC));
		System.out.println(String.format("SimulatedAnnealing: %d", successSA));
	}

}
