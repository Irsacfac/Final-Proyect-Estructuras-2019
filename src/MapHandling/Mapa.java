package MapHandling;

import estructuras.GrafoND;

import java.util.ArrayList;

public class Mapa {

    private GrafoND<Casilla> mapa;
    private GeneradorDeMapas generador;

    public Mapa(String jsonMapPath) {
        this.generador = new GeneradorDeMapas(jsonMapPath);
        mapa =  generador.getGeneratingMap();
    }

    public GrafoND<Casilla> getMapa() {
        return mapa;
    }
}
