package estructuras;

import java.util.Vector;

public class GrafoND<T> {
	private Vector<NodoG<T>> nodos;
	private Vector<Arco<T>> arcos; 
	
	public GrafoND() {
		nodos = new Vector<>();
	}
	
	public void agregarNodo(NodoG<T> pNodo) {
		if(!nodos.contains(pNodo)) {
			nodos.add(pNodo);
		}
	}
	
	public void agregarArco(NodoG<T> pNodo1, NodoG<T> pNodo2) {
		if(nodos.contains(pNodo1) && nodos.contains(pNodo2)) {
			if(pNodo1.getArcos().contains(pNodo2)) {
				return;
			}
			if(pNodo1.agregarArco(pNodo2)) {
				arcos.add(new Arco<T>(1,pNodo1,pNodo2));
			}
		}
	}
	
	public void warshall() {
		
	}
	
	public void floyd() {
		
	}
	
	public void MST() {
		
	}
	
	public void dijkstra() {
		
	}
}
