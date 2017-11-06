package hito1;

import java.util.*;

public class Terreno {

	private int Terreno[][];
	private int x;// posicion del tractor
	private int y;// posicion del tractor
	private int k;// cantidad de arrena deseada por casilla
	private int max;// maxima arena en una casilla
	private int c;// cordenada del terreno
	private int f;// 2cordenada del terreno
	// private

	// constructor
	public Terreno(int NX, int NY, int NK, int NMax, int NC, int NF) {
		x = NX;
		y = NY;
		k = NK;
		max = NMax;
		c = NC;
		f = NF;
		Terreno = new int[c][f];
	}

	// metodos para consultar/actualizar variables.

	public void inicializarTerreno() {
		int v = c * f * k;
		int r;
		while (v > 0) {
			for (int i = 0; i < c; i++) {
				for (int j = 0; j < f; j++) {
					r = (int) (Math.random() * max);
					if ((Terreno[i][j] + r) <= max && (v - r) >= 0) {
						Terreno[i][j] += r;
						v -= r;
					}
				}
			}
		}
	}

	public int[][] getTerreno() {
		return Terreno;
	}

	public void setTerreno(int[][] Nterreno) {
		Terreno = Nterreno;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getx() {
		return x;
	}

	public int gety() {
		return y;
	}

	public int getk() {
		return k;
	}

	public int getmax() {
		return max;
	}

	public int getc() {
		return c;
	}

	public int getf() {
		return f;
	}

	}

	public int[] leerCabecera(String nombre) throws FileNotFoundException {// necesario¿?¿?¿?
																			// creo
																			// k
																			// innecesario
		File fichero = new File(nombre);
		Scanner sc = new Scanner(fichero);
		String str = sc.nextLine();
		String[] cabecera = str.split(" ");
		int[] cabeceraInt = new int[cabecera.length];
		for (int i = 0; i < cabeceraInt.length; i++) {
			cabeceraInt[i] = Integer.parseInt(cabecera[i]);
		}
		sc.close();
		return cabeceraInt;

	}

	public Terreno leerTerreno(String nombre) throws FileNotFoundException {
		File fichero = new File(nombre);
		Scanner sc = new Scanner(fichero);
		int[] cabecera = leerCabecera(nombre);
		int x = cabecera[0];
		int y = cabecera[1];
		int k = cabecera[2];
		int max = cabecera[3];
		int c = cabecera[4];
		int f = cabecera[5];
		int[][] t = new int[f][c];
		String str = sc.nextLine();

		int fila = 0;
		Terreno terreno = new Terreno(x, y, k, max, c, f);
		// System.out.println(terreno.getx()+" "+terreno.gety()+"
		// "+terreno.getk()+" "+terreno.getmax()+" "+terreno.getc()+"
		// "+terreno.getf());

		do {
			if (fila < f) {
				for (int i = 0; i < c; i++) {
					t[fila][i] = sc.nextInt();
				}
			}

			fila++;
		} while (fila < f);

		terreno.setTerreno(t);
		return terreno;

	}

public void GuardarTerreno(Terreno terreno) { // añadir opcione de nombrar terreno para guardarlos.
	
	FileWriter fichero=null;
	int [][] t =terreno.getTerreno();
	try {
		fichero = new FileWriter("Terreno.txt");
		
		fichero.write(terreno.getx()+" "+terreno.gety()+" "+terreno.getk()+" "+terreno.getmax()+" "+terreno.getc()+" "+terreno.getf());
		
		for (int i = 0; i < t.length; i++) {
			fichero.write("\n");
			for (int j = 0; j < t[i].length; j++) {
				fichero.write(t[i][j]+" ");
			}
			
		}
		fichero.close();
	}catch(Exception ex) {
		
	}
	
}
