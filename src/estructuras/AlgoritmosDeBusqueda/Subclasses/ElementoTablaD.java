package estructuras.AlgoritmosDeBusqueda.Subclasses;

import estructuras.NodoG;

public class ElementoTablaD<T> {

    private int pesoAcumulado;
    private NodoG<T> origen;
    private NodoG<T> nodoActual;

    public ElementoTablaD(int pPesoAcumulado, NodoG<T> pOrigen, NodoG<T> pNodoActual) {
        this.pesoAcumulado = pPesoAcumulado;
        this.origen = pOrigen;
        this.nodoActual = pNodoActual;
    }

    public void setPesoAcumulado(int pesoAcumulado) {
        this.pesoAcumulado = pesoAcumulado;
    }

    public void setOrigen(NodoG<T> origen) {
        this.origen = origen;
    }

    public void setNodoActual(NodoG<T> nodoActual) {
        this.nodoActual = nodoActual;
    }

    public int getPesoAcumulado() {
        return pesoAcumulado;
    }

    public NodoG<T> getOrigen() {
        return origen;
    }

    public NodoG<T> getNodoActual() {
        return nodoActual;
    }

}
