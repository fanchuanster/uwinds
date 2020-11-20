package assignment2;

import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.environment.eightpuzzle.BidirectionalEightPuzzleProblem;
import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.environment.eightpuzzle.EightPuzzleFunctions;
import aima.core.search.agent.SearchAgent;
import aima.core.search.framework.problem.Problem;
import aima.core.search.local.HillClimbingSearch;
import aima.core.search.local.SimulatedAnnealingSearch;

public class EightPuzzleDemo {
	
	static Set<EightPuzzleBoard> usedBoards = new HashSet<EightPuzzleBoard>();
	
	static EightPuzzleBoard getUniqueEightPuzzleState() {
		EightPuzzleBoard board = null;
		while (board == null) {
//			board = new EightPuzzleBoard(Util.getRandomEightPuzzleState());
			board = new EightPuzzleBoard(new int[] {1,0,2,3,4,5,6,7,8 });
			if (usedBoards.contains(board)) {
//				System.out.println("usedBoards size:" + usedBoards.size());
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
				Problem<EightPuzzleBoard, Action> problem = new BidirectionalEightPuzzleProblem(initialState);
				SimulatedAnnealingSearch<EightPuzzleBoard, Action> search = new SimulatedAnnealingSearch<>(EightPuzzleFunctions::getManhattanDistance);
				SearchAgent<Object, EightPuzzleBoard, Action> agent = new SearchAgent<>(problem, search);
//				printActions(agent.getActions());
				System.out.println("Final State:\n" + search.getLastState());
				printInstrumentation(agent.getInstrumentation());
				if (search.getLastState().equals(EightPuzzleFunctions.GOAL_STATE)) {
					System.out.println("===============succeeded==============================:\n" + i);
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void eightPuzzleHillClimbingSearchDemo() {
		System.out.println("\nEightPuzzleDemo HillClimbingSearch");
		for (int i=0; i<10000000; i++) {
			
			EightPuzzleBoard initialState = getUniqueEightPuzzleState();
			System.out.println("Initial State:\n" + initialState.toString());
			try {
				Problem<EightPuzzleBoard, Action> problem = new BidirectionalEightPuzzleProblem(initialState);
				HillClimbingSearch<EightPuzzleBoard, Action> search = new HillClimbingSearch<>(EightPuzzleFunctions::getManhattanDistance);
				SearchAgent<Object, EightPuzzleBoard, Action> agent = new SearchAgent<>(problem, search);
				printActions(agent.getActions());
				System.out.println("Final State:\n" + search.getLastState());
				printInstrumentation(agent.getInstrumentation());
				if (search.getLastState().equals(EightPuzzleFunctions.GOAL_STATE)) {
					System.out.println("===============succeeded==============================:\n" + i);
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("\nEightPuzzleDemo done");
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
