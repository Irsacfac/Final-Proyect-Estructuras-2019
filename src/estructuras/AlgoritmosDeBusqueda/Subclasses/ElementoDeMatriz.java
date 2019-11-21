package estructuras.AlgoritmosDeBusqueda.Subclasses;

import estructuras.Arco;
import estructuras.NodoG;

public class ElementoDeMatriz {
    private NodoG nodoOrigen;
    private NodoG nodoDestino;

    public ElementoDeMatriz(NodoG pNodoOrigen, NodoG pNodoDestino) {
        this.nodoOrigen = pNodoOrigen;
        this.nodoDestino = pNodoDestino;
    }
    
    public ElementoDeMatriz(NodoG<T> pNodoOrigen, NodoG<T> pNodoDestino, NodoG<T> pNodoAanterior) {
    	this.nodoOrigen = pNodoOrigen;
        this.nodoDestino = pNodoDestino;
        nodoAnterior = pNodoAanterior;
    }

    public NodoG getNodoOrigen() {
        return nodoOrigen;
    }

	public NodoG getNodoDestino() {
		return nodoDestino;
	}

}