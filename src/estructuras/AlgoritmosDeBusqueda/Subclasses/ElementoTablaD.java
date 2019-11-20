package estructuras.AlgoritmosDeBusqueda.Subclasses;

import estructuras.NodoG;

public class ElementoTablaD {

    private int pesoAcumulado;
    private NodoG origen;
    private NodoG nodoActual;

    public ElementoTablaD(int pPesoAcumulado, NodoG pOrigen, NodoG pNodoActual) {
        this.pesoAcumulado = pPesoAcumulado;
        this.origen = pOrigen;
        this.nodoActual = pNodoActual;
    }

    public void setPesoAcumulado(int pesoAcumulado) {
        this.pesoAcumulado = pesoAcumulado;
    }

    public void setOrigen(NodoG origen) {
        this.origen = origen;
    }

    public void setNodoActual(NodoG nodoActual) {
        this.nodoActual = nodoActual;
    }

    public int getPesoAcumulado() {
        return pesoAcumulado;
    }

    public NodoG getOrigen() {
        return origen;
    }

    public NodoG getNodoActual() {
        return nodoActual;
    }

}
