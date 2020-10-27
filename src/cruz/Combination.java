package cruz;

public class Combination {
	public static final int COMBINATION_NUMBER=4;
	private Attempt attempt;
	private Peg peg;
	
	public void setAttempt(Attempt attempt) {
		this.attempt = attempt;
	}

	public void setPeg(Peg peg) {
		this.peg = peg;
	}
	
	public Attempt getAttempt() {
		return attempt;
	}

	public Peg getPeg() {
		return peg;
	}

	@Override
	public String toString() {
		return attempt.toString()+peg.toString();
	}
}
