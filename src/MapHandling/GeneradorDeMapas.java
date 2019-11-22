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
    private GrafoND<Casilla> generatingMap;

    public GeneradorDeMapas(String jsonMapPath){
        this.jsonMap = JSONReader.getInstance().parseJson(jsonMapPath);
        generateMap();
    }

    public ArrayList<Obstaculo> getObstacles(){
        JSONArray jsonObstacles = (JSONArray)jsonMap.get("obstaculos");
        ArrayList<Obstaculo> obstacles = new ArrayList<>();
        for (int index = 0 ; index < jsonObstacles.size() ; index++){
            JSONObject jsonObstacle = (JSONObject) jsonObstacles.get(index);
            int x1 = Integer.parseInt((String)jsonObstacle.get("x1"));
            int y1 = Integer.parseInt((String)jsonObstacle.get("y1"));
            int x2 = Integer.parseInt((String)jsonObstacle.get("x2"));
            int y2 = Integer.parseInt((String)jsonObstacle.get("y2"));
            Obstaculo newObstacle = new Obstaculo(x1, y1, x2, y2);
            obstacles.add(newObstacle);
        }
        return obstacles;
    }

    public void generateMap() {
        generatingMap = new GrafoND<>();
        generateNodes();
        generateArcs();
    }

    private void generateNodes(){
        ArrayList<NodoG<Casilla>> newNodes = new ArrayList<>();
        for (int columnNumber = 1 ; columnNumber < CANTIDAD_NODOS_ANCHURA - 1; columnNumber++)
            for (int rowNumber = 0 ; rowNumber < CANTIDAD_NODOS_ALTURA ; rowNumber++){
                Casilla newGrid = new Casilla(rowNumber, columnNumber);
                NodoG<Casilla> newNode = new NodoG<>(newGrid);
                if(isAValidNode(newNode)) generatingMap.agregarNodo(newNode);
            }
        flagGoals();
    }
    private void generateArcs(){
        ArrayList<NodoG<Casilla>> nodes = generatingMap.getNodos();
        for (NodoG<Casilla> node : nodes)
            for (NodoG<Casilla> otherNode : nodes){
                if (isAdjacent(node, otherNode)){
                    node.agregarArco(otherNode);
                    otherNode.agregarArco(node);
                    generatingMap.agregarArco(1,node,otherNode);
                }
            }
    }
    private boolean isAdjacent(NodoG<Casilla> pNodeA, NodoG<Casilla> pNodeB){
        boolean adjacent = false;
        if (pNodeA.getElemento().getColumna() == pNodeB.getElemento().getColumna())
            if (pNodeB.getElemento().getFila() == pNodeA.getElemento().getFila() + 1) adjacent = true;

        if (pNodeA.getElemento().getFila() == pNodeB.getElemento().getFila())
            if (pNodeB.getElemento().getColumna() == pNodeA.getElemento().getColumna() + 1) adjacent = true;
        return adjacent;
    }
    private void flagGoals(){
        ArrayList<Casilla> reservedGrids = generateFlagGrids();
        for (Casilla grid : reservedGrids){
            NodoG<Casilla> newNode = new NodoG<>(grid);
            generatingMap.agregarNodo(newNode);
        }

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
        return (isBetween(nodeX1, pObstacle.getX1(), nodeX2) || isBetween(nodeX1, pObstacle.getX2(), nodeX2) ||
                isBetween(pObstacle.getX1(), nodeX1, pObstacle.getX2()) || isBetween(pObstacle.getX1(), nodeX2, pObstacle.getX2()));
    }
    private boolean existsYIntersection(NodoG<Casilla> pNode, Obstaculo pObstacle){
        int nodeY1 = pNode.getElemento().getY1();
        int nodeY2 = pNode.getElemento().getY2();
        return (isBetween(nodeY1, pObstacle.getY1(), nodeY2) || isBetween(nodeY1, pObstacle.getY2(), nodeY2) ||
                isBetween(pObstacle.getY1(), nodeY1, pObstacle.getY2()) || isBetween(pObstacle.getY1(), nodeY2, pObstacle.getY2()));
    }
    private boolean isBetween(int A, int B, int C){
        return (A <= B && B <= C);
    }


    public GrafoND<Casilla> getGeneratingMap() {
        return generatingMap;
    }
}
