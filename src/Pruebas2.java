import estructuras.AlgoritmosDeBusqueda.Subclasses.*;
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
        prueba.agregarArco( 1,nodoB, nodoC);
        prueba.agregarArco( 1,nodoC, nodoD);
        prueba.agregarArco( 3,nodoD, nodoE);
        prueba.agregarArco( 3,nodoD, nodoB);
        prueba.agregarArco( 3,nodoC, nodoA);
        prueba.agregarArco( 3,nodoE, nodoD);
        prueba.agregarArco( 3,nodoD, nodoA);
        prueba.agregarArco( 3,nodoD, nodoC);

        System.out.println( "Cantidad de Arcos " + prueba.getArcos().size());

        WarshallV2 d = new WarshallV2(prueba, nodoA, nodoE);
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

