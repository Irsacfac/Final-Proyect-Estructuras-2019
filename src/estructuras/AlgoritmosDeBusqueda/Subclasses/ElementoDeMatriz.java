package estructuras.AlgoritmosDeBusqueda.Subclasses;

import estructuras.Arco;
import estructuras.NodoG;

public class ElementoDeMatriz<T> implements Comparable<ElementoDeMatriz<T>>{
    private NodoG<T> nodoOrigen;
    private NodoG<T> nodoDestino;
    private NodoG<T> nodoAnterior;

    public ElementoDeMatriz(NodoG<T> pNodoOrigen, NodoG<T> pNodoDestino) {
        this.nodoOrigen = pNodoOrigen;
        this.nodoDestino = pNodoDestino;
        nodoAnterior = null;
    }

    public NodoG<T> getNodoOrigen() {
        return nodoOrigen;
    }

	public NodoG<T> getNodoDestino() {
		return nodoDestino;
	}
	
	protected void setNodoDestino(NodoG<T> pNodoDestino) {
		nodoDestino = pNodoDestino;
	}
	
	public NodoG<T> getNodoAnterior(){
		return nodoAnterior;
	}
	
	protected void setNodoAnterior(NodoG<T> pNodoAnterior){
		nodoAnterior = pNodoAnterior;
	}

	@Override
	public int compareTo(ElementoDeMatriz<T> pComparado) {
		if((nodoOrigen == pComparado.getNodoOrigen()) && (nodoDestino == pComparado.getNodoDestino())){
			return 0;
		}else {
			return -1;
		}
	}

}