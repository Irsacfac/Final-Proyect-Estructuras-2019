package estructuras.AlgoritmosDeBusqueda.Subclasses;

import estructuras.AlgoritmosDeBusqueda.AlgoritmoDeBusqueda;
import estructuras.Arco;
import estructuras.GrafoND;
import estructuras.NodoG;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;

public class Warshall<T> extends AlgoritmoDeBusqueda {

	private Hashtable<String, ElementoDeMatriz<T>> tablaHash;
	private GrafoND<T> grafo;
	private NodoG<T> nodoParada;
	private String ruta;
	private Vector<Vector<ElementoDeMatriz<T>>> recorrido;
	
	public Warshall(GrafoND pGrafo, NodoG pPartida, NodoG pDestino) {
		grafo = pGrafo;
		ruta = pPartida.getId() +"-"+ pDestino.getId();
		nodoParada = pPartida;
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
		System.out.println("Arcos directos");
		NodoG<T> nodoActual;
		NodoG<T> arcoActual;
		ElementoDeMatriz<T> elementoActual;
		//recorrido.add(new Vector<>());
		for(int posNodo = 0; posNodo < grafo.getNodos().size(); posNodo++) {
			nodoActual = grafo.getNodos().get(posNodo);
			for(int posArco = 0; posArco < nodoActual.getArcos().size(); posArco++) {
				arcoActual = nodoActual.getArcos().get(posArco);
				tablaHash.put(nodoActual.getId() +"-"+ arcoActual.getId(), new ElementoDeMatriz<>(nodoActual, arcoActual, null));
				//tablaHash.put(arcoActual.getId() +"-"+ nodoActual.getId(), new ElementoDeMatriz<>(nodoActual, arcoActual, null));
			}
		}
		/*for(int posNodo = 0; posNodo < grafo.getNodos().size(); posNodo++) {
			nodoActual = grafo.getNodos().get(posNodo);
			for(int conecciones = 0; conecciones < nodoActual.getArcos().size(); conecciones++) {
				tablaHash.put(new ElementoDeMatriz(nodoActual,(NodoG)nodoActual.getArcos().get(conecciones)), null);
				if(tablaHash.containsKey(ruta)) {
					return;
				}
			}
		}*/
	}
	
	
	//en teoria, realiza las conexiones necesarias para llegar del punto al punto b un k iteraciones
	private void buscarElemento() {
		System.out.println("Conectando caminos");
		ArrayList<NodoG<T>> todosNodos = grafo.getNodos();
		NodoG<T> nodoInicio;
		NodoG<T> nodoConector;
		NodoG<T> nodoFin;
		ElementoDeMatriz<T> elementoActual;
		ElementoDeMatriz<T> origenActual;
		ElementoDeMatriz<T> actualDestino;
		for(int posNodoInicio = 0; posNodoInicio < todosNodos.size(); posNodoInicio++) {
			nodoInicio = todosNodos.get(posNodoInicio);
			for(int posConector = 0; posConector < todosNodos.size(); posConector++) {
				nodoConector = todosNodos.get(posConector);
				for(int posFin = 0; posFin < todosNodos.size(); posFin++) {
					nodoFin = todosNodos.get(posFin);
					if((tablaHash.get(nodoInicio.getId() +"-"+ nodoConector.getId()) != null) && (tablaHash.get(nodoConector.getId() +"-"+ nodoFin.getId()) != null)){
						tablaHash.put(nodoInicio.getId() +"-"+ nodoFin.getId(), new ElementoDeMatriz<>(nodoInicio, nodoFin, nodoConector));
					}
					if(tablaHash.get(ruta) != null) {
						return;
					}
				}
			}
		}
		/*int elementos = 0;
		Vector<ElementoDeMatriz<T>> previo;
		Vector<ElementoDeMatriz<T>> actual;
		while(elementoActual.compareTo(ruta) != 0) {
			System.out.println("Inicio while");
			recorrido.add(new Vector<>());
			previo = recorrido.elementAt(elementos);
			actual = recorrido.lastElement();
			elementos++;
			for(int pos = 0; pos<previo.size();pos++) {
				System.out.println("Pos: " + pos);
				for(int element =0; element<previo.size();element++) {
					System.out.println("Segundo for");
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
		}*/
		/*for(int posNodo = 0; posNodo < grafo.getNodos().size(); posNodo++) {
			nodoConector = grafo.getNodos().get(posNodo);
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
			
		}*/
	}
	
	// devuelve un array con los nodos para llegar del punto a al punto b, se debe recorrer alreves
	public ArrayList<NodoG<T>> retornarCamino(){
		System.out.println("Retornar camono warshall");
		Vector<T> actual = new Vector<>();
		//ElementoDeMatriz<T> elementoActual = ruta;
		int contador;
		Stack<NodoG<T>> pila = new Stack<>();
		ArrayList<NodoG<T>> camino = new ArrayList<>();
		pila.push(tablaHash.get(ruta).getNodoDestino());
		camino.add(tablaHash.get(ruta).getNodoDestino());
		System.out.println("Primer elemento: " + tablaHash.get(ruta).getNodoDestino().getElemento());
		while(tablaHash.get(ruta).getNodoAnterior() != null) {
			System.out.println("Siguiente elemento: " + tablaHash.get(ruta).getNodoAnterior().getElemento());
			pila.push(tablaHash.get(ruta).getNodoAnterior());
			camino.add(tablaHash.get(ruta).getNodoAnterior());
			ruta = nodoParada.getId() +"-"+ tablaHash.get(ruta).getNodoAnterior().getId();
		}
		camino.add(tablaHash.get(ruta).getNodoOrigen());
		/*while(!pila.empty()) {
			camino.add(pila.pop());
		}*/
		//camino.add(elementoActual.getNodoDestino());
		/*for(int pos = recorrido.size()-1; pos > 0; pos--) {
			
			actual = recorrido.elementAt(pos);
			contador = actual.size()-1;
			while((ruta.compareTo(elementoActual) != 0) || (contador >= 0)) {
				contador--;
				elementoActual = actual.elementAt(contador);
			}
			
			ruta.setNodoDestino(elementoActual.getNodoAnterior());
			camino.add(elementoActual.getNodoAnterior());
		}*/
		//ElementoDeMatriz<T> conectores = ruta;
		/*while(conectores.getNodoAnterior() != null) {
			conectores = tablaHash.get(conectores);
			camino.add(conectores.getNodoAnterior());
			System.out.println(contador);
			contador++;
		}*/
		return camino;
	}
	









}
