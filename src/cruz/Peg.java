package cruz;

public class Peg {
	private int[] pegs;
	
	public Peg() {
		this.pegs=new int[2];
	}
	
	public void setPegs(int[] pegs) {
		
	}
	
	public int getPeg(int index) {
		return pegs[index];
	}
	
	public void setPeg(int index,int value) {
		this.pegs[index]=value;
	}

	@Override
	public String toString() {
		String out="";
		for (int valor:this.pegs) {
			out +="   "+String.format("%5s",Integer.toString(valor));
		}
				
		return out;
	}
}
