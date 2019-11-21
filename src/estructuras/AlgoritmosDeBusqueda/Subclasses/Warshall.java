package estructuras.AlgoritmosDeBusqueda.Subclasses;

import estructuras.AlgoritmosDeBusqueda.AlgoritmoDeBusqueda;
import estructuras.Arco;
import estructuras.GrafoND;
import estructuras.NodoG;

import java.util.ArrayList;
import java.util.Hashtable;

public class Warshall<T> extends AlgoritmoDeBusqueda {

	private Hashtable<ElementoDeMatriz<T>, NodoG<T>> tablaHash;
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
		for(int posNodo = 0; posNodo < grafo.getNodos().size(); posNodo++) {
			nodoActual = grafo.getNodos().get(posNodo);
			for(int conecciones = 0; conecciones < nodoActual.getArcos().size(); conecciones++) {
				tablaHash.put(new ElementoDeMatriz<>(nodoActual, nodoActual.getArcos().get(conecciones)), nodoParada);
				if(tablaHash.containsKey(ruta)) {
					return;
				}
			}
		}
	}
	
	
	//en teoria, realiza las conexiones necesarias para llegar del punto al punto b un k iteraciones
	private void buscarElemento() {
		NodoG<T> nodoActual;
		NodoG<T> nodoConector;
		ElementoDeMatriz<T> origenActual;
		ElementoDeMatriz<T> actualDestino;
		for(int posNodo = 0; posNodo < grafo.getNodos().size(); posNodo++) {
			nodoConector = grafo.getNodos().get(posNodo);
			for(int arcoActual = 0; arcoActual< nodoConector.getArcos().size();arcoActual++) {
				nodoActual = nodoConector.getArcos().get(arcoActual);
				origenActual = new ElementoDeMatriz<>(ruta.getNodoOrigen(), nodoConector);
				actualDestino = new ElementoDeMatriz<>(nodoConector, nodoActual);
				if(tablaHash.containsKey(origenActual) && tablaHash.containsKey(actualDestino)) {
					tablaHash.put(new ElementoDeMatriz<>(ruta.getNodoOrigen(), nodoActual), nodoConector);
				}
				if(tablaHash.containsKey(ruta)) {
					return;
				}
			}
			
		}
	}
	
	// devuelve un array con los nodos para llegar del punto a al punto b, se debe recorrer alreves
	public ArrayList<NodoG<T>> retornarCamino(){
		ArrayList<NodoG<T>> camino = new ArrayList<>();
		camino.add(ruta.getNodoDestino());
		ElementoDeMatriz<T> conectores = ruta;
		while(tablaHash.get(conectores) != nodoParada) {
			camino.add(tablaHash.get(conectores));
		}
		return camino;
	}
	









}
