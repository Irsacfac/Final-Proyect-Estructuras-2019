package estructuras.AlgoritmosDeBusqueda.Subclasses;

import estructuras.Arco;
import estructuras.NodoG;

public class ElementoDeMatriz<T> {
    private NodoG<T> nodoOrigen;
    private NodoG<T> nodoDestino;
    private NodoG<T> nodoAnterior;

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
	
	public NodoG getNodoAnterior() {
		return nodoAnterior;
	}
}