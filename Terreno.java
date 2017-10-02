package hito1;

public class Terreno {

	private int Terreno [][]; 
	private int X;//posicion del tractor
	private int Y;//posicion del tractor
	private int K;//cantidad de arrena deseada por casilla
	private int Max;//maxima arena en una casilla
	private int C;//cordenada del terreno
	private int F;//2cordenada del terreno
	//private
	
	//constructor
	public Terreno(int [][] Nterreno,int NX,int NY,int NK,int NMax,int NC,int NF) {
		Terreno=Nterreno;
		X=NX;
		Y=NY;
		K=NK;
		Max=NMax;
		C=NC;
		F=NF;
	}
	
	//metodos para consultar/actualizar variables.
}
