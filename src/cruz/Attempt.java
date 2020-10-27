package cruz;

import java.util.HashMap;
import java.util.Random;

public class Attempt {
	
	private Colors[] colors;
	
	
	public Attempt() {
		this.colors=new Colors[Combination.COMBINATION_NUMBER];
	}
	
	public Colors[] getColors() {
		return this.colors;
	}
	
	public void requestCombination(String inputs) {
		HashMap<Character,Colors> map=Colors.getMap();
		for(int i=0; i<inputs.length();i++) {
			this.colors[i]=map.get(inputs.charAt(i));
		}
	}
	
	public Attempt getRandomAttempt() {
		HashMap<Character,Colors> map=Colors.getMap();
        Random rnd=new Random();
        for (int i=0;i<Combination.COMBINATION_NUMBER;i++){
            int number;
            int j=Combination.COMBINATION_NUMBER;
            do{
                number=rnd.nextInt(Colors.values().length);
                for(j=0;j<i;j++) {
                    if (map.get(Colors.values()[number].getNickname())==colors[j]) {
                    	break;
                    }
                }
            }while(j<i);
            //this.colors[i]=map.get(Colors.values()[number].getNickname());
            this.colors[i]=Colors.values()[number];
        }
		return this;
	}
	
	public String toString() {
		String out="";
		for(Colors color:this.colors) {
			out+=String.format("%-7s", color.toString().substring(0, color.toString().length()<7?color.toString().length():6));
		}
		return out;
	}

}
