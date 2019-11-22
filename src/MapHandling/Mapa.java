package MapHandling;

import estructuras.GrafoND;

import java.util.ArrayList;

public class Mapa {

    private GrafoND<Casilla> mapa;
    private ArrayList<Obstaculo> obstaculos;

    public Mapa(String jsonMapPath) {
        GeneradorDeMapas generador = new GeneradorDeMapas(jsonMapPath);
        mapa =  generador.getGeneratingMap();
        obstaculos = generador.getObstacles();
    }

    public GrafoND<Casilla> getMapa() {
        return mapa;
    }

    public ArrayList<Obstaculo> getObstaculos() {
        return obstaculos;
    }

}
