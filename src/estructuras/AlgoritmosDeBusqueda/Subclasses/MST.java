package estructuras.AlgoritmosDeBusqueda.Subclasses;

import MapHandling.Casilla;
import estructuras.AlgoritmosDeBusqueda.AlgoritmoDeBusqueda;
import estructuras.Arco;
import estructuras.GrafoND;
import estructuras.NodoG;

import java.util.ArrayList;
import java.util.Collections;

public class MST extends AlgoritmoDeBusqueda {

    @Override
    public ArrayList<NodoG> getPath(NodoG pNodoA, NodoG pNodoB, GrafoND pGrafo)
    {

     ArrayList resultado = algoritmoMST(pGrafo);
        ArrayList<NodoG> path = new ArrayList<>();

        int index = 0;
        ArrayList<NodoG> pathNodeA = calculatePathToRoot(pNodoA, pNodoB, resultado);
        ArrayList<NodoG> pathNodeB = calculatePathToRoot(pNodoB, pNodoA, resultado);
        return determinePath(pathNodeA, pNodoA, pathNodeB, pNodoB);
    }

    public ArrayList<NodoG> calculatePathToRoot(NodoG pNodoA, NodoG pNodoB, ArrayList resultado){
        NodoG nodoActual = pNodoA;
        ArrayList<NodoG> individualPath = new ArrayList<>();
        int index = 0;
        while (index < resultado.size())
        {
            NodoG nodoAnalizandose = ((Arco)resultado.get(index)).getPuntoB();
            if (nodoAnalizandose == nodoActual && !individualPath.contains(nodoAnalizandose))
            {
                individualPath.add(((Arco)resultado.get(index)).getPuntoB());
                nodoActual = ((Arco)resultado.get(index)).getPuntoA();
                //System.out.println(((Casilla)nodoActual.getElemento()).getFila()+"-"+((Casilla)nodoActual.getElemento()).getColumna());
                index = 0;
                if (nodoActual == pNodoB) break;
            }
            else index++;
        }
        individualPath.add(nodoActual);
        return individualPath;
    }

    private ArrayList<NodoG> determinePath(ArrayList<NodoG> pathA, NodoG pNodoA, ArrayList<NodoG> pathB, NodoG pNodoB){
        if (pathA.contains(pNodoB)) {
            Collections.reverse(pathA);
            return pathA;
        }
        else if (pathB.contains(pNodoA)) return pathB;
        else {
            return concatPaths(pathA,  pathB);
        }

    }
    private ArrayList<NodoG> concatPaths(ArrayList<NodoG> pathA, ArrayList<NodoG> pathB){
        Collections.reverse(pathB);
        pathA.addAll(pathB);
        return pathA;
    }


    public ArrayList<Arco> algoritmoMST(GrafoND pGrafo) {
        ArrayList<Arco> mts = new ArrayList<>();
        Arco tempArc;
        for(int pos = 0; pos < pGrafo.getArcos().size(); pos++) {
            tempArc = (Arco) pGrafo.getArcos().get(pos);
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
}
