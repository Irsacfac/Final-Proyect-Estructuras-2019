import MapHandling.Casilla;
import MapHandling.Mapa;
import estructuras.Arco;
import estructuras.NodoG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Pruebas {
    public static void main(String[] args) {
        Mapa map = new Mapa("C:\\Users\\jguty\\OneDrive\\Documents\\GitHub\\Final-Proyect-Estructuras-2019\\src\\MapHandling\\Mapas\\mapa2.json");
        for (Arco<Casilla> arco : map.getMapa().getArcos()){
            System.out.println(arco.getPuntoA().getElemento().getFila() + "," + arco.getPuntoA().getElemento().getColumna() + "//" + arco.getPuntoB().getElemento().getFila() + "," + arco.getPuntoB().getElemento().getColumna());
        }
    }
}

