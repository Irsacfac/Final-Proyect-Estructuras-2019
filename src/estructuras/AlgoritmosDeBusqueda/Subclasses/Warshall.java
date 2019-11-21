package estructuras.AlgoritmosDeBusqueda.Subclasses;

import estructuras.AlgoritmosDeBusqueda.AlgoritmoDeBusqueda;
import estructuras.Arco;
import estructuras.GrafoND;
import estructuras.NodoG;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;

public class Warshall<T> extends AlgoritmoDeBusqueda {

	private Hashtable<ElementoDeMatriz<T>, ElementoDeMatriz<T>> tablaHash;
	private GrafoND<T> grafo;
	private NodoG<T> nodoParada;
	private ElementoDeMatriz<T> ruta;
	private Vector<Vector<ElementoDeMatriz<T>>> recorrido;
	
	public Warshall(GrafoND<T> pGrafo, NodoG<T> pPartida, NodoG<T> pDestino) {
		grafo = pGrafo;
		ruta = new ElementoDeMatriz<>(pPartida, pDestino);
		nodoParada = new NodoG<>(null);
		tablaHash = new Hashtable<>();
		recorrido = new Vector<>();
		
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
		recorrido.add(new Vector<>());
		for(int posNodo = 0; posNodo < grafo.getNodos().size(); posNodo++) {
			nodoActual = grafo.getNodos().get(posNodo);
			for(int conecciones = 0; conecciones < nodoActual.getArcos().size(); conecciones++) {
				elementoActual = new ElementoDeMatriz<>(nodoActual, nodoActual.getArcos().get(conecciones));
				tablaHash.put(elementoActual, elementoActual);
				recorrido.firstElement().add(elementoActual);
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
		ElementoDeMatriz<T> elementoActual = recorrido.firstElement().firstElement();
		ElementoDeMatriz<T> origenActual;
		ElementoDeMatriz<T> actualDestino;
		int elementos = 0;
		Vector<ElementoDeMatriz<T>> previo;
		Vector<ElementoDeMatriz<T>> actual;
		while(elementoActual.compareTo(ruta) != 0) {
			recorrido.add(new Vector<>());
			previo = recorrido.elementAt(elementos);
			actual = recorrido.lastElement();
			elementos++;
			for(int pos = 0; pos<previo.size();pos++) {
				for(int element =0; element<previo.size();element++) {
					origenActual = previo.elementAt(pos);
					actualDestino = previo.elementAt(element);
					if((elementos == 1) && (origenActual.getNodoDestino() == actualDestino.getNodoOrigen())) {
						elementoActual = new ElementoDeMatriz<>(origenActual.getNodoOrigen(),actualDestino.getNodoDestino());
						elementoActual.setNodoAnterior(actualDestino.getNodoOrigen());
						actual.add(elementoActual);
					}else if(origenActual.getNodoDestino() == actualDestino.getNodoAnterior()) {
						elementoActual = new ElementoDeMatriz<>(origenActual.getNodoOrigen(),actualDestino.getNodoDestino());
						elementoActual.setNodoAnterior(actualDestino.getNodoOrigen());
						actual.add(elementoActual);
					}
				}
			}
		}
		/*for(int posNodo = 0; posNodo < grafo.getNodos().size(); posNodo++) {
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
				}
			}
			
		}*/
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
