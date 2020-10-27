package cruz;

public class Game {
	private final int ATTEMPTS_NUMBER=5;
	private Attempt secretKey;
	private Player player;
	private Board board;
	
	public Game() {
		this.secretKey=new Attempt();
		this.player=new Player();
		this.board=new Board();
	}
	
	public String inputCombination() {
		ManagementIO management=new ManagementIO();
		management.outln(Colors.printAllColors());
		String inputs;
		do {
			inputs=management.inString("Propose a combination, p.e. rgby: ");
			management.outln("repeated: "+Validation.repeatedColor(inputs));
		}while(!Colors.contains(inputs) || inputs.length()!=Combination.COMBINATION_NUMBER || Validation.repeatedColor(inputs));
		return inputs;
	}
	
	public void play(){
		ManagementIO management=new ManagementIO();

		this.secretKey=this.secretKey.getRandomAttempt();
		management.outln("secretKey= "+this.secretKey.toString());
		boolean isRight;
		int n=0;
		do {
			String inputs=inputCombination();
			this.player.readAttempt(inputs);
			isRight=this.isSecretKey(this.player.getCombinations().get(this.player.getCombinations().size()-1));
			management.outln("isRight= "+isRight);
			n++;
			this.board.print(this.player.getCombinations(),this.secretKey,((n==this.ATTEMPTS_NUMBER)||isRight));
		}
		while(n<this.ATTEMPTS_NUMBER && !isRight);
		if (isRight) {
			management.outln("Congratulations");
		}
		else {
			management.outln("You have exceeded the number of attempts");
		}
    }
	
	private boolean isSecretKey(Combination combination) {
		Colors[] aux=new Colors[combination.getAttempt().getColors().length];
		for (int i=0;i<combination.getAttempt().getColors().length;i++) {
			aux[i]=combination.getAttempt().getColors()[i];
		}
		Peg peg=new Peg();
		peg.setPeg(0, 0);
		combination.setPeg(peg);
		for(int i=0;i<this.secretKey.getColors().length;i++) {
			for(int j=0;j<aux.length;j++) {
				if(this.secretKey.getColors()[i]==aux[j]) {
					if(i==j) {
						combination.getPeg().setPeg(0, combination.getPeg().getPeg(0)+1);
						aux[j]=null;
					}
				}
			}
		}
		combination.getPeg().setPeg(1, 0);
		for(int i=0;i<this.secretKey.getColors().length;i++) {
			for(int j=0;j<aux.length;j++) {
				if(this.secretKey.getColors()[i]==aux[j]) {
					combination.getPeg().setPeg(1, combination.getPeg().getPeg(1)+1);
					aux[j]=null;
				}
			}
		}
		if(combination.getPeg().getPeg(0)==Combination.COMBINATION_NUMBER) {
			return true;
		}
		return false;
	}

}
