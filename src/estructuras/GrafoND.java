package estructuras;

import java.util.Vector;

public class GrafoND<T> {
	private Vector<NodoG<T>> nodos;
	
	public GrafoND() {
		nodos = new Vector<>();
	}
	
	public void agregarNodo(NodoG<T> pNodo) {
		if(!nodos.contains(pNodo)) {
			nodos.add(pNodo);
		}
	}
	
	public void agregarArco(NodoG<T> pNodo1, NodoG<T> pNodo2) {
		pNodo1.agregarArco(pNodo2);
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
