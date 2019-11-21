package juego;

import javax.swing.JFrame;

import MapHandling.Mapa;
import gui.Juego;
import otros.IConstants;

public class CaptureFlag implements IConstants {
	private int turnoActual;
	private Jugador[] jugadores;
	private Mapa mapa;
	private Hilos hilos;
	private Juego ventana;
	
	public CaptureFlag(String mapPath, Jugador pJugador1, Jugador pJugador2) {
		jugadores = new Jugador[] {pJugador1, pJugador2};
		mapa = new Mapa(mapPath);
		hilos = new Hilos(CANT_HILOS);
		ventana = new Juego();
	}
	
	public void turno() {
		Jugador jugadorActual = jugadores[turnoActual%2];
		Peloton[] pelotones = jugadorActual.getPelotones();
		for(int numPeloton = 0;numPeloton < pelotones.length; numPeloton++) {
			hilos.ejecutar(pelotones[numPeloton].getMovimiento());
		}
		turnoActual++;
	}
	
}
