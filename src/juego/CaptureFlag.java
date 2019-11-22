package juego;

import static juego.PosiblePoints.CENTER;

import java.util.ArrayList;

import javax.swing.JFrame;

import MapHandling.Casilla;
import MapHandling.Mapa;
import estructuras.NodoG;
import gui.Juego;
import otros.IConstants;

public class CaptureFlag implements IConstants {
	private int turnoActual;
	private Jugador[] jugadores;
	private Mapa mapa;
	private Hilos hilos;
	private Juego ventana;
	private Runnable positionChanger;
	
	public CaptureFlag(String mapPath, Jugador pJugador1, Jugador pJugador2) {
		jugadores = new Jugador[] {pJugador1, pJugador2};
		mapa = new Mapa(mapPath);
		hilos = new Hilos(CANT_HILOS);
		ventana = new Juego(mapa);
		
	}
	
	public void turno() {
		Jugador jugadorActual = jugadores[0];
		Peloton[] pelotones = jugadorActual.getPelotones();
		for(int numPeloton = 0;numPeloton < pelotones.length; numPeloton++) {
			hilos.ejecutar(pelotones[numPeloton].getMovimiento());
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		turnoActual++;
	}


}
