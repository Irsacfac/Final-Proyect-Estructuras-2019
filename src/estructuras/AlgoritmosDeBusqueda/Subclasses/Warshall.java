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
	private ElementoDeMatriz<T> ruta;
	
	public Warshall(GrafoND<T> pGrafo, NodoG<T> pPartida, NodoG<T> pDestino) {
		grafo = pGrafo;
		ruta = new ElementoDeMatriz<>(pPartida, pDestino);
		tablaHash = new Hashtable<>();
		
		this.arcosDirectos();
		this.buscarElemento();
	}
	
	private void arcosDirectos() {
		while(tablaHash.containsKey(ruta)) {
			
		}
	}
	
	private void buscarElemento() {
		while(tablaHash.containsKey(ruta)) {
			
		}
	}
    @Override
    public ArrayList<NodoG<T>> getPath(NodoG pInicio, NodoG pDestino, GrafoND pGrafo) {
        return null;
    }
//
//    public ArrayList<NodoG<T>> algoritmoWarshall(GrafoND<T> pGrafo, NodoG<T> pNodoA, NodoG<T> pNodoB){
//
//
//
//    }
//
//    private ArrayList<ElementoDeMatriz<T>> generarP0(GrafoND<T> pGrafo  ){
//
//    }

    private boolean existeConexion(int i, int j, GrafoND<T> pGrafo){
        return pGrafo.getNodos().get(i).getArcos().contains(pGrafo.getNodos().get(j));
    }

    private Arco<T> getConexion(int i, int j, GrafoND<T> pGrafo){
        ArrayList<Arco<T>> conexiones = pGrafo.getArcos();
        NodoG<T> nodoA = pGrafo.getNodos().get(i);
        NodoG<T> nodoB = pGrafo.getNodos().get(j);
        for (Arco<T> conexion : conexiones){
            if (conexion.getPuntoA() == nodoA && conexion.getPuntoB() == nodoB){
                return conexion;
            }
        }
        return null;
    }







}
