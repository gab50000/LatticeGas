import java.util.*;
public class test{

	public static void main(String[] args){
		Atom a = new Atom("H", 1, 2, 3);
		Atom b = new Atom("H", 0, 0, 0);

		//~ System.out.println(a.dist(b));

		try{
			xyzFile hex400 = new xyzFile("../../Master/trajectories/400K.xyz");
			String[] atoms={"H", "O", "P"};
			hex400.toggleAcidHs();
			hex400.setAtomsShown(atoms);
			for (int i = 0; i<75000; i++){
				hex400.readFrame();
			}
		}
		catch (Exception e){
			System.err.println(e);
		}


		//~ String str= "    1 2 3   5 6  7";
//~ 
		//~ String[] str2=str.replaceAll("^\\s+","").split("\\s+");
//~ 
		//~ System.out.println(str2[0]);
//~ 
		//~ Map<String,Vector<Integer>> m = new HashMap<>();
//~ 
		//~ m.put("H", new Vector<Integer>());
		//~ m.get("H").add(1);
//~ 
		//~ m.put("O", new Vector<Integer>());
		//~ m.get("O").add(3);
//~ 
		//~ System.out.println(m.containsKey("H"));
		//~ 
		//~ System.out.println(m);
//~ 
		//~ m.get("O").add(4);
//~ 
		//~ System.out.println(m);
		//~ 
		//~ ArrayList<Integer> abc = new ArrayList<>();
		//~ abc.add(1);
		//~ abc.add(3);
		//~ abc.add(12);
		//~ System.out.println(abc);

	}
}
