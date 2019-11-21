package estructuras.AlgoritmosDeBusqueda.Subclasses;

import estructuras.AlgoritmosDeBusqueda.AlgoritmoDeBusqueda;
import estructuras.Arco;
import estructuras.GrafoND;
import estructuras.NodoG;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class Dijkstra extends AlgoritmoDeBusqueda {

    public ArrayList<ElementoTablaD> tablaD;

    public Dijkstra(NodoG pInicio, GrafoND pGrafo) {
        algoritmoDijkstra(pGrafo, pInicio);
    }

    @Override
    public  ArrayList<NodoG> getPath(NodoG pInicio, NodoG pDestino, GrafoND pGrafo) {
        ArrayList<NodoG> path = new ArrayList<>();
        NodoG origen;
        NodoG actual = pDestino;
        while(actual != pInicio){
            ElementoTablaD elementoActual = getElementoTablaD(actual);
            path.add(elementoActual.getNodoActual());
            origen = elementoActual.getOrigen();
            actual = origen;

        }
        path.add(pInicio);
        Collections.reverse(path);
        return path;
    }

    public void algoritmoDijkstra(GrafoND pGrafo, NodoG pInicio) {
        crearTablaDInicial(pGrafo, pInicio);
        ArrayList nodos = pGrafo.getNodos();
        ArrayList<NodoG> arrayF = new ArrayList<>();
        while (arrayF.size() < nodos.size()){
            ElementoTablaD nodoAnalizandose = getMenorPesoAcumulado(arrayF);
            actualizarTabla(pGrafo, nodoAnalizandose);
            arrayF.add(nodoAnalizandose.getNodoActual());
        }
    }

    public ElementoTablaD getMenorPesoAcumulado(ArrayList<NodoG> pArrayF){
        int menorPesoAcumulado = 0;
        ElementoTablaD elementoConMenorPeso = null;
        for (ElementoTablaD elementoTablaD : tablaD){
            if (!pArrayF.contains(elementoTablaD.getNodoActual()))
            {
                if(elementoConMenorPeso == null)
                {
                    elementoConMenorPeso = elementoTablaD;
                    menorPesoAcumulado = elementoConMenorPeso.getPesoAcumulado();
                }
                else if (elementoTablaD.getPesoAcumulado() <= menorPesoAcumulado)
                {
                    menorPesoAcumulado = elementoTablaD.getPesoAcumulado();
                    elementoConMenorPeso = elementoTablaD;
                }
            }


        }
        return elementoConMenorPeso;

    }
    
    public void actualizarTabla(GrafoND pGrafo, ElementoTablaD pElementoAnalizandose){

        ArrayList conexiones = pElementoAnalizandose.getNodoActual().getArcos();
        for (Object conexion : conexiones){
            ElementoTablaD elementoConectado = getElementoTablaD((NodoG)conexion);
            assert elementoConectado != null;
            procesarElemento(pGrafo, elementoConectado, pElementoAnalizandose);
        }

    }

    public void procesarElemento(GrafoND pGrafo, ElementoTablaD elementoActual, ElementoTablaD posElementoOrigen){
        NodoG nodoA = posElementoOrigen.getNodoActual();
        NodoG nodoB = elementoActual.getNodoActual();
        int posiblePesoAcumulado = posElementoOrigen.getPesoAcumulado() + pGrafo.getPesoDeUnArco(nodoA, nodoB);
        if (elementoActual.getPesoAcumulado() > posiblePesoAcumulado){
            elementoActual.setOrigen(nodoA);
            elementoActual.setPesoAcumulado(posiblePesoAcumulado);
        }
    }

    public void crearTablaDInicial(GrafoND pGrafo, NodoG pInicio){
        tablaD = new ArrayList<>();
        for (Object nodo : pGrafo.getNodos() ){
            if (nodo == pInicio) tablaD.add(new ElementoTablaD(0, (NodoG)nodo,(NodoG)nodo));
            else tablaD.add(new ElementoTablaD(Integer.MAX_VALUE, null, (NodoG)nodo));
        }
    }

    private ElementoTablaD getElementoTablaD(NodoG pSearching){
        for (ElementoTablaD elementoTablaD : tablaD){
            if (elementoTablaD.getNodoActual() == pSearching){
                return elementoTablaD;
            }
        }
        return null;
    }

    public ArrayList<ElementoTablaD> getTablaD() {
        return tablaD;
    }
}
