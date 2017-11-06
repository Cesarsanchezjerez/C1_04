package hito1;
import java.util.*;
public class Terreno {

	private int Terreno [][]; 
	private int x;//posicion del tractor
	private int y;//posicion del tractor
	private int k;//cantidad de arrena deseada por casilla
	private int max;//maxima arena en una casilla
	private int c;//cordenada del terreno
	private int f;//2cordenada del terreno
	//private
	
	//constructor
	public Terreno(int NX,int NY,int NK,int NMax,int NC,int NF) {
		x=NX;
		y=NY;
		k=NK;
		max=NMax;
		c=NC;
		f=NF;
		Terreno=new int [c][f];
	}
	
	//metodos para consultar/actualizar variables.

	public void inicializarTerreno(){
		int v = c*f*k;
		int r;
		while(v>0){
			for (int i = 0; i < c; i++) {
				for (int j = 0; j < f; j++) {
					r= (int) (Math.random()*max);
					if((Terreno[i][j]+r)<=max && (v-r)>=0) {
						Terreno[i][j]+=r;
						v-=r;
					}
				}
			}
			}
		}
	public int[][] getTerreno(){
			return Terreno;
		}
	public void setTerreno(int [][] Nterreno){
			Terreno=Nterreno;
		}
	public void setX(int x){
		this.x=x;
	}
		
	public int getx(){
			return x;
		}
	public int gety(){
			return y;
		}
	public int getk(){
			return k;
		}
	public int getmax(){
			return max;
		}
	public int getc(){
			return c;
		}
	public int getf(){
			return f;
		}
	} 

