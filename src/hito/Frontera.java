package hito;


import java.util.ArrayList;

public class Frontera {
	private ArrayList<Nodo> frontera;
	
	public void añadirNodo(Nodo nodo){
	    frontera.add(posicion(frontera, nodo.getValor()), nodo);
	}
	public ArrayList<Nodo> getfrontera(){
		return frontera;
	}
	public void elimina(Nodo nodo){
		frontera.remove(nodo);
	}
	public boolean EsVacia(){
		boolean vacia= frontera.isEmpty();
		return vacia;
	}
	public int posicion(ArrayList<Nodo> fron, int valor){
		int posicion=fron.size();
		for (int i = 0; i < fron.size(); i++) {
			if(fron.get(i).getValor()<valor){
				posicion=i;
			}
		}
		
		return posicion;
	}

}