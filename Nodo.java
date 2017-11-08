package hito1;

import java.util.ArrayList;

public class Nodo {
	
	private Nodo padre;
	private Estado estado;
	private int costo;
	private Accion accion;
	private int valor;
	public Nodo() {
		this.padre = padre;
		this.estado = estado;
		this.costo = costo;
		this.accion = accion;
		this.valor = valor;
	}
	public Nodo(Nodo padre, Estado estado, int costo, Accion accion, int valor) {
		super();
		this.padre = padre;
		this.estado = estado;
		this.costo = costo;
		this.accion = accion;
		this.valor = valor;
	}
	public Nodo getPadre() {
		return padre;
	}
	public void setPadre(Nodo padre) {
		this.padre = padre;
	}
	public Accion getAccion() {
		return accion;
	}
	public void setAccion(Accion accion) {
		this.accion = accion;
	}
	public int getCosto() {
		return costo;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public ArrayList<Nodo> sucesores(){
		ArrayList<Accion> todas=accion.todasV(estado.getRepartir());
		ArrayList<Nodo> sucesores=new ArrayList<Nodo>();
		Nodo me=new Nodo();
		for (Accion a : todas) {
			if(!fueraLimites(a,estado)) { 
				if(!echaDemasiado(a, estado)) {
					Nodo n=new Nodo(me, a.aplicarMovimiento(estado, a), a.cantidadArena(a.getArena())+1, a, valor); //valor es un random
					sucesores.add(n);
				}
				
			}
		}
		return sucesores;
	}
	public boolean fueraLimites(Accion a, Estado e) {
		boolean sale=false;
		int[] nCoor= new int[2];
		int[] movimiento=a.getArena();
		for (int i = 0; i < movimiento.length; i++) {
			if (movimiento[i]!=0) {
				nCoor= a.nuevaCoordenada(e.getx(), e.gety(), i);
				if(nCoor[0]-1<0 || nCoor[1]-1<0 || nCoor[0]+1>=e.getc() || nCoor[1]+1>=e.getf()) {
					sale=true;
				}
			}
		}
		return sale;
	}
	public boolean echaDemasiado(Accion a, Estado e) {
		boolean demasiado=false;
		int[] nCoor= new int[2];
		int[] movimiento=a.getArena();
		int[][] terreno=e.getTerreno();
		for (int i = 0; i < movimiento.length; i++) {
			if (movimiento[i]!=0) {
				nCoor= a.nuevaCoordenada(e.getx(), e.gety(), i);
				if(terreno[nCoor[0]][nCoor[1]]+movimiento[i]> e.getmax()) {
					demasiado=true;
				}
			}
		}
		
		return demasiado;
	}
}
