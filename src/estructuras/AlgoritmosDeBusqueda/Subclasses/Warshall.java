package estructuras.AlgoritmosDeBusqueda.Subclasses;

import estructuras.AlgoritmosDeBusqueda.AlgoritmoDeBusqueda;
import estructuras.Arco;
import estructuras.GrafoND;
import estructuras.NodoG;

import java.util.ArrayList;
import java.util.Hashtable;

public class Warshall<T> extends AlgoritmoDeBusqueda {

	private Hashtable<ElementoDeMatriz<T>, ElementoDeMatriz<T>> tablaHash;
	private GrafoND<T> grafo;
	private NodoG<T> nodoParada;
	private ElementoDeMatriz<T> ruta;
	
	public Warshall(GrafoND<T> pGrafo, NodoG<T> pPartida, NodoG<T> pDestino) {
		grafo = pGrafo;
		ruta = new ElementoDeMatriz<>(pPartida, pDestino);
		nodoParada = new NodoG<>(null);
		tablaHash = new Hashtable<>();
		
		this.arcosDirectos();
		this.buscarElemento();
	}

	@Override
	public ArrayList<NodoG<T>> getPath(NodoG pInicio, NodoG pDestino, GrafoND pGrafo) {
		return retornarCamino();
	}


	//agrega todos los arcos directos a la tabla hash
	private void arcosDirectos() {
		NodoG<T> nodoActual;
		ElementoDeMatriz<T> elementoActual;
		for(int posNodo = 0; posNodo < grafo.getNodos().size(); posNodo++) {
			nodoActual = grafo.getNodos().get(posNodo);
			for(int conecciones = 0; conecciones < nodoActual.getArcos().size(); conecciones++) {
				elementoActual = new ElementoDeMatriz<>(nodoActual, nodoActual.getArcos().get(conecciones));
				tablaHash.put(elementoActual, elementoActual);
				if(elementoActual.compareTo(ruta)==0) {
					ruta = elementoActual; 
					return;
				}
			}
		}
	}
	
	
	//en teoria, realiza las conexiones necesarias para llegar del punto al punto b un k iteraciones
	private void buscarElemento() {
		NodoG<T> nodoActual;
		NodoG<T> nodoConector;
		ElementoDeMatriz<T> elementoActual;
		ElementoDeMatriz<T> origenActual;
		ElementoDeMatriz<T> actualDestino;
		for(int posNodo = 0; posNodo < grafo.getNodos().size(); posNodo++) {
			nodoConector = grafo.getNodos().get(posNodo);
			for(int arcoActual = 0; arcoActual< nodoConector.getArcos().size();arcoActual++) {
				nodoActual = nodoConector.getArcos().get(arcoActual);
				//origenActual = new ElementoDeMatriz<>(ruta.getNodoOrigen(), nodoConector);
				//actualDestino = new ElementoDeMatriz<>(nodoConector, nodoActual);
				if((ruta.getNodoOrigen().getArcos().contains(nodoConector)) && (nodoConector.getArcos().contains(nodoActual))) {
					elementoActual = new ElementoDeMatriz<>(ruta.getNodoOrigen(), nodoActual);
					elementoActual.setNodoAnterior(nodoConector);
					tablaHash.put(elementoActual, elementoActual);
					if(elementoActual.compareTo(ruta) == 0) {
						ruta = elementoActual; 
						return;
					}
				}
				/*if(tablaHash.containsKey(ruta)) {
					return;
				}*/
			}
			
		}
	}
	
	// devuelve un array con los nodos para llegar del punto a al punto b, se debe recorrer alreves
	public ArrayList<NodoG<T>> retornarCamino(){
		System.out.println("Retornar camono warshall");
		int contador = 0;
		ArrayList<NodoG<T>> camino = new ArrayList<>();
		camino.add(ruta.getNodoDestino());
		ElementoDeMatriz<T> conectores = ruta;
		while(conectores.getNodoAnterior() != null) {
			conectores = tablaHash.get(conectores);
			camino.add(conectores.getNodoAnterior());
			System.out.println(contador);
			contador++;
		}
		return camino;
	}
	









}
