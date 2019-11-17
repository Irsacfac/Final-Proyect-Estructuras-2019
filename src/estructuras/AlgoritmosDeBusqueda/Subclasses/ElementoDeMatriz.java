package estructuras.AlgoritmosDeBusqueda.Subclasses;

import estructuras.NodoG;

public class ElementoDeMatriz<T> {

    private NodoG<T> nodoOrigen;
    private NodoG<T> nodoActual;
    private int PsubK;


    public ElementoDeMatriz(NodoG<T> nodoOrigen, NodoG<T> nodoActual, int PsubK) {
        this.nodoOrigen = nodoOrigen;
        this.nodoActual = nodoActual;
        this.PsubK = PsubK;
    }

    public NodoG<T> getNodoOrigen() {
        return nodoOrigen;
    }

    public NodoG<T> getNodoActual() {
        return nodoActual;
    }

    public int getPsubK() {
        return PsubK;
    }

}