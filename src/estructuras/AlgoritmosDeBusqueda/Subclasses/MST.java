package estructuras.AlgoritmosDeBusqueda.Subclasses;

import estructuras.AlgoritmosDeBusqueda.AlgoritmoDeBusqueda;
import estructuras.Arco;
import estructuras.GrafoND;
import estructuras.NodoG;

import java.util.ArrayList;

public class MST<T> extends AlgoritmoDeBusqueda {

    @Override
    public  ArrayList<NodoG<T>>  getPath(NodoG pInicio, NodoG pDestino, GrafoND pGrafo) {
        ArrayList resultado = algoritmoMST(pGrafo);
        return getPath(resultado, pInicio, pDestino);
    }

    private ArrayList<Arco<T>> algoritmoMST(GrafoND<T> pGrafo) {
        ArrayList<Arco<T>> mts = new ArrayList<>();
        Arco<T> tempArc;
        for(int pos = 0; pos < pGrafo.getArcos().size(); pos++) {
            tempArc = pGrafo.getArcos().get(pos);
            if(!tempArc.getPuntoA().isVisitado() && !tempArc.getPuntoB().isVisitado()) {
                mts.add(tempArc);
                tempArc.getPuntoA().setVisitado(true);
                tempArc.getPuntoB().setVisitado(true);
            }else if(!tempArc.getPuntoA().isVisitado() || !tempArc.getPuntoB().isVisitado()) {
                mts.add(tempArc);
                tempArc.getPuntoA().setVisitado(true);
                tempArc.getPuntoB().setVisitado(true);
            }
        }
        return mts;
    }

    private ArrayList<NodoG<T>> getPath(ArrayList<Arco<T>> pAlgoritmoMST, NodoG<T> pNodoA, NodoG<T> pNodoB){
        ArrayList<NodoG<T>> path = new ArrayList<>();
        NodoG<T> nodoActual = pNodoA;
        for (int index = 0 ; index < pAlgoritmoMST.size() ; index++){
            if (pAlgoritmoMST.get(index).getPuntoA() == nodoActual && !path.contains(pAlgoritmoMST.get(index).getPuntoA())){
                path.add(pAlgoritmoMST.get(index).getPuntoA());
                nodoActual = pAlgoritmoMST.get(index).getPuntoB();
                index = 0;
            }
            if (nodoActual == pNodoB) break;
        }
        return path;
    }

}
