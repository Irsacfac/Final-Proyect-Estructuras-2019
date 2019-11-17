package estructuras.AlgoritmosDeBusqueda.Subclasses;

import estructuras.AlgoritmosDeBusqueda.AlgoritmoDeBusqueda;
import estructuras.Arco;
import estructuras.GrafoND;
import estructuras.NodoG;

import java.util.ArrayList;
import java.util.Collections;

public class Dijkstra<T> extends AlgoritmoDeBusqueda {

    @Override
    public  ArrayList<NodoG<T>>  getPath(NodoG pInicio, NodoG pDestino, GrafoND pGrafo) {
        ArrayList<ElementoTablaD<T>> dijkstraResult = algoritmoDijkstra(pGrafo, pInicio);
        ArrayList<NodoG<T>> path = new ArrayList<>();
        NodoG<T> origen;
        NodoG<T> actual = getElementoTablaD(pDestino, dijkstraResult).getNodoActual();
        while (actual != pInicio){
            ElementoTablaD<T> elementoActual = getElementoTablaD(actual,  dijkstraResult);
            path.add(elementoActual.getNodoActual());
            origen = elementoActual.getOrigen();
            actual = origen;
        }
        Collections.reverse(path);
        return path;
    }

    public ArrayList<ElementoTablaD<T>> algoritmoDijkstra(GrafoND<T> pGrafo, NodoG<T> pInicio) {
        ArrayList<ElementoTablaD<T>> tablaD = crearTablaDInicial(pGrafo, pInicio);
        ArrayList<NodoG<T>> nodos = pGrafo.getNodos();
        ArrayList<NodoG<T>> arrayF = new ArrayList<>();
        while (arrayF.size() < nodos.size()){
            ElementoTablaD<T> nodoAnalizandose = getMenorPesoAcumulado(tablaD, arrayF);
            tablaD  = actualizarTabla(pGrafo, nodoAnalizandose, tablaD);
            arrayF.add(nodoAnalizandose.getNodoActual());
        }

        return tablaD;

    }

    public ElementoTablaD<T> getMenorPesoAcumulado(ArrayList<ElementoTablaD<T>> pTablaD, ArrayList<NodoG<T>> pArrayF){
        int menorPesoAcumulado = Integer.MAX_VALUE;
        ElementoTablaD<T> elementoConMenorPeso;
        elementoConMenorPeso = new ElementoTablaD<T>(menorPesoAcumulado, null, null);
        for (ElementoTablaD<T> elementoTablaD:pTablaD){
            if (elementoTablaD.getPesoAcumulado()<=menorPesoAcumulado && !pArrayF.contains(elementoTablaD.getNodoActual())) {
                menorPesoAcumulado = elementoTablaD.getPesoAcumulado();
                elementoConMenorPeso = elementoTablaD;
            }

        }
        return elementoConMenorPeso;
    }


    private ArrayList<ElementoTablaD<T>> actualizarTabla(GrafoND<T> pGrafo, ElementoTablaD<T> pNodoAnalizandose, ArrayList<ElementoTablaD<T>> tablaD){

        for (ElementoTablaD<T> elementoTablaD : tablaD){
        if (pNodoAnalizandose.getNodoActual().getArcos().contains(elementoTablaD.getNodoActual()))
            if(pNodoAnalizandose.getPesoAcumulado() + getPesoDeUnArco(pGrafo, pNodoAnalizandose.getNodoActual(), elementoTablaD.getNodoActual()) < elementoTablaD.getPesoAcumulado()){
                elementoTablaD.setPesoAcumulado(pNodoAnalizandose.getPesoAcumulado()+elementoTablaD.getPesoAcumulado());
            }
    }
        return tablaD;
}

    private ArrayList<ElementoTablaD<T>> crearTablaDInicial(GrafoND<T> pGrafo, NodoG<T> pInicio){
        ArrayList<ElementoTablaD<T>> tablaD = new ArrayList<>();
        for (NodoG<T> nodo : pGrafo.getNodos() ){
            if (nodo == pInicio) tablaD.add(new ElementoTablaD<>(0, nodo, nodo));
            else tablaD.add(new ElementoTablaD<>(Integer.MAX_VALUE, null, nodo));
        }
        return tablaD;
    }


    private int getPesoDeUnArco(GrafoND<T> pGrafo , NodoG<T> pNodoA, NodoG<T> pNodoB){
        for (Arco<T> arco : pGrafo.getArcos()){
            if (arco.getPuntoB()==pNodoB && arco.getPuntoA() == pNodoA) return arco.getPeso();
        }
        return Integer.MAX_VALUE;
    }

    private ElementoTablaD<T> getElementoTablaD(NodoG<T> pSearching, ArrayList<ElementoTablaD<T>> pDijkstraResult){
        for (ElementoTablaD<T> elementoTablaD : pDijkstraResult){
            if (elementoTablaD.getNodoActual() == pSearching){
                return elementoTablaD;
            }
        }
        return null;
    }


}
