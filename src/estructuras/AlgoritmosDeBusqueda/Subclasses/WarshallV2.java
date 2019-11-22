package estructuras.AlgoritmosDeBusqueda.Subclasses;

import MapHandling.Casilla;
import estructuras.AlgoritmosDeBusqueda.AlgoritmoDeBusqueda;
import estructuras.Arco;
import estructuras.GrafoND;
import estructuras.NodoG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class WarshallV2 extends AlgoritmoDeBusqueda {

    private Hashtable<String, MatrixElementV2> hashtable;
    private GrafoND graph;
    private NodoG nodeA;
    private NodoG nodeB;
    private String searchingkey;

    public WarshallV2(GrafoND graph, NodoG nodeA, NodoG nodeB) {
        this.graph = graph;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.searchingkey = nodeA.getId() + "-" + nodeB.getId();
        createInitialHashtable();
    }

    @Override
    public ArrayList<NodoG> getPath(NodoG pInicio, NodoG pDestino, GrafoND pGrafo) {
        warshallAlgorithm();
        return returnPath();
    }

    private void warshallAlgorithm(){
        System.out.println("Start building paths");
        ArrayList nodes = graph.getNodos();

        for (Object j : nodes)
            for (Object k : nodes)
                for (Object i : nodes){
                    if (i != j && i != k && j != k){
                        String iID = ((NodoG)i).getId();
                        String jID = ((NodoG)j).getId();
                        String kID = ((NodoG)k).getId();

                        String ij = iID + "-" + jID;
                        String ji = jID + "-" + iID;
                        String ik = iID + "-" + kID;
                        String kj = kID + "-" + jID;




                        if (!exists(ij) && !exists(ji) && exists(ik) && exists(kj)){
                            System.out.println("i " + ((NodoG<Casilla>)i).getElemento().getColumna() + "-" + ((NodoG<Casilla>)i).getElemento().getFila());
                            System.out.println("j " + ((NodoG<Casilla>)j).getElemento().getColumna() + "-" + ((NodoG<Casilla>)j).getElemento().getFila());
                            System.out.println("k " + ((NodoG<Casilla>)k).getElemento().getColumna() + "-" + ((NodoG<Casilla>)k).getElemento().getFila());

                            hashtable.put(ij, new MatrixElementV2(((NodoG)i),((NodoG)k),((NodoG)j)));
                            hashtable.put(ji, new MatrixElementV2(((NodoG)j),((NodoG)k),((NodoG)i)));

                             if (ij.equals(searchingkey) || ji.equals(searchingkey)) break;
                        }
                    }

                }

        System.out.println("found a path");
    }

    private ArrayList<NodoG> returnPath(){

        MatrixElementV2 element = hashtable.get(searchingkey);
        String searchingNodeID = element.originNode.getId();
        ArrayList<NodoG> path = new ArrayList<>();
        path.add(element.currentNode);
        while (element.conexionNode != null){
            path.add(element.conexionNode);
            String connectionId = element.conexionNode.getId();
            String elementKey = searchingNodeID + "-" + connectionId;
            element = hashtable.get(elementKey);
        }
        path.add(element.originNode);
        Collections.reverse(path);
        return path;
    }

    private void createInitialHashtable(){
        hashtable = new Hashtable<>();
        for (Object node : graph.getArcos()){

            NodoG nodeA = ((Arco)node).getPuntoA();
            NodoG nodeB = ((Arco)node).getPuntoB();

            String idA = nodeA.getId();
            String idB = nodeB.getId();

            String keyA = idA + "-" + idB;
            String keyB = idB + "-" + idA;

            if (!exists(keyA) && !exists(keyB)){
                hashtable.put(keyA, new MatrixElementV2(nodeA,null, nodeB));
                hashtable.put(keyB,  new MatrixElementV2(nodeB,null, nodeA));
            }
        }
    }

    private boolean exists(String key){
        return hashtable.get(key) != null;
    }
}
