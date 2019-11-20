package juego;

import MapHandling.Casilla;
import estructuras.AlgoritmosDeBusqueda.AlgoritmoDeBusqueda;
import estructuras.AlgoritmosDeBusqueda.Subclasses.Dijkstra;
import estructuras.AlgoritmosDeBusqueda.Subclasses.MST;
import estructuras.AlgoritmosDeBusqueda.Subclasses.Warshall;
import estructuras.GrafoND;
import estructuras.NodoG;
import otros.IConstants;

import java.util.ArrayList;

public class Peloton implements IConstants {

    private ArrayList<Character> soldiers;
    private GrafoND<Casilla> map;
    private AlgoritmoDeBusqueda<Casilla> strategy;
    private ArrayList<NodoG<Casilla>> path;

    private NodoG<Casilla> start;
    private NodoG<Casilla> actualPosition;
    private NodoG<Casilla> goal;

    public enum posibleAlgorithms{
        DIJKSTRA,
        MST,
        WARSHALL
    }


    public Peloton(PosiblePoints startPoint, posibleAlgorithms strategy, GrafoND<Casilla> map) {
        this.map = map;
        setStartPoint(startPoint);
        setStrategy(strategy);
        path = this.strategy.getPath(start, goal, map);
        actualPosition = start;
    }

    private void setStrategy(posibleAlgorithms strategy){
        switch (strategy){
            case DIJKSTRA:
                this.strategy = new Dijkstra<>();
                break;
            case MST:
                this.strategy = new MST<>();
            case WARSHALL:
                this.strategy =  new Warshall<>(map, start, goal);
        }
    }


    public void setGoalPoint(PosiblePoints goal) {
        switch (goal){
            case CENTER:
                this.goal = getGoalCenter();
                break;
            case LOWCORNER:
                this.goal = getGoalLowCorner();
                break;
            case TOPCORNER:
                this.goal = getGoalTopCorner();
                break;
        }
    }

    private NodoG<Casilla> getGoalTopCorner() {
        for (NodoG<Casilla> nodo : map.getNodos()){
            if (nodo.getElemento().getFila() == 0)
                if (nodo.getElemento().getColumna() == ULTIMA_COLUMNA) return nodo;
        }
        return null;
    }

    private NodoG<Casilla> getGoalLowCorner() {
        for (NodoG<Casilla> nodo : map.getNodos()){
            if (nodo.getElemento().getFila() == ULTIMA_FILA)
                if (nodo.getElemento().getColumna() == ULTIMA_COLUMNA) return nodo;
        }
        return null;
    }

    private NodoG<Casilla> getGoalCenter() {
        for (NodoG<Casilla> nodo : map.getNodos()){
            if (nodo.getElemento().getFila() == FILA_CENTRAL)
                if (nodo.getElemento().getColumna() == ULTIMA_COLUMNA) return nodo;
        }
        return null;
    }

    private void setStartPoint(PosiblePoints start){
        switch (start){
            case CENTER:
                this.start = getStartCenter();
                break;
            case LOWCORNER:
                this.start = getStartLowCorner();
                break;
            case TOPCORNER:
                this.start = getStartTopCorner();
                break;
        }
    }

    private NodoG<Casilla> getStartCenter() {
        for (NodoG<Casilla> nodo : map.getNodos()){
            if (nodo.getElemento().getFila() == 0)
                if (nodo.getElemento().getColumna() == 0) return nodo;
        }
        return null;
    }

    private NodoG<Casilla> getStartLowCorner() {
        for (NodoG<Casilla> nodo : map.getNodos()){
            if (nodo.getElemento().getFila() == ULTIMA_FILA)
                if (nodo.getElemento().getColumna() == 0) return nodo;
        }
        return null;
    }

    private NodoG<Casilla> getStartTopCorner(){
        for (NodoG<Casilla> nodo : map.getNodos()){
            if (nodo.getElemento().getFila() == FILA_CENTRAL)
                if (nodo.getElemento().getColumna() == 0) return nodo;
        }
        return null;
    }

    public ArrayList<NodoG<Casilla>> getPath() {
        return path;
    }

    public ArrayList<Character> getSoldiers() {
        return soldiers;
    }

    public void setSoldiers(ArrayList<Character> soldiers) {
        this.soldiers = soldiers;
    }

    public AlgoritmoDeBusqueda<Casilla> getStrategy() {
        return strategy;
    }

    public NodoG<Casilla> getStart() {
        return start;
    }

    public NodoG<Casilla> getGoal() {
        return goal;
    }

    public NodoG<Casilla> getActualPosition() {
        return actualPosition;
    }

    public void setActualPosition(NodoG<Casilla> actualPosition) {
        this.actualPosition = actualPosition;
    }
}
