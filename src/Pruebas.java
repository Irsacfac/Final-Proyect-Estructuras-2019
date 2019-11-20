import MapHandling.Casilla;
import MapHandling.Mapa;
import estructuras.Arco;
import estructuras.NodoG;
import juego.Jugador;
import juego.PosiblePoints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import static juego.Jugador.PlayerIdentifier.A;
import static juego.PosiblePoints.*;

public class Pruebas {
    public static void main(String[] args) {
        Mapa map = new Mapa("C:\\Users\\jguty\\OneDrive\\Documents\\GitHub\\Final-Proyect-Estructuras-2019\\src\\MapHandling\\Mapas\\Mapa.json");
        Jugador player = new Jugador("Prueba", map.getMapa(), CENTER, A);
        player.getGrupo1().setGoalPoint(TOPCORNER);
        ArrayList<NodoG<Casilla>> path = player.getGrupo1().getPath();
        for (NodoG<Casilla> nodo : path){
            System.out.println(nodo.getElemento().getFila()+"-"+nodo.getElemento().getColumna()+ "\n");
        }
//        for (Arco<Casilla> arco : map.getMapa().getArcos()){
//            System.out.println(arco.getPuntoA().getElemento().getFila() + "," + arco.getPuntoA().getElemento().getColumna() + "//" + arco.getPuntoB().getElemento().getFila() + "," + arco.getPuntoB().getElemento().getColumna());
//        }
    }
}

