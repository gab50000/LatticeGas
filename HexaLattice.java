import java.util.Random;

public class HexaLattice{

	private int i,j;
	private boolean[][] lattice;
	private double[][] transitionMatrix;


	public HexaLattice (int OxygenNumber) {
		this.lattice = new boolean[OxygenNumber][OxygenNumber];
		this.transitionMatrix = new double[OxygenNumber+1][OxygenNumber+1];
	}

	public void step(Random r){
		this.i = r.nextInt(this.lattice.length);
		this.j = r.nextInt(this.lattice.length);
	}
	


	
}
