package cruz;

import java.util.ArrayList;

public class Player {
	private ArrayList<Combination> combinations;
	
	public Player() {
		combinations=new ArrayList<>();
	}
	
	public void readAttempt(String inputs) {
		Combination combination=new Combination();
		Attempt attempt=new Attempt();
		attempt.requestCombination(inputs);
		combination.setAttempt(attempt);
		combinations.add(combination);
	}
	
	public ArrayList<Combination> getCombinations(){
		return combinations;
	}

}
