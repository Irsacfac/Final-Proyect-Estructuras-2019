package estructuras.AlgoritmosDeBusqueda.Subclasses;

import estructuras.AlgoritmosDeBusqueda.AlgoritmoDeBusqueda;
import estructuras.Arco;
import estructuras.GrafoND;
import estructuras.NodoG;

import java.util.ArrayList;
import java.util.Hashtable;

public class Warshall extends AlgoritmoDeBusqueda {

	private Hashtable<ElementoDeMatriz, NodoG> tablaHash;
	private GrafoND grafo;
	private ElementoDeMatriz ruta;






















	6
	
	public Warshall(GrafoND pGrafo, NodoG pPartida, NodoG pDestino) {
		grafo = pGrafo;
		ruta = new ElementoDeMatriz(pPartida, pDestino);
		tablaHash = new Hashtable<>();
		
		this.arcosDirectos();
		this.buscarElemento();
	}

	@Override
	public ArrayList<NodoG> getPath(NodoG pInicio, NodoG pDestino, GrafoND pGrafo) {
		return retornarCamino();
	}


	//agrega todos los arcos directos a la tabla hash
	private void arcosDirectos() {
		NodoG nodoActual;
		for(int posNodo = 0; posNodo < grafo.getNodos().size(); posNodo++) {
			nodoActual = ((NodoG)grafo.getNodos().get(posNodo));
			for(int conecciones = 0; conecciones < nodoActual.getArcos().size(); conecciones++) {
				tablaHash.put(new ElementoDeMatriz(nodoActual,(NodoG)nodoActual.getArcos().get(conecciones)), null);
				if(tablaHash.containsKey(ruta)) {
					return;
				}
			}
		}
	}
	
	
	//en teoria, realiza las conexiones necesarias para llegar del punto al punto b un k iteraciones
	private void buscarElemento() {
		NodoG nodoActual;
		NodoG nodoConector;
		ElementoDeMatriz origenActual;
		ElementoDeMatriz actualDestino;
		for(int posNodo = 0; posNodo < grafo.getNodos().size(); posNodo++) {
			nodoConector = (NodoG) grafo.getNodos().get(posNodo);
			for(int arcoActual = 0; arcoActual< nodoConector.getArcos().size();arcoActual++) {
				nodoActual = (NodoG)nodoConector.getArcos().get(arcoActual);
				origenActual = new ElementoDeMatriz(ruta.getNodoOrigen(), nodoConector);
				actualDestino = new ElementoDeMatriz(nodoConector, nodoActual);
				if(tablaHash.containsKey(origenActual) && tablaHash.containsKey(actualDestino)) {
					tablaHash.put(new ElementoDeMatriz(ruta.getNodoOrigen(), nodoActual), nodoConector);
				}
				if(tablaHash.containsKey(ruta)) {
					return;
				}
			}
			
		}
	}
	
	// devuelve un array con los nodos para llegar del punto a al punto b, se debe recorrer alreves
	public ArrayList<NodoG> retornarCamino(){
		ArrayList<NodoG> camino = new ArrayList<>();
		camino.add(ruta.getNodoDestino());
		ElementoDeMatriz conectores = ruta;
		while(tablaHash.get(conectores) != null) {
			camino.add(tablaHash.get(conectores));
		}
		return camino;
	}
	









}
