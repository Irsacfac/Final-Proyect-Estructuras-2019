package estructuras.AlgoritmosDeBusqueda.Subclasses;

import estructuras.Arco;
import estructuras.NodoG;

public class ElementoDeMatriz<T> {
    private NodoG<T> nodoOrigen;
    private NodoG<T> nodoDestino;

    public ElementoDeMatriz(NodoG<T> pNodoOrigen, NodoG<T> pNodoDestino) {
        this.nodoOrigen = pNodoOrigen;
        this.nodoDestino = pNodoDestino;
    }

    public NodoG<T> getNodoOrigen() {
        return nodoOrigen;
    }

	public NodoG<T> getNodoDestino() {
		return nodoDestino;
	}

}