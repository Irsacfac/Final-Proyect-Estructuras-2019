package juego;

import java.util.Vector;

public class Jugador {
	private String nombre;
	private Vector<Character> grupo1;
	private Vector<Character> grupo2;
	private Vector<Character> grupo3;
	
	public Jugador(String pNombre) {
		nombre = pNombre;
		grupo1 = new Vector<>();
		grupo2 = new Vector<>();
		grupo3 = new Vector<>();
	}
	
	
}
