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

import javax.swing.plaf.basic.BasicTreeUI.TreeHomeAction;

public class Peloton implements IConstants {

    private ArrayList<Character> soldiers;
    private GrafoND<Casilla> map;
    private AlgoritmoDeBusqueda<Casilla> strategy;
    private ArrayList<NodoG<Casilla>> path;
    private Runnable movimiento;
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
        actualPosition = start;
    }

    private void setStrategy(posibleAlgorithms strategy){
        switch (strategy){
            case DIJKSTRA:
                this.strategy = (AlgoritmoDeBusqueda<Casilla>) new Dijkstra(start, map);
                break;
            case MST:
                this.strategy = (AlgoritmoDeBusqueda<Casilla>) new MST();
                break;
//            case WARSHALL:
//                Dijkstra dijkstra2 = new Dijkstra(start, map);
//                this.strategy = (AlgoritmoDeBusqueda<Casilla>) dijkstra2;
//                break;
        }
    }


    public void setGoalPoint(PosiblePoints posibleGoalPoint) {
        switch (posibleGoalPoint){
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
        System.out.println(strategy==null);
        path = this.strategy.getPath(start, goal, map);
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

    private NodoG<Casilla> getStartTopCorner() {
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

    private NodoG<Casilla> getStartCenter(){
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
    
    public Runnable getMovimiento() {
    	return movimiento;
    }
    
    private void run() {
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
