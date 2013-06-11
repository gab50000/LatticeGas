import java.io.*;
import java.util.*;
public class xyzFile{
	
	private Scanner sc;
	private int atomnumber, selectedatomnumber, framecount=0;
	private HashMap <String, ArrayList<Integer>> indexmap;
	private boolean[] indicestoshow;
	private ArrayList<Integer> Hacid_indices;
	
	public xyzFile(String filename) throws FileNotFoundException{
		this.sc = new Scanner(new File(filename));
		this.atomnumber = sc.nextInt();
		sc.nextLine();
		sc.nextLine();

		this.indicestoshow=new boolean[this.atomnumber];
		for (int i=0; i<this.atomnumber; i++){
			this.indicestoshow[i]=true;
		}
		this.indexmap = determineAtoms(sc, atomnumber);
		this.sc.close();
		this.sc = new Scanner(new File(filename));
	}

	private HashMap<String,ArrayList<Integer>> determineAtoms(Scanner sc, int steps){
		String[] line;
		HashMap <String, ArrayList<Integer>> indexmap = new HashMap<>();
		for (int i = 0; i < steps; i++){
			line=sc.nextLine().replaceAll("^\\s+", "").split("\\s+");
			if (indexmap.containsKey(line[0])){
				indexmap.get(line[0]).add(i);
			}
			else{
				indexmap.put(line[0], new ArrayList<Integer>());
				indexmap.get(line[0]).add(i);
			}
		}
		
		return indexmap;
	}

	public void readFrame() throws IOException{
		System.out.println(this.selectedatomnumber);
		System.out.println();
		
		sc.nextLine();
		sc.nextLine();

		for (int i = 0; i < this.atomnumber; i++){
			if (this.indicestoshow[i]){
				System.out.println(sc.nextLine());
			}
			else{
				sc.nextLine();
			}
		}
		framecount++;
	}

	public Atom[] getAtoms() throws IOException{
		sc.nextLine();
		sc.nextLine();

		Atom [] atoms = new Atom[this.atomnumber];
		String[] line;

		for (int i = 0; i < this.atomnumber; i++){
			if (this.indicestoshow[i]){
				line=sc.nextLine().replaceAll("^\\s+", "").split("\\s+");
				atoms[i] = new Atom(line[0], Double.parseDouble(line[1]), Double.parseDouble(line[2]), Double.parseDouble(line[3]));
			}
			else{
				sc.nextLine();
			}
		}
		framecount++;

		return atoms;
	}

	public void setAtomsShown(String[] atoms){

		ArrayList<Integer> atomstoshow = new ArrayList<Integer>();
		for (int i = 0; i < atoms.length; i++){
			if (this.indexmap.containsKey(atoms[i])){
				atomstoshow.addAll(this.indexmap.get(atoms[i]));
			}
		}
		
		Collections.sort(atomstoshow);
		for (int i = 0; i < this.atomnumber; i++){
			if (atomstoshow.contains(i)){
				this.indicestoshow[i] = true;
			}
			else{
				 this.indicestoshow[i] = false;
			 }
		 }
		 
		 this.selectedatomnumber = atomstoshow.size();
		 
	}
	
	public Set<String> getAtomTypes(){
		return this.indexmap.keySet();
	}
	
	public int getAtomCount(String name){
		if (this.indexmap.containsKey(name)){
			return this.indexmap.get(name).size();
		}
		else return 0;
	}
	
	public set_acidicHs(){
		Atom[] Hs = 
	}
	
	
}

