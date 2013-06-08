import java.io.*;
import java.util.Scanner;
public class xyzFile{
	
	private Scanner sc;
	private int atomnumber;
	
	public xyzFile(String filename) throws FileNotFoundException{
		this.sc = new Scanner(new File(filename));
		this.atomnumber = sc.nextInt();
		this.sc.close();
		this.sc = new Scanner(new File(filename));
	}

	public void readFrame() throws IOException{
		sc.nextLine();
		sc.nextLine();

		for (int i = 0; i < this.atomnumber; i++){
			System.out.println(sc.nextLine());
		}
	}

	public Atom[] getAtoms() throws IOException{
		sc.nextLine();
		sc.nextLine();

		Atom [] atoms = new Atom[this.atomnumber];

		for (int i = 0; i < this.atomnumber; i++){
			String[] line=sc.nextLine().replaceAll("^\\s+", "").split("\\s+");
			System.out.println(line[0]+";"+line[1]+";"+line[2]+";"+line[3]);
			atoms[i] = new Atom(line[0], Double.parseDouble(line[1]), Double.parseDouble(line[2]), Double.parseDouble(line[3]));
		}

		return atoms;
	}


}

