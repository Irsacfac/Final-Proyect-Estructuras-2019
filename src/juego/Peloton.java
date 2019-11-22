package juego;

import MapHandling.Casilla;
import estructuras.AlgoritmosDeBusqueda.AlgoritmoDeBusqueda;
import estructuras.AlgoritmosDeBusqueda.Subclasses.Dijkstra;
import estructuras.AlgoritmosDeBusqueda.Subclasses.MST;
import estructuras.AlgoritmosDeBusqueda.Subclasses.Warshall;
import estructuras.GrafoND;
import estructuras.NodoG;
import juego.Observer.Observer;
import juego.Observer.Subject;
import otros.IConstants;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.plaf.basic.BasicTreeUI.TreeHomeAction;

public class Peloton implements IConstants, Subject {

    private ArrayList<Character> soldiers;
    private GrafoND<Casilla> map;
    private AlgoritmoDeBusqueda<Casilla> strategy;
    private ArrayList<NodoG<Casilla>> path;
    private Runnable movimiento;
    private NodoG<Casilla> start;
    private NodoG<Casilla> actualPosition;
    private NodoG<Casilla> goal;
    private Jugador.PlayerIdentifier playerIdentifier;

    public enum posibleAlgorithms{
        DIJKSTRA,
        MST,
        WARSHALL
    }


    public Peloton(PosiblePoints startPoint,PosiblePoints goalPoint, posibleAlgorithms strategy, GrafoND<Casilla> map, Jugador.PlayerIdentifier pAorB) {
        this.map = map;
        playerIdentifier = pAorB;
        setStartPoint(startPoint);
        setGoalPoint(goalPoint);
        setStrategy(strategy);
        actualPosition = start;

        path = this.strategy.getPath(start, goal, map);
        if (path.get(0) != start) {
            Collections.reverse(path);
        }
        movimiento = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				move();
			}
		};
    }

    protected void move(){
    	//System.out.println("Movimiento");
    	try {
    		actualPosition = path.get(0);
            path.remove(0);
		} catch (Exception e) {
			// TODO: handle exception
			return;
		}
    }


    @Override
    public void detach(Observer observer) {

    }

    @Override
    public void attach(Observer observer) {

    }

    @Override
    public void notifyObservers(Observer observer) {

    }

    private void setStrategy(posibleAlgorithms strategy){
        switch (strategy){
            case DIJKSTRA:
                this.strategy = (AlgoritmoDeBusqueda<Casilla>) new Dijkstra(start, map);
                break;
            case MST:
                this.strategy = (AlgoritmoDeBusqueda<Casilla>) new MST();
                break;
            case WARSHALL:
                this.strategy = (AlgoritmoDeBusqueda<Casilla>) (AlgoritmoDeBusqueda<Casilla>) new MST();
                break;
        }
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


    }

    private NodoG<Casilla> getGoalTopCorner() {
        for (NodoG<Casilla> nodo : map.getNodos()){
            if (playerIdentifier == Jugador.PlayerIdentifier.B)
            {
                if (nodo.getElemento().getFila() == 0)
                    if (nodo.getElemento().getColumna() == 0) return nodo;
            } else {
                if (nodo.getElemento().getFila() == 0)
                    if (nodo.getElemento().getColumna() == ULTIMA_COLUMNA) return nodo;
            }
        }
        return null;
    }
    private NodoG<Casilla> getGoalLowCorner() {
        for (NodoG<Casilla> nodo : map.getNodos()){
            if (playerIdentifier == Jugador.PlayerIdentifier.B) {
                if (nodo.getElemento().getFila() == ULTIMA_FILA)
                    if (nodo.getElemento().getColumna() == 0) return nodo;
            } else {
                if (nodo.getElemento().getFila() == ULTIMA_FILA)
                    if (nodo.getElemento().getColumna() == ULTIMA_COLUMNA) return nodo;
            }
        }
        return null;
    }
    private NodoG<Casilla> getGoalCenter() {
        for (NodoG<Casilla> nodo : map.getNodos()){
            if (playerIdentifier == Jugador.PlayerIdentifier.B) {
                if (nodo.getElemento().getFila() == FILA_CENTRAL)
                    if (nodo.getElemento().getColumna() == 0) return nodo;
            } else {
                if (nodo.getElemento().getFila() == FILA_CENTRAL)
                    if (nodo.getElemento().getColumna() == ULTIMA_COLUMNA) return nodo;
            }
        }
        return null;
    }
    private NodoG<Casilla> getStartTopCorner() {
        for (NodoG<Casilla> nodo : map.getNodos()){
            if (playerIdentifier == Jugador.PlayerIdentifier.A)
            {
                if (nodo.getElemento().getFila() == 0)
                    if (nodo.getElemento().getColumna() == 0) return nodo;
            } else {
                if (nodo.getElemento().getFila() == 0)
                    if (nodo.getElemento().getColumna() == ULTIMA_COLUMNA) return nodo;
            }

        }
        return null;
    }
    private NodoG<Casilla> getStartLowCorner() {
        for (NodoG<Casilla> nodo : map.getNodos()){
            if (playerIdentifier == Jugador.PlayerIdentifier.A) {
                if (nodo.getElemento().getFila() == ULTIMA_FILA)
                    if (nodo.getElemento().getColumna() == 0) return nodo;
            } else {
                if (nodo.getElemento().getFila() == ULTIMA_FILA)
                    if (nodo.getElemento().getColumna() == ULTIMA_COLUMNA) return nodo;
            }
        }
        return null;
    }
    private NodoG<Casilla> getStartCenter(){
        for (NodoG<Casilla> nodo : map.getNodos()){
            if (playerIdentifier == Jugador.PlayerIdentifier.A) {
                if (nodo.getElemento().getFila() == FILA_CENTRAL)
                    if (nodo.getElemento().getColumna() == 0) return nodo;
            } else {
                if (nodo.getElemento().getFila() == FILA_CENTRAL)
                    if (nodo.getElemento().getColumna() == ULTIMA_COLUMNA) return nodo;
            }

        }
        return null;
    }

    public ArrayList<NodoG<Casilla>> getPath() {
        return path;
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

}
