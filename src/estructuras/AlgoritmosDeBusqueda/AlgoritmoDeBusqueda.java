package estructuras.AlgoritmosDeBusqueda;

import estructuras.GrafoND;
import estructuras.NodoG;

import java.util.ArrayList;

public abstract class AlgoritmoDeBusqueda<T> {

       public abstract ArrayList<NodoG<T>> getPath(NodoG<T> pInicio, NodoG<T> pDestino, GrafoND<T> pGrafo);

}
