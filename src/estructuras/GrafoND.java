package estructuras;

import java.util.ArrayList;

public class GrafoND<T> {
	private ArrayList<NodoG<T>> nodos;
	private ArrayList<Arco<T>> arcos;
	private T Object;



	public GrafoND() {
		nodos = new ArrayList<>();
		arcos = new ArrayList<>();
	}
	
	public void agregarNodo(NodoG<T> pNodo) {
		if(!nodos.contains(pNodo)) {
			nodos.add(pNodo);
		}
	}
	
	public void agregarArco(int peso,NodoG<T> pNodo1, NodoG<T> pNodo2) {
		if(nodos.contains(pNodo1) && nodos.contains(pNodo2)) {
				arcos.add(new Arco<T>(peso,pNodo1,pNodo2));
				pNodo1.agregarArco(pNodo2);
				pNodo2.agregarArco(pNodo1);

		}
	}


	public int getPesoDeUnArco(NodoG pNodoA, NodoG pNodoB){
		for (Arco arco : arcos){
			if (((Arco)arco).getPuntoB()==pNodoB && ((Arco)arco).getPuntoA() == pNodoA ||
					((Arco)arco).getPuntoB()==pNodoA && ((Arco)arco).getPuntoA() == pNodoB) return ((Arco)arco).getPeso();
		}
		return 7;
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

	public void setNodos(ArrayList<NodoG<T>> nodos) {
		this.nodos = nodos;
	}

	public void setArcos(ArrayList<Arco<T>> arcos) {
		this.arcos = arcos;
	}

	public void setObject(T object) {
		Object = object;
	}
}