package estructuras.AlgoritmosDeBusqueda.Subclasses;

import estructuras.AlgoritmosDeBusqueda.AlgoritmoDeBusqueda;
import estructuras.Arco;
import estructuras.GrafoND;
import estructuras.NodoG;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Warshall<T> extends AlgoritmoDeBusqueda {

    @Override
    public ArrayList<NodoG<T>> getPath(NodoG pInicio, NodoG pDestino, GrafoND pGrafo) {
        return null;
    }

    public ArrayList<NodoG<T>> algoritmoWarshall(GrafoND<T> pGrafo){
        return null;
    }

    private boolean connectionExists(int i, int j, GrafoND<T> pGrafo){
        //Determina el nodo en la posicion i y j de la lista de adyacencia del  grafo.
        //Busca al elemento de indice j en el array de conexiones del elemento de indice i.
        //Devuelve el valor de verdad de lo anterior.
        return pGrafo.getNodos().get(i).getArcos().contains(pGrafo.getNodos().get(j));
    }







}
