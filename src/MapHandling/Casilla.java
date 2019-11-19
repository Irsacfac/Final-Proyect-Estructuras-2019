package MapHandling;

import estructuras.NodoG;
import otros.IConstants;

import java.util.ArrayList;

public class Casilla implements IConstants {

    private int fila;
    private int columna;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    ArrayList<Character> peloton;

    public Casilla(int fila, int columna) {

        this.fila = fila;
        this.columna = columna;

        x1 = ANCHO_CASILLA * columna;
        y1 = ALTURA_CASILLA * fila;

        x2 = ANCHO_CASILLA * (columna + 1);
        y2 = ALTURA_CASILLA * (fila + 1);

        this.peloton = null;

    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public ArrayList<Character> getPeloton() {
        return peloton;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }
}
