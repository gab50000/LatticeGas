import java.lang.Math;
import java.util.AbstractCollection;
public class Atom{
	private String name;
	private double[] pos=new double[3];

	public Atom(String name, double x, double y, double z){
		this.name = name;
		this.pos[0]=x;
		this.pos[1]=y;
		this.pos[2]=z;
	}

	public double[] getCoords(){
		return this.pos;
	}

	public String getName(){
		return this.name;
	}

	public double dist(Atom b){
		return Math.sqrt((this.pos[0]-b.pos[0])*(this.pos[0]-b.pos[0])+(this.pos[1]-b.pos[1])*(this.pos[1]-b.pos[1])+(this.pos[2]-b.pos[2])*(this.pos[2]-b.pos[2]));
	}

	public double[] getPosdiff(Atom b){
		double[] posdiff = new double[3];
		posdiff[0]=b.pos[0]-this.pos[0];
		posdiff[1]=b.pos[1]-this.pos[1];
		posdiff[2]=b.pos[2]-this.pos[2];
		return posdiff;
	}

	public Atom closestNeighbor(Atom[] atoms){
		double mindist=-1;
		double distance;
		Atom closestatom = atoms[0];
		for (int i = 0; i < atoms.length; i++){
			distance = dist(atoms[i]);
			if (mindist < 0 || distance < mindist){
				mindist = distance;
				if (!this.equals(atoms[i])){
					closestatom = atoms[i];
				}
			}
		}
		return closestatom;
	}
}


