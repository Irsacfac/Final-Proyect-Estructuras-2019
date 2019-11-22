import MapHandling.Casilla;
import MapHandling.Mapa;
import estructuras.Arco;
import estructuras.NodoG;
import gui.Juego;
import gui.LogIn;
import gui.Menu;
import juego.Jugador;
import java.util.ArrayList;


import static juego.Jugador.PlayerIdentifier.A;
import static juego.Jugador.PlayerIdentifier.B;
import static juego.PosiblePoints.*;

public class Pruebas {
    public static void main(String[] args) {
        Mapa map = new Mapa("C:\\Users\\jguty\\OneDrive\\Documents\\GitHub\\Final-Proyect-Estructuras-2019\\src\\MapHandling\\Mapas\\mapa2.json");
        Jugador player1 = new Jugador("Prueba", map.getMapa(), CENTER, A, TOPCORNER, CENTER, TOPCORNER);

        new LogIn();

        ArrayList<NodoG<Casilla>> path1 = player1.getGrupo1().getPath();
        System.out.println("Dijkstra");
        for (NodoG<Casilla> nodo : path1){
            System.out.println(nodo.getElemento().getFila()+"-"+nodo.getElemento().getColumna()+ "\n");
        }

        System.out.println("\n");
        ArrayList<NodoG<Casilla>> path2 = player1.getGrupo2().getPath();
        System.out.println("WARSHALL");
        for (NodoG<Casilla> nodo : path2){
            System.out.println(nodo.getElemento().getFila()+"-"+nodo.getElemento().getColumna()+ "\n");
        }

        System.out.println("\n");
        ArrayList<NodoG<Casilla>> path3 = player1.getGrupo3().getPath();
        System.out.println("MST");
        for (NodoG<Casilla> nodo : path3){
            System.out.println(nodo.getElemento().getFila()+"-"+nodo.getElemento().getColumna()+ "\n");
        }

        new Juego(map);

    }
}

