package estructuras.AlgoritmosDeBusqueda.Subclasses;

import estructuras.AlgoritmosDeBusqueda.AlgoritmoDeBusqueda;
import estructuras.Arco;
import estructuras.GrafoND;
import estructuras.NodoG;

import java.util.ArrayList;
import java.util.Vector;

public class MST<T> extends AlgoritmoDeBusqueda {

    @Override
    public  ArrayList<NodoG<T>>  getPath(NodoG pInicio, NodoG pDestino, GrafoND pGrafo) {
        return null;
    }

    public ArrayList<Arco<T>> algoritmoMST(GrafoND<T> pGrafo) {
        ArrayList<Arco<T>> mts = new ArrayList<>();
        Arco tempArc;
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

    public ArrayList<Arco<T>> ordenarResultado(ArrayList<Arco<T>> arcosDesordenados){
        ArrayList<Arco<T>> arcosOrdenados = new ArrayList<>();
        for (Arco<T> arco : arcosDesordenados){

            if (arcosOrdenados == null){

            }

        }
        return arcosOrdenados;
    }



}
