import java.lang.Math;
public class Atom{
	private String name;
	private double[] pos=new double[3];

	public Atom(String name, double x, double y, double z){
		this.name = name;
		this.pos[0]=x;
		this.pos[1]=y;
		this.pos[2]=z;
	}

	public double[] get_Coords(){
		return this.pos;
	}

	public double dist(Atom b){
		return Math.sqrt((this.pos[0]-b.pos[0])*(this.pos[0]-b.pos[0])+(this.pos[1]-b.pos[1])*(this.pos[1]-b.pos[1])+(this.pos[2]-b.pos[2])*(this.pos[2]-b.pos[2]));
	}

	public double[] get_posdiff(Atom b){
		double[] posdiff = new double[3];
		posdiff[0]=b.pos[0]-this.pos[0];
		posdiff[1]=b.pos[1]-this.pos[1];
		posdiff[2]=b.pos[2]-this.pos[2];
		return posdiff;
	}
}


