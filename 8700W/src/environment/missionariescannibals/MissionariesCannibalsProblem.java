package environment.missionariescannibals;

import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.framework.qsearch.TreeSearch;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthFirstSearch;
import aima.core.search.uninformed.UniformCostSearch;

import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.SearchForActions;

import java.util.List;
import java.util.Optional;

import java.util.function.Predicate;

public class MissionariesCannibalsProblem extends Problem {
	
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
		System.out.println("\n--- BreadthFirstSearch ---");

	    MissionariesCannibalsProblem problem = Functions.createMissionariesCannibalsProblem();
	    SearchForActions search = new BreadthFirstSearch(new GraphSearch());
	    SearchAgent agent = new SearchAgent(problem, search);
	    Optional<List<MissionariesCannibalsAction>> actions = search.findActions(problem);

	    actions.ifPresent(qActions -> qActions.forEach(System.out::println));
	    System.out.println("\n--- actions: ---" + search);
	    System.out.println(search.getMetrics());
	    System.out.println("\n--- Done ---");
	}
	private static void missionariesCannibalsDFS() {
		System.out.println("\n--- DepthFirstSearch ---");

	    Problem<MissionariesCannibalsState, MissionariesCannibalsAction> problem = Functions.createMissionariesCannibalsProblem();
	    SearchForActions<MissionariesCannibalsState, MissionariesCannibalsAction> search = new DepthFirstSearch<>(new GraphSearch<>());
	    Optional<List<MissionariesCannibalsAction>> actions = search.findActions(problem);

	    actions.ifPresent(qActions -> qActions.forEach(System.out::println));
	    System.out.println(search.getMetrics());
	    System.out.println("\n--- Done ---");
	}
	private static void missionariesCannibalsUCS() {
		System.out.println("\n--- UniformCostSearch ---");

	    Problem<MissionariesCannibalsState, MissionariesCannibalsAction> problem = Functions.createMissionariesCannibalsProblem();
	    UniformCostSearch<MissionariesCannibalsState, MissionariesCannibalsAction> search = new UniformCostSearch<>(new GraphSearch<>());
	    Optional<List<MissionariesCannibalsAction>> actions = search.findActions(problem);

	    actions.ifPresent(qActions -> qActions.forEach(System.out::println));
	    System.out.println(search.getMetrics());
	    System.out.println("\n--- Done ---");
	}
	private static void missionariesCannibalsUCS_NotCheckRepeatedStates() {
		System.out.println("\n--- UniformCostSearch NotCheckRepeatedStates ---");

	    Problem<MissionariesCannibalsState, MissionariesCannibalsAction> problem = Functions.createMissionariesCannibalsProblem();
	    UniformCostSearch<MissionariesCannibalsState, MissionariesCannibalsAction> search = new UniformCostSearch<>(new TreeSearch<>());
	    Optional<List<MissionariesCannibalsAction>> actions = search.findActions(problem);

	    actions.ifPresent(qActions -> qActions.forEach(System.out::println));
	    System.out.println(search.getMetrics());
	    System.out.println("\n--- Done ---");
	}
	public static void main(String[] args) {
		missionariesCannibalsBFS();
		missionariesCannibalsDFS();
		missionariesCannibalsUCS();
		missionariesCannibalsUCS_NotCheckRepeatedStates();
	}
}
