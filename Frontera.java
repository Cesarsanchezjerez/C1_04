package hito1;
////lelele
public class Frontera {
	private Nodo[] frontera;
	
	public void añadirNodo(Nodo nodo, int posicion){
	    Nodo[] fron=frontera; //lista para guardar los valores y no quemar 
		fron[posicion]=nodo;
		for (int i=posicion;i<frontera.length;i++){
			fron[i+1]=frontera[i];
		}
		frontera=fron;
	}
	public Nodo[] getfrontera(){
		return frontera;
	}
	public Nodo elimina(){
		Nodo eliminado=frontera[0];
		for(int i=0;i<frontera.length-1;i++){
			frontera[i]=frontera[i+1];
		}
		return eliminado;
	}
	public boolean EsVacia(){
		boolean vacia=false;
		if(frontera.length==0){
			vacia=true;
		}
		return vacia;
	}
	

}
