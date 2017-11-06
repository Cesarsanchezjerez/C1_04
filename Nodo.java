package hito1;

import java.util.ArrayList;

public class Nodo {
	
	private Nodo padre;
	private Estado estado;
	private int costo;
	private Accion accion;
	private int valor;
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
	}
	
}
