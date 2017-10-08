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
			System.out.println(terreno.getx()+" "+terreno.gety()+" "+terreno.getk()+" "+terreno.getmax()+" "+terreno.getc()+" "+terreno.getf());
			
			do {
				if (fila<f) {
					for (int i = 0; i < c; i++) {
						t[fila][i]=sc.nextInt();
					}
				}
				
				fila++;
			}while(fila<4);
			
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
	public ArrayList<ArrayList<int[]>> todas() throws FileNotFoundException{
		
		ArrayList<ArrayList<int[]>>sol=new ArrayList<ArrayList<int[]>>();
		ArrayList<int[]>actual=new ArrayList<int[]>();
		Terreno terreno=leerTerreno("Terreno.txt");
		movimientosRecur(terreno.getx(), terreno.gety(), 3, terreno.getmax(), terreno.getTerreno(), 0, actual , sol);
		
		return sol;
	}
	
	public void movimientosRecur (int x, int y, int arena, int max, int [][] terreno, int etapa, ArrayList<int[]> actual, ArrayList<ArrayList<int[]>> soluciones) {
		int [] nCoordenadas= new int[2];
		int cardinal=0;
		if (arena==0 || etapa ==4) {
			if (arena==0){
				soluciones.add(actual);
			}
		}else {
			for (int a = 0; a <= arena ; a++) {
				nCoordenadas=nuevaCoordenada(x, y, cardinal, terreno);
				
				if (terreno[nCoordenadas[0]][nCoordenadas[1]]+a <=max) {
					actual.add(a,nCoordenadas);
					movimientosRecur(x, y, arena-a, max, terreno, etapa+1, actual, soluciones);
				}
				cardinal++;
			}		
		}
			
	}
	public int[] nuevaCoordenada(int x, int y, int cardinal, int [][] terreno) {
		int [] c= new int[2];
		switch (cardinal) {
		case 0:
			y+=1;
			break;
		case 1:
			y-=1;
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
}










