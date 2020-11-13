package environment.missionariescannibals;

import java.util.ArrayList;
import java.util.List;



import aima.core.agent.Action;
import aima.core.search.framework.problem.Problem;

public class Functions {
	
	public static final MissionariesCannibalsState GOAL_STATE = new MissionariesCannibalsState(new int[] { 0, 0, 1});
	
	public static boolean testGoal(MissionariesCannibalsState state) {
        return state.equals(Functions.GOAL_STATE);
    }
	
	public static Problem<MissionariesCannibalsState, MissionariesCannibalsAction> createMissionariesCannibalsProblem() {
		return new MissionariesCannibalsProblem(new MissionariesCannibalsState(new int[]{3,3,-1}));
	}

	public static List<MissionariesCannibalsAction> getActions(MissionariesCannibalsState s) {
		int[] state = s.getState();
		
		int missionaries = state[0];
		int cannibals = state[1];
		int direction = state[2];
		
		if (direction == 1) {
			missionaries = MissionariesCannibalsProblem.MissionariesNumber - state[0];
			cannibals = MissionariesCannibalsProblem.MissionariesNumber - state[1];
		}
		
		List<MissionariesCannibalsAction> actions = new ArrayList<>();
		for (int capacity=1; capacity<=MissionariesCannibalsProblem.ShipCapacity; capacity++) {
			for (int m=0; m<=missionaries; m++) {
				for (int c=0; c<=cannibals; c++) {
					if (m+c == capacity) {
						MissionariesCannibalsAction newAction = new MissionariesCannibalsAction(m, c, direction);
						if (!s.isMissionariesInDanger(newAction)) {
							actions.add(newAction);
						}						 
					}
				}
			}
		}
		return actions;
	}

	public static MissionariesCannibalsState getResult(MissionariesCannibalsState s, MissionariesCannibalsAction a) {
		assert s.getState()[2] == a.getShipDirection() : String.format("S State %d not consistent with action direction %d", s.getState()[2], a.getShipDirection());
		MissionariesCannibalsState ss = s.clone();
		ss.applyAction(a);
		System.out.println(s.toString() + "\t" + a.toString() + "\t" + ss.toString());
		return ss;
	}
}
