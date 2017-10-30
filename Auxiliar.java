package hito1;
import java.util.*;
package hito1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Auxiliar {
	
	public int [] leerCabecera(String nombre) throws FileNotFoundException {// necesario¿?¿?¿? creo k innecesario
		File fichero = new File(nombre);
		Scanner sc = new Scanner(fichero);
		String str = sc.nextLine();
		String[] cabecera= str.split(" ");
		int[] cabeceraInt= new int[cabecera.length];
		for (int i = 0; i < cabeceraInt.length; i++) {
			cabeceraInt[i]=Integer.parseInt(cabecera[i]);
		}
		sc.close();
		return cabeceraInt;
		
}
	public Terreno leerTerreno(String nombre) throws FileNotFoundException { 
		File fichero = new File(nombre);
			Scanner sc = new Scanner(fichero);
			int [] cabecera= leerCabecera(nombre);
			int x = cabecera[0];
			int y = cabecera[1];
			int k = cabecera[2];
			int max = cabecera[3];
			int c = cabecera[4];
			int f = cabecera[5];
			int [][] t=new int [f][c];
			String str=sc.nextLine();
			
			int fila=0;
			Terreno terreno = new Terreno(x,y,k,max,c,f);
			//System.out.println(terreno.getx()+" "+terreno.gety()+" "+terreno.getk()+" "+terreno.getmax()+" "+terreno.getc()+" "+terreno.getf());
			
			do {
				if (fila<f) {
					for (int i = 0; i < c; i++) {
						t[fila][i]=sc.nextInt();
					}
				}
				
				fila++;
			}while(fila<f);
			
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
	public ArrayList<int[]> todasV(int repartir){
		
		ArrayList<int[]>sol=new ArrayList<int[]>();
		movimientosRecurV(repartir, 0, new int[4] , sol, repartir);
		
		return sol;
	}
	public void movimientosRecurV ( int arenaQueda, int etapa, int [] actual, ArrayList<int[]> soluciones, int repartir) {
		
		if (arenaQueda==0 || etapa >=4) {
			if (arenaQueda==0){
				int[] aux=new int[4];
				if (contarArena(actual)==repartir) {
					System.arraycopy( actual, 0, aux, 0, actual.length);
					soluciones.add(aux);
				}
				
			}
		}else {
			for (int a = arenaQueda; a >= 0 ; a--) {
				if((arenaQueda-a)>=0) {
					actual[etapa]=a;	
					movimientosRecurV(arenaQueda-a, etapa+1, actual, soluciones, repartir);
				}
				
			}		
		}
			
	}
	public int contarArena(int[] a) {
		int suma=0;
		for (int i = 0; i < a.length; i++) {
			suma+=a[i];
		}
		return suma;
	}
	public int[] nuevaCoordenada(int x, int y, int cardinal) {
		int [] c= new int[2];
		switch (cardinal) {
		case 0:
			y-=1;
			break;
		case 1:
			y+=1;
			break;
		case 2:
			x+=1;
			break;
		case 3:
			x-=1;
			break;
		}
		c[0]=x;
		c[1]=y;
		return c;
	}
	
	
	public void aplicarMovimiento(Terreno terreno, Movimiento m) {
		int [] coordenadas= m.getPosicion();
		int[][] matriz=terreno.getTerreno();
		terreno.setX(coordenadas[0]);
		terreno.setY(coordenadas[1]);
		for (int i = 0; i < 4; i++) {
			coordenadas=m.getDesde();
			coordenadas=nuevaCoordenada(coordenadas[0], coordenadas[1], i);
			matriz[coordenadas[0]][coordenadas[1]]=m.getArena()[i];
		}
		terreno.setTerreno(matriz);
	}
}










