package estructuras.AlgoritmosDeBusqueda.Subclasses;

import estructuras.Arco;
import estructuras.NodoG;

public class ElementoDeMatriz<T> {
    private NodoG<T> nodoOrigen;
    private NodoG<T> nodoDestino;

    public ElementoDeMatriz(NodoG<T> pNodoOrigen, NodoG<T> pNodoActual) {
        this.nodoOrigen = pNodoOrigen;
        this.nodoDestino = pNodoActual;
    }

    public NodoG<T> getNodoOrigen() {
        return nodoOrigen;
    }

	public NodoG<T> getNodoDestino() {
		return nodoDestino;
	}

}