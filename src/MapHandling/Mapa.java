package MapHandling;

import estructuras.GrafoND;

import java.util.ArrayList;

public class Mapa {

    private GrafoND<Casilla> mapa;
    private GeneradorDeMapas generador;

    public Mapa(String jsonMapPath) {
        this.generador = new GeneradorDeMapas(jsonMapPath);
        this.mapa = generador.generateMap();
    }

    public GrafoND<Casilla> getMapa() {
        return mapa;
    }
}
