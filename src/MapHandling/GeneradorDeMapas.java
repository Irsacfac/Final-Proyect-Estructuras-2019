package MapHandling;

import estructuras.Arco;
import estructuras.GrafoND;
import estructuras.NodoG;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import otros.IConstants;

import java.util.ArrayList;

public class GeneradorDeMapas implements IConstants {

    private JSONObject jsonMap;

    public GeneradorDeMapas(String jsonMapPath){
        this.jsonMap = JSONReader.getInstance().parseJson(jsonMapPath);
    }

    public ArrayList<Obstaculo> getObstacles(){
        JSONArray jsonObstacles = (JSONArray)jsonMap.get("obstaculos");
        ArrayList<Obstaculo> obstacles = new ArrayList<>();
        for (int index = 0 ; index < jsonObstacles.size() ; index++){
            JSONObject jsonObstacle = (JSONObject) jsonObstacles.get(0);
            int x1 = Integer.parseInt((String)jsonObstacle.get("x1"));
            int y1 = Integer.parseInt((String)jsonObstacle.get("y1"));
            int x2 = Integer.parseInt((String)jsonObstacle.get("x2"));
            int y2 = Integer.parseInt((String)jsonObstacle.get("y2"));
            Obstaculo newObstacle = new Obstaculo(x1, y1, x2, y2);
            obstacles.add(newObstacle);
        }
        return obstacles;
    }

    public GrafoND<Casilla> generateMap(){
        GrafoND<Casilla> graph = new GrafoND<>();
        ArrayList<NodoG<Casilla>> nodes = generateNodes();
        graph.setNodos(nodes);
        ArrayList<Arco<Casilla>> arcs = generateArcs(nodes);
        graph.setArcos(arcs);
        return graph;
    }

    private ArrayList<NodoG<Casilla>> generateNodes(){
        ArrayList<NodoG<Casilla>> newNodes = new ArrayList<>();
        for (int columnNumber = 1 ; columnNumber < CANTIDAD_NODOS_ANCHURA - 1; columnNumber++)
            for (int rowNumber = 0 ; rowNumber < CANTIDAD_NODOS_ALTURA ; rowNumber++){
                Casilla newGrid = new Casilla(rowNumber, columnNumber);
                NodoG<Casilla> newNode = new NodoG<>(newGrid);
                if(isAValidNode(newNode)) newNodes.add(newNode);
                else System.out.println("NOT VALID:" + newNode.getElemento().getX1() + "," + newNode.getElemento().getY1() + "//"
                + newNode.getElemento().getX2() + "," + newNode.getElemento().getY2());
            }
        newNodes.addAll(flagGoals());
        return newNodes;
    }

    private ArrayList<Arco<Casilla>> generateArcs(ArrayList<NodoG<Casilla>> pNodes){
        ArrayList<Arco<Casilla>> arcs = new ArrayList<>();
        for (NodoG<Casilla> node : pNodes)
            for (NodoG<Casilla> otherNode : pNodes){
                if (isAdjacent(node, otherNode)){
                    node.agregarArco(otherNode);
                    otherNode.agregarArco(node);
                    Arco<Casilla> newArc = new Arco<>(1,node,otherNode);
                    arcs.add(newArc);
                }
            }

        return arcs;
    }

    private boolean isAdjacent(NodoG<Casilla> pNodeA, NodoG<Casilla> pNodeB){
        boolean adjacent = false;
        if (pNodeA.getElemento().getColumna() == pNodeB.getElemento().getColumna())
            if (pNodeB.getElemento().getFila() == pNodeA.getElemento().getFila() + 1) adjacent = true;

        if (pNodeA.getElemento().getFila() == pNodeB.getElemento().getFila())
            if (pNodeB.getElemento().getColumna() == pNodeA.getElemento().getColumna() + 1) adjacent = true;

        return adjacent;
    }

    private ArrayList<NodoG<Casilla>> flagGoals(){
        ArrayList<NodoG<Casilla>> flagGoals = new ArrayList<>();
        ArrayList<Casilla> reservedGrids = generateFlagGrids();
        for (Casilla grid : reservedGrids){
            NodoG<Casilla> newNode = new NodoG<>(grid);
            flagGoals.add(newNode);
        }
        return flagGoals;

    }

    private ArrayList<Casilla> generateFlagGrids(){
        ArrayList<Casilla> flagGrids = new ArrayList<>();
        Casilla cornerA1 = new Casilla(0,0);
        flagGrids.add(cornerA1);
        Casilla centerA = new Casilla(FILA_CENTRAL, 0);
        flagGrids.add(centerA);
        Casilla cornerA2 = new Casilla(CANTIDAD_NODOS_ALTURA - 1, 0);
        flagGrids.add(cornerA2);
        Casilla cornerB1 = new Casilla(0,CANTIDAD_NODOS_ANCHURA - 1);
        flagGrids.add(cornerB1);
        Casilla centerB = new Casilla(FILA_CENTRAL, CANTIDAD_NODOS_ANCHURA - 1);
        flagGrids.add(centerB);
        Casilla cornerB2 = new Casilla(CANTIDAD_NODOS_ALTURA - 1, CANTIDAD_NODOS_ANCHURA - 1);
        flagGrids.add(cornerB2);
        return flagGrids;
    }

//    private ArrayList<Arco<Casilla>> keepValidArcs(ArrayList<Arco<Casilla>> pArcs){
//
//
//        return null;
//    }
//
//    private boolean isAValidArc(Arco<Casilla> pArc){
//        ArrayList<Obstaculo> obstacles = getObstacles();
//        boolean isValid = true;
//        for (Obstaculo obstacle : obstacles){
//            int xRange = obstacle.x2 - obstacle.x1;
//            int yRange = obstacle.y2 - obstacle.y1;
//        }
//        return isValid;
//    }
    private boolean isAValidNode(NodoG<Casilla> pNode){
        ArrayList<Obstaculo> obstacles = getObstacles();
        boolean isValid = true;
        for (Obstaculo obstacle : obstacles){
            if (existsXIntersection(pNode, obstacle) && existsYIntersection(pNode, obstacle)) isValid = false;
        }
        return isValid;
    }
    
    private boolean existsXIntersection(NodoG<Casilla> pNode, Obstaculo pObstacle){
        int nodeX1 = pNode.getElemento().getX1();
        int nodeX2 = pNode.getElemento().getX2();
        return (isBetween(nodeX1, pObstacle.x1, nodeX2) || isBetween(nodeX1, pObstacle.x2, nodeX2) ||
                isBetween(pObstacle.x1, nodeX1, pObstacle.x2) || isBetween(pObstacle.x1, nodeX2, pObstacle.x2));
    }
    private boolean existsYIntersection(NodoG<Casilla> pNode, Obstaculo pObstacle){
        int nodeY1 = pNode.getElemento().getY1();
        int nodeY2 = pNode.getElemento().getY2();
        return (isBetween(nodeY1, pObstacle.y1, nodeY2) || isBetween(nodeY1, pObstacle.y2, nodeY2) ||
                isBetween(pObstacle.y1, nodeY1, pObstacle.y2) || isBetween(pObstacle.y1, nodeY2, pObstacle.y2));
    }
        
    

    private boolean isBetween(int A, int B, int C){
        return (A <= B && B <= C);
    }








}
