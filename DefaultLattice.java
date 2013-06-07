public interface DefaultLattice{
	private boolean[][] lattice;
	private <Number>[][] transitionMatrix;

	public void step();
}
