package hito1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		int [][] matriz;
		
		int suma=0;
		Auxiliar aux = new Auxiliar();
		int[] desde= {2,2};
		int[] N= {2,1};
		int[] S= {2,3};
		int[] E= {3,2};
		int[] O= {1,2};
		ArrayList<Movimiento> movimientos= new ArrayList<Movimiento>();
		ArrayList<int[]>sol=new ArrayList<int[]>();
		sol=aux.todasV(1);
		
		/*for (int[] is : sol) {
			for (int i = 0; i < 4; i++) {
				System.out.print(is[i]);
			}
			System.out.println();
		}*/
		
		for (int[] is : sol) {
			Movimiento m =new Movimiento(N,desde, is);
			movimientos.add(m);
		}
		for (int[] is : sol) {
			Movimiento m =new Movimiento(S,desde, is);
			movimientos.add(m);
		}
		for (int[] is : sol) {
			Movimiento m =new Movimiento(E,desde, is);
			movimientos.add(m);
		}
		for (int[] is : sol) {
			Movimiento m =new Movimiento(O,desde, is);
			movimientos.add(m);
		}
		
		for (Movimiento M : movimientos) {
			System.out.println(M.toString());
		}
		//ArrayList<ArrayList<int[]>> sol = new ArrayList<ArrayList<int[]>>();
		//ArrayList<Movimiento> movimientos= new ArrayList<Movimiento>();
		//int[] pos= {0,0};
		//Arena a =new Arena(0,pos);
		//Movimiento mov =new Movimiento(pos, new ArrayList<Arena>());
		//movimientos=aux.todas();
		/*for (Movimiento m : movimientos) {
			pos=m.getPosicion();
			System.out.println(pos[0]+"_"+pos[1]);
			
			for (Arena a : m.getDesplazamientos()) {
				
				System.out.print(a.getArena());
				System.out.print("===");
				pos=a.getPosicion();
				System.out.println(""+pos[0]+"-"+pos[1]+ " ");
			}
			
		}*/
		
		
		
		
		//matriz=terreno.getTerreno();
		
	/*	for (int i = 0; i < matriz.length; i++) {
			System.out.println();
		for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]+" ");
				suma=suma+matriz[i][j];
			}
		}
	
		
		//aux.GuardarTerreno(terreno);
		//Terreno terreno=aux.leerTerreno("Terreno.txt");
		//Terreno terreno=new Terreno(aux.leerCabecera("Terreno.txt");
				//terreno.inicializarTerreno();
		//matriz=terreno.getTerreno();
		/*
		for (int i = 0; i < matriz.length; i++) {
			System.out.println();
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]+" ");
				suma=suma+matriz[i][j];	//V total
			}
		}*/
		
		
	}

}
