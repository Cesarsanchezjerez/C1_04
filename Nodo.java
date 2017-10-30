package hito1;

public class Nodo {
	
	private Nodo padre;
	private Terreno terreno;
	private int costo;
	private Movimiento movimiento;
	private int valor;
	
	
	public Nodo(Nodo padre, Terreno terreno, int costo, Movimiento movimiento, int valor) {

		this.padre=padre;
		this.terreno = terreno;
		this.costo = costo;
		this.movimiento = movimiento;
		this.valor = valor;
	}

	public Terreno getTerreno() {
		return terreno;
	}

	public void setTerreno(Terreno terreno) {
		this.terreno = terreno;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public Movimiento getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Nodo getPadre() {
		return padre;
	}

	public void setPadre(Nodo padre) {
		this.padre = padre;
	}
	
	
	
}
