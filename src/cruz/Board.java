package cruz;

import java.util.ArrayList;

public class Board {
	public void print(ArrayList<Combination> combinations, Attempt secretKey,boolean displaySecretKey) {
		ManagementIO management=new ManagementIO();
		management.outln();
		System.out.printf("%-28s     %5s   %5s\n","COMBINATION","WHITE","BLACK");
		management.outln("-----------------------------------------------");
		if(displaySecretKey) {
			management.outln(secretKey.toString());
		}
		else {
			System.out.printf("%-7s%-7s%-7s%-7s\n","X","X","X","X");
		}
		for (Combination combination:combinations) {
			management.outln(combination.toString());
		}
		management.outln();
	}

}
