package hito;

import java.util.ArrayList;

public class Accion {
	private int[] posicion = new int[2];
	private int[] desde = new int[2];
	private int[] arena = new int[4];

	public Accion(int[] posicion, int[] desde, int[] arena) {
		this.posicion = posicion;
		this.desde = desde;
		this.arena = arena;
	}

	public int[] getArena() {
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
	public int cantidadArena(int[] arena) {
		int suma=0;
		for (int i = 0; i < arena.length; i++) {
			suma+=arena[i];
		}
		return suma;
	}
	@Override
	public String toString() {
		String cadena = "(" + posicion[0] + ", " + posicion[1] + "), [";

		for (int i = 0; i < arena.length; i++) {
			if (arena[i] != 0) {
				cadena += desplazamiento(i, desde[0], desde[1], arena) + ", ";
			}

		}

		return cadena.substring(0, cadena.length() - 2) + "]";
	}

	public String desplazamiento(int a, int x, int y, int[] arena) {
		String cadena = "";
		if (arena[a] != 0)
			switch (a) {
			case 0:
				y = y - 1;
				cadena += "(" + arena[a] + ", (" + x + ", " + y + "))";
				break;
			case 1:
				y = y + 1;
				cadena += "(" + arena[a] + ", (" + x + ", " + y + "))";
				break;
			case 2:
				x = x + 1;
				cadena += "(" + arena[a] + ", (" + x + ", " + y + "))";
				break;
			case 3:
				x = x - 1;
				cadena += "(" + arena[a] + ", (" + x + ", " + y + "))";
				break;

			}

		return cadena;
	}

	public ArrayList<Accion> todasV(int repartir) {
		ArrayList<Accion> acciones = new ArrayList<Accion>();
		ArrayList<int[]> sol = new ArrayList<int[]>();
		movimientosRecurV(repartir, 0, new int[4], sol, repartir);
		for (int i = 0; i < 4; i++) {
			for (int[] is : sol) {
				Accion a= new Accion(nuevaCoordenada(desde[0], desde[1], i), getDesde(), is );
				acciones.add(a);
			}
		}
		return acciones;
	}

	public void movimientosRecurV(int arenaQueda, int etapa, int[] actual, ArrayList<int[]> soluciones, int repartir) {

		if (arenaQueda == 0 || etapa >= 4) {
			int[] aux = new int[4];
			System.arraycopy(actual, 0, aux, 0, actual.length);
			soluciones.add(aux);

		} else {
			for (int a = arenaQueda; a >= 0; a--) {
				if ((arenaQueda - a) >= 0) {
					actual[etapa] = a;
					movimientosRecurV(arenaQueda - a, etapa + 1, actual, soluciones, repartir);
				}

			}
		}

	}

	public int[] nuevaCoordenada(int x, int y, int cardinal) {
		int[] c = new int[2];
		switch (cardinal) {
		case 0:
			y -= 1;
			break;
		case 1:
			y += 1;
			break;
		case 2:
			x += 1;
			break;
		case 3:
			x -= 1;
			break;
		}
		c[0] = x;
		c[1] = y;
		return c;
	}

	public Estado aplicarMovimiento(Estado terreno, Accion m) {
		Estado terrenoN=terreno;
		int[] coordenadas = m.getPosicion();
		int[][] matriz = terrenoN.getTerreno();
		terrenoN.setX(coordenadas[0]);
		terrenoN.setY(coordenadas[1]);
		for (int i = 0; i < 4; i++) {
			coordenadas = m.getDesde();
			coordenadas = nuevaCoordenada(coordenadas[0], coordenadas[1], i);
			matriz[coordenadas[0]][coordenadas[1]] = m.getArena()[i];
		}
		terrenoN.setTerreno(matriz);
		return terrenoN;
	}
}
