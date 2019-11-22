import estructuras.AlgoritmosDeBusqueda.Subclasses.Dijkstra;
import estructuras.AlgoritmosDeBusqueda.Subclasses.ElementoTablaD;
import estructuras.AlgoritmosDeBusqueda.Subclasses.MST;
import estructuras.AlgoritmosDeBusqueda.Subclasses.Warshall;
import estructuras.Arco;
import estructuras.GrafoND;
import estructuras.NodoG;

import java.util.ArrayList;

public class Pruebas2 {
    public static void main(String[] args) {

        GrafoND<String> prueba = new GrafoND<>();

        NodoG<String> nodoA = new NodoG<>("A");
        NodoG<String> nodoB = new NodoG<>("B");
        NodoG<String> nodoC = new NodoG<>("C");
        NodoG<String> nodoD = new NodoG<>("D");
        NodoG<String> nodoE = new NodoG<>("E");

        prueba.agregarNodo(nodoA);
        prueba.agregarNodo(nodoB);
        prueba.agregarNodo(nodoC);
        prueba.agregarNodo(nodoD);
        prueba.agregarNodo(nodoE);

        prueba.agregarArco( 2,nodoA,nodoB);
        prueba.agregarArco( 3,nodoA, nodoD);
        prueba.agregarArco( 1,nodoA, nodoC);
        prueba.agregarArco( 1,nodoC, nodoD);
        prueba.agregarArco( 3,nodoC, nodoB);
        prueba.agregarArco( 4,nodoD, nodoB);
        prueba.agregarArco( 2,nodoD, nodoE);
        prueba.agregarArco( 1,nodoB, nodoE);

        System.out.println( "Cantidad de Arcos " + prueba.getArcos().size());

        Warshall d = new Warshall(prueba, nodoA, nodoE);
//        ArrayList<Arco> algoritmo = mst.algoritmoMST(prueba);
//        for (Arco arco : algoritmo){
//            System.out.println(arco.getPuntoA().getElemento()+""+arco.getPuntoB().getElemento());
//        }

        ArrayList path = d.getPath(nodoA, nodoE, prueba);
        System.out.println("\n"+"Final path");
        for (Object nodo : path){
            System.out.println(((NodoG)nodo).getElemento());
        }


    }
}

