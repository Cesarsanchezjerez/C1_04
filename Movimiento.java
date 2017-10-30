package hito1;
import java.util.ArrayList;
public class Movimiento {
	private int[] posicion=new int[2];
	private int[] desde=new int[2];
	private int [] arena=new int [4];
	public Movimiento(int[] posicion, int[] desde, int[] arena) {
		this.posicion = posicion;
		this.desde = desde;
		this.arena=arena;
	}
	
	
	public int [] getArena() {
		return arena;
	}
	public int[] getPosicion() {
		return posicion;
	}
	public int[] getDesde() {
		return desde;
	}
	public void setArena(int[] arena) {
		this.arena = arena;
	}
	public void setPosicion(int[] posicion) {
		this.posicion = posicion;
	}
	public void setDesde(int[] desde) {
		this.desde = desde;
	}
	@Override
	public String toString() {
		String cadena="("+posicion[0]+", "+posicion[1]+"), [";
		
		for (int i = 0; i < arena.length; i++) {
			if (arena[i]!=0) {
				cadena+=desplazamiento(i, desde[0], desde[1], arena)+", ";
			}
			
		}
		
		return cadena.substring(0, cadena.length()-2)+"]";
	}
	public String desplazamiento(int a, int x, int y, int [] arena) {
		String cadena="";
		if(arena[a]!=0)
			switch (a) {
				case 0:
					y=y-1;
					cadena+= "("+arena[a]+", ("+x+", "+y+"))";
					break;
				case 1:
					y=y+1;
					cadena+= "("+arena[a]+", ("+x+", "+y+"))";
					break;
				case 2:
					x=x+1;
					cadena+= "("+arena[a]+", ("+x+", "+y+"))";
					break;
				case 3:
					x=x-1;
					cadena+= "("+arena[a]+", ("+x+", "+y+"))";
					break;
					
		}
		
		return cadena;
	}
}
