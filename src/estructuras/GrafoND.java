package estructuras;

import java.util.ArrayList;

public class GrafoND<T> {
	private ArrayList<NodoG<T>> nodos;
	private ArrayList<Arco<T>> arcos;
	private T Object;



	public GrafoND() {
		nodos = new ArrayList<>();
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

	public ArrayList<NodoG<T>> getNodos() {
		return nodos;
	}

	public ArrayList<Arco<T>> getArcos() {
		return arcos;
	}
	public T getObject() {
		return Object;
	}

	public void setObject(T object) {
		Object = object;
	}
}