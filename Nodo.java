package hito1;

public class Nodo {
	
	private Nodo padre;
	private Estado terreno;
	private int costo;
	private Accion movimiento;
	private int valor;
	public Nodo(Nodo padre, Estado terreno, int costo, Accion movimiento, int valor) {
		super();
		this.padre = padre;
		this.terreno = terreno;
		this.costo = costo;
		this.movimiento = movimiento;
		this.valor = valor;
	}
	public Nodo getPadre() {
		return padre;
	}
	public void setPadre(Nodo padre) {
		this.padre = padre;
	}
	public Estado getTerreno() {
		return terreno;
	}
	public void setTerreno(Estado terreno) {
		this.terreno = terreno;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	public Accion getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(Accion movimiento) {
		this.movimiento = movimiento;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
}
