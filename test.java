public class test{

	public static void main(String[] args){
		Atom a = new Atom("H", 1, 2, 3);
		Atom b = new Atom("H", 0, 0, 0);

		System.out.println(a.dist(b));

		try{
			xyzFile hex400 = new xyzFile("../../Master/trajectories/400K.xyz");
			
			Atom[] atoms = hex400.getAtoms();
			int j;
			System.out.println(atoms.length);
			for (int i = 0; i < atoms.length; i++){
				for (j = 0; j < i; j++){
					System.out.println(atoms[i].dist(atoms[j]));
				}
			}


		}
		catch (Exception e){
			System.out.println("Nö");
		}


	}
}
