package environment.missionariescannibals;

import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthFirstSearch;
import aima.core.search.uninformed.DepthLimitedSearch;
import aima.core.agent.Action;
import aima.core.search.framework.problem.GeneralProblem;
import aima.core.search.framework.Node;
import aima.core.search.framework.SearchForActions;
import aima.core.util.datastructure.XYLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.util.function.Predicate;

public class MissionariesCannibalsProblem extends GeneralProblem<MissionariesCannibalsState, MissionariesCannibalsAction> {
	
	/*
	 * number of missionaries, cannibals equals missionaries there is the same.
	 */
	static final int MissionariesNumber = 3;
	static final int ShipCapacity = 2;

	public MissionariesCannibalsProblem(MissionariesCannibalsState initialState) {
		super(initialState, Functions::getActions, Functions::getResult, 
				Functions::testGoal);
	}
	
	private static void missionariesCannibalsBFS() {
		System.out.println("\n--- MissionariesCannibalsProblem BFS ---");

	    Problem<MissionariesCannibalsState, MissionariesCannibalsAction> problem = Functions.createMissionariesCannibalsProblem();
	    SearchForActions<MissionariesCannibalsState, MissionariesCannibalsAction> search = new BreadthFirstSearch<>(new GraphSearch<>());
	    Optional<List<MissionariesCannibalsAction>> actions = search.findActions(problem);

	    actions.ifPresent(qActions -> qActions.forEach(System.out::println));
	    System.out.println(search.getMetrics());
	    System.out.println("\n--- Done ---");
	}
	private static void missionariesCannibalsDFS() {
		System.out.println("\n--- MissionariesCannibalsProblem DFS ---");

	    Problem<MissionariesCannibalsState, MissionariesCannibalsAction> problem = Functions.createMissionariesCannibalsProblem();
	    SearchForActions<MissionariesCannibalsState, MissionariesCannibalsAction> search = new DepthFirstSearch<>(new GraphSearch<>());
	    Optional<List<MissionariesCannibalsAction>> actions = search.findActions(problem);

	    actions.ifPresent(qActions -> qActions.forEach(System.out::println));
	    System.out.println(search.getMetrics());
	    System.out.println("\n--- Done ---");
	}
	private static void missionariesCannibalsDLS() {
		System.out.println("\n--- MissionariesCannibalsProblem DLS ---");

	    Problem<MissionariesCannibalsState, MissionariesCannibalsAction> problem = Functions.createMissionariesCannibalsProblem();
	    DepthLimitedSearch<MissionariesCannibalsState, MissionariesCannibalsAction> search = new DepthLimitedSearch<MissionariesCannibalsState, MissionariesCannibalsAction>(5);
	    Optional<List<MissionariesCannibalsAction>> actions = search.findActions(problem);

	    actions.ifPresent(qActions -> qActions.forEach(System.out::println));
	    System.out.println(search.getMetrics());
	    System.out.println("\n--- Done ---");
	}
	public static void main(String[] args) {
		missionariesCannibalsBFS();
		missionariesCannibalsDFS();
		missionariesCannibalsDLS();
	}
}
